package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class ParcelableEventList
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new d();
  final int a;
  final List b;
  final DataHolder c;
  final boolean d;
  final List e;
  final ParcelableChangeInfo f;

  ParcelableEventList(int paramInt, List paramList1, DataHolder paramDataHolder, boolean paramBoolean, List paramList2, ParcelableChangeInfo paramParcelableChangeInfo)
  {
    this.a = paramInt;
    this.b = paramList1;
    this.c = paramDataHolder;
    this.d = paramBoolean;
    this.e = paramList2;
    this.f = paramParcelableChangeInfo;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ParcelableEventList
 * JD-Core Version:    0.6.0
 */