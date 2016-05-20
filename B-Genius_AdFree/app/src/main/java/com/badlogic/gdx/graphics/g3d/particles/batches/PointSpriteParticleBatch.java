package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
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
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Config;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.ParticleType;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData;
import com.badlogic.gdx.graphics.g3d.particles.renderers.PointSpriteControllerRenderData;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import java.util.Iterator;

public class PointSpriteParticleBatch extends BufferedParticleBatch
{
  protected static final VertexAttributes CPU_ATTRIBUTES;
  protected static final int CPU_COLOR_OFFSET = 0;
  protected static final int CPU_POSITION_OFFSET = 0;
  protected static final int CPU_REGION_OFFSET = 0;
  protected static final int CPU_SIZE_AND_ROTATION_OFFSET = 0;
  protected static final int CPU_VERTEX_SIZE = 0;
  protected static final Vector3 TMP_V1;
  private static boolean pointSpritesEnabled = false;
  protected static final int sizeAndRotationUsage = 512;
  Renderable renderable;
  private float[] vertices;

  static
  {
    TMP_V1 = new Vector3();
    VertexAttribute[] arrayOfVertexAttribute = new VertexAttribute[4];
    arrayOfVertexAttribute[0] = new VertexAttribute(1, 3, "a_position");
    arrayOfVertexAttribute[1] = new VertexAttribute(2, 4, "a_color");
    arrayOfVertexAttribute[2] = new VertexAttribute(16, 4, "a_region");
    arrayOfVertexAttribute[3] = new VertexAttribute(512, 3, "a_sizeAndRotation");
    VertexAttributes localVertexAttributes = new VertexAttributes(arrayOfVertexAttribute);
    CPU_ATTRIBUTES = localVertexAttributes;
    CPU_VERTEX_SIZE = (short)(localVertexAttributes.vertexSize / 4);
    CPU_POSITION_OFFSET = (short)(CPU_ATTRIBUTES.findByUsage(1).offset / 4);
    CPU_COLOR_OFFSET = (short)(CPU_ATTRIBUTES.findByUsage(2).offset / 4);
    CPU_REGION_OFFSET = (short)(CPU_ATTRIBUTES.findByUsage(16).offset / 4);
    CPU_SIZE_AND_ROTATION_OFFSET = (short)(CPU_ATTRIBUTES.findByUsage(512).offset / 4);
  }

  public PointSpriteParticleBatch()
  {
    this(1000);
  }

  public PointSpriteParticleBatch(int paramInt)
  {
    super(PointSpriteControllerRenderData.class);
    if (!pointSpritesEnabled)
      enablePointSprites();
    allocRenderable();
    ensureCapacity(paramInt);
    this.renderable.shader = new ParticleShader(this.renderable, new ParticleShader.Config(ParticleShader.ParticleType.Point));
    this.renderable.shader.init();
  }

  private static void enablePointSprites()
  {
    Gdx.gl.glEnable(34370);
    if (Gdx.app.getType() == Application.ApplicationType.Desktop)
      Gdx.gl.glEnable(34913);
    pointSpritesEnabled = true;
  }

  protected void allocParticlesData(int paramInt)
  {
    this.vertices = new float[paramInt * CPU_VERTEX_SIZE];
    if (this.renderable.meshPart.mesh != null)
      this.renderable.meshPart.mesh.dispose();
    this.renderable.meshPart.mesh = new Mesh(false, paramInt, 0, CPU_ATTRIBUTES);
  }

  protected void allocRenderable()
  {
    this.renderable = new Renderable();
    this.renderable.meshPart.primitiveType = 0;
    this.renderable.meshPart.offset = 0;
    Renderable localRenderable = this.renderable;
    Attribute[] arrayOfAttribute = new Attribute[3];
    arrayOfAttribute[0] = new BlendingAttribute(1, 771, 1.0F);
    arrayOfAttribute[1] = new DepthTestAttribute(515, false);
    arrayOfAttribute[2] = TextureAttribute.createDiffuse(null);
    localRenderable.material = new Material(arrayOfAttribute);
  }

