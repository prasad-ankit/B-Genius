package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetPermissionsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new i();
  final int a;
  final List b;
  final int c;

  GetPermissionsResponse(int paramInt1, List paramList, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramList;
    this.c = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.GetPermissionsResponse
 * JD-Core Version:    0.6.0
 */