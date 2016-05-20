package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class DynamicsModifier$Angular extends DynamicsModifier.Strength
{
  protected ParallelArray.FloatChannel angularChannel;
  public ScaledNumericValue phiValue = new ScaledNumericValue();
  public ScaledNumericValue thetaValue = new ScaledNumericValue();

  public DynamicsModifier$Angular()
  {
  }

  public DynamicsModifier$Angular(Angular paramAngular)
  {
    super(paramAngular);
    this.thetaValue.load(paramAngular.thetaValue);
    this.phiValue.load(paramAngular.phiValue);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    super.activateParticles(paramInt1, paramInt2);
    int i = paramInt1 * this.angularChannel.strideSize;
    int j = i + paramInt2 * this.angularChannel.strideSize;
    int k = i;
    while (k < j)
    {
      float f1 = this.thetaValue.newLowValue();
      float f2 = this.thetaValue.newHighValue();
      if (!this.thetaValue.isRelative())
        f2 -= f1;
      this.angularChannel.data[k] = f1;
      this.angularChannel.data[(k + 1)] = f2;
      float f3 = this.phiValue.newLowValue();
      float f4 = this.phiValue.newHighValue();
      if (!this.phiValue.isRelative())
        f4 -= f3;
      this.angularChannel.data[(k + 2)] = f3;
      this.angularChannel.data[(k + 3)] = f4;
      k += this.angularChannel.strideSize;
    }
  }

  public void allocateChannels()
  {
    super.allocateChannels();
    ParticleChannels.Interpolation4.id = this.controller.particleChannels.newId();
    this.angularChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation4));
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    super.read(paramJson, paramJsonValue);
    this.thetaValue = ((ScaledNumericValue)paramJson.readValue("thetaValue", ScaledNumericValue.class, paramJsonValue));
    this.phiValue = ((ScaledNumericValue)paramJson.readValue("phiValue", ScaledNumericValue.class, paramJsonValue));
  }

  public void write(Json paramJson)
  {
    super.write(paramJson);
    paramJson.writeValue("thetaValue", this.thetaValue);
    paramJson.writeValue("phiValue", this.phiValue);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier.Angular
 * JD-Core Version:    0.6.0
 */