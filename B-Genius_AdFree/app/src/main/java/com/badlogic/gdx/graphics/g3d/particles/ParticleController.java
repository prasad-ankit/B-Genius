package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.emitters.Emitter;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import java.util.Iterator;

public class ParticleController
  implements ResourceData.Configurable, Json.Serializable
{
  protected static final float DEFAULT_TIME_STEP = 0.01666667F;
  protected BoundingBox boundingBox;
  public float deltaTime;
  public float deltaTimeSqr;
  public Emitter emitter;
  public Array influencers = new Array(true, 3, Influencer.class);
  public String name;
  public ParticleChannels particleChannels;
  public ParallelArray particles;
  public ParticleControllerRenderer renderer;
  public Vector3 scale = new Vector3(1.0F, 1.0F, 1.0F);
  public Matrix4 transform = new Matrix4();

  public ParticleController()
  {
    setTimeStep(0.01666667F);
  }

  public ParticleController(String paramString, Emitter paramEmitter, ParticleControllerRenderer paramParticleControllerRenderer, Influencer[] paramArrayOfInfluencer)
  {
    this();
    this.name = paramString;
    this.emitter = paramEmitter;
    this.renderer = paramParticleControllerRenderer;
    this.particleChannels = new ParticleChannels();
    this.influencers = new Array(paramArrayOfInfluencer);
  }

  private int findIndex(Class paramClass)
  {
    for (int i = 0; i < this.influencers.size; i++)
      if (ClassReflection.isAssignableFrom(paramClass, ((Influencer)this.influencers.get(i)).getClass()))
        return i;
    return -1;
  }

  private void setTimeStep(float paramFloat)
  {
    this.deltaTime = paramFloat;
    this.deltaTimeSqr = (this.deltaTime * this.deltaTime);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    this.emitter.activateParticles(paramInt1, paramInt2);
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).activateParticles(paramInt1, paramInt2);
  }

  protected void allocateChannels(int paramInt)
  {
    this.particles = new ParallelArray(paramInt);
    this.emitter.allocateChannels();
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).allocateChannels();
    this.renderer.allocateChannels();
  }

  protected void bind()
  {
    this.emitter.set(this);
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).set(this);
    this.renderer.set(this);
  }

  protected void calculateBoundingBox()
  {
    this.boundingBox.clr();
    ParallelArray.FloatChannel localFloatChannel = (ParallelArray.FloatChannel)this.particles.getChannel(ParticleChannels.Position);
    int i = 0;
    int j = localFloatChannel.strideSize * this.particles.size;
    while (i < j)
    {
      this.boundingBox.ext(localFloatChannel.data[i], localFloatChannel.data[(i + 1)], localFloatChannel.data[(i + 2)]);
      i += localFloatChannel.strideSize;
    }
  }

  public ParticleController copy()
  {
    Emitter localEmitter = (Emitter)this.emitter.copy();
    Influencer[] arrayOfInfluencer = new Influencer[this.influencers.size];
    Iterator localIterator = this.influencers.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Influencer localInfluencer = (Influencer)localIterator.next();
      j = i + 1;
      arrayOfInfluencer[i] = ((Influencer)localInfluencer.copy());
    }
    return new ParticleController(new String(this.name), localEmitter, (ParticleControllerRenderer)this.renderer.copy(), arrayOfInfluencer);
  }

  public void dispose()
  {
    this.emitter.dispose();
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).dispose();
  }

  public void draw()
  {
    if (this.particles.size > 0)
      this.renderer.update();
  }

  public void end()
  {
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).end();
    this.emitter.end();
  }

  public Influencer findInfluencer(Class paramClass)
  {
    int i = findIndex(paramClass);
    if (i >= 0)
      return (Influencer)this.influencers.get(i);
    return null;
  }

  public BoundingBox getBoundingBox()
  {
    if (this.boundingBox == null)
      this.boundingBox = new BoundingBox();
    calculateBoundingBox();
    return this.boundingBox;
  }

  public void getTransform(Matrix4 paramMatrix4)
  {
    paramMatrix4.set(this.transform);
  }

  public void init()
  {
    bind();
    if (this.particles != null)
    {
      end();
      this.particleChannels.resetIds();
    }
    allocateChannels(this.emitter.maxParticleCount);
    this.emitter.init();
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).init();
    this.renderer.init();
  }

  public void killParticles(int paramInt1, int paramInt2)
  {
    this.emitter.killParticles(paramInt1, paramInt2);
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).killParticles(paramInt1, paramInt2);
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    this.emitter.load(paramAssetManager, paramResourceData);
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).load(paramAssetManager, paramResourceData);
    this.renderer.load(paramAssetManager, paramResourceData);
  }

  public void mul(Matrix4 paramMatrix4)
  {
    this.transform.mul(paramMatrix4);
    this.transform.getScale(this.scale);
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.name = ((String)paramJson.readValue("name", String.class, paramJsonValue));
    this.emitter = ((Emitter)paramJson.readValue("emitter", Emitter.class, paramJsonValue));
    this.influencers.addAll((Array)paramJson.readValue("influencers", Array.class, Influencer.class, paramJsonValue));
    this.renderer = ((ParticleControllerRenderer)paramJson.readValue("renderer", ParticleControllerRenderer.class, paramJsonValue));
  }

  public void removeInfluencer(Class paramClass)
  {
    int i = findIndex(paramClass);
    if (i >= 0)
      this.influencers.removeIndex(i);
  }

  public boolean replaceInfluencer(Class paramClass, Influencer paramInfluencer)
  {
    int i = findIndex(paramClass);
    if (i >= 0)
    {
      this.influencers.insert(i, paramInfluencer);
      this.influencers.removeIndex(i + 1);
      return true;
    }
    return false;
  }

  public void reset()
  {
    end();
    start();
  }

  public void rotate(Quaternion paramQuaternion)
  {
    this.transform.rotate(paramQuaternion);
  }

  public void rotate(Vector3 paramVector3, float paramFloat)
  {
    this.transform.rotate(paramVector3, paramFloat);
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    this.emitter.save(paramAssetManager, paramResourceData);
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).save(paramAssetManager, paramResourceData);
    this.renderer.save(paramAssetManager, paramResourceData);
  }

  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.transform.scale(paramFloat1, paramFloat2, paramFloat3);
    this.transform.getScale(this.scale);
  }

  public void scale(Vector3 paramVector3)
  {
    scale(paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public void setTransform(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    this.transform.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat8, paramFloat8);
    this.scale.set(paramFloat8, paramFloat8, paramFloat8);
  }

  public void setTransform(Matrix4 paramMatrix4)
  {
    this.transform.set(paramMatrix4);
    paramMatrix4.getScale(this.scale);
  }

  public void setTranslation(Vector3 paramVector3)
  {
    this.transform.setTranslation(paramVector3);
  }

  public void start()
  {
    this.emitter.start();
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).start();
  }

  public void translate(Vector3 paramVector3)
  {
    this.transform.translate(paramVector3);
  }

  public void update()
  {
    this.emitter.update();
    Iterator localIterator = this.influencers.iterator();
    while (localIterator.hasNext())
      ((Influencer)localIterator.next()).update();
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("name", this.name);
    paramJson.writeValue("emitter", this.emitter, Emitter.class);
    paramJson.writeValue("influencers", this.influencers, Array.class, Influencer.class);
    paramJson.writeValue("renderer", this.renderer, ParticleControllerRenderer.class);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleController
 * JD-Core Version:    0.6.0
 */