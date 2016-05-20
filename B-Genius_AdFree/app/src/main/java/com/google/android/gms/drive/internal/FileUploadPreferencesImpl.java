package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FileUploadPreferencesImpl
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new d();
  final int a;
  int b;
  int c;
  boolean d;

  FileUploadPreferencesImpl(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramBoolean;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.FileUploadPreferencesImpl
 * JD-Core Version:    0.6.0
 */