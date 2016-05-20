package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class d
  implements Parcelable.Creator
{
  static void a(FileUploadPreferencesImpl paramFileUploadPreferencesImpl, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramFileUploadPreferencesImpl.a);
    j.a(paramParcel, 2, paramFileUploadPreferencesImpl.b);
    j.a(paramParcel, 3, paramFileUploadPreferencesImpl.c);
    j.a(paramParcel, 4, paramFileUploadPreferencesImpl.d);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.d
 * JD-Core Version:    0.6.0
 */