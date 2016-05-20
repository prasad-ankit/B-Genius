package com.google.android.gms.b;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class da
{
  private final Object[] a;
  private boolean b;

  da(AdRequestParcel paramAdRequestParcel, String paramString, int paramInt)
  {
    au localau = aD.N;
    HashSet localHashSet = new HashSet(Arrays.asList(((String)P.n().a(localau)).split(",")));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    if (localHashSet.contains("networkType"))
      localArrayList.add(Integer.valueOf(paramInt));
    if (localHashSet.contains("birthday"))
      localArrayList.add(Long.valueOf(paramAdRequestParcel.b));
    if (localHashSet.contains("extras"))
      localArrayList.add(a(paramAdRequestParcel.c));
    if (localHashSet.contains("gender"))
      localArrayList.add(Integer.valueOf(paramAdRequestParcel.d));
    if (localHashSet.contains("keywords"))
    {
      if (paramAdRequestParcel.e != null)
        localArrayList.add(paramAdRequestParcel.e.toString());
    }
    else
    {
      if (localHashSet.contains("isTestDevice"))
        localArrayList.add(Boolean.valueOf(paramAdRequestParcel.f));
      if (localHashSet.contains("tagForChildDirectedTreatment"))
        localArrayList.add(Integer.valueOf(paramAdRequestParcel.g));
      if (localHashSet.contains("manualImpressionsEnabled"))
        localArrayList.add(Boolean.valueOf(paramAdRequestParcel.h));
      if (localHashSet.contains("publisherProvidedId"))
        localArrayList.add(paramAdRequestParcel.i);
      if (localHashSet.contains("location"))
      {
        if (paramAdRequestParcel.k == null)
          break label479;
        localArrayList.add(paramAdRequestParcel.k.toString());
      }
      label311: if (localHashSet.contains("contentUrl"))
        localArrayList.add(paramAdRequestParcel.l);
      if (localHashSet.contains("networkExtras"))
        localArrayList.add(a(paramAdRequestParcel.m));
      if (localHashSet.contains("customTargeting"))
        localArrayList.add(a(paramAdRequestParcel.n));
      if (localHashSet.contains("categoryExclusions"))
      {
        if (paramAdRequestParcel.o == null)
          break label489;
        localArrayList.add(paramAdRequestParcel.o.toString());
      }
    }
    while (true)
    {
      if (localHashSet.contains("requestAgent"))
        localArrayList.add(paramAdRequestParcel.p);
      if (localHashSet.contains("requestPackage"))
        localArrayList.add(paramAdRequestParcel.q);
      this.a = localArrayList.toArray();
      return;
      localArrayList.add(null);
      break;
      label479: localArrayList.add(null);
      break label311;
      label489: localArrayList.add(null);
    }
  }

  private static String a(Bundle paramBundle)
  {
    if (paramBundle == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    Collections.sort(new ArrayList(paramBundle.keySet()));
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = paramBundle.get((String)localIterator.next());
      String str;
      if (localObject == null)
        str = "null";
      while (true)
      {
        localStringBuilder.append(str);
        break;
        if ((localObject instanceof Bundle))
        {
          str = a((Bundle)localObject);
          continue;
        }
        str = localObject.toString();
      }
    }
    return localStringBuilder.toString();
  }

  final void a()
  {
    this.b = true;
  }

  final boolean b()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof da))
      return false;
    da localda = (da)paramObject;
    return Arrays.equals(this.a, localda.a);
  }

  public final int hashCode()
  {
    return Arrays.hashCode(this.a);
  }

  public final String toString()
  {
    return "[InterstitialAdPoolKey " + Arrays.toString(this.a) + "]";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.da
 * JD-Core Version:    0.6.0
 */