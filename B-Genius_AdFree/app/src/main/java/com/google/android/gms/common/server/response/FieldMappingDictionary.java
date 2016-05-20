package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FieldMappingDictionary
  implements SafeParcelable
{
  public static final d CREATOR = new d();
  private final int a;
  private final HashMap b;
  private final String c;

  FieldMappingDictionary(int paramInt, ArrayList paramArrayList, String paramString)
  {
    this.a = paramInt;
    this.b = a(paramArrayList);
    this.c = ((String)w.a(paramString));
    d();
  }

  private static HashMap a(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
    {
      FieldMappingDictionary.Entry localEntry = (FieldMappingDictionary.Entry)paramArrayList.get(j);
      localHashMap.put(localEntry.b, localEntry.a());
    }
    return localHashMap;
  }

  private void d()
  {
    Iterator localIterator1 = this.b.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Map localMap = (Map)this.b.get(str);
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
        ((FastJsonResponse.Field)localMap.get((String)localIterator2.next())).a(this);
    }
  }

  final int a()
  {
    return this.a;
  }

  public final Map a(String paramString)
  {
    return (Map)this.b.get(paramString);
  }

  final ArrayList b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new FieldMappingDictionary.Entry(str, (Map)this.b.get(str)));
    }
    return localArrayList;
  }

  public final String c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.b.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      localStringBuilder.append(str1).append(":\n");
      Map localMap = (Map)this.b.get(str1);
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str2).append(": ");
        localStringBuilder.append(localMap.get(str2));
      }
    }
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary
 * JD-Core Version:    0.6.0
 */