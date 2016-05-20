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

public final class PersonEntity$PlacesLivedEntity extends FastSafeParcelableJsonResponse
  implements c
{
  public static final i CREATOR = new i();
  private static final HashMap e;
  final Set a;
  final int b;
  boolean c;
  String d;

  static
  {
    HashMap localHashMap = new HashMap();
    e = localHashMap;
    localHashMap.put("primary", FastJsonResponse.Field.b("primary", 2));
    e.put("value", FastJsonResponse.Field.c("value", 3));
  }

  public PersonEntity$PlacesLivedEntity()
  {
    this.b = 1;
    this.a = new HashSet();
  }

  PersonEntity$PlacesLivedEntity(Set paramSet, int paramInt, boolean paramBoolean, String paramString)
  {
    this.a = paramSet;
    this.b = paramInt;
    this.c = paramBoolean;
    this.d = paramString;
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
      return Boolean.valueOf(this.c);
    case 3:
    }
    return this.d;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlacesLivedEntity))
      return false;
    if (this == paramObject)
      return true;
    PlacesLivedEntity localPlacesLivedEntity = (PlacesLivedEntity)paramObject;
    Iterator localIterator = e.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (localPlacesLivedEntity.a(localField))
          if (!b(localField).equals(localPlacesLivedEntity.b(localField)))
            return false;
        return false;
      }
      if (localPlacesLivedEntity.a(localField))
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
    i.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.PersonEntity.PlacesLivedEntity
 * JD-Core Version:    0.6.0
 */