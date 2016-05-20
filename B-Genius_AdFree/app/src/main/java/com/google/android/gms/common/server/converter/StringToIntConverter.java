package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class StringToIntConverter
  implements SafeParcelable, a
{
  public static final b CREATOR = new b();
  private final int a;
  private final HashMap b;
  private final HashMap c;

  public StringToIntConverter()
  {
    this.a = 1;
    this.b = new HashMap();
    this.c = new HashMap();
  }

  StringToIntConverter(int paramInt, ArrayList paramArrayList)
  {
    this.a = paramInt;
    this.b = new HashMap();
    this.c = new HashMap();
    a(paramArrayList);
  }

  private void a(ArrayList paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      StringToIntConverter.Entry localEntry = (StringToIntConverter.Entry)localIterator.next();
      a(localEntry.b, localEntry.c);
    }
  }

  final int a()
  {
    return this.a;
  }

  public final StringToIntConverter a(String paramString, int paramInt)
  {
    this.b.put(paramString, Integer.valueOf(paramInt));
    this.c.put(Integer.valueOf(paramInt), paramString);
    return this;
  }

  final ArrayList b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new StringToIntConverter.Entry(str, ((Integer)this.b.get(str)).intValue()));
    }
    return localArrayList;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverter
 * JD-Core Version:    0.6.0
 */