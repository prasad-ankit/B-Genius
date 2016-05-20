package com.badlogic.gdx.graphics.g3d.particles;

public class ParticleChannels$TextureRegionInitializer
  implements ParallelArray.ChannelInitializer
{
  private static TextureRegionInitializer instance;

  public static TextureRegionInitializer get()
  {
    if (instance == null)
      instance = new TextureRegionInitializer();
    return instance;
  }

  public void init(ParallelArray.FloatChannel paramFloatChannel)
  {
    int i = 0;
    int j = paramFloatChannel.data.length;
    while (i < j)
    {
      paramFloatChannel.data[i] = 0.0F;
      paramFloatChannel.data[(i + 1)] = 0.0F;
      paramFloatChannel.data[(i + 2)] = 1.0F;
      paramFloatChannel.data[(i + 3)] = 1.0F;
      paramFloatChannel.data[(i + 4)] = 0.5F;
      paramFloatChannel.data[(i + 5)] = 0.5F;
      i += paramFloatChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.TextureRegionInitializer
 * JD-Core Version:    0.6.0
 */