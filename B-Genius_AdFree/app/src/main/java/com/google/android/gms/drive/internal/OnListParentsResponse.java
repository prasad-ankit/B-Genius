package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListParentsResponse extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new F();
  final int a;
  final DataHolder b;

  OnListParentsResponse(int paramInt, DataHolder paramDataHolder)
  {
    this.a = paramInt;
    this.b = paramDataHolder;
  }

  protected final void a(Parcel paramParcel, int paramInt)
  {
    F.a(this, paramParcel, paramInt);
  }

  public int describeContents()
  {
    return 0;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnListParentsResponse
 * JD-Core Version:    0.6.0
 */