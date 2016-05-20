package com.badlogic.gdx.math;

public class Interpolation$Elastic extends Interpolation
{
  final float bounces;
  final float power;
  final float scale;
  final float value;

  public Interpolation$Elastic(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    this.value = paramFloat1;
    this.power = paramFloat2;
    this.scale = paramFloat3;
    float f = 3.141593F * paramInt;
    if (paramInt % 2 == 0);
    for (int i = 1; ; i = -1)
    {
      this.bounces = (f * i);
      return;
    }
  }

  public float apply(float paramFloat)
  {
    if (paramFloat <= 0.5F)
    {
      float f2 = paramFloat * 2.0F;
      return (float)Math.pow(this.value, this.power * (f2 - 1.0F)) * MathUtils.sin(f2 * this.bounces) * this.scale / 2.0F;
    }
    float f1 = 2.0F * (1.0F - paramFloat);
    return 1.0F - (float)Math.pow(this.value, this.power * (f1 - 1.0F)) * MathUtils.sin(f1 * this.bounces) * this.scale / 2.0F;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Interpolation.Elastic
 * JD-Core Version:    0.6.0
 */