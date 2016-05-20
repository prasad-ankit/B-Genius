package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import java.util.Set;

public final class i
  implements Parcelable.Creator
{
  static void a(PersonEntity.PlacesLivedEntity paramPlacesLivedEntity, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    Set localSet = paramPlacesLivedEntity.a;
    if (localSet.contains(Integer.valueOf(1)))
      j.a(paramParcel, 1, paramPlacesLivedEntity.b);
    if (localSet.contains(Integer.valueOf(2)))
      j.a(paramParcel, 2, paramPlacesLivedEntity.c);
    if (localSet.contains(Integer.valueOf(3)))
      j.a(paramParcel, 3, paramPlacesLivedEntity.d, true);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.i
 * JD-Core Version:    0.6.0
 */