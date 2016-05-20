package com.google.android.gms.ads.internal.reward.a;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.b.el;

final class f
  implements d
{
  private IBinder a;

  f(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final IBinder a(a parama, el paramel, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
      if (parama != null);
      for (IBinder localIBinder1 = parama.asBinder(); ; localIBinder1 = null)
      {
        localParcel1.writeStrongBinder(localIBinder1);
        IBinder localIBinder2 = null;
        if (paramel != null)
          localIBinder2 = paramel.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        localParcel1.writeInt(paramInt);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        IBinder localIBinder3 = localParcel2.readStrongBinder();
        return localIBinder3;
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
 * Qualified Name:     com.google.android.gms.ads.internal.reward.a.f
 * JD-Core Version:    0.6.0
 */