package com.google.android.gms.b;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class kn
{
  private final ByteBuffer a;

  private kn(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
    this.a.order(ByteOrder.LITTLE_ENDIAN);
  }

  private kn(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }

  public static int a(int paramInt)
  {
    if (paramInt >= 0)
      return e(paramInt);
    return 10;
  }

  public static int a(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
      return 1;
    if ((0xFFFFC000 & paramLong) == 0L)
      return 2;
    if ((0xFFE00000 & paramLong) == 0L)
      return 3;
    if ((0xF0000000 & paramLong) == 0L)
      return 4;
    if ((0x0 & paramLong) == 0L)
      return 5;
    if ((0x0 & paramLong) == 0L)
      return 6;
    if ((0x0 & paramLong) == 0L)
      return 7;
    if ((0x0 & paramLong) == 0L)
      return 8;
    if ((0x0 & paramLong) == 0L)
      return 9;
    return 10;
  }

  private static int a(CharSequence paramCharSequence)
  {
    int i = 0;
    int j = paramCharSequence.length();
    for (int k = 0; (k < j) && (paramCharSequence.charAt(k) < ''); k++);
    while (true)
    {
      if (k < j)
      {
        int i1 = paramCharSequence.charAt(k);
        if (i1 < 2048)
        {
          m += (127 - i1 >>> 31);
          k++;
          continue;
        }
        int i2 = paramCharSequence.length();
        if (k < i2)
        {
          int i3 = paramCharSequence.charAt(k);
          if (i3 < 2048)
            i += (127 - i3 >>> 31);
          while (true)
          {
            k++;
            break;
            i += 2;
            if ((55296 > i3) || (i3 > 57343))
              continue;
            if (Character.codePointAt(paramCharSequence, k) < 65536)
              throw new IllegalArgumentException("Unpaired surrogate at index " + k);
            k++;
          }
        }
      }
      for (int n = i + m; ; n = m)
      {
        if (n < j)
          throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (4294967296L + n));
        return n;
      }
      int m = j;
    }
  }

  private static int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramCharSequence.length();
    int j = 0;
    int k = paramInt1 + paramInt2;
    while ((j < i) && (j + paramInt1 < k))
    {
      int i9 = paramCharSequence.charAt(j);
      if (i9 >= 128)
        break;
      paramArrayOfByte[(paramInt1 + j)] = (byte)i9;
      j++;
    }
    if (j == i)
      return paramInt1 + i;
    int m = paramInt1 + j;
    if (j < i)
    {
      int n = paramCharSequence.charAt(j);
      int i5;
      if ((n < 128) && (m < k))
      {
        i5 = m + 1;
        paramArrayOfByte[m] = (byte)n;
      }
      while (true)
      {
        j++;
        m = i5;
        break;
        if ((n < 2048) && (m <= k - 2))
        {
          int i8 = m + 1;
          paramArrayOfByte[m] = (byte)(0x3C0 | n >>> 6);
          i5 = i8 + 1;
          paramArrayOfByte[i8] = (byte)(0x80 | n & 0x3F);
          continue;
        }
        if (((n < 55296) || (57343 < n)) && (m <= k - 3))
        {
          int i6 = m + 1;
          paramArrayOfByte[m] = (byte)(0x1E0 | n >>> 12);
          int i7 = i6 + 1;
          paramArrayOfByte[i6] = (byte)(0x80 | 0x3F & n >>> 6);
          i5 = i7 + 1;
          paramArrayOfByte[i7] = (byte)(0x80 | n & 0x3F);
          continue;
        }
        if (m > k - 4)
          break label457;
        char c;
        if (j + 1 != paramCharSequence.length())
        {
          j++;
          c = paramCharSequence.charAt(j);
          if (Character.isSurrogatePair(n, c));
        }
        else
        {
          throw new IllegalArgumentException("Unpaired surrogate at index " + (j - 1));
        }
        int i1 = Character.toCodePoint(n, c);
        int i2 = m + 1;
        paramArrayOfByte[m] = (byte)(0xF0 | i1 >>> 18);
        int i3 = i2 + 1;
        paramArrayOfByte[i2] = (byte)(0x80 | 0x3F & i1 >>> 12);
        int i4 = i3 + 1;
        paramArrayOfByte[i3] = (byte)(0x80 | 0x3F & i1 >>> 6);
        i5 = i4 + 1;
        paramArrayOfByte[i4] = (byte)(0x80 | i1 & 0x3F);
      }
      label457: if ((55296 <= n) && (n <= 57343) && ((j + 1 == paramCharSequence.length()) || (!Character.isSurrogatePair(n, paramCharSequence.charAt(j + 1)))))
        throw new IllegalArgumentException("Unpaired surrogate at index " + j);
      throw new ArrayIndexOutOfBoundsException("Failed writing " + n + " at index " + m);
    }
    return m;
  }

  public static int a(String paramString)
  {
    int i = a(paramString);
    return i + e(i);
  }

  public static kn a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static kn a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new kn(paramArrayOfByte, paramInt1, paramInt2);
  }

  private static void a(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly())
      throw new ReadOnlyBufferException();
    if (paramByteBuffer.hasArray())
      try
      {
        paramByteBuffer.position(a(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        BufferOverflowException localBufferOverflowException = new BufferOverflowException();
        localBufferOverflowException.initCause(localArrayIndexOutOfBoundsException);
        throw localBufferOverflowException;
      }
    b(paramCharSequence, paramByteBuffer);
  }

  public static int b(int paramInt1, int paramInt2)
  {
    return c(paramInt1) + a(paramInt2);
  }

  public static int b(int paramInt, ku paramku)
  {
    int i = c(paramInt);
    int j = paramku.d();
    return i + (j + e(j));
  }

  public static int b(int paramInt, String paramString)
  {
    return c(paramInt) + a(paramString);
  }

  public static int b(int paramInt, byte[] paramArrayOfByte)
  {
    return c(paramInt) + b(paramArrayOfByte);
  }

  public static int b(byte[] paramArrayOfByte)
  {
    return e(paramArrayOfByte.length) + paramArrayOfByte.length;
  }

  private void b(long paramLong)
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        b((int)paramLong);
        return;
      }
      b(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  private static void b(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int i = paramCharSequence.length();
    int j = 0;
    if (j < i)
    {
      int k = paramCharSequence.charAt(j);
      if (k < 128)
        paramByteBuffer.put((byte)k);
      while (true)
      {
        j++;
        break;
        if (k < 2048)
        {
          paramByteBuffer.put((byte)(0x3C0 | k >>> 6));
          paramByteBuffer.put((byte)(0x80 | k & 0x3F));
          continue;
        }
        if ((k < 55296) || (57343 < k))
        {
          paramByteBuffer.put((byte)(0x1E0 | k >>> 12));
          paramByteBuffer.put((byte)(0x80 | 0x3F & k >>> 6));
          paramByteBuffer.put((byte)(0x80 | k & 0x3F));
          continue;
        }
        char c;
        if (j + 1 != paramCharSequence.length())
        {
          j++;
          c = paramCharSequence.charAt(j);
          if (Character.isSurrogatePair(k, c));
        }
        else
        {
          throw new IllegalArgumentException("Unpaired surrogate at index " + (j - 1));
        }
        int m = Character.toCodePoint(k, c);
        paramByteBuffer.put((byte)(0xF0 | m >>> 18));
        paramByteBuffer.put((byte)(0x80 | 0x3F & m >>> 12));
        paramByteBuffer.put((byte)(0x80 | 0x3F & m >>> 6));
        paramByteBuffer.put((byte)(0x80 | m & 0x3F));
      }
    }
  }

  public static int c(int paramInt)
  {
    return e(kw.a(paramInt, 0));
  }

  public static int c(int paramInt, long paramLong)
  {
    return c(paramInt) + a(paramLong);
  }

  private static long c(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }

  public static int d(int paramInt, long paramLong)
  {
    return c(paramInt) + a(c(paramLong));
  }

  public static int e(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0)
      return 1;
    if ((paramInt & 0xFFFFC000) == 0)
      return 2;
    if ((0xFFE00000 & paramInt) == 0)
      return 3;
    if ((0xF0000000 & paramInt) == 0)
      return 4;
    return 5;
  }

  public final void a()
  {
    if (this.a.remaining() != 0)
      throw new IllegalStateException("Did not write as much data as expected.");
  }

  public final void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      d(paramInt2);
      return;
    }
    b(paramInt2);
  }

  public final void a(int paramInt, long paramLong)
  {
    c(paramInt, 0);
    b(paramLong);
  }

  public final void a(int paramInt, ku paramku)
  {
    c(paramInt, 2);
    a(paramku);
  }

  public final void a(int paramInt, String paramString)
  {
    c(paramInt, 2);
    int i;
    int j;
    try
    {
      i = e(paramString.length());
      if (i != e(3 * paramString.length()))
        break label167;
      j = this.a.position();
      if (this.a.remaining() < i)
        throw new ko(i + j, this.a.limit());
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      ko localko = new ko(this.a.position(), this.a.limit());
      localko.initCause(localBufferOverflowException);
      throw localko;
    }
    this.a.position(j + i);
    a(paramString, this.a);
    int k = this.a.position();
    this.a.position(j);
    d(k - j - i);
    this.a.position(k);
    return;
    label167: d(a(paramString));
    a(paramString, this.a);
  }

  public final void a(int paramInt, byte[] paramArrayOfByte)
  {
    c(paramInt, 2);
    d(paramArrayOfByte.length);
    c(paramArrayOfByte);
  }

  public final void a(ku paramku)
  {
    d(paramku.c());
    paramku.a(this);
  }

  public final void b(int paramInt)
  {
    byte b = (byte)paramInt;
    if (!this.a.hasRemaining())
      throw new ko(this.a.position(), this.a.limit());
    this.a.put(b);
  }

  public final void b(int paramInt, long paramLong)
  {
    c(paramInt, 0);
    b(c(paramLong));
  }

  public final void c(int paramInt1, int paramInt2)
  {
    d(kw.a(paramInt1, paramInt2));
  }

  public final void c(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    if (this.a.remaining() >= i)
    {
      this.a.put(paramArrayOfByte, 0, i);
      return;
    }
    throw new ko(this.a.position(), this.a.limit());
  }

  public final void d(int paramInt)
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        b(paramInt);
        return;
      }
      b(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.kn
 * JD-Core Version:    0.6.0
 */