package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.stats.b;
import java.util.HashSet;
import java.util.Set;

final class w
{
  private final x b;
  private final Set c;
  private int d;
  private boolean e;
  private IBinder f;
  private final v g;
  private ComponentName h;

  public w(u paramu, v paramv)
  {
    this.g = paramv;
    this.b = new x(this);
    this.c = new HashSet();
    this.d = 2;
  }

  public final void a()
  {
    u.c(this.a).a(u.b(this.a), this.b);
    this.e = false;
    this.d = 2;
  }

  public final void a(ServiceConnection paramServiceConnection)
  {
    u.c(this.a).b(u.b(this.a), paramServiceConnection);
    this.c.remove(paramServiceConnection);
  }

  public final void a(ServiceConnection paramServiceConnection, String paramString)
  {
    u.c(this.a).a(u.b(this.a), paramServiceConnection, paramString, this.g.a());
    this.c.add(paramServiceConnection);
  }

  public final void a(String paramString)
  {
    this.d = 3;
    this.e = u.c(this.a).a(u.b(this.a), paramString, this.g.a(), this.b, 129);
    if (!this.e)
      this.d = 2;
    try
    {
      u.c(this.a).a(u.b(this.a), this.b);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
  }

  public final boolean b()
  {
    return this.e;
  }

  public final boolean b(ServiceConnection paramServiceConnection)
  {
    return this.c.contains(paramServiceConnection);
  }

  public final int c()
  {
    return this.d;
  }

  public final boolean d()
  {
    return this.c.isEmpty();
  }

  public final IBinder e()
  {
    return this.f;
  }

  public final ComponentName f()
  {
    return this.h;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.w
 * JD-Core Version:    0.6.0
 */