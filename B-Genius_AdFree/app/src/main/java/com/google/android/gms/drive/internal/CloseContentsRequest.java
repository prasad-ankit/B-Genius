package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ah();
  final int a;
  final Contents b;
  final Boolean c;
  final int d;

  CloseContentsRequest(int paramInt1, Contents paramContents, Boolean paramBoolean, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramContents;
    this.c = paramBoolean;
    this.d = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ah.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CloseContentsRequest
 * JD-Core Version:    0.6.0
 */