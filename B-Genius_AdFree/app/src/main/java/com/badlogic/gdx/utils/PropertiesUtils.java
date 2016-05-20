package com.badlogic.gdx.utils;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.Iterator;

public final class PropertiesUtils
{
  private static final int CONTINUE = 3;
  private static final int IGNORE = 5;
  private static final int KEY_DONE = 4;
  private static final String LINE_SEPARATOR = "\n";
  private static final int NONE = 0;
  private static final int SLASH = 1;
  private static final int UNICODE = 2;

  private static void dumpString(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramString.length();
    int j = 0;
    if (j < i)
    {
      char c = paramString.charAt(j);
      Object localObject;
      if ((c > '=') && (c < ''))
        if (c == '\\')
        {
          localObject = "\\\\";
          label49: paramStringBuilder.append(localObject);
        }
      while (true)
      {
        j++;
        break;
        localObject = Character.valueOf(c);
        break label49;
        switch (c)
        {
        default:
          if ((c >= ' ') && (c <= '~'))
            break;
        case ' ':
        case '\n':
        case '\r':
        case '\t':
        case '\f':
        case '!':
        case '#':
        case ':':
        case '=':
        }
        String str;
        for (boolean bool = true; ; bool = false)
        {
          if (!(bool & paramBoolean2))
            break label312;
          str = Integer.toHexString(c);
          paramStringBuilder.append("\\u");
          for (int k = 0; k < 4 - str.length(); k++)
            paramStringBuilder.append('0');
          if ((j != 0) && (!paramBoolean1))
            break;
          paramStringBuilder.append("\\ ");
          break;
          paramStringBuilder.append("\\n");
          break;
          paramStringBuilder.append("\\r");
          break;
          paramStringBuilder.append("\\t");
          break;
          paramStringBuilder.append("\\f");
          break;
          paramStringBuilder.append('\\').append(c);
          break;
        }
        paramStringBuilder.append(str);
        continue;
        label312: paramStringBuilder.append(c);
      }
    }
  }

  public static void load(ObjectMap paramObjectMap, Reader paramReader)
  {
    if (paramObjectMap == null)
      throw new NullPointerException("ObjectMap cannot be null");
    if (paramReader == null)
      throw new NullPointerException("Reader cannot be null");
    Object localObject1 = new char[40];
    int i = 0;
    int j = -1;
    int k = 1;
    BufferedReader localBufferedReader = new BufferedReader(paramReader);
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = localBufferedReader.read();
    char c;
    Object localObject2;
    if (i2 != -1)
    {
      c = (char)i2;
      if (i != localObject1.length)
        break label850;
      localObject2 = new char[localObject1.length << 1];
      System.arraycopy(localObject1, 0, localObject2, 0, i);
    }
    while (true)
    {
      label172: int i8;
      if (m == 2)
      {
        int i7 = Character.digit(c, 16);
        int i9;
        if (i7 >= 0)
        {
          n = i7 + (n << 4);
          i9 = i1 + 1;
          if (i9 < 4)
          {
            i1 = i9;
            localObject1 = localObject2;
            break;
          }
        }
        else
        {
          if (i1 > 4)
            break label172;
          throw new IllegalArgumentException("Invalid Unicode sequence: illegal character");
        }
        i1 = i9;
        i8 = i + 1;
        localObject2[i] = (char)n;
        if (c == '\n')
          i = i8;
      }
      for (int i3 = 0; ; i3 = m)
      {
        if (i3 == 1)
        {
          m = 0;
          switch (c)
          {
          default:
          case '\r':
          case '\n':
          case 'b':
          case 'f':
          case 'n':
          case 'r':
          case 't':
          case 'u':
          }
        }
        while (true)
        {
          if (m == 4)
          {
            m = 0;
            j = i;
          }
          int i4 = i + 1;
          localObject2[i] = c;
          i = i4;
          localObject1 = localObject2;
          k = 0;
          break;
          m = 3;
          localObject1 = localObject2;
          break;
          m = 5;
          localObject1 = localObject2;
          break;
          c = '\b';
          m = 0;
          continue;
          c = '\f';
          m = 0;
          continue;
          c = '\n';
          m = 0;
          continue;
          c = '\r';
          m = 0;
          continue;
          c = '\t';
          m = 0;
          continue;
          m = 2;
          localObject1 = localObject2;
          i1 = 0;
          n = 0;
          break;
          switch (c)
          {
          default:
          case '!':
          case '#':
          case '\n':
          case '\r':
          case '\\':
          case ':':
          case '=':
          }
          do
          {
            do
            {
              if (!Character.isSpace(c))
                break label690;
              if (i3 == 3)
                i3 = 5;
              if ((i == 0) || (i == j) || (i3 == 5))
                break label821;
              if (j != -1)
                break label690;
              m = 4;
              localObject1 = localObject2;
              break;
            }
            while (k == 0);
            int i6;
            do
            {
              int i5 = localBufferedReader.read();
              if (i5 == -1)
                break;
              i6 = (char)i5;
              if (i6 == 13)
                break;
            }
            while (i6 != 10);
            m = i3;
            localObject1 = localObject2;
            break;
            if (i3 == 3)
            {
              m = 5;
              localObject1 = localObject2;
              break;
            }
            k = 1;
            if ((i > 0) || ((i == 0) && (j == 0)))
            {
              if (j == -1)
                j = i;
              String str4 = new String(localObject2, 0, i);
              paramObjectMap.put(str4.substring(0, j), str4.substring(j));
            }
            j = -1;
            localObject1 = localObject2;
            i = 0;
            m = 0;
            break;
            if (i3 == 4)
              j = i;
            m = 1;
            localObject1 = localObject2;
            break;
          }
          while (j != -1);
          localObject1 = localObject2;
          j = i;
          m = 0;
          break;
          label690: m = i3;
          if ((m != 5) && (m != 3))
            continue;
          m = 0;
        }
        if ((m == 2) && (i1 <= 4))
          throw new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
        if ((j == -1) && (i > 0))
          j = i;
        if (j >= 0)
        {
          String str1 = new String(localObject1, 0, i);
          String str2 = str1.substring(0, j);
          String str3 = str1.substring(j);
          if (m == 1)
            str3 = str3 + "";
          paramObjectMap.put(str2, str3);
        }
        return;
        label821: m = i3;
        localObject1 = localObject2;
        break;
        i = i8;
        localObject1 = localObject2;
        m = 0;
        break;
      }
      label850: localObject2 = localObject1;
    }
  }

