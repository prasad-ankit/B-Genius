package com.google.android.gms.b;

import java.util.ArrayList;
import java.util.Iterator;

public final class ad
{
  private final int a;
  private final int b;
  private final int c;
  private final am d;
  private final Object e = new Object();
  private ArrayList f = new ArrayList();
  private ArrayList g = new ArrayList();
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k;
  private String l = "";
  private String m = "";

  public ad(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = new am(paramInt4);
  }

  private static String a(ArrayList paramArrayList, int paramInt)
  {
    String str;
    if (paramArrayList.isEmpty())
      str = "";
    do
    {
      return str;
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = paramArrayList.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localStringBuffer.append((String)localIterator.next());
        localStringBuffer.append(' ');
      }
      while (localStringBuffer.length() <= 100);
      localStringBuffer.deleteCharAt(-1 + localStringBuffer.length());
      str = localStringBuffer.toString();
    }
    while (str.length() < 100);
    return str.substring(0, 100);
  }

  private void c(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() < this.c))
      return;
    synchronized (this.e)
    {
      this.f.add(paramString);
      this.h += paramString.length();
      if (paramBoolean)
        this.g.add(paramString);
      return;
    }
  }

  public final void a(int paramInt)
  {
    this.i = paramInt;
  }

  public final void a(String paramString, boolean paramBoolean)
  {
    c(paramString, paramBoolean);
    synchronized (this.e)
    {
      if (this.j < 0)
        hc.a("ActivityContent: negative number of WebViews.");
      g();
      return;
    }
  }

  public final boolean a()
  {
    while (true)
    {
      synchronized (this.e)
      {
        if (this.j == 0)
        {
          n = 1;
          return n;
        }
      }
      int n = 0;
    }
  }

  public final String b()
  {
    return this.l;
  }

  public final void b(String paramString, boolean paramBoolean)
  {
    c(paramString, paramBoolean);
  }

  public final String c()
  {
    return this.m;
  }

  public final void d()
  {
    synchronized (this.e)
    {
      this.k = (-100 + this.k);
      return;
    }
  }

  public final void e()
  {
    synchronized (this.e)
    {
      this.j = (-1 + this.j);
      return;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ad));
    ad localad;
    do
    {
      return false;
      if (paramObject == this)
        return true;
      localad = (ad)paramObject;
    }
    while ((localad.l == null) || (!localad.l.equals(this.l)));
    return true;
  }

  public final void f()
  {
    synchronized (this.e)
    {
      this.j = (1 + this.j);
      return;
    }
  }

  public final void g()
  {
    synchronized (this.e)
    {
      int n = this.h;
      int i1 = this.i;
      int i2 = n * this.a + i1 * this.b;
      if (i2 > this.k)
      {
        this.k = i2;
        this.l = this.d.a(this.f);
        this.m = this.d.a(this.g);
      }
      return;
    }
  }

  public final int h()
  {
    return this.k;
  }

  public final int hashCode()
  {
    return this.l.hashCode();
  }

  final int i()
  {
    return this.h;
  }

  public final String toString()
  {
    return "ActivityContent fetchId: " + this.i + " score:" + this.k + " total_length:" + this.h + "\n text: " + a(this.f, 100) + "\n viewableText" + a(this.g, 100) + "\n signture: " + this.l + "\n viewableSignture: " + this.m;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ad
 * JD-Core Version:    0.6.0
 */