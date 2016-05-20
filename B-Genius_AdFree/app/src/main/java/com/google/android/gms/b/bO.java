package com.google.android.gms.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

final class bO
  implements bU
{
  public final void a(is paramis, Map paramMap)
  {
    String str1 = (String)paramMap.get("urls");
    if (TextUtils.isEmpty(str1))
    {
      hc.d("URLs missing in canOpenURLs GMSG.");
      return;
    }
    String[] arrayOfString1 = str1.split(",");
    HashMap localHashMap = new HashMap();
    PackageManager localPackageManager = paramis.getContext().getPackageManager();
    int i = arrayOfString1.length;
    int j = 0;
    if (j < i)
    {
      String str2 = arrayOfString1[j];
      String[] arrayOfString2 = str2.split(";", 2);
      String str3 = arrayOfString2[0].trim();
      String str4;
      if (arrayOfString2.length > 1)
      {
        str4 = arrayOfString2[1].trim();
        label110: if (localPackageManager.resolveActivity(new Intent(str4, Uri.parse(str3)), 65536) == null)
          break label163;
      }
      label163: for (boolean bool = true; ; bool = false)
      {
        localHashMap.put(str2, Boolean.valueOf(bool));
        j++;
        break;
        str4 = "android.intent.action.VIEW";
        break label110;
      }
    }
    paramis.a("openableURLs", localHashMap);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.bO
 * JD-Core Version:    0.6.0
 */