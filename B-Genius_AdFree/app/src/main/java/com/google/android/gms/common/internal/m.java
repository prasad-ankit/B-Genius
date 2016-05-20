package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.w;
import android.util.Log;

public final class m extends H
{
  private i a;
  private final int b;

  public m(i parami, int paramInt)
  {
    this.a = parami;
    this.b = paramInt;
  }

  public final void a(int paramInt, Bundle paramBundle)
  {
    Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
  }

  public final void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    w.a(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
    this.a.a(paramInt, paramIBinder, paramBundle, this.b);
    this.a = null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.m
 * JD-Core Version:    0.6.0
 */