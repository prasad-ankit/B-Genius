package com.badlogic.gdx.graphics.g3d.particles.renderers;

import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;

public abstract class ParticleControllerRenderer extends ParticleControllerComponent
{
  protected ParticleBatch batch;
  protected ParticleControllerRenderData renderData;

  protected ParticleControllerRenderer()
  {
  }

  protected ParticleControllerRenderer(ParticleControllerRenderData paramParticleControllerRenderData)
  {
    this.renderData = paramParticleControllerRenderData;
  }

  public abstract boolean isCompatible(ParticleBatch paramParticleBatch);

  public void set(ParticleController paramParticleController)
  {
    super.set(paramParticleController);
    if (this.renderData != null)
      this.renderData.controller = this.controller;
  }

  public boolean setBatch(ParticleBatch paramParticleBatch)
  {
    if (isCompatible(paramParticleBatch))
    {
      this.batch = paramParticleBatch;
      return true;
    }
    return false;
  }

  public void update()
  {
    this.batch.draw(this.renderData);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderer
 * JD-Core Version:    0.6.0
 */