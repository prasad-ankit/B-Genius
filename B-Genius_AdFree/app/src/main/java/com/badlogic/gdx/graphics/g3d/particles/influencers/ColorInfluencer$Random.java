package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.math.MathUtils;

public class ColorInfluencer$Random extends ColorInfluencer
{
  ParallelArray.FloatChannel colorChannel;

  public void activateParticles(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.colorChannel.strideSize;
    int j = i + paramInt2 * this.colorChannel.strideSize;
    while (i < j)
    {
      this.colorChannel.data[i] = MathUtils.random();
      this.colorChannel.data[(i + 1)] = MathUtils.random();
      this.colorChannel.data[(i + 2)] = MathUtils.random();
      this.colorChannel.data[(i + 3)] = MathUtils.random();
      i += this.colorChannel.strideSize;
    }
  }

  public void allocateChannels()
  {
    this.colorChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Color));
  }

  public Random copy()
  {
    return new Random();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer.Random
 * JD-Core Version:    0.6.0
 */