package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.support.v4.a.c;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class PersonEntity$OrganizationsEntity extends FastSafeParcelableJsonResponse
  implements c
{
  public static final h CREATOR = new h();
  private static final HashMap l;
  final Set a;
  final int b;
  String c;
  String d;
  String e;
  String f;
  String g;
  boolean h;
  String i;
  String j;
  int k;

  static
  {
    HashMap localHashMap = new HashMap();
    l = localHashMap;
    localHashMap.put("department", FastJsonResponse.Field.c("department", 2));
    l.put("description", FastJsonResponse.Field.c("description", 3));
    l.put("endDate", FastJsonResponse.Field.c("endDate", 4));
    l.put("location", FastJsonResponse.Field.c("location", 5));
    l.put("name", FastJsonResponse.Field.c("name", 6));
    l.put("primary", FastJsonResponse.Field.b("primary", 7));
    l.put("startDate", FastJsonResponse.Field.c("startDate", 8));
    l.put("title", FastJsonResponse.Field.c("title", 9));
    l.put("type", FastJsonResponse.Field.a("type", 10, new StringToIntConverter().a("work", 0).a("school", 1), false));
  }

  public PersonEntity$OrganizationsEntity()
  {
    this.b = 1;
    this.a = new HashSet();
  }

  PersonEntity$OrganizationsEntity(Set paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
  {
    this.a = paramSet;
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
    this.h = paramBoolean;
    this.i = paramString6;
    this.j = paramString7;
    this.k = paramInt2;
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
      return Boolean.valueOf(this.h);
    case 8:
      return this.i;
    case 9:
      return this.j;
    case 10:
    }
    return Integer.valueOf(this.k);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof OrganizationsEntity))
      return false;
    if (this == paramObject)
      return true;
    OrganizationsEntity localOrganizationsEntity = (OrganizationsEntity)paramObject;
    Iterator localIterator = l.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (localOrganizationsEntity.a(localField))
          if (!b(localField).equals(localOrganizationsEntity.b(localField)))
            return false;
        return false;
      }
      if (localOrganizationsEntity.a(localField))
        return false;
    }
    return true;
  }

  public final int hashCode()
  {
    Iterator localIterator = l.values().iterator();
    int m = 0;
    FastJsonResponse.Field localField;
    if (localIterator.hasNext())
    {
      localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField))
        break label66;
    }
    label66: for (int n = m + localField.g() + b(localField).hashCode(); ; n = m)
    {
      m = n;
      break;
      return m;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.PersonEntity.OrganizationsEntity
 * JD-Core Version:    0.6.0
 */