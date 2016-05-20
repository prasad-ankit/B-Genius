package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

public class OnChangesResponse extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new w();
  final int a;
  final DataHolder b;
  final List c;
  final ChangeSequenceNumber d;
  final boolean e;

  OnChangesResponse(int paramInt, DataHolder paramDataHolder, List paramList, ChangeSequenceNumber paramChangeSequenceNumber, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramDataHolder;
    this.c = paramList;
    this.d = paramChangeSequenceNumber;
    this.e = paramBoolean;
  }

  protected final void a(Parcel paramParcel, int paramInt)
  {
    w.a(this, paramParcel, paramInt | 0x1);
  }

  public int describeContents()
  {
    return 0;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnChangesResponse
 * JD-Core Version:    0.6.0
 */