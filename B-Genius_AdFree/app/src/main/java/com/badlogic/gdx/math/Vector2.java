package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Vector2
  implements Vector, Serializable
{
  public static final Vector2 X = new Vector2(1.0F, 0.0F);
  public static final Vector2 Y = new Vector2(0.0F, 1.0F);
  public static final Vector2 Zero = new Vector2(0.0F, 0.0F);
  private static final long serialVersionUID = 913902788239530931L;
  public float x;
  public float y;

  public Vector2()
  {
  }

  public Vector2(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }

  public Vector2(Vector2 paramVector2)
  {
    set(paramVector2);
  }

  public static float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat1 * paramFloat3 + paramFloat2 * paramFloat4;
  }

  public static float dst(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }

  public static float dst2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    return f1 * f1 + f2 * f2;
  }

  public static float len(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }

  public static float len2(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2;
  }

  public Vector2 add(float paramFloat1, float paramFloat2)
  {
    this.x = (paramFloat1 + this.x);
    this.y = (paramFloat2 + this.y);
    return this;
  }

  public Vector2 add(Vector2 paramVector2)
  {
    this.x += paramVector2.x;
    this.y += paramVector2.y;
    return this;
  }

  public float angle()
  {
    float f = 57.295776F * (float)Math.atan2(this.y, this.x);
    if (f < 0.0F)
      f += 360.0F;
    return f;
  }

  public float angle(Vector2 paramVector2)
  {
    return 57.295776F * (float)Math.atan2(crs(paramVector2), dot(paramVector2));
  }

  public float angleRad()
  {
    return (float)Math.atan2(this.y, this.x);
  }

  public float angleRad(Vector2 paramVector2)
  {
    return (float)Math.atan2(crs(paramVector2), dot(paramVector2));
  }

  public Vector2 clamp(float paramFloat1, float paramFloat2)
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

  public Vector2 cpy()
  {
    return new Vector2(this);
  }

  public float crs(float paramFloat1, float paramFloat2)
  {
    return paramFloat2 * this.x - paramFloat1 * this.y;
  }

  public float crs(Vector2 paramVector2)
  {
    return this.x * paramVector2.y - this.y * paramVector2.x;
  }

  public float dot(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * this.x + paramFloat2 * this.y;
  }

  public float dot(Vector2 paramVector2)
  {
    return this.x * paramVector2.x + this.y * paramVector2.y;
  }

  public float dst(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1 - this.x;
    float f2 = paramFloat2 - this.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }

  public float dst(Vector2 paramVector2)
  {
    float f1 = paramVector2.x - this.x;
    float f2 = paramVector2.y - this.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }

  public float dst2(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1 - this.x;
    float f2 = paramFloat2 - this.y;
    return f1 * f1 + f2 * f2;
  }

  public float dst2(Vector2 paramVector2)
  {
    float f1 = paramVector2.x - this.x;
    float f2 = paramVector2.y - this.y;
    return f1 * f1 + f2 * f2;
  }

  public boolean epsilonEquals(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Math.abs(paramFloat1 - this.x) > paramFloat3);
    do
      return false;
    while (Math.abs(paramFloat2 - this.y) > paramFloat3);
    return true;
  }

  public boolean epsilonEquals(Vector2 paramVector2, float paramFloat)
  {
    if (paramVector2 == null);
    do
      return false;
    while ((Math.abs(paramVector2.x - this.x) > paramFloat) || (Math.abs(paramVector2.y - this.y) > paramFloat));
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Vector2 localVector2;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localVector2 = (Vector2)paramObject;
      if (NumberUtils.floatToIntBits(this.x) != NumberUtils.floatToIntBits(localVector2.x))
        return false;
    }
    while (NumberUtils.floatToIntBits(this.y) == NumberUtils.floatToIntBits(localVector2.y));
    return false;
  }

  public Vector2 fromString(String paramString)
  {
    int i = paramString.indexOf(',', 1);
    if ((i != -1) && (paramString.charAt(0) == '(') && (paramString.charAt(-1 + paramString.length()) == ')'))
      try
      {
        Vector2 localVector2 = set(Float.parseFloat(paramString.substring(1, i)), Float.parseFloat(paramString.substring(i + 1, -1 + paramString.length())));
        return localVector2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    throw new GdxRuntimeException("Malformed Vector2: " + paramString);
  }

  public boolean hasOppositeDirection(Vector2 paramVector2)
  {
    return dot(paramVector2) < 0.0F;
  }

  public boolean hasSameDirection(Vector2 paramVector2)
  {
    return dot(paramVector2) > 0.0F;
  }

  public int hashCode()
  {
    return 31 * (31 + NumberUtils.floatToIntBits(this.x)) + NumberUtils.floatToIntBits(this.y);
  }

  public Vector2 interpolate(Vector2 paramVector2, float paramFloat, Interpolation paramInterpolation)
  {
    return lerp(paramVector2, paramInterpolation.apply(paramFloat));
  }

  public boolean isCollinear(Vector2 paramVector2)
  {
    return (isOnLine(paramVector2)) && (dot(paramVector2) > 0.0F);
  }

  public boolean isCollinear(Vector2 paramVector2, float paramFloat)
  {
    return (isOnLine(paramVector2, paramFloat)) && (dot(paramVector2) > 0.0F);
  }

  public boolean isCollinearOpposite(Vector2 paramVector2)
  {
    return (isOnLine(paramVector2)) && (dot(paramVector2) < 0.0F);
  }

  public boolean isCollinearOpposite(Vector2 paramVector2, float paramFloat)
  {
    return (isOnLine(paramVector2, paramFloat)) && (dot(paramVector2) < 0.0F);
  }

  public boolean isOnLine(Vector2 paramVector2)
  {
    return MathUtils.isZero(this.x * paramVector2.y - this.y * paramVector2.x);
  }

  public boolean isOnLine(Vector2 paramVector2, float paramFloat)
  {
    return MathUtils.isZero(this.x * paramVector2.y - this.y * paramVector2.x, paramFloat);
  }

  public boolean isPerpendicular(Vector2 paramVector2)
  {
    return MathUtils.isZero(dot(paramVector2));
  }

  public boolean isPerpendicular(Vector2 paramVector2, float paramFloat)
  {
    return MathUtils.isZero(dot(paramVector2), paramFloat);
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
    return (this.x == 0.0F) && (this.y == 0.0F);
  }

  public boolean isZero(float paramFloat)
  {
    return len2() < paramFloat;
  }

  public float len()
  {
    return (float)Math.sqrt(this.x * this.x + this.y * this.y);
  }

  public float len2()
  {
    return this.x * this.x + this.y * this.y;
  }

  public Vector2 lerp(Vector2 paramVector2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    this.x = (f * this.x + paramFloat * paramVector2.x);
    this.y = (f * this.y + paramFloat * paramVector2.y);
    return this;
  }

  public Vector2 limit(float paramFloat)
  {
    return limit2(paramFloat * paramFloat);
  }

  public Vector2 limit2(float paramFloat)
  {
    float f = len2();
    if (f > paramFloat)
      this = scl((float)Math.sqrt(paramFloat / f));
    return this;
  }

  public Vector2 mul(Matrix3 paramMatrix3)
  {
    float f1 = this.x * paramMatrix3.val[0] + this.y * paramMatrix3.val[3] + paramMatrix3.val[6];
    float f2 = this.x * paramMatrix3.val[1] + this.y * paramMatrix3.val[4] + paramMatrix3.val[7];
    this.x = f1;
    this.y = f2;
    return this;
  }

  public Vector2 mulAdd(Vector2 paramVector2, float paramFloat)
  {
    this.x += paramFloat * paramVector2.x;
    this.y += paramFloat * paramVector2.y;
    return this;
  }

  public Vector2 mulAdd(Vector2 paramVector21, Vector2 paramVector22)
  {
    this.x += paramVector21.x * paramVector22.x;
    this.y += paramVector21.y * paramVector22.y;
    return this;
  }

  public Vector2 nor()
  {
    float f = len();
    if (f != 0.0F)
    {
      this.x /= f;
      this.y /= f;
    }
    return this;
  }

  public Vector2 rotate(float paramFloat)
  {
    return rotateRad(0.01745329F * paramFloat);
  }

  public Vector2 rotate90(int paramInt)
  {
    float f = this.x;
    if (paramInt >= 0)
    {
      this.x = (-this.y);
      this.y = f;
      return this;
    }
    this.x = this.y;
    this.y = (-f);
    return this;
  }

  public Vector2 rotateRad(float paramFloat)
  {
    float f1 = (float)Math.cos(paramFloat);
    float f2 = (float)Math.sin(paramFloat);
    float f3 = f1 * this.x - f2 * this.y;
    float f4 = f2 * this.x + f1 * this.y;
    this.x = f3;
    this.y = f4;
    return this;
  }

  public Vector2 scl(float paramFloat)
  {
    this.x = (paramFloat * this.x);
    this.y = (paramFloat * this.y);
    return this;
  }

  public Vector2 scl(float paramFloat1, float paramFloat2)
  {
    this.x = (paramFloat1 * this.x);
    this.y = (paramFloat2 * this.y);
    return this;
  }

  public Vector2 scl(Vector2 paramVector2)
  {
    this.x *= paramVector2.x;
    this.y *= paramVector2.y;
    return this;
  }

  public Vector2 set(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    return this;
  }

  public Vector2 set(Vector2 paramVector2)
  {
    this.x = paramVector2.x;
    this.y = paramVector2.y;
    return this;
  }

  public Vector2 setAngle(float paramFloat)
  {
    return setAngleRad(0.01745329F * paramFloat);
  }

  public Vector2 setAngleRad(float paramFloat)
  {
    set(len(), 0.0F);
    rotateRad(paramFloat);
    return this;
  }

  public Vector2 setLength(float paramFloat)
  {
    return setLength2(paramFloat * paramFloat);
  }

  public Vector2 setLength2(float paramFloat)
  {
    float f = len2();
    if ((f == 0.0F) || (f == paramFloat))
      return this;
    return scl((float)Math.sqrt(paramFloat / f));
  }

  public Vector2 setToRandomDirection()
  {
    float f = MathUtils.random(0.0F, 6.283186F);
    return set(MathUtils.cos(f), MathUtils.sin(f));
  }

  public Vector2 setZero()
  {
    this.x = 0.0F;
    this.y = 0.0F;
    return this;
  }

  public Vector2 sub(float paramFloat1, float paramFloat2)
  {
    this.x -= paramFloat1;
    this.y -= paramFloat2;
    return this;
  }

  public Vector2 sub(Vector2 paramVector2)
  {
    this.x -= paramVector2.x;
    this.y -= paramVector2.y;
    return this;
  }

  public String toString()
  {
    return "(" + this.x + "," + this.y + ")";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Vector2
 * JD-Core Version:    0.6.0
 */