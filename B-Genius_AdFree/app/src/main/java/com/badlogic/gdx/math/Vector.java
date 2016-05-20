package com.badlogic.gdx.math;

public abstract interface Vector
{
  public abstract Vector add(Vector paramVector);

  public abstract Vector clamp(float paramFloat1, float paramFloat2);

  public abstract Vector cpy();

  public abstract float dot(Vector paramVector);

  public abstract float dst(Vector paramVector);

  public abstract float dst2(Vector paramVector);

  public abstract boolean epsilonEquals(Vector paramVector, float paramFloat);

  public abstract boolean hasOppositeDirection(Vector paramVector);

  public abstract boolean hasSameDirection(Vector paramVector);

  public abstract Vector interpolate(Vector paramVector, float paramFloat, Interpolation paramInterpolation);

  public abstract boolean isCollinear(Vector paramVector);

  public abstract boolean isCollinear(Vector paramVector, float paramFloat);

  public abstract boolean isCollinearOpposite(Vector paramVector);

  public abstract boolean isCollinearOpposite(Vector paramVector, float paramFloat);

  public abstract boolean isOnLine(Vector paramVector);

  public abstract boolean isOnLine(Vector paramVector, float paramFloat);

  public abstract boolean isPerpendicular(Vector paramVector);

  public abstract boolean isPerpendicular(Vector paramVector, float paramFloat);

  public abstract boolean isUnit();

  public abstract boolean isUnit(float paramFloat);

  public abstract boolean isZero();

  public abstract boolean isZero(float paramFloat);

  public abstract float len();

  public abstract float len2();

  public abstract Vector lerp(Vector paramVector, float paramFloat);

  public abstract Vector limit(float paramFloat);

  public abstract Vector limit2(float paramFloat);

  public abstract Vector mulAdd(Vector paramVector, float paramFloat);

  public abstract Vector mulAdd(Vector paramVector1, Vector paramVector2);

  public abstract Vector nor();

  public abstract Vector scl(float paramFloat);

  public abstract Vector scl(Vector paramVector);

  public abstract Vector set(Vector paramVector);

  public abstract Vector setLength(float paramFloat);

  public abstract Vector setLength2(float paramFloat);

  public abstract Vector setToRandomDirection();

  public abstract Vector setZero();

  public abstract Vector sub(Vector paramVector);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Vector
 * JD-Core Version:    0.6.0
 */