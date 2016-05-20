package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.AlignMode;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Config;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData;
import com.badlogic.gdx.graphics.g3d.particles.renderers.BillboardControllerRenderData;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import java.util.Iterator;

public class BillboardParticleBatch extends BufferedParticleBatch
{
  private static final VertexAttributes CPU_ATTRIBUTES;
  private static final int CPU_COLOR_OFFSET = 0;
  private static final int CPU_POSITION_OFFSET = 0;
  private static final int CPU_UV_OFFSET = 0;
  private static final int CPU_VERTEX_SIZE = 0;
  private static final VertexAttributes GPU_ATTRIBUTES;
  private static final int GPU_COLOR_OFFSET = 0;
  private static final int GPU_POSITION_OFFSET = 0;
  private static final int GPU_SIZE_ROTATION_OFFSET = 0;
  private static final int GPU_UV_OFFSET = 0;
  private static final int GPU_VERTEX_SIZE = 0;
  private static final int MAX_PARTICLES_PER_MESH = 8191;
  private static final int MAX_VERTICES_PER_MESH = 32764;
  protected static final Matrix3 TMP_M3;
  protected static final Vector3 TMP_V1 = new Vector3();
  protected static final Vector3 TMP_V2 = new Vector3();
  protected static final Vector3 TMP_V3 = new Vector3();
  protected static final Vector3 TMP_V4 = new Vector3();
  protected static final Vector3 TMP_V5 = new Vector3();
  protected static final Vector3 TMP_V6 = new Vector3();
  protected static final int directionUsage = 1024;
  protected static final int sizeAndRotationUsage = 512;
  protected BlendingAttribute blendingAttribute;
  private VertexAttributes currentAttributes;
  private int currentVertexSize = 0;
  protected DepthTestAttribute depthTestAttribute;
  private short[] indices;
  protected ParticleShader.AlignMode mode = ParticleShader.AlignMode.Screen;
  private BillboardParticleBatch.RenderablePool renderablePool = new BillboardParticleBatch.RenderablePool(this);
  private Array renderables = new Array();
  Shader shader;
  protected Texture texture;
  protected boolean useGPU = false;
  private float[] vertices;

  static
  {
    TMP_M3 = new Matrix3();
    VertexAttribute[] arrayOfVertexAttribute1 = new VertexAttribute[4];
    arrayOfVertexAttribute1[0] = new VertexAttribute(1, 3, "a_position");
    arrayOfVertexAttribute1[1] = new VertexAttribute(16, 2, "a_texCoord0");
    arrayOfVertexAttribute1[2] = new VertexAttribute(2, 4, "a_color");
    arrayOfVertexAttribute1[3] = new VertexAttribute(512, 4, "a_sizeAndRotation");
    GPU_ATTRIBUTES = new VertexAttributes(arrayOfVertexAttribute1);
    VertexAttribute[] arrayOfVertexAttribute2 = new VertexAttribute[3];
    arrayOfVertexAttribute2[0] = new VertexAttribute(1, 3, "a_position");
    arrayOfVertexAttribute2[1] = new VertexAttribute(16, 2, "a_texCoord0");
    arrayOfVertexAttribute2[2] = new VertexAttribute(2, 4, "a_color");
    CPU_ATTRIBUTES = new VertexAttributes(arrayOfVertexAttribute2);
    GPU_POSITION_OFFSET = (short)(GPU_ATTRIBUTES.findByUsage(1).offset / 4);
    GPU_UV_OFFSET = (short)(GPU_ATTRIBUTES.findByUsage(16).offset / 4);
    GPU_SIZE_ROTATION_OFFSET = (short)(GPU_ATTRIBUTES.findByUsage(512).offset / 4);
    GPU_COLOR_OFFSET = (short)(GPU_ATTRIBUTES.findByUsage(2).offset / 4);
    GPU_VERTEX_SIZE = GPU_ATTRIBUTES.vertexSize / 4;
    CPU_POSITION_OFFSET = (short)(CPU_ATTRIBUTES.findByUsage(1).offset / 4);
    CPU_UV_OFFSET = (short)(CPU_ATTRIBUTES.findByUsage(16).offset / 4);
    CPU_COLOR_OFFSET = (short)(CPU_ATTRIBUTES.findByUsage(2).offset / 4);
    CPU_VERTEX_SIZE = CPU_ATTRIBUTES.vertexSize / 4;
  }

