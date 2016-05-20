package com.google.android.gms.games.internal;

import android.os.IBinder;
import android.os.Parcel;

final class p
  implements n
{
  private IBinder a;

  p(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final PopupLocationInfoParcelable a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesClient");
      this.a.transact(1001, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        PopupLocationInfoParcelable localPopupLocationInfoParcelable2 = t.a(localParcel2);
        localPopupLocationInfoParcelable1 = localPopupLocationInfoParcelable2;
        return localPopupLocationInfoParcelable1;
      }
      PopupLocationInfoParcelable localPopupLocationInfoParcelable1 = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.p
 * JD-Core Version:    0.6.0
 */