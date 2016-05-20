package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class j extends l
{
  private int a;
  private Bundle b;

  protected j(i parami, int paramInt, Bundle paramBundle)
  {
    super(parami, Boolean.valueOf(true));
    this.a = paramInt;
    this.b = paramBundle;
  }

  protected abstract void a(ConnectionResult paramConnectionResult);

  protected abstract boolean a();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.j
 * JD-Core Version:    0.6.0
 */