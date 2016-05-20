package com.badlogic.gdx.utils;

public class Base64Coder$CharMap
{
  protected final byte[] decodingMap = new byte[''];
  protected final char[] encodingMap = new char[64];

  public Base64Coder$CharMap(char paramChar1, char paramChar2)
  {
    int i = 65;
    int i6;
    for (int j = 0; i <= 90; j = i6)
    {
      char[] arrayOfChar4 = this.encodingMap;
      i6 = j + 1;
      arrayOfChar4[j] = i;
      i = (char)(i + 1);
    }
    int k = 97;
    while (k <= 122)
    {
      char[] arrayOfChar3 = this.encodingMap;
      int i5 = j + 1;
      arrayOfChar3[j] = k;
      k = (char)(k + 1);
      j = i5;
    }
    int m = 48;
    while (m <= 57)
    {
      char[] arrayOfChar2 = this.encodingMap;
      int i4 = j + 1;
      arrayOfChar2[j] = m;
      m = (char)(m + 1);
      j = i4;
    }
    char[] arrayOfChar1 = this.encodingMap;
    int n = j + 1;
    arrayOfChar1[j] = paramChar1;
    this.encodingMap[n] = paramChar2;
    int i3;
    for (int i1 = 0; ; i1++)
    {
      int i2 = this.decodingMap.length;
      i3 = 0;
      if (i1 >= i2)
        break;
      this.decodingMap[i1] = -1;
    }
    while (i3 < 64)
    {
      this.decodingMap[this.encodingMap[i3]] = (byte)i3;
      i3++;
    }
  }

  public byte[] getDecodingMap()
  {
    return this.decodingMap;
  }

  public char[] getEncodingMap()
  {
    return this.encodingMap;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Base64Coder.CharMap
 * JD-Core Version:    0.6.0
 */