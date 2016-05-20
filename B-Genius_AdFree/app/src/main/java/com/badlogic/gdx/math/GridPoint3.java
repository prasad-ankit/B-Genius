package com.badlogic.gdx.math;

import java.io.Serializable;

public class GridPoint3
  implements Serializable
{
  private static final long serialVersionUID = 5922187982746752830L;
  public int x;
  public int y;
  public int z;

  public GridPoint3()
  {
  }

  public GridPoint3(int paramInt1, int paramInt2, int paramInt3)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = paramInt3;
  }

  public GridPoint3(GridPoint3 paramGridPoint3)
  {
    this.x = paramGridPoint3.x;
    this.y = paramGridPoint3.y;
    this.z = paramGridPoint3.z;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    GridPoint3 localGridPoint3;
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass()))
        return false;
      localGridPoint3 = (GridPoint3)paramObject;
    }
    while ((this.x == localGridPoint3.x) && (this.y == localGridPoint3.y) && (this.z == localGridPoint3.z));
    return false;
  }

  public int hashCode()
  {
    return 17 * (17 * (17 + this.x) + this.y) + this.z;
  }

  public GridPoint3 set(int paramInt1, int paramInt2, int paramInt3)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = paramInt3;
    return this;
  }

  public GridPoint3 set(GridPoint3 paramGridPoint3)
  {
    this.x = paramGridPoint3.x;
    this.y = paramGridPoint3.y;
    this.z = paramGridPoint3.z;
    return this;
  }

  public String toString()
  {
    return "(" + this.x + ", " + this.y + ", " + this.z + ")";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.GridPoint3
 * JD-Core Version:    0.6.0
 */