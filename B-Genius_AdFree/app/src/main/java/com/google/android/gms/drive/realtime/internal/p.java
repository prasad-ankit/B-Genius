package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.i;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public abstract class p extends Binder
  implements o
{
  public static o a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
    if ((localIInterface != null) && ((localIInterface instanceof o)))
      return (o)localIInterface;
    return new q(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
      DataHolder localDataHolder;
      if (paramParcel1.readInt() != 0)
      {
        localDataHolder = i.a(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label118;
      }
      label118: for (ParcelableEventList localParcelableEventList = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(paramParcel1); ; localParcelableEventList = null)
      {
        a(localDataHolder, localParcelableEventList);
        paramParcel2.writeNoException();
        return true;
        localDataHolder = null;
        break;
      }
    case 2:
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
    if (paramParcel1.readInt() != 0);
    for (Status localStatus = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; localStatus = null)
    {
      a(localStatus);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.p
 * JD-Core Version:    0.6.0
 */