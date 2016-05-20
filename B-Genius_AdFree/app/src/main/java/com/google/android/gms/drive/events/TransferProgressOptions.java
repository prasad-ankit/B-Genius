package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

public final class TransferProgressOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new g();
  final int a;
  final int b;

  TransferProgressOptions(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      return false;
    if (paramObject == this)
      return true;
    TransferProgressOptions localTransferProgressOptions = (TransferProgressOptions)paramObject;
    return f.a(Integer.valueOf(this.b), Integer.valueOf(localTransferProgressOptions.b));
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this.b);
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this.b);
    return String.format(localLocale, "TransferProgressOptions[type=%d]", arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.TransferProgressOptions
 * JD-Core Version:    0.6.0
 */