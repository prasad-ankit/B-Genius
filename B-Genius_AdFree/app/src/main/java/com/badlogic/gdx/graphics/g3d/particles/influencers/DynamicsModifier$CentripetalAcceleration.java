package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class DynamicsModifier$CentripetalAcceleration extends DynamicsModifier.Strength
{
  ParallelArray.FloatChannel accelerationChannel;
  ParallelArray.FloatChannel positionChannel;

  public DynamicsModifier$CentripetalAcceleration()
  {
  }

  public DynamicsModifier$CentripetalAcceleration(CentripetalAcceleration paramCentripetalAcceleration)
  {
    super(paramCentripetalAcceleration);
  }

  public void allocateChannels()
  {
    super.allocateChannels();
    this.accelerationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration));
    this.positionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position));
  }

  public CentripetalAcceleration copy()
  {
    return new CentripetalAcceleration(this);
  }

  public void update()
  {
    int i = 0;
    float f3;
    float f2;
    float f1;
    if (!this.isGlobal)
    {
      float[] arrayOfFloat4 = this.controller.transform.val;
      f3 = arrayOfFloat4[12];
      f2 = arrayOfFloat4[13];
      f1 = arrayOfFloat4[14];
    }
    while (true)
    {
      int j = this.controller.particles.size;
      int k = 0;
      int m = 0;
      int n = 2;
      int i1 = 0;
      while (i < j)
      {
        float f4 = this.strengthChannel.data[m] + this.strengthChannel.data[(m + 1)] * this.strengthValue.getScale(this.lifeChannel.data[n]);
        TMP_V3.set(this.positionChannel.data[k] - f3, this.positionChannel.data[(k + 1)] - f2, this.positionChannel.data[(k + 2)] - f1).nor().scl(f4);
        float[] arrayOfFloat1 = this.accelerationChannel.data;
        arrayOfFloat1[i1] += TMP_V3.x;
        float[] arrayOfFloat2 = this.accelerationChannel.data;
        int i2 = i1 + 1;
        arrayOfFloat2[i2] += TMP_V3.y;
        float[] arrayOfFloat3 = this.accelerationChannel.data;
        int i3 = i1 + 2;
        arrayOfFloat3[i3] += TMP_V3.z;
        i++;
        k += this.positionChannel.strideSize;
        m += this.strengthChannel.strideSize;
        i1 += this.accelerationChannel.strideSize;
        n += this.lifeChannel.strideSize;
      }
      return;
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier.CentripetalAcceleration
 * JD-Core Version:    0.6.0
 */