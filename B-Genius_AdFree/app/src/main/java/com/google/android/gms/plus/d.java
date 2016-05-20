package com.google.android.gms.plus;

import android.support.v4.app.w;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.f;

public final class d
{
  public static final com.google.android.gms.common.api.a a;
  public static final Scope b;
  public static final a c;
  private static f d = new f();
  private static com.google.android.gms.common.api.d e = new e();

  static
  {
    a = new com.google.android.gms.common.api.a("Plus.API", e, d);
    b = new Scope("https://www.googleapis.com/auth/plus.login");
    new Scope("https://www.googleapis.com/auth/plus.me");
    new b();
    new c();
    c = new a();
    new h();
    new g();
  }

  public static com.google.android.gms.plus.internal.g a(com.google.android.gms.common.api.g paramg, boolean paramBoolean)
  {
    if (paramg != null);
    for (boolean bool = true; ; bool = false)
    {
      w.b(bool, "GoogleApiClient parameter is required.");
      w.a(paramg.d(), "GoogleApiClient must be connected.");
      w.a(paramg.a(a), "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      if (!paramg.b(a))
        break;
      return (com.google.android.gms.plus.internal.g)paramg.a(d);
    }
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.d
 * JD-Core Version:    0.6.0
 */