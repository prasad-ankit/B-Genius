package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class e
  implements Parcelable.Creator
{
  static void a(QueryResultEventParcelable paramQueryResultEventParcelable, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramQueryResultEventParcelable.a);
    j.a(paramParcel, 2, paramQueryResultEventParcelable.b, paramInt, false);
    j.a(paramParcel, 3, paramQueryResultEventParcelable.c);
    j.a(paramParcel, 4, paramQueryResultEventParcelable.d);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.e
 * JD-Core Version:    0.6.0
 */