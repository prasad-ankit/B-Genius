package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Vector3
  implements Vector, Serializable
{
  public static final Vector3 X = new Vector3(1.0F, 0.0F, 0.0F);
  public static final Vector3 Y = new Vector3(0.0F, 1.0F, 0.0F);
  public static final Vector3 Z = new Vector3(0.0F, 0.0F, 1.0F);
  public static final Vector3 Zero = new Vector3(0.0F, 0.0F, 0.0F);
  private static final long serialVersionUID = 3840054589595372522L;
  private static final Matrix4 tmpMat = new Matrix4();
  public float x;
  public float y;
  public float z;

  public Vector3()
  {
  }

  public Vector3(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    set(paramFloat1, paramFloat2, paramFloat3);
  }

  public Vector3(Vector2 paramVector2, float paramFloat)
  {
    set(paramVector2.x, paramVector2.y, paramFloat);
  }

  public Vector3(Vector3 paramVector3)
  {
    set(paramVector3);
  }

  public Vector3(float[] paramArrayOfFloat)
  {
    set(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
  }

  public static float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return paramFloat1 * paramFloat4 + paramFloat2 * paramFloat5 + paramFloat3 * paramFloat6;
  }

  public static float dst(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f1 = paramFloat4 - paramFloat1;
    float f2 = paramFloat5 - paramFloat2;
    float f3 = paramFloat6 - paramFloat3;
    return (float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
  }

  public static float dst2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f1 = paramFloat4 - paramFloat1;
    float f2 = paramFloat5 - paramFloat2;
    float f3 = paramFloat6 - paramFloat3;
    return f1 * f1 + f2 * f2 + f3 * f3;
  }

  public static float len(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3);
  }

  public static float len2(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3;
  }

  public Vector3 add(float paramFloat)
  {
    return set(paramFloat + this.x, paramFloat + this.y, paramFloat + this.z);
  }

  public Vector3 add(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return set(paramFloat1 + this.x, paramFloat2 + this.y, paramFloat3 + this.z);
  }

  public Vector3 add(Vector3 paramVector3)
  {
    return add(paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public Vector3 clamp(float paramFloat1, float paramFloat2)
  {
    float f1 = len2();
    if (f1 == 0.0F);
    float f3;
    do
    {
      return this;
      float f2 = paramFloat2 * paramFloat2;
      if (f1 > f2)
        return scl((float)Math.sqrt(f2 / f1));
      f3 = paramFloat1 * paramFloat1;
    }
    while (f1 >= f3);
    return scl((float)Math.sqrt(f3 / f1));
  }

  public Vector3 cpy()
  {
    return new Vector3(this);
  }

  public Vector3 crs(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return set(paramFloat3 * this.y - paramFloat2 * this.z, paramFloat1 * this.z - paramFloat3 * this.x, paramFloat2 * this.x - paramFloat1 * this.y);
  }

  public Vector3 crs(Vector3 paramVector3)
  {
    return set(this.y * paramVector3.z - this.z * paramVector3.y, this.z * paramVector3.x - this.x * paramVector3.z, this.x * paramVector3.y - this.y * paramVector3.x);
  }

  public float dot(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 * this.x + paramFloat2 * this.y + paramFloat3 * this.z;
  }

  public float dot(Vector3 paramVector3)
  {
    return this.x * paramVector3.x + this.y * paramVector3.y + this.z * paramVector3.z;
  }

  public float dst(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat1 - this.x;
    float f2 = paramFloat2 - this.y;
    float f3 = paramFloat3 - this.z;
    return (float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
  }

  public float dst(Vector3 paramVector3)
  {
    float f1 = paramVector3.x - this.x;
    float f2 = paramVector3.y - this.y;
    float f3 = paramVector3.z - this.z;
    return (float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
  }

  public float dst2(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat1 - this.x;
    float f2 = paramFloat2 - this.y;
    float f3 = paramFloat3 - this.z;
    return f1 * f1 + f2 * f2 + f3 * f3;
  }

  public float dst2(Vector3 paramVector3)
  {
    float f1 = paramVector3.x - this.x;
    float f2 = paramVector3.y - this.y;
    float f3 = paramVector3.z - this.z;
    return f1 * f1 + f2 * f2 + f3 * f3;
  }

  public boolean epsilonEquals(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (Math.abs(paramFloat1 - this.x) > paramFloat4);
    do
      return false;
    while ((Math.abs(paramFloat2 - this.y) > paramFloat4) || (Math.abs(paramFloat3 - this.z) > paramFloat4));
    return true;
  }

  public boolean epsilonEquals(Vector3 paramVector3, float paramFloat)
  {
    if (paramVector3 == null);
    do
      return false;
    while ((Math.abs(paramVector3.x - this.x) > paramFloat) || (Math.abs(paramVector3.y - this.y) > paramFloat) || (Math.abs(paramVector3.z - this.z) > paramFloat));
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Vector3 localVector3;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localVector3 = (Vector3)paramObject;
      if (NumberUtils.floatToIntBits(this.x) != NumberUtils.floatToIntBits(localVector3.x))
        return false;
      if (NumberUtils.floatToIntBits(this.y) != NumberUtils.floatToIntBits(localVector3.y))
        return false;
    }
    while (NumberUtils.floatToIntBits(this.z) == NumberUtils.floatToIntBits(localVector3.z));
    return false;
  }

  public Vector3 fromString(String paramString)
  {
    int i = paramString.indexOf(',', 1);
    int j = paramString.indexOf(',', i + 1);
    if ((i != -1) && (j != -1) && (paramString.charAt(0) == '(') && (paramString.charAt(-1 + paramString.length()) == ')'))
      try
      {
        Vector3 localVector3 = set(Float.parseFloat(paramString.substring(1, i)), Float.parseFloat(paramString.substring(i + 1, j)), Float.parseFloat(paramString.substring(j + 1, -1 + paramString.length())));
        return localVector3;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    throw new GdxRuntimeException("Malformed Vector3: " + paramString);
  }

  public boolean hasOppositeDirection(Vector3 paramVector3)
  {
    return dot(paramVector3) < 0.0F;
  }

  public boolean hasSameDirection(Vector3 paramVector3)
  {
    return dot(paramVector3) > 0.0F;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 + NumberUtils.floatToIntBits(this.x)) + NumberUtils.floatToIntBits(this.y)) + NumberUtils.floatToIntBits(this.z);
  }

  public boolean idt(Vector3 paramVector3)
  {
    return (this.x == paramVector3.x) && (this.y == paramVector3.y) && (this.z == paramVector3.z);
  }

  public Vector3 interpolate(Vector3 paramVector3, float paramFloat, Interpolation paramInterpolation)
  {
    return lerp(paramVector3, paramInterpolation.apply(0.0F, 1.0F, paramFloat));
  }

  public boolean isCollinear(Vector3 paramVector3)
  {
    return (isOnLine(paramVector3)) && (hasSameDirection(paramVector3));
  }

  public boolean isCollinear(Vector3 paramVector3, float paramFloat)
  {
    return (isOnLine(paramVector3, paramFloat)) && (hasSameDirection(paramVector3));
  }

  public boolean isCollinearOpposite(Vector3 paramVector3)
  {
    return (isOnLine(paramVector3)) && (hasOppositeDirection(paramVector3));
  }

  public boolean isCollinearOpposite(Vector3 paramVector3, float paramFloat)
  {
    return (isOnLine(paramVector3, paramFloat)) && (hasOppositeDirection(paramVector3));
  }

  public boolean isOnLine(Vector3 paramVector3)
  {
    return len2(this.y * paramVector3.z - this.z * paramVector3.y, this.z * paramVector3.x - this.x * paramVector3.z, this.x * paramVector3.y - this.y * paramVector3.x) <= 1.0E-006F;
  }

  public boolean isOnLine(Vector3 paramVector3, float paramFloat)
  {
    return len2(this.y * paramVector3.z - this.z * paramVector3.y, this.z * paramVector3.x - this.x * paramVector3.z, this.x * paramVector3.y - this.y * paramVector3.x) <= paramFloat;
  }

  public boolean isPerpendicular(Vector3 paramVector3)
  {
    return MathUtils.isZero(dot(paramVector3));
  }

  public boolean isPerpendicular(Vector3 paramVector3, float paramFloat)
  {
    return MathUtils.isZero(dot(paramVector3), paramFloat);
  }

  public boolean isUnit()
  {
    return isUnit(1.0E-009F);
  }

  public boolean isUnit(float paramFloat)
  {
    return Math.abs(len2() - 1.0F) < paramFloat;
  }

  public boolean isZero()
  {
    return (this.x == 0.0F) && (this.y == 0.0F) && (this.z == 0.0F);
  }

  public boolean isZero(float paramFloat)
  {
    return len2() < paramFloat;
  }

  public float len()
  {
    return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
  }

  public float len2()
  {
    return this.x * this.x + this.y * this.y + this.z * this.z;
  }

  public Vector3 lerp(Vector3 paramVector3, float paramFloat)
  {
    this.x += paramFloat * (paramVector3.x - this.x);
    this.y += paramFloat * (paramVector3.y - this.y);
    this.z += paramFloat * (paramVector3.z - this.z);
    return this;
  }

  public Vector3 limit(float paramFloat)
  {
    return limit2(paramFloat * paramFloat);
  }

  public Vector3 limit2(float paramFloat)
  {
    float f = len2();
    if (f > paramFloat)
      scl((float)Math.sqrt(paramFloat / f));
    return this;
  }

  public Vector3 mul(Matrix3 paramMatrix3)
  {
    float[] arrayOfFloat = paramMatrix3.val;
    return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[3] + this.z * arrayOfFloat[6], this.x * arrayOfFloat[1] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[7], this.x * arrayOfFloat[2] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[8]);
  }

  public Vector3 mul(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat = paramMatrix4.val;
    return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[8] + arrayOfFloat[12], this.x * arrayOfFloat[1] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[9] + arrayOfFloat[13], this.x * arrayOfFloat[2] + this.y * arrayOfFloat[6] + this.z * arrayOfFloat[10] + arrayOfFloat[14]);
  }

  public Vector3 mul(Quaternion paramQuaternion)
  {
    return paramQuaternion.transform(this);
  }

  public Vector3 mul4x3(float[] paramArrayOfFloat)
  {
    return set(this.x * paramArrayOfFloat[0] + this.y * paramArrayOfFloat[3] + this.z * paramArrayOfFloat[6] + paramArrayOfFloat[9], this.x * paramArrayOfFloat[1] + this.y * paramArrayOfFloat[4] + this.z * paramArrayOfFloat[7] + paramArrayOfFloat[10], this.x * paramArrayOfFloat[2] + this.y * paramArrayOfFloat[5] + this.z * paramArrayOfFloat[8] + paramArrayOfFloat[11]);
  }

  public Vector3 mulAdd(Vector3 paramVector3, float paramFloat)
  {
    this.x += paramFloat * paramVector3.x;
    this.y += paramFloat * paramVector3.y;
    this.z += paramFloat * paramVector3.z;
    return this;
  }

  public Vector3 mulAdd(Vector3 paramVector31, Vector3 paramVector32)
  {
    this.x += paramVector31.x * paramVector32.x;
    this.y += paramVector31.y * paramVector32.y;
    this.z += paramVector31.z * paramVector32.z;
    return this;
  }

  public Vector3 nor()
  {
    float f = len2();
    if ((f == 0.0F) || (f == 1.0F))
      return this;
    return scl(1.0F / (float)Math.sqrt(f));
  }

  public Vector3 prj(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat = paramMatrix4.val;
    float f = 1.0F / (this.x * arrayOfFloat[3] + this.y * arrayOfFloat[7] + this.z * arrayOfFloat[11] + arrayOfFloat[15]);
    return set(f * (this.x * arrayOfFloat[0] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[8] + arrayOfFloat[12]), f * (this.x * arrayOfFloat[1] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[9] + arrayOfFloat[13]), f * (this.x * arrayOfFloat[2] + this.y * arrayOfFloat[6] + this.z * arrayOfFloat[10] + arrayOfFloat[14]));
  }

  public Vector3 rot(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat = paramMatrix4.val;
    return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[8], this.x * arrayOfFloat[1] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[9], this.x * arrayOfFloat[2] + this.y * arrayOfFloat[6] + this.z * arrayOfFloat[10]);
  }

  public Vector3 rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return mul(tmpMat.setToRotation(paramFloat2, paramFloat3, paramFloat4, paramFloat1));
  }

  public Vector3 rotate(Vector3 paramVector3, float paramFloat)
  {
    tmpMat.setToRotation(paramVector3, paramFloat);
    return mul(tmpMat);
  }

  public Vector3 rotateRad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return mul(tmpMat.setToRotationRad(paramFloat2, paramFloat3, paramFloat4, paramFloat1));
  }

  public Vector3 rotateRad(Vector3 paramVector3, float paramFloat)
  {
    tmpMat.setToRotationRad(paramVector3, paramFloat);
    return mul(tmpMat);
  }

  public Vector3 scl(float paramFloat)
  {
    return set(paramFloat * this.x, paramFloat * this.y, paramFloat * this.z);
  }

  public Vector3 scl(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return set(paramFloat1 * this.x, paramFloat2 * this.y, paramFloat3 * this.z);
  }

  public Vector3 scl(Vector3 paramVector3)
  {
    return set(this.x * paramVector3.x, this.y * paramVector3.y, this.z * paramVector3.z);
  }

  public Vector3 set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    return this;
  }

  public Vector3 set(Vector2 paramVector2, float paramFloat)
  {
    return set(paramVector2.x, paramVector2.y, paramFloat);
  }

  public Vector3 set(Vector3 paramVector3)
  {
    return set(paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public Vector3 set(float[] paramArrayOfFloat)
  {
    return set(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
  }

  public Vector3 setFromSpherical(float paramFloat1, float paramFloat2)
  {
    float f1 = MathUtils.cos(paramFloat2);
    float f2 = MathUtils.sin(paramFloat2);
    float f3 = MathUtils.cos(paramFloat1);
    float f4 = MathUtils.sin(paramFloat1);
    return set(f3 * f2, f2 * f4, f1);
  }

  public Vector3 setLength(float paramFloat)
  {
    return setLength2(paramFloat * paramFloat);
  }

  public Vector3 setLength2(float paramFloat)
  {
    float f = len2();
    if ((f == 0.0F) || (f == paramFloat))
      return this;
    return scl((float)Math.sqrt(paramFloat / f));
  }

  public Vector3 setToRandomDirection()
  {
    float f1 = MathUtils.random();
    float f2 = MathUtils.random();
    return setFromSpherical(f1 * 6.283186F, (float)Math.acos(f2 * 2.0F - 1.0F));
  }

  public Vector3 setZero()
  {
    this.x = 0.0F;
    this.y = 0.0F;
    this.z = 0.0F;
    return this;
  }

  public Vector3 slerp(Vector3 paramVector3, float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = dot(paramVector3);
    if ((f2 > 0.9995000000000001D) || (f2 < -0.9995000000000001D))
      return lerp(paramVector3, paramFloat);
    float f3 = paramFloat * (float)Math.acos(f2);
    float f4 = (float)Math.sin(f3);
    float f5 = paramVector3.x - f2 * this.x;
    float f6 = paramVector3.y - f2 * this.y;
    float f7 = paramVector3.z - f2 * this.z;
    float f8 = f5 * f5 + f6 * f6 + f7 * f7;
    if (f8 < 1.0E-004F);
    while (true)
    {
      float f9 = f1 * f4;
      return scl((float)Math.cos(f3)).add(f5 * f9, f6 * f9, f9 * f7).nor();
      f1 /= (float)Math.sqrt(f8);
    }
  }

  public Vector3 sub(float paramFloat)
  {
    return set(this.x - paramFloat, this.y - paramFloat, this.z - paramFloat);
  }

  public Vector3 sub(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return set(this.x - paramFloat1, this.y - paramFloat2, this.z - paramFloat3);
  }

  public Vector3 sub(Vector3 paramVector3)
  {
    return sub(paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public String toString()
  {
    return "(" + this.x + "," + this.y + "," + this.z + ")";
  }

  public Vector3 traMul(Matrix3 paramMatrix3)
  {
    float[] arrayOfFloat = paramMatrix3.val;
    return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[1] + this.z * arrayOfFloat[2], this.x * arrayOfFloat[3] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[5], this.x * arrayOfFloat[6] + this.y * arrayOfFloat[7] + this.z * arrayOfFloat[8]);
  }

  public Vector3 traMul(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat = paramMatrix4.val;
    return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[1] + this.z * arrayOfFloat[2] + arrayOfFloat[3], this.x * arrayOfFloat[4] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[6] + arrayOfFloat[7], this.x * arrayOfFloat[8] + this.y * arrayOfFloat[9] + this.z * arrayOfFloat[10] + arrayOfFloat[11]);
  }

  public Vector3 unrotate(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat = paramMatrix4.val;
    return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[1] + this.z * arrayOfFloat[2], this.x * arrayOfFloat[4] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[6], this.x * arrayOfFloat[8] + this.y * arrayOfFloat[9] + this.z * arrayOfFloat[10]);
  }

  public Vector3 untransform(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat = paramMatrix4.val;
    this.x -= arrayOfFloat[12];
    this.y -= arrayOfFloat[12];
    this.z -= arrayOfFloat[12];
    return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[1] + this.z * arrayOfFloat[2], this.x * arrayOfFloat[4] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[6], this.x * arrayOfFloat[8] + this.y * arrayOfFloat[9] + this.z * arrayOfFloat[10]);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Vector3
 * JD-Core Version:    0.6.0
 */