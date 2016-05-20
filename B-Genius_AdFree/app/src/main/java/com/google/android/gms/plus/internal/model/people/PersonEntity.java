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
import java.util.List;
import java.util.Set;

public final class PersonEntity extends FastSafeParcelableJsonResponse
  implements c
{
  private static final HashMap A;
  public static final a CREATOR = new a();
  final Set a;
  final int b;
  String c;
  PersonEntity.AgeRangeEntity d;
  String e;
  String f;
  int g;
  PersonEntity.CoverEntity h;
  String i;
  String j;
  int k;
  String l;
  PersonEntity.ImageEntity m;
  boolean n;
  String o;
  PersonEntity.NameEntity p;
  String q;
  int r;
  List s;
  List t;
  int u;
  int v;
  String w;
  String x;
  List y;
  boolean z;

  static
  {
    HashMap localHashMap = new HashMap();
    A = localHashMap;
    localHashMap.put("aboutMe", FastJsonResponse.Field.c("aboutMe", 2));
    A.put("ageRange", FastJsonResponse.Field.a("ageRange", 3, PersonEntity.AgeRangeEntity.class));
    A.put("birthday", FastJsonResponse.Field.c("birthday", 4));
    A.put("braggingRights", FastJsonResponse.Field.c("braggingRights", 5));
    A.put("circledByCount", FastJsonResponse.Field.a("circledByCount", 6));
    A.put("cover", FastJsonResponse.Field.a("cover", 7, PersonEntity.CoverEntity.class));
    A.put("currentLocation", FastJsonResponse.Field.c("currentLocation", 8));
    A.put("displayName", FastJsonResponse.Field.c("displayName", 9));
    A.put("gender", FastJsonResponse.Field.a("gender", 12, new StringToIntConverter().a("male", 0).a("female", 1).a("other", 2), false));
    A.put("id", FastJsonResponse.Field.c("id", 14));
    A.put("image", FastJsonResponse.Field.a("image", 15, PersonEntity.ImageEntity.class));
    A.put("isPlusUser", FastJsonResponse.Field.b("isPlusUser", 16));
    A.put("language", FastJsonResponse.Field.c("language", 18));
    A.put("name", FastJsonResponse.Field.a("name", 19, PersonEntity.NameEntity.class));
    A.put("nickname", FastJsonResponse.Field.c("nickname", 20));
    A.put("objectType", FastJsonResponse.Field.a("objectType", 21, new StringToIntConverter().a("person", 0).a("page", 1), false));
    A.put("organizations", FastJsonResponse.Field.b("organizations", 22, PersonEntity.OrganizationsEntity.class));
    A.put("placesLived", FastJsonResponse.Field.b("placesLived", 23, PersonEntity.PlacesLivedEntity.class));
    A.put("plusOneCount", FastJsonResponse.Field.a("plusOneCount", 24));
    A.put("relationshipStatus", FastJsonResponse.Field.a("relationshipStatus", 25, new StringToIntConverter().a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8), false));
    A.put("tagline", FastJsonResponse.Field.c("tagline", 26));
    A.put("url", FastJsonResponse.Field.c("url", 27));
    A.put("urls", FastJsonResponse.Field.b("urls", 28, PersonEntity.UrlsEntity.class));
    A.put("verified", FastJsonResponse.Field.b("verified", 29));
  }

  public PersonEntity()
  {
    this.b = 1;
    this.a = new HashSet();
  }

  PersonEntity(Set paramSet, int paramInt1, String paramString1, PersonEntity.AgeRangeEntity paramAgeRangeEntity, String paramString2, String paramString3, int paramInt2, PersonEntity.CoverEntity paramCoverEntity, String paramString4, String paramString5, int paramInt3, String paramString6, PersonEntity.ImageEntity paramImageEntity, boolean paramBoolean1, String paramString7, PersonEntity.NameEntity paramNameEntity, String paramString8, int paramInt4, List paramList1, List paramList2, int paramInt5, int paramInt6, String paramString9, String paramString10, List paramList3, boolean paramBoolean2)
  {
    this.a = paramSet;
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramAgeRangeEntity;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramInt2;
    this.h = paramCoverEntity;
    this.i = paramString4;
    this.j = paramString5;
    this.k = paramInt3;
    this.l = paramString6;
    this.m = paramImageEntity;
    this.n = paramBoolean1;
    this.o = paramString7;
    this.p = paramNameEntity;
    this.q = paramString8;
    this.r = paramInt4;
    this.s = paramList1;
    this.t = paramList2;
    this.u = paramInt5;
    this.v = paramInt6;
    this.w = paramString9;
    this.x = paramString10;
    this.y = paramList3;
    this.z = paramBoolean2;
  }

  public static PersonEntity a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    PersonEntity localPersonEntity = a.a(localParcel);
    localParcel.recycle();
    return localPersonEntity;
  }

  protected final boolean a(FastJsonResponse.Field paramField)
  {
    return this.a.contains(Integer.valueOf(paramField.g()));
  }

  protected final Object b(FastJsonResponse.Field paramField)
  {
    switch (paramField.g())
    {
    case 10:
    case 11:
    case 13:
    case 17:
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
      return Integer.valueOf(this.g);
    case 7:
      return this.h;
    case 8:
      return this.i;
    case 9:
      return this.j;
    case 12:
      return Integer.valueOf(this.k);
    case 14:
      return this.l;
    case 15:
      return this.m;
    case 16:
      return Boolean.valueOf(this.n);
    case 18:
      return this.o;
    case 19:
      return this.p;
    case 20:
      return this.q;
    case 21:
      return Integer.valueOf(this.r);
    case 22:
      return this.s;
    case 23:
      return this.t;
    case 24:
      return Integer.valueOf(this.u);
    case 25:
      return Integer.valueOf(this.v);
    case 26:
      return this.w;
    case 27:
      return this.x;
    case 28:
      return this.y;
    case 29:
    }
    return Boolean.valueOf(this.z);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PersonEntity))
      return false;
    if (this == paramObject)
      return true;
    PersonEntity localPersonEntity = (PersonEntity)paramObject;
    Iterator localIterator = A.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (localPersonEntity.a(localField))
          if (!b(localField).equals(localPersonEntity.b(localField)))
            return false;
        return false;
      }
      if (localPersonEntity.a(localField))
        return false;
    }
    return true;
  }

  public final int hashCode()
  {
    Iterator localIterator = A.values().iterator();
    int i1 = 0;
    FastJsonResponse.Field localField;
    if (localIterator.hasNext())
    {
      localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField))
        break label66;
    }
    label66: for (int i2 = i1 + localField.g() + b(localField).hashCode(); ; i2 = i1)
    {
      i1 = i2;
      break;
      return i1;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.PersonEntity
 * JD-Core Version:    0.6.0
 */