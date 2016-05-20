package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class b
  implements Parcelable.Creator
{
  static void a(ChangesAvailableEvent paramChangesAvailableEvent, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramChangesAvailableEvent.a);
    j.a(paramParcel, 2, paramChangesAvailableEvent.b, false);
    j.a(paramParcel, 3, paramChangesAvailableEvent.c, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.b
 * JD-Core Version:    0.6.0
 */