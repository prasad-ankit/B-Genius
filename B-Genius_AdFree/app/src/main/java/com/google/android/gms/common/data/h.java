package com.google.android.gms.common.data;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.f;
import java.util.Arrays;

public abstract class h
{
  protected final DataHolder a;
  protected int b;
  private int c;

  public h(DataHolder paramDataHolder, int paramInt)
  {
    this.a = ((DataHolder)w.a(paramDataHolder));
    if ((paramInt >= 0) && (paramInt < this.a.b));
    for (boolean bool = true; ; bool = false)
    {
      w.b(bool);
      this.b = paramInt;
      this.c = this.a.a(this.b);
      return;
    }
  }

  public final boolean a(String paramString)
  {
    return this.a.a.containsKey(paramString);
  }

  protected final long b(String paramString)
  {
    return this.a.a(paramString, this.b, this.c);
  }

  protected final int c(String paramString)
  {
    return this.a.b(paramString, this.b, this.c);
  }

  protected final boolean d(String paramString)
  {
    return this.a.d(paramString, this.b, this.c);
  }

  protected final String e(String paramString)
  {
    return this.a.c(paramString, this.b, this.c);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof h;
    int i = 0;
    if (bool1)
    {
      h localh = (h)paramObject;
      boolean bool2 = f.a(Integer.valueOf(localh.b), Integer.valueOf(this.b));
      i = 0;
      if (bool2)
      {
        boolean bool3 = f.a(Integer.valueOf(localh.c), Integer.valueOf(this.c));
        i = 0;
        if (bool3)
        {
          DataHolder localDataHolder1 = localh.a;
          DataHolder localDataHolder2 = this.a;
          i = 0;
          if (localDataHolder1 == localDataHolder2)
            i = 1;
        }
      }
    }
    return i;
  }

  protected final Uri f(String paramString)
  {
    return this.a.e(paramString, this.b, this.c);
  }

  protected final boolean g(String paramString)
  {
    return this.a.f(paramString, this.b, this.c);
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.b);
    arrayOfObject[1] = Integer.valueOf(this.c);
    arrayOfObject[2] = this.a;
    return Arrays.hashCode(arrayOfObject);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.h
 * JD-Core Version:    0.6.0
 */