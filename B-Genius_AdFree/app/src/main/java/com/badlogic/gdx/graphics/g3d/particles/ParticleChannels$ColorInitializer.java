package com.badlogic.gdx.graphics.g3d.particles;

import java.util.Arrays;

public class ParticleChannels$ColorInitializer
  implements ParallelArray.ChannelInitializer
{
  private static ColorInitializer instance;

  public static ColorInitializer get()
  {
    if (instance == null)
      instance = new ColorInitializer();
    return instance;
  }

  public void init(ParallelArray.FloatChannel paramFloatChannel)
  {
    Arrays.fill(paramFloatChannel.data, 0, paramFloatChannel.data.length, 1.0F);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.ColorInitializer
 * JD-Core Version:    0.6.0
 */