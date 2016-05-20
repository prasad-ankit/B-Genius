package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.Serializable;

public class Matrix3
  implements Serializable
{
  public static final int M00 = 0;
  public static final int M01 = 3;
  public static final int M02 = 6;
  public static final int M10 = 1;
  public static final int M11 = 4;
  public static final int M12 = 7;
  public static final int M20 = 2;
  public static final int M21 = 5;
  public static final int M22 = 8;
  private static final long serialVersionUID = 7907569533774959788L;
  private float[] tmp = new float[9];
  public float[] val = new float[9];

  public Matrix3()
  {
    idt();
  }

  public Matrix3(Matrix3 paramMatrix3)
  {
    set(paramMatrix3);
  }

  public Matrix3(float[] paramArrayOfFloat)
  {
    set(paramArrayOfFloat);
  }

  private static void mul(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[3] * paramArrayOfFloat2[1] + paramArrayOfFloat1[6] * paramArrayOfFloat2[2];
    float f2 = paramArrayOfFloat1[0] * paramArrayOfFloat2[3] + paramArrayOfFloat1[3] * paramArrayOfFloat2[4] + paramArrayOfFloat1[6] * paramArrayOfFloat2[5];
    float f3 = paramArrayOfFloat1[0] * paramArrayOfFloat2[6] + paramArrayOfFloat1[3] * paramArrayOfFloat2[7] + paramArrayOfFloat1[6] * paramArrayOfFloat2[8];
    float f4 = paramArrayOfFloat1[1] * paramArrayOfFloat2[0] + paramArrayOfFloat1[4] * paramArrayOfFloat2[1] + paramArrayOfFloat1[7] * paramArrayOfFloat2[2];
    float f5 = paramArrayOfFloat1[1] * paramArrayOfFloat2[3] + paramArrayOfFloat1[4] * paramArrayOfFloat2[4] + paramArrayOfFloat1[7] * paramArrayOfFloat2[5];
    float f6 = paramArrayOfFloat1[1] * paramArrayOfFloat2[6] + paramArrayOfFloat1[4] * paramArrayOfFloat2[7] + paramArrayOfFloat1[7] * paramArrayOfFloat2[8];
    float f7 = paramArrayOfFloat1[2] * paramArrayOfFloat2[0] + paramArrayOfFloat1[5] * paramArrayOfFloat2[1] + paramArrayOfFloat1[8] * paramArrayOfFloat2[2];
    float f8 = paramArrayOfFloat1[2] * paramArrayOfFloat2[3] + paramArrayOfFloat1[5] * paramArrayOfFloat2[4] + paramArrayOfFloat1[8] * paramArrayOfFloat2[5];
    float f9 = paramArrayOfFloat1[2] * paramArrayOfFloat2[6] + paramArrayOfFloat1[5] * paramArrayOfFloat2[7] + paramArrayOfFloat1[8] * paramArrayOfFloat2[8];
    paramArrayOfFloat1[0] = f1;
    paramArrayOfFloat1[1] = f4;
    paramArrayOfFloat1[2] = f7;
    paramArrayOfFloat1[3] = f2;
    paramArrayOfFloat1[4] = f5;
    paramArrayOfFloat1[5] = f8;
    paramArrayOfFloat1[6] = f3;
    paramArrayOfFloat1[7] = f6;
    paramArrayOfFloat1[8] = f9;
  }

  public float det()
  {
    float[] arrayOfFloat = this.val;
    return arrayOfFloat[0] * arrayOfFloat[4] * arrayOfFloat[8] + arrayOfFloat[3] * arrayOfFloat[7] * arrayOfFloat[2] + arrayOfFloat[6] * arrayOfFloat[1] * arrayOfFloat[5] - arrayOfFloat[0] * arrayOfFloat[7] * arrayOfFloat[5] - arrayOfFloat[3] * arrayOfFloat[1] * arrayOfFloat[8] - arrayOfFloat[6] * arrayOfFloat[4] * arrayOfFloat[2];
  }

  public float getRotation()
  {
    return 57.295776F * (float)Math.atan2(this.val[1], this.val[0]);
  }

  public float getRotationRad()
  {
    return (float)Math.atan2(this.val[1], this.val[0]);
  }

  public Vector2 getScale(Vector2 paramVector2)
  {
    float[] arrayOfFloat = this.val;
    paramVector2.x = (float)Math.sqrt(arrayOfFloat[0] * arrayOfFloat[0] + arrayOfFloat[3] * arrayOfFloat[3]);
    paramVector2.y = (float)Math.sqrt(arrayOfFloat[1] * arrayOfFloat[1] + arrayOfFloat[4] * arrayOfFloat[4]);
    return paramVector2;
  }

  public Vector2 getTranslation(Vector2 paramVector2)
  {
    paramVector2.x = this.val[6];
    paramVector2.y = this.val[7];
    return paramVector2;
  }

  public float[] getValues()
  {
    return this.val;
  }

  public Matrix3 idt()
  {
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 1.0F;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    return this;
  }

  public Matrix3 inv()
  {
    float f1 = det();
    if (f1 == 0.0F)
      throw new GdxRuntimeException("Can't invert a singular matrix");
    float f2 = 1.0F / f1;
    float[] arrayOfFloat1 = this.tmp;
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat1[0] = (arrayOfFloat2[4] * arrayOfFloat2[8] - arrayOfFloat2[5] * arrayOfFloat2[7]);
    arrayOfFloat1[1] = (arrayOfFloat2[2] * arrayOfFloat2[7] - arrayOfFloat2[1] * arrayOfFloat2[8]);
    arrayOfFloat1[2] = (arrayOfFloat2[1] * arrayOfFloat2[5] - arrayOfFloat2[2] * arrayOfFloat2[4]);
    arrayOfFloat1[3] = (arrayOfFloat2[5] * arrayOfFloat2[6] - arrayOfFloat2[3] * arrayOfFloat2[8]);
    arrayOfFloat1[4] = (arrayOfFloat2[0] * arrayOfFloat2[8] - arrayOfFloat2[2] * arrayOfFloat2[6]);
    arrayOfFloat1[5] = (arrayOfFloat2[2] * arrayOfFloat2[3] - arrayOfFloat2[0] * arrayOfFloat2[5]);
    arrayOfFloat1[6] = (arrayOfFloat2[3] * arrayOfFloat2[7] - arrayOfFloat2[4] * arrayOfFloat2[6]);
    arrayOfFloat1[7] = (arrayOfFloat2[1] * arrayOfFloat2[6] - arrayOfFloat2[0] * arrayOfFloat2[7]);
    arrayOfFloat1[8] = (arrayOfFloat2[0] * arrayOfFloat2[4] - arrayOfFloat2[1] * arrayOfFloat2[3]);
    arrayOfFloat2[0] = (f2 * arrayOfFloat1[0]);
    arrayOfFloat2[1] = (f2 * arrayOfFloat1[1]);
    arrayOfFloat2[2] = (f2 * arrayOfFloat1[2]);
    arrayOfFloat2[3] = (f2 * arrayOfFloat1[3]);
    arrayOfFloat2[4] = (f2 * arrayOfFloat1[4]);
    arrayOfFloat2[5] = (f2 * arrayOfFloat1[5]);
    arrayOfFloat2[6] = (f2 * arrayOfFloat1[6]);
    arrayOfFloat2[7] = (f2 * arrayOfFloat1[7]);
    arrayOfFloat2[8] = (f2 * arrayOfFloat1[8]);
    return this;
  }

  public Matrix3 mul(Matrix3 paramMatrix3)
  {
    float[] arrayOfFloat = this.val;
    float f1 = arrayOfFloat[0] * paramMatrix3.val[0] + arrayOfFloat[3] * paramMatrix3.val[1] + arrayOfFloat[6] * paramMatrix3.val[2];
    float f2 = arrayOfFloat[0] * paramMatrix3.val[3] + arrayOfFloat[3] * paramMatrix3.val[4] + arrayOfFloat[6] * paramMatrix3.val[5];
    float f3 = arrayOfFloat[0] * paramMatrix3.val[6] + arrayOfFloat[3] * paramMatrix3.val[7] + arrayOfFloat[6] * paramMatrix3.val[8];
    float f4 = arrayOfFloat[1] * paramMatrix3.val[0] + arrayOfFloat[4] * paramMatrix3.val[1] + arrayOfFloat[7] * paramMatrix3.val[2];
    float f5 = arrayOfFloat[1] * paramMatrix3.val[3] + arrayOfFloat[4] * paramMatrix3.val[4] + arrayOfFloat[7] * paramMatrix3.val[5];
    float f6 = arrayOfFloat[1] * paramMatrix3.val[6] + arrayOfFloat[4] * paramMatrix3.val[7] + arrayOfFloat[7] * paramMatrix3.val[8];
    float f7 = arrayOfFloat[2] * paramMatrix3.val[0] + arrayOfFloat[5] * paramMatrix3.val[1] + arrayOfFloat[8] * paramMatrix3.val[2];
    float f8 = arrayOfFloat[2] * paramMatrix3.val[3] + arrayOfFloat[5] * paramMatrix3.val[4] + arrayOfFloat[8] * paramMatrix3.val[5];
    float f9 = arrayOfFloat[2] * paramMatrix3.val[6] + arrayOfFloat[5] * paramMatrix3.val[7] + arrayOfFloat[8] * paramMatrix3.val[8];
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = f4;
    arrayOfFloat[2] = f7;
    arrayOfFloat[3] = f2;
    arrayOfFloat[4] = f5;
    arrayOfFloat[5] = f8;
    arrayOfFloat[6] = f3;
    arrayOfFloat[7] = f6;
    arrayOfFloat[8] = f9;
    return this;
  }

  public Matrix3 mulLeft(Matrix3 paramMatrix3)
  {
    float[] arrayOfFloat = this.val;
    float f1 = paramMatrix3.val[0] * arrayOfFloat[0] + paramMatrix3.val[3] * arrayOfFloat[1] + paramMatrix3.val[6] * arrayOfFloat[2];
    float f2 = paramMatrix3.val[0] * arrayOfFloat[3] + paramMatrix3.val[3] * arrayOfFloat[4] + paramMatrix3.val[6] * arrayOfFloat[5];
    float f3 = paramMatrix3.val[0] * arrayOfFloat[6] + paramMatrix3.val[3] * arrayOfFloat[7] + paramMatrix3.val[6] * arrayOfFloat[8];
    float f4 = paramMatrix3.val[1] * arrayOfFloat[0] + paramMatrix3.val[4] * arrayOfFloat[1] + paramMatrix3.val[7] * arrayOfFloat[2];
    float f5 = paramMatrix3.val[1] * arrayOfFloat[3] + paramMatrix3.val[4] * arrayOfFloat[4] + paramMatrix3.val[7] * arrayOfFloat[5];
    float f6 = paramMatrix3.val[1] * arrayOfFloat[6] + paramMatrix3.val[4] * arrayOfFloat[7] + paramMatrix3.val[7] * arrayOfFloat[8];
    float f7 = paramMatrix3.val[2] * arrayOfFloat[0] + paramMatrix3.val[5] * arrayOfFloat[1] + paramMatrix3.val[8] * arrayOfFloat[2];
    float f8 = paramMatrix3.val[2] * arrayOfFloat[3] + paramMatrix3.val[5] * arrayOfFloat[4] + paramMatrix3.val[8] * arrayOfFloat[5];
    float f9 = paramMatrix3.val[2] * arrayOfFloat[6] + paramMatrix3.val[5] * arrayOfFloat[7] + paramMatrix3.val[8] * arrayOfFloat[8];
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = f4;
    arrayOfFloat[2] = f7;
    arrayOfFloat[3] = f2;
    arrayOfFloat[4] = f5;
    arrayOfFloat[5] = f8;
    arrayOfFloat[6] = f3;
    arrayOfFloat[7] = f6;
    arrayOfFloat[8] = f9;
    return this;
  }

  public Matrix3 rotate(float paramFloat)
  {
    return rotateRad(0.01745329F * paramFloat);
  }

  public Matrix3 rotateRad(float paramFloat)
  {
    if (paramFloat == 0.0F)
      return this;
    float f1 = (float)Math.cos(paramFloat);
    float f2 = (float)Math.sin(paramFloat);
    float[] arrayOfFloat = this.tmp;
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = f2;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = (-f2);
    arrayOfFloat[4] = f1;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    mul(this.val, arrayOfFloat);
    return this;
  }

  public Matrix3 scale(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.tmp;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = paramFloat2;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    mul(this.val, arrayOfFloat);
    return this;
  }

  public Matrix3 scale(Vector2 paramVector2)
  {
    float[] arrayOfFloat = this.tmp;
    arrayOfFloat[0] = paramVector2.x;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = paramVector2.y;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    mul(this.val, arrayOfFloat);
    return this;
  }

  public Matrix3 scl(float paramFloat)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[0] = (paramFloat * arrayOfFloat1[0]);
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[4] = (paramFloat * arrayOfFloat2[4]);
    return this;
  }

  public Matrix3 scl(Vector2 paramVector2)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[0] *= paramVector2.x;
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[4] *= paramVector2.y;
    return this;
  }

  public Matrix3 scl(Vector3 paramVector3)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[0] *= paramVector3.x;
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[4] *= paramVector3.y;
    return this;
  }

  public Matrix3 set(Affine2 paramAffine2)
  {
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = paramAffine2.m00;
    arrayOfFloat[1] = paramAffine2.m10;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = paramAffine2.m01;
    arrayOfFloat[4] = paramAffine2.m11;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = paramAffine2.m02;
    arrayOfFloat[7] = paramAffine2.m12;
    arrayOfFloat[8] = 1.0F;
    return this;
  }

  public Matrix3 set(Matrix3 paramMatrix3)
  {
    System.arraycopy(paramMatrix3.val, 0, this.val, 0, this.val.length);
    return this;
  }

  public Matrix3 set(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = paramMatrix4.val[0];
    arrayOfFloat[1] = paramMatrix4.val[1];
    arrayOfFloat[2] = paramMatrix4.val[2];
    arrayOfFloat[3] = paramMatrix4.val[4];
    arrayOfFloat[4] = paramMatrix4.val[5];
    arrayOfFloat[5] = paramMatrix4.val[6];
    arrayOfFloat[6] = paramMatrix4.val[8];
    arrayOfFloat[7] = paramMatrix4.val[9];
    arrayOfFloat[8] = paramMatrix4.val[10];
    return this;
  }

  public Matrix3 set(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.val, 0, this.val.length);
    return this;
  }

  public Matrix3 setToRotation(float paramFloat)
  {
    return setToRotationRad(0.01745329F * paramFloat);
  }

  public Matrix3 setToRotation(Vector3 paramVector3, float paramFloat)
  {
    return setToRotation(paramVector3, MathUtils.cosDeg(paramFloat), MathUtils.sinDeg(paramFloat));
  }

  public Matrix3 setToRotation(Vector3 paramVector3, float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.val;
    float f = 1.0F - paramFloat1;
    arrayOfFloat[0] = (paramFloat1 + f * paramVector3.x * paramVector3.x);
    arrayOfFloat[1] = (f * paramVector3.x * paramVector3.y - paramFloat2 * paramVector3.z);
    arrayOfFloat[2] = (f * paramVector3.z * paramVector3.x + paramFloat2 * paramVector3.y);
    arrayOfFloat[3] = (f * paramVector3.x * paramVector3.y + paramFloat2 * paramVector3.z);
    arrayOfFloat[4] = (paramFloat1 + f * paramVector3.y * paramVector3.y);
    arrayOfFloat[5] = (f * paramVector3.y * paramVector3.z - paramFloat2 * paramVector3.x);
    arrayOfFloat[6] = (f * paramVector3.z * paramVector3.x - paramFloat2 * paramVector3.y);
    arrayOfFloat[7] = (f * paramVector3.y * paramVector3.z + paramFloat2 * paramVector3.x);
    arrayOfFloat[8] = (paramFloat1 + f * paramVector3.z * paramVector3.z);
    return this;
  }

  public Matrix3 setToRotationRad(float paramFloat)
  {
    float f1 = (float)Math.cos(paramFloat);
    float f2 = (float)Math.sin(paramFloat);
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = f2;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = (-f2);
    arrayOfFloat[4] = f1;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    return this;
  }

  public Matrix3 setToScaling(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = paramFloat2;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    return this;
  }

  public Matrix3 setToScaling(Vector2 paramVector2)
  {
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = paramVector2.x;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = paramVector2.y;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    return this;
  }

  public Matrix3 setToTranslation(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 1.0F;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = paramFloat1;
    arrayOfFloat[7] = paramFloat2;
    arrayOfFloat[8] = 1.0F;
    return this;
  }

  public Matrix3 setToTranslation(Vector2 paramVector2)
  {
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 1.0F;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = paramVector2.x;
    arrayOfFloat[7] = paramVector2.y;
    arrayOfFloat[8] = 1.0F;
    return this;
  }

  public String toString()
  {
    float[] arrayOfFloat = this.val;
    return "[" + arrayOfFloat[0] + "|" + arrayOfFloat[3] + "|" + arrayOfFloat[6] + "]\n[" + arrayOfFloat[1] + "|" + arrayOfFloat[4] + "|" + arrayOfFloat[7] + "]\n[" + arrayOfFloat[2] + "|" + arrayOfFloat[5] + "|" + arrayOfFloat[8] + "]";
  }

  public Matrix3 translate(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.val;
    this.tmp[0] = 1.0F;
    this.tmp[1] = 0.0F;
    this.tmp[2] = 0.0F;
    this.tmp[3] = 0.0F;
    this.tmp[4] = 1.0F;
    this.tmp[5] = 0.0F;
    this.tmp[6] = paramFloat1;
    this.tmp[7] = paramFloat2;
    this.tmp[8] = 1.0F;
    mul(arrayOfFloat, this.tmp);
    return this;
  }

  public Matrix3 translate(Vector2 paramVector2)
  {
    float[] arrayOfFloat = this.val;
    this.tmp[0] = 1.0F;
    this.tmp[1] = 0.0F;
    this.tmp[2] = 0.0F;
    this.tmp[3] = 0.0F;
    this.tmp[4] = 1.0F;
    this.tmp[5] = 0.0F;
    this.tmp[6] = paramVector2.x;
    this.tmp[7] = paramVector2.y;
    this.tmp[8] = 1.0F;
    mul(arrayOfFloat, this.tmp);
    return this;
  }

  public Matrix3 transpose()
  {
    float[] arrayOfFloat = this.val;
    float f1 = arrayOfFloat[1];
    float f2 = arrayOfFloat[2];
    float f3 = arrayOfFloat[3];
    float f4 = arrayOfFloat[5];
    float f5 = arrayOfFloat[6];
    float f6 = arrayOfFloat[7];
    arrayOfFloat[3] = f1;
    arrayOfFloat[6] = f2;
    arrayOfFloat[1] = f3;
    arrayOfFloat[7] = f4;
    arrayOfFloat[2] = f5;
    arrayOfFloat[5] = f6;
    return this;
  }

  public Matrix3 trn(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[6] = (paramFloat1 + arrayOfFloat1[6]);
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[7] = (paramFloat2 + arrayOfFloat2[7]);
    return this;
  }

  public Matrix3 trn(Vector2 paramVector2)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[6] += paramVector2.x;
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[7] += paramVector2.y;
    return this;
  }

  public Matrix3 trn(Vector3 paramVector3)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[6] += paramVector3.x;
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[7] += paramVector3.y;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Matrix3
 * JD-Core Version:    0.6.0
 */