  public static void store(ObjectMap paramObjectMap, Writer paramWriter, String paramString)
  {
    storeImpl(paramObjectMap, paramWriter, paramString, false);
  }

  private static void storeImpl(ObjectMap paramObjectMap, Writer paramWriter, String paramString, boolean paramBoolean)
  {
    if (paramString != null)
      writeComment(paramWriter, paramString);
    paramWriter.write("#");
    paramWriter.write(new Date().toString());
    paramWriter.write("\n");
    StringBuilder localStringBuilder = new StringBuilder(200);
    ObjectMap.Entries localEntries = paramObjectMap.entries().iterator();
    while (localEntries.hasNext())
    {
      ObjectMap.Entry localEntry = (ObjectMap.Entry)localEntries.next();
      dumpString(localStringBuilder, (String)localEntry.key, true, paramBoolean);
      localStringBuilder.append('=');
      dumpString(localStringBuilder, (String)localEntry.value, false, paramBoolean);
      paramWriter.write("\n");
      paramWriter.write(localStringBuilder.toString());
      localStringBuilder.setLength(0);
    }
    paramWriter.flush();
  }

  private static void writeComment(Writer paramWriter, String paramString)
  {
    paramWriter.write("#");
    int i = paramString.length();
    int j = 0;
    int k = 0;
    int m;
    int n;
    if (k < i)
    {
      m = paramString.charAt(k);
      if ((m > 255) || (m == 10) || (m == 13))
      {
        if (j != k)
          paramWriter.write(paramString.substring(j, k));
        if (m <= 255)
          break label146;
        String str = Integer.toHexString(m);
        paramWriter.write("\\u");
        for (int i2 = 0; i2 < 4 - str.length(); i2++)
          paramWriter.write(48);
        paramWriter.write(str);
        n = k;
      }
    }
    label258: 
    while (true)
    {
      int i1 = n + 1;
      k = n;
      j = i1;
      k++;
      break;
      label146: paramWriter.write("\n");
      if ((m == 13) && (k != i - 1) && (paramString.charAt(k + 1) == '\n'));
      for (n = k + 1; ; n = k)
      {
        if ((n != i - 1) && ((paramString.charAt(n + 1) == '#') || (paramString.charAt(n + 1) == '!')))
          break label258;
        paramWriter.write("#");
        break;
        if (j != k)
          paramWriter.write(paramString.substring(j, k));
        paramWriter.write("\n");
        return;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.PropertiesUtils
 * JD-Core Version:    0.6.0
 */