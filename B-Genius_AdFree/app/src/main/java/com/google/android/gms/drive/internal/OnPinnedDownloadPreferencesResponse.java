package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnPinnedDownloadPreferencesResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new H();
  final int a;
  final ParcelableTransferPreferences b;

  OnPinnedDownloadPreferencesResponse(int paramInt, ParcelableTransferPreferences paramParcelableTransferPreferences)
  {
    this.a = paramInt;
    this.b = paramParcelableTransferPreferences;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    H.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse
 * JD-Core Version:    0.6.0
 */