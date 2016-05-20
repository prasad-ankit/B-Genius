package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class BoundingBox
  implements Serializable
{
  private static final long serialVersionUID = -1286036817192127343L;
  private static final Vector3 tmpVector = new Vector3();
  private final Vector3 cnt = new Vector3();
  private final Vector3 dim = new Vector3();
  public final Vector3 max = new Vector3();
  public final Vector3 min = new Vector3();

  public BoundingBox()
  {
    clr();
  }

  public BoundingBox(Vector3 paramVector31, Vector3 paramVector32)
  {
    set(paramVector31, paramVector32);
  }

  public BoundingBox(BoundingBox paramBoundingBox)
  {
    set(paramBoundingBox);
  }

  static final float max(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2)
      return paramFloat1;
    return paramFloat2;
  }

  static final float min(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2)
      return paramFloat2;
    return paramFloat1;
  }

  public BoundingBox clr()
  {
    return set(this.min.set(0.0F, 0.0F, 0.0F), this.max.set(0.0F, 0.0F, 0.0F));
  }

  public boolean contains(Vector3 paramVector3)
  {
    return (this.min.x <= paramVector3.x) && (this.max.x >= paramVector3.x) && (this.min.y <= paramVector3.y) && (this.max.y >= paramVector3.y) && (this.min.z <= paramVector3.z) && (this.max.z >= paramVector3.z);
  }

  public boolean contains(BoundingBox paramBoundingBox)
  {
    return (!isValid()) || ((this.min.x <= paramBoundingBox.min.x) && (this.min.y <= paramBoundingBox.min.y) && (this.min.z <= paramBoundingBox.min.z) && (this.max.x >= paramBoundingBox.max.x) && (this.max.y >= paramBoundingBox.max.y) && (this.max.z >= paramBoundingBox.max.z));
  }

  public BoundingBox ext(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return set(this.min.set(min(this.min.x, paramFloat1), min(this.min.y, paramFloat2), min(this.min.z, paramFloat3)), this.max.set(max(this.max.x, paramFloat1), max(this.max.y, paramFloat2), max(this.max.z, paramFloat3)));
  }

  public BoundingBox ext(Vector3 paramVector3)
  {
    return set(this.min.set(min(this.min.x, paramVector3.x), min(this.min.y, paramVector3.y), min(this.min.z, paramVector3.z)), this.max.set(Math.max(this.max.x, paramVector3.x), Math.max(this.max.y, paramVector3.y), Math.max(this.max.z, paramVector3.z)));
  }

  public BoundingBox ext(Vector3 paramVector3, float paramFloat)
  {
    return set(this.min.set(min(this.min.x, paramVector3.x - paramFloat), min(this.min.y, paramVector3.y - paramFloat), min(this.min.z, paramVector3.z - paramFloat)), this.max.set(max(this.max.x, paramFloat + paramVector3.x), max(this.max.y, paramFloat + paramVector3.y), max(this.max.z, paramFloat + paramVector3.z)));
  }

  public BoundingBox ext(BoundingBox paramBoundingBox)
  {
    return set(this.min.set(min(this.min.x, paramBoundingBox.min.x), min(this.min.y, paramBoundingBox.min.y), min(this.min.z, paramBoundingBox.min.z)), this.max.set(max(this.max.x, paramBoundingBox.max.x), max(this.max.y, paramBoundingBox.max.y), max(this.max.z, paramBoundingBox.max.z)));
  }

  public BoundingBox ext(BoundingBox paramBoundingBox, Matrix4 paramMatrix4)
  {
    ext(tmpVector.set(paramBoundingBox.min.x, paramBoundingBox.min.y, paramBoundingBox.min.z).mul(paramMatrix4));
    ext(tmpVector.set(paramBoundingBox.min.x, paramBoundingBox.min.y, paramBoundingBox.max.z).mul(paramMatrix4));
    ext(tmpVector.set(paramBoundingBox.min.x, paramBoundingBox.max.y, paramBoundingBox.min.z).mul(paramMatrix4));
    ext(tmpVector.set(paramBoundingBox.min.x, paramBoundingBox.max.y, paramBoundingBox.max.z).mul(paramMatrix4));
    ext(tmpVector.set(paramBoundingBox.max.x, paramBoundingBox.min.y, paramBoundingBox.min.z).mul(paramMatrix4));
    ext(tmpVector.set(paramBoundingBox.max.x, paramBoundingBox.min.y, paramBoundingBox.max.z).mul(paramMatrix4));
    ext(tmpVector.set(paramBoundingBox.max.x, paramBoundingBox.max.y, paramBoundingBox.min.z).mul(paramMatrix4));
    ext(tmpVector.set(paramBoundingBox.max.x, paramBoundingBox.max.y, paramBoundingBox.max.z).mul(paramMatrix4));
    return this;
  }

  public Vector3 getCenter(Vector3 paramVector3)
  {
    return paramVector3.set(this.cnt);
  }

  public float getCenterX()
  {
    return this.cnt.x;
  }

  public float getCenterY()
  {
    return this.cnt.y;
  }

  public float getCenterZ()
  {
    return this.cnt.z;
  }

  public Vector3 getCorner000(Vector3 paramVector3)
  {
    return paramVector3.set(this.min.x, this.min.y, this.min.z);
  }

  public Vector3 getCorner001(Vector3 paramVector3)
  {
    return paramVector3.set(this.min.x, this.min.y, this.max.z);
  }

  public Vector3 getCorner010(Vector3 paramVector3)
  {
    return paramVector3.set(this.min.x, this.max.y, this.min.z);
  }

  public Vector3 getCorner011(Vector3 paramVector3)
  {
    return paramVector3.set(this.min.x, this.max.y, this.max.z);
  }

  public Vector3 getCorner100(Vector3 paramVector3)
  {
    return paramVector3.set(this.max.x, this.min.y, this.min.z);
  }

  public Vector3 getCorner101(Vector3 paramVector3)
  {
    return paramVector3.set(this.max.x, this.min.y, this.max.z);
  }

  public Vector3 getCorner110(Vector3 paramVector3)
  {
    return paramVector3.set(this.max.x, this.max.y, this.min.z);
  }

  public Vector3 getCorner111(Vector3 paramVector3)
  {
    return paramVector3.set(this.max.x, this.max.y, this.max.z);
  }

  public float getDepth()
  {
    return this.dim.z;
  }

  public Vector3 getDimensions(Vector3 paramVector3)
  {
    return paramVector3.set(this.dim);
  }

  public float getHeight()
  {
    return this.dim.y;
  }

  public Vector3 getMax(Vector3 paramVector3)
  {
    return paramVector3.set(this.max);
  }

  public Vector3 getMin(Vector3 paramVector3)
  {
    return paramVector3.set(this.min);
  }

  public float getWidth()
  {
    return this.dim.x;
  }

  public BoundingBox inf()
  {
    this.min.set((1.0F / 1.0F), (1.0F / 1.0F), (1.0F / 1.0F));
    this.max.set((1.0F / -1.0F), (1.0F / -1.0F), (1.0F / -1.0F));
    this.cnt.set(0.0F, 0.0F, 0.0F);
    this.dim.set(0.0F, 0.0F, 0.0F);
    return this;
  }

  public boolean intersects(BoundingBox paramBoundingBox)
  {
    if (!isValid());
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    do
    {
      return false;
      f1 = Math.abs(this.cnt.x - paramBoundingBox.cnt.x);
      f2 = this.dim.x / 2.0F + paramBoundingBox.dim.x / 2.0F;
      f3 = Math.abs(this.cnt.y - paramBoundingBox.cnt.y);
      f4 = this.dim.y / 2.0F + paramBoundingBox.dim.y / 2.0F;
      f5 = Math.abs(this.cnt.z - paramBoundingBox.cnt.z);
      f6 = this.dim.z / 2.0F + paramBoundingBox.dim.z / 2.0F;
    }
    while ((f1 > f2) || (f3 > f4) || (f5 > f6));
    return true;
  }

  public boolean isValid()
  {
    return (this.min.x < this.max.x) && (this.min.y < this.max.y) && (this.min.z < this.max.z);
  }

  public BoundingBox mul(Matrix4 paramMatrix4)
  {
    float f1 = this.min.x;
    float f2 = this.min.y;
    float f3 = this.min.z;
    float f4 = this.max.x;
    float f5 = this.max.y;
    float f6 = this.max.z;
    inf();
    ext(tmpVector.set(f1, f2, f3).mul(paramMatrix4));
    ext(tmpVector.set(f1, f2, f6).mul(paramMatrix4));
    ext(tmpVector.set(f1, f5, f3).mul(paramMatrix4));
    ext(tmpVector.set(f1, f5, f6).mul(paramMatrix4));
    ext(tmpVector.set(f4, f2, f3).mul(paramMatrix4));
    ext(tmpVector.set(f4, f2, f6).mul(paramMatrix4));
    ext(tmpVector.set(f4, f5, f3).mul(paramMatrix4));
    ext(tmpVector.set(f4, f5, f6).mul(paramMatrix4));
    return this;
  }

  public BoundingBox set(Vector3 paramVector31, Vector3 paramVector32)
  {
    Vector3 localVector31 = this.min;
    float f1;
    float f2;
    label41: float f3;
    label59: Vector3 localVector32;
    float f4;
    label94: float f5;
    label112: float f6;
    if (paramVector31.x < paramVector32.x)
    {
      f1 = paramVector31.x;
      if (paramVector31.y >= paramVector32.y)
        break label196;
      f2 = paramVector31.y;
      if (paramVector31.z >= paramVector32.z)
        break label205;
      f3 = paramVector31.z;
      localVector31.set(f1, f2, f3);
      localVector32 = this.max;
      if (paramVector31.x <= paramVector32.x)
        break label214;
      f4 = paramVector31.x;
      if (paramVector31.y <= paramVector32.y)
        break label223;
      f5 = paramVector31.y;
      if (paramVector31.z <= paramVector32.z)
        break label232;
      f6 = paramVector31.z;
    }
    while (true)
    {
      localVector32.set(f4, f5, f6);
      this.cnt.set(this.min).add(this.max).scl(0.5F);
      this.dim.set(this.max).sub(this.min);
      return this;
      f1 = paramVector32.x;
      break;
      label196: f2 = paramVector32.y;
      break label41;
      label205: f3 = paramVector32.z;
      break label59;
      label214: f4 = paramVector32.x;
      break label94;
      label223: f5 = paramVector32.y;
      break label112;
      label232: f6 = paramVector32.z;
    }
  }

  public BoundingBox set(BoundingBox paramBoundingBox)
  {
    return set(paramBoundingBox.min, paramBoundingBox.max);
  }

  public BoundingBox set(List paramList)
  {
    inf();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      ext((Vector3)localIterator.next());
    return this;
  }

  public BoundingBox set(Vector3[] paramArrayOfVector3)
  {
    inf();
    int i = paramArrayOfVector3.length;
    for (int j = 0; j < i; j++)
      ext(paramArrayOfVector3[j]);
    return this;
  }

  public String toString()
  {
    return "[" + this.min + "|" + this.max + "]";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.collision.BoundingBox
 * JD-Core Version:    0.6.0
 */