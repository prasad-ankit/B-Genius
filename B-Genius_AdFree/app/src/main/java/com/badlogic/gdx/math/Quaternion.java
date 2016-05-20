package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Quaternion
  implements Serializable
{
  private static final long serialVersionUID = -7661875440774897168L;
  private static Quaternion tmp1 = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
  private static Quaternion tmp2 = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
  public float w;
  public float x;
  public float y;
  public float z;

  public Quaternion()
  {
    idt();
  }

  public Quaternion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public Quaternion(Quaternion paramQuaternion)
  {
    set(paramQuaternion);
  }

  public Quaternion(Vector3 paramVector3, float paramFloat)
  {
    set(paramVector3, paramFloat);
  }

  public static final float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    return paramFloat1 * paramFloat5 + paramFloat2 * paramFloat6 + paramFloat3 * paramFloat7 + paramFloat4 * paramFloat8;
  }

  public static final float len(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4);
  }

  public static final float len2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4;
  }

  public Quaternion add(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = (paramFloat1 + this.x);
    this.y = (paramFloat2 + this.y);
    this.z = (paramFloat3 + this.z);
    this.w = (paramFloat4 + this.w);
    return this;
  }

  public Quaternion add(Quaternion paramQuaternion)
  {
    this.x += paramQuaternion.x;
    this.y += paramQuaternion.y;
    this.z += paramQuaternion.z;
    this.w += paramQuaternion.w;
    return this;
  }

  public Quaternion conjugate()
  {
    this.x = (-this.x);
    this.y = (-this.y);
    this.z = (-this.z);
    return this;
  }

  public Quaternion cpy()
  {
    return new Quaternion(this);
  }

  public float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat1 * this.x + paramFloat2 * this.y + paramFloat3 * this.z + paramFloat4 * this.w;
  }

  public float dot(Quaternion paramQuaternion)
  {
    return this.x * paramQuaternion.x + this.y * paramQuaternion.y + this.z * paramQuaternion.z + this.w * paramQuaternion.w;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Quaternion localQuaternion;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (!(paramObject instanceof Quaternion))
        return false;
      localQuaternion = (Quaternion)paramObject;
    }
    while ((NumberUtils.floatToRawIntBits(this.w) == NumberUtils.floatToRawIntBits(localQuaternion.w)) && (NumberUtils.floatToRawIntBits(this.x) == NumberUtils.floatToRawIntBits(localQuaternion.x)) && (NumberUtils.floatToRawIntBits(this.y) == NumberUtils.floatToRawIntBits(localQuaternion.y)) && (NumberUtils.floatToRawIntBits(this.z) == NumberUtils.floatToRawIntBits(localQuaternion.z)));
    return false;
  }

  public Quaternion exp(float paramFloat)
  {
    float f1 = len();
    float f2 = (float)Math.pow(f1, paramFloat);
    float f3 = (float)Math.acos(this.w / f1);
    float f4;
    if (Math.abs(f3) < 0.001D)
      f4 = f2 * paramFloat / f1;
    while (true)
    {
      this.w = (float)(f2 * Math.cos(paramFloat * f3));
      this.x = (f4 * this.x);
      this.y = (f4 * this.y);
      this.z = (f4 * this.z);
      nor();
      return this;
      f4 = (float)(f2 * Math.sin(paramFloat * f3) / (f1 * Math.sin(f3)));
    }
  }

  public float getAngle()
  {
    return 57.295776F * getAngleRad();
  }

  public float getAngleAround(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return 57.295776F * getAngleAroundRad(paramFloat1, paramFloat2, paramFloat3);
  }

  public float getAngleAround(Vector3 paramVector3)
  {
    return getAngleAround(paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public float getAngleAroundRad(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Vector3.dot(this.x, this.y, this.z, paramFloat1, paramFloat2, paramFloat3);
    float f2 = len2(paramFloat1 * f1, paramFloat2 * f1, f1 * paramFloat3, this.w);
    if (MathUtils.isZero(f2))
      return 0.0F;
    return (float)(2.0D * Math.acos(MathUtils.clamp((float)(this.w / Math.sqrt(f2)), -1.0F, 1.0F)));
  }

  public float getAngleAroundRad(Vector3 paramVector3)
  {
    return getAngleAroundRad(paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public float getAngleRad()
  {
    double d;
    if (this.w > 1.0F)
      d = this.w / len();
    while (true)
    {
      return (float)(2.0D * Math.acos(d));
      d = this.w;
    }
  }

  public float getAxisAngle(Vector3 paramVector3)
  {
    return 57.295776F * getAxisAngleRad(paramVector3);
  }

  public float getAxisAngleRad(Vector3 paramVector3)
  {
    if (this.w > 1.0F)
      nor();
    float f = (float)(2.0D * Math.acos(this.w));
    double d = Math.sqrt(1.0F - this.w * this.w);
    if (d < 9.999999974752427E-007D)
    {
      paramVector3.x = this.x;
      paramVector3.y = this.y;
      paramVector3.z = this.z;
      return f;
    }
    paramVector3.x = (float)(this.x / d);
    paramVector3.y = (float)(this.y / d);
    paramVector3.z = (float)(this.z / d);
    return f;
  }

  public int getGimbalPole()
  {
    float f = this.y * this.x + this.z * this.w;
    if (f > 0.499F)
      return 1;
    if (f < -0.499F)
      return -1;
    return 0;
  }

  public float getPitch()
  {
    return 57.295776F * getPitchRad();
  }

  public float getPitchRad()
  {
    int i = getGimbalPole();
    if (i == 0)
      return (float)Math.asin(MathUtils.clamp(2.0F * (this.w * this.x - this.z * this.y), -1.0F, 1.0F));
    return 0.5F * (3.141593F * i);
  }

  public float getRoll()
  {
    return 57.295776F * getRollRad();
  }

  public float getRollRad()
  {
    int i = getGimbalPole();
    if (i == 0)
      return MathUtils.atan2(2.0F * (this.w * this.z + this.y * this.x), 1.0F - 2.0F * (this.x * this.x + this.z * this.z));
    return 2.0F * i * MathUtils.atan2(this.y, this.w);
  }

  public void getSwingTwist(float paramFloat1, float paramFloat2, float paramFloat3, Quaternion paramQuaternion1, Quaternion paramQuaternion2)
  {
    float f = Vector3.dot(this.x, this.y, this.z, paramFloat1, paramFloat2, paramFloat3);
    paramQuaternion2.set(paramFloat1 * f, paramFloat2 * f, f * paramFloat3, this.w).nor();
    paramQuaternion1.set(paramQuaternion2).conjugate().mulLeft(this);
  }

  public void getSwingTwist(Vector3 paramVector3, Quaternion paramQuaternion1, Quaternion paramQuaternion2)
  {
    getSwingTwist(paramVector3.x, paramVector3.y, paramVector3.z, paramQuaternion1, paramQuaternion2);
  }

  public float getYaw()
  {
    return 57.295776F * getYawRad();
  }

  public float getYawRad()
  {
    if (getGimbalPole() == 0)
      return MathUtils.atan2(2.0F * (this.y * this.w + this.x * this.z), 1.0F - 2.0F * (this.y * this.y + this.x * this.x));
    return 0.0F;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (31 + NumberUtils.floatToRawIntBits(this.w)) + NumberUtils.floatToRawIntBits(this.x)) + NumberUtils.floatToRawIntBits(this.y)) + NumberUtils.floatToRawIntBits(this.z);
  }

  public Quaternion idt()
  {
    return set(0.0F, 0.0F, 0.0F, 1.0F);
  }

  public boolean isIdentity()
  {
    return (MathUtils.isZero(this.x)) && (MathUtils.isZero(this.y)) && (MathUtils.isZero(this.z)) && (MathUtils.isEqual(this.w, 1.0F));
  }

  public boolean isIdentity(float paramFloat)
  {
    return (MathUtils.isZero(this.x, paramFloat)) && (MathUtils.isZero(this.y, paramFloat)) && (MathUtils.isZero(this.z, paramFloat)) && (MathUtils.isEqual(this.w, 1.0F, paramFloat));
  }

  public float len()
  {
    return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
  }

  public float len2()
  {
    return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
  }

  public Quaternion mul(float paramFloat)
  {
    this.x = (paramFloat * this.x);
    this.y = (paramFloat * this.y);
    this.z = (paramFloat * this.z);
    this.w = (paramFloat * this.w);
    return this;
  }

  public Quaternion mul(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 * this.w + paramFloat4 * this.x + paramFloat3 * this.y - paramFloat2 * this.z;
    float f2 = paramFloat2 * this.w + paramFloat4 * this.y + paramFloat1 * this.z - paramFloat3 * this.x;
    float f3 = paramFloat3 * this.w + paramFloat4 * this.z + paramFloat2 * this.x - paramFloat1 * this.y;
    float f4 = paramFloat4 * this.w - paramFloat1 * this.x - paramFloat2 * this.y - paramFloat3 * this.z;
    this.x = f1;
    this.y = f2;
    this.z = f3;
    this.w = f4;
    return this;
  }

  public Quaternion mul(Quaternion paramQuaternion)
  {
    float f1 = this.w * paramQuaternion.x + this.x * paramQuaternion.w + this.y * paramQuaternion.z - this.z * paramQuaternion.y;
    float f2 = this.w * paramQuaternion.y + this.y * paramQuaternion.w + this.z * paramQuaternion.x - this.x * paramQuaternion.z;
    float f3 = this.w * paramQuaternion.z + this.z * paramQuaternion.w + this.x * paramQuaternion.y - this.y * paramQuaternion.x;
    float f4 = this.w * paramQuaternion.w - this.x * paramQuaternion.x - this.y * paramQuaternion.y - this.z * paramQuaternion.z;
    this.x = f1;
    this.y = f2;
    this.z = f3;
    this.w = f4;
    return this;
  }

  public Quaternion mulLeft(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat4 * this.x + paramFloat1 * this.w + paramFloat2 * this.z - paramFloat3 * paramFloat2;
    float f2 = paramFloat4 * this.y + paramFloat2 * this.w + paramFloat3 * this.x - paramFloat1 * paramFloat3;
    float f3 = paramFloat4 * this.z + paramFloat3 * this.w + paramFloat1 * this.y - paramFloat2 * paramFloat1;
    float f4 = paramFloat4 * this.w - paramFloat1 * this.x - paramFloat2 * this.y - paramFloat3 * paramFloat3;
    this.x = f1;
    this.y = f2;
    this.z = f3;
    this.w = f4;
    return this;
  }

  public Quaternion mulLeft(Quaternion paramQuaternion)
  {
    float f1 = paramQuaternion.w * this.x + paramQuaternion.x * this.w + paramQuaternion.y * this.z - paramQuaternion.z * this.y;
    float f2 = paramQuaternion.w * this.y + paramQuaternion.y * this.w + paramQuaternion.z * this.x - paramQuaternion.x * this.z;
    float f3 = paramQuaternion.w * this.z + paramQuaternion.z * this.w + paramQuaternion.x * this.y - paramQuaternion.y * this.x;
    float f4 = paramQuaternion.w * this.w - paramQuaternion.x * this.x - paramQuaternion.y * this.y - paramQuaternion.z * this.z;
    this.x = f1;
    this.y = f2;
    this.z = f3;
    this.w = f4;
    return this;
  }

  public Quaternion nor()
  {
    float f1 = len2();
    if ((f1 != 0.0F) && (!MathUtils.isEqual(f1, 1.0F)))
    {
      float f2 = (float)Math.sqrt(f1);
      this.w /= f2;
      this.x /= f2;
      this.y /= f2;
      this.z /= f2;
    }
    return this;
  }

  public Quaternion set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
    return this;
  }

  public Quaternion set(Quaternion paramQuaternion)
  {
    return set(paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w);
  }

  public Quaternion set(Vector3 paramVector3, float paramFloat)
  {
    return setFromAxis(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
  }

  public Quaternion setEulerAngles(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return setEulerAnglesRad(paramFloat1 * 0.01745329F, paramFloat2 * 0.01745329F, 0.01745329F * paramFloat3);
  }

  public Quaternion setEulerAnglesRad(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat3 * 0.5F;
    float f2 = (float)Math.sin(f1);
    float f3 = (float)Math.cos(f1);
    float f4 = paramFloat2 * 0.5F;
    float f5 = (float)Math.sin(f4);
    float f6 = (float)Math.cos(f4);
    float f7 = paramFloat1 * 0.5F;
    float f8 = (float)Math.sin(f7);
    float f9 = (float)Math.cos(f7);
    float f10 = f9 * f5;
    float f11 = f8 * f6;
    float f12 = f6 * f9;
    float f13 = f5 * f8;
    this.x = (f10 * f3 + f11 * f2);
    this.y = (f11 * f3 - f10 * f2);
    this.z = (f12 * f2 - f13 * f3);
    this.w = (f3 * f12 + f2 * f13);
    return this;
  }

  public Quaternion setFromAxes(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    return setFromAxes(false, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }

  public Quaternion setFromAxes(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    if (paramBoolean)
    {
      float f10 = 1.0F / Vector3.len(paramFloat1, paramFloat2, paramFloat3);
      float f11 = 1.0F / Vector3.len(paramFloat4, paramFloat5, paramFloat6);
      float f12 = 1.0F / Vector3.len(paramFloat7, paramFloat8, paramFloat9);
      paramFloat1 *= f10;
      paramFloat2 *= f10;
      paramFloat3 *= f10;
      paramFloat4 *= f11;
      paramFloat5 *= f11;
      paramFloat6 *= f11;
      paramFloat7 *= f12;
      paramFloat8 *= f12;
      paramFloat9 *= f12;
    }
    float f1 = paramFloat9 + (paramFloat1 + paramFloat5);
    if (f1 >= 0.0F)
    {
      float f8 = (float)Math.sqrt(f1 + 1.0F);
      this.w = (0.5F * f8);
      float f9 = 0.5F / f8;
      this.x = (f9 * (paramFloat8 - paramFloat6));
      this.y = (f9 * (paramFloat3 - paramFloat7));
      this.z = (f9 * (paramFloat4 - paramFloat2));
      return this;
    }
    if ((paramFloat1 > paramFloat5) && (paramFloat1 > paramFloat9))
    {
      float f6 = (float)Math.sqrt(1.0D + paramFloat1 - paramFloat5 - paramFloat9);
      this.x = (0.5F * f6);
      float f7 = 0.5F / f6;
      this.y = (f7 * (paramFloat4 + paramFloat2));
      this.z = (f7 * (paramFloat3 + paramFloat7));
      this.w = (f7 * (paramFloat8 - paramFloat6));
      return this;
    }
    if (paramFloat5 > paramFloat9)
    {
      float f4 = (float)Math.sqrt(1.0D + paramFloat5 - paramFloat1 - paramFloat9);
      this.y = (0.5F * f4);
      float f5 = 0.5F / f4;
      this.x = (f5 * (paramFloat4 + paramFloat2));
      this.z = (f5 * (paramFloat8 + paramFloat6));
      this.w = (f5 * (paramFloat3 - paramFloat7));
      return this;
    }
    float f2 = (float)Math.sqrt(1.0D + paramFloat9 - paramFloat1 - paramFloat5);
    this.z = (0.5F * f2);
    float f3 = 0.5F / f2;
    this.x = (f3 * (paramFloat3 + paramFloat7));
    this.y = (f3 * (paramFloat8 + paramFloat6));
    this.w = (f3 * (paramFloat4 - paramFloat2));
    return this;
  }

  public Quaternion setFromAxis(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return setFromAxisRad(paramFloat1, paramFloat2, paramFloat3, 0.01745329F * paramFloat4);
  }

  public Quaternion setFromAxis(Vector3 paramVector3, float paramFloat)
  {
    return setFromAxis(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
  }

  public Quaternion setFromAxisRad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = Vector3.len(paramFloat1, paramFloat2, paramFloat3);
    if (f1 == 0.0F)
      return idt();
    float f2 = 1.0F / f1;
    float f3;
    if (paramFloat4 < 0.0F)
      f3 = 6.283186F - -paramFloat4 % 6.283186F;
    while (true)
    {
      float f4 = (float)Math.sin(f3 / 2.0F);
      float f5 = (float)Math.cos(f3 / 2.0F);
      return set(f4 * (f2 * paramFloat1), f4 * (f2 * paramFloat2), f4 * (f2 * paramFloat3), f5).nor();
      f3 = paramFloat4 % 6.283186F;
    }
  }

  public Quaternion setFromAxisRad(Vector3 paramVector3, float paramFloat)
  {
    return setFromAxisRad(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
  }

  public Quaternion setFromCross(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f = (float)Math.acos(MathUtils.clamp(Vector3.dot(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6), -1.0F, 1.0F));
    return setFromAxisRad(paramFloat2 * paramFloat6 - paramFloat3 * paramFloat5, paramFloat3 * paramFloat4 - paramFloat1 * paramFloat6, paramFloat1 * paramFloat5 - paramFloat2 * paramFloat4, f);
  }

  public Quaternion setFromCross(Vector3 paramVector31, Vector3 paramVector32)
  {
    float f = (float)Math.acos(MathUtils.clamp(paramVector31.dot(paramVector32), -1.0F, 1.0F));
    return setFromAxisRad(paramVector31.y * paramVector32.z - paramVector31.z * paramVector32.y, paramVector31.z * paramVector32.x - paramVector31.x * paramVector32.z, paramVector31.x * paramVector32.y - paramVector31.y * paramVector32.x, f);
  }

  public Quaternion setFromMatrix(Matrix3 paramMatrix3)
  {
    return setFromMatrix(false, paramMatrix3);
  }

  public Quaternion setFromMatrix(Matrix4 paramMatrix4)
  {
    return setFromMatrix(false, paramMatrix4);
  }

  public Quaternion setFromMatrix(boolean paramBoolean, Matrix3 paramMatrix3)
  {
    return setFromAxes(paramBoolean, paramMatrix3.val[0], paramMatrix3.val[3], paramMatrix3.val[6], paramMatrix3.val[1], paramMatrix3.val[4], paramMatrix3.val[7], paramMatrix3.val[2], paramMatrix3.val[5], paramMatrix3.val[8]);
  }

  public Quaternion setFromMatrix(boolean paramBoolean, Matrix4 paramMatrix4)
  {
    return setFromAxes(paramBoolean, paramMatrix4.val[0], paramMatrix4.val[4], paramMatrix4.val[8], paramMatrix4.val[1], paramMatrix4.val[5], paramMatrix4.val[9], paramMatrix4.val[2], paramMatrix4.val[6], paramMatrix4.val[10]);
  }

  public Quaternion slerp(Quaternion paramQuaternion, float paramFloat)
  {
    float f1 = this.x * paramQuaternion.x + this.y * paramQuaternion.y + this.z * paramQuaternion.z + this.w * paramQuaternion.w;
    float f2;
    float f3;
    float f4;
    float f5;
    if (f1 < 0.0F)
    {
      f2 = -f1;
      f3 = 1.0F - paramFloat;
      if (1.0F - f2 <= 0.1D)
        break label211;
      float f6 = (float)Math.acos(f2);
      float f7 = 1.0F / (float)Math.sin(f6);
      f4 = f7 * (float)Math.sin(f3 * f6);
      f5 = f7 * (float)Math.sin(paramFloat * f6);
    }
    while (true)
    {
      if (f1 < 0.0F)
        f5 = -f5;
      this.x = (f4 * this.x + f5 * paramQuaternion.x);
      this.y = (f4 * this.y + f5 * paramQuaternion.y);
      this.z = (f4 * this.z + f5 * paramQuaternion.z);
      this.w = (f4 * this.w + f5 * paramQuaternion.w);
      return this;
      f2 = f1;
      break;
      label211: f4 = f3;
      f5 = paramFloat;
    }
  }

  public Quaternion slerp(Quaternion[] paramArrayOfQuaternion)
  {
    float f = 1.0F / paramArrayOfQuaternion.length;
    set(paramArrayOfQuaternion[0]).exp(f);
    for (int i = 1; i < paramArrayOfQuaternion.length; i++)
      mul(tmp1.set(paramArrayOfQuaternion[i]).exp(f));
    nor();
    return this;
  }

  public Quaternion slerp(Quaternion[] paramArrayOfQuaternion, float[] paramArrayOfFloat)
  {
    set(paramArrayOfQuaternion[0]).exp(paramArrayOfFloat[0]);
    for (int i = 1; i < paramArrayOfQuaternion.length; i++)
      mul(tmp1.set(paramArrayOfQuaternion[i]).exp(paramArrayOfFloat[i]));
    nor();
    return this;
  }

  public void toMatrix(float[] paramArrayOfFloat)
  {
    float f1 = this.x * this.x;
    float f2 = this.x * this.y;
    float f3 = this.x * this.z;
    float f4 = this.x * this.w;
    float f5 = this.y * this.y;
    float f6 = this.y * this.z;
    float f7 = this.y * this.w;
    float f8 = this.z * this.z;
    float f9 = this.z * this.w;
    paramArrayOfFloat[0] = (1.0F - 2.0F * (f5 + f8));
    paramArrayOfFloat[4] = (2.0F * (f2 - f9));
    paramArrayOfFloat[8] = (2.0F * (f3 + f7));
    paramArrayOfFloat[12] = 0.0F;
    paramArrayOfFloat[1] = (2.0F * (f2 + f9));
    paramArrayOfFloat[5] = (1.0F - 2.0F * (f8 + f1));
    paramArrayOfFloat[9] = (2.0F * (f6 - f4));
    paramArrayOfFloat[13] = 0.0F;
    paramArrayOfFloat[2] = (2.0F * (f3 - f7));
    paramArrayOfFloat[6] = (2.0F * (f6 + f4));
    paramArrayOfFloat[10] = (1.0F - 2.0F * (f1 + f5));
    paramArrayOfFloat[14] = 0.0F;
    paramArrayOfFloat[3] = 0.0F;
    paramArrayOfFloat[7] = 0.0F;
    paramArrayOfFloat[11] = 0.0F;
    paramArrayOfFloat[15] = 1.0F;
  }

  public String toString()
  {
    return "[" + this.x + "|" + this.y + "|" + this.z + "|" + this.w + "]";
  }

  public Vector3 transform(Vector3 paramVector3)
  {
    tmp2.set(this);
    tmp2.conjugate();
    tmp2.mulLeft(tmp1.set(paramVector3.x, paramVector3.y, paramVector3.z, 0.0F)).mulLeft(this);
    paramVector3.x = tmp2.x;
    paramVector3.y = tmp2.y;
    paramVector3.z = tmp2.z;
    return paramVector3;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Quaternion
 * JD-Core Version:    0.6.0
 */