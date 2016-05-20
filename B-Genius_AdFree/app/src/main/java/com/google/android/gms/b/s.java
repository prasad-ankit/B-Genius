package com.google.android.gms.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.a.a.b;
import com.google.android.gms.common.api.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public abstract class s
  implements r
{
  protected static g i;
  protected MotionEvent a;
  protected LinkedList b = new LinkedList();
  protected long c = 0L;
  protected long d = 0L;
  protected long e = 0L;
  protected long f = 0L;
  protected DisplayMetrics g;
  protected A h;
  private boolean j = false;

  protected s(Context paramContext, A paramA)
  {
    this.h = paramA;
    try
    {
      this.g = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      this.g = new DisplayMetrics();
      this.g.density = 1.0F;
    }
  }

  private String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      b localb1 = c(paramContext);
      this.j = true;
      while ((localb1 == null) || (localb1.d() == 0))
      {
        return Integer.toString(5);
        localb1 = b(paramContext);
      }
      byte[] arrayOfByte1 = ku.a(localb1);
      if (arrayOfByte1.length > 239)
      {
        b localb2 = new b();
        localb2.k = Long.valueOf(1L);
        arrayOfByte1 = ku.a(localb2);
      }
      byte[] arrayOfByte6;
      if (arrayOfByte1.length < 239)
      {
        arrayOfByte6 = new byte[239 - arrayOfByte1.length];
        new SecureRandom().nextBytes(arrayOfByte6);
      }
      byte[] arrayOfByte2;
      for (Object localObject = ByteBuffer.allocate(240).put((byte)arrayOfByte1.length).put(arrayOfByte1).put(arrayOfByte6).array(); ; localObject = arrayOfByte2)
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(localObject);
        byte[] arrayOfByte3 = localMessageDigest.digest();
        byte[] arrayOfByte4 = ByteBuffer.allocate(256).put(arrayOfByte3).put(localObject).array();
        byte[] arrayOfByte5 = new byte[256];
        new d().a(arrayOfByte4, arrayOfByte5);
        if ((paramString != null) && (paramString.length() > 0))
        {
          if (paramString.length() > 32)
            paramString = paramString.substring(0, 32);
          new km(paramString.getBytes("UTF-8")).a(arrayOfByte5);
        }
        return this.h.a(arrayOfByte5, true);
        arrayOfByte2 = ByteBuffer.allocate(240).put((byte)arrayOfByte1.length).put(arrayOfByte1).array();
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return Integer.toString(7);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return Integer.toString(7);
    }
    catch (IOException localIOException)
    {
    }
    return (String)Integer.toString(3);
  }

  public final String a(Context paramContext)
  {
    return a(paramContext, null, false);
  }

  public final String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true);
  }

  protected final String a(String paramString)
  {
    if ((paramString != null) && (paramString.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")))
    {
      UUID localUUID = UUID.fromString(paramString);
      byte[] arrayOfByte = new byte[16];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer.putLong(localUUID.getMostSignificantBits());
      localByteBuffer.putLong(localUUID.getLeastSignificantBits());
      paramString = this.h.a(arrayOfByte, true);
    }
    return paramString;
  }

  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null)
      this.a.recycle();
    this.a = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.g.density, paramInt2 * this.g.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
  }

  public final void a(MotionEvent paramMotionEvent)
  {
    if (this.j)
    {
      this.f = 0L;
      this.e = 0L;
      this.d = 0L;
      this.c = 0L;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        ((MotionEvent)localIterator.next()).recycle();
      this.b.clear();
      this.a = null;
      this.j = false;
    }
    switch (paramMotionEvent.getAction())
    {
    default:
      return;
    case 1:
      this.a = MotionEvent.obtain(paramMotionEvent);
      this.b.add(this.a);
      if (this.b.size() > 6)
        ((MotionEvent)this.b.remove()).recycle();
      this.e = (1L + this.e);
      return;
    case 0:
      this.c = (1L + this.c);
      return;
    case 3:
      this.f = (1L + this.f);
      return;
    case 2:
    }
    this.d += 1 + paramMotionEvent.getHistorySize();
  }

  protected abstract b b(Context paramContext);

  protected abstract b c(Context paramContext);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.s
 * JD-Core Version:    0.6.0
 */