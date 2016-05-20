package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.events.internal.TransferProgressData;
import java.util.Arrays;

public final class TransferProgressEvent
  implements DriveEvent
{
  public static final Parcelable.Creator CREATOR = new f();
  final int a;
  final TransferProgressData b;

  TransferProgressEvent(int paramInt, TransferProgressData paramTransferProgressData)
  {
    this.a = paramInt;
    this.b = paramTransferProgressData;
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
    TransferProgressEvent localTransferProgressEvent = (TransferProgressEvent)paramObject;
    return com.google.android.gms.common.internal.f.a(this.b, localTransferProgressEvent.b);
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.b;
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.b.toString();
    return String.format("TransferProgressEvent[%s]", arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.TransferProgressEvent
 * JD-Core Version:    0.6.0
 */