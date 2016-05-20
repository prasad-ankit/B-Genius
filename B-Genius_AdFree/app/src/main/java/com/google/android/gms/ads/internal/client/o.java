package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.a.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ek;

public final class o extends e
{
  private static final o a = new o();

  private o()
  {
    super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
  }

  public static H a(Context paramContext, String paramString, ek paramek)
  {
    x.a();
    H localH;
    if (com.google.android.gms.ads.internal.util.client.a.b(paramContext))
    {
      localH = a.b(paramContext, paramString, paramek);
      if (localH != null);
    }
    else
    {
      android.support.v4.a.a.a("Using AdLoader from the client jar.");
      VersionInfoParcel localVersionInfoParcel = new VersionInfoParcel(8487000, 8487000, true);
      localH = x.c().a(paramContext, paramString, paramek, localVersionInfoParcel);
    }
    return localH;
  }

  private H b(Context paramContext, String paramString, ek paramek)
  {
    try
    {
      com.google.android.gms.a.a locala = d.a(paramContext);
      H localH = I.a(((K)a(paramContext)).a(locala, paramString, paramek, 8487000));
      return localH;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Could not create remote builder for AdLoader.", localRemoteException);
      return null;
    }
    catch (f localf)
    {
      while (true)
        android.support.v4.a.a.c("Could not create remote builder for AdLoader.", localf);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.o
 * JD-Core Version:    0.6.0
 */