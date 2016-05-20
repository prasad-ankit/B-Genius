package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class DynamicsModifier$Strength extends DynamicsModifier
{
  protected ParallelArray.FloatChannel strengthChannel;
  public ScaledNumericValue strengthValue = new ScaledNumericValue();

  public DynamicsModifier$Strength()
  {
  }

  public DynamicsModifier$Strength(Strength paramStrength)
  {
    super(paramStrength);
    this.strengthValue.load(paramStrength.strengthValue);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.strengthChannel.strideSize;
    int j = i + paramInt2 * this.strengthChannel.strideSize;
    int k = i;
    while (k < j)
    {
      float f1 = this.strengthValue.newLowValue();
      float f2 = this.strengthValue.newHighValue();
      if (!this.strengthValue.isRelative())
        f2 -= f1;
      this.strengthChannel.data[k] = f1;
      this.strengthChannel.data[(k + 1)] = f2;
      k += this.strengthChannel.strideSize;
    }
  }

  public void allocateChannels()
  {
    super.allocateChannels();
    ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
    this.strengthChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation));
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    super.read(paramJson, paramJsonValue);
    this.strengthValue = ((ScaledNumericValue)paramJson.readValue("strengthValue", ScaledNumericValue.class, paramJsonValue));
  }

  public void write(Json paramJson)
  {
    super.write(paramJson);
    paramJson.writeValue("strengthValue", this.strengthValue);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier.Strength
 * JD-Core Version:    0.6.0
 */