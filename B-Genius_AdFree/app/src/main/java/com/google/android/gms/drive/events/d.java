package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class d
  implements Parcelable.Creator
{
  static void a(CompletionEvent paramCompletionEvent, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramCompletionEvent.a);
    j.a(paramParcel, 2, paramCompletionEvent.b, paramInt, false);
    j.a(paramParcel, 3, paramCompletionEvent.c, false);
    j.a(paramParcel, 4, paramCompletionEvent.d, paramInt, false);
    j.a(paramParcel, 5, paramCompletionEvent.e, paramInt, false);
    j.a(paramParcel, 6, paramCompletionEvent.f, paramInt, false);
    j.a(paramParcel, 7, paramCompletionEvent.g, false);
    j.a(paramParcel, 8, paramCompletionEvent.h);
    j.a(paramParcel, 9, paramCompletionEvent.i, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.d
 * JD-Core Version:    0.6.0
 */