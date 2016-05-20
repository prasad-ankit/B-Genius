package com.badlogic.gdx.graphics.g3d.particles;

public class ParticleChannels$Rotation3dInitializer
  implements ParallelArray.ChannelInitializer
{
  private static Rotation3dInitializer instance;

  public static Rotation3dInitializer get()
  {
    if (instance == null)
      instance = new Rotation3dInitializer();
    return instance;
  }

  public void init(ParallelArray.FloatChannel paramFloatChannel)
  {
    int i = 0;
    int j = paramFloatChannel.data.length;
    while (i < j)
    {
      float[] arrayOfFloat1 = paramFloatChannel.data;
      float[] arrayOfFloat2 = paramFloatChannel.data;
      int k = i + 1;
      paramFloatChannel.data[(i + 2)] = 0.0F;
      arrayOfFloat2[k] = 0.0F;
      arrayOfFloat1[i] = 0.0F;
      paramFloatChannel.data[(i + 3)] = 1.0F;
      i += paramFloatChannel.strideSize;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.Rotation3dInitializer
 * JD-Core Version:    0.6.0
 */