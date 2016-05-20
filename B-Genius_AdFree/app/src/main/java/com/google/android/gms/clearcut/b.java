package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.w;
import android.util.Log;
import com.google.android.gms.b.iW;
import com.google.android.gms.b.ju;
import com.google.android.gms.b.jv;
import com.google.android.gms.common.api.g;
import java.util.concurrent.TimeUnit;

public final class b
{
  public static final com.google.android.gms.common.api.f a = new com.google.android.gms.common.api.f();
  public static final com.google.android.gms.common.api.a b;
  private static com.google.android.gms.common.api.d c = new c();
  private static f d;
  private final Context e;
  private final String f;
  private final int g;
  private String h;
  private int i = -1;
  private String j;
  private String k;
  private final boolean l;
  private int m = 0;
  private final f n;
  private final ju o;
  private final a p;
  private e q;

  static
  {
    b = new com.google.android.gms.common.api.a("ClearcutLogger.API", c, a);
    d = new iW();
  }

  private b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, f paramf, ju paramju, e parame, a parama)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null)
    {
      this.e = localContext;
      this.f = paramContext.getPackageName();
      this.g = a(paramContext);
      this.i = -1;
      this.h = paramString1;
      this.j = paramString2;
      this.k = paramString3;
      this.l = false;
      this.n = paramf;
      this.o = paramju;
      this.q = new e();
      this.p = parama;
      this.m = 0;
      if (this.l)
        if (this.j != null)
          break label139;
    }
    label139: for (boolean bool = true; ; bool = false)
    {
      w.b(bool, "can't be anonymous with an upload account");
      return;
      localContext = paramContext;
      break;
    }
  }

  public b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, -1, paramString1, null, null, false, d, jv.d(), null, a.a);
  }

  private static int a(Context paramContext)
  {
    try
    {
      int i1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.wtf("ClearcutLogger", "This can't happen.");
    }
    return 0;
  }

  public final d a(byte[] paramArrayOfByte)
  {
    return new d(this, paramArrayOfByte, 0);
  }

  public final boolean a(g paramg, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.n.a(100L, paramTimeUnit);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.clearcut.b
 * JD-Core Version:    0.6.0
 */