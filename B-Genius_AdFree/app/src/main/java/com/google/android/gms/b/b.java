package com.google.android.gms.b;

import java.io.ByteArrayOutputStream;

public final class b extends ByteArrayOutputStream
{
  private final kD a;

  public b(kD paramkD, int paramInt)
  {
    this.a = paramkD;
    this.buf = this.a.a(Math.max(paramInt, 256));
  }

  private void a(int paramInt)
  {
    if (paramInt + this.count <= this.buf.length)
      return;
    byte[] arrayOfByte = this.a.a(paramInt + this.count << 1);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.a.a(this.buf);
    this.buf = arrayOfByte;
  }

  public final void close()
  {
    this.a.a(this.buf);
    this.buf = null;
    super.close();
  }

  public final void finalize()
  {
    this.a.a(this.buf);
  }

  public final void write(int paramInt)
  {
    monitorenter;
    try
    {
      a(1);
      super.write(paramInt);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    monitorenter;
    try
    {
      a(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.b
 * JD-Core Version:    0.6.0
 */