package com.google.android.gms.b;

import java.util.Map;

public final class cd
  implements bU
{
  private final ce a;

  public cd(ce paramce)
  {
    this.a = paramce;
  }

  public final void a(is paramis, Map paramMap)
  {
    boolean bool1 = "1".equals(paramMap.get("transparentBackground"));
    boolean bool2 = "1".equals(paramMap.get("blur"));
    try
    {
      if (paramMap.get("blurRadius") != null)
      {
        float f2 = Float.parseFloat((String)paramMap.get("blurRadius"));
        f1 = f2;
        this.a.b(bool1);
        this.a.a(bool2, f1);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        hc.b("Fail to parse float", localNumberFormatException);
        float f1 = 0.0F;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cd
 * JD-Core Version:    0.6.0
 */