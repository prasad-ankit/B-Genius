package com.badlogic.gdx.math;

public class Polyline
  implements Shape2D
{
  private boolean calculateLength = true;
  private boolean calculateScaledLength = true;
  private boolean dirty = true;
  private float length;
  private float[] localVertices;
  private float originX;
  private float originY;
  private float rotation;
  private float scaleX = 1.0F;
  private float scaleY = 1.0F;
  private float scaledLength;
  private float[] worldVertices;
  private float x;
  private float y;

  public Polyline()
  {
    this.localVertices = new float[0];
  }

  public Polyline(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length < 4)
      throw new IllegalArgumentException("polylines must contain at least 2 points.");
    this.localVertices = paramArrayOfFloat;
  }

  public void calculateLength()
  {
    this.calculateLength = true;
  }

  public void calculateScaledLength()
  {
    this.calculateScaledLength = true;
  }

  public boolean contains(float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public boolean contains(Vector2 paramVector2)
  {
    return false;
  }

  public void dirty()
  {
    this.dirty = true;
  }

  public float getLength()
  {
    int i = 0;
    if (!this.calculateLength)
      return this.length;
    this.calculateLength = false;
    this.length = 0.0F;
    int j = -2 + this.localVertices.length;
    while (i < j)
    {
      float f1 = this.localVertices[(i + 2)] - this.localVertices[i];
      float f2 = this.localVertices[(i + 1)] - this.localVertices[(i + 3)];
      this.length += (float)Math.sqrt(f1 * f1 + f2 * f2);
      i += 2;
    }
    return this.length;
  }

  public float getOriginX()
  {
    return this.originX;
  }

  public float getOriginY()
  {
    return this.originY;
  }

  public float getRotation()
  {
    return this.rotation;
  }

  public float getScaleX()
  {
    return this.scaleX;
  }

  public float getScaleY()
  {
    return this.scaleY;
  }

  public float getScaledLength()
  {
    int i = 0;
    if (!this.calculateScaledLength)
      return this.scaledLength;
    this.calculateScaledLength = false;
    this.scaledLength = 0.0F;
    int j = -2 + this.localVertices.length;
    while (i < j)
    {
      float f1 = this.localVertices[(i + 2)] * this.scaleX - this.localVertices[i] * this.scaleX;
      float f2 = this.localVertices[(i + 1)] * this.scaleY - this.localVertices[(i + 3)] * this.scaleY;
      this.scaledLength += (float)Math.sqrt(f1 * f1 + f2 * f2);
      i += 2;
    }
    return this.scaledLength;
  }

  public float[] getTransformedVertices()
  {
    if (!this.dirty)
      return this.worldVertices;
    this.dirty = false;
    float[] arrayOfFloat1 = this.localVertices;
    if ((this.worldVertices == null) || (this.worldVertices.length < arrayOfFloat1.length))
      this.worldVertices = new float[arrayOfFloat1.length];
    float[] arrayOfFloat2 = this.worldVertices;
    float f1 = this.x;
    float f2 = this.y;
    float f3 = this.originX;
    float f4 = this.originY;
    float f5 = this.scaleX;
    float f6 = this.scaleY;
    int i;
    int k;
    label131: float f10;
    float f11;
    float f12;
    if ((f5 != 1.0F) || (f6 != 1.0F))
    {
      i = 1;
      float f7 = this.rotation;
      float f8 = MathUtils.cosDeg(f7);
      float f9 = MathUtils.sinDeg(f7);
      int j = arrayOfFloat1.length;
      k = 0;
      if (k >= j)
        break label247;
      f10 = arrayOfFloat1[k] - f3;
      f11 = arrayOfFloat1[(k + 1)] - f4;
      if (i != 0)
      {
        f10 *= f5;
        f11 *= f6;
      }
      if (f7 == 0.0F)
        break label249;
      f12 = f8 * f10 - f9 * f11;
      f11 = f10 * f9 + f11 * f8;
    }
    while (true)
    {
      arrayOfFloat2[k] = (f3 + (f12 + f1));
      arrayOfFloat2[(k + 1)] = (f4 + (f11 + f2));
      k += 2;
      break label131;
      i = 0;
      break;
      label247: return arrayOfFloat2;
      label249: f12 = f10;
    }
  }

  public float[] getVertices()
  {
    return this.localVertices;
  }

  public float getX()
  {
    return this.x;
  }

  public float getY()
  {
    return this.y;
  }

  public void rotate(float paramFloat)
  {
    this.rotation = (paramFloat + this.rotation);
    this.dirty = true;
  }

  public void scale(float paramFloat)
  {
    this.scaleX = (paramFloat + this.scaleX);
    this.scaleY = (paramFloat + this.scaleY);
    this.dirty = true;
    this.calculateScaledLength = true;
  }

  public void setOrigin(float paramFloat1, float paramFloat2)
  {
    this.originX = paramFloat1;
    this.originY = paramFloat2;
    this.dirty = true;
  }

  public void setPosition(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.dirty = true;
  }

  public void setRotation(float paramFloat)
  {
    this.rotation = paramFloat;
    this.dirty = true;
  }

  public void setScale(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    this.dirty = true;
    this.calculateScaledLength = true;
  }

  public void setVertices(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length < 4)
      throw new IllegalArgumentException("polylines must contain at least 2 points.");
    this.localVertices = paramArrayOfFloat;
    this.dirty = true;
  }

  public void translate(float paramFloat1, float paramFloat2)
  {
    this.x = (paramFloat1 + this.x);
    this.y = (paramFloat2 + this.y);
    this.dirty = true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Polyline
 * JD-Core Version:    0.6.0
 */