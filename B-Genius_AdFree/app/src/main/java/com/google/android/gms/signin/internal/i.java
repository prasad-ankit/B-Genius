package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.A;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.M;
import com.google.android.gms.common.internal.ResolveAccountRequest;

final class i
  implements g
{
  private IBinder a;

  i(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final void a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
      localParcel1.writeInt(paramInt);
      this.a.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(int paramInt, Account paramAccount, d paramd)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        localParcel1.writeInt(paramInt);
        if (paramAccount == null)
          continue;
        localParcel1.writeInt(1);
        paramAccount.writeToParcel(localParcel1, 0);
        if (paramd != null)
        {
          localIBinder = paramd.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      IBinder localIBinder = null;
    }
  }

  public final void a(A paramA, int paramInt, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
      if (paramA != null);
      for (IBinder localIBinder = paramA.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(9, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(AuthAccountRequest paramAuthAccountRequest, d paramd)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        if (paramAuthAccountRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramAuthAccountRequest.writeToParcel(localParcel1, 0);
        if (paramd != null)
        {
          localIBinder = paramd.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      IBinder localIBinder = null;
    }
  }

  public final void a(ResolveAccountRequest paramResolveAccountRequest, M paramM)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        if (paramResolveAccountRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramResolveAccountRequest.writeToParcel(localParcel1, 0);
        if (paramM != null)
        {
          localIBinder = paramM.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      IBinder localIBinder = null;
    }
  }

  public final void a(CheckServerAuthResult paramCheckServerAuthResult)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
      if (paramCheckServerAuthResult != null)
      {
        localParcel1.writeInt(1);
        paramCheckServerAuthResult.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(RecordConsentRequest paramRecordConsentRequest, d paramd)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        if (paramRecordConsentRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramRecordConsentRequest.writeToParcel(localParcel1, 0);
        if (paramd != null)
        {
          localIBinder = paramd.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      IBinder localIBinder = null;
    }
  }

  public final void a(SignInRequest paramSignInRequest, d paramd)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        if (paramSignInRequest == null)
          continue;
        localParcel1.writeInt(1);
        paramSignInRequest.writeToParcel(localParcel1, 0);
        if (paramd != null)
        {
          localIBinder = paramd.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          this.a.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      IBinder localIBinder = null;
    }
  }

  public final void a(d paramd)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
      if (paramd != null);
      for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(11, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
      int i = 0;
      if (paramBoolean)
        i = 1;
      localParcel1.writeInt(i);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.i
 * JD-Core Version:    0.6.0
 */