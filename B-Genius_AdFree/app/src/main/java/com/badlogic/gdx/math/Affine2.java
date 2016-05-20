package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.Serializable;

public final class Affine2
  implements Serializable
{
  private static final long serialVersionUID = 1524569123485049187L;
  public float m00 = 1.0F;
  public float m01 = 0.0F;
  public float m02 = 0.0F;
  public float m10 = 0.0F;
  public float m11 = 1.0F;
  public float m12 = 0.0F;

  public Affine2()
  {
  }

  public Affine2(Affine2 paramAffine2)
  {
    set(paramAffine2);
  }

  public final void applyTo(Vector2 paramVector2)
  {
    float f1 = paramVector2.x;
    float f2 = paramVector2.y;
    paramVector2.x = (f1 * this.m00 + f2 * this.m01 + this.m02);
    paramVector2.y = (f1 * this.m10 + f2 * this.m11 + this.m12);
  }

  public final float det()
  {
    return this.m00 * this.m11 - this.m01 * this.m10;
  }

  public final Vector2 getTranslation(Vector2 paramVector2)
  {
    paramVector2.x = this.m02;
    paramVector2.y = this.m12;
    return paramVector2;
  }

  public final Affine2 idt()
  {
    this.m00 = 1.0F;
    this.m01 = 0.0F;
    this.m02 = 0.0F;
    this.m10 = 0.0F;
    this.m11 = 1.0F;
    this.m12 = 0.0F;
    return this;
  }

  public final Affine2 inv()
  {
    float f1 = det();
    if (f1 == 0.0F)
      throw new GdxRuntimeException("Can't invert a singular affine matrix");
    float f2 = 1.0F / f1;
    float f3 = this.m11;
    float f4 = -this.m01;
    float f5 = this.m01 * this.m12 - this.m11 * this.m02;
    float f6 = -this.m10;
    float f7 = this.m00;
    float f8 = this.m10 * this.m02 - this.m00 * this.m12;
    this.m00 = (f3 * f2);
    this.m01 = (f2 * f4);
    this.m02 = (f2 * f5);
    this.m10 = (f2 * f6);
    this.m11 = (f2 * f7);
    this.m12 = (f2 * f8);
    return this;
  }

  public final boolean isIdt()
  {
    return (this.m00 == 1.0F) && (this.m02 == 0.0F) && (this.m12 == 0.0F) && (this.m11 == 1.0F) && (this.m01 == 0.0F) && (this.m10 == 0.0F);
  }

  public final boolean isTranslation()
  {
    return (this.m00 == 1.0F) && (this.m11 == 1.0F) && (this.m01 == 0.0F) && (this.m10 == 0.0F);
  }

  public final Affine2 mul(Affine2 paramAffine2)
  {
    float f1 = this.m00 * paramAffine2.m00 + this.m01 * paramAffine2.m10;
    float f2 = this.m00 * paramAffine2.m01 + this.m01 * paramAffine2.m11;
    float f3 = this.m00 * paramAffine2.m02 + this.m01 * paramAffine2.m12 + this.m02;
    float f4 = this.m10 * paramAffine2.m00 + this.m11 * paramAffine2.m10;
    float f5 = this.m10 * paramAffine2.m01 + this.m11 * paramAffine2.m11;
    float f6 = this.m10 * paramAffine2.m02 + this.m11 * paramAffine2.m12 + this.m12;
    this.m00 = f1;
    this.m01 = f2;
    this.m02 = f3;
    this.m10 = f4;
    this.m11 = f5;
    this.m12 = f6;
    return this;
  }

  public final Affine2 preMul(Affine2 paramAffine2)
  {
    float f1 = paramAffine2.m00 * this.m00 + paramAffine2.m01 * this.m10;
    float f2 = paramAffine2.m00 * this.m01 + paramAffine2.m01 * this.m11;
    float f3 = paramAffine2.m00 * this.m02 + paramAffine2.m01 * this.m12 + paramAffine2.m02;
    float f4 = paramAffine2.m10 * this.m00 + paramAffine2.m11 * this.m10;
    float f5 = paramAffine2.m10 * this.m01 + paramAffine2.m11 * this.m11;
    float f6 = paramAffine2.m10 * this.m02 + paramAffine2.m11 * this.m12 + paramAffine2.m12;
    this.m00 = f1;
    this.m01 = f2;
    this.m02 = f3;
    this.m10 = f4;
    this.m11 = f5;
    this.m12 = f6;
    return this;
  }

  public final Affine2 preRotate(float paramFloat)
  {
    if (paramFloat == 0.0F)
      return this;
    float f1 = MathUtils.cosDeg(paramFloat);
    float f2 = MathUtils.sinDeg(paramFloat);
    float f3 = f1 * this.m00 - f2 * this.m10;
    float f4 = f1 * this.m01 - f2 * this.m11;
    float f5 = f1 * this.m02 - f2 * this.m12;
    float f6 = f2 * this.m00 + f1 * this.m10;
    float f7 = f2 * this.m01 + f1 * this.m11;
    float f8 = f2 * this.m02 + f1 * this.m12;
    this.m00 = f3;
    this.m01 = f4;
    this.m02 = f5;
    this.m10 = f6;
    this.m11 = f7;
    this.m12 = f8;
    return this;
  }

  public final Affine2 preRotateRad(float paramFloat)
  {
    if (paramFloat == 0.0F)
      return this;
    float f1 = MathUtils.cos(paramFloat);
    float f2 = MathUtils.sin(paramFloat);
    float f3 = f1 * this.m00 - f2 * this.m10;
    float f4 = f1 * this.m01 - f2 * this.m11;
    float f5 = f1 * this.m02 - f2 * this.m12;
    float f6 = f2 * this.m00 + f1 * this.m10;
    float f7 = f2 * this.m01 + f1 * this.m11;
    float f8 = f2 * this.m02 + f1 * this.m12;
    this.m00 = f3;
    this.m01 = f4;
    this.m02 = f5;
    this.m10 = f6;
    this.m11 = f7;
    this.m12 = f8;
    return this;
  }

  public final Affine2 preScale(float paramFloat1, float paramFloat2)
  {
    this.m00 = (paramFloat1 * this.m00);
    this.m01 = (paramFloat1 * this.m01);
    this.m02 = (paramFloat1 * this.m02);
    this.m10 = (paramFloat2 * this.m10);
    this.m11 = (paramFloat2 * this.m11);
    this.m12 = (paramFloat2 * this.m12);
    return this;
  }

  public final Affine2 preScale(Vector2 paramVector2)
  {
    return preScale(paramVector2.x, paramVector2.y);
  }

  public final Affine2 preShear(float paramFloat1, float paramFloat2)
  {
    float f1 = this.m00 + paramFloat1 * this.m10;
    float f2 = this.m01 + paramFloat1 * this.m11;
    float f3 = this.m02 + paramFloat1 * this.m12;
    float f4 = this.m10 + paramFloat2 * this.m00;
    float f5 = this.m11 + paramFloat2 * this.m01;
    float f6 = this.m12 + paramFloat2 * this.m02;
    this.m00 = f1;
    this.m01 = f2;
    this.m02 = f3;
    this.m10 = f4;
    this.m11 = f5;
    this.m12 = f6;
    return this;
  }

  public final Affine2 preShear(Vector2 paramVector2)
  {
    return preShear(paramVector2.x, paramVector2.y);
  }

  public final Affine2 preTranslate(float paramFloat1, float paramFloat2)
  {
    this.m02 = (paramFloat1 + this.m02);
    this.m12 = (paramFloat2 + this.m12);
    return this;
  }

  public final Affine2 preTranslate(Vector2 paramVector2)
  {
    return preTranslate(paramVector2.x, paramVector2.y);
  }

  public final Affine2 rotate(float paramFloat)
  {
    if (paramFloat == 0.0F)
      return this;
    float f1 = MathUtils.cosDeg(paramFloat);
    float f2 = MathUtils.sinDeg(paramFloat);
    float f3 = f1 * this.m00 + f2 * this.m01;
    float f4 = this.m00 * -f2 + f1 * this.m01;
    float f5 = f1 * this.m10 + f2 * this.m11;
    float f6 = this.m10 * -f2 + f1 * this.m11;
    this.m00 = f3;
    this.m01 = f4;
    this.m10 = f5;
    this.m11 = f6;
    return this;
  }

  public final Affine2 rotateRad(float paramFloat)
  {
    if (paramFloat == 0.0F)
      return this;
    float f1 = MathUtils.cos(paramFloat);
    float f2 = MathUtils.sin(paramFloat);
    float f3 = f1 * this.m00 + f2 * this.m01;
    float f4 = this.m00 * -f2 + f1 * this.m01;
    float f5 = f1 * this.m10 + f2 * this.m11;
    float f6 = this.m10 * -f2 + f1 * this.m11;
    this.m00 = f3;
    this.m01 = f4;
    this.m10 = f5;
    this.m11 = f6;
    return this;
  }

  public final Affine2 scale(float paramFloat1, float paramFloat2)
  {
    this.m00 = (paramFloat1 * this.m00);
    this.m01 = (paramFloat2 * this.m01);
    this.m10 = (paramFloat1 * this.m10);
    this.m11 = (paramFloat2 * this.m11);
    return this;
  }

  public final Affine2 scale(Vector2 paramVector2)
  {
    return scale(paramVector2.x, paramVector2.y);
  }

  public final Affine2 set(Affine2 paramAffine2)
  {
    this.m00 = paramAffine2.m00;
    this.m01 = paramAffine2.m01;
    this.m02 = paramAffine2.m02;
    this.m10 = paramAffine2.m10;
    this.m11 = paramAffine2.m11;
    this.m12 = paramAffine2.m12;
    return this;
  }

  public final Affine2 set(Matrix3 paramMatrix3)
  {
    float[] arrayOfFloat = paramMatrix3.val;
    this.m00 = arrayOfFloat[0];
    this.m01 = arrayOfFloat[3];
    this.m02 = arrayOfFloat[6];
    this.m10 = arrayOfFloat[1];
    this.m11 = arrayOfFloat[4];
    this.m12 = arrayOfFloat[7];
    return this;
  }

  public final Affine2 set(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat = paramMatrix4.val;
    this.m00 = arrayOfFloat[0];
    this.m01 = arrayOfFloat[4];
    this.m02 = arrayOfFloat[12];
    this.m10 = arrayOfFloat[1];
    this.m11 = arrayOfFloat[5];
    this.m12 = arrayOfFloat[13];
    return this;
  }

  public final Affine2 setToProduct(Affine2 paramAffine21, Affine2 paramAffine22)
  {
    this.m00 = (paramAffine21.m00 * paramAffine22.m00 + paramAffine21.m01 * paramAffine22.m10);
    this.m01 = (paramAffine21.m00 * paramAffine22.m01 + paramAffine21.m01 * paramAffine22.m11);
    this.m02 = (paramAffine21.m00 * paramAffine22.m02 + paramAffine21.m01 * paramAffine22.m12 + paramAffine21.m02);
    this.m10 = (paramAffine21.m10 * paramAffine22.m00 + paramAffine21.m11 * paramAffine22.m10);
    this.m11 = (paramAffine21.m10 * paramAffine22.m01 + paramAffine21.m11 * paramAffine22.m11);
    this.m12 = (paramAffine21.m10 * paramAffine22.m02 + paramAffine21.m11 * paramAffine22.m12 + paramAffine21.m12);
    return this;
  }

  public final Affine2 setToRotation(float paramFloat)
  {
    float f1 = MathUtils.cosDeg(paramFloat);
    float f2 = MathUtils.sinDeg(paramFloat);
    this.m00 = f1;
    this.m01 = (-f2);
    this.m02 = 0.0F;
    this.m10 = f2;
    this.m11 = f1;
    this.m12 = 0.0F;
    return this;
  }

  public final Affine2 setToRotation(float paramFloat1, float paramFloat2)
  {
    this.m00 = paramFloat1;
    this.m01 = (-paramFloat2);
    this.m02 = 0.0F;
    this.m10 = paramFloat2;
    this.m11 = paramFloat1;
    this.m12 = 0.0F;
    return this;
  }

  public final Affine2 setToRotationRad(float paramFloat)
  {
    float f1 = MathUtils.cos(paramFloat);
    float f2 = MathUtils.sin(paramFloat);
    this.m00 = f1;
    this.m01 = (-f2);
    this.m02 = 0.0F;
    this.m10 = f2;
    this.m11 = f1;
    this.m12 = 0.0F;
    return this;
  }

  public final Affine2 setToScaling(float paramFloat1, float paramFloat2)
  {
    this.m00 = paramFloat1;
    this.m01 = 0.0F;
    this.m02 = 0.0F;
    this.m10 = 0.0F;
    this.m11 = paramFloat2;
    this.m12 = 0.0F;
    return this;
  }

  public final Affine2 setToScaling(Vector2 paramVector2)
  {
    return setToScaling(paramVector2.x, paramVector2.y);
  }

  public final Affine2 setToShearing(float paramFloat1, float paramFloat2)
  {
    this.m00 = 1.0F;
    this.m01 = paramFloat1;
    this.m02 = 0.0F;
    this.m10 = paramFloat2;
    this.m11 = 1.0F;
    this.m12 = 0.0F;
    return this;
  }

  public final Affine2 setToShearing(Vector2 paramVector2)
  {
    return setToShearing(paramVector2.x, paramVector2.y);
  }

  public final Affine2 setToTranslation(float paramFloat1, float paramFloat2)
  {
    this.m00 = 1.0F;
    this.m01 = 0.0F;
    this.m02 = paramFloat1;
    this.m10 = 0.0F;
    this.m11 = 1.0F;
    this.m12 = paramFloat2;
    return this;
  }

  public final Affine2 setToTranslation(Vector2 paramVector2)
  {
    return setToTranslation(paramVector2.x, paramVector2.y);
  }

  public final Affine2 setToTrnRotRadScl(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.m02 = paramFloat1;
    this.m12 = paramFloat2;
    if (paramFloat3 == 0.0F)
    {
      this.m00 = paramFloat4;
      this.m01 = 0.0F;
      this.m10 = 0.0F;
      this.m11 = paramFloat5;
      return this;
    }
    float f1 = MathUtils.sin(paramFloat3);
    float f2 = MathUtils.cos(paramFloat3);
    this.m00 = (f2 * paramFloat4);
    this.m01 = (paramFloat5 * -f1);
    this.m10 = (f1 * paramFloat4);
    this.m11 = (f2 * paramFloat5);
    return this;
  }

  public final Affine2 setToTrnRotRadScl(Vector2 paramVector21, float paramFloat, Vector2 paramVector22)
  {
    return setToTrnRotRadScl(paramVector21.x, paramVector21.y, paramFloat, paramVector22.x, paramVector22.y);
  }

  public final Affine2 setToTrnRotScl(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.m02 = paramFloat1;
    this.m12 = paramFloat2;
    if (paramFloat3 == 0.0F)
    {
      this.m00 = paramFloat4;
      this.m01 = 0.0F;
      this.m10 = 0.0F;
      this.m11 = paramFloat5;
      return this;
    }
    float f1 = MathUtils.sinDeg(paramFloat3);
    float f2 = MathUtils.cosDeg(paramFloat3);
    this.m00 = (f2 * paramFloat4);
    this.m01 = (paramFloat5 * -f1);
    this.m10 = (f1 * paramFloat4);
    this.m11 = (f2 * paramFloat5);
    return this;
  }

  public final Affine2 setToTrnRotScl(Vector2 paramVector21, float paramFloat, Vector2 paramVector22)
  {
    return setToTrnRotScl(paramVector21.x, paramVector21.y, paramFloat, paramVector22.x, paramVector22.y);
  }

  public final Affine2 setToTrnScl(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.m00 = paramFloat3;
    this.m01 = 0.0F;
    this.m02 = paramFloat1;
    this.m10 = 0.0F;
    this.m11 = paramFloat4;
    this.m12 = paramFloat2;
    return this;
  }

  public final Affine2 setToTrnScl(Vector2 paramVector21, Vector2 paramVector22)
  {
    return setToTrnScl(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y);
  }

  public final Affine2 shear(float paramFloat1, float paramFloat2)
  {
    float f1 = this.m00 + paramFloat2 * this.m01;
    float f2 = this.m01 + paramFloat1 * this.m00;
    this.m00 = f1;
    this.m01 = f2;
    float f3 = this.m10 + paramFloat2 * this.m11;
    float f4 = this.m11 + paramFloat1 * this.m10;
    this.m10 = f3;
    this.m11 = f4;
    return this;
  }

  public final Affine2 shear(Vector2 paramVector2)
  {
    return shear(paramVector2.x, paramVector2.y);
  }

  public final String toString()
  {
    return "[" + this.m00 + "|" + this.m01 + "|" + this.m02 + "]\n[" + this.m10 + "|" + this.m11 + "|" + this.m12 + "]\n[0.0|0.0|0.1]";
  }

  public final Affine2 translate(float paramFloat1, float paramFloat2)
  {
    this.m02 += paramFloat1 * this.m00 + paramFloat2 * this.m01;
    this.m12 += paramFloat1 * this.m10 + paramFloat2 * this.m11;
    return this;
  }

  public final Affine2 translate(Vector2 paramVector2)
  {
    return translate(paramVector2.x, paramVector2.y);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Affine2
 * JD-Core Version:    0.6.0
 */