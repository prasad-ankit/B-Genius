package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ag();
  final int a;
  final DriveId b;
  final MetadataBundle c;
  final Contents d;
  final boolean e;
  final String f;
  final int g;
  final int h;
  final boolean i;
  final boolean j;

  CloseContentsAndUpdateMetadataRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, boolean paramBoolean1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramInt1;
    this.b = paramDriveId;
    this.c = paramMetadataBundle;
    this.d = paramContents;
    this.e = paramBoolean1;
    this.f = paramString;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramBoolean2;
    this.j = paramBoolean3;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ag.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest
 * JD-Core Version:    0.6.0
 */