package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;

final class be
  implements bc
{
  private IBinder a;

  be(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final IBinder a(a parama1, a parama2, a parama3, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
      IBinder localIBinder1;
      if (parama1 != null)
      {
        localIBinder1 = parama1.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        if (parama2 == null)
          break label131;
      }
      label131: for (IBinder localIBinder2 = parama2.asBinder(); ; localIBinder2 = null)
      {
        localParcel1.writeStrongBinder(localIBinder2);
        IBinder localIBinder3 = null;
        if (parama3 != null)
          localIBinder3 = parama3.asBinder();
        localParcel1.writeStrongBinder(localIBinder3);
        localParcel1.writeInt(paramInt);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        IBinder localIBinder4 = localParcel2.readStrongBinder();
        return localIBinder4;
        localIBinder1 = null;
        break;
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
 * Qualified Name:     com.google.android.gms.b.be
 * JD-Core Version:    0.6.0
 */