  public BillboardParticleBatch()
  {
    this(ParticleShader.AlignMode.Screen, false, 100);
  }

  public BillboardParticleBatch(int paramInt)
  {
    this(ParticleShader.AlignMode.Screen, false, paramInt);
  }

  public BillboardParticleBatch(ParticleShader.AlignMode paramAlignMode, boolean paramBoolean, int paramInt)
  {
    this(paramAlignMode, paramBoolean, paramInt, null, null);
  }

  public BillboardParticleBatch(ParticleShader.AlignMode paramAlignMode, boolean paramBoolean, int paramInt, BlendingAttribute paramBlendingAttribute, DepthTestAttribute paramDepthTestAttribute)
  {
    super(BillboardControllerRenderData.class);
    this.blendingAttribute = paramBlendingAttribute;
    this.depthTestAttribute = paramDepthTestAttribute;
    if (this.blendingAttribute == null)
      this.blendingAttribute = new BlendingAttribute(1, 771, 1.0F);
    if (this.depthTestAttribute == null)
      this.depthTestAttribute = new DepthTestAttribute(515, false);
    allocIndices();
    initRenderData();
    ensureCapacity(paramInt);
    setUseGpu(paramBoolean);
    setAlignMode(paramAlignMode);
  }

  private void allocIndices()
  {
    int i = 0;
    this.indices = new short[49146];
    int j = 0;
    while (j < 49146)
    {
      this.indices[j] = (short)i;
      this.indices[(j + 1)] = (short)(i + 1);
      this.indices[(j + 2)] = (short)(i + 2);
      this.indices[(j + 3)] = (short)(i + 2);
      this.indices[(j + 4)] = (short)(i + 3);
      this.indices[(j + 5)] = (short)i;
      j += 6;
      i += 4;
    }
  }

  private void allocRenderables(int paramInt)
  {
    int i = MathUtils.ceil(paramInt / 8191);
    int j = this.renderablePool.getFree();
    if (j < i)
    {
      int k = 0;
      int m = i - j;
      while (k < m)
      {
        this.renderablePool.free(this.renderablePool.newObject());
        k++;
      }
    }
  }

  private void allocShader()
  {
    Renderable localRenderable = allocRenderable();
    Shader localShader = getShader(localRenderable);
    localRenderable.shader = localShader;
    this.shader = localShader;
    this.renderablePool.free(localRenderable);
  }

  private void clearRenderablesPool()
  {
    this.renderablePool.freeAll(this.renderables);
    int i = this.renderablePool.getFree();
    for (int j = 0; j < i; j++)
      ((Renderable)this.renderablePool.obtain()).meshPart.mesh.dispose();
    this.renderables.clear();
  }

