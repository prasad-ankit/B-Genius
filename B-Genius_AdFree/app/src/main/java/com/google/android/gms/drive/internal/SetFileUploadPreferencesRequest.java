package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetFileUploadPreferencesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new S();
  final int a;
  final FileUploadPreferencesImpl b;

  SetFileUploadPreferencesRequest(int paramInt, FileUploadPreferencesImpl paramFileUploadPreferencesImpl)
  {
    this.a = paramInt;
    this.b = paramFileUploadPreferencesImpl;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    S.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest
 * JD-Core Version:    0.6.0
 */