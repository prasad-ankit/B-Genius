package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class Bresenham2
{
  private final Array points = new Array();
  private final Pool pool = new Bresenham2.1(this);

  public Array line(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.pool.freeAll(this.points);
    this.points.clear();
    return line(paramInt1, paramInt2, paramInt3, paramInt4, this.pool, this.points);
  }

  public Array line(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Pool paramPool, Array paramArray)
  {
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    int k;
    int m;
    if (i < 0)
    {
      k = -1;
      m = -1;
    }
    while (true)
    {
      int n;
      if (j < 0)
        n = -1;
      while (true)
      {
        label30: int i1 = Math.abs(i);
        int i2 = Math.abs(j);
        int i13;
        label73: int i3;
        int i4;
        if (i1 <= i2)
        {
          int i11 = Math.abs(j);
          int i12 = Math.abs(i);
          if (j < 0)
          {
            i13 = -1;
            i3 = 0;
            i4 = i12;
            i1 = i11;
          }
        }
        for (int i5 = i13; ; i5 = 0)
        {
          int i6 = i1 >> 1;
          int i7 = 0;
          label97: if (i7 <= i1)
          {
            GridPoint2 localGridPoint2 = (GridPoint2)paramPool.obtain();
            localGridPoint2.set(paramInt1, paramInt2);
            paramArray.add(localGridPoint2);
            int i8 = i6 + i4;
            int i9;
            if (i8 > i1)
            {
              i8 -= i1;
              i9 = paramInt1 + m;
            }
            for (int i10 = paramInt2 + n; ; i10 = paramInt2 + i5)
            {
              i7++;
              paramInt2 = i10;
              paramInt1 = i9;
              i6 = i8;
              break label97;
              if (i <= 0)
                break label258;
              k = 1;
              m = 1;
              break;
              if (j <= 0)
                break label252;
              n = 1;
              break label30;
              if (j <= 0)
                break label232;
              i13 = 1;
              break label73;
              i9 = paramInt1 + i3;
            }
          }
          return paramArray;
          label232: i13 = 0;
          break label73;
          i3 = k;
          i4 = i2;
        }
        label252: n = 0;
      }
      label258: k = 0;
      m = 0;
    }
  }

  public Array line(GridPoint2 paramGridPoint21, GridPoint2 paramGridPoint22)
  {
    return line(paramGridPoint21.x, paramGridPoint21.y, paramGridPoint22.x, paramGridPoint22.y);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Bresenham2
 * JD-Core Version:    0.6.0
 */