  private void fillVerticesGPU(int[] paramArrayOfInt)
  {
    Iterator localIterator = this.renderData.iterator();
    int m;
    for (int i = 0; localIterator.hasNext(); i = m)
    {
      BillboardControllerRenderData localBillboardControllerRenderData = (BillboardControllerRenderData)localIterator.next();
      ParallelArray.FloatChannel localFloatChannel1 = localBillboardControllerRenderData.scaleChannel;
      ParallelArray.FloatChannel localFloatChannel2 = localBillboardControllerRenderData.regionChannel;
      ParallelArray.FloatChannel localFloatChannel3 = localBillboardControllerRenderData.positionChannel;
      ParallelArray.FloatChannel localFloatChannel4 = localBillboardControllerRenderData.colorChannel;
      ParallelArray.FloatChannel localFloatChannel5 = localBillboardControllerRenderData.rotationChannel;
      int j = localBillboardControllerRenderData.controller.particles.size;
      int k = 0;
      m = i;
      while (k < j)
      {
        int n = paramArrayOfInt[m] * this.currentVertexSize << 2;
        float f1 = localFloatChannel1.data[(k * localFloatChannel1.strideSize)];
        int i1 = k * localFloatChannel2.strideSize;
        int i2 = k * localFloatChannel3.strideSize;
        int i3 = k * localFloatChannel4.strideSize;
        int i4 = k * localFloatChannel5.strideSize;
        float f2 = localFloatChannel3.data[i2];
        float f3 = localFloatChannel3.data[(i2 + 1)];
        float f4 = localFloatChannel3.data[(i2 + 2)];
        float f5 = localFloatChannel2.data[i1];
        float f6 = localFloatChannel2.data[(i1 + 1)];
        float f7 = localFloatChannel2.data[(i1 + 2)];
        float f8 = localFloatChannel2.data[(i1 + 3)];
        float f9 = f1 * localFloatChannel2.data[(i1 + 4)];
        float f10 = f1 * localFloatChannel2.data[(i1 + 5)];
        float f11 = localFloatChannel4.data[i3];
        float f12 = localFloatChannel4.data[(i3 + 1)];
        float f13 = localFloatChannel4.data[(i3 + 2)];
        float f14 = localFloatChannel4.data[(i3 + 3)];
        float f15 = localFloatChannel5.data[i4];
        float f16 = localFloatChannel5.data[(i4 + 1)];
        putVertex(this.vertices, n, f2, f3, f4, f5, f8, -f9, -f10, f15, f16, f11, f12, f13, f14);
        int i5 = n + this.currentVertexSize;
        putVertex(this.vertices, i5, f2, f3, f4, f7, f8, f9, -f10, f15, f16, f11, f12, f13, f14);
        int i6 = i5 + this.currentVertexSize;
        putVertex(this.vertices, i6, f2, f3, f4, f7, f6, f9, f10, f15, f16, f11, f12, f13, f14);
        int i7 = i6 + this.currentVertexSize;
        putVertex(this.vertices, i7, f2, f3, f4, f5, f6, -f9, f10, f15, f16, f11, f12, f13, f14);
        int i8 = k + 1;
        m++;
        k = i8;
      }
    }
  }

