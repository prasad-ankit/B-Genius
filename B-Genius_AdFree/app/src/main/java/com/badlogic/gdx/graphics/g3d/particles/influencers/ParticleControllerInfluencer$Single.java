package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.utils.Array;

public class ParticleControllerInfluencer$Single extends ParticleControllerInfluencer
{
  public ParticleControllerInfluencer$Single()
  {
  }

  public ParticleControllerInfluencer$Single(Single paramSingle)
  {
    super(paramSingle);
  }

  public ParticleControllerInfluencer$Single(ParticleController[] paramArrayOfParticleController)
  {
    super(paramArrayOfParticleController);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      ((ParticleController[])this.particleControllerChannel.data)[paramInt1].start();
      paramInt1++;
    }
  }

  public Single copy()
  {
    return new Single(this);
  }

  public void init()
  {
    ParticleController localParticleController1 = (ParticleController)this.templates.first();
    int i = this.controller.particles.capacity;
    for (int j = 0; j < i; j++)
    {
      ParticleController localParticleController2 = localParticleController1.copy();
      localParticleController2.init();
      ((ParticleController[])this.particleControllerChannel.data)[j] = localParticleController2;
    }
  }

  public void killParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      ((ParticleController[])this.particleControllerChannel.data)[paramInt1].end();
      paramInt1++;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ParticleControllerInfluencer.Single
 * JD-Core Version:    0.6.0
 */