package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import java.util.List;
import java.util.Set;

public class GetChangesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new e();
  final int a;
  final ChangeSequenceNumber b;
  final int c;
  final List d;
  final boolean e;

  private GetChangesRequest(int paramInt1, ChangeSequenceNumber paramChangeSequenceNumber, int paramInt2, List paramList, Set paramSet, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramChangeSequenceNumber;
    this.c = paramInt2;
    this.d = paramList;
    this.e = paramBoolean;
  }

  GetChangesRequest(int paramInt1, ChangeSequenceNumber paramChangeSequenceNumber, int paramInt2, List paramList, boolean paramBoolean)
  {
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.GetChangesRequest
 * JD-Core Version:    0.6.0
 */