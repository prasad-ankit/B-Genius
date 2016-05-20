package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableChangeInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new P();
  final int a;
  final long b;
  final List c;

  ParcelableChangeInfo(int paramInt, long paramLong, List paramList)
  {
    this.a = paramInt;
    this.b = paramLong;
    this.c = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    P.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo
 * JD-Core Version:    0.6.0
 */