  protected void flush(int[] paramArrayOfInt)
  {
    Iterator localIterator = this.renderData.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      PointSpriteControllerRenderData localPointSpriteControllerRenderData = (PointSpriteControllerRenderData)localIterator.next();
      ParallelArray.FloatChannel localFloatChannel1 = localPointSpriteControllerRenderData.scaleChannel;
      ParallelArray.FloatChannel localFloatChannel2 = localPointSpriteControllerRenderData.regionChannel;
      ParallelArray.FloatChannel localFloatChannel3 = localPointSpriteControllerRenderData.positionChannel;
      ParallelArray.FloatChannel localFloatChannel4 = localPointSpriteControllerRenderData.colorChannel;
      ParallelArray.FloatChannel localFloatChannel5 = localPointSpriteControllerRenderData.rotationChannel;
      int j = 0;
      while (j < localPointSpriteControllerRenderData.controller.particles.size)
      {
        int k = paramArrayOfInt[i] * CPU_VERTEX_SIZE;
        int m = j * localFloatChannel2.strideSize;
        int n = j * localFloatChannel3.strideSize;
        int i1 = j * localFloatChannel4.strideSize;
        int i2 = j * localFloatChannel5.strideSize;
        this.vertices[(k + CPU_POSITION_OFFSET)] = localFloatChannel3.data[n];
        this.vertices[(1 + (k + CPU_POSITION_OFFSET))] = localFloatChannel3.data[(n + 1)];
        this.vertices[(2 + (k + CPU_POSITION_OFFSET))] = localFloatChannel3.data[(n + 2)];
        this.vertices[(k + CPU_COLOR_OFFSET)] = localFloatChannel4.data[i1];
        this.vertices[(1 + (k + CPU_COLOR_OFFSET))] = localFloatChannel4.data[(i1 + 1)];
        this.vertices[(2 + (k + CPU_COLOR_OFFSET))] = localFloatChannel4.data[(i1 + 2)];
        this.vertices[(3 + (k + CPU_COLOR_OFFSET))] = localFloatChannel4.data[(i1 + 3)];
        this.vertices[(k + CPU_SIZE_AND_ROTATION_OFFSET)] = localFloatChannel1.data[(j * localFloatChannel1.strideSize)];
        this.vertices[(1 + (k + CPU_SIZE_AND_ROTATION_OFFSET))] = localFloatChannel5.data[i2];
        this.vertices[(2 + (k + CPU_SIZE_AND_ROTATION_OFFSET))] = localFloatChannel5.data[(i2 + 1)];
        this.vertices[(k + CPU_REGION_OFFSET)] = localFloatChannel2.data[m];
        this.vertices[(1 + (k + CPU_REGION_OFFSET))] = localFloatChannel2.data[(m + 1)];
        this.vertices[(2 + (k + CPU_REGION_OFFSET))] = localFloatChannel2.data[(m + 2)];
        this.vertices[(3 + (k + CPU_REGION_OFFSET))] = localFloatChannel2.data[(m + 3)];
        j++;
        i++;
      }
    }
    this.renderable.meshPart.size = this.bufferedParticlesCount;
    this.renderable.meshPart.mesh.setVertices(this.vertices, 0, this.bufferedParticlesCount * CPU_VERTEX_SIZE);
    this.renderable.meshPart.update();
  }

  public void getRenderables(Array paramArray, Pool paramPool)
  {
    if (this.bufferedParticlesCount > 0)
      paramArray.add(((Renderable)paramPool.obtain()).set(this.renderable));
  }

  public Texture getTexture()
  {
    return (Texture)((TextureAttribute)this.renderable.material.get(TextureAttribute.Diffuse)).textureDescription.texture;
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    ResourceData.SaveData localSaveData = paramResourceData.getSaveData("pointSpriteBatch");
    if (localSaveData != null)
      setTexture((Texture)paramAssetManager.get(localSaveData.loadAsset()));
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    paramResourceData.createSaveData("pointSpriteBatch").saveAsset(paramAssetManager.getAssetFileName(getTexture()), Texture.class);
  }

  public void setTexture(Texture paramTexture)
  {
    ((TextureAttribute)this.renderable.material.get(TextureAttribute.Diffuse)).textureDescription.texture = paramTexture;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.batches.PointSpriteParticleBatch
 * JD-Core Version:    0.6.0
 */