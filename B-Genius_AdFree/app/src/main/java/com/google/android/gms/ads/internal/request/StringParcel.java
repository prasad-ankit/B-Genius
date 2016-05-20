package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StringParcel
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new L();
  final int a;
  String b;

  StringParcel(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }

  public StringParcel(String paramString)
  {
    this.a = 1;
    this.b = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    L.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.StringParcel
 * JD-Core Version:    0.6.0
 */