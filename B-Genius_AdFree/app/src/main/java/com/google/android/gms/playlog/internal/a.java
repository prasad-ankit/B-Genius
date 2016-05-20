package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(PlayLoggerContext paramPlayLoggerContext, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramPlayLoggerContext.a);
    j.a(paramParcel, 2, paramPlayLoggerContext.b, false);
    j.a(paramParcel, 3, paramPlayLoggerContext.c);
    j.a(paramParcel, 4, paramPlayLoggerContext.d);
    j.a(paramParcel, 5, paramPlayLoggerContext.e, false);
    j.a(paramParcel, 6, paramPlayLoggerContext.f, false);
    j.a(paramParcel, 7, paramPlayLoggerContext.g);
    j.a(paramParcel, 8, paramPlayLoggerContext.h, false);
    j.a(paramParcel, 9, paramPlayLoggerContext.i);
    j.a(paramParcel, 10, paramPlayLoggerContext.j);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.playlog.internal.a
 * JD-Core Version:    0.6.0
 */