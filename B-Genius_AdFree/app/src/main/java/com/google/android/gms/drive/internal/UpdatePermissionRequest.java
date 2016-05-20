package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UpdatePermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ac();
  final int a;
  final DriveId b;
  final String c;
  final int d;
  final boolean e;
  final String f;

  UpdatePermissionRequest(int paramInt1, DriveId paramDriveId, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    this.a = paramInt1;
    this.b = paramDriveId;
    this.c = paramString1;
    this.d = paramInt2;
    this.e = paramBoolean;
    this.f = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ac.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.UpdatePermissionRequest
 * JD-Core Version:    0.6.0
 */