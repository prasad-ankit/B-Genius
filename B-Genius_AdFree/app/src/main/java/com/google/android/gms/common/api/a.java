package com.google.android.gms.common.api;

import android.support.v4.app.j;
import android.support.v4.app.w;
import android.support.v4.app.z;

public final class a
{
  private final d a;
  private final z b;
  private final f c;
  private final j d;
  private final String e;

  public a(String paramString, d paramd, f paramf)
  {
    w.a(paramd, "Cannot construct an Api with a null ClientBuilder");
    w.a(paramf, "Cannot construct an Api with a null ClientKey");
    this.e = paramString;
    this.a = paramd;
    this.b = null;
    this.c = paramf;
    this.d = null;
  }

  public final d a()
  {
    if (this.a != null);
    for (boolean bool = true; ; bool = false)
    {
      w.a(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return this.a;
    }
  }

  public final f b()
  {
    if (this.c != null);
    for (boolean bool = true; ; bool = false)
    {
      w.a(bool, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
      return this.c;
    }
  }

  public final String c()
  {
    return this.e;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.a
 * JD-Core Version:    0.6.0
 */