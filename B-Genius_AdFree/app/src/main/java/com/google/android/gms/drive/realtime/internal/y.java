package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public abstract class y extends Binder
  implements x
{
  public static x a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
    if ((localIInterface != null) && ((localIInterface instanceof x)))
      return (x)localIInterface;
    return new z(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IEventCallback");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
      int j = paramParcel1.readInt();
      ParcelableEventList localParcelableEventList = null;
      if (j != 0)
        localParcelableEventList = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(paramParcel1);
      a(localParcelableEventList);
      paramParcel2.writeNoException();
      return true;
    case 2:
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
    int i = paramParcel1.readInt();
    Status localStatus = null;
    if (i != 0)
      localStatus = (Status)Status.CREATOR.createFromParcel(paramParcel1);
    a(localStatus);
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.y
 * JD-Core Version:    0.6.0
 */