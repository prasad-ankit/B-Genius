package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class ChangeResourceParentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ae();
  final int a;
  final DriveId b;
  final List c;
  final List d;

  ChangeResourceParentsRequest(int paramInt, DriveId paramDriveId, List paramList1, List paramList2)
  {
    this.a = paramInt;
    this.b = paramDriveId;
    this.c = paramList1;
    this.d = paramList2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ae.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ChangeResourceParentsRequest
 * JD-Core Version:    0.6.0
 */