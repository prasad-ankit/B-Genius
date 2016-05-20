package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.q;

public final class b extends B
{
  private int a;

  public static Account a(A paramA)
  {
    Object localObject1 = null;
    long l;
    if (paramA != null)
      l = Binder.clearCallingIdentity();
    try
    {
      Account localAccount = paramA.a();
      localObject1 = localAccount;
      return localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
    throw localObject2;
  }

  public final Account a()
  {
    int i = Binder.getCallingUid();
    if (i == this.a)
      return null;
    if (q.a(null, i))
    {
      this.a = i;
      return null;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof b))
      return false;
    return null.equals(null);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.b
 * JD-Core Version:    0.6.0
 */