package com.google.android.gms.b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class al
{
  private static MessageDigest b = null;
  protected Object a = new Object();

  protected final MessageDigest a()
  {
    while (true)
    {
      int i;
      synchronized (this.a)
      {
        if (b == null)
          continue;
        MessageDigest localMessageDigest2 = b;
        return localMessageDigest2;
        i = 0;
        if (i >= 2);
      }
      try
      {
        b = MessageDigest.getInstance("MD5");
        label38: i++;
        continue;
        MessageDigest localMessageDigest1 = b;
        monitorexit;
        return localMessageDigest1;
        localObject2 = finally;
        monitorexit;
        throw localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        break label38;
      }
    }
  }

  abstract byte[] a(String paramString);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.al
 * JD-Core Version:    0.6.0
 */