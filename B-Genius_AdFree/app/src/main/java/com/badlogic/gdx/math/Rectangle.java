package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Rectangle
  implements Shape2D, Serializable
{
  private static final long serialVersionUID = 5733252015138115702L;
  public static final Rectangle tmp = new Rectangle();
  public static final Rectangle tmp2 = new Rectangle();
  public float height;
  public float width;
  public float x;
  public float y;

  public Rectangle()
  {
  }

  public Rectangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
  }

  public Rectangle(Rectangle paramRectangle)
  {
    this.x = paramRectangle.x;
    this.y = paramRectangle.y;
    this.width = paramRectangle.width;
    this.height = paramRectangle.height;
  }

  public float area()
  {
    return this.width * this.height;
  }

  public boolean contains(float paramFloat1, float paramFloat2)
  {
    return (this.x <= paramFloat1) && (this.x + this.width >= paramFloat1) && (this.y <= paramFloat2) && (this.y + this.height >= paramFloat2);
  }

  public boolean contains(Rectangle paramRectangle)
  {
    float f1 = paramRectangle.x;
    float f2 = f1 + paramRectangle.width;
    float f3 = paramRectangle.y;
    float f4 = f3 + paramRectangle.height;
    return (f1 > this.x) && (f1 < this.x + this.width) && (f2 > this.x) && (f2 < this.x + this.width) && (f3 > this.y) && (f3 < this.y + this.height) && (f4 > this.y) && (f4 < this.y + this.height);
  }

  public boolean contains(Vector2 paramVector2)
  {
    return contains(paramVector2.x, paramVector2.y);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Rectangle localRectangle;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localRectangle = (Rectangle)paramObject;
      if (NumberUtils.floatToRawIntBits(this.height) != NumberUtils.floatToRawIntBits(localRectangle.height))
        return false;
      if (NumberUtils.floatToRawIntBits(this.width) != NumberUtils.floatToRawIntBits(localRectangle.width))
        return false;
      if (NumberUtils.floatToRawIntBits(this.x) != NumberUtils.floatToRawIntBits(localRectangle.x))
        return false;
    }
    while (NumberUtils.floatToRawIntBits(this.y) == NumberUtils.floatToRawIntBits(localRectangle.y));
    return false;
  }

  public Rectangle fitInside(Rectangle paramRectangle)
  {
    float f = getAspectRatio();
    if (f < paramRectangle.getAspectRatio())
      setSize(f * paramRectangle.height, paramRectangle.height);
    while (true)
    {
      setPosition(paramRectangle.x + paramRectangle.width / 2.0F - this.width / 2.0F, paramRectangle.y + paramRectangle.height / 2.0F - this.height / 2.0F);
      return this;
      setSize(paramRectangle.width, paramRectangle.width / f);
    }
  }

  public Rectangle fitOutside(Rectangle paramRectangle)
  {
    float f = getAspectRatio();
    if (f > paramRectangle.getAspectRatio())
      setSize(f * paramRectangle.height, paramRectangle.height);
    while (true)
    {
      setPosition(paramRectangle.x + paramRectangle.width / 2.0F - this.width / 2.0F, paramRectangle.y + paramRectangle.height / 2.0F - this.height / 2.0F);
      return this;
      setSize(paramRectangle.width, paramRectangle.width / f);
    }
  }

  public Rectangle fromString(String paramString)
  {
    int i = paramString.indexOf(',', 1);
    int j = paramString.indexOf(',', i + 1);
    int k = paramString.indexOf(',', j + 1);
    if ((i != -1) && (j != -1) && (k != -1) && (paramString.charAt(0) == '[') && (paramString.charAt(-1 + paramString.length()) == ']'))
      try
      {
        Rectangle localRectangle = set(Float.parseFloat(paramString.substring(1, i)), Float.parseFloat(paramString.substring(i + 1, j)), Float.parseFloat(paramString.substring(j + 1, k)), Float.parseFloat(paramString.substring(k + 1, -1 + paramString.length())));
        return localRectangle;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    throw new GdxRuntimeException("Malformed Rectangle: " + paramString);
  }

  public float getAspectRatio()
  {
    if (this.height == 0.0F)
      return (0.0F / 0.0F);
    return this.width / this.height;
  }

  public Vector2 getCenter(Vector2 paramVector2)
  {
    paramVector2.x = (this.x + this.width / 2.0F);
    paramVector2.y = (this.y + this.height / 2.0F);
    return paramVector2;
  }

  public float getHeight()
  {
    return this.height;
  }

  public Vector2 getPosition(Vector2 paramVector2)
  {
    return paramVector2.set(this.x, this.y);
  }

  public Vector2 getSize(Vector2 paramVector2)
  {
    return paramVector2.set(this.width, this.height);
  }

  public float getWidth()
  {
    return this.width;
  }

  public float getX()
  {
    return this.x;
  }

  public float getY()
  {
    return this.y;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (31 + NumberUtils.floatToRawIntBits(this.height)) + NumberUtils.floatToRawIntBits(this.width)) + NumberUtils.floatToRawIntBits(this.x)) + NumberUtils.floatToRawIntBits(this.y);
  }

  public Rectangle merge(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.min(this.x, paramFloat1);
    float f2 = Math.max(this.x + this.width, paramFloat1);
    this.x = f1;
    this.width = (f2 - f1);
    float f3 = Math.min(this.y, paramFloat2);
    float f4 = Math.max(this.y + this.height, paramFloat2);
    this.y = f3;
    this.height = (f4 - f3);
    return this;
  }

  public Rectangle merge(Rectangle paramRectangle)
  {
    float f1 = Math.min(this.x, paramRectangle.x);
    float f2 = Math.max(this.x + this.width, paramRectangle.x + paramRectangle.width);
    this.x = f1;
    this.width = (f2 - f1);
    float f3 = Math.min(this.y, paramRectangle.y);
    float f4 = Math.max(this.y + this.height, paramRectangle.y + paramRectangle.height);
    this.y = f3;
    this.height = (f4 - f3);
    return this;
  }

  public Rectangle merge(Vector2 paramVector2)
  {
    return merge(paramVector2.x, paramVector2.y);
  }

  public Rectangle merge(Vector2[] paramArrayOfVector2)
  {
    float f1 = this.x;
    float f2 = this.x + this.width;
    float f3 = this.y;
    float f4 = this.y + this.height;
    for (int i = 0; i < paramArrayOfVector2.length; i++)
    {
      Vector2 localVector2 = paramArrayOfVector2[i];
      f1 = Math.min(f1, localVector2.x);
      f2 = Math.max(f2, localVector2.x);
      f3 = Math.min(f3, localVector2.y);
      f4 = Math.max(f4, localVector2.y);
    }
    this.x = f1;
    this.width = (f2 - f1);
    this.y = f3;
    this.height = (f4 - f3);
    return this;
  }

  public boolean overlaps(Rectangle paramRectangle)
  {
    return (this.x < paramRectangle.x + paramRectangle.width) && (this.x + this.width > paramRectangle.x) && (this.y < paramRectangle.y + paramRectangle.height) && (this.y + this.height > paramRectangle.y);
  }

  public float perimeter()
  {
    return 2.0F * (this.width + this.height);
  }

  public Rectangle set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
    return this;
  }

  public Rectangle set(Rectangle paramRectangle)
  {
    this.x = paramRectangle.x;
    this.y = paramRectangle.y;
    this.width = paramRectangle.width;
    this.height = paramRectangle.height;
    return this;
  }

  public Rectangle setCenter(float paramFloat1, float paramFloat2)
  {
    setPosition(paramFloat1 - this.width / 2.0F, paramFloat2 - this.height / 2.0F);
    return this;
  }

  public Rectangle setCenter(Vector2 paramVector2)
  {
    setPosition(paramVector2.x - this.width / 2.0F, paramVector2.y - this.height / 2.0F);
    return this;
  }

  public Rectangle setHeight(float paramFloat)
  {
    this.height = paramFloat;
    return this;
  }

  public Rectangle setPosition(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    return this;
  }

  public Rectangle setPosition(Vector2 paramVector2)
  {
    this.x = paramVector2.x;
    this.y = paramVector2.y;
    return this;
  }

  public Rectangle setSize(float paramFloat)
  {
    this.width = paramFloat;
    this.height = paramFloat;
    return this;
  }

  public Rectangle setSize(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
    return this;
  }

  public Rectangle setWidth(float paramFloat)
  {
    this.width = paramFloat;
    return this;
  }

  public Rectangle setX(float paramFloat)
  {
    this.x = paramFloat;
    return this;
  }

  public Rectangle setY(float paramFloat)
  {
    this.y = paramFloat;
    return this;
  }

  public String toString()
  {
    return "[" + this.x + "," + this.y + "," + this.width + "," + this.height + "]";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Rectangle
 * JD-Core Version:    0.6.0
 */