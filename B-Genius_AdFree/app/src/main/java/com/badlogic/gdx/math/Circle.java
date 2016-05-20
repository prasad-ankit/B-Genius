package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Circle
  implements Shape2D, Serializable
{
  public float radius;
  public float x;
  public float y;

  public Circle()
  {
  }

  public Circle(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.radius = paramFloat3;
  }

  public Circle(Circle paramCircle)
  {
    this.x = paramCircle.x;
    this.y = paramCircle.y;
    this.radius = paramCircle.radius;
  }

  public Circle(Vector2 paramVector2, float paramFloat)
  {
    this.x = paramVector2.x;
    this.y = paramVector2.y;
    this.radius = paramFloat;
  }

  public Circle(Vector2 paramVector21, Vector2 paramVector22)
  {
    this.x = paramVector21.x;
    this.y = paramVector21.y;
    this.radius = Vector2.len(paramVector21.x - paramVector22.x, paramVector21.y - paramVector22.y);
  }

  public float area()
  {
    return 3.141593F * (this.radius * this.radius);
  }

  public float circumference()
  {
    return 6.283186F * this.radius;
  }

  public boolean contains(float paramFloat1, float paramFloat2)
  {
    float f1 = this.x - paramFloat1;
    float f2 = this.y - paramFloat2;
    return f1 * f1 + f2 * f2 <= this.radius * this.radius;
  }

  public boolean contains(Circle paramCircle)
  {
    float f1 = this.radius - paramCircle.radius;
    if (f1 < 0.0F);
    float f4;
    float f5;
    do
    {
      return false;
      float f2 = this.x - paramCircle.x;
      float f3 = this.y - paramCircle.y;
      f4 = f2 * f2 + f3 * f3;
      f5 = this.radius + paramCircle.radius;
    }
    while ((f1 * f1 < f4) || (f4 >= f5 * f5));
    return true;
  }

  public boolean contains(Vector2 paramVector2)
  {
    float f1 = this.x - paramVector2.x;
    float f2 = this.y - paramVector2.y;
    return f1 * f1 + f2 * f2 <= this.radius * this.radius;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    Circle localCircle;
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass()))
        return false;
      localCircle = (Circle)paramObject;
    }
    while ((this.x == localCircle.x) && (this.y == localCircle.y) && (this.radius == localCircle.radius));
    return false;
  }

  public int hashCode()
  {
    return 41 * (41 * (41 + NumberUtils.floatToRawIntBits(this.radius)) + NumberUtils.floatToRawIntBits(this.x)) + NumberUtils.floatToRawIntBits(this.y);
  }

  public boolean overlaps(Circle paramCircle)
  {
    float f1 = this.x - paramCircle.x;
    float f2 = this.y - paramCircle.y;
    float f3 = f1 * f1 + f2 * f2;
    float f4 = this.radius + paramCircle.radius;
    return f3 < f4 * f4;
  }

  public void set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.radius = paramFloat3;
  }

  public void set(Circle paramCircle)
  {
    this.x = paramCircle.x;
    this.y = paramCircle.y;
    this.radius = paramCircle.radius;
  }

  public void set(Vector2 paramVector2, float paramFloat)
  {
    this.x = paramVector2.x;
    this.y = paramVector2.y;
    this.radius = paramFloat;
  }

  public void set(Vector2 paramVector21, Vector2 paramVector22)
  {
    this.x = paramVector21.x;
    this.y = paramVector21.y;
    this.radius = Vector2.len(paramVector21.x - paramVector22.x, paramVector21.y - paramVector22.y);
  }

  public void setPosition(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }

  public void setPosition(Vector2 paramVector2)
  {
    this.x = paramVector2.x;
    this.y = paramVector2.y;
  }

  public void setRadius(float paramFloat)
  {
    this.radius = paramFloat;
  }

  public void setX(float paramFloat)
  {
    this.x = paramFloat;
  }

  public void setY(float paramFloat)
  {
    this.y = paramFloat;
  }

  public String toString()
  {
    return this.x + "," + this.y + "," + this.radius;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Circle
 * JD-Core Version:    0.6.0
 */