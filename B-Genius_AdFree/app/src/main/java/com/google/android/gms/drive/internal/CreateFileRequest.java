package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new al();
  final int a;
  final DriveId b;
  final MetadataBundle c;
  final Contents d;
  final Integer e;
  final boolean f;
  final String g;
  final int h;
  final int i;
  final String j;

  CreateFileRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, Integer paramInteger, boolean paramBoolean, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    if ((paramContents != null) && (paramInt3 != 0))
      if (paramContents.a() != paramInt3)
        break label67;
    label67: for (boolean bool = true; ; bool = false)
    {
      w.b(bool, "inconsistent contents reference");
      if (((paramInteger != null) && (paramInteger.intValue() != 0)) || (paramContents != null) || (paramInt3 != 0))
        break;
      throw new IllegalArgumentException("Need a valid contents");
    }
    this.a = paramInt1;
    this.b = ((DriveId)w.a(paramDriveId));
    this.c = ((MetadataBundle)w.a(paramMetadataBundle));
    this.d = paramContents;
    this.e = paramInteger;
    this.g = paramString1;
    this.h = paramInt2;
    this.f = paramBoolean;
    this.i = paramInt3;
    this.j = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    al.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CreateFileRequest
 * JD-Core Version:    0.6.0
 */