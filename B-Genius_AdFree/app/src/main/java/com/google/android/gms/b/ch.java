package com.google.android.gms.b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.l;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class ch
  implements bU
{
  private final cc a;
  private final l b;
  private final eQ c;

  public ch(cc paramcc, l paraml, eQ parameQ)
  {
    this.a = paramcc;
    this.b = paraml;
    this.c = parameQ;
  }

  private void a(boolean paramBoolean)
  {
    if (this.c != null)
      this.c.a(paramBoolean);
  }

  private static boolean a(Map paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }

  private static int b(Map paramMap)
  {
    String str = (String)paramMap.get("o");
    if (str != null)
    {
      if ("p".equalsIgnoreCase(str))
        return P.g().b();
      if ("l".equalsIgnoreCase(str))
        return P.g().a();
      if ("c".equalsIgnoreCase(str))
        return P.g().c();
    }
    return -1;
  }

  public final void a(is paramis, Map paramMap)
  {
    String str1 = (String)paramMap.get("a");
    if (str1 == null)
      hc.d("Action missing from an open GMSG.");
    it localit1;
    while (true)
    {
      return;
      if ((this.b != null) && (!this.b.b()))
      {
        this.b.a((String)paramMap.get("u"));
        return;
      }
      localit1 = paramis.l();
      if ("expand".equalsIgnoreCase(str1))
      {
        if (paramis.p())
        {
          hc.d("Cannot expand WebView that is already expanded.");
          return;
        }
        a(false);
        localit1.a(a(paramMap), b(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase(str1))
      {
        String str7 = (String)paramMap.get("u");
        a(false);
        if (str7 != null)
        {
          localit1.a(a(paramMap), b(paramMap), str7);
          return;
        }
        localit1.a(a(paramMap), b(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase(str1))
        break;
      String str5 = (String)paramMap.get("product_id");
      String str6 = (String)paramMap.get("report_urls");
      if (this.a == null)
        continue;
      if ((str6 != null) && (!str6.isEmpty()))
      {
        String[] arrayOfString = str6.split(" ");
        this.a.a(str5, new ArrayList(Arrays.asList(arrayOfString)));
        return;
      }
      this.a.a(str5, new ArrayList());
      return;
    }
    if (("app".equalsIgnoreCase(str1)) && ("true".equalsIgnoreCase((String)paramMap.get("play_store"))))
    {
      String str4 = (String)paramMap.get("u");
      if (TextUtils.isEmpty(str4))
      {
        hc.d("Destination url cannot be empty.");
        return;
      }
      new ci(paramis, str4).g();
      return;
    }
    if (("app".equalsIgnoreCase(str1)) && ("true".equalsIgnoreCase((String)paramMap.get("system_browser"))))
    {
      a(true);
      Context localContext = paramis.getContext();
      if (TextUtils.isEmpty((String)paramMap.get("u")))
      {
        hc.d("Destination url cannot be empty.");
        return;
      }
      it localit2 = paramis.l();
      Intent localIntent = new cj(paramis).a(localContext, paramMap);
      try
      {
        localit2.a(new AdLauncherIntentInfoParcel(localIntent));
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        hc.d(localActivityNotFoundException.getMessage());
        return;
      }
    }
    a(true);
    String str2 = (String)paramMap.get("u");
    if (!TextUtils.isEmpty(str2));
    for (String str3 = P.e().a(paramis, str2); ; str3 = str2)
    {
      localit1.a(new AdLauncherIntentInfoParcel((String)paramMap.get("i"), str3, (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ch
 * JD-Core Version:    0.6.0
 */