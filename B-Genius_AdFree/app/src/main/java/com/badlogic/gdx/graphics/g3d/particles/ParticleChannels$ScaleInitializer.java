package com.badlogic.gdx.graphics.g3d.particles;

import java.util.Arrays;

public class ParticleChannels$ScaleInitializer
  implements ParallelArray.ChannelInitializer
{
  private static ScaleInitializer instance;

  public static ScaleInitializer get()
  {
    if (instance == null)
      instance = new ScaleInitializer();
    return instance;
  }

  public void init(ParallelArray.FloatChannel paramFloatChannel)
  {
    Arrays.fill(paramFloatChannel.data, 0, paramFloatChannel.data.length, 1.0F);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.ScaleInitializer
 * JD-Core Version:    0.6.0
 */