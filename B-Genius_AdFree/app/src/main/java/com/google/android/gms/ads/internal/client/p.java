package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.a.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ek;

public final class p extends e
{
  public p()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }

  private N a(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, ek paramek, int paramInt)
  {
    try
    {
      com.google.android.gms.a.a locala = d.a(paramContext);
      N localN = O.a(((Q)a(paramContext)).a(locala, paramAdSizeParcel, paramString, paramek, 8487000, paramInt));
      return localN;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.a("Could not create remote AdManager.", localRemoteException);
      return null;
    }
    catch (f localf)
    {
      label39: break label39;
    }
  }

  public final N a(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, ek paramek)
  {
    x.a();
    N localN;
    if (com.google.android.gms.ads.internal.util.client.a.b(paramContext))
    {
      localN = a(paramContext, paramAdSizeParcel, paramString, paramek, 1);
      if (localN != null);
    }
    else
    {
      android.support.v4.a.a.a("Using BannerAdManager from the client jar.");
      VersionInfoParcel localVersionInfoParcel = new VersionInfoParcel(8487000, 8487000, true);
      localN = x.c().a(paramContext, paramAdSizeParcel, paramString, paramek, localVersionInfoParcel);
    }
    return localN;
  }

  public final N b(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, ek paramek)
  {
    x.a();
    N localN;
    if (com.google.android.gms.ads.internal.util.client.a.b(paramContext))
    {
      localN = a(paramContext, paramAdSizeParcel, paramString, paramek, 2);
      if (localN != null);
    }
    else
    {
      android.support.v4.a.a.d("Using InterstitialAdManager from the client jar.");
      VersionInfoParcel localVersionInfoParcel = new VersionInfoParcel(8487000, 8487000, true);
      localN = x.c().b(paramContext, paramAdSizeParcel, paramString, paramek, localVersionInfoParcel);
    }
    return localN;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.p
 * JD-Core Version:    0.6.0
 */