package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.values.GradientColorValue;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class ColorInfluencer$Single extends ColorInfluencer
{
  ParallelArray.FloatChannel alphaInterpolationChannel;
  public ScaledNumericValue alphaValue = new ScaledNumericValue();
  public GradientColorValue colorValue = new GradientColorValue();
  ParallelArray.FloatChannel lifeChannel;

  public ColorInfluencer$Single()
  {
    this.alphaValue.setHigh(1.0F);
  }

  public ColorInfluencer$Single(Single paramSingle)
  {
    this();
    set(paramSingle);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.colorChannel.strideSize;
    int j = paramInt1 * this.alphaInterpolationChannel.strideSize;
    int k = 2 + paramInt1 * this.lifeChannel.strideSize;
    int m = i + paramInt2 * this.colorChannel.strideSize;
    while (i < m)
    {
      float f1 = this.alphaValue.newLowValue();
      float f2 = this.alphaValue.newHighValue() - f1;
      this.colorValue.getColor(0.0F, this.colorChannel.data, i);
      this.colorChannel.data[(i + 3)] = (f1 + f2 * this.alphaValue.getScale(this.lifeChannel.data[k]));
      this.alphaInterpolationChannel.data[j] = f1;
      this.alphaInterpolationChannel.data[(j + 1)] = f2;
      i += this.colorChannel.strideSize;
      j += this.alphaInterpolationChannel.strideSize;
      k += this.lifeChannel.strideSize;
    }
  }

  public void allocateChannels()
  {
    super.allocateChannels();
    ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
    this.alphaInterpolationChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation));
    this.lifeChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life));
  }

  public Single copy()
  {
    return new Single(this);
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.alphaValue = ((ScaledNumericValue)paramJson.readValue("alpha", ScaledNumericValue.class, paramJsonValue));
    this.colorValue = ((GradientColorValue)paramJson.readValue("color", GradientColorValue.class, paramJsonValue));
  }

  public void set(Single paramSingle)
  {
    this.colorValue.load(paramSingle.colorValue);
    this.alphaValue.load(paramSingle.alphaValue);
  }

  public void update()
  {
    int i = 0;
    int j = 2;
    int k = 0 + this.controller.particles.size * this.colorChannel.strideSize;
    int m = 0;
    while (m < k)
    {
      float f = this.lifeChannel.data[j];
      this.colorValue.getColor(f, this.colorChannel.data, m);
      this.colorChannel.data[(m + 3)] = (this.alphaInterpolationChannel.data[i] + this.alphaInterpolationChannel.data[(i + 1)] * this.alphaValue.getScale(f));
      m += this.colorChannel.strideSize;
      i += this.alphaInterpolationChannel.strideSize;
      j += this.lifeChannel.strideSize;
    }
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("alpha", this.alphaValue);
    paramJson.writeValue("color", this.colorValue);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer.Single
 * JD-Core Version:    0.6.0
 */