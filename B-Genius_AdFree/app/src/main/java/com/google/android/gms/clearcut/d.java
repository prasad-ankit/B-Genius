package com.google.android.gms.clearcut;

import android.support.v4.app.z;
import com.google.android.gms.b.ju;
import com.google.android.gms.b.kA;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.m;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.TimeZone;

public final class d
{
  private int a = b.a(this.j);
  private String b = b.b(this.j);
  private String c = b.c(this.j);
  private String d = b.d(this.j);
  private int e = b.e(this.j);
  private final z f;
  private ArrayList g = null;
  private final kA h = new kA();
  private boolean i = false;

  private d(b paramb, byte[] paramArrayOfByte)
  {
    this(paramb, paramArrayOfByte, null);
  }

  private d(b paramb, byte[] paramArrayOfByte, z paramz)
  {
    this.c = b.c(paramb);
    this.d = b.d(paramb);
    this.h.a = b.f(paramb).a();
    this.h.b = b.f(paramb).b();
    kA localkA1 = this.h;
    b.h(paramb);
    localkA1.i = a.a(b.g(paramb));
    kA localkA2 = this.h;
    b.i(paramb);
    long l = this.h.a;
    localkA2.g = (TimeZone.getDefault().getOffset(l) / 1000);
    if (paramArrayOfByte != null)
      this.h.e = paramArrayOfByte;
    this.f = null;
  }

  public final d a(int paramInt)
  {
    this.h.c = paramInt;
    return this;
  }

  public final m a(g paramg)
  {
    if (this.i)
      throw new IllegalStateException("do not reuse LogEventBuilder");
    this.i = true;
    f localf = b.m(this.j);
    LogEventParcelable localLogEventParcelable = new LogEventParcelable(new PlayLoggerContext(b.k(this.j), b.l(this.j), this.a, this.b, this.c, this.d, b.j(this.j), this.e), this.h, this.f, null, b.a(null));
    return localf.a(paramg, localLogEventParcelable);
  }

  public final d b(int paramInt)
  {
    this.h.d = paramInt;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.clearcut.d
 * JD-Core Version:    0.6.0
 */