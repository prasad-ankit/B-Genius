package com.badlogic.gdx.graphics;

public abstract interface CubemapData
{
  public abstract void consumeCubemapData();

  public abstract int getHeight();

  public abstract int getWidth();

  public abstract boolean isManaged();

  public abstract boolean isPrepared();

  public abstract void prepare();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.CubemapData
 * JD-Core Version:    0.6.0
 */