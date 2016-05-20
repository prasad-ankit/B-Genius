package com.google.android.gms.b;

import android.support.v4.app.j;
import java.io.UnsupportedEncodingException;

public class c extends iR
{
  private final js a;

  private c(int paramInt, String paramString, js paramjs, jr paramjr)
  {
    super(0, paramString, paramjr);
    this.a = paramjs;
  }

  public c(String paramString, js paramjs, jr paramjr)
  {
    this(0, paramString, paramjs, paramjr);
  }

  protected final jq a(gP paramgP)
  {
    try
    {
      str = new String(paramgP.a, j.a(paramgP.b));
      return jq.a(str, j.a(paramgP));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        String str = new String(paramgP.a);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.c
 * JD-Core Version:    0.6.0
 */