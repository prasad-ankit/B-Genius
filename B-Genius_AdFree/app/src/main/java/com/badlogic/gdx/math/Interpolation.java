package com.badlogic.gdx.math;

public abstract class Interpolation
{
  public static final Interpolation.Bounce bounce;
  public static final Interpolation.BounceIn bounceIn;
  public static final Interpolation.BounceOut bounceOut;
  public static final Interpolation circle;
  public static final Interpolation circleIn;
  public static final Interpolation circleOut;
  public static final Interpolation.Elastic elastic;
  public static final Interpolation.ElasticIn elasticIn;
  public static final Interpolation.ElasticOut elasticOut;
  public static final Interpolation.Exp exp10;
  public static final Interpolation.ExpIn exp10In;
  public static final Interpolation.ExpOut exp10Out;
  public static final Interpolation.Exp exp5;
  public static final Interpolation.ExpIn exp5In;
  public static final Interpolation.ExpOut exp5Out;
  public static final Interpolation fade;
  public static final Interpolation linear = new Interpolation.1();
  public static final Interpolation.Pow pow2;
  public static final Interpolation.PowIn pow2In;
  public static final Interpolation.PowOut pow2Out;
  public static final Interpolation.Pow pow3;
  public static final Interpolation.PowIn pow3In;
  public static final Interpolation.PowOut pow3Out;
  public static final Interpolation.Pow pow4;
  public static final Interpolation.PowIn pow4In;
  public static final Interpolation.PowOut pow4Out;
  public static final Interpolation.Pow pow5;
  public static final Interpolation.PowIn pow5In;
  public static final Interpolation.PowOut pow5Out;
  public static final Interpolation sine;
  public static final Interpolation sineIn;
  public static final Interpolation sineOut;
  public static final Interpolation.Swing swing;
  public static final Interpolation.SwingIn swingIn;
  public static final Interpolation.SwingOut swingOut;

  static
  {
    fade = new Interpolation.2();
    pow2 = new Interpolation.Pow(2);
    pow2In = new Interpolation.PowIn(2);
    pow2Out = new Interpolation.PowOut(2);
    pow3 = new Interpolation.Pow(3);
    pow3In = new Interpolation.PowIn(3);
    pow3Out = new Interpolation.PowOut(3);
    pow4 = new Interpolation.Pow(4);
    pow4In = new Interpolation.PowIn(4);
    pow4Out = new Interpolation.PowOut(4);
    pow5 = new Interpolation.Pow(5);
    pow5In = new Interpolation.PowIn(5);
    pow5Out = new Interpolation.PowOut(5);
    sine = new Interpolation.3();
    sineIn = new Interpolation.4();
    sineOut = new Interpolation.5();
    exp10 = new Interpolation.Exp(2.0F, 10.0F);
    exp10In = new Interpolation.ExpIn(2.0F, 10.0F);
    exp10Out = new Interpolation.ExpOut(2.0F, 10.0F);
    exp5 = new Interpolation.Exp(2.0F, 5.0F);
    exp5In = new Interpolation.ExpIn(2.0F, 5.0F);
    exp5Out = new Interpolation.ExpOut(2.0F, 5.0F);
    circle = new Interpolation.6();
    circleIn = new Interpolation.7();
    circleOut = new Interpolation.8();
    elastic = new Interpolation.Elastic(2.0F, 10.0F, 7, 1.0F);
    elasticIn = new Interpolation.ElasticIn(2.0F, 10.0F, 6, 1.0F);
    elasticOut = new Interpolation.ElasticOut(2.0F, 10.0F, 7, 1.0F);
    swing = new Interpolation.Swing(1.5F);
    swingIn = new Interpolation.SwingIn(2.0F);
    swingOut = new Interpolation.SwingOut(2.0F);
    bounce = new Interpolation.Bounce(4);
    bounceIn = new Interpolation.BounceIn(4);
    bounceOut = new Interpolation.BounceOut(4);
  }

  public abstract float apply(float paramFloat);

  public float apply(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + (paramFloat2 - paramFloat1) * apply(paramFloat3);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Interpolation
 * JD-Core Version:    0.6.0
 */