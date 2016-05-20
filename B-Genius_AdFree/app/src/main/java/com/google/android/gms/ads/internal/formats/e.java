package com.google.android.gms.ads.internal.formats;

import android.support.v4.b.k;
import com.google.android.gms.b.aZ;
import com.google.android.gms.b.bo;
import com.google.android.gms.b.hc;
import java.util.Arrays;
import java.util.List;

public final class e extends bo
  implements h
{
  private final String a;
  private final k b;
  private final k c;
  private final Object d = new Object();
  private g e;

  public e(String paramString, k paramk1, k paramk2, a parama)
  {
    this.a = paramString;
    this.b = paramk1;
    this.c = paramk2;
  }

  public final String a(String paramString)
  {
    return (String)this.c.get(paramString);
  }

  public final List a()
  {
    String[] arrayOfString = new String[this.b.size() + this.c.size()];
    int i = 0;
    int j = 0;
    int m;
    while (true)
    {
      int k = this.b.size();
      m = 0;
      if (i >= k)
        break;
      arrayOfString[j] = ((String)this.b.b(i));
      int n = i + 1;
      j++;
      i = n;
    }
    while (m < this.c.size())
    {
      arrayOfString[j] = ((String)this.c.b(m));
      m++;
      j++;
    }
    return Arrays.asList(arrayOfString);
  }

  public final void a(g paramg)
  {
    synchronized (this.d)
    {
      this.e = paramg;
      return;
    }
  }

  public final aZ b(String paramString)
  {
    return (aZ)this.b.get(paramString);
  }

  public final void b()
  {
    synchronized (this.d)
    {
      if (this.e == null)
      {
        hc.b("Attempt to perform recordImpression before ad initialized.");
        return;
      }
      this.e.a();
      return;
    }
  }

  public final void c(String paramString)
  {
    synchronized (this.d)
    {
      if (this.e == null)
      {
        hc.b("Attempt to call performClick before ad initialized.");
        return;
      }
      this.e.a(paramString, null, null, null);
      return;
    }
  }

  public final String j()
  {
    return "3";
  }

  public final String k()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.formats.e
 * JD-Core Version:    0.6.0
 */