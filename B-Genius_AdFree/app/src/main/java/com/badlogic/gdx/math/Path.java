package com.badlogic.gdx.math;

public abstract interface Path
{
  public abstract float approxLength(int paramInt);

  public abstract float approximate(Object paramObject);

  public abstract Object derivativeAt(Object paramObject, float paramFloat);

  public abstract float locate(Object paramObject);

  public abstract Object valueAt(Object paramObject, float paramFloat);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Path
 * JD-Core Version:    0.6.0
 */