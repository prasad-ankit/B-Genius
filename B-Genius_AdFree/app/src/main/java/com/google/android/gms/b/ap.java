package com.google.android.gms.b;

import java.security.MessageDigest;

public final class ap extends al
{
  private MessageDigest b;

  public final byte[] a(String paramString)
  {
    int i = 0;
    String[] arrayOfString = paramString.split(" ");
    byte[] arrayOfByte1 = new byte[arrayOfString.length];
    while (i < arrayOfString.length)
    {
      int k = d.a(arrayOfString[i]);
      arrayOfByte1[i] = (byte)(k & 0xFF ^ 0xFF & k >> 8 ^ 0xFF & k >> 16 ^ k >> 24);
      i++;
    }
    this.b = a();
    while (true)
    {
      byte[] arrayOfByte3;
      synchronized (this.a)
      {
        if (this.b != null)
          continue;
        byte[] arrayOfByte2 = new byte[0];
        return arrayOfByte2;
        this.b.reset();
        this.b.update(arrayOfByte1);
        arrayOfByte3 = this.b.digest();
        if (arrayOfByte3.length > 4)
        {
          j = 4;
          byte[] arrayOfByte4 = new byte[j];
          System.arraycopy(arrayOfByte3, 0, arrayOfByte4, 0, arrayOfByte4.length);
          return arrayOfByte4;
        }
      }
      int j = arrayOfByte3.length;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ap
 * JD-Core Version:    0.6.0
 */