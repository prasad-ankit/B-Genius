package com.google.android.gms.b;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;

public final class kc
{
  public static final d a;
  public static final a b;
  private static f c = new f();
  private static f d = new f();
  private static d e;

  static
  {
    a = new kd();
    e = new ke();
    new Scope("profile");
    new Scope("email");
    b = new a("SignIn.API", a, c);
    new a("SignIn.INTERNAL_API", e, d);
    new kf();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.kc
 * JD-Core Version:    0.6.0
 */