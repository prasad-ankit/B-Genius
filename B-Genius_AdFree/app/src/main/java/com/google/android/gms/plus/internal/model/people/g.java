package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import java.util.Set;

public final class g
  implements Parcelable.Creator
{
  static void a(PersonEntity.NameEntity paramNameEntity, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    Set localSet = paramNameEntity.a;
    if (localSet.contains(Integer.valueOf(1)))
      j.a(paramParcel, 1, paramNameEntity.b);
    if (localSet.contains(Integer.valueOf(2)))
      j.a(paramParcel, 2, paramNameEntity.c, true);
    if (localSet.contains(Integer.valueOf(3)))
      j.a(paramParcel, 3, paramNameEntity.d, true);
    if (localSet.contains(Integer.valueOf(4)))
      j.a(paramParcel, 4, paramNameEntity.e, true);
    if (localSet.contains(Integer.valueOf(5)))
      j.a(paramParcel, 5, paramNameEntity.f, true);
    if (localSet.contains(Integer.valueOf(6)))
      j.a(paramParcel, 6, paramNameEntity.g, true);
    if (localSet.contains(Integer.valueOf(7)))
      j.a(paramParcel, 7, paramNameEntity.h, true);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.g
 * JD-Core Version:    0.6.0
 */