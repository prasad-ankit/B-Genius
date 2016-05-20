package com.google.android.gms.b;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.H;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.b;
import com.google.android.gms.ads.internal.formats.e;
import com.google.android.gms.ads.internal.formats.g;
import com.google.android.gms.ads.internal.formats.h;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gb
  implements Callable
{
  private static final long a = TimeUnit.SECONDS.toMillis(60L);
  private final Context b;
  private final hN c;
  private final H d;
  private final y e;
  private final dj f;
  private final Object g = new Object();
  private final gT h;
  private boolean i;
  private int j;
  private List k;
  private JSONObject l;

  public gb(Context paramContext, H paramH, dj paramdj, hN paramhN, y paramy, gT paramgT)
  {
    this.b = paramContext;
    this.d = paramH;
    this.c = paramhN;
    this.f = paramdj;
    this.h = paramgT;
    this.e = paramy;
    this.i = false;
    this.j = -2;
    this.k = null;
  }

  private gS a(h paramh)
  {
    while (true)
    {
      synchronized (this.g)
      {
        int m = this.j;
        if ((paramh != null) || (this.j != -2))
          continue;
        m = 0;
        if (m != -2)
        {
          localh = null;
          return new gS(this.h.a.c, null, this.h.b.d, m, this.h.b.f, this.k, this.h.b.l, this.h.b.k, this.h.a.i, false, null, null, null, null, null, 0L, this.h.d, this.h.b.g, this.h.f, this.h.g, this.h.b.o, this.l, localh, null, null, null, this.h.b.G);
        }
      }
      h localh = paramh;
    }
  }

  private ih a(JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1);
    double d1;
    for (String str = paramJSONObject.getString("url"); ; str = paramJSONObject.optString("url"))
    {
      d1 = paramJSONObject.optDouble("scale", 1.0D);
      if (!TextUtils.isEmpty(str))
        break;
      a(0, paramBoolean1);
      return new id(null);
    }
    if (paramBoolean2)
      return new id(new b(null, Uri.parse(str), d1));
    return this.c.a(str, new gg(this, paramBoolean1, d1, str));
  }

  private static Integer a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
      Integer localInteger = Integer.valueOf(Color.rgb(localJSONObject.getInt("r"), localJSONObject.getInt("g"), localJSONObject.getInt("b")));
      return localInteger;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private gS b()
  {
    while (true)
    {
      try
      {
        if (!a())
          continue;
        localObject1 = null;
        if (!a())
          continue;
        localJSONObject1 = null;
        if (!a())
        {
          String str1 = localJSONObject1.getString("template_id");
          if (this.h.a.z == null)
            continue;
          bool1 = this.h.a.z.b;
          if (this.h.a.z == null)
            continue;
          bool2 = this.h.a.z.d;
          if (!"2".equals(str1))
            continue;
          localObject2 = new gj(bool1, bool2);
          if (!a())
            continue;
          localObject3 = null;
          if (!(localObject3 instanceof e))
            continue;
          e locale = (e)localObject3;
          gi localgi1 = new gi(this);
          ge localge = new ge(this, locale);
          localgi1.a = localge;
          localObject1.a("/nativeAdCustomClick", localge);
          return a((h)localObject3);
          au localau = aD.L;
          String str3 = (String)P.n().a(localau);
          if (this.h.b.b.indexOf("https") != 0)
            continue;
          str4 = "https:";
          String str5 = str4 + str3;
          dj localdj = this.f;
          Context localContext = this.b;
          VersionInfoParcel localVersionInfoParcel = this.h.a.k;
          y localy = this.e;
          dm localdm = new dm(0);
          hu.a.post(new dk(localdj, localContext, localVersionInfoParcel, localdm, localy, str5));
          dh localdh = (dh)localdm.get(a, TimeUnit.MILLISECONDS);
          localdh.a(this.d, this.d, this.d, this.d, false, null, null, null);
          localObject1 = localdh;
          continue;
          ic localic2 = new ic();
          gi localgi2 = new gi(this);
          gc localgc = new gc(this, localObject1, localgi2, localic2);
          localgi2.a = localgc;
          localObject1.a("/nativeAdPreProcess", localgc);
          localObject1.a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.h.b.c));
          localJSONObject1 = (JSONObject)localic2.get(a, TimeUnit.MILLISECONDS);
          continue;
          if (!"1".equals(str1))
            continue;
          localObject2 = new gk(bool1, bool2);
          continue;
          if (!"3".equals(str1))
            continue;
          String str2 = localJSONObject1.getString("custom_template_id");
          ic localic1 = new ic();
          hu.a.post(new gd(this, localic1, str2));
          if (localic1.get(a, TimeUnit.MILLISECONDS) == null)
            continue;
          localObject2 = new gl(bool1);
          continue;
          hc.b("No handler for custom template: " + localJSONObject1.getString("custom_template_id"));
          break label820;
          a(0);
        }
      }
      catch (CancellationException localCancellationException)
      {
        Object localObject1;
        JSONObject localJSONObject1;
        if (this.i)
          continue;
        a(0);
        return a(null);
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("tracking_urls_and_actions");
        String[] arrayOfString = b(localJSONObject2, "impression_tracking_urls");
        if (arrayOfString != null)
          continue;
        List localList = null;
        this.k = localList;
        this.l = localJSONObject2.optJSONObject("active_view");
        h localh = ((gh)localObject2).a(this, localJSONObject1);
        if (localh != null)
          continue;
        hc.b("Failed to retrieve ad assets.");
        Object localObject3 = null;
        continue;
        localList = Arrays.asList(arrayOfString);
        continue;
        localh.a(new g(this.b, this.d, localObject1, this.e, localJSONObject1, localh, this.h.a.k));
        localObject3 = localh;
        continue;
      }
      catch (JSONException localJSONException)
      {
        hc.c("Malformed native JSON response.", localJSONException);
        continue;
      }
      catch (TimeoutException localTimeoutException)
      {
        hc.c("Timeout when loading native ad.", localTimeoutException);
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
      }
      catch (ExecutionException localExecutionException)
      {
        continue;
        String str4 = "http:";
        continue;
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
      }
      label820: Object localObject2 = null;
    }
  }

  private static String[] b(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray == null)
      return null;
    String[] arrayOfString = new String[localJSONArray.length()];
    for (int m = 0; m < localJSONArray.length(); m++)
      arrayOfString[m] = localJSONArray.getString(m);
    return arrayOfString;
  }

  public final ih a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("attribution");
    if (localJSONObject == null)
      return new id(null);
    String str = localJSONObject.optString("text");
    int m = localJSONObject.optInt("text_size", -1);
    Integer localInteger1 = a(localJSONObject, "text_color");
    Integer localInteger2 = a(localJSONObject, "bg_color");
    int n = localJSONObject.optInt("animation_ms", 1000);
    int i1 = localJSONObject.optInt("presentation_ms", 4000);
    Object localObject = new ArrayList();
    if (localJSONObject.optJSONArray("images") != null)
      localObject = a(localJSONObject, "images", false, false, true);
    while (true)
    {
      ih localih = d.a((List)localObject);
      gf localgf = new gf(this, str, localInteger2, localInteger1, m, i1, n);
      ic localic = new ic();
      localih.a(new ie(localic, localgf, localih));
      return localic;
      ((List)localObject).add(a(localJSONObject, "image", false, false));
    }
  }

  public final ih a(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1);
    for (JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString); ; localJSONObject = paramJSONObject.optJSONObject(paramString))
    {
      if (localJSONObject == null)
        localJSONObject = new JSONObject();
      return a(localJSONObject, paramBoolean1, paramBoolean2);
    }
  }

  public final List a(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1);
    ArrayList localArrayList;
    for (JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString); ; localJSONArray = paramJSONObject.optJSONArray(paramString))
    {
      localArrayList = new ArrayList();
      if ((localJSONArray != null) && (localJSONArray.length() != 0))
        break;
      a(0, paramBoolean1);
      return localArrayList;
    }
    if (paramBoolean3);
    for (int m = localJSONArray.length(); ; m = 1)
      for (int n = 0; n < m; n++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(n);
        if (localJSONObject == null)
          localJSONObject = new JSONObject();
        localArrayList.add(a(localJSONObject, paramBoolean1, paramBoolean2));
      }
    return localArrayList;
  }

  public final Future a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
    boolean bool = localJSONObject.optBoolean("require", true);
    if (localJSONObject == null)
      localJSONObject = new JSONObject();
    return a(localJSONObject, bool, paramBoolean);
  }

  public final void a(int paramInt)
  {
    synchronized (this.g)
    {
      this.i = true;
      this.j = paramInt;
      return;
    }
  }

  public final void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      a(paramInt);
  }

  public final boolean a()
  {
    synchronized (this.g)
    {
      boolean bool = this.i;
      return bool;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.gb
 * JD-Core Version:    0.6.0
 */