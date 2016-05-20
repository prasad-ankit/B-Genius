package com.google.android.gms.common;

import android.support.v4.app.w;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class k
{
  private int a;

  protected k(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 25);
    for (boolean bool = true; ; bool = false)
    {
      w.b(bool, "cert hash data has incorrect length");
      this.a = Arrays.hashCode(paramArrayOfByte);
      return;
    }
  }

  protected static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new AssertionError(localUnsupportedEncodingException);
  }

  abstract byte[] a();

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof k)))
      return false;
    k localk = (k)paramObject;
    return Arrays.equals(a(), localk.a());
  }

  public int hashCode()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.k
 * JD-Core Version:    0.6.0
 */