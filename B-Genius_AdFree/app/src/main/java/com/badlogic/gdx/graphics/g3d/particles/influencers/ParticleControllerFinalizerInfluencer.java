package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ParticleControllerFinalizerInfluencer extends Influencer
{
  ParallelArray.ObjectChannel controllerChannel;
  boolean hasRotation;
  boolean hasScale;
  ParallelArray.FloatChannel positionChannel;
  ParallelArray.FloatChannel rotationChannel;
  ParallelArray.FloatChannel scaleChannel;

  public void allocateChannels()
  {
    this.positionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position));
  }

  public ParticleControllerFinalizerInfluencer copy()
  {
    return new ParticleControllerFinalizerInfluencer();
  }

  public void init()
  {
    boolean bool1 = true;
    this.controllerChannel = ((ParallelArray.ObjectChannel)this.controller.particles.getChannel(ParticleChannels.ParticleController));
    if (this.controllerChannel == null)
      throw new GdxRuntimeException("ParticleController channel not found, specify an influencer which will allocate it please.");
    this.scaleChannel = ((ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Scale));
    this.rotationChannel = ((ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Rotation3D));
    boolean bool2;
    if (this.scaleChannel != null)
    {
      bool2 = bool1;
      this.hasScale = bool2;
      if (this.rotationChannel == null)
        break label111;
    }
    while (true)
    {
      this.hasRotation = bool1;
      return;
      bool2 = false;
      break;
      label111: bool1 = false;
    }
  }

  public void update()
  {
    int i = this.controller.particles.size;
    int j = 0;
    int k = 0;
    ParticleController localParticleController;
    float f1;
    label52: float f3;
    float f4;
    float f5;
    float f2;
    if (k < i)
    {
      localParticleController = ((ParticleController[])this.controllerChannel.data)[k];
      if (this.hasScale)
      {
        f1 = this.scaleChannel.data[k];
        if (!this.hasRotation)
          break label203;
        int n = k * this.rotationChannel.strideSize;
        f3 = this.rotationChannel.data[n];
        f4 = this.rotationChannel.data[(n + 1)];
        f5 = this.rotationChannel.data[(n + 2)];
        f2 = this.rotationChannel.data[(n + 3)];
      }
    }
    while (true)
    {
      localParticleController.setTransform(this.positionChannel.data[j], this.positionChannel.data[(j + 1)], this.positionChannel.data[(j + 2)], f3, f4, f5, f2, f1);
      localParticleController.update();
      int m = k + 1;
      j += this.positionChannel.strideSize;
      k = m;
      break;
      f1 = 1.0F;
      break label52;
      return;
      label203: f2 = 1.0F;
      f3 = 0.0F;
      f4 = 0.0F;
      f5 = 0.0F;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ParticleControllerFinalizerInfluencer
 * JD-Core Version:    0.6.0
 */