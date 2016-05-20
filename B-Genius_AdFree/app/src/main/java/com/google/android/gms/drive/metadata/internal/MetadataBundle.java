package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.aq;
import com.google.android.gms.drive.metadata.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new g();
  final int a;
  final Bundle b;

  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = ((Bundle)w.a(paramBundle));
    this.b.setClassLoader(getClass().getClassLoader());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.b.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str2 = (String)localIterator1.next();
      if (c.a(str2) != null)
        continue;
      localArrayList.add(str2);
      aq.a("MetadataBundle", "Ignored unknown metadata field in bundle: " + str2);
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      this.b.remove(str1);
    }
  }

  public final Object a(a parama)
  {
    return parama.a(this.b);
  }

  public final Set a()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
      localHashSet.add(c.a((String)localIterator.next()));
    return localHashSet;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof MetadataBundle))
      return false;
    MetadataBundle localMetadataBundle = (MetadataBundle)paramObject;
    Set localSet = this.b.keySet();
    if (!localSet.equals(localMetadataBundle.b.keySet()))
      return false;
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!f.a(this.b.get(str), localMetadataBundle.b.get(str)))
        return false;
    }
    return true;
  }

  public final int hashCode()
  {
    Iterator localIterator = this.b.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = i * 31 + this.b.get(str).hashCode())
      str = (String)localIterator.next();
    return i;
  }

  public final String toString()
  {
    return "MetadataBundle [values=" + this.b + "]";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.MetadataBundle
 * JD-Core Version:    0.6.0
 */