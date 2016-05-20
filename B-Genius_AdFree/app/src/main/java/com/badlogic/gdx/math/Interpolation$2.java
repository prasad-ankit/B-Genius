package com.badlogic.gdx.math;

final class Interpolation$2 extends Interpolation
{
  public final float apply(float paramFloat)
  {
    return MathUtils.clamp(paramFloat * (paramFloat * paramFloat) * (10.0F + paramFloat * (6.0F * paramFloat - 15.0F)), 0.0F, 1.0F);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Interpolation.2
 * JD-Core Version:    0.6.0
 */