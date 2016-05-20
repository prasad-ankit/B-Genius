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

public final class PersonEntity$ImageEntity extends FastSafeParcelableJsonResponse
  implements c
{
  public static final f CREATOR = new f();
  private static final HashMap d;
  final Set a;
  final int b;
  String c;

  static
  {
    HashMap localHashMap = new HashMap();
    d = localHashMap;
    localHashMap.put("url", FastJsonResponse.Field.c("url", 2));
  }

  public PersonEntity$ImageEntity()
  {
    this.b = 1;
    this.a = new HashSet();
  }

  PersonEntity$ImageEntity(Set paramSet, int paramInt, String paramString)
  {
    this.a = paramSet;
    this.b = paramInt;
    this.c = paramString;
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
    }
    return this.c;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageEntity))
      return false;
    if (this == paramObject)
      return true;
    ImageEntity localImageEntity = (ImageEntity)paramObject;
    Iterator localIterator = d.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (localImageEntity.a(localField))
          if (!b(localField).equals(localImageEntity.b(localField)))
            return false;
        return false;
      }
      if (localImageEntity.a(localField))
        return false;
    }
    return true;
  }

  public final int hashCode()
  {
    Iterator localIterator = d.values().iterator();
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
    f.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.PersonEntity.ImageEntity
 * JD-Core Version:    0.6.0
 */