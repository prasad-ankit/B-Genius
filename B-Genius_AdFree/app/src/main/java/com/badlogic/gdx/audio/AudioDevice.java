package com.badlogic.gdx.audio;

import com.badlogic.gdx.utils.Disposable;

public abstract interface AudioDevice extends Disposable
{
  public abstract void dispose();

  public abstract int getLatency();

  public abstract boolean isMono();

  public abstract void setVolume(float paramFloat);

  public abstract void writeSamples(float[] paramArrayOfFloat, int paramInt1, int paramInt2);

  public abstract void writeSamples(short[] paramArrayOfShort, int paramInt1, int paramInt2);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.audio.AudioDevice
 * JD-Core Version:    0.6.0
 */