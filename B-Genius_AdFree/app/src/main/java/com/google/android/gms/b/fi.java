package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;

final class fi
  implements fg
{
  private IBinder a;

  fi(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final IBinder a(a parama)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
      if (parama != null);
      for (IBinder localIBinder1 = parama.asBinder(); ; localIBinder1 = null)
      {
        localParcel1.writeStrongBinder(localIBinder1);
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
 * Qualified Name:     com.google.android.gms.b.fi
 * JD-Core Version:    0.6.0
 */