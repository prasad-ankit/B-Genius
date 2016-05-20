package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import android.util.Base64;
import com.google.android.gms.b.ku;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.u;

public class ChangeSequenceNumber
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  final int a;
  final long b;
  final long c;
  final long d;
  private volatile String e = null;

  ChangeSequenceNumber(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool2;
    boolean bool3;
    if (paramLong1 != -1L)
    {
      bool2 = bool1;
      w.c(bool2);
      if (paramLong2 == -1L)
        break label90;
      bool3 = bool1;
      label42: w.c(bool3);
      if (paramLong3 == -1L)
        break label96;
    }
    while (true)
    {
      w.c(bool1);
      this.a = paramInt;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramLong3;
      return;
      bool2 = false;
      break;
      label90: bool3 = false;
      break label42;
      label96: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ChangeSequenceNumber));
    ChangeSequenceNumber localChangeSequenceNumber;
    do
    {
      return false;
      localChangeSequenceNumber = (ChangeSequenceNumber)paramObject;
    }
    while ((localChangeSequenceNumber.c != this.c) || (localChangeSequenceNumber.d != this.d) || (localChangeSequenceNumber.b != this.b));
    return true;
  }

  public int hashCode()
  {
    return (String.valueOf(this.b) + String.valueOf(this.c) + String.valueOf(this.d)).hashCode();
  }

  public String toString()
  {
    if (this.e == null)
    {
      u localu = new u();
      localu.a = this.a;
      localu.b = this.b;
      localu.c = this.c;
      localu.d = this.d;
      String str = Base64.encodeToString(ku.a(localu), 10);
      this.e = ("ChangeSequenceNumber:" + str);
    }
    return this.e;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.ChangeSequenceNumber
 * JD-Core Version:    0.6.0
 */