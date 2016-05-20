package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckServerAuthResult
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  final int a;
  final boolean b;
  final List c;

  CheckServerAuthResult(int paramInt, boolean paramBoolean, List paramList)
  {
    this.a = paramInt;
    this.b = paramBoolean;
    this.c = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.CheckServerAuthResult
 * JD-Core Version:    0.6.0
 */