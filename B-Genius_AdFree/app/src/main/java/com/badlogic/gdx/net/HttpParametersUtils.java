package com.badlogic.gdx.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HttpParametersUtils
{
  public static String defaultEncoding = "UTF-8";
  public static String nameValueSeparator = "=";
  public static String parameterSeparator = "&";

  public static String convertHttpParameters(Map paramMap)
  {
    Set localSet = paramMap.keySet();
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuffer.append(encode(str, defaultEncoding));
      localStringBuffer.append(nameValueSeparator);
      localStringBuffer.append(encode((String)paramMap.get(str), defaultEncoding));
      localStringBuffer.append(parameterSeparator);
    }
    if (localStringBuffer.length() > 0)
      localStringBuffer.deleteCharAt(-1 + localStringBuffer.length());
    return localStringBuffer.toString();
  }

  private static String encode(String paramString1, String paramString2)
  {
    try
    {
      String str = URLEncoder.encode(paramString1, paramString2);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new IllegalArgumentException(localUnsupportedEncodingException);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.net.HttpParametersUtils
 * JD-Core Version:    0.6.0
 */