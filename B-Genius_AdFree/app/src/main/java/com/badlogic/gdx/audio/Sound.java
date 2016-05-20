package com.badlogic.gdx.audio;

import com.badlogic.gdx.utils.Disposable;

public abstract interface Sound extends Disposable
{
  public abstract void dispose();

  public abstract long loop();

  public abstract long loop(float paramFloat);

  public abstract long loop(float paramFloat1, float paramFloat2, float paramFloat3);

  public abstract void pause();

  public abstract void pause(long paramLong);

  public abstract long play();

  public abstract long play(float paramFloat);

  public abstract long play(float paramFloat1, float paramFloat2, float paramFloat3);

  public abstract void resume();

  public abstract void resume(long paramLong);

  public abstract void setLooping(long paramLong, boolean paramBoolean);

  public abstract void setPan(long paramLong, float paramFloat1, float paramFloat2);

  public abstract void setPitch(long paramLong, float paramFloat);

  public abstract void setPriority(long paramLong, int paramInt);

  public abstract void setVolume(long paramLong, float paramFloat);

  public abstract void stop();

  public abstract void stop(long paramLong);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.audio.Sound
 * JD-Core Version:    0.6.0
 */