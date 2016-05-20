package com.badlogic.gdx.math;

public class Interpolation$ElasticOut extends Interpolation.Elastic
{
  public Interpolation$ElasticOut(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    super(paramFloat1, paramFloat2, paramInt, paramFloat3);
  }

  public float apply(float paramFloat)
  {
    float f = 1.0F - paramFloat;
    return 1.0F - (float)Math.pow(this.value, this.power * (f - 1.0F)) * MathUtils.sin(f * this.bounces) * this.scale;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Interpolation.ElasticOut
 * JD-Core Version:    0.6.0
 */