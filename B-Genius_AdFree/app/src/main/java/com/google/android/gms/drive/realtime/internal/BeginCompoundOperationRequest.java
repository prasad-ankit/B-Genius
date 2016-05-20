package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  final int a;
  final boolean b;
  final String c;
  final boolean d;

  BeginCompoundOperationRequest(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramString;
    this.d = paramBoolean2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest
 * JD-Core Version:    0.6.0
 */