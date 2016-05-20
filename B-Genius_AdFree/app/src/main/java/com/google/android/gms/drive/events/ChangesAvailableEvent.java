package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

public final class ChangesAvailableEvent
  implements SafeParcelable, DriveEvent
{
  public static final Parcelable.Creator CREATOR = new b();
  final int a;
  final String b;
  final ChangesAvailableOptions c;

  ChangesAvailableEvent(int paramInt, String paramString, ChangesAvailableOptions paramChangesAvailableOptions)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramChangesAvailableOptions;
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
    ChangesAvailableEvent localChangesAvailableEvent;
    do
    {
      do
        return i;
      while (paramObject == this);
      localChangesAvailableEvent = (ChangesAvailableEvent)paramObject;
    }
    while ((f.a(this.c, localChangesAvailableEvent.c)) && (f.a(this.b, localChangesAvailableEvent.b)));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = this.b;
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.c;
    return String.format(localLocale, "ChangesAvailableEvent [changesAvailableOptions=%s]", arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.ChangesAvailableEvent
 * JD-Core Version:    0.6.0
 */