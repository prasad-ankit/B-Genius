package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class o extends Binder
  implements n
{
  public o()
  {
    attachInterface(this, "com.google.android.gms.games.internal.IGamesClient");
  }

  public static n a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesClient");
    if ((localIInterface != null) && ((localIInterface instanceof n)))
      return (n)localIInterface;
    return new p(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.games.internal.IGamesClient");
      return true;
    case 1001:
    }
    paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesClient");
    PopupLocationInfoParcelable localPopupLocationInfoParcelable = a();
    paramParcel2.writeNoException();
    if (localPopupLocationInfoParcelable != null)
    {
      paramParcel2.writeInt(1);
      localPopupLocationInfoParcelable.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.o
 * JD-Core Version:    0.6.0
 */