package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntIntMap;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.ShortArray;
import java.util.Iterator;

public class MeshBuilder
  implements MeshPartBuilder
{
  private static IntIntMap indicesMap;
  private static final Array matrices4Array;
  private static final Pool matrices4Pool;
  private static final ShortArray tmpIndices = new ShortArray();
  private static final FloatArray tmpVertices = new FloatArray();
  private static final Vector3 vTmp;
  private static final Array vectorArray;
  private static final Pool vectorPool = new MeshBuilder.1();
  private VertexAttributes attributes;
  private final BoundingBox bounds = new BoundingBox();
  private int colOffset;
  private int colSize;
  private final Color color = new Color(Color.WHITE);
  private int cpOffset;
  private boolean hasColor = false;
  private boolean hasUVTransform = false;
  private ShortArray indices = new ShortArray();
  private int istart;
  private short lastIndex = -1;
  private final Matrix4 matTmp1 = new Matrix4();
  private int norOffset;
  private final Matrix3 normalTransform = new Matrix3();
  private MeshPart part;
  private Array parts = new Array();
  private int posOffset;
  private int posSize;
  private final Matrix4 positionTransform = new Matrix4();
  private int primitiveType;
  private int stride;
  private final Color tempC1 = new Color();
  private final Vector3 tempV1 = new Vector3();
  private final Vector3 tempV2 = new Vector3();
  private final Vector3 tempV3 = new Vector3();
  private final Vector3 tempV4 = new Vector3();
  private final Vector3 tempV5 = new Vector3();
  private final Vector3 tempV6 = new Vector3();
  private final Vector3 tempV7 = new Vector3();
  private final Vector3 tempV8 = new Vector3();
  private final Vector3 tmpNormal = new Vector3();
  private float uOffset = 0.0F;
  private float uScale = 1.0F;
  private int uvOffset;
  private float vOffset = 0.0F;
  private float vScale = 1.0F;
  private final MeshPartBuilder.VertexInfo vertTmp1 = new MeshPartBuilder.VertexInfo();
  private final MeshPartBuilder.VertexInfo vertTmp2 = new MeshPartBuilder.VertexInfo();
  private final MeshPartBuilder.VertexInfo vertTmp3 = new MeshPartBuilder.VertexInfo();
  private final MeshPartBuilder.VertexInfo vertTmp4 = new MeshPartBuilder.VertexInfo();
  private final MeshPartBuilder.VertexInfo vertTmp5 = new MeshPartBuilder.VertexInfo();
  private final MeshPartBuilder.VertexInfo vertTmp6 = new MeshPartBuilder.VertexInfo();
  private final MeshPartBuilder.VertexInfo vertTmp7 = new MeshPartBuilder.VertexInfo();
  private final MeshPartBuilder.VertexInfo vertTmp8 = new MeshPartBuilder.VertexInfo();
  private float[] vertex;
  private boolean vertexTransformationEnabled = false;
  private FloatArray vertices = new FloatArray();
  private short vindex;

  static
  {
    vectorArray = new Array();
    matrices4Pool = new MeshBuilder.2();
    matrices4Array = new Array();
    vTmp = new Vector3();
    indicesMap = null;
  }

  private void addMesh(float[] paramArrayOfFloat, short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (indicesMap == null)
    {
      indicesMap = new IntIntMap(paramInt2);
      ensureIndices(paramInt2);
      if (paramArrayOfFloat.length >= paramInt2)
        break label135;
    }
    label135: for (int i = paramArrayOfFloat.length; ; i = paramInt2)
    {
      ensureVertices(i);
      for (int j = 0; j < paramInt2; j++)
      {
        int k = paramArrayOfShort[j];
        int m = indicesMap.get(k, -1);
        if (m < 0)
        {
          addVertex(paramArrayOfFloat, k * this.stride);
          IntIntMap localIntIntMap = indicesMap;
          m = this.lastIndex;
          localIntIntMap.put(k, m);
        }
        index((short)m);
      }
      indicesMap.clear();
      indicesMap.ensureCapacity(paramInt2);
      break;
    }
  }

  private final void addVertex(float[] paramArrayOfFloat, int paramInt)
  {
    int i = this.vertices.size;
    this.vertices.addAll(paramArrayOfFloat, paramInt, this.stride);
    short s = this.vindex;
    this.vindex = (short)(s + 1);
    this.lastIndex = s;
    if (this.vertexTransformationEnabled)
    {
      transformPosition(this.vertices.items, i + this.posOffset, this.posSize, this.positionTransform);
      if (this.norOffset >= 0)
        transformNormal(this.vertices.items, i + this.norOffset, 3, this.normalTransform);
    }
    float f1 = this.vertices.items[(i + this.posOffset)];
    float f2;
    if (this.posSize > 1)
    {
      f2 = this.vertices.items[(1 + (i + this.posOffset))];
      int j = this.posSize;
      float f3 = 0.0F;
      if (j > 2)
        f3 = this.vertices.items[(2 + (i + this.posOffset))];
      this.bounds.ext(f1, f2, f3);
      if (this.hasColor)
      {
        if (this.colOffset < 0)
          break label459;
        float[] arrayOfFloat1 = this.vertices.items;
        int k = i + this.colOffset;
        arrayOfFloat1[k] *= this.color.r;
        float[] arrayOfFloat2 = this.vertices.items;
        int m = 1 + (i + this.colOffset);
        arrayOfFloat2[m] *= this.color.g;
        float[] arrayOfFloat3 = this.vertices.items;
        int n = 2 + (i + this.colOffset);
        arrayOfFloat3[n] *= this.color.b;
        if (this.colSize > 3)
        {
          float[] arrayOfFloat4 = this.vertices.items;
          int i1 = 3 + (i + this.colOffset);
          arrayOfFloat4[i1] *= this.color.a;
        }
      }
    }
    while (true)
    {
      if ((this.hasUVTransform) && (this.uvOffset >= 0))
      {
        this.vertices.items[(i + this.uvOffset)] = (this.uOffset + this.uScale * this.vertices.items[(i + this.uvOffset)]);
        this.vertices.items[(1 + (i + this.uvOffset))] = (this.vOffset + this.vScale * this.vertices.items[(1 + (i + this.uvOffset))]);
      }
      return;
      f2 = 0.0F;
      break;
      label459: if (this.cpOffset < 0)
        continue;
      this.vertices.items[(i + this.cpOffset)] = this.tempC1.set(NumberUtils.floatToIntColor(this.vertices.items[(i + this.cpOffset)])).mul(this.color).toFloatBits();
    }
  }

  private void cleanup()
  {
    vectorPool.freeAll(vectorArray);
    vectorArray.clear();
    matrices4Pool.freeAll(matrices4Array);
    matrices4Array.clear();
  }

  public static VertexAttributes createAttributes(long paramLong)
  {
    Array localArray = new Array();
    if ((paramLong & 1L) == 1L)
      localArray.add(new VertexAttribute(1, 3, "a_position"));
    if ((paramLong & 0x2) == 2L)
      localArray.add(new VertexAttribute(2, 4, "a_color"));
    if ((0x4 & paramLong) == 4L)
      localArray.add(new VertexAttribute(4, 4, "a_color"));
    if ((0x8 & paramLong) == 8L)
      localArray.add(new VertexAttribute(8, 3, "a_normal"));
    if ((0x10 & paramLong) == 16L)
      localArray.add(new VertexAttribute(16, 2, "a_texCoord0"));
    VertexAttribute[] arrayOfVertexAttribute = new VertexAttribute[localArray.size];
    for (int i = 0; i < arrayOfVertexAttribute.length; i++)
      arrayOfVertexAttribute[i] = ((VertexAttribute)localArray.get(i));
    return new VertexAttributes(arrayOfVertexAttribute);
  }

  private void endpart()
  {
    if (this.part != null)
    {
      this.bounds.getCenter(this.part.center);
      this.bounds.getDimensions(this.part.halfExtents).scl(0.5F);
      this.part.radius = this.part.halfExtents.len();
      this.bounds.inf();
      this.part.offset = this.istart;
      this.part.size = (this.indices.size - this.istart);
      this.istart = this.indices.size;
      this.part = null;
    }
  }

  private Matrix4 tmp()
  {
    Matrix4 localMatrix4 = ((Matrix4)matrices4Pool.obtain()).idt();
    matrices4Array.add(localMatrix4);
    return localMatrix4;
  }

  private Matrix4 tmp(Matrix4 paramMatrix4)
  {
    return tmp().set(paramMatrix4);
  }

  private Vector3 tmp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Vector3 localVector3 = ((Vector3)vectorPool.obtain()).set(paramFloat1, paramFloat2, paramFloat3);
    vectorArray.add(localVector3);
    return localVector3;
  }

  private Vector3 tmp(Vector3 paramVector3)
  {
    return tmp(paramVector3.x, paramVector3.y, paramVector3.z);
  }

  private static final void transformNormal(float[] paramArrayOfFloat, int paramInt1, int paramInt2, Matrix3 paramMatrix3)
  {
    if (paramInt2 > 2)
    {
      vTmp.set(paramArrayOfFloat[paramInt1], paramArrayOfFloat[(paramInt1 + 1)], paramArrayOfFloat[(paramInt1 + 2)]).mul(paramMatrix3).nor();
      paramArrayOfFloat[paramInt1] = vTmp.x;
      paramArrayOfFloat[(paramInt1 + 1)] = vTmp.y;
      paramArrayOfFloat[(paramInt1 + 2)] = vTmp.z;
      return;
    }
    if (paramInt2 > 1)
    {
      vTmp.set(paramArrayOfFloat[paramInt1], paramArrayOfFloat[(paramInt1 + 1)], 0.0F).mul(paramMatrix3).nor();
      paramArrayOfFloat[paramInt1] = vTmp.x;
      paramArrayOfFloat[(paramInt1 + 1)] = vTmp.y;
      return;
    }
    paramArrayOfFloat[paramInt1] = vTmp.set(paramArrayOfFloat[paramInt1], 0.0F, 0.0F).mul(paramMatrix3).nor().x;
  }

  private static final void transformPosition(float[] paramArrayOfFloat, int paramInt1, int paramInt2, Matrix4 paramMatrix4)
  {
    if (paramInt2 > 2)
    {
      vTmp.set(paramArrayOfFloat[paramInt1], paramArrayOfFloat[(paramInt1 + 1)], paramArrayOfFloat[(paramInt1 + 2)]).mul(paramMatrix4);
      paramArrayOfFloat[paramInt1] = vTmp.x;
      paramArrayOfFloat[(paramInt1 + 1)] = vTmp.y;
      paramArrayOfFloat[(paramInt1 + 2)] = vTmp.z;
      return;
    }
    if (paramInt2 > 1)
    {
      vTmp.set(paramArrayOfFloat[paramInt1], paramArrayOfFloat[(paramInt1 + 1)], 0.0F).mul(paramMatrix4);
      paramArrayOfFloat[paramInt1] = vTmp.x;
      paramArrayOfFloat[(paramInt1 + 1)] = vTmp.y;
      return;
    }
    paramArrayOfFloat[paramInt1] = vTmp.set(paramArrayOfFloat[paramInt1], 0.0F, 0.0F).mul(paramMatrix4).x;
  }

  public void addMesh(Mesh paramMesh)
  {
    addMesh(paramMesh, 0, paramMesh.getNumIndices());
  }

  public void addMesh(Mesh paramMesh, int paramInt1, int paramInt2)
  {
    if (!this.attributes.equals(paramMesh.getVertexAttributes()))
      throw new GdxRuntimeException("Vertex attributes do not match");
    if (paramInt2 <= 0)
      return;
    int i = paramMesh.getNumVertices() * this.stride;
    tmpVertices.clear();
    tmpVertices.ensureCapacity(i);
    tmpVertices.size = i;
    paramMesh.getVertices(tmpVertices.items);
    tmpIndices.clear();
    tmpIndices.ensureCapacity(paramInt2);
    tmpIndices.size = paramInt2;
    paramMesh.getIndices(paramInt1, paramInt2, tmpIndices.items, 0);
    addMesh(tmpVertices.items, tmpIndices.items, 0, paramInt2);
  }

  public void addMesh(MeshPart paramMeshPart)
  {
    if (paramMeshPart.primitiveType != this.primitiveType)
      throw new GdxRuntimeException("Primitive type doesn't match");
    addMesh(paramMeshPart.mesh, paramMeshPart.offset, paramMeshPart.size);
  }

  public void arrow(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt)
  {
    Vector3 localVector31 = tmp(paramFloat1, paramFloat2, paramFloat3);
    Vector3 localVector32 = tmp(paramFloat4, paramFloat5, paramFloat6);
    float f1 = localVector31.dst(localVector32);
    float f2 = f1 * paramFloat7;
    float f3 = 2.0F * (float)(f2 * Math.sqrt(0.333333343267441D));
    float f4 = f1 - f2;
    float f5 = f3 * paramFloat8;
    Vector3 localVector33 = tmp(localVector32).sub(localVector31).nor();
    Vector3 localVector34 = tmp(localVector33).crs(Vector3.Z);
    if (localVector34.isZero())
      localVector34.set(Vector3.X);
    localVector34.crs(localVector33).nor();
    Vector3 localVector35 = tmp(localVector33).crs(localVector34).nor();
    Vector3 localVector36 = tmp(localVector32).sub(localVector31).nor();
    Matrix4 localMatrix41 = getVertexTransform(tmp());
    Matrix4 localMatrix42 = tmp();
    float[] arrayOfFloat = localMatrix42.val;
    arrayOfFloat[0] = localVector35.x;
    arrayOfFloat[4] = localVector33.x;
    arrayOfFloat[8] = localVector34.x;
    arrayOfFloat[1] = localVector35.y;
    arrayOfFloat[5] = localVector33.y;
    arrayOfFloat[9] = localVector34.y;
    arrayOfFloat[2] = localVector35.z;
    arrayOfFloat[6] = localVector33.z;
    arrayOfFloat[10] = localVector34.z;
    Matrix4 localMatrix43 = tmp();
    localMatrix42.setTranslation(tmp(localVector36).scl(f4 / 2.0F).add(paramFloat1, paramFloat2, paramFloat3));
    setVertexTransform(localMatrix43.set(localMatrix42).mul(localMatrix41));
    cylinder(f5, f4, f5, paramInt);
    localMatrix42.setTranslation(tmp(localVector36).scl(f4).add(paramFloat1, paramFloat2, paramFloat3));
    setVertexTransform(localMatrix43.set(localMatrix42).mul(localMatrix41));
    cone(f3, f2, f3, paramInt);
    setVertexTransform(localMatrix41);
    cleanup();
  }

  public void begin(long paramLong)
  {
    begin(createAttributes(paramLong), -1);
  }

  public void begin(long paramLong, int paramInt)
  {
    begin(createAttributes(paramLong), paramInt);
  }

  public void begin(VertexAttributes paramVertexAttributes)
  {
    begin(paramVertexAttributes, -1);
  }

  public void begin(VertexAttributes paramVertexAttributes, int paramInt)
  {
    int i = -1;
    if (this.attributes != null)
      throw new RuntimeException("Call end() first");
    this.attributes = paramVertexAttributes;
    this.vertices.clear();
    this.indices.clear();
    this.parts.clear();
    this.vindex = 0;
    this.istart = 0;
    this.part = null;
    this.stride = (paramVertexAttributes.vertexSize / 4);
    if ((this.vertex == null) || (this.vertex.length < this.stride))
      this.vertex = new float[this.stride];
    VertexAttribute localVertexAttribute1 = paramVertexAttributes.findByUsage(1);
    if (localVertexAttribute1 == null)
      throw new GdxRuntimeException("Cannot build mesh without position attribute");
    this.posOffset = (localVertexAttribute1.offset / 4);
    this.posSize = localVertexAttribute1.numComponents;
    VertexAttribute localVertexAttribute2 = paramVertexAttributes.findByUsage(8);
    int j;
    VertexAttribute localVertexAttribute3;
    int k;
    label180: int m;
    label194: VertexAttribute localVertexAttribute4;
    int n;
    label215: VertexAttribute localVertexAttribute5;
    if (localVertexAttribute2 == null)
    {
      j = i;
      this.norOffset = j;
      localVertexAttribute3 = paramVertexAttributes.findByUsage(2);
      if (localVertexAttribute3 != null)
        break label280;
      k = i;
      this.colOffset = k;
      if (localVertexAttribute3 != null)
        break label292;
      m = 0;
      this.colSize = m;
      localVertexAttribute4 = paramVertexAttributes.findByUsage(4);
      if (localVertexAttribute4 != null)
        break label302;
      n = i;
      this.cpOffset = n;
      localVertexAttribute5 = paramVertexAttributes.findByUsage(16);
      if (localVertexAttribute5 != null)
        break label314;
    }
    while (true)
    {
      this.uvOffset = i;
      setColor(null);
      setVertexTransform(null);
      setUVRange(null);
      this.primitiveType = paramInt;
      this.bounds.inf();
      return;
      j = localVertexAttribute2.offset / 4;
      break;
      label280: k = localVertexAttribute3.offset / 4;
      break label180;
      label292: m = localVertexAttribute3.numComponents;
      break label194;
      label302: n = localVertexAttribute4.offset / 4;
      break label215;
      label314: i = localVertexAttribute5.offset / 4;
    }
  }

  public void box(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    box(this.matTmp1.setToScaling(paramFloat1, paramFloat2, paramFloat3));
  }

  public void box(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    box(this.matTmp1.setToScaling(paramFloat4, paramFloat5, paramFloat6).trn(paramFloat1, paramFloat2, paramFloat3));
  }

  public void box(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4, MeshPartBuilder.VertexInfo paramVertexInfo5, MeshPartBuilder.VertexInfo paramVertexInfo6, MeshPartBuilder.VertexInfo paramVertexInfo7, MeshPartBuilder.VertexInfo paramVertexInfo8)
  {
    ensureVertices(8);
    short s1 = vertex(paramVertexInfo1);
    short s2 = vertex(paramVertexInfo3);
    short s3 = vertex(paramVertexInfo4);
    short s4 = vertex(paramVertexInfo2);
    short s5 = vertex(paramVertexInfo5);
    short s6 = vertex(paramVertexInfo7);
    short s7 = vertex(paramVertexInfo8);
    short s8 = vertex(paramVertexInfo6);
    if (this.primitiveType == 1)
    {
      ensureIndices(24);
      rect(s1, s2, s3, s4);
      rect(s6, s5, s8, s7);
      index(s1, s5, s4, s8, s3, s7, s2, s6);
      return;
    }
    if (this.primitiveType == 0)
    {
      ensureRectangleIndices(2);
      rect(s1, s2, s3, s4);
      rect(s6, s5, s8, s7);
      return;
    }
    ensureRectangleIndices(6);
    rect(s1, s2, s3, s4);
    rect(s6, s5, s8, s7);
    rect(s1, s4, s8, s5);
    rect(s6, s7, s3, s2);
    rect(s6, s2, s1, s5);
    rect(s3, s7, s8, s4);
  }

  public void box(Matrix4 paramMatrix4)
  {
    box(tmp(-0.5F, -0.5F, -0.5F).mul(paramMatrix4), tmp(-0.5F, 0.5F, -0.5F).mul(paramMatrix4), tmp(0.5F, -0.5F, -0.5F).mul(paramMatrix4), tmp(0.5F, 0.5F, -0.5F).mul(paramMatrix4), tmp(-0.5F, -0.5F, 0.5F).mul(paramMatrix4), tmp(-0.5F, 0.5F, 0.5F).mul(paramMatrix4), tmp(0.5F, -0.5F, 0.5F).mul(paramMatrix4), tmp(0.5F, 0.5F, 0.5F).mul(paramMatrix4));
    cleanup();
  }

  public void box(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, Vector3 paramVector36, Vector3 paramVector37, Vector3 paramVector38)
  {
    if ((this.norOffset < 0) && (this.uvOffset < 0))
    {
      box(this.vertTmp1.set(paramVector31, null, null, null), this.vertTmp2.set(paramVector32, null, null, null), this.vertTmp3.set(paramVector33, null, null, null), this.vertTmp4.set(paramVector34, null, null, null), this.vertTmp5.set(paramVector35, null, null, null), this.vertTmp6.set(paramVector36, null, null, null), this.vertTmp7.set(paramVector37, null, null, null), this.vertTmp8.set(paramVector38, null, null, null));
      return;
    }
    ensureRectangles(6);
    Vector3 localVector31 = this.tempV1.set(paramVector31).lerp(paramVector34, 0.5F).sub(this.tempV2.set(paramVector35).lerp(paramVector38, 0.5F)).nor();
    rect(paramVector31, paramVector32, paramVector34, paramVector33, localVector31);
    rect(paramVector36, paramVector35, paramVector37, paramVector38, localVector31.scl(-1.0F));
    Vector3 localVector32 = this.tempV1.set(paramVector31).lerp(paramVector37, 0.5F).sub(this.tempV2.set(paramVector32).lerp(paramVector38, 0.5F)).nor();
    rect(paramVector35, paramVector31, paramVector33, paramVector37, localVector32);
    rect(paramVector32, paramVector36, paramVector38, paramVector34, localVector32.scl(-1.0F));
    Vector3 localVector33 = this.tempV1.set(paramVector31).lerp(paramVector36, 0.5F).sub(this.tempV2.set(paramVector33).lerp(paramVector38, 0.5F)).nor();
    rect(paramVector35, paramVector36, paramVector32, paramVector31, localVector33);
    rect(paramVector33, paramVector34, paramVector38, paramVector37, localVector33.scl(-1.0F));
  }

  public void capsule(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramFloat2 < 2.0F * paramFloat1)
      throw new GdxRuntimeException("Height must be at least twice the radius");
    float f = paramFloat1 * 2.0F;
    cylinder(f, paramFloat2 - f, f, paramInt, 0.0F, 360.0F, false);
    sphere(this.matTmp1.setToTranslation(0.0F, 0.5F * (paramFloat2 - f), 0.0F), f, f, f, paramInt, paramInt, 0.0F, 360.0F, 0.0F, 90.0F);
    sphere(this.matTmp1.setToTranslation(0.0F, -0.5F * (paramFloat2 - f), 0.0F), f, f, f, paramInt, paramInt, 0.0F, 360.0F, 90.0F, 180.0F);
  }

  public void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    circle(paramFloat1, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, 0.0F, 360.0F);
  }

  public void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    ellipse(paramFloat1 * 2.0F, paramFloat1 * 2.0F, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }

  public void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13)
  {
    circle(paramFloat1, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, 0.0F, 360.0F);
  }

  public void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15)
  {
    ellipse(paramFloat1 * 2.0F, paramFloat1 * 2.0F, 0.0F, 0.0F, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15);
  }

  public void circle(float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32)
  {
    circle(paramFloat, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z);
  }

  public void circle(float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat2, float paramFloat3)
  {
    circle(paramFloat1, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramFloat2, paramFloat3);
  }

  public void circle(float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34)
  {
    circle(paramFloat, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramVector33.x, paramVector33.y, paramVector33.z, paramVector34.x, paramVector34.y, paramVector34.z);
  }

  public void circle(float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat2, float paramFloat3)
  {
    circle(paramFloat1, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramVector33.x, paramVector33.y, paramVector33.z, paramVector34.x, paramVector34.y, paramVector34.z, paramFloat2, paramFloat3);
  }

  public void clear()
  {
    this.vertices.clear();
    this.indices.clear();
    this.parts.clear();
    this.vindex = 0;
    this.istart = 0;
    this.part = null;
  }

  public void cone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    cone(paramFloat1, paramFloat2, paramFloat3, paramInt, 0.0F, 360.0F);
  }

  public void cone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5)
  {
    ensureTriangles(paramInt + 2, paramInt);
    float f1 = paramFloat1 * 0.5F;
    float f2 = paramFloat2 * 0.5F;
    float f3 = paramFloat3 * 0.5F;
    float f4 = 0.01745329F * paramFloat4;
    float f5 = 0.01745329F * (paramFloat5 - paramFloat4) / paramInt;
    float f6 = 1.0F / paramInt;
    MeshPartBuilder.VertexInfo localVertexInfo = this.vertTmp3.set(null, null, null, null);
    localVertexInfo.hasNormal = true;
    localVertexInfo.hasPosition = true;
    localVertexInfo.hasUV = true;
    short s1 = vertex(this.vertTmp4.set(null, null, null, null).setPos(0.0F, f2, 0.0F).setNor(0.0F, 1.0F, 0.0F).setUV(0.5F, 0.0F));
    short s2 = 0;
    int i = 0;
    while (i <= paramInt)
    {
      float f7 = f4 + f5 * i;
      float f8 = 1.0F - f6 * i;
      localVertexInfo.position.set(f1 * MathUtils.cos(f7), 0.0F, f3 * MathUtils.sin(f7));
      localVertexInfo.normal.set(localVertexInfo.position).nor();
      localVertexInfo.position.y = (-f2);
      localVertexInfo.uv.set(f8, 1.0F);
      short s3 = vertex(localVertexInfo);
      if (i != 0)
        triangle(s1, s3, s2);
      i++;
      s2 = s3;
    }
    ellipse(paramFloat1, paramFloat3, 0.0F, 0.0F, paramInt, 0.0F, -f2, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 180.0F - paramFloat5, 180.0F - paramFloat4);
  }

  public void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    cylinder(paramFloat1, paramFloat2, paramFloat3, paramInt, 0.0F, 360.0F);
  }

  public void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5)
  {
    cylinder(paramFloat1, paramFloat2, paramFloat3, paramInt, paramFloat4, paramFloat5, true);
  }

  public void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    float f1 = paramFloat1 * 0.5F;
    float f2 = paramFloat2 * 0.5F;
    float f3 = paramFloat3 * 0.5F;
    float f4 = 0.01745329F * paramFloat4;
    float f5 = 0.01745329F * (paramFloat5 - paramFloat4) / paramInt;
    float f6 = 1.0F / paramInt;
    MeshPartBuilder.VertexInfo localVertexInfo1 = this.vertTmp3.set(null, null, null, null);
    localVertexInfo1.hasNormal = true;
    localVertexInfo1.hasPosition = true;
    localVertexInfo1.hasUV = true;
    MeshPartBuilder.VertexInfo localVertexInfo2 = this.vertTmp4.set(null, null, null, null);
    localVertexInfo2.hasNormal = true;
    localVertexInfo2.hasPosition = true;
    localVertexInfo2.hasUV = true;
    short s1 = 0;
    ensureRectangles(2 * (paramInt + 1), paramInt);
    int i = 0;
    short s4;
    for (short s2 = 0; i <= paramInt; s2 = s4)
    {
      float f7 = f4 + f5 * i;
      float f8 = 1.0F - f6 * i;
      localVertexInfo1.position.set(f1 * MathUtils.cos(f7), 0.0F, f3 * MathUtils.sin(f7));
      localVertexInfo1.normal.set(localVertexInfo1.position).nor();
      localVertexInfo1.position.y = (-f2);
      localVertexInfo1.uv.set(f8, 1.0F);
      localVertexInfo2.position.set(localVertexInfo1.position);
      localVertexInfo2.normal.set(localVertexInfo1.normal);
      localVertexInfo2.position.y = f2;
      localVertexInfo2.uv.set(f8, 0.0F);
      short s3 = vertex(localVertexInfo1);
      s4 = vertex(localVertexInfo2);
      if (i != 0)
        rect(s2, s4, s3, s1);
      i++;
      s1 = s3;
    }
    if (paramBoolean)
    {
      ellipse(paramFloat1, paramFloat3, 0.0F, 0.0F, paramInt, 0.0F, f2, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, paramFloat4, paramFloat5);
      ellipse(paramFloat1, paramFloat3, 0.0F, 0.0F, paramInt, 0.0F, -f2, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 180.0F - paramFloat5, 180.0F - paramFloat4);
    }
  }

  public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10)
  {
    ellipse(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, 0.0F, 360.0F);
  }

  public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12)
  {
    this.tempV1.set(paramFloat8, paramFloat9, paramFloat10).crs(0.0F, 0.0F, 1.0F);
    this.tempV2.set(paramFloat8, paramFloat9, paramFloat10).crs(0.0F, 1.0F, 0.0F);
    if (this.tempV2.len2() > this.tempV1.len2())
      this.tempV1.set(this.tempV2);
    this.tempV2.set(this.tempV1.nor()).crs(paramFloat8, paramFloat9, paramFloat10).nor();
    ellipse(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, this.tempV1.x, this.tempV1.y, this.tempV1.z, this.tempV2.x, this.tempV2.y, this.tempV2.z, paramFloat11, paramFloat12);
  }

  public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18)
  {
    Vector3 localVector33;
    Vector3 localVector34;
    MeshPartBuilder.VertexInfo localVertexInfo1;
    float f3;
    float f4;
    short s2;
    short s3;
    int i;
    short s4;
    label330: float f6;
    float f7;
    short s5;
    short s7;
    short s8;
    if ((paramFloat3 <= 0.0F) || (paramFloat4 <= 0.0F))
    {
      ensureTriangles(paramInt + 2, paramInt);
      float f1 = 0.01745329F * paramFloat17;
      float f2 = 0.01745329F * (paramFloat18 - paramFloat17) / paramInt;
      Vector3 localVector31 = this.tempV1.set(paramFloat11, paramFloat12, paramFloat13).scl(0.5F * paramFloat1);
      Vector3 localVector32 = this.tempV2.set(paramFloat14, paramFloat15, paramFloat16).scl(0.5F * paramFloat2);
      localVector33 = this.tempV3.set(paramFloat11, paramFloat12, paramFloat13).scl(0.5F * paramFloat3);
      localVector34 = this.tempV4.set(paramFloat14, paramFloat15, paramFloat16).scl(0.5F * paramFloat4);
      localVertexInfo1 = this.vertTmp3.set(null, null, null, null);
      localVertexInfo1.hasNormal = true;
      localVertexInfo1.hasPosition = true;
      localVertexInfo1.hasUV = true;
      localVertexInfo1.uv.set(0.5F, 0.5F);
      localVertexInfo1.position.set(paramFloat5, paramFloat6, paramFloat7);
      localVertexInfo1.normal.set(paramFloat8, paramFloat9, paramFloat10);
      MeshPartBuilder.VertexInfo localVertexInfo2 = this.vertTmp4.set(null, null, null, null);
      localVertexInfo2.hasNormal = true;
      localVertexInfo2.hasPosition = true;
      localVertexInfo2.hasUV = true;
      localVertexInfo2.uv.set(0.5F, 0.5F);
      localVertexInfo2.position.set(paramFloat5, paramFloat6, paramFloat7);
      localVertexInfo2.normal.set(paramFloat8, paramFloat9, paramFloat10);
      short s1 = vertex(localVertexInfo2);
      f3 = 0.5F * (paramFloat3 / paramFloat1);
      f4 = 0.5F * (paramFloat4 / paramFloat2);
      s2 = 0;
      s3 = 0;
      i = 0;
      s4 = 0;
      if (i > paramInt)
        return;
      float f5 = f1 + f2 * i;
      f6 = MathUtils.cos(f5);
      f7 = MathUtils.sin(f5);
      localVertexInfo2.position.set(paramFloat5, paramFloat6, paramFloat7).add(f6 * localVector31.x + f7 * localVector32.x, f6 * localVector31.y + f7 * localVector32.y, f6 * localVector31.z + f7 * localVector32.z);
      localVertexInfo2.uv.set(0.5F + 0.5F * f6, 0.5F + 0.5F * f7);
      s5 = vertex(localVertexInfo2);
      if ((paramFloat3 > 0.0F) && (paramFloat4 > 0.0F))
        break label587;
      if (i != 0)
        triangle(s5, s2, s1);
      short s6 = s3;
      s7 = s5;
      s8 = s6;
    }
    while (true)
    {
      i++;
      s2 = s7;
      s3 = s8;
      break label330;
      if ((paramFloat3 == paramFloat1) && (paramFloat4 == paramFloat2))
      {
        ensureVertices(paramInt + 1);
        ensureIndices(paramInt + 1);
        if (this.primitiveType == 1)
          break;
        throw new GdxRuntimeException("Incorrect primitive type : expect GL_LINES because innerWidth == width && innerHeight == height");
      }
      ensureRectangles(paramInt + 1 << 1, paramInt + 1);
      break;
      label587: if ((paramFloat3 == paramFloat1) && (paramFloat4 == paramFloat2))
      {
        if (i != 0)
          line(s5, s2);
        short s10 = s3;
        s7 = s5;
        s8 = s10;
        continue;
      }
      localVertexInfo1.position.set(paramFloat5, paramFloat6, paramFloat7).add(f6 * localVector33.x + f7 * localVector34.x, f6 * localVector33.y + f7 * localVector34.y, f6 * localVector33.z + f7 * localVector34.z);
      localVertexInfo1.uv.set(0.5F + f6 * f3, 0.5F + f7 * f4);
      short s9 = vertex(localVertexInfo1);
      if (i != 0)
        rect(s9, s5, s4, s3);
      s4 = s5;
      s7 = s5;
      s8 = s9;
    }
  }

  public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, Vector3 paramVector31, Vector3 paramVector32)
  {
    ellipse(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, 0.0F, 360.0F);
  }

  public void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    ellipse(paramFloat1, paramFloat2, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, 0.0F, 360.0F);
  }

  public void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10)
  {
    ellipse(paramFloat1, paramFloat2, 0.0F, 0.0F, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10);
  }

  public void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14)
  {
    ellipse(paramFloat1, paramFloat2, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, 0.0F, 360.0F);
  }

  public void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
  {
    ellipse(paramFloat1, paramFloat2, 0.0F, 0.0F, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16);
  }

  public void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32)
  {
    ellipse(paramFloat1, paramFloat2, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z);
  }

  public void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat3, float paramFloat4)
  {
    ellipse(paramFloat1, paramFloat2, 0.0F, 0.0F, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramFloat3, paramFloat4);
  }

  public void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34)
  {
    ellipse(paramFloat1, paramFloat2, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramVector33.x, paramVector33.y, paramVector33.z, paramVector34.x, paramVector34.y, paramVector34.z);
  }

  public void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat3, float paramFloat4)
  {
    ellipse(paramFloat1, paramFloat2, 0.0F, 0.0F, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramVector33.x, paramVector33.y, paramVector33.z, paramVector34.x, paramVector34.y, paramVector34.z, paramFloat3, paramFloat4);
  }

  public Mesh end()
  {
    return end(new Mesh(true, this.vertices.size / this.stride, this.indices.size, this.attributes));
  }

  public Mesh end(Mesh paramMesh)
  {
    endpart();
    if (this.attributes == null)
      throw new GdxRuntimeException("Call begin() first");
    if (!this.attributes.equals(paramMesh.getVertexAttributes()))
      throw new GdxRuntimeException("Mesh attributes don't match");
    if (paramMesh.getMaxVertices() * this.stride < this.vertices.size)
      throw new GdxRuntimeException("Mesh can't hold enough vertices: " + paramMesh.getMaxVertices() + " * " + this.stride + " < " + this.vertices.size);
    if (paramMesh.getMaxIndices() < this.indices.size)
      throw new GdxRuntimeException("Mesh can't hold enough indices: " + paramMesh.getMaxIndices() + " < " + this.indices.size);
    paramMesh.setVertices(this.vertices.items, 0, this.vertices.size);
    paramMesh.setIndices(this.indices.items, 0, this.indices.size);
    Iterator localIterator = this.parts.iterator();
    while (localIterator.hasNext())
      ((MeshPart)localIterator.next()).mesh = paramMesh;
    this.parts.clear();
    this.attributes = null;
    this.vertices.clear();
    this.indices.clear();
    return paramMesh;
  }

  public void ensureCapacity(int paramInt1, int paramInt2)
  {
    ensureVertices(paramInt1);
    ensureIndices(paramInt2);
  }

  public void ensureIndices(int paramInt)
  {
    this.indices.ensureCapacity(paramInt);
  }

  public void ensureRectangleIndices(int paramInt)
  {
    if (this.primitiveType == 0)
    {
      ensureIndices(paramInt * 4);
      return;
    }
    if (this.primitiveType == 1)
    {
      ensureIndices(paramInt * 8);
      return;
    }
    ensureIndices(paramInt * 6);
  }

  public void ensureRectangles(int paramInt)
  {
    ensureRectangles(paramInt * 4, paramInt);
  }

  public void ensureRectangles(int paramInt1, int paramInt2)
  {
    ensureVertices(paramInt1);
    ensureRectangleIndices(paramInt2);
  }

  public void ensureTriangleIndices(int paramInt)
  {
    if (this.primitiveType == 1)
    {
      ensureIndices(paramInt * 6);
      return;
    }
    if ((this.primitiveType == 4) || (this.primitiveType == 0))
    {
      ensureIndices(paramInt * 3);
      return;
    }
    throw new GdxRuntimeException("Incorrect primtive type");
  }

  public void ensureTriangles(int paramInt)
  {
    ensureTriangles(paramInt * 3, paramInt);
  }

  public void ensureTriangles(int paramInt1, int paramInt2)
  {
    ensureVertices(paramInt1);
    ensureTriangleIndices(paramInt2);
  }

  public void ensureVertices(int paramInt)
  {
    this.vertices.ensureCapacity(paramInt * this.stride);
  }

  public VertexAttributes getAttributes()
  {
    return this.attributes;
  }

  public int getFloatsPerVertex()
  {
    return this.stride;
  }

  public void getIndices(short[] paramArrayOfShort, int paramInt)
  {
    if (this.attributes == null)
      throw new GdxRuntimeException("Must be called in between #begin and #end");
    if ((paramInt < 0) || (paramInt > paramArrayOfShort.length - this.indices.size))
      throw new GdxRuntimeException("Array to small or offset out of range");
    System.arraycopy(this.indices.items, 0, paramArrayOfShort, paramInt, this.indices.size);
  }

  protected short[] getIndices()
  {
    return this.indices.items;
  }

  public MeshPart getMeshPart()
  {
    return this.part;
  }

  public int getNumIndices()
  {
    return this.indices.size;
  }

  public int getNumVertices()
  {
    return this.vertices.size / this.stride;
  }

  public Matrix4 getVertexTransform(Matrix4 paramMatrix4)
  {
    return paramMatrix4.set(this.positionTransform);
  }

  public void getVertices(float[] paramArrayOfFloat, int paramInt)
  {
    if (this.attributes == null)
      throw new GdxRuntimeException("Must be called in between #begin and #end");
    if ((paramInt < 0) || (paramInt > paramArrayOfFloat.length - this.vertices.size))
      throw new GdxRuntimeException("Array to small or offset out of range");
    System.arraycopy(this.vertices.items, 0, paramArrayOfFloat, paramInt, this.vertices.size);
  }

  protected float[] getVertices()
  {
    return this.vertices.items;
  }

  public void index(short paramShort)
  {
    this.indices.add(paramShort);
  }

  public void index(short paramShort1, short paramShort2)
  {
    ensureIndices(2);
    this.indices.add(paramShort1);
    this.indices.add(paramShort2);
  }

  public void index(short paramShort1, short paramShort2, short paramShort3)
  {
    ensureIndices(3);
    this.indices.add(paramShort1);
    this.indices.add(paramShort2);
    this.indices.add(paramShort3);
  }

  public void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    ensureIndices(4);
    this.indices.add(paramShort1);
    this.indices.add(paramShort2);
    this.indices.add(paramShort3);
    this.indices.add(paramShort4);
  }

  public void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6)
  {
    ensureIndices(6);
    this.indices.add(paramShort1);
    this.indices.add(paramShort2);
    this.indices.add(paramShort3);
    this.indices.add(paramShort4);
    this.indices.add(paramShort5);
    this.indices.add(paramShort6);
  }

  public void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, short paramShort7, short paramShort8)
  {
    ensureIndices(8);
    this.indices.add(paramShort1);
    this.indices.add(paramShort2);
    this.indices.add(paramShort3);
    this.indices.add(paramShort4);
    this.indices.add(paramShort5);
    this.indices.add(paramShort6);
    this.indices.add(paramShort7);
    this.indices.add(paramShort8);
  }

  public boolean isVertexTransformationEnabled()
  {
    return this.vertexTransformationEnabled;
  }

  public short lastIndex()
  {
    return this.lastIndex;
  }

  public void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    line(this.vertTmp1.set(null, null, null, null).setPos(paramFloat1, paramFloat2, paramFloat3), this.vertTmp2.set(null, null, null, null).setPos(paramFloat4, paramFloat5, paramFloat6));
  }

  public void line(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2)
  {
    ensureVertices(2);
    line(vertex(paramVertexInfo1), vertex(paramVertexInfo2));
  }

  public void line(Vector3 paramVector31, Color paramColor1, Vector3 paramVector32, Color paramColor2)
  {
    line(this.vertTmp1.set(paramVector31, null, paramColor1, null), this.vertTmp2.set(paramVector32, null, paramColor2, null));
  }

  public void line(Vector3 paramVector31, Vector3 paramVector32)
  {
    line(this.vertTmp1.set(paramVector31, null, null, null), this.vertTmp2.set(paramVector32, null, null, null));
  }

  public void line(short paramShort1, short paramShort2)
  {
    if (this.primitiveType != 1)
      throw new GdxRuntimeException("Incorrect primitive type");
    index(paramShort1, paramShort2);
  }

  public MeshPart part(String paramString, int paramInt)
  {
    return part(paramString, paramInt, new MeshPart());
  }

  public MeshPart part(String paramString, int paramInt, MeshPart paramMeshPart)
  {
    if (this.attributes == null)
      throw new RuntimeException("Call begin() first");
    endpart();
    this.part = paramMeshPart;
    this.part.id = paramString;
    this.part.primitiveType = paramInt;
    this.primitiveType = paramInt;
    this.parts.add(this.part);
    setColor(null);
    setVertexTransform(null);
    setUVRange(null);
    return this.part;
  }

  public void patch(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, int paramInt1, int paramInt2)
  {
    patch(this.vertTmp1.set(null).setPos(paramFloat1, paramFloat2, paramFloat3).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(0.0F, 1.0F), this.vertTmp2.set(null).setPos(paramFloat4, paramFloat5, paramFloat6).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(1.0F, 1.0F), this.vertTmp3.set(null).setPos(paramFloat7, paramFloat8, paramFloat9).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(1.0F, 0.0F), this.vertTmp4.set(null).setPos(paramFloat10, paramFloat11, paramFloat12).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(0.0F, 0.0F), paramInt1, paramInt2);
  }

  public void patch(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      throw new GdxRuntimeException("divisionsU and divisionV must be > 0, u,v: " + paramInt1 + ", " + paramInt2);
    ensureRectangles((paramInt2 + 1) * (paramInt1 + 1), paramInt2 * paramInt1);
    for (int i = 0; i <= paramInt1; i++)
    {
      float f = i / paramInt1;
      this.vertTmp5.set(paramVertexInfo1).lerp(paramVertexInfo2, f);
      this.vertTmp6.set(paramVertexInfo4).lerp(paramVertexInfo3, f);
      for (int j = 0; j <= paramInt2; j++)
      {
        int k = vertex(this.vertTmp7.set(this.vertTmp5).lerp(this.vertTmp6, j / paramInt2));
        if ((i <= 0) || (j <= 0))
          continue;
        rect((short)(-2 + (k - paramInt2)), (short)(k - 1), k, (short)(-1 + (k - paramInt2)));
      }
    }
  }

  public void patch(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, int paramInt1, int paramInt2)
  {
    patch(this.vertTmp1.set(paramVector31, paramVector35, null, null).setUV(0.0F, 1.0F), this.vertTmp2.set(paramVector32, paramVector35, null, null).setUV(1.0F, 1.0F), this.vertTmp3.set(paramVector33, paramVector35, null, null).setUV(1.0F, 0.0F), this.vertTmp4.set(paramVector34, paramVector35, null, null).setUV(0.0F, 0.0F), paramInt1, paramInt2);
  }

  public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15)
  {
    rect(this.vertTmp1.set(null, null, null, null).setPos(paramFloat1, paramFloat2, paramFloat3).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(0.0F, 1.0F), this.vertTmp2.set(null, null, null, null).setPos(paramFloat4, paramFloat5, paramFloat6).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(1.0F, 1.0F), this.vertTmp3.set(null, null, null, null).setPos(paramFloat7, paramFloat8, paramFloat9).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(1.0F, 0.0F), this.vertTmp4.set(null, null, null, null).setPos(paramFloat10, paramFloat11, paramFloat12).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(0.0F, 0.0F));
  }

  public void rect(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4)
  {
    ensureVertices(4);
    rect(vertex(paramVertexInfo1), vertex(paramVertexInfo2), vertex(paramVertexInfo3), vertex(paramVertexInfo4));
  }

  public void rect(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35)
  {
    rect(this.vertTmp1.set(paramVector31, paramVector35, null, null).setUV(0.0F, 1.0F), this.vertTmp2.set(paramVector32, paramVector35, null, null).setUV(1.0F, 1.0F), this.vertTmp3.set(paramVector33, paramVector35, null, null).setUV(1.0F, 0.0F), this.vertTmp4.set(paramVector34, paramVector35, null, null).setUV(0.0F, 0.0F));
  }

  public void rect(short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    if (this.primitiveType == 4)
    {
      index(paramShort1, paramShort2, paramShort3, paramShort3, paramShort4, paramShort1);
      return;
    }
    if (this.primitiveType == 1)
    {
      index(paramShort1, paramShort2, paramShort2, paramShort3, paramShort3, paramShort4, paramShort4, paramShort1);
      return;
    }
    if (this.primitiveType == 0)
    {
      index(paramShort1, paramShort2, paramShort3, paramShort4);
      return;
    }
    throw new GdxRuntimeException("Incorrect primitive type");
  }

  public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    if (!this.color.equals(Color.WHITE));
    for (boolean bool = true; ; bool = false)
    {
      this.hasColor = bool;
      return;
    }
  }

  public void setColor(Color paramColor)
  {
    Color localColor = this.color;
    if (paramColor != null);
    for (boolean bool = true; ; bool = false)
    {
      this.hasColor = bool;
      if (!bool)
        paramColor = Color.WHITE;
      localColor.set(paramColor);
      return;
    }
  }

  public void setUVRange(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.uOffset = paramFloat1;
    this.vOffset = paramFloat2;
    this.uScale = (paramFloat3 - paramFloat1);
    this.vScale = (paramFloat4 - paramFloat2);
    if ((!MathUtils.isZero(paramFloat1)) || (!MathUtils.isZero(paramFloat2)) || (!MathUtils.isEqual(paramFloat3, 1.0F)) || (!MathUtils.isEqual(paramFloat4, 1.0F)));
    for (boolean bool = true; ; bool = false)
    {
      this.hasUVTransform = bool;
      return;
    }
  }

  public void setUVRange(TextureRegion paramTextureRegion)
  {
    if (paramTextureRegion != null);
    for (boolean bool = true; ; bool = false)
    {
      this.hasUVTransform = bool;
      if (bool)
        break;
      this.vOffset = 0.0F;
      this.uOffset = 0.0F;
      this.vScale = 1.0F;
      this.uScale = 1.0F;
      return;
    }
    setUVRange(paramTextureRegion.getU(), paramTextureRegion.getV(), paramTextureRegion.getU2(), paramTextureRegion.getV2());
  }

  public void setVertexTransform(Matrix4 paramMatrix4)
  {
    if (paramMatrix4 != null);
    for (boolean bool = true; ; bool = false)
    {
      this.vertexTransformationEnabled = bool;
      if (bool != true)
        break;
      this.positionTransform.set(paramMatrix4);
      this.normalTransform.set(paramMatrix4).inv().transpose();
      return;
    }
    this.positionTransform.idt();
    this.normalTransform.idt();
  }

  public void setVertexTransformationEnabled(boolean paramBoolean)
  {
    this.vertexTransformationEnabled = paramBoolean;
  }

  public void sphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    sphere(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, 0.0F, 360.0F, 0.0F, 180.0F);
  }

  public void sphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    sphere(this.matTmp1.idt(), paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
  }

  public void sphere(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    sphere(paramMatrix4, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, 0.0F, 360.0F, 0.0F, 180.0F);
  }

  public void sphere(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    float f1 = paramFloat1 * 0.5F;
    float f2 = paramFloat2 * 0.5F;
    float f3 = paramFloat3 * 0.5F;
    float f4 = 0.01745329F * paramFloat4;
    float f5 = 0.01745329F * (paramFloat5 - paramFloat4) / paramInt1;
    float f6 = 0.01745329F * paramFloat6;
    float f7 = 0.01745329F * (paramFloat7 - paramFloat6) / paramInt2;
    float f8 = 1.0F / paramInt1;
    float f9 = 1.0F / paramInt2;
    MeshPartBuilder.VertexInfo localVertexInfo = this.vertTmp3.set(null, null, null, null);
    localVertexInfo.hasNormal = true;
    localVertexInfo.hasPosition = true;
    localVertexInfo.hasUV = true;
    int i = paramInt1 + 3;
    tmpIndices.clear();
    tmpIndices.ensureCapacity(paramInt1 << 1);
    tmpIndices.size = i;
    int j = 0;
    ensureRectangles((paramInt2 + 1) * (paramInt1 + 1), paramInt2 * paramInt1);
    for (int k = 0; k <= paramInt2; k++)
    {
      float f10 = f6 + f7 * k;
      float f11 = f9 * k;
      float f12 = MathUtils.sin(f10);
      float f13 = f2 * MathUtils.cos(f10);
      for (int m = 0; m <= paramInt1; m++)
      {
        float f14 = f4 + f5 * m;
        float f15 = 1.0F - f8 * m;
        localVertexInfo.position.set(f12 * (f1 * MathUtils.cos(f14)), f13, f12 * (f3 * MathUtils.sin(f14))).mul(paramMatrix4);
        localVertexInfo.normal.set(localVertexInfo.position).nor();
        localVertexInfo.uv.set(f15, f11);
        tmpIndices.set(j, vertex(localVertexInfo));
        int n = j + i;
        if ((k > 0) && (m > 0))
          rect(tmpIndices.get(j), tmpIndices.get((n - 1) % i), tmpIndices.get((n - (paramInt1 + 2)) % i), tmpIndices.get((n - (paramInt1 + 1)) % i));
        j = (j + 1) % tmpIndices.size;
      }
    }
  }

  public void triangle(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3)
  {
    ensureVertices(3);
    triangle(vertex(paramVertexInfo1), vertex(paramVertexInfo2), vertex(paramVertexInfo3));
  }

  public void triangle(Vector3 paramVector31, Color paramColor1, Vector3 paramVector32, Color paramColor2, Vector3 paramVector33, Color paramColor3)
  {
    triangle(this.vertTmp1.set(paramVector31, null, paramColor1, null), this.vertTmp2.set(paramVector32, null, paramColor2, null), this.vertTmp3.set(paramVector33, null, paramColor3, null));
  }

  public void triangle(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33)
  {
    triangle(this.vertTmp1.set(paramVector31, null, null, null), this.vertTmp2.set(paramVector32, null, null, null), this.vertTmp3.set(paramVector33, null, null, null));
  }

  public void triangle(short paramShort1, short paramShort2, short paramShort3)
  {
    if ((this.primitiveType == 4) || (this.primitiveType == 0))
    {
      index(paramShort1, paramShort2, paramShort3);
      return;
    }
    if (this.primitiveType == 1)
    {
      index(paramShort1, paramShort2, paramShort2, paramShort3, paramShort3, paramShort1);
      return;
    }
    throw new GdxRuntimeException("Incorrect primitive type");
  }

  public short vertex(MeshPartBuilder.VertexInfo paramVertexInfo)
  {
    Vector3 localVector31;
    Vector3 localVector32;
    if (paramVertexInfo.hasPosition)
    {
      localVector31 = paramVertexInfo.position;
      if (!paramVertexInfo.hasNormal)
        break label73;
      localVector32 = paramVertexInfo.normal;
      label24: if (!paramVertexInfo.hasColor)
        break label78;
    }
    label73: label78: for (Color localColor = paramVertexInfo.color; ; localColor = null)
    {
      boolean bool = paramVertexInfo.hasUV;
      Vector2 localVector2 = null;
      if (bool)
        localVector2 = paramVertexInfo.uv;
      return vertex(localVector31, localVector32, localColor, localVector2);
      localVector31 = null;
      break;
      localVector32 = null;
      break label24;
    }
  }

  public short vertex(Vector3 paramVector31, Vector3 paramVector32, Color paramColor, Vector2 paramVector2)
  {
    if (this.vindex >= 32767)
      throw new GdxRuntimeException("Too many vertices used");
    this.vertex[this.posOffset] = paramVector31.x;
    if (this.posSize > 1)
      this.vertex[(1 + this.posOffset)] = paramVector31.y;
    if (this.posSize > 2)
      this.vertex[(2 + this.posOffset)] = paramVector31.z;
    if (this.norOffset >= 0)
    {
      if (paramVector32 == null)
        paramVector32 = this.tmpNormal.set(paramVector31).nor();
      this.vertex[this.norOffset] = paramVector32.x;
      this.vertex[(1 + this.norOffset)] = paramVector32.y;
      this.vertex[(2 + this.norOffset)] = paramVector32.z;
    }
    if (this.colOffset >= 0)
    {
      if (paramColor == null)
        paramColor = Color.WHITE;
      this.vertex[this.colOffset] = paramColor.r;
      this.vertex[(1 + this.colOffset)] = paramColor.g;
      this.vertex[(2 + this.colOffset)] = paramColor.b;
      if (this.colSize > 3)
        this.vertex[(3 + this.colOffset)] = paramColor.a;
    }
    while (true)
    {
      if ((paramVector2 != null) && (this.uvOffset >= 0))
      {
        this.vertex[this.uvOffset] = paramVector2.x;
        this.vertex[(1 + this.uvOffset)] = paramVector2.y;
      }
      addVertex(this.vertex, 0);
      return this.lastIndex;
      if (this.cpOffset <= 0)
        continue;
      if (paramColor == null)
        paramColor = Color.WHITE;
      this.vertex[this.cpOffset] = paramColor.toFloatBits();
    }
  }

  public short vertex(float[] paramArrayOfFloat)
  {
    int i = paramArrayOfFloat.length - this.stride;
    int j = 0;
    while (j <= i)
    {
      addVertex(paramArrayOfFloat, j);
      j += this.stride;
    }
    return this.lastIndex;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.MeshBuilder
 * JD-Core Version:    0.6.0
 */