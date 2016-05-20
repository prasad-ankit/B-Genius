package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class m extends k
{
  private static final WeakReference b = new WeakReference(null);
  private WeakReference a = b;

  m(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }

  final byte[] a()
  {
    monitorenter;
    try
    {
      byte[] arrayOfByte = (byte[])this.a.get();
      if (arrayOfByte == null)
      {
        arrayOfByte = b();
        this.a = new WeakReference(arrayOfByte);
      }
      return arrayOfByte;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected abstract byte[] b();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.m
 * JD-Core Version:    0.6.0
 */