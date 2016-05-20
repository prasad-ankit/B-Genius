package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;

public class DynamicsModifier$Rotational2D extends DynamicsModifier.Strength
{
  ParallelArray.FloatChannel rotationalVelocity2dChannel;

  public DynamicsModifier$Rotational2D()
  {
  }

  public DynamicsModifier$Rotational2D(Rotational2D paramRotational2D)
  {
    super(paramRotational2D);
  }

  public void allocateChannels()
  {
    super.allocateChannels();
    this.rotationalVelocity2dChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.AngularVelocity2D));
  }

  public Rotational2D copy()
  {
    return new Rotational2D(this);
  }

  public void update()
  {
    int i = 0;
    int j = 2;
    int k = 0 + this.controller.particles.size * this.rotationalVelocity2dChannel.strideSize;
    int m = 0;
    while (m < k)
    {
      float[] arrayOfFloat = this.rotationalVelocity2dChannel.data;
      arrayOfFloat[m] += this.strengthChannel.data[i] + this.strengthChannel.data[(i + 1)] * this.strengthValue.getScale(this.lifeChannel.data[j]);
      i += this.strengthChannel.strideSize;
      m += this.rotationalVelocity2dChannel.strideSize;
      j += this.lifeChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier.Rotational2D
 * JD-Core Version:    0.6.0
 */