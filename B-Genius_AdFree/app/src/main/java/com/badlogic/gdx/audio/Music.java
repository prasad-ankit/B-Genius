package com.badlogic.gdx.audio;

import com.badlogic.gdx.utils.Disposable;

public abstract interface Music extends Disposable
{
  public abstract void dispose();

  public abstract float getPosition();

  public abstract float getVolume();

  public abstract boolean isLooping();

  public abstract boolean isPlaying();

  public abstract void pause();

  public abstract void play();

  public abstract void setLooping(boolean paramBoolean);

  public abstract void setOnCompletionListener(Music.OnCompletionListener paramOnCompletionListener);

  public abstract void setPan(float paramFloat1, float paramFloat2);

  public abstract void setPosition(float paramFloat);

  public abstract void setVolume(float paramFloat);

  public abstract void stop();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.audio.Music
 * JD-Core Version:    0.6.0
 */