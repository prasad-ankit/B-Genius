package com.badlogic.gdx.backends.android;

import android.media.AudioTrack;
import com.badlogic.gdx.audio.AudioDevice;

class AndroidAudioDevice
  implements AudioDevice
{
  private short[] buffer = new short[1024];
  private final boolean isMono;
  private final int latency;
  private final AudioTrack track;

  AndroidAudioDevice(int paramInt, boolean paramBoolean)
  {
    this.isMono = paramBoolean;
    int k;
    int m;
    if (paramBoolean)
    {
      k = 4;
      m = AudioTrack.getMinBufferSize(paramInt, k, 2);
      if (paramBoolean)
        i = 4;
      this.track = new AudioTrack(3, paramInt, i, 2, m, j);
      this.track.play();
      if (!paramBoolean)
        break label92;
    }
    while (true)
    {
      this.latency = (m / j);
      return;
      k = i;
      break;
      label92: j = 2;
    }
  }

  public void dispose()
  {
    this.track.stop();
    this.track.release();
  }

  public int getLatency()
  {
    return this.latency;
  }

  public boolean isMono()
  {
    return this.isMono;
  }

  public void setVolume(float paramFloat)
  {
    this.track.setStereoVolume(paramFloat, paramFloat);
  }

  public void writeSamples(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (this.buffer.length < paramArrayOfFloat.length)
      this.buffer = new short[paramArrayOfFloat.length];
    int i = paramInt1 + paramInt2;
    for (int j = 0; paramInt1 < i; j++)
    {
      float f = paramArrayOfFloat[paramInt1];
      if (f > 1.0F)
        f = 1.0F;
      if (f < -1.0F)
        f = -1.0F;
      int m = (short)(int)(f * 32767.0F);
      this.buffer[j] = m;
      paramInt1++;
    }
    int k = this.track.write(this.buffer, 0, paramInt2);
    while (k != paramInt2)
      k += this.track.write(this.buffer, k, paramInt2 - k);
  }

  public void writeSamples(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int i = this.track.write(paramArrayOfShort, paramInt1, paramInt2);
    while (i != paramInt2)
      i += this.track.write(paramArrayOfShort, paramInt1 + i, paramInt2 - i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidAudioDevice
 * JD-Core Version:    0.6.0
 */