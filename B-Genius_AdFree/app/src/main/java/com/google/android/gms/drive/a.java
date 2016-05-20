package com.google.android.gms.drive;

import com.google.android.gms.common.api.Scope;

public final class a
{
  public static final Scope a;
  public static final com.google.android.gms.common.api.a b;
  private static com.google.android.gms.common.api.f c = new com.google.android.gms.common.api.f();

  static
  {
    new Scope("https://www.googleapis.com/auth/drive.file");
    a = new Scope("https://www.googleapis.com/auth/drive.appdata");
    new Scope("https://www.googleapis.com/auth/drive");
    new Scope("https://www.googleapis.com/auth/drive.apps");
    b = new com.google.android.gms.common.api.a("Drive.API", new b(), c);
    new com.google.android.gms.common.api.a("Drive.INTERNAL_API", new c(), c);
    new f();
    new k();
    new m();
    new g();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.a
 * JD-Core Version:    0.6.0
 */