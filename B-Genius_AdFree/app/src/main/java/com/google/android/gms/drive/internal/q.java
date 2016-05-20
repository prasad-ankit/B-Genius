package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class q extends Binder
  implements p
{
  public static p a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventCallback");
    if ((localIInterface != null) && ((localIInterface instanceof p)))
      return (p)localIInterface;
    return new r(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.drive.internal.IEventCallback");
      return true;
    case 1:
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IEventCallback");
    if (paramParcel1.readInt() != 0);
    for (OnEventResponse localOnEventResponse = (OnEventResponse)OnEventResponse.CREATOR.createFromParcel(paramParcel1); ; localOnEventResponse = null)
    {
      a(localOnEventResponse);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.q
 * JD-Core Version:    0.6.0
 */