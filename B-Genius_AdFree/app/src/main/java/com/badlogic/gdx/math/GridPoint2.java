package com.badlogic.gdx.math;

import java.io.Serializable;

public class GridPoint2
  implements Serializable
{
  private static final long serialVersionUID = -4019969926331717380L;
  public int x;
  public int y;

  public GridPoint2()
  {
  }

  public GridPoint2(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
  }

  public GridPoint2(GridPoint2 paramGridPoint2)
  {
    this.x = paramGridPoint2.x;
    this.y = paramGridPoint2.y;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    GridPoint2 localGridPoint2;
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass()))
        return false;
      localGridPoint2 = (GridPoint2)paramObject;
    }
    while ((this.x == localGridPoint2.x) && (this.y == localGridPoint2.y));
    return false;
  }

  public int hashCode()
  {
    return 53 * (53 + this.x) + this.y;
  }

  public GridPoint2 set(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    return this;
  }

  public GridPoint2 set(GridPoint2 paramGridPoint2)
  {
    this.x = paramGridPoint2.x;
    this.y = paramGridPoint2.y;
    return this;
  }

  public String toString()
  {
    return "(" + this.x + ", " + this.y + ")";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.GridPoint2
 * JD-Core Version:    0.6.0
 */