  private void fillVerticesToScreenCPU(int[] paramArrayOfInt)
  {
    Vector3 localVector31 = TMP_V3.set(this.camera.direction).scl(-1.0F);
    Vector3 localVector32 = TMP_V4.set(this.camera.up).crs(localVector31).nor();
    Vector3 localVector33 = this.camera.up;
    Iterator localIterator = this.renderData.iterator();
    int m;
    for (int i = 0; localIterator.hasNext(); i = m)
    {
      BillboardControllerRenderData localBillboardControllerRenderData = (BillboardControllerRenderData)localIterator.next();
      ParallelArray.FloatChannel localFloatChannel1 = localBillboardControllerRenderData.scaleChannel;
      ParallelArray.FloatChannel localFloatChannel2 = localBillboardControllerRenderData.regionChannel;
      ParallelArray.FloatChannel localFloatChannel3 = localBillboardControllerRenderData.positionChannel;
      ParallelArray.FloatChannel localFloatChannel4 = localBillboardControllerRenderData.colorChannel;
      ParallelArray.FloatChannel localFloatChannel5 = localBillboardControllerRenderData.rotationChannel;
      int j = localBillboardControllerRenderData.controller.particles.size;
      int k = 0;
      m = i;
      if (k >= j)
        continue;
      int n = paramArrayOfInt[m] * this.currentVertexSize << 2;
      float f1 = localFloatChannel1.data[(k * localFloatChannel1.strideSize)];
      int i1 = k * localFloatChannel2.strideSize;
      int i2 = k * localFloatChannel3.strideSize;
      int i3 = k * localFloatChannel4.strideSize;
      int i4 = k * localFloatChannel5.strideSize;
      float f2 = localFloatChannel3.data[i2];
      float f3 = localFloatChannel3.data[(i2 + 1)];
      float f4 = localFloatChannel3.data[(i2 + 2)];
      float f5 = localFloatChannel2.data[i1];
      float f6 = localFloatChannel2.data[(i1 + 1)];
      float f7 = localFloatChannel2.data[(i1 + 2)];
      float f8 = localFloatChannel2.data[(i1 + 3)];
      float f9 = f1 * localFloatChannel2.data[(i1 + 4)];
      float f10 = f1 * localFloatChannel2.data[(i1 + 5)];
      float f11 = localFloatChannel4.data[i3];
      float f12 = localFloatChannel4.data[(i3 + 1)];
      float f13 = localFloatChannel4.data[(i3 + 2)];
      float f14 = localFloatChannel4.data[(i3 + 3)];
      float f15 = localFloatChannel5.data[i4];
      float f16 = localFloatChannel5.data[(i4 + 1)];
      TMP_V1.set(localVector32).scl(f9);
      TMP_V2.set(localVector33).scl(f10);
      if (f15 != 1.0F)
      {
        TMP_M3.setToRotation(localVector31, f15, f16);
        putVertex(this.vertices, n, TMP_V6.set(-TMP_V1.x - TMP_V2.x, -TMP_V1.y - TMP_V2.y, -TMP_V1.z - TMP_V2.z).mul(TMP_M3).add(f2, f3, f4), f5, f8, f11, f12, f13, f14);
        int i9 = n + this.currentVertexSize;
        putVertex(this.vertices, i9, TMP_V6.set(TMP_V1.x - TMP_V2.x, TMP_V1.y - TMP_V2.y, TMP_V1.z - TMP_V2.z).mul(TMP_M3).add(f2, f3, f4), f7, f8, f11, f12, f13, f14);
        int i10 = i9 + this.currentVertexSize;
        putVertex(this.vertices, i10, TMP_V6.set(TMP_V1.x + TMP_V2.x, TMP_V1.y + TMP_V2.y, TMP_V1.z + TMP_V2.z).mul(TMP_M3).add(f2, f3, f4), f7, f6, f11, f12, f13, f14);
        int i11 = i10 + this.currentVertexSize;
        putVertex(this.vertices, i11, TMP_V6.set(-TMP_V1.x + TMP_V2.x, -TMP_V1.y + TMP_V2.y, -TMP_V1.z + TMP_V2.z).mul(TMP_M3).add(f2, f3, f4), f5, f6, f11, f12, f13, f14);
      }
      while (true)
      {
        int i8 = k + 1;
        m++;
        k = i8;
        break;
        putVertex(this.vertices, n, TMP_V6.set(f2 + (-TMP_V1.x - TMP_V2.x), f3 + (-TMP_V1.y - TMP_V2.y), f4 + (-TMP_V1.z - TMP_V2.z)), f5, f8, f11, f12, f13, f14);
        int i5 = n + this.currentVertexSize;
        putVertex(this.vertices, i5, TMP_V6.set(f2 + (TMP_V1.x - TMP_V2.x), f3 + (TMP_V1.y - TMP_V2.y), f4 + (TMP_V1.z - TMP_V2.z)), f7, f8, f11, f12, f13, f14);
        int i6 = i5 + this.currentVertexSize;
        putVertex(this.vertices, i6, TMP_V6.set(f2 + (TMP_V1.x + TMP_V2.x), f3 + (TMP_V1.y + TMP_V2.y), f4 + (TMP_V1.z + TMP_V2.z)), f7, f6, f11, f12, f13, f14);
        int i7 = i6 + this.currentVertexSize;
        putVertex(this.vertices, i7, TMP_V6.set(f2 + (-TMP_V1.x + TMP_V2.x), f3 + (-TMP_V1.y + TMP_V2.y), f4 + (-TMP_V1.z + TMP_V2.z)), f5, f6, f11, f12, f13, f14);
      }
    }
  }

