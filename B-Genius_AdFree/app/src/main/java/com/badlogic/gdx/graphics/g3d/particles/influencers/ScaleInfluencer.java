package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.math.Vector3;

public class ScaleInfluencer extends SimpleInfluencer
{
  public ScaleInfluencer()
  {
    this.valueChannelDescriptor = ParticleChannels.Scale;
  }

  public ScaleInfluencer(ScaleInfluencer paramScaleInfluencer)
  {
    super(paramScaleInfluencer);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    if (this.value.isRelative())
    {
      int m = paramInt1 * this.valueChannel.strideSize;
      int n = paramInt1 * this.interpolationChannel.strideSize;
      int i1 = m + paramInt2 * this.valueChannel.strideSize;
      while (m < i1)
      {
        float f3 = this.value.newLowValue() * this.controller.scale.x;
        float f4 = this.value.newHighValue() * this.controller.scale.x;
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
      float f1 = this.value.newLowValue() * this.controller.scale.x;
      float f2 = this.value.newHighValue() * this.controller.scale.x - f1;
      this.interpolationChannel.data[j] = f1;
      this.interpolationChannel.data[(j + 1)] = f2;
      this.valueChannel.data[i] = (f1 + f2 * this.value.getScale(0.0F));
      i += this.valueChannel.strideSize;
      j += this.interpolationChannel.strideSize;
    }
  }

  public ParticleControllerComponent copy()
  {
    return new ScaleInfluencer(this);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ScaleInfluencer
 * JD-Core Version:    0.6.0
 */