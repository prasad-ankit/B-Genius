package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

class ParticleControllerInfluencer$Random$ParticleControllerPool extends Pool
{
  public ParticleControllerInfluencer$Random$ParticleControllerPool(ParticleControllerInfluencer.Random paramRandom)
  {
  }

  public void clear()
  {
    int i = this.this$0.pool.getFree();
    for (int j = 0; j < i; j++)
      ((ParticleController)this.this$0.pool.obtain()).dispose();
    super.clear();
  }

  public ParticleController newObject()
  {
    ParticleController localParticleController = ((ParticleController)this.this$0.templates.random()).copy();
    localParticleController.init();
    return localParticleController;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ParticleControllerInfluencer.Random.ParticleControllerPool
 * JD-Core Version:    0.6.0
 */