package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class c
  implements Parcelable.Creator
{
  static void a(ChangesAvailableOptions paramChangesAvailableOptions, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramChangesAvailableOptions.a);
    j.a(paramParcel, 2, paramChangesAvailableOptions.b);
    j.a(paramParcel, 3, paramChangesAvailableOptions.c);
    j.b(paramParcel, 4, paramChangesAvailableOptions.d, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.c
 * JD-Core Version:    0.6.0
 */