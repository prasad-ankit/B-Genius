package com.google.android.gms.ads.internal.reward.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class h extends Binder
  implements g
{
  public h()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
  }

  public static g a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    if ((localIInterface != null) && ((localIInterface instanceof g)))
      return (g)localIInterface;
    return new i(paramIBinder);
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
      a();
      paramParcel2.writeNoException();
      return true;
    case 2:
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
      b();
      paramParcel2.writeNoException();
      return true;
    case 3:
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
      c();
      paramParcel2.writeNoException();
      return true;
    case 4:
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
      d();
      paramParcel2.writeNoException();
      return true;
    case 5:
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
      IBinder localIBinder = paramParcel1.readStrongBinder();
      Object localObject;
      if (localIBinder == null)
        localObject = null;
      while (true)
      {
        a((a)localObject);
        paramParcel2.writeNoException();
        return true;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardItem");
        if ((localIInterface != null) && ((localIInterface instanceof a)))
        {
          localObject = (a)localIInterface;
          continue;
        }
        localObject = new c(localIBinder);
      }
    case 6:
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
      e();
      paramParcel2.writeNoException();
      return true;
    case 7:
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    a(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.reward.a.h
 * JD-Core Version:    0.6.0
 */