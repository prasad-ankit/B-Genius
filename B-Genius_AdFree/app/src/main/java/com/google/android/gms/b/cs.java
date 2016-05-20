package com.google.android.gms.b;

import java.util.HashMap;
import java.util.Map;

final class cs
  implements Runnable
{
  cs(cq paramcq, String paramString1, String paramString2, int paramInt)
  {
  }

  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheComplete");
    localHashMap.put("src", this.a);
    localHashMap.put("cachedSrc", this.b);
    localHashMap.put("totalBytes", Integer.toString(this.c));
    cq.a(this.d, "onPrecacheEvent", localHashMap);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cs
 * JD-Core Version:    0.6.0
 */