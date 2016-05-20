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

public final class PersonEntity$AgeRangeEntity extends FastSafeParcelableJsonResponse
  implements c
{
  public static final b CREATOR = new b();
  private static final HashMap e;
  final Set a;
  final int b;
  int c;
  int d;

  static
  {
    HashMap localHashMap = new HashMap();
    e = localHashMap;
    localHashMap.put("max", FastJsonResponse.Field.a("max", 2));
    e.put("min", FastJsonResponse.Field.a("min", 3));
  }

  public PersonEntity$AgeRangeEntity()
  {
    this.b = 1;
    this.a = new HashSet();
  }

  PersonEntity$AgeRangeEntity(Set paramSet, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramSet;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
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
    }
    return Integer.valueOf(this.d);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AgeRangeEntity))
      return false;
    if (this == paramObject)
      return true;
    AgeRangeEntity localAgeRangeEntity = (AgeRangeEntity)paramObject;
    Iterator localIterator = e.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (localAgeRangeEntity.a(localField))
          if (!b(localField).equals(localAgeRangeEntity.b(localField)))
            return false;
        return false;
      }
      if (localAgeRangeEntity.a(localField))
        return false;
    }
    return true;
  }

  public final int hashCode()
  {
    Iterator localIterator = e.values().iterator();
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
    b.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.PersonEntity.AgeRangeEntity
 * JD-Core Version:    0.6.0
 */