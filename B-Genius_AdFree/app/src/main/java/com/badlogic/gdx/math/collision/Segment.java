package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;

public class Segment
  implements Serializable
{
  private static final long serialVersionUID = 2739667069736519602L;
  public final Vector3 a = new Vector3();
  public final Vector3 b = new Vector3();

  public Segment(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.a.set(paramFloat1, paramFloat2, paramFloat3);
    this.b.set(paramFloat4, paramFloat5, paramFloat6);
  }

  public Segment(Vector3 paramVector31, Vector3 paramVector32)
  {
    this.a.set(paramVector31);
    this.b.set(paramVector32);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    Segment localSegment;
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass()))
        return false;
      localSegment = (Segment)paramObject;
    }
    while ((this.a.equals(localSegment.a)) && (this.b.equals(localSegment.b)));
    return false;
  }

  public int hashCode()
  {
    return 71 * (71 + this.a.hashCode()) + this.b.hashCode();
  }

  public float len()
  {
    return this.a.dst(this.b);
  }

  public float len2()
  {
    return this.a.dst2(this.b);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.collision.Segment
 * JD-Core Version:    0.6.0
 */