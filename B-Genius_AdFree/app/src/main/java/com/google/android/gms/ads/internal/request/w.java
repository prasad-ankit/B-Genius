package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class w extends Binder
  implements v
{
  public w()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
  }

  public static v a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
    if ((localIInterface != null) && ((localIInterface instanceof v)))
      return (v)localIInterface;
    return new x(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      int i = paramParcel1.readInt();
      AdRequestInfoParcel localAdRequestInfoParcel2 = null;
      if (i != 0)
        localAdRequestInfoParcel2 = r.a(paramParcel1);
      AdResponseParcel localAdResponseParcel = a(localAdRequestInfoParcel2);
      paramParcel2.writeNoException();
      if (localAdResponseParcel != null)
      {
        paramParcel2.writeInt(1);
        localAdResponseParcel.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 2:
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
    AdRequestInfoParcel localAdRequestInfoParcel1;
    IBinder localIBinder;
    Object localObject;
    if (paramParcel1.readInt() != 0)
    {
      localAdRequestInfoParcel1 = r.a(paramParcel1);
      localIBinder = paramParcel1.readStrongBinder();
      localObject = null;
      if (localIBinder != null)
        break label180;
    }
    while (true)
    {
      a(localAdRequestInfoParcel1, (y)localObject);
      paramParcel2.writeNoException();
      return true;
      localAdRequestInfoParcel1 = null;
      break;
      label180: IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
      if ((localIInterface != null) && ((localIInterface instanceof y)))
      {
        localObject = (y)localIInterface;
        continue;
      }
      localObject = new A(localIBinder);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.w
 * JD-Core Version:    0.6.0
 */