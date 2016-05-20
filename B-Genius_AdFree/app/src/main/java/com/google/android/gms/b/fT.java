package com.google.android.gms.b;

import android.content.Context;
import android.support.v4.app.j;
import com.google.android.gms.ads.internal.H;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

public final class fT
{
  public static hG a(Context paramContext, b paramb, gT paramgT, y paramy, is paramis, el paramel, fU paramfU, aR paramaR)
  {
    AdResponseParcel localAdResponseParcel = paramgT.b;
    Object localObject;
    if (localAdResponseParcel.h)
      localObject = new fX(paramContext, paramgT, paramel, paramfU, paramaR, paramis);
    while (true)
    {
      hc.a("AdRenderer: " + localObject.getClass().getName());
      ((hG)localObject).e();
      return localObject;
      if (localAdResponseParcel.t)
      {
        if ((paramb instanceof H))
        {
          localObject = new fZ(paramContext, (H)paramb, new dj(), paramgT, paramy, paramfU);
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder("Invalid NativeAdManager type. Found: ");
        if (paramb != null);
        for (String str = paramb.getClass().getName(); ; str = "null")
          throw new IllegalArgumentException(str + "; Required: NativeAdManager.");
      }
      if (localAdResponseParcel.p)
      {
        localObject = new fO(paramContext, paramgT, paramis, paramfU);
        continue;
      }
      au localau = aD.G;
      if ((((Boolean)P.n().a(localau)).booleanValue()) && (j.g()) && (!j.h()) && (paramis.k().e))
      {
        localObject = new fW(paramContext, paramgT, paramis, paramfU);
        continue;
      }
      localObject = new fV(paramContext, paramgT, paramis, paramfU);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.fT
 * JD-Core Version:    0.6.0
 */