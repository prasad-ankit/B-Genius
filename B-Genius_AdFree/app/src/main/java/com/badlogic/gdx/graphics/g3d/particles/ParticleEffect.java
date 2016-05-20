package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import java.util.Iterator;

public class ParticleEffect
  implements ResourceData.Configurable, Disposable
{
  private BoundingBox bounds;
  private Array controllers;

  public ParticleEffect()
  {
    this.controllers = new Array(true, 3, ParticleController.class);
  }

  public ParticleEffect(ParticleEffect paramParticleEffect)
  {
    this.controllers = new Array(true, paramParticleEffect.controllers.size);
    int i = paramParticleEffect.controllers.size;
    for (int j = 0; j < i; j++)
      this.controllers.add(((ParticleController)paramParticleEffect.controllers.get(j)).copy());
  }

  public ParticleEffect(ParticleController[] paramArrayOfParticleController)
  {
    this.controllers = new Array(paramArrayOfParticleController);
  }

  public ParticleEffect copy()
  {
    return new ParticleEffect(this);
  }

  public void dispose()
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).dispose();
  }

  public void draw()
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).draw();
  }

  public void end()
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).end();
  }

  public ParticleController findController(String paramString)
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
    {
      ParticleController localParticleController = (ParticleController)this.controllers.get(j);
      if (localParticleController.name.equals(paramString))
        return localParticleController;
    }
    return null;
  }

  public BoundingBox getBoundingBox()
  {
    if (this.bounds == null)
      this.bounds = new BoundingBox();
    BoundingBox localBoundingBox = this.bounds;
    localBoundingBox.inf();
    Iterator localIterator = this.controllers.iterator();
    while (localIterator.hasNext())
      localBoundingBox.ext(((ParticleController)localIterator.next()).getBoundingBox());
    return localBoundingBox;
  }

  public Array getControllers()
  {
    return this.controllers;
  }

  public void init()
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).init();
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    Iterator localIterator = this.controllers.iterator();
    while (localIterator.hasNext())
      ((ParticleController)localIterator.next()).load(paramAssetManager, paramResourceData);
  }

  public void reset()
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).reset();
  }

  public void rotate(Quaternion paramQuaternion)
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).rotate(paramQuaternion);
  }

  public void rotate(Vector3 paramVector3, float paramFloat)
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).rotate(paramVector3, paramFloat);
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    Iterator localIterator = this.controllers.iterator();
    while (localIterator.hasNext())
      ((ParticleController)localIterator.next()).save(paramAssetManager, paramResourceData);
  }

  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).scale(paramFloat1, paramFloat2, paramFloat3);
  }

  public void scale(Vector3 paramVector3)
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).scale(paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public void setBatch(Array paramArray)
  {
    Iterator localIterator1 = this.controllers.iterator();
    label68: 
    while (localIterator1.hasNext())
    {
      ParticleController localParticleController = (ParticleController)localIterator1.next();
      Iterator localIterator2 = paramArray.iterator();
      while (true)
      {
        if (!localIterator2.hasNext())
          break label68;
        ParticleBatch localParticleBatch = (ParticleBatch)localIterator2.next();
        if (localParticleController.renderer.setBatch(localParticleBatch))
          break;
      }
    }
  }

  public void setTransform(Matrix4 paramMatrix4)
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).setTransform(paramMatrix4);
  }

  public void start()
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).start();
  }

  public void translate(Vector3 paramVector3)
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).translate(paramVector3);
  }

  public void update()
  {
    int i = this.controllers.size;
    for (int j = 0; j < i; j++)
      ((ParticleController)this.controllers.get(j)).update();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleEffect
 * JD-Core Version:    0.6.0
 */