package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.emitters.Emitter;

public class ParticleControllerInfluencer$Random extends ParticleControllerInfluencer
{
  ParticleControllerInfluencer.Random.ParticleControllerPool pool = new ParticleControllerInfluencer.Random.ParticleControllerPool(this);

  public ParticleControllerInfluencer$Random()
  {
  }

  public ParticleControllerInfluencer$Random(Random paramRandom)
  {
    super(paramRandom);
  }

  public ParticleControllerInfluencer$Random(ParticleController[] paramArrayOfParticleController)
  {
    super(paramArrayOfParticleController);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      ParticleController localParticleController = (ParticleController)this.pool.obtain();
      localParticleController.start();
      ((ParticleController[])this.particleControllerChannel.data)[paramInt1] = localParticleController;
      paramInt1++;
    }
  }

  public Random copy()
  {
    return new Random(this);
  }

  public void dispose()
  {
    this.pool.clear();
    super.dispose();
  }

  public void init()
  {
    this.pool.clear();
    for (int i = 0; i < this.controller.emitter.maxParticleCount; i++)
      this.pool.free(this.pool.newObject());
  }

  public void killParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      ParticleController localParticleController = ((ParticleController[])this.particleControllerChannel.data)[paramInt1];
      localParticleController.end();
      this.pool.free(localParticleController);
      ((ParticleController[])this.particleControllerChannel.data)[paramInt1] = null;
      paramInt1++;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ParticleControllerInfluencer.Random
 * JD-Core Version:    0.6.0
 */