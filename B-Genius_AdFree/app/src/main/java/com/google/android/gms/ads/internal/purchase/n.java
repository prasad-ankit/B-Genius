package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.support.v4.app.j;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.hc;

public final class n
{
  private final String a;

  public n(String paramString)
  {
    this.a = paramString;
  }

  public final boolean a(String paramString, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null));
    String str1;
    String str2;
    while (true)
    {
      return false;
      P.o();
      str1 = k.b(paramIntent);
      P.o();
      if (paramIntent == null);
      for (str2 = null; (str1 != null) && (str2 != null); str2 = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE"))
      {
        P.o();
        if (paramString.equals(k.a(str1)))
          break label75;
        hc.d("Developer payload not match.");
        return false;
      }
    }
    label75: if (this.a != null)
    {
      String str3 = this.a;
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str2)))
        hc.b("Purchase verification failed: missing data.");
      for (boolean bool = false; !bool; bool = j.a(j.a(str3), str1, str2))
      {
        hc.d("Fail to verify signature.");
        return false;
      }
    }
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.n
 * JD-Core Version:    0.6.0
 */