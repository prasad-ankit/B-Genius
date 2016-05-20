package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class e
  implements Parcelable.Creator
{
  static void a(FieldMappingDictionary.Entry paramEntry, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramEntry.a);
    j.a(paramParcel, 2, paramEntry.b, false);
    j.b(paramParcel, 3, paramEntry.c, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.e
 * JD-Core Version:    0.6.0
 */