  private void fillVerticesToViewPointCPU(int[] paramArrayOfInt)
  {
    Iterator localIterator = this.renderData.iterator();
    int m;
    for (int i = 0; localIterator.hasNext(); i = m)
    {
      BillboardControllerRenderData localBillboardControllerRenderData = (BillboardControllerRenderData)localIterator.next();
      ParallelArray.FloatChannel localFloatChannel1 = localBillboardControllerRenderData.scaleChannel;
      ParallelArray.FloatChannel localFloatChannel2 = localBillboardControllerRenderData.regionChannel;
      ParallelArray.FloatChannel localFloatChannel3 = localBillboardControllerRenderData.positionChannel;
      ParallelArray.FloatChannel localFloatChannel4 = localBillboardControllerRenderData.colorChannel;
      ParallelArray.FloatChannel localFloatChannel5 = localBillboardControllerRenderData.rotationChannel;
      int j = localBillboardControllerRenderData.controller.particles.size;
      int k = 0;
      m = i;
      if (k >= j)
        continue;
      int n = paramArrayOfInt[m] * this.currentVertexSize << 2;
      float f1 = localFloatChannel1.data[(k * localFloatChannel1.strideSize)];
      int i1 = k * localFloatChannel2.strideSize;
      int i2 = k * localFloatChannel3.strideSize;
      int i3 = k * localFloatChannel4.strideSize;
      int i4 = k * localFloatChannel5.strideSize;
      float f2 = localFloatChannel3.data[i2];
      float f3 = localFloatChannel3.data[(i2 + 1)];
      float f4 = localFloatChannel3.data[(i2 + 2)];
      float f5 = localFloatChannel2.data[i1];
      float f6 = localFloatChannel2.data[(i1 + 1)];
      float f7 = localFloatChannel2.data[(i1 + 2)];
      float f8 = localFloatChannel2.data[(i1 + 3)];
      float f9 = f1 * localFloatChannel2.data[(i1 + 4)];
      float f10 = f1 * localFloatChannel2.data[(i1 + 5)];
      float f11 = localFloatChannel4.data[i3];
      float f12 = localFloatChannel4.data[(i3 + 1)];
      float f13 = localFloatChannel4.data[(i3 + 2)];
      float f14 = localFloatChannel4.data[(i3 + 3)];
      float f15 = localFloatChannel5.data[i4];
      float f16 = localFloatChannel5.data[(i4 + 1)];
      Vector3 localVector31 = TMP_V3.set(this.camera.position).sub(f2, f3, f4).nor();
      Vector3 localVector32 = TMP_V1.set(this.camera.up).crs(localVector31).nor();
      Vector3 localVector33 = TMP_V2.set(localVector31).crs(localVector32);
      localVector32.scl(f9);
      localVector33.scl(f10);
      if (f15 != 1.0F)
      {
        TMP_M3.setToRotation(localVector31, f15, f16);
        putVertex(this.vertices, n, TMP_V6.set(-TMP_V1.x - TMP_V2.x, -TMP_V1.y - TMP_V2.y, -TMP_V1.z - TMP_V2.z).mul(TMP_M3).add(f2, f3, f4), f5, f8, f11, f12, f13, f14);
        int i9 = n + this.currentVertexSize;
        putVertex(this.vertices, i9, TMP_V6.set(TMP_V1.x - TMP_V2.x, TMP_V1.y - TMP_V2.y, TMP_V1.z - TMP_V2.z).mul(TMP_M3).add(f2, f3, f4), f7, f8, f11, f12, f13, f14);
        int i10 = i9 + this.currentVertexSize;
        putVertex(this.vertices, i10, TMP_V6.set(TMP_V1.x + TMP_V2.x, TMP_V1.y + TMP_V2.y, TMP_V1.z + TMP_V2.z).mul(TMP_M3).add(f2, f3, f4), f7, f6, f11, f12, f13, f14);
        int i11 = i10 + this.currentVertexSize;
        putVertex(this.vertices, i11, TMP_V6.set(-TMP_V1.x + TMP_V2.x, -TMP_V1.y + TMP_V2.y, -TMP_V1.z + TMP_V2.z).mul(TMP_M3).add(f2, f3, f4), f5, f6, f11, f12, f13, f14);
      }
      while (true)
      {
        int i8 = k + 1;
        m++;
        k = i8;
        break;
        putVertex(this.vertices, n, TMP_V6.set(f2 + (-TMP_V1.x - TMP_V2.x), f3 + (-TMP_V1.y - TMP_V2.y), f4 + (-TMP_V1.z - TMP_V2.z)), f5, f8, f11, f12, f13, f14);
        int i5 = n + this.currentVertexSize;
        putVertex(this.vertices, i5, TMP_V6.set(f2 + (TMP_V1.x - TMP_V2.x), f3 + (TMP_V1.y - TMP_V2.y), f4 + (TMP_V1.z - TMP_V2.z)), f7, f8, f11, f12, f13, f14);
        int i6 = i5 + this.currentVertexSize;
        putVertex(this.vertices, i6, TMP_V6.set(f2 + (TMP_V1.x + TMP_V2.x), f3 + (TMP_V1.y + TMP_V2.y), f4 + (TMP_V1.z + TMP_V2.z)), f7, f6, f11, f12, f13, f14);
        int i7 = i6 + this.currentVertexSize;
        putVertex(this.vertices, i7, TMP_V6.set(f2 + (-TMP_V1.x + TMP_V2.x), f3 + (-TMP_V1.y + TMP_V2.y), f4 + (-TMP_V1.z + TMP_V2.z)), f5, f6, f11, f12, f13, f14);
      }
    }
  }

