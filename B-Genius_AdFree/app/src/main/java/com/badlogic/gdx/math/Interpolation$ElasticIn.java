package com.badlogic.gdx.math;

public class Interpolation$ElasticIn extends Interpolation.Elastic
{
  public Interpolation$ElasticIn(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    super(paramFloat1, paramFloat2, paramInt, paramFloat3);
  }

  public float apply(float paramFloat)
  {
    if (paramFloat >= 0.99D)
      return 1.0F;
    return (float)Math.pow(this.value, this.power * (paramFloat - 1.0F)) * MathUtils.sin(paramFloat * this.bounces) * this.scale;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Interpolation.ElasticIn
 * JD-Core Version:    0.6.0
 */