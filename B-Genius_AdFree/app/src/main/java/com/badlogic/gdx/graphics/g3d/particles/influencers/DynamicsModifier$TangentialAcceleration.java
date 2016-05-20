package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class DynamicsModifier$TangentialAcceleration extends DynamicsModifier.Angular
{
  ParallelArray.FloatChannel directionalVelocityChannel;
  ParallelArray.FloatChannel positionChannel;

  public DynamicsModifier$TangentialAcceleration()
  {
  }

  public DynamicsModifier$TangentialAcceleration(TangentialAcceleration paramTangentialAcceleration)
  {
    super(paramTangentialAcceleration);
  }

  public void allocateChannels()
  {
    super.allocateChannels();
    this.directionalVelocityChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration));
    this.positionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position));
  }

  public TangentialAcceleration copy()
  {
    return new TangentialAcceleration(this);
  }

  public void update()
  {
    int i = 0;
    int j = 0 + this.controller.particles.size * this.directionalVelocityChannel.strideSize;
    int k = 0;
    int m = 2;
    int n = 0;
    int i1 = 0;
    while (n < j)
    {
      float f1 = this.lifeChannel.data[m];
      float f2 = this.strengthChannel.data[k] + this.strengthChannel.data[(k + 1)] * this.strengthValue.getScale(f1);
      float f3 = this.angularChannel.data[(i1 + 2)] + this.angularChannel.data[(i1 + 3)] * this.phiValue.getScale(f1);
      float f4 = this.angularChannel.data[i1] + this.angularChannel.data[(i1 + 1)] * this.thetaValue.getScale(f1);
      float f5 = MathUtils.cosDeg(f4);
      float f6 = MathUtils.sinDeg(f4);
      float f7 = MathUtils.cosDeg(f3);
      float f8 = MathUtils.sinDeg(f3);
      TMP_V3.set(f5 * f8, f7, f6 * f8).crs(this.positionChannel.data[i], this.positionChannel.data[(i + 1)], this.positionChannel.data[(i + 2)]).nor().scl(f2);
      float[] arrayOfFloat1 = this.directionalVelocityChannel.data;
      arrayOfFloat1[n] += TMP_V3.x;
      float[] arrayOfFloat2 = this.directionalVelocityChannel.data;
      int i2 = n + 1;
      arrayOfFloat2[i2] += TMP_V3.y;
      float[] arrayOfFloat3 = this.directionalVelocityChannel.data;
      int i3 = n + 2;
      arrayOfFloat3[i3] += TMP_V3.z;
      k += this.strengthChannel.strideSize;
      n += this.directionalVelocityChannel.strideSize;
      i1 += this.angularChannel.strideSize;
      m += this.lifeChannel.strideSize;
      i += this.positionChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier.TangentialAcceleration
 * JD-Core Version:    0.6.0
 */