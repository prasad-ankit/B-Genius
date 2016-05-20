package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(ChangeEvent paramChangeEvent, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramChangeEvent.a);
    j.a(paramParcel, 2, paramChangeEvent.b, paramInt, false);
    j.a(paramParcel, 3, paramChangeEvent.c);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.a
 * JD-Core Version:    0.6.0
 */