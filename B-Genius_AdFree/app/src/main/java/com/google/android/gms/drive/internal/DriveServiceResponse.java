package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DriveServiceResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  final int a;
  final IBinder b;

  DriveServiceResponse(int paramInt, IBinder paramIBinder)
  {
    this.a = paramInt;
    this.b = paramIBinder;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.DriveServiceResponse
 * JD-Core Version:    0.6.0
 */