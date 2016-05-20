package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import java.util.Set;

public final class h
  implements Parcelable.Creator
{
  static void a(PersonEntity.OrganizationsEntity paramOrganizationsEntity, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    Set localSet = paramOrganizationsEntity.a;
    if (localSet.contains(Integer.valueOf(1)))
      j.a(paramParcel, 1, paramOrganizationsEntity.b);
    if (localSet.contains(Integer.valueOf(2)))
      j.a(paramParcel, 2, paramOrganizationsEntity.c, true);
    if (localSet.contains(Integer.valueOf(3)))
      j.a(paramParcel, 3, paramOrganizationsEntity.d, true);
    if (localSet.contains(Integer.valueOf(4)))
      j.a(paramParcel, 4, paramOrganizationsEntity.e, true);
    if (localSet.contains(Integer.valueOf(5)))
      j.a(paramParcel, 5, paramOrganizationsEntity.f, true);
    if (localSet.contains(Integer.valueOf(6)))
      j.a(paramParcel, 6, paramOrganizationsEntity.g, true);
    if (localSet.contains(Integer.valueOf(7)))
      j.a(paramParcel, 7, paramOrganizationsEntity.h);
    if (localSet.contains(Integer.valueOf(8)))
      j.a(paramParcel, 8, paramOrganizationsEntity.i, true);
    if (localSet.contains(Integer.valueOf(9)))
      j.a(paramParcel, 9, paramOrganizationsEntity.j, true);
    if (localSet.contains(Integer.valueOf(10)))
      j.a(paramParcel, 10, paramOrganizationsEntity.k);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.h
 * JD-Core Version:    0.6.0
 */