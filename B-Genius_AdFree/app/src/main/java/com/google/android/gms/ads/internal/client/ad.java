package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;

final class ad
  implements ab
{
  private IBinder a;

  ad(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final IBinder a(a parama, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
      if (parama != null);
      for (IBinder localIBinder1 = parama.asBinder(); ; localIBinder1 = null)
      {
        localParcel1.writeStrongBinder(localIBinder1);
        localParcel1.writeInt(paramInt);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        IBinder localIBinder2 = localParcel2.readStrongBinder();
        return localIBinder2;
      }
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
 * Qualified Name:     com.google.android.gms.ads.internal.client.ad
 * JD-Core Version:    0.6.0
 */