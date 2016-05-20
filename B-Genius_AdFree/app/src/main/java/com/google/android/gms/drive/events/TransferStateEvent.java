package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.f;
import java.util.Arrays;
import java.util.List;

public final class TransferStateEvent
  implements DriveEvent
{
  public static final Parcelable.Creator CREATOR = new h();
  final int a;
  final String b;
  final List c;

  TransferStateEvent(int paramInt, String paramString, List paramList)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramList;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    int i = 1;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      i = 0;
    TransferStateEvent localTransferStateEvent;
    do
    {
      do
        return i;
      while (paramObject == this);
      localTransferStateEvent = (TransferStateEvent)paramObject;
    }
    while ((f.a(this.b, localTransferStateEvent.b)) && (f.a(this.c, localTransferStateEvent.c)));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = this.c;
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = TextUtils.join("','", this.c);
    return String.format("TransferStateEvent[%s]", arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.TransferStateEvent
 * JD-Core Version:    0.6.0
 */