package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.support.v4.a.c;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class PersonEntity$CoverEntity$CoverPhotoEntity extends FastSafeParcelableJsonResponse
  implements c
{
  public static final e CREATOR = new e();
  private static final HashMap f;
  final Set a;
  final int b;
  int c;
  String d;
  int e;

  static
  {
    HashMap localHashMap = new HashMap();
    f = localHashMap;
    localHashMap.put("height", FastJsonResponse.Field.a("height", 2));
    f.put("url", FastJsonResponse.Field.c("url", 3));
    f.put("width", FastJsonResponse.Field.a("width", 4));
  }

  public PersonEntity$CoverEntity$CoverPhotoEntity()
  {
    this.b = 1;
    this.a = new HashSet();
  }

  PersonEntity$CoverEntity$CoverPhotoEntity(Set paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.a = paramSet;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString;
    this.e = paramInt3;
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
      return Integer.valueOf(this.c);
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
    if (!(paramObject instanceof CoverPhotoEntity))
      return false;
    if (this == paramObject)
      return true;
    CoverPhotoEntity localCoverPhotoEntity = (CoverPhotoEntity)paramObject;
    Iterator localIterator = f.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (localCoverPhotoEntity.a(localField))
          if (!b(localField).equals(localCoverPhotoEntity.b(localField)))
            return false;
        return false;
      }
      if (localCoverPhotoEntity.a(localField))
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
    e.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverPhotoEntity
 * JD-Core Version:    0.6.0
 */