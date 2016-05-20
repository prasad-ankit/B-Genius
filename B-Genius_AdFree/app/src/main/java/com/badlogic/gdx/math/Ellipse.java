package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Ellipse
  implements Shape2D, Serializable
{
  private static final long serialVersionUID = 7381533206532032099L;
  public float height;
  public float width;
  public float x;
  public float y;

  public Ellipse()
  {
  }

  public Ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
  }

  public Ellipse(Circle paramCircle)
  {
    this.x = paramCircle.x;
    this.y = paramCircle.y;
    this.width = paramCircle.radius;
    this.height = paramCircle.radius;
  }

  public Ellipse(Ellipse paramEllipse)
  {
    this.x = paramEllipse.x;
    this.y = paramEllipse.y;
    this.width = paramEllipse.width;
    this.height = paramEllipse.height;
  }

  public Ellipse(Vector2 paramVector2, float paramFloat1, float paramFloat2)
  {
    this.x = paramVector2.x;
    this.y = paramVector2.y;
    this.width = paramFloat1;
    this.height = paramFloat2;
  }

  public Ellipse(Vector2 paramVector21, Vector2 paramVector22)
  {
    this.x = paramVector21.x;
    this.y = paramVector21.y;
    this.width = paramVector22.x;
    this.height = paramVector22.y;
  }

  public float area()
  {
    return 3.141593F * (this.width * this.height) / 4.0F;
  }

  public float circumference()
  {
    float f1 = this.width / 2.0F;
    float f2 = this.height / 2.0F;
    if ((f1 * 3.0F > f2) || (f2 * 3.0F > f1))
      return (float)(3.141592741012573D * (3.0F * (f1 + f2) - Math.sqrt((f2 + 3.0F * f1) * (f1 + f2 * 3.0F))));
    return (float)(6.283185482025147D * Math.sqrt((f1 * f1 + f2 * f2) / 2.0F));
  }

  public boolean contains(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1 - this.x;
    float f2 = paramFloat2 - this.y;
    return f1 * f1 / (0.5F * (0.5F * this.width * this.width)) + f2 * f2 / (0.5F * (0.5F * this.height * this.height)) <= 1.0F;
  }

  public boolean contains(Vector2 paramVector2)
  {
    return contains(paramVector2.x, paramVector2.y);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    Ellipse localEllipse;
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass()))
        return false;
      localEllipse = (Ellipse)paramObject;
    }
    while ((this.x == localEllipse.x) && (this.y == localEllipse.y) && (this.width == localEllipse.width) && (this.height == localEllipse.height));
    return false;
  }

  public int hashCode()
  {
    return 53 * (53 * (53 * (53 + NumberUtils.floatToRawIntBits(this.height)) + NumberUtils.floatToRawIntBits(this.width)) + NumberUtils.floatToRawIntBits(this.x)) + NumberUtils.floatToRawIntBits(this.y);
  }

  public void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
  }

  public void set(Circle paramCircle)
  {
    this.x = paramCircle.x;
    this.y = paramCircle.y;
    this.width = paramCircle.radius;
    this.height = paramCircle.radius;
  }

  public void set(Ellipse paramEllipse)
  {
    this.x = paramEllipse.x;
    this.y = paramEllipse.y;
    this.width = paramEllipse.width;
    this.height = paramEllipse.height;
  }

  public void set(Vector2 paramVector21, Vector2 paramVector22)
  {
    this.x = paramVector21.x;
    this.y = paramVector21.y;
    this.width = paramVector22.x;
    this.height = paramVector22.y;
  }

  public Ellipse setPosition(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    return this;
  }

  public Ellipse setPosition(Vector2 paramVector2)
  {
    this.x = paramVector2.x;
    this.y = paramVector2.y;
    return this;
  }

  public Ellipse setSize(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Ellipse
 * JD-Core Version:    0.6.0
 */