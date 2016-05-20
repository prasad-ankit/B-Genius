package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class d
  implements Parcelable.Creator
{
  static void a(FieldMappingDictionary paramFieldMappingDictionary, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramFieldMappingDictionary.a());
    j.b(paramParcel, 2, paramFieldMappingDictionary.b(), false);
    j.a(paramParcel, 3, paramFieldMappingDictionary.c(), false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.d
 * JD-Core Version:    0.6.0
 */