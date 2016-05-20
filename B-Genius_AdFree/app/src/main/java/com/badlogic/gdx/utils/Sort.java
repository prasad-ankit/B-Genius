package com.badlogic.gdx.utils;

import java.util.Comparator;

public class Sort
{
  private static Sort instance;
  private ComparableTimSort comparableTimSort;
  private TimSort timSort;

  public static Sort instance()
  {
    if (instance == null)
      instance = new Sort();
    return instance;
  }

  public void sort(Array paramArray)
  {
    if (this.comparableTimSort == null)
      this.comparableTimSort = new ComparableTimSort();
    this.comparableTimSort.doSort((Object[])paramArray.items, 0, paramArray.size);
  }

  public void sort(Array paramArray, Comparator paramComparator)
  {
    if (this.timSort == null)
      this.timSort = new TimSort();
    this.timSort.doSort((Object[])paramArray.items, paramComparator, 0, paramArray.size);
  }

  public void sort(Object[] paramArrayOfObject)
  {
    if (this.comparableTimSort == null)
      this.comparableTimSort = new ComparableTimSort();
    this.comparableTimSort.doSort(paramArrayOfObject, 0, paramArrayOfObject.length);
  }

  public void sort(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    if (this.comparableTimSort == null)
      this.comparableTimSort = new ComparableTimSort();
    this.comparableTimSort.doSort(paramArrayOfObject, paramInt1, paramInt2);
  }

  public void sort(Object[] paramArrayOfObject, Comparator paramComparator)
  {
    if (this.timSort == null)
      this.timSort = new TimSort();
    this.timSort.doSort(paramArrayOfObject, paramComparator, 0, paramArrayOfObject.length);
  }

  public void sort(Object[] paramArrayOfObject, Comparator paramComparator, int paramInt1, int paramInt2)
  {
    if (this.timSort == null)
      this.timSort = new TimSort();
    this.timSort.doSort(paramArrayOfObject, paramComparator, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Sort
 * JD-Core Version:    0.6.0
 */