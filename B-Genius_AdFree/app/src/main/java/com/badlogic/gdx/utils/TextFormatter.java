package com.badlogic.gdx.utils;

import java.text.MessageFormat;
import java.util.Locale;

class TextFormatter
{
  private StringBuilder buffer = new StringBuilder();
  private MessageFormat messageFormat;

  public TextFormatter(Locale paramLocale, boolean paramBoolean)
  {
    if (paramBoolean)
      this.messageFormat = new MessageFormat("", paramLocale);
  }

  private String replaceEscapeChars(String paramString)
  {
    int i = 0;
    this.buffer.setLength(0);
    int j = paramString.length();
    int k = 0;
    char c;
    int m;
    int n;
    while (true)
      if (i < j)
      {
        c = paramString.charAt(i);
        if (c == '\'')
        {
          this.buffer.append("''");
          m = i;
          k = 1;
          i = m + 1;
          continue;
        }
        if (c != '{')
          break;
        for (n = i + 1; (n < j) && (paramString.charAt(n) == '{'); n++);
        int i1 = (n - i) / 2;
        if (i1 <= 0)
          break label217;
        this.buffer.append('\'');
        do
        {
          this.buffer.append('{');
          i1--;
        }
        while (i1 > 0);
        this.buffer.append('\'');
      }
    label217: for (int i2 = 1; ; i2 = k)
    {
      if ((n - i) % 2 != 0)
        this.buffer.append('{');
      int i3 = n - 1;
      k = i2;
      m = i3;
      break;
      this.buffer.append(c);
      m = i;
      break;
      if (k != 0)
        paramString = this.buffer.toString();
      return paramString;
    }
  }

  private String simpleFormat(String paramString, Object[] paramArrayOfObject)
  {
    this.buffer.setLength(0);
    int i = paramString.length();
    int j = 0;
    int k = -1;
    int m = 0;
    if (j < i)
    {
      char c = paramString.charAt(j);
      if (k < 0)
        if (c == '{')
        {
          m = 1;
          if ((j + 1 < i) && (paramString.charAt(j + 1) == '{'))
          {
            this.buffer.append(c);
            j++;
          }
        }
      while (true)
      {
        j++;
        break;
        k = 0;
        continue;
        this.buffer.append(c);
        continue;
        if (c == '}')
        {
          if (k >= paramArrayOfObject.length)
            throw new IllegalArgumentException("Argument index out of bounds: " + k);
          if (paramString.charAt(j - 1) == '{')
            throw new IllegalArgumentException("Missing argument index after a left curly brace");
          if (paramArrayOfObject[k] == null)
            this.buffer.append("null");
          while (true)
          {
            k = -1;
            break;
            this.buffer.append(paramArrayOfObject[k].toString());
          }
        }
        if ((c < '0') || (c > '9'))
          throw new IllegalArgumentException("Unexpected '" + c + "' while parsing argument index");
        k = k * 10 + (c - '0');
      }
    }
    if (k >= 0)
      throw new IllegalArgumentException("Unmatched braces in the pattern.");
    if (m != 0)
      paramString = this.buffer.toString();
    return paramString;
  }

  public String format(String paramString, Object[] paramArrayOfObject)
  {
    if (this.messageFormat != null)
    {
      this.messageFormat.applyPattern(replaceEscapeChars(paramString));
      return this.messageFormat.format(paramArrayOfObject);
    }
    return simpleFormat(paramString, paramArrayOfObject);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.TextFormatter
 * JD-Core Version:    0.6.0
 */