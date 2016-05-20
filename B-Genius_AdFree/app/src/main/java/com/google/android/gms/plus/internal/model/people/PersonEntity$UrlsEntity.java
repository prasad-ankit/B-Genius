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

public final class PersonEntity$UrlsEntity extends FastSafeParcelableJsonResponse
  implements c
{
  public static final j CREATOR = new j();
  private static final HashMap f;
  final Set a;
  final int b;
  String c;
  int d;
  String e;

  static
  {
    HashMap localHashMap = new HashMap();
    f = localHashMap;
    localHashMap.put("label", FastJsonResponse.Field.c("label", 5));
    f.put("type", FastJsonResponse.Field.a("type", 6, new StringToIntConverter().a("home", 0).a("work", 1).a("blog", 2).a("profile", 3).a("other", 4).a("otherProfile", 5).a("contributor", 6).a("website", 7), false));
    f.put("value", FastJsonResponse.Field.c("value", 4));
  }

  public PersonEntity$UrlsEntity()
  {
    this.b = 1;
    this.a = new HashSet();
  }

  PersonEntity$UrlsEntity(Set paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.a = paramSet;
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramInt2;
    this.e = paramString2;
  }

  public static int e()
  {
    return 4;
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
    case 5:
      return this.c;
    case 6:
      return Integer.valueOf(this.d);
    case 4:
    }
    return this.e;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof UrlsEntity))
      return false;
    if (this == paramObject)
      return true;
    UrlsEntity localUrlsEntity = (UrlsEntity)paramObject;
    Iterator localIterator = f.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (localUrlsEntity.a(localField))
          if (!b(localField).equals(localUrlsEntity.b(localField)))
            return false;
        return false;
      }
      if (localUrlsEntity.a(localField))
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
    j.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.PersonEntity.UrlsEntity
 * JD-Core Version:    0.6.0
 */