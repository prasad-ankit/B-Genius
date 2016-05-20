package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class s
{
  private static s a = new s();

  public static AdRequestParcel a(Context paramContext, b paramb)
  {
    Date localDate = paramb.a();
    long l;
    String str1;
    int i;
    List localList;
    label56: boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    com.google.android.gms.ads.e.a locala;
    if (localDate != null)
    {
      l = localDate.getTime();
      str1 = paramb.b();
      i = paramb.c();
      Set localSet = paramb.d();
      if (localSet.isEmpty())
        break label228;
      localList = Collections.unmodifiableList(new ArrayList(localSet));
      bool1 = paramb.a(paramContext);
      j = paramb.l();
      localLocation = paramb.e();
      localBundle = paramb.a(AdMobAdapter.class);
      bool2 = paramb.f();
      str2 = paramb.g();
      locala = paramb.i();
      if (locala == null)
        break label234;
    }
    label228: label234: for (SearchAdRequestParcel localSearchAdRequestParcel = new SearchAdRequestParcel(locala); ; localSearchAdRequestParcel = null)
    {
      Context localContext = paramContext.getApplicationContext();
      String str3 = null;
      if (localContext != null)
      {
        String str4 = localContext.getPackageName();
        str3 = x.a().a(Thread.currentThread().getStackTrace(), str4);
      }
      boolean bool3 = paramb.o();
      return new AdRequestParcel(7, l, localBundle, i, localList, bool1, j, bool2, str2, localSearchAdRequestParcel, localLocation, str1, paramb.k(), paramb.m(), Collections.unmodifiableList(new ArrayList(paramb.n())), paramb.h(), str3, bool3);
      l = -1L;
      break;
      localList = null;
      break label56;
    }
  }

  public static s a()
  {
    return a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.s
 * JD-Core Version:    0.6.0
 */