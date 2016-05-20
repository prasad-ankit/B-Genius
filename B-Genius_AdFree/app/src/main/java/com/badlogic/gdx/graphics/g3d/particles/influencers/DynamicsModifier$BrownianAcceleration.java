package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class DynamicsModifier$BrownianAcceleration extends DynamicsModifier.Strength
{
  ParallelArray.FloatChannel accelerationChannel;

  public DynamicsModifier$BrownianAcceleration()
  {
  }

  public DynamicsModifier$BrownianAcceleration(BrownianAcceleration paramBrownianAcceleration)
  {
    super(paramBrownianAcceleration);
  }

  public void allocateChannels()
  {
    super.allocateChannels();
    this.accelerationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration));
  }

  public BrownianAcceleration copy()
  {
    return new BrownianAcceleration(this);
  }

  public void update()
  {
    int i = 0;
    int j = this.controller.particles.size;
    int k = 0;
    int m = 2;
    int n = 0;
    while (i < j)
    {
      float f = this.strengthChannel.data[k] + this.strengthChannel.data[(k + 1)] * this.strengthValue.getScale(this.lifeChannel.data[m]);
      TMP_V3.set(MathUtils.random(-1.0F, 1.0F), MathUtils.random(-1.0F, 1.0F), MathUtils.random(-1.0F, 1.0F)).nor().scl(f);
      float[] arrayOfFloat1 = this.accelerationChannel.data;
      arrayOfFloat1[n] += TMP_V3.x;
      float[] arrayOfFloat2 = this.accelerationChannel.data;
      int i1 = n + 1;
      arrayOfFloat2[i1] += TMP_V3.y;
      float[] arrayOfFloat3 = this.accelerationChannel.data;
      int i2 = n + 2;
      arrayOfFloat3[i2] += TMP_V3.z;
      i++;
      k += this.strengthChannel.strideSize;
      n += this.accelerationChannel.strideSize;
      m += this.lifeChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier.BrownianAcceleration
 * JD-Core Version:    0.6.0
 */