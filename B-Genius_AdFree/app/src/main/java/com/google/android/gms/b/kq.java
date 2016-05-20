package com.google.android.gms.b;

import java.io.IOException;
import java.lang.reflect.Array;

public final class kq
{
  protected final Class a;
  private int b;
  private int c;
  private boolean d;

  private int b(Object paramObject)
  {
    int i = kw.a(this.c);
    switch (this.b)
    {
    default:
      throw new IllegalArgumentException("Unknown type " + this.b);
    case 10:
      ku localku = (ku)paramObject;
      return (kn.c(i) << 1) + localku.d();
    case 11:
    }
    return kn.b(i, (ku)paramObject);
  }

  private void b(Object paramObject, kn paramkn)
  {
    try
    {
      paramkn.d(this.c);
      switch (this.b)
      {
      default:
        throw new IllegalArgumentException("Unknown type " + this.b);
      case 10:
      case 11:
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
    ku localku = (ku)paramObject;
    int i = kw.a(this.c);
    localku.a(paramkn);
    paramkn.c(i, 4);
    return;
    paramkn.a((ku)paramObject);
  }

  final int a(Object paramObject)
  {
    int i = 0;
    if (this.d)
    {
      int j = Array.getLength(paramObject);
      for (int k = 0; k < j; k++)
      {
        if (Array.get(paramObject, k) == null)
          continue;
        i += b(Array.get(paramObject, k));
      }
    }
    i = b(paramObject);
    return i;
  }

  final void a(Object paramObject, kn paramkn)
  {
    if (this.d)
    {
      int i = Array.getLength(paramObject);
      for (int j = 0; j < i; j++)
      {
        Object localObject = Array.get(paramObject, j);
        if (localObject == null)
          continue;
        b(localObject, paramkn);
      }
    }
    b(paramObject, paramkn);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.kq
 * JD-Core Version:    0.6.0
 */