  private Shader getShader(Renderable paramRenderable)
  {
    if (this.useGPU);
    for (Object localObject = new ParticleShader(paramRenderable, new ParticleShader.Config(this.mode)); ; localObject = new DefaultShader(paramRenderable))
    {
      ((Shader)localObject).init();
      return localObject;
    }
  }

  private void initRenderData()
  {
    setVertexData();
    clearRenderablesPool();
    allocShader();
    resetCapacity();
  }

  private static void putVertex(float[] paramArrayOfFloat, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13)
  {
    paramArrayOfFloat[(paramInt + GPU_POSITION_OFFSET)] = paramFloat1;
    paramArrayOfFloat[(1 + (paramInt + GPU_POSITION_OFFSET))] = paramFloat2;
    paramArrayOfFloat[(2 + (paramInt + GPU_POSITION_OFFSET))] = paramFloat3;
    paramArrayOfFloat[(paramInt + GPU_UV_OFFSET)] = paramFloat4;
    paramArrayOfFloat[(1 + (paramInt + GPU_UV_OFFSET))] = paramFloat5;
    paramArrayOfFloat[(paramInt + GPU_SIZE_ROTATION_OFFSET)] = paramFloat6;
    paramArrayOfFloat[(1 + (paramInt + GPU_SIZE_ROTATION_OFFSET))] = paramFloat7;
    paramArrayOfFloat[(2 + (paramInt + GPU_SIZE_ROTATION_OFFSET))] = paramFloat8;
    paramArrayOfFloat[(3 + (paramInt + GPU_SIZE_ROTATION_OFFSET))] = paramFloat9;
    paramArrayOfFloat[(paramInt + GPU_COLOR_OFFSET)] = paramFloat10;
    paramArrayOfFloat[(1 + (paramInt + GPU_COLOR_OFFSET))] = paramFloat11;
    paramArrayOfFloat[(2 + (paramInt + GPU_COLOR_OFFSET))] = paramFloat12;
    paramArrayOfFloat[(3 + (paramInt + GPU_COLOR_OFFSET))] = paramFloat13;
  }

  private static void putVertex(float[] paramArrayOfFloat, int paramInt, Vector3 paramVector3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    paramArrayOfFloat[(paramInt + CPU_POSITION_OFFSET)] = paramVector3.x;
    paramArrayOfFloat[(1 + (paramInt + CPU_POSITION_OFFSET))] = paramVector3.y;
    paramArrayOfFloat[(2 + (paramInt + CPU_POSITION_OFFSET))] = paramVector3.z;
    paramArrayOfFloat[(paramInt + CPU_UV_OFFSET)] = paramFloat1;
    paramArrayOfFloat[(1 + (paramInt + CPU_UV_OFFSET))] = paramFloat2;
    paramArrayOfFloat[(paramInt + CPU_COLOR_OFFSET)] = paramFloat3;
    paramArrayOfFloat[(1 + (paramInt + CPU_COLOR_OFFSET))] = paramFloat4;
    paramArrayOfFloat[(2 + (paramInt + CPU_COLOR_OFFSET))] = paramFloat5;
    paramArrayOfFloat[(3 + (paramInt + CPU_COLOR_OFFSET))] = paramFloat6;
  }

  public void allocParticlesData(int paramInt)
  {
    this.vertices = new float[paramInt * (this.currentVertexSize << 2)];
    allocRenderables(paramInt);
  }

