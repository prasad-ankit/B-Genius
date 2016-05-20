package com.badlogic.gdx.utils;

import java.util.Comparator;

public class Select
{
  private static Select instance;
  private QuickSelect quickSelect;

  private int fastMax(Object[] paramArrayOfObject, Comparator paramComparator, int paramInt)
  {
    int i = 0;
    for (int j = 1; j < paramInt; j++)
    {
      if (paramComparator.compare(paramArrayOfObject[j], paramArrayOfObject[i]) <= 0)
        continue;
      i = j;
    }
    return i;
  }

  private int fastMin(Object[] paramArrayOfObject, Comparator paramComparator, int paramInt)
  {
    int i = 0;
    for (int j = 1; j < paramInt; j++)
    {
      if (paramComparator.compare(paramArrayOfObject[j], paramArrayOfObject[i]) >= 0)
        continue;
      i = j;
    }
    return i;
  }

  public static Select instance()
  {
    if (instance == null)
      instance = new Select();
    return instance;
  }

  public Object select(Object[] paramArrayOfObject, Comparator paramComparator, int paramInt1, int paramInt2)
  {
    return paramArrayOfObject[selectIndex(paramArrayOfObject, paramComparator, paramInt1, paramInt2)];
  }

  public int selectIndex(Object[] paramArrayOfObject, Comparator paramComparator, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0)
      throw new GdxRuntimeException("cannot select from empty array (size < 1)");
    if (paramInt1 > paramInt2)
      throw new GdxRuntimeException("Kth rank is larger than size. k: " + paramInt1 + ", size: " + paramInt2);
    if (paramInt1 == 1)
      return fastMin(paramArrayOfObject, paramComparator, paramInt2);
    if (paramInt1 == paramInt2)
      return fastMax(paramArrayOfObject, paramComparator, paramInt2);
    if (this.quickSelect == null)
      this.quickSelect = new QuickSelect();
    return this.quickSelect.select(paramArrayOfObject, paramComparator, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Select
 * JD-Core Version:    0.6.0
 */