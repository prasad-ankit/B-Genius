package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import java.util.Set;

public final class b
  implements Parcelable.Creator
{
  static void a(PersonEntity.AgeRangeEntity paramAgeRangeEntity, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    Set localSet = paramAgeRangeEntity.a;
    if (localSet.contains(Integer.valueOf(1)))
      j.a(paramParcel, 1, paramAgeRangeEntity.b);
    if (localSet.contains(Integer.valueOf(2)))
      j.a(paramParcel, 2, paramAgeRangeEntity.c);
    if (localSet.contains(Integer.valueOf(3)))
      j.a(paramParcel, 3, paramAgeRangeEntity.d);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.b
 * JD-Core Version:    0.6.0
 */