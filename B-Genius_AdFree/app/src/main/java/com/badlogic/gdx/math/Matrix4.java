package com.badlogic.gdx.math;

import java.io.Serializable;

public class Matrix4
  implements Serializable
{
  public static final int M00 = 0;
  public static final int M01 = 4;
  public static final int M02 = 8;
  public static final int M03 = 12;
  public static final int M10 = 1;
  public static final int M11 = 5;
  public static final int M12 = 9;
  public static final int M13 = 13;
  public static final int M20 = 2;
  public static final int M21 = 6;
  public static final int M22 = 10;
  public static final int M23 = 14;
  public static final int M30 = 3;
  public static final int M31 = 7;
  public static final int M32 = 11;
  public static final int M33 = 15;
  static final Vector3 l_vex;
  static final Vector3 l_vey;
  static final Vector3 l_vez;
  static Quaternion quat;
  static Quaternion quat2;
  static final Vector3 right;
  private static final long serialVersionUID = -2717655254359579617L;
  private static final float[] tmp = new float[16];
  static final Vector3 tmpForward;
  static final Matrix4 tmpMat;
  static final Vector3 tmpUp;
  static final Vector3 tmpVec;
  public final float[] val = new float[16];

  static
  {
    quat = new Quaternion();
    quat2 = new Quaternion();
    l_vez = new Vector3();
    l_vex = new Vector3();
    l_vey = new Vector3();
    tmpVec = new Vector3();
    tmpMat = new Matrix4();
    right = new Vector3();
    tmpForward = new Vector3();
    tmpUp = new Vector3();
  }

  public Matrix4()
  {
    this.val[0] = 1.0F;
    this.val[5] = 1.0F;
    this.val[10] = 1.0F;
    this.val[15] = 1.0F;
  }

  public Matrix4(Matrix4 paramMatrix4)
  {
    set(paramMatrix4);
  }

  public Matrix4(Quaternion paramQuaternion)
  {
    set(paramQuaternion);
  }

  public Matrix4(Vector3 paramVector31, Quaternion paramQuaternion, Vector3 paramVector32)
  {
    set(paramVector31, paramQuaternion, paramVector32);
  }

  public Matrix4(float[] paramArrayOfFloat)
  {
    set(paramArrayOfFloat);
  }

  public static native float det(float[] paramArrayOfFloat);

  public static native boolean inv(float[] paramArrayOfFloat);

  public static native void mul(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);

  public static native void mulVec(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);

  public static native void mulVec(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, int paramInt3);

  public static native void prj(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);

  public static native void prj(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, int paramInt3);

  public static native void rot(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);

  public static native void rot(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, int paramInt3);

  public Matrix4 avg(Matrix4 paramMatrix4, float paramFloat)
  {
    getScale(tmpVec);
    paramMatrix4.getScale(tmpForward);
    getRotation(quat);
    paramMatrix4.getRotation(quat2);
    getTranslation(tmpUp);
    paramMatrix4.getTranslation(right);
    setToScaling(tmpVec.scl(paramFloat).add(tmpForward.scl(1.0F - paramFloat)));
    rotate(quat.slerp(quat2, 1.0F - paramFloat));
    setTranslation(tmpUp.scl(paramFloat).add(right.scl(1.0F - paramFloat)));
    return this;
  }

  public Matrix4 avg(Matrix4[] paramArrayOfMatrix4)
  {
    float f = 1.0F / paramArrayOfMatrix4.length;
    tmpVec.set(paramArrayOfMatrix4[0].getScale(tmpUp).scl(f));
    quat.set(paramArrayOfMatrix4[0].getRotation(quat2).exp(f));
    tmpForward.set(paramArrayOfMatrix4[0].getTranslation(tmpUp).scl(f));
    for (int i = 1; i < paramArrayOfMatrix4.length; i++)
    {
      tmpVec.add(paramArrayOfMatrix4[i].getScale(tmpUp).scl(f));
      quat.mul(paramArrayOfMatrix4[i].getRotation(quat2).exp(f));
      tmpForward.add(paramArrayOfMatrix4[i].getTranslation(tmpUp).scl(f));
    }
    quat.nor();
    setToScaling(tmpVec);
    rotate(quat);
    setTranslation(tmpForward);
    return this;
  }

  public Matrix4 avg(Matrix4[] paramArrayOfMatrix4, float[] paramArrayOfFloat)
  {
    tmpVec.set(paramArrayOfMatrix4[0].getScale(tmpUp).scl(paramArrayOfFloat[0]));
    quat.set(paramArrayOfMatrix4[0].getRotation(quat2).exp(paramArrayOfFloat[0]));
    tmpForward.set(paramArrayOfMatrix4[0].getTranslation(tmpUp).scl(paramArrayOfFloat[0]));
    for (int i = 1; i < paramArrayOfMatrix4.length; i++)
    {
      tmpVec.add(paramArrayOfMatrix4[i].getScale(tmpUp).scl(paramArrayOfFloat[i]));
      quat.mul(paramArrayOfMatrix4[i].getRotation(quat2).exp(paramArrayOfFloat[i]));
      tmpForward.add(paramArrayOfMatrix4[i].getTranslation(tmpUp).scl(paramArrayOfFloat[i]));
    }
    quat.nor();
    setToScaling(tmpVec);
    rotate(quat);
    setTranslation(tmpForward);
    return this;
  }

  public Matrix4 cpy()
  {
    return new Matrix4(this);
  }

  public float det()
  {
    return this.val[3] * this.val[6] * this.val[9] * this.val[12] - this.val[2] * this.val[7] * this.val[9] * this.val[12] - this.val[3] * this.val[5] * this.val[10] * this.val[12] + this.val[1] * this.val[7] * this.val[10] * this.val[12] + this.val[2] * this.val[5] * this.val[11] * this.val[12] - this.val[1] * this.val[6] * this.val[11] * this.val[12] - this.val[3] * this.val[6] * this.val[8] * this.val[13] + this.val[2] * this.val[7] * this.val[8] * this.val[13] + this.val[3] * this.val[4] * this.val[10] * this.val[13] - this.val[0] * this.val[7] * this.val[10] * this.val[13] - this.val[2] * this.val[4] * this.val[11] * this.val[13] + this.val[0] * this.val[6] * this.val[11] * this.val[13] + this.val[3] * this.val[5] * this.val[8] * this.val[14] - this.val[1] * this.val[7] * this.val[8] * this.val[14] - this.val[3] * this.val[4] * this.val[9] * this.val[14] + this.val[0] * this.val[7] * this.val[9] * this.val[14] + this.val[1] * this.val[4] * this.val[11] * this.val[14] - this.val[0] * this.val[5] * this.val[11] * this.val[14] - this.val[2] * this.val[5] * this.val[8] * this.val[15] + this.val[1] * this.val[6] * this.val[8] * this.val[15] + this.val[2] * this.val[4] * this.val[9] * this.val[15] - this.val[0] * this.val[6] * this.val[9] * this.val[15] - this.val[1] * this.val[4] * this.val[10] * this.val[15] + this.val[0] * this.val[5] * this.val[10] * this.val[15];
  }

  public float det3x3()
  {
    return this.val[0] * this.val[5] * this.val[10] + this.val[4] * this.val[9] * this.val[2] + this.val[8] * this.val[1] * this.val[6] - this.val[0] * this.val[9] * this.val[6] - this.val[4] * this.val[1] * this.val[10] - this.val[8] * this.val[5] * this.val[2];
  }

  public void extract4x3Matrix(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = this.val[0];
    paramArrayOfFloat[1] = this.val[1];
    paramArrayOfFloat[2] = this.val[2];
    paramArrayOfFloat[3] = this.val[4];
    paramArrayOfFloat[4] = this.val[5];
    paramArrayOfFloat[5] = this.val[6];
    paramArrayOfFloat[6] = this.val[8];
    paramArrayOfFloat[7] = this.val[9];
    paramArrayOfFloat[8] = this.val[10];
    paramArrayOfFloat[9] = this.val[12];
    paramArrayOfFloat[10] = this.val[13];
    paramArrayOfFloat[11] = this.val[14];
  }

  public Quaternion getRotation(Quaternion paramQuaternion)
  {
    return paramQuaternion.setFromMatrix(this);
  }

  public Quaternion getRotation(Quaternion paramQuaternion, boolean paramBoolean)
  {
    return paramQuaternion.setFromMatrix(paramBoolean, this);
  }

  public Vector3 getScale(Vector3 paramVector3)
  {
    return paramVector3.set(getScaleX(), getScaleY(), getScaleZ());
  }

  public float getScaleX()
  {
    if ((MathUtils.isZero(this.val[4])) && (MathUtils.isZero(this.val[8])))
      return Math.abs(this.val[0]);
    return (float)Math.sqrt(getScaleXSquared());
  }

  public float getScaleXSquared()
  {
    return this.val[0] * this.val[0] + this.val[4] * this.val[4] + this.val[8] * this.val[8];
  }

  public float getScaleY()
  {
    if ((MathUtils.isZero(this.val[1])) && (MathUtils.isZero(this.val[9])))
      return Math.abs(this.val[5]);
    return (float)Math.sqrt(getScaleYSquared());
  }

  public float getScaleYSquared()
  {
    return this.val[1] * this.val[1] + this.val[5] * this.val[5] + this.val[9] * this.val[9];
  }

  public float getScaleZ()
  {
    if ((MathUtils.isZero(this.val[2])) && (MathUtils.isZero(this.val[6])))
      return Math.abs(this.val[10]);
    return (float)Math.sqrt(getScaleZSquared());
  }

  public float getScaleZSquared()
  {
    return this.val[2] * this.val[2] + this.val[6] * this.val[6] + this.val[10] * this.val[10];
  }

  public Vector3 getTranslation(Vector3 paramVector3)
  {
    paramVector3.x = this.val[12];
    paramVector3.y = this.val[13];
    paramVector3.z = this.val[14];
    return paramVector3;
  }

  public float[] getValues()
  {
    return this.val;
  }

  public Matrix4 idt()
  {
    this.val[0] = 1.0F;
    this.val[4] = 0.0F;
    this.val[8] = 0.0F;
    this.val[12] = 0.0F;
    this.val[1] = 0.0F;
    this.val[5] = 1.0F;
    this.val[9] = 0.0F;
    this.val[13] = 0.0F;
    this.val[2] = 0.0F;
    this.val[6] = 0.0F;
    this.val[10] = 1.0F;
    this.val[14] = 0.0F;
    this.val[3] = 0.0F;
    this.val[7] = 0.0F;
    this.val[11] = 0.0F;
    this.val[15] = 1.0F;
    return this;
  }

  public Matrix4 inv()
  {
    float f1 = this.val[3] * this.val[6] * this.val[9] * this.val[12] - this.val[2] * this.val[7] * this.val[9] * this.val[12] - this.val[3] * this.val[5] * this.val[10] * this.val[12] + this.val[1] * this.val[7] * this.val[10] * this.val[12] + this.val[2] * this.val[5] * this.val[11] * this.val[12] - this.val[1] * this.val[6] * this.val[11] * this.val[12] - this.val[3] * this.val[6] * this.val[8] * this.val[13] + this.val[2] * this.val[7] * this.val[8] * this.val[13] + this.val[3] * this.val[4] * this.val[10] * this.val[13] - this.val[0] * this.val[7] * this.val[10] * this.val[13] - this.val[2] * this.val[4] * this.val[11] * this.val[13] + this.val[0] * this.val[6] * this.val[11] * this.val[13] + this.val[3] * this.val[5] * this.val[8] * this.val[14] - this.val[1] * this.val[7] * this.val[8] * this.val[14] - this.val[3] * this.val[4] * this.val[9] * this.val[14] + this.val[0] * this.val[7] * this.val[9] * this.val[14] + this.val[1] * this.val[4] * this.val[11] * this.val[14] - this.val[0] * this.val[5] * this.val[11] * this.val[14] - this.val[2] * this.val[5] * this.val[8] * this.val[15] + this.val[1] * this.val[6] * this.val[8] * this.val[15] + this.val[2] * this.val[4] * this.val[9] * this.val[15] - this.val[0] * this.val[6] * this.val[9] * this.val[15] - this.val[1] * this.val[4] * this.val[10] * this.val[15] + this.val[0] * this.val[5] * this.val[10] * this.val[15];
    if (f1 == 0.0F)
      throw new RuntimeException("non-invertible matrix");
    float f2 = 1.0F / f1;
    tmp[0] = (this.val[9] * this.val[14] * this.val[7] - this.val[13] * this.val[10] * this.val[7] + this.val[13] * this.val[6] * this.val[11] - this.val[5] * this.val[14] * this.val[11] - this.val[9] * this.val[6] * this.val[15] + this.val[5] * this.val[10] * this.val[15]);
    tmp[4] = (this.val[12] * this.val[10] * this.val[7] - this.val[8] * this.val[14] * this.val[7] - this.val[12] * this.val[6] * this.val[11] + this.val[4] * this.val[14] * this.val[11] + this.val[8] * this.val[6] * this.val[15] - this.val[4] * this.val[10] * this.val[15]);
    tmp[8] = (this.val[8] * this.val[13] * this.val[7] - this.val[12] * this.val[9] * this.val[7] + this.val[12] * this.val[5] * this.val[11] - this.val[4] * this.val[13] * this.val[11] - this.val[8] * this.val[5] * this.val[15] + this.val[4] * this.val[9] * this.val[15]);
    tmp[12] = (this.val[12] * this.val[9] * this.val[6] - this.val[8] * this.val[13] * this.val[6] - this.val[12] * this.val[5] * this.val[10] + this.val[4] * this.val[13] * this.val[10] + this.val[8] * this.val[5] * this.val[14] - this.val[4] * this.val[9] * this.val[14]);
    tmp[1] = (this.val[13] * this.val[10] * this.val[3] - this.val[9] * this.val[14] * this.val[3] - this.val[13] * this.val[2] * this.val[11] + this.val[1] * this.val[14] * this.val[11] + this.val[9] * this.val[2] * this.val[15] - this.val[1] * this.val[10] * this.val[15]);
    tmp[5] = (this.val[8] * this.val[14] * this.val[3] - this.val[12] * this.val[10] * this.val[3] + this.val[12] * this.val[2] * this.val[11] - this.val[0] * this.val[14] * this.val[11] - this.val[8] * this.val[2] * this.val[15] + this.val[0] * this.val[10] * this.val[15]);
    tmp[9] = (this.val[12] * this.val[9] * this.val[3] - this.val[8] * this.val[13] * this.val[3] - this.val[12] * this.val[1] * this.val[11] + this.val[0] * this.val[13] * this.val[11] + this.val[8] * this.val[1] * this.val[15] - this.val[0] * this.val[9] * this.val[15]);
    tmp[13] = (this.val[8] * this.val[13] * this.val[2] - this.val[12] * this.val[9] * this.val[2] + this.val[12] * this.val[1] * this.val[10] - this.val[0] * this.val[13] * this.val[10] - this.val[8] * this.val[1] * this.val[14] + this.val[0] * this.val[9] * this.val[14]);
    tmp[2] = (this.val[5] * this.val[14] * this.val[3] - this.val[13] * this.val[6] * this.val[3] + this.val[13] * this.val[2] * this.val[7] - this.val[1] * this.val[14] * this.val[7] - this.val[5] * this.val[2] * this.val[15] + this.val[1] * this.val[6] * this.val[15]);
    tmp[6] = (this.val[12] * this.val[6] * this.val[3] - this.val[4] * this.val[14] * this.val[3] - this.val[12] * this.val[2] * this.val[7] + this.val[0] * this.val[14] * this.val[7] + this.val[4] * this.val[2] * this.val[15] - this.val[0] * this.val[6] * this.val[15]);
    tmp[10] = (this.val[4] * this.val[13] * this.val[3] - this.val[12] * this.val[5] * this.val[3] + this.val[12] * this.val[1] * this.val[7] - this.val[0] * this.val[13] * this.val[7] - this.val[4] * this.val[1] * this.val[15] + this.val[0] * this.val[5] * this.val[15]);
    tmp[14] = (this.val[12] * this.val[5] * this.val[2] - this.val[4] * this.val[13] * this.val[2] - this.val[12] * this.val[1] * this.val[6] + this.val[0] * this.val[13] * this.val[6] + this.val[4] * this.val[1] * this.val[14] - this.val[0] * this.val[5] * this.val[14]);
    tmp[3] = (this.val[9] * this.val[6] * this.val[3] - this.val[5] * this.val[10] * this.val[3] - this.val[9] * this.val[2] * this.val[7] + this.val[1] * this.val[10] * this.val[7] + this.val[5] * this.val[2] * this.val[11] - this.val[1] * this.val[6] * this.val[11]);
    tmp[7] = (this.val[4] * this.val[10] * this.val[3] - this.val[8] * this.val[6] * this.val[3] + this.val[8] * this.val[2] * this.val[7] - this.val[0] * this.val[10] * this.val[7] - this.val[4] * this.val[2] * this.val[11] + this.val[0] * this.val[6] * this.val[11]);
    tmp[11] = (this.val[8] * this.val[5] * this.val[3] - this.val[4] * this.val[9] * this.val[3] - this.val[8] * this.val[1] * this.val[7] + this.val[0] * this.val[9] * this.val[7] + this.val[4] * this.val[1] * this.val[11] - this.val[0] * this.val[5] * this.val[11]);
    tmp[15] = (this.val[4] * this.val[9] * this.val[2] - this.val[8] * this.val[5] * this.val[2] + this.val[8] * this.val[1] * this.val[6] - this.val[0] * this.val[9] * this.val[6] - this.val[4] * this.val[1] * this.val[10] + this.val[0] * this.val[5] * this.val[10]);
    this.val[0] = (f2 * tmp[0]);
    this.val[4] = (f2 * tmp[4]);
    this.val[8] = (f2 * tmp[8]);
    this.val[12] = (f2 * tmp[12]);
    this.val[1] = (f2 * tmp[1]);
    this.val[5] = (f2 * tmp[5]);
    this.val[9] = (f2 * tmp[9]);
    this.val[13] = (f2 * tmp[13]);
    this.val[2] = (f2 * tmp[2]);
    this.val[6] = (f2 * tmp[6]);
    this.val[10] = (f2 * tmp[10]);
    this.val[14] = (f2 * tmp[14]);
    this.val[3] = (f2 * tmp[3]);
    this.val[7] = (f2 * tmp[7]);
    this.val[11] = (f2 * tmp[11]);
    this.val[15] = (f2 * tmp[15]);
    return this;
  }

  public Matrix4 lerp(Matrix4 paramMatrix4, float paramFloat)
  {
    for (int i = 0; i < 16; i++)
      this.val[i] = (this.val[i] * (1.0F - paramFloat) + paramFloat * paramMatrix4.val[i]);
    return this;
  }

  public Matrix4 mul(Matrix4 paramMatrix4)
  {
    mul(this.val, paramMatrix4.val);
    return this;
  }

  public Matrix4 mulLeft(Matrix4 paramMatrix4)
  {
    tmpMat.set(paramMatrix4);
    mul(tmpMat.val, this.val);
    return set(tmpMat);
  }

  public Matrix4 rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat4 == 0.0F)
      return this;
    quat.setFromAxis(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return rotate(quat);
  }

  public Matrix4 rotate(Quaternion paramQuaternion)
  {
    paramQuaternion.toMatrix(tmp);
    mul(this.val, tmp);
    return this;
  }

  public Matrix4 rotate(Vector3 paramVector3, float paramFloat)
  {
    if (paramFloat == 0.0F)
      return this;
    quat.set(paramVector3, paramFloat);
    return rotate(quat);
  }

  public Matrix4 rotate(Vector3 paramVector31, Vector3 paramVector32)
  {
    return rotate(quat.setFromCross(paramVector31, paramVector32));
  }

  public Matrix4 rotateRad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat4 == 0.0F)
      return this;
    quat.setFromAxisRad(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return rotate(quat);
  }

  public Matrix4 rotateRad(Vector3 paramVector3, float paramFloat)
  {
    if (paramFloat == 0.0F)
      return this;
    quat.setFromAxisRad(paramVector3, paramFloat);
    return rotate(quat);
  }

  public Matrix4 scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    tmp[0] = paramFloat1;
    tmp[4] = 0.0F;
    tmp[8] = 0.0F;
    tmp[12] = 0.0F;
    tmp[1] = 0.0F;
    tmp[5] = paramFloat2;
    tmp[9] = 0.0F;
    tmp[13] = 0.0F;
    tmp[2] = 0.0F;
    tmp[6] = 0.0F;
    tmp[10] = paramFloat3;
    tmp[14] = 0.0F;
    tmp[3] = 0.0F;
    tmp[7] = 0.0F;
    tmp[11] = 0.0F;
    tmp[15] = 1.0F;
    mul(this.val, tmp);
    return this;
  }

  public Matrix4 scl(float paramFloat)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[0] = (paramFloat * arrayOfFloat1[0]);
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[5] = (paramFloat * arrayOfFloat2[5]);
    float[] arrayOfFloat3 = this.val;
    arrayOfFloat3[10] = (paramFloat * arrayOfFloat3[10]);
    return this;
  }

  public Matrix4 scl(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[0] = (paramFloat1 * arrayOfFloat1[0]);
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[5] = (paramFloat2 * arrayOfFloat2[5]);
    float[] arrayOfFloat3 = this.val;
    arrayOfFloat3[10] = (paramFloat3 * arrayOfFloat3[10]);
    return this;
  }

  public Matrix4 scl(Vector3 paramVector3)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[0] *= paramVector3.x;
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[5] *= paramVector3.y;
    float[] arrayOfFloat3 = this.val;
    arrayOfFloat3[10] *= paramVector3.z;
    return this;
  }

  public Matrix4 set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return set(0.0F, 0.0F, 0.0F, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public Matrix4 set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    float f1 = 2.0F * paramFloat4;
    float f2 = 2.0F * paramFloat5;
    float f3 = 2.0F * paramFloat6;
    float f4 = paramFloat7 * f1;
    float f5 = paramFloat7 * f2;
    float f6 = paramFloat7 * f3;
    float f7 = f1 * paramFloat4;
    float f8 = paramFloat4 * f2;
    float f9 = paramFloat4 * f3;
    float f10 = f2 * paramFloat5;
    float f11 = paramFloat5 * f3;
    float f12 = f3 * paramFloat6;
    this.val[0] = (1.0F - (f10 + f12));
    this.val[4] = (f8 - f6);
    this.val[8] = (f9 + f5);
    this.val[12] = paramFloat1;
    this.val[1] = (f6 + f8);
    this.val[5] = (1.0F - (f12 + f7));
    this.val[9] = (f11 - f4);
    this.val[13] = paramFloat2;
    this.val[2] = (f9 - f5);
    this.val[6] = (f4 + f11);
    this.val[10] = (1.0F - (f7 + f10));
    this.val[14] = paramFloat3;
    this.val[3] = 0.0F;
    this.val[7] = 0.0F;
    this.val[11] = 0.0F;
    this.val[15] = 1.0F;
    return this;
  }

  public Matrix4 set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10)
  {
    float f1 = 2.0F * paramFloat4;
    float f2 = 2.0F * paramFloat5;
    float f3 = 2.0F * paramFloat6;
    float f4 = paramFloat7 * f1;
    float f5 = paramFloat7 * f2;
    float f6 = paramFloat7 * f3;
    float f7 = f1 * paramFloat4;
    float f8 = paramFloat4 * f2;
    float f9 = paramFloat4 * f3;
    float f10 = f2 * paramFloat5;
    float f11 = paramFloat5 * f3;
    float f12 = f3 * paramFloat6;
    this.val[0] = (paramFloat8 * (1.0F - (f10 + f12)));
    this.val[4] = (paramFloat9 * (f8 - f6));
    this.val[8] = (paramFloat10 * (f9 + f5));
    this.val[12] = paramFloat1;
    this.val[1] = (paramFloat8 * (f6 + f8));
    this.val[5] = (paramFloat9 * (1.0F - (f12 + f7)));
    this.val[9] = (paramFloat10 * (f11 - f4));
    this.val[13] = paramFloat2;
    this.val[2] = (paramFloat8 * (f9 - f5));
    this.val[6] = (paramFloat9 * (f4 + f11));
    this.val[10] = (paramFloat10 * (1.0F - (f7 + f10)));
    this.val[14] = paramFloat3;
    this.val[3] = 0.0F;
    this.val[7] = 0.0F;
    this.val[11] = 0.0F;
    this.val[15] = 1.0F;
    return this;
  }

  public Matrix4 set(Affine2 paramAffine2)
  {
    this.val[0] = paramAffine2.m00;
    this.val[1] = paramAffine2.m10;
    this.val[2] = 0.0F;
    this.val[3] = 0.0F;
    this.val[4] = paramAffine2.m01;
    this.val[5] = paramAffine2.m11;
    this.val[6] = 0.0F;
    this.val[7] = 0.0F;
    this.val[8] = 0.0F;
    this.val[9] = 0.0F;
    this.val[10] = 1.0F;
    this.val[11] = 0.0F;
    this.val[12] = paramAffine2.m02;
    this.val[13] = paramAffine2.m12;
    this.val[14] = 0.0F;
    this.val[15] = 1.0F;
    return this;
  }

  public Matrix4 set(Matrix3 paramMatrix3)
  {
    this.val[0] = paramMatrix3.val[0];
    this.val[1] = paramMatrix3.val[1];
    this.val[2] = paramMatrix3.val[2];
    this.val[3] = 0.0F;
    this.val[4] = paramMatrix3.val[3];
    this.val[5] = paramMatrix3.val[4];
    this.val[6] = paramMatrix3.val[5];
    this.val[7] = 0.0F;
    this.val[8] = 0.0F;
    this.val[9] = 0.0F;
    this.val[10] = 1.0F;
    this.val[11] = 0.0F;
    this.val[12] = paramMatrix3.val[6];
    this.val[13] = paramMatrix3.val[7];
    this.val[14] = 0.0F;
    this.val[15] = paramMatrix3.val[8];
    return this;
  }

  public Matrix4 set(Matrix4 paramMatrix4)
  {
    return set(paramMatrix4.val);
  }

  public Matrix4 set(Quaternion paramQuaternion)
  {
    return set(paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w);
  }

  public Matrix4 set(Vector3 paramVector3, Quaternion paramQuaternion)
  {
    return set(paramVector3.x, paramVector3.y, paramVector3.z, paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w);
  }

  public Matrix4 set(Vector3 paramVector31, Quaternion paramQuaternion, Vector3 paramVector32)
  {
    return set(paramVector31.x, paramVector31.y, paramVector31.z, paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w, paramVector32.x, paramVector32.y, paramVector32.z);
  }

  public Matrix4 set(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34)
  {
    this.val[0] = paramVector31.x;
    this.val[4] = paramVector31.y;
    this.val[8] = paramVector31.z;
    this.val[1] = paramVector32.x;
    this.val[5] = paramVector32.y;
    this.val[9] = paramVector32.z;
    this.val[2] = paramVector33.x;
    this.val[6] = paramVector33.y;
    this.val[10] = paramVector33.z;
    this.val[12] = paramVector34.x;
    this.val[13] = paramVector34.y;
    this.val[14] = paramVector34.z;
    this.val[3] = 0.0F;
    this.val[7] = 0.0F;
    this.val[11] = 0.0F;
    this.val[15] = 1.0F;
    return this;
  }

  public Matrix4 set(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.val, 0, this.val.length);
    return this;
  }

  public Matrix4 setAsAffine(Affine2 paramAffine2)
  {
    this.val[0] = paramAffine2.m00;
    this.val[1] = paramAffine2.m10;
    this.val[4] = paramAffine2.m01;
    this.val[5] = paramAffine2.m11;
    this.val[12] = paramAffine2.m02;
    this.val[13] = paramAffine2.m12;
    return this;
  }

  public Matrix4 setAsAffine(Matrix4 paramMatrix4)
  {
    this.val[0] = paramMatrix4.val[0];
    this.val[1] = paramMatrix4.val[1];
    this.val[4] = paramMatrix4.val[4];
    this.val[5] = paramMatrix4.val[5];
    this.val[12] = paramMatrix4.val[12];
    this.val[13] = paramMatrix4.val[13];
    return this;
  }

  public Matrix4 setFromEulerAngles(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    quat.setEulerAngles(paramFloat1, paramFloat2, paramFloat3);
    return set(quat);
  }

  public Matrix4 setFromEulerAnglesRad(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    quat.setEulerAnglesRad(paramFloat1, paramFloat2, paramFloat3);
    return set(quat);
  }

  public Matrix4 setToLookAt(Vector3 paramVector31, Vector3 paramVector32)
  {
    l_vez.set(paramVector31).nor();
    l_vex.set(paramVector31).nor();
    l_vex.crs(paramVector32).nor();
    l_vey.set(l_vex).crs(l_vez).nor();
    idt();
    this.val[0] = l_vex.x;
    this.val[4] = l_vex.y;
    this.val[8] = l_vex.z;
    this.val[1] = l_vey.x;
    this.val[5] = l_vey.y;
    this.val[9] = l_vey.z;
    this.val[2] = (-l_vez.x);
    this.val[6] = (-l_vez.y);
    this.val[10] = (-l_vez.z);
    return this;
  }

  public Matrix4 setToLookAt(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33)
  {
    tmpVec.set(paramVector32).sub(paramVector31);
    setToLookAt(tmpVec, paramVector33);
    mul(tmpMat.setToTranslation(-paramVector31.x, -paramVector31.y, -paramVector31.z));
    return this;
  }

  public Matrix4 setToOrtho(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    idt();
    float f1 = 2.0F / (paramFloat2 - paramFloat1);
    float f2 = 2.0F / (paramFloat4 - paramFloat3);
    float f3 = -2.0F / (paramFloat6 - paramFloat5);
    float f4 = -(paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1);
    float f5 = -(paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3);
    float f6 = -(paramFloat6 + paramFloat5) / (paramFloat6 - paramFloat5);
    this.val[0] = f1;
    this.val[1] = 0.0F;
    this.val[2] = 0.0F;
    this.val[3] = 0.0F;
    this.val[4] = 0.0F;
    this.val[5] = f2;
    this.val[6] = 0.0F;
    this.val[7] = 0.0F;
    this.val[8] = 0.0F;
    this.val[9] = 0.0F;
    this.val[10] = f3;
    this.val[11] = 0.0F;
    this.val[12] = f4;
    this.val[13] = f5;
    this.val[14] = f6;
    this.val[15] = 1.0F;
    return this;
  }

  public Matrix4 setToOrtho2D(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setToOrtho(paramFloat1, paramFloat1 + paramFloat3, paramFloat2, paramFloat2 + paramFloat4, 0.0F, 1.0F);
    return this;
  }

  public Matrix4 setToOrtho2D(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    setToOrtho(paramFloat1, paramFloat1 + paramFloat3, paramFloat2, paramFloat2 + paramFloat4, paramFloat5, paramFloat6);
    return this;
  }

  public Matrix4 setToProjection(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    idt();
    float f1 = (float)(1.0D / Math.tan(0.0174532925199433D * paramFloat3 / 2.0D));
    float f2 = (paramFloat2 + paramFloat1) / (paramFloat1 - paramFloat2);
    float f3 = paramFloat1 * (2.0F * paramFloat2) / (paramFloat1 - paramFloat2);
    this.val[0] = (f1 / paramFloat4);
    this.val[1] = 0.0F;
    this.val[2] = 0.0F;
    this.val[3] = 0.0F;
    this.val[4] = 0.0F;
    this.val[5] = f1;
    this.val[6] = 0.0F;
    this.val[7] = 0.0F;
    this.val[8] = 0.0F;
    this.val[9] = 0.0F;
    this.val[10] = f2;
    this.val[11] = -1.0F;
    this.val[12] = 0.0F;
    this.val[13] = 0.0F;
    this.val[14] = f3;
    this.val[15] = 0.0F;
    return this;
  }

  public Matrix4 setToProjection(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f1 = paramFloat5 * 2.0F / (paramFloat2 - paramFloat1);
    float f2 = paramFloat5 * 2.0F / (paramFloat4 - paramFloat3);
    float f3 = (paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1);
    float f4 = (paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3);
    float f5 = (paramFloat6 + paramFloat5) / (paramFloat5 - paramFloat6);
    float f6 = paramFloat5 * (paramFloat6 * 2.0F) / (paramFloat5 - paramFloat6);
    this.val[0] = f1;
    this.val[1] = 0.0F;
    this.val[2] = 0.0F;
    this.val[3] = 0.0F;
    this.val[4] = 0.0F;
    this.val[5] = f2;
    this.val[6] = 0.0F;
    this.val[7] = 0.0F;
    this.val[8] = f3;
    this.val[9] = f4;
    this.val[10] = f5;
    this.val[11] = -1.0F;
    this.val[12] = 0.0F;
    this.val[13] = 0.0F;
    this.val[14] = f6;
    this.val[15] = 0.0F;
    return this;
  }

  public Matrix4 setToRotation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat4 == 0.0F)
    {
      idt();
      return this;
    }
    return set(quat.setFromAxis(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }

  public Matrix4 setToRotation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return set(quat.setFromCross(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6));
  }

  public Matrix4 setToRotation(Vector3 paramVector3, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      idt();
      return this;
    }
    return set(quat.set(paramVector3, paramFloat));
  }

  public Matrix4 setToRotation(Vector3 paramVector31, Vector3 paramVector32)
  {
    return set(quat.setFromCross(paramVector31, paramVector32));
  }

  public Matrix4 setToRotationRad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat4 == 0.0F)
    {
      idt();
      return this;
    }
    return set(quat.setFromAxisRad(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }

  public Matrix4 setToRotationRad(Vector3 paramVector3, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      idt();
      return this;
    }
    return set(quat.setFromAxisRad(paramVector3, paramFloat));
  }

  public Matrix4 setToScaling(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    idt();
    this.val[0] = paramFloat1;
    this.val[5] = paramFloat2;
    this.val[10] = paramFloat3;
    return this;
  }

  public Matrix4 setToScaling(Vector3 paramVector3)
  {
    idt();
    this.val[0] = paramVector3.x;
    this.val[5] = paramVector3.y;
    this.val[10] = paramVector3.z;
    return this;
  }

  public Matrix4 setToTranslation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    idt();
    this.val[12] = paramFloat1;
    this.val[13] = paramFloat2;
    this.val[14] = paramFloat3;
    return this;
  }

  public Matrix4 setToTranslation(Vector3 paramVector3)
  {
    idt();
    this.val[12] = paramVector3.x;
    this.val[13] = paramVector3.y;
    this.val[14] = paramVector3.z;
    return this;
  }

  public Matrix4 setToTranslationAndScaling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    idt();
    this.val[12] = paramFloat1;
    this.val[13] = paramFloat2;
    this.val[14] = paramFloat3;
    this.val[0] = paramFloat4;
    this.val[5] = paramFloat5;
    this.val[10] = paramFloat6;
    return this;
  }

  public Matrix4 setToTranslationAndScaling(Vector3 paramVector31, Vector3 paramVector32)
  {
    idt();
    this.val[12] = paramVector31.x;
    this.val[13] = paramVector31.y;
    this.val[14] = paramVector31.z;
    this.val[0] = paramVector32.x;
    this.val[5] = paramVector32.y;
    this.val[10] = paramVector32.z;
    return this;
  }

  public Matrix4 setToWorld(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33)
  {
    tmpForward.set(paramVector32).nor();
    right.set(tmpForward).crs(paramVector33).nor();
    tmpUp.set(right).crs(tmpForward).nor();
    set(right, tmpUp, tmpForward.scl(-1.0F), paramVector31);
    return this;
  }

  public Matrix4 setTranslation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.val[12] = paramFloat1;
    this.val[13] = paramFloat2;
    this.val[14] = paramFloat3;
    return this;
  }

  public Matrix4 setTranslation(Vector3 paramVector3)
  {
    this.val[12] = paramVector3.x;
    this.val[13] = paramVector3.y;
    this.val[14] = paramVector3.z;
    return this;
  }

  public Matrix4 toNormalMatrix()
  {
    this.val[12] = 0.0F;
    this.val[13] = 0.0F;
    this.val[14] = 0.0F;
    return inv().tra();
  }

  public String toString()
  {
    return "[" + this.val[0] + "|" + this.val[4] + "|" + this.val[8] + "|" + this.val[12] + "]\n[" + this.val[1] + "|" + this.val[5] + "|" + this.val[9] + "|" + this.val[13] + "]\n[" + this.val[2] + "|" + this.val[6] + "|" + this.val[10] + "|" + this.val[14] + "]\n[" + this.val[3] + "|" + this.val[7] + "|" + this.val[11] + "|" + this.val[15] + "]\n";
  }

  public Matrix4 tra()
  {
    tmp[0] = this.val[0];
    tmp[4] = this.val[1];
    tmp[8] = this.val[2];
    tmp[12] = this.val[3];
    tmp[1] = this.val[4];
    tmp[5] = this.val[5];
    tmp[9] = this.val[6];
    tmp[13] = this.val[7];
    tmp[2] = this.val[8];
    tmp[6] = this.val[9];
    tmp[10] = this.val[10];
    tmp[14] = this.val[11];
    tmp[3] = this.val[12];
    tmp[7] = this.val[13];
    tmp[11] = this.val[14];
    tmp[15] = this.val[15];
    return set(tmp);
  }

  public Matrix4 translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    tmp[0] = 1.0F;
    tmp[4] = 0.0F;
    tmp[8] = 0.0F;
    tmp[12] = paramFloat1;
    tmp[1] = 0.0F;
    tmp[5] = 1.0F;
    tmp[9] = 0.0F;
    tmp[13] = paramFloat2;
    tmp[2] = 0.0F;
    tmp[6] = 0.0F;
    tmp[10] = 1.0F;
    tmp[14] = paramFloat3;
    tmp[3] = 0.0F;
    tmp[7] = 0.0F;
    tmp[11] = 0.0F;
    tmp[15] = 1.0F;
    mul(this.val, tmp);
    return this;
  }

  public Matrix4 translate(Vector3 paramVector3)
  {
    return translate(paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public Matrix4 trn(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[12] = (paramFloat1 + arrayOfFloat1[12]);
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[13] = (paramFloat2 + arrayOfFloat2[13]);
    float[] arrayOfFloat3 = this.val;
    arrayOfFloat3[14] = (paramFloat3 + arrayOfFloat3[14]);
    return this;
  }

  public Matrix4 trn(Vector3 paramVector3)
  {
    float[] arrayOfFloat1 = this.val;
    arrayOfFloat1[12] += paramVector3.x;
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat2[13] += paramVector3.y;
    float[] arrayOfFloat3 = this.val;
    arrayOfFloat3[14] += paramVector3.z;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Matrix4
 * JD-Core Version:    0.6.0
 */