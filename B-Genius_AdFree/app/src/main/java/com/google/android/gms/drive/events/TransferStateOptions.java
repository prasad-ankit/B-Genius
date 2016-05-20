package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class TransferStateOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new i();
  final int a;
  final List b;
  private final Set c;

  TransferStateOptions(int paramInt, List paramList)
  {
  }

  private TransferStateOptions(int paramInt, List paramList, Set paramSet)
  {
    this.a = paramInt;
    this.b = paramList;
    this.c = paramSet;
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
    TransferStateOptions localTransferStateOptions = (TransferStateOptions)paramObject;
    return f.a(this.c, localTransferStateOptions.c);
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.c;
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.b;
    return String.format(localLocale, "TransferStateOptions[Spaces=%s]", arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.TransferStateOptions
 * JD-Core Version:    0.6.0
 */