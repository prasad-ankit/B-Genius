package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import java.util.Set;

public final class e
  implements Parcelable.Creator
{
  static void a(PersonEntity.CoverEntity.CoverPhotoEntity paramCoverPhotoEntity, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    Set localSet = paramCoverPhotoEntity.a;
    if (localSet.contains(Integer.valueOf(1)))
      j.a(paramParcel, 1, paramCoverPhotoEntity.b);
    if (localSet.contains(Integer.valueOf(2)))
      j.a(paramParcel, 2, paramCoverPhotoEntity.c);
    if (localSet.contains(Integer.valueOf(3)))
      j.a(paramParcel, 3, paramCoverPhotoEntity.d, true);
    if (localSet.contains(Integer.valueOf(4)))
      j.a(paramParcel, 4, paramCoverPhotoEntity.e);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.e
 * JD-Core Version:    0.6.0
 */