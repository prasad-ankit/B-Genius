package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Set;

public final class j
  implements Parcelable.Creator
{
  static void a(PersonEntity.UrlsEntity paramUrlsEntity, Parcel paramParcel)
  {
    int i = android.support.v4.app.j.b(paramParcel);
    Set localSet = paramUrlsEntity.a;
    if (localSet.contains(Integer.valueOf(1)))
      android.support.v4.app.j.a(paramParcel, 1, paramUrlsEntity.b);
    if (localSet.contains(Integer.valueOf(3)))
      android.support.v4.app.j.a(paramParcel, 3, PersonEntity.UrlsEntity.e());
    if (localSet.contains(Integer.valueOf(4)))
      android.support.v4.app.j.a(paramParcel, 4, paramUrlsEntity.e, true);
    if (localSet.contains(Integer.valueOf(5)))
      android.support.v4.app.j.a(paramParcel, 5, paramUrlsEntity.c, true);
    if (localSet.contains(Integer.valueOf(6)))
      android.support.v4.app.j.a(paramParcel, 6, paramUrlsEntity.d);
    android.support.v4.app.j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.j
 * JD-Core Version:    0.6.0
 */