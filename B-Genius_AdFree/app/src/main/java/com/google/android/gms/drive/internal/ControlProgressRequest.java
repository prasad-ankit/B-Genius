package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ControlProgressRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ai();
  final int a;
  final int b;
  final int c;
  final DriveId d;
  final ParcelableTransferPreferences e;

  ControlProgressRequest(int paramInt1, int paramInt2, int paramInt3, DriveId paramDriveId, ParcelableTransferPreferences paramParcelableTransferPreferences)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramDriveId;
    this.e = paramParcelableTransferPreferences;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ai.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ControlProgressRequest
 * JD-Core Version:    0.6.0
 */