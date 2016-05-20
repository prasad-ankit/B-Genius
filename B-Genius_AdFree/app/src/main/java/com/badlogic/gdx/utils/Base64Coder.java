package com.badlogic.gdx.utils;

public class Base64Coder
{
  public static final Base64Coder.CharMap regularMap = new Base64Coder.CharMap('+', '/');
  private static final String systemLineSeparator = "\n";
  public static final Base64Coder.CharMap urlsafeMap = new Base64Coder.CharMap('-', '_');

  public static byte[] decode(String paramString)
  {
    return decode(paramString.toCharArray());
  }

  public static byte[] decode(String paramString, Base64Coder.CharMap paramCharMap)
  {
    return decode(paramString.toCharArray(), paramCharMap);
  }

  public static byte[] decode(char[] paramArrayOfChar)
  {
    return decode(paramArrayOfChar, 0, paramArrayOfChar.length, regularMap.decodingMap);
  }

  public static byte[] decode(char[] paramArrayOfChar, int paramInt1, int paramInt2, Base64Coder.CharMap paramCharMap)
  {
    return decode(paramArrayOfChar, paramInt1, paramInt2, paramCharMap.decodingMap);
  }

  public static byte[] decode(char[] paramArrayOfChar, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt2 % 4 != 0)
      throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    while ((paramInt2 > 0) && (paramArrayOfChar[(-1 + (paramInt1 + paramInt2))] == '='))
      paramInt2--;
    int i = paramInt2 * 3 / 4;
    byte[] arrayOfByte = new byte[i];
    int j = paramInt1 + paramInt2;
    int k = 0;
    int i4;
    label178: label189: int i12;
    int i13;
    int i14;
    if (paramInt1 < j)
    {
      int m = paramInt1 + 1;
      int n = paramArrayOfChar[paramInt1];
      int i1 = m + 1;
      int i2 = paramArrayOfChar[m];
      int i3;
      int i5;
      if (i1 < j)
      {
        int i17 = i1 + 1;
        i3 = paramArrayOfChar[i1];
        i1 = i17;
        if (i1 >= j)
          break label178;
        int i16 = i1 + 1;
        i5 = paramArrayOfChar[i1];
        i4 = i16;
      }
      while (true)
      {
        if ((n <= 127) && (i2 <= 127) && (i3 <= 127) && (i5 <= 127))
          break label189;
        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
        i3 = 65;
        break;
        i4 = i1;
        i5 = 65;
      }
      int i6 = paramArrayOfByte[n];
      int i7 = paramArrayOfByte[i2];
      int i8 = paramArrayOfByte[i3];
      int i9 = paramArrayOfByte[i5];
      if ((i6 < 0) || (i7 < 0) || (i8 < 0) || (i9 < 0))
        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
      int i10 = i6 << 2 | i7 >>> 4;
      int i11 = (i7 & 0xF) << 4 | i8 >>> 2;
      i12 = i9 | (i8 & 0x3) << 6;
      i13 = k + 1;
      arrayOfByte[k] = (byte)i10;
      if (i13 >= i)
        break label356;
      i14 = i13 + 1;
      arrayOfByte[i13] = (byte)i11;
    }
    while (true)
    {
      int i15;
      if (i14 < i)
      {
        i15 = i14 + 1;
        arrayOfByte[i14] = (byte)i12;
      }
      while (true)
      {
        paramInt1 = i4;
        k = i15;
        break;
        return arrayOfByte;
        i15 = i14;
      }
      label356: i14 = i13;
    }
  }

  public static byte[] decode(char[] paramArrayOfChar, Base64Coder.CharMap paramCharMap)
  {
    return decode(paramArrayOfChar, 0, paramArrayOfChar.length, paramCharMap);
  }

  public static byte[] decode(char[] paramArrayOfChar, byte[] paramArrayOfByte)
  {
    return decode(paramArrayOfChar, 0, paramArrayOfChar.length, paramArrayOfByte);
  }

  public static byte[] decodeLines(String paramString)
  {
    return decodeLines(paramString, regularMap.decodingMap);
  }

  public static byte[] decodeLines(String paramString, Base64Coder.CharMap paramCharMap)
  {
    return decodeLines(paramString, paramCharMap.decodingMap);
  }

  public static byte[] decodeLines(String paramString, byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramString.length()];
    int i = 0;
    int j = 0;
    while (i < paramString.length())
    {
      int k = paramString.charAt(i);
      if ((k != 32) && (k != 13) && (k != 10) && (k != 9))
      {
        int m = j + 1;
        arrayOfChar[j] = k;
        j = m;
      }
      i++;
    }
    return decode(arrayOfChar, 0, j, paramArrayOfByte);
  }

  public static String decodeString(String paramString)
  {
    return decodeString(paramString, false);
  }

  public static String decodeString(String paramString, boolean paramBoolean)
  {
    char[] arrayOfChar = paramString.toCharArray();
    if (paramBoolean);
    for (byte[] arrayOfByte = urlsafeMap.decodingMap; ; arrayOfByte = regularMap.decodingMap)
      return new String(decode(arrayOfChar, arrayOfByte));
  }

  public static char[] encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, regularMap.encodingMap);
  }

  public static char[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramInt, regularMap.encodingMap);
  }

  public static char[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Base64Coder.CharMap paramCharMap)
  {
    return encode(paramArrayOfByte, paramInt1, paramInt2, paramCharMap.encodingMap);
  }

  public static char[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    int i = (2 + (paramInt2 << 2)) / 3;
    char[] arrayOfChar = new char[(paramInt2 + 2) / 3 << 2];
    int j = paramInt1 + paramInt2;
    int k = 0;
    if (paramInt1 < j)
    {
      int m = paramInt1 + 1;
      int n = 0xFF & paramArrayOfByte[paramInt1];
      int i1;
      label75: int i2;
      int i3;
      label98: int i7;
      int i10;
      label182: int i11;
      if (m < j)
      {
        int i14 = m + 1;
        i1 = 0xFF & paramArrayOfByte[m];
        m = i14;
        if (m >= j)
          break label237;
        i2 = m + 1;
        i3 = 0xFF & paramArrayOfByte[m];
        int i4 = n >>> 2;
        int i5 = (n & 0x3) << 4 | i1 >>> 4;
        int i6 = (i1 & 0xF) << 2 | i3 >>> 6;
        i7 = i3 & 0x3F;
        int i8 = k + 1;
        arrayOfChar[k] = paramArrayOfChar[i4];
        int i9 = i8 + 1;
        arrayOfChar[i8] = paramArrayOfChar[i5];
        if (i9 >= i)
          break label247;
        i10 = paramArrayOfChar[i6];
        arrayOfChar[i9] = i10;
        i11 = i9 + 1;
        if (i11 >= i)
          break label254;
      }
      label237: label247: label254: for (int i12 = paramArrayOfChar[i7]; ; i12 = 61)
      {
        arrayOfChar[i11] = i12;
        int i13 = i11 + 1;
        paramInt1 = i2;
        k = i13;
        break;
        i1 = 0;
        break label75;
        i2 = m;
        i3 = 0;
        break label98;
        i10 = 61;
        break label182;
      }
    }
    return arrayOfChar;
  }

  public static char[] encode(byte[] paramArrayOfByte, Base64Coder.CharMap paramCharMap)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramCharMap);
  }

  public static char[] encode(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramArrayOfChar);
  }

  public static String encodeLines(byte[] paramArrayOfByte)
  {
    return encodeLines(paramArrayOfByte, 0, paramArrayOfByte.length, 76, "\n", regularMap.encodingMap);
  }

  public static String encodeLines(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString, Base64Coder.CharMap paramCharMap)
  {
    return encodeLines(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramString, paramCharMap.encodingMap);
  }

  public static String encodeLines(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString, char[] paramArrayOfChar)
  {
    int i = paramInt3 * 3 / 4;
    if (i <= 0)
      throw new IllegalArgumentException();
    int j = (-1 + (paramInt2 + i)) / i;
    StringBuilder localStringBuilder = new StringBuilder(((paramInt2 + 2) / 3 << 2) + j * paramString.length());
    int k = 0;
    while (k < paramInt2)
    {
      int m = Math.min(paramInt2 - k, i);
      localStringBuilder.append(encode(paramArrayOfByte, paramInt1 + k, m, paramArrayOfChar));
      localStringBuilder.append(paramString);
      k += m;
    }
    return localStringBuilder.toString();
  }

  public static String encodeString(String paramString)
  {
    return encodeString(paramString, false);
  }

  public static String encodeString(String paramString, boolean paramBoolean)
  {
    byte[] arrayOfByte = paramString.getBytes();
    if (paramBoolean);
    for (char[] arrayOfChar = urlsafeMap.encodingMap; ; arrayOfChar = regularMap.encodingMap)
      return new String(encode(arrayOfByte, arrayOfChar));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Base64Coder
 * JD-Core Version:    0.6.0
 */