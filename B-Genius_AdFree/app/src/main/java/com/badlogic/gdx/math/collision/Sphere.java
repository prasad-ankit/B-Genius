package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Sphere
  implements Serializable
{
  private static final float PI_4_3 = 4.18879F;
  private static final long serialVersionUID = -6487336868908521596L;
  public final Vector3 center;
  public float radius;

  public Sphere(Vector3 paramVector3, float paramFloat)
  {
    this.center = new Vector3(paramVector3);
    this.radius = paramFloat;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Sphere localSphere;
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass()))
        return false;
      localSphere = (Sphere)paramObject;
    }
    while ((this.radius == localSphere.radius) && (this.center.equals(localSphere.center)));
    return false;
  }

  public int hashCode()
  {
    return 71 * (71 + this.center.hashCode()) + NumberUtils.floatToRawIntBits(this.radius);
  }

  public boolean overlaps(Sphere paramSphere)
  {
    return this.center.dst2(paramSphere.center) < (this.radius + paramSphere.radius) * (this.radius + paramSphere.radius);
  }

  public float surfaceArea()
  {
    return 12.566371F * this.radius * this.radius;
  }

  public float volume()
  {
    return 4.18879F * this.radius * this.radius * this.radius;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.collision.Sphere
 * JD-Core Version:    0.6.0
 */