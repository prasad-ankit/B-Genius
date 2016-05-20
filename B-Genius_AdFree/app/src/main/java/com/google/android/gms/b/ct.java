package com.google.android.gms.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

final class ct
  implements Runnable
{
  ct(cq paramcq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
  }

  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheCanceled");
    localHashMap.put("src", this.a);
    if (!TextUtils.isEmpty(this.b))
      localHashMap.put("cachedSrc", this.b);
    localHashMap.put("type", cq.a(this.e, this.c));
    localHashMap.put("reason", this.c);
    if (!TextUtils.isEmpty(this.d))
      localHashMap.put("message", this.d);
    cq.a(this.e, "onPrecacheEvent", localHashMap);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ct
 * JD-Core Version:    0.6.0
 */