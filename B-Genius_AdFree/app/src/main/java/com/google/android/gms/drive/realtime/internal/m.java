package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.i;

public abstract class m extends Binder
  implements l
{
  public static l a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
    if ((localIInterface != null) && ((localIInterface instanceof l)))
      return (l)localIInterface;
    return new n(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
      int j = paramParcel1.readInt();
      DataHolder localDataHolder = null;
      if (j != 0)
        localDataHolder = i.a(paramParcel1);
      a(localDataHolder);
      paramParcel2.writeNoException();
      return true;
    case 2:
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
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
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.m
 * JD-Core Version:    0.6.0
 */