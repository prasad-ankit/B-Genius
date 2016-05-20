package com.badlogic.gdx.utils;

import java.util.Comparator;

public class QuickSelect
{
  private Object[] array;
  private Comparator comp;

  private int medianOfThreePivot(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.array[paramInt1];
    int i = (paramInt1 + paramInt2) / 2;
    Object localObject2 = this.array[i];
    Object localObject3 = this.array[paramInt2];
    if (this.comp.compare(localObject1, localObject2) > 0)
      if (this.comp.compare(localObject2, localObject3) > 0)
        paramInt2 = i;
    do
    {
      do
        return paramInt2;
      while (this.comp.compare(localObject1, localObject3) > 0);
      return paramInt1;
      if (this.comp.compare(localObject1, localObject3) > 0)
        return paramInt1;
    }
    while (this.comp.compare(localObject2, localObject3) > 0);
    return i;
  }

  private int partition(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.array[paramInt3];
    swap(paramInt2, paramInt3);
    int i = paramInt1;
    while (paramInt1 < paramInt2)
    {
      if (this.comp.compare(this.array[paramInt1], localObject) < 0)
      {
        swap(i, paramInt1);
        i++;
      }
      paramInt1++;
    }
    swap(paramInt2, i);
    return i;
  }

  private int recursiveSelect(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == paramInt2)
      return paramInt1;
    int i = partition(paramInt1, paramInt2, medianOfThreePivot(paramInt1, paramInt2));
    int j = 1 + (i - paramInt1);
    if (j == paramInt3);
    while (true)
    {
      return i;
      if (paramInt3 < j)
      {
        i = recursiveSelect(paramInt1, i - 1, paramInt3);
        continue;
      }
      i = recursiveSelect(i + 1, paramInt2, paramInt3 - j);
    }
  }

  private void swap(int paramInt1, int paramInt2)
  {
    Object localObject = this.array[paramInt1];
    this.array[paramInt1] = this.array[paramInt2];
    this.array[paramInt2] = localObject;
  }

  public int select(Object[] paramArrayOfObject, Comparator paramComparator, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfObject;
    this.comp = paramComparator;
    return recursiveSelect(0, paramInt2 - 1, paramInt1);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.QuickSelect
 * JD-Core Version:    0.6.0
 */