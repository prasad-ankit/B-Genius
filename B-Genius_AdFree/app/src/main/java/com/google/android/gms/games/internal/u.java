package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.j;
import android.view.View;

public class u
{
  protected c a;
  protected v b;

  private u(c paramc, int paramInt)
  {
    this.a = paramc;
    a(paramInt);
  }

  public static u a(c paramc, int paramInt)
  {
    if (j.b())
      return new w(paramc, paramInt);
    return new u(paramc, paramInt);
  }

  public void a()
  {
    this.a.a(this.b.a, this.b.a());
  }

  protected void a(int paramInt)
  {
    this.b = new v(paramInt, new Binder(), 0);
  }

  public void a(View paramView)
  {
  }

  public final IBinder b()
  {
    return this.b.a;
  }

  public final v c()
  {
    return this.b;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.u
 * JD-Core Version:    0.6.0
 */