package com.badlogic.gdx.graphics.g3d.particles.renderers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ParticleControllerControllerRenderer extends ParticleControllerRenderer
{
  ParallelArray.ObjectChannel controllerChannel;

  public ParticleControllerComponent copy()
  {
    return new ParticleControllerControllerRenderer();
  }

  public void init()
  {
    this.controllerChannel = ((ParallelArray.ObjectChannel)this.controller.particles.getChannel(ParticleChannels.ParticleController));
    if (this.controllerChannel == null)
      throw new GdxRuntimeException("ParticleController channel not found, specify an influencer which will allocate it please.");
  }

  public boolean isCompatible(ParticleBatch paramParticleBatch)
  {
    return false;
  }

  public void update()
  {
    int i = this.controller.particles.size;
    for (int j = 0; j < i; j++)
      ((ParticleController[])this.controllerChannel.data)[j].draw();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerControllerRenderer
 * JD-Core Version:    0.6.0
 */