  protected Renderable allocRenderable()
  {
    Renderable localRenderable = new Renderable();
    localRenderable.meshPart.primitiveType = 4;
    localRenderable.meshPart.offset = 0;
    Attribute[] arrayOfAttribute = new Attribute[3];
    arrayOfAttribute[0] = this.blendingAttribute;
    arrayOfAttribute[1] = this.depthTestAttribute;
    arrayOfAttribute[2] = TextureAttribute.createDiffuse(this.texture);
    localRenderable.material = new Material(arrayOfAttribute);
    localRenderable.meshPart.mesh = new Mesh(false, 32764, 49146, this.currentAttributes);
    localRenderable.meshPart.mesh.setIndices(this.indices);
    localRenderable.shader = this.shader;
    return localRenderable;
  }

  public void begin()
  {
    super.begin();
    this.renderablePool.freeAll(this.renderables);
    this.renderables.clear();
  }

  protected void flush(int[] paramArrayOfInt)
  {
    if (this.useGPU)
      fillVerticesGPU(paramArrayOfInt);
    while (true)
    {
      int i = this.bufferedParticlesCount << 2;
      int j = 0;
      while (j < i)
      {
        int k = Math.min(i - j, 32764);
        Renderable localRenderable = (Renderable)this.renderablePool.obtain();
        localRenderable.meshPart.size = (6 * (k / 4));
        localRenderable.meshPart.mesh.setVertices(this.vertices, j * this.currentVertexSize, k * this.currentVertexSize);
        localRenderable.meshPart.update();
        this.renderables.add(localRenderable);
        j += k;
      }
      if (this.mode == ParticleShader.AlignMode.Screen)
      {
        fillVerticesToScreenCPU(paramArrayOfInt);
        continue;
      }
      if (this.mode != ParticleShader.AlignMode.ViewPoint)
        continue;
      fillVerticesToViewPointCPU(paramArrayOfInt);
    }
  }

  public ParticleShader.AlignMode getAlignMode()
  {
    return this.mode;
  }

  public void getRenderables(Array paramArray, Pool paramPool)
  {
    Iterator localIterator = this.renderables.iterator();
    while (localIterator.hasNext())
    {
      Renderable localRenderable = (Renderable)localIterator.next();
      paramArray.add(((Renderable)paramPool.obtain()).set(localRenderable));
    }
  }

  public Texture getTexture()
  {
    return this.texture;
  }

  public boolean isUseGPU()
  {
    return this.useGPU;
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    ResourceData.SaveData localSaveData = paramResourceData.getSaveData("billboardBatch");
    if (localSaveData != null)
    {
      setTexture((Texture)paramAssetManager.get(localSaveData.loadAsset()));
      BillboardParticleBatch.Config localConfig = (BillboardParticleBatch.Config)localSaveData.load("cfg");
      setUseGpu(localConfig.useGPU);
      setAlignMode(localConfig.mode);
    }
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    ResourceData.SaveData localSaveData = paramResourceData.createSaveData("billboardBatch");
    localSaveData.save("cfg", new BillboardParticleBatch.Config(this.useGPU, this.mode));
    localSaveData.saveAsset(paramAssetManager.getAssetFileName(this.texture), Texture.class);
  }

  public void setAlignMode(ParticleShader.AlignMode paramAlignMode)
  {
    if (paramAlignMode != this.mode)
    {
      this.mode = paramAlignMode;
      if (this.useGPU)
      {
        initRenderData();
        allocRenderables(this.bufferedParticlesCount);
      }
    }
  }

  public void setTexture(Texture paramTexture)
  {
    this.renderablePool.freeAll(this.renderables);
    this.renderables.clear();
    int i = this.renderablePool.getFree();
    for (int j = 0; j < i; j++)
      ((TextureAttribute)((Renderable)this.renderablePool.obtain()).material.get(TextureAttribute.Diffuse)).textureDescription.texture = paramTexture;
    this.texture = paramTexture;
  }

  public void setUseGpu(boolean paramBoolean)
  {
    if (this.useGPU != paramBoolean)
    {
      this.useGPU = paramBoolean;
      initRenderData();
      allocRenderables(this.bufferedParticlesCount);
    }
  }

  public void setVertexData()
  {
    if (this.useGPU)
    {
      this.currentAttributes = GPU_ATTRIBUTES;
      this.currentVertexSize = GPU_VERTEX_SIZE;
      return;
    }
    this.currentAttributes = CPU_ATTRIBUTES;
    this.currentVertexSize = CPU_VERTEX_SIZE;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch
 * JD-Core Version:    0.6.0
 */