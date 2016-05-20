package com.google.android.gms.b;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.a.f;
import com.google.android.gms.ads.internal.client.v;
import com.google.android.gms.ads.internal.client.x;

public final class fb extends e
{
  private static final fb a = new fb();

  private fb()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }

  public static fd a(Activity paramActivity)
  {
    fd localfd1;
    do
    {
      Intent localIntent;
      try
      {
        localIntent = paramActivity.getIntent();
        if (!localIntent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar"))
          throw new fc("Ad overlay requires the useClientJar flag in intent extras.");
      }
      catch (fc localfc)
      {
        android.support.v4.a.a.d(localfc.getMessage());
        localfd1 = null;
        return localfd1;
      }
      if (localIntent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false))
        break;
      localfd1 = a.b(paramActivity);
    }
    while (localfd1 != null);
    android.support.v4.a.a.a("Using AdOverlay from the client jar.");
    fd localfd2 = x.c().b(paramActivity);
    return localfd2;
  }

  private fd b(Activity paramActivity)
  {
    try
    {
      com.google.android.gms.a.a locala = d.a(paramActivity);
      fd localfd = fe.a(((fg)a(paramActivity)).a(locala));
      return localfd;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Could not create remote AdOverlay.", localRemoteException);
      return null;
    }
    catch (f localf)
    {
      android.support.v4.a.a.c("Could not create remote AdOverlay.", localf);
    }
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.fb
 * JD-Core Version:    0.6.0
 */