package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Contents
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new i();
  final int a;
  final ParcelFileDescriptor b;
  final int c;
  final int d;
  final DriveId e;
  final boolean f;
  final String g;

  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, boolean paramBoolean, String paramString)
  {
    this.a = paramInt1;
    this.b = paramParcelFileDescriptor;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramDriveId;
    this.f = paramBoolean;
    this.g = paramString;
  }

  public final int a()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.Contents
 * JD-Core Version:    0.6.0
 */