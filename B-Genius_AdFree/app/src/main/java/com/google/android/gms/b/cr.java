package com.google.android.gms.b;

import java.util.HashMap;
import java.util.Map;

final class cr
  implements Runnable
{
  cr(cq paramcq, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
  }

  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheProgress");
    localHashMap.put("src", this.a);
    localHashMap.put("cachedSrc", this.b);
    localHashMap.put("bytesLoaded", Integer.toString(this.c));
    localHashMap.put("totalBytes", Integer.toString(this.d));
    if (this.e);
    for (String str = "1"; ; str = "0")
    {
      localHashMap.put("cacheReady", str);
      cq.a(this.f, "onPrecacheEvent", localHashMap);
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cr
 * JD-Core Version:    0.6.0
 */