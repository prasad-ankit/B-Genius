package com.badlogic.gdx.graphics.g3d.particles;

public class ParticleChannels$Rotation2dInitializer
  implements ParallelArray.ChannelInitializer
{
  private static Rotation2dInitializer instance;

  public static Rotation2dInitializer get()
  {
    if (instance == null)
      instance = new Rotation2dInitializer();
    return instance;
  }

  public void init(ParallelArray.FloatChannel paramFloatChannel)
  {
    int i = 0;
    int j = paramFloatChannel.data.length;
    while (i < j)
    {
      paramFloatChannel.data[i] = 1.0F;
      paramFloatChannel.data[(i + 1)] = 0.0F;
      i += paramFloatChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.Rotation2dInitializer
 * JD-Core Version:    0.6.0
 */