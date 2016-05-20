package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class DynamicsModifier$Rotational3D extends DynamicsModifier.Angular
{
  ParallelArray.FloatChannel rotationChannel;
  ParallelArray.FloatChannel rotationalForceChannel;

  public DynamicsModifier$Rotational3D()
  {
  }

  public DynamicsModifier$Rotational3D(Rotational3D paramRotational3D)
  {
    super(paramRotational3D);
  }

  public void allocateChannels()
  {
    super.allocateChannels();
    this.rotationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D));
    this.rotationalForceChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.AngularVelocity3D));
  }

  public Rotational3D copy()
  {
    return new Rotational3D(this);
  }

  public void update()
  {
    int i = 0;
    int j = this.controller.particles.size * this.rotationalForceChannel.strideSize;
    int k = 2;
    int m = 0;
    int n = 0;
    while (m < j)
    {
      float f1 = this.lifeChannel.data[k];
      float f2 = this.strengthChannel.data[n] + this.strengthChannel.data[(n + 1)] * this.strengthValue.getScale(f1);
      float f3 = this.angularChannel.data[(i + 2)] + this.angularChannel.data[(i + 3)] * this.phiValue.getScale(f1);
      float f4 = this.angularChannel.data[i] + this.angularChannel.data[(i + 1)] * this.thetaValue.getScale(f1);
      float f5 = MathUtils.cosDeg(f4);
      float f6 = MathUtils.sinDeg(f4);
      float f7 = MathUtils.cosDeg(f3);
      float f8 = MathUtils.sinDeg(f3);
      TMP_V3.set(f5 * f8, f7, f6 * f8);
      TMP_V3.scl(f2 * 0.01745329F);
      float[] arrayOfFloat1 = this.rotationalForceChannel.data;
      arrayOfFloat1[m] += TMP_V3.x;
      float[] arrayOfFloat2 = this.rotationalForceChannel.data;
      int i1 = m + 1;
      arrayOfFloat2[i1] += TMP_V3.y;
      float[] arrayOfFloat3 = this.rotationalForceChannel.data;
      int i2 = m + 2;
      arrayOfFloat3[i2] += TMP_V3.z;
      n += this.strengthChannel.strideSize;
      m += this.rotationalForceChannel.strideSize;
      i += this.angularChannel.strideSize;
      k += this.lifeChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier.Rotational3D
 * JD-Core Version:    0.6.0
 */