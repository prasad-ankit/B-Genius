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

public final class PersonEntity$NameEntity extends FastSafeParcelableJsonResponse
  implements c
{
  public static final g CREATOR = new g();
  private static final HashMap i;
  final Set a;
  final int b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;

  static
  {
    HashMap localHashMap = new HashMap();
    i = localHashMap;
    localHashMap.put("familyName", FastJsonResponse.Field.c("familyName", 2));
    i.put("formatted", FastJsonResponse.Field.c("formatted", 3));
    i.put("givenName", FastJsonResponse.Field.c("givenName", 4));
    i.put("honorificPrefix", FastJsonResponse.Field.c("honorificPrefix", 5));
    i.put("honorificSuffix", FastJsonResponse.Field.c("honorificSuffix", 6));
    i.put("middleName", FastJsonResponse.Field.c("middleName", 7));
  }

  public PersonEntity$NameEntity()
  {
    this.b = 1;
    this.a = new HashSet();
  }

  PersonEntity$NameEntity(Set paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.a = paramSet;
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
    this.h = paramString6;
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
      return this.e;
    case 5:
      return this.f;
    case 6:
      return this.g;
    case 7:
    }
    return this.h;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NameEntity))
      return false;
    if (this == paramObject)
      return true;
    NameEntity localNameEntity = (NameEntity)paramObject;
    Iterator localIterator = i.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (localNameEntity.a(localField))
          if (!b(localField).equals(localNameEntity.b(localField)))
            return false;
        return false;
      }
      if (localNameEntity.a(localField))
        return false;
    }
    return true;
  }

  public final int hashCode()
  {
    Iterator localIterator = i.values().iterator();
    int j = 0;
    FastJsonResponse.Field localField;
    if (localIterator.hasNext())
    {
      localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField))
        break label66;
    }
    label66: for (int k = j + localField.g() + b(localField).hashCode(); ; k = j)
    {
      j = k;
      break;
      return j;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.PersonEntity.NameEntity
 * JD-Core Version:    0.6.0
 */