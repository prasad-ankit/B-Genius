package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

public abstract class v extends Binder
  implements u
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IErrorCallback");
      return true;
    case 2:
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
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
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.v
 * JD-Core Version:    0.6.0
 */