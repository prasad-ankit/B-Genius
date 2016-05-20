package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class PersonEntity$CoverEntity extends FastSafeParcelableJsonResponse
  implements android.support.v4.a.c
{
  public static final c CREATOR = new c();
  private static final HashMap f;
  final Set a;
  final int b;
  PersonEntity.CoverEntity.CoverInfoEntity c;
  PersonEntity.CoverEntity.CoverPhotoEntity d;
  int e;

  static
  {
    HashMap localHashMap = new HashMap();
    f = localHashMap;
    localHashMap.put("coverInfo", FastJsonResponse.Field.a("coverInfo", 2, PersonEntity.CoverEntity.CoverInfoEntity.class));
    f.put("coverPhoto", FastJsonResponse.Field.a("coverPhoto", 3, PersonEntity.CoverEntity.CoverPhotoEntity.class));
    f.put("layout", FastJsonResponse.Field.a("layout", 4, new StringToIntConverter().a("banner", 0), false));
  }

  public PersonEntity$CoverEntity()
  {
    this.b = 1;
    this.a = new HashSet();
  }

  PersonEntity$CoverEntity(Set paramSet, int paramInt1, PersonEntity.CoverEntity.CoverInfoEntity paramCoverInfoEntity, PersonEntity.CoverEntity.CoverPhotoEntity paramCoverPhotoEntity, int paramInt2)
  {
    this.a = paramSet;
    this.b = paramInt1;
    this.c = paramCoverInfoEntity;
    this.d = paramCoverPhotoEntity;
    this.e = paramInt2;
  }

  protected final boolean a(FastJsonResponse.Field paramField)
  {
    return this.a.contains(Integer.valueOf(paramField.g()));
  }

  protected final Object b(FastJsonResponse.Field paramField)
  {
    switch (paramField.g())
    {
    default:
      throw new IllegalStateException("Unknown safe parcelable id=" + paramField.g());
    case 2:
      return this.c;
    case 3:
      return this.d;
    case 4:
    }
    return Integer.valueOf(this.e);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CoverEntity))
      return false;
    if (this == paramObject)
      return true;
    CoverEntity localCoverEntity = (CoverEntity)paramObject;
    Iterator localIterator = f.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (localCoverEntity.a(localField))
          if (!b(localField).equals(localCoverEntity.b(localField)))
            return false;
        return false;
      }
      if (localCoverEntity.a(localField))
        return false;
    }
    return true;
  }

  public final int hashCode()
  {
    Iterator localIterator = f.values().iterator();
    int i = 0;
    FastJsonResponse.Field localField;
    if (localIterator.hasNext())
    {
      localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField))
        break label66;
    }
    label66: for (int j = i + localField.g() + b(localField).hashCode(); ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity
 * JD-Core Version:    0.6.0
 */