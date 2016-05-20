package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.A;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.B;
import com.google.android.gms.common.internal.N;
import com.google.android.gms.common.internal.ResolveAccountRequest;

public abstract class h extends Binder
  implements g
{
  public static g a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
    if ((localIInterface != null) && ((localIInterface instanceof g)))
      return (g)localIInterface;
    return new i(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
      return true;
    case 2:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      int i4 = paramParcel1.readInt();
      AuthAccountRequest localAuthAccountRequest = null;
      if (i4 != 0)
        localAuthAccountRequest = (AuthAccountRequest)AuthAccountRequest.CREATOR.createFromParcel(paramParcel1);
      a(localAuthAccountRequest, e.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      int i3 = paramParcel1.readInt();
      CheckServerAuthResult localCheckServerAuthResult = null;
      if (i3 != 0)
        localCheckServerAuthResult = (CheckServerAuthResult)CheckServerAuthResult.CREATOR.createFromParcel(paramParcel1);
      a(localCheckServerAuthResult);
      paramParcel2.writeNoException();
      return true;
    case 4:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      if (paramParcel1.readInt() != 0);
      for (boolean bool2 = true; ; bool2 = false)
      {
        a(bool2);
        paramParcel2.writeNoException();
        return true;
      }
    case 5:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      int i2 = paramParcel1.readInt();
      ResolveAccountRequest localResolveAccountRequest = null;
      if (i2 != 0)
        localResolveAccountRequest = (ResolveAccountRequest)ResolveAccountRequest.CREATOR.createFromParcel(paramParcel1);
      a(localResolveAccountRequest, N.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 7:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 8:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      int n = paramParcel1.readInt();
      int i1 = paramParcel1.readInt();
      Account localAccount = null;
      if (i1 != 0)
        localAccount = (Account)Account.CREATOR.createFromParcel(paramParcel1);
      a(n, localAccount, e.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      A localA = B.a(paramParcel1.readStrongBinder());
      int k = paramParcel1.readInt();
      int m = paramParcel1.readInt();
      boolean bool1 = false;
      if (m != 0)
        bool1 = true;
      a(localA, k, bool1);
      paramParcel2.writeNoException();
      return true;
    case 10:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      int j = paramParcel1.readInt();
      RecordConsentRequest localRecordConsentRequest = null;
      if (j != 0)
        localRecordConsentRequest = (RecordConsentRequest)RecordConsentRequest.CREATOR.createFromParcel(paramParcel1);
      a(localRecordConsentRequest, e.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 11:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      a(e.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 12:
    }
    paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
    int i = paramParcel1.readInt();
    SignInRequest localSignInRequest = null;
    if (i != 0)
      localSignInRequest = (SignInRequest)SignInRequest.CREATOR.createFromParcel(paramParcel1);
    a(localSignInRequest, e.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.h
 * JD-Core Version:    0.6.0
 */