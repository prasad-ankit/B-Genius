package com.google.android.gms.ads.internal.request;

import android.os.IBinder;
import android.os.Parcel;

final class x
  implements v
{
  private IBinder a;

  x(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final AdResponseParcel a(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (paramAdRequestInfoParcel == null)
          continue;
        localParcel1.writeInt(1);
        paramAdRequestInfoParcel.writeToParcel(localParcel1, 0);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          AdResponseParcel localAdResponseParcel2 = t.a(localParcel2);
          localAdResponseParcel1 = localAdResponseParcel2;
          return localAdResponseParcel1;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      AdResponseParcel localAdResponseParcel1 = null;
    }
  }

  public final void a(AdRequestInfoParcel paramAdRequestInfoParcel, y paramy)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (paramAdRequestInfoParcel == null)
          continue;
        localParcel1.writeInt(1);
        paramAdRequestInfoParcel.writeToParcel(localParcel1, 0);
        if (paramy != null)
        {
          localIBinder = paramy.asBinder();
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

  public final IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.x
 * JD-Core Version:    0.6.0
 */