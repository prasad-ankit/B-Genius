package com.google.android.gms.b;

import android.os.Handler;
import com.google.android.gms.ads.internal.P;

public final class cn extends ha
{
  final is a;
  final cq b;
  private final String c;

  cn(is paramis, cq paramcq, String paramString)
  {
    this.a = paramis;
    this.b = paramcq;
    this.c = paramString;
    P.t().a(this);
  }

  public final void a()
  {
    try
    {
      this.b.a(this.c);
      return;
    }
    finally
    {
      hu.a.post(new co(this));
    }
    throw localObject;
  }

  public final void b()
  {
    this.b.b();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cn
 * JD-Core Version:    0.6.0
 */