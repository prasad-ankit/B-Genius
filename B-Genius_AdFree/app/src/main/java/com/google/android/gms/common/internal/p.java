package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.k;

public final class p extends j
{
  private IBinder a;

  public p(i parami, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(parami, paramInt, paramBundle);
    this.a = paramIBinder;
  }

  protected final void a(ConnectionResult paramConnectionResult)
  {
    if (i.f(this.b) != null)
      i.f(this.b).a(paramConnectionResult);
    this.b.a(paramConnectionResult);
  }

  protected final boolean a()
  {
    IInterface localIInterface;
    do
    {
      try
      {
        String str = this.a.getInterfaceDescriptor();
        if (!this.b.b().equals(str))
        {
          Log.e("GmsClient", "service descriptor mismatch: " + this.b.b() + " vs. " + str);
          return false;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("GmsClient", "service probably died");
        return false;
      }
      localIInterface = this.b.a(this.a);
    }
    while ((localIInterface == null) || (!i.a(this.b, 2, 3, localIInterface)));
    Bundle localBundle = this.b.b_();
    if (i.c(this.b) != null)
      i.c(this.b).a(localBundle);
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.p
 * JD-Core Version:    0.6.0
 */