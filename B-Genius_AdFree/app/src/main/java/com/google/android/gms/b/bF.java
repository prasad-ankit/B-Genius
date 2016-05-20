package com.google.android.gms.b;

import java.util.Map;

public final class bF
  implements bU
{
  private final bG a;

  public bF(bG parambG)
  {
    this.a = parambG;
  }

  public final void a(is paramis, Map paramMap)
  {
    String str = (String)paramMap.get("name");
    if (str == null)
    {
      hc.d("App event with no name parameter.");
      return;
    }
    this.a.a(str, (String)paramMap.get("info"));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.bF
 * JD-Core Version:    0.6.0
 */