package com.google.android.gms.b;

import android.support.v4.app.j;
import java.io.IOException;

public abstract class ku
{
  protected volatile int E = -1;

  public static final byte[] a(ku paramku)
  {
    byte[] arrayOfByte = new byte[paramku.d()];
    int i = arrayOfByte.length;
    try
    {
      kn localkn = kn.a(arrayOfByte, 0, i);
      paramku.a(localkn);
      localkn.a();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
  }

  protected int a()
  {
    return 0;
  }

  public void a(kn paramkn)
  {
  }

  public ku b()
  {
    return (ku)super.clone();
  }

  public final int c()
  {
    if (this.E < 0)
      d();
    return this.E;
  }

  public final int d()
  {
    int i = a();
    this.E = i;
    return i;
  }

  public String toString()
  {
    return j.a(this);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ku
 * JD-Core Version:    0.6.0
 */