package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

public final class r
{
  private static final r a = new r();

  static k a(PackageInfo paramPackageInfo, k[] paramArrayOfk)
  {
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    l locall = new l(paramPackageInfo.signatures[0].toByteArray());
    for (int i = 0; i < paramArrayOfk.length; i++)
      if (paramArrayOfk[i].equals(locall))
        return paramArrayOfk[i];
    if (Log.isLoggable("GoogleSignatureVerifier", 2))
      Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(locall.a(), 0));
    return null;
  }

  public static r a()
  {
    return a;
  }

  public final boolean a(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if ((paramPackageInfo != null) && (paramPackageInfo.signatures != null))
    {
      if (paramBoolean);
      k[] arrayOfk;
      for (k localk = a(paramPackageInfo, n.a); localk != null; localk = a(paramPackageInfo, arrayOfk))
      {
        return true;
        arrayOfk = new k[1];
        arrayOfk[0] = n.a[0];
      }
    }
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.r
 * JD-Core Version:    0.6.0
 */