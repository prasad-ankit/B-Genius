package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new t();
  final int a;
  final DriveId b;
  final boolean c;
  final List d;
  final boolean e;
  final DataHolder f;
  final String g;

  LoadRealtimeRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean1, List paramList, boolean paramBoolean2, DataHolder paramDataHolder, String paramString)
  {
    this.a = paramInt;
    this.b = paramDriveId;
    this.c = paramBoolean1;
    this.d = paramList;
    this.e = paramBoolean2;
    this.f = paramDataHolder;
    this.g = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    t.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.LoadRealtimeRequest
 * JD-Core Version:    0.6.0
 */