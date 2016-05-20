package com.google.android.gms.b;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

final class bQ
  implements bU
{
  public final void a(is paramis, Map paramMap)
  {
    String str1 = (String)paramMap.get("u");
    if (str1 == null)
    {
      hc.d("URL missing from click GMSG.");
      return;
    }
    Uri localUri1 = Uri.parse(str1);
    try
    {
      y localy = paramis.n();
      if ((localy != null) && (localy.a(localUri1)))
      {
        Uri localUri3 = localy.a(localUri1, paramis.getContext());
        localUri2 = localUri3;
        String str2 = localUri2.toString();
        new hX(paramis.getContext(), paramis.o().b, str2).g();
        return;
      }
    }
    catch (z localz)
    {
      while (true)
      {
        hc.d("Unable to append parameter to URL: " + str1);
        Uri localUri2 = localUri1;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.bQ
 * JD-Core Version:    0.6.0
 */