package com.badlogic.gdx.math;

public class Interpolation$PowIn extends Interpolation.Pow
{
  public Interpolation$PowIn(int paramInt)
  {
    super(paramInt);
  }

  public float apply(float paramFloat)
  {
    return (float)Math.pow(paramFloat, this.power);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Interpolation.PowIn
 * JD-Core Version:    0.6.0
 */