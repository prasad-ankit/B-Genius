package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ChannelDescriptor;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class SimpleInfluencer extends Influencer
{
  ParallelArray.FloatChannel interpolationChannel;
  ParallelArray.FloatChannel lifeChannel;
  public ScaledNumericValue value = new ScaledNumericValue();
  ParallelArray.FloatChannel valueChannel;
  ParallelArray.ChannelDescriptor valueChannelDescriptor;

  public SimpleInfluencer()
  {
    this.value.setHigh(1.0F);
  }

  public SimpleInfluencer(SimpleInfluencer paramSimpleInfluencer)
  {
    this();
    set(paramSimpleInfluencer);
  }

  private void set(SimpleInfluencer paramSimpleInfluencer)
  {
    this.value.load(paramSimpleInfluencer.value);
    this.valueChannelDescriptor = paramSimpleInfluencer.valueChannelDescriptor;
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    if (!this.value.isRelative())
    {
      int m = paramInt1 * this.valueChannel.strideSize;
      int n = paramInt1 * this.interpolationChannel.strideSize;
      int i1 = m + paramInt2 * this.valueChannel.strideSize;
      while (m < i1)
      {
        float f3 = this.value.newLowValue();
        float f4 = this.value.newHighValue() - f3;
        this.interpolationChannel.data[n] = f3;
        this.interpolationChannel.data[(n + 1)] = f4;
        this.valueChannel.data[m] = (f3 + f4 * this.value.getScale(0.0F));
        m += this.valueChannel.strideSize;
        n += this.interpolationChannel.strideSize;
      }
    }
    int i = paramInt1 * this.valueChannel.strideSize;
    int j = paramInt1 * this.interpolationChannel.strideSize;
    int k = i + paramInt2 * this.valueChannel.strideSize;
    while (i < k)
    {
      float f1 = this.value.newLowValue();
      float f2 = this.value.newHighValue();
      this.interpolationChannel.data[j] = f1;
      this.interpolationChannel.data[(j + 1)] = f2;
      this.valueChannel.data[i] = (f1 + f2 * this.value.getScale(0.0F));
      i += this.valueChannel.strideSize;
      j += this.interpolationChannel.strideSize;
    }
  }

  public void allocateChannels()
  {
    this.valueChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(this.valueChannelDescriptor));
    ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
    this.interpolationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation));
    this.lifeChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life));
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.value = ((ScaledNumericValue)paramJson.readValue("value", ScaledNumericValue.class, paramJsonValue));
  }

  public void update()
  {
    int i = 0;
    int j = 2;
    int k = 0 + this.controller.particles.size * this.valueChannel.strideSize;
    int m = 0;
    while (m < k)
    {
      this.valueChannel.data[m] = (this.interpolationChannel.data[i] + this.interpolationChannel.data[(i + 1)] * this.value.getScale(this.lifeChannel.data[j]));
      m += this.valueChannel.strideSize;
      i += this.interpolationChannel.strideSize;
      j += this.lifeChannel.strideSize;
    }
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("value", this.value);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.SimpleInfluencer
 * JD-Core Version:    0.6.0
 */