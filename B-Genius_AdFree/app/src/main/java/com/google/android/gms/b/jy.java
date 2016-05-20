package com.google.android.gms.b;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class jy
{
  private static final Pattern a;

  static
  {
    Pattern.compile("\\\\.");
    a = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
  }

  public static String a(String paramString)
  {
    Matcher localMatcher;
    StringBuffer localStringBuffer;
    if (!TextUtils.isEmpty(paramString))
    {
      localMatcher = a.matcher(paramString);
      localStringBuffer = null;
      while (localMatcher.find())
      {
        if (localStringBuffer == null)
          localStringBuffer = new StringBuffer();
        switch (localMatcher.group().charAt(0))
        {
        default:
          break;
        case '\b':
          localMatcher.appendReplacement(localStringBuffer, "\\\\b");
          break;
        case '"':
          localMatcher.appendReplacement(localStringBuffer, "\\\\\\\"");
          break;
        case '\\':
          localMatcher.appendReplacement(localStringBuffer, "\\\\\\\\");
          break;
        case '/':
          localMatcher.appendReplacement(localStringBuffer, "\\\\/");
          break;
        case '\f':
          localMatcher.appendReplacement(localStringBuffer, "\\\\f");
          break;
        case '\n':
          localMatcher.appendReplacement(localStringBuffer, "\\\\n");
          break;
        case '\r':
          localMatcher.appendReplacement(localStringBuffer, "\\\\r");
          break;
        case '\t':
          localMatcher.appendReplacement(localStringBuffer, "\\\\t");
        }
      }
      if (localStringBuffer != null);
    }
    else
    {
      return paramString;
    }
    localMatcher.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jy
 * JD-Core Version:    0.6.0
 */