package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.H;
import com.google.android.gms.ads.internal.client.N;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.purchase.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.au;
import com.google.android.gms.b.df;
import com.google.android.gms.b.ek;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.fw;

public class a
  implements w
{
  public static void a()
  {
    com.google.android.gms.ads.internal.client.v.a = a.class.getName();
  }

  public final H a(Context paramContext, String paramString, ek paramek, VersionInfoParcel paramVersionInfoParcel)
  {
    return new u(paramContext, paramString, paramek, paramVersionInfoParcel, k.a());
  }

  public final N a(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, ek paramek, VersionInfoParcel paramVersionInfoParcel)
  {
    return new n(paramContext, paramAdSizeParcel, paramString, paramek, paramVersionInfoParcel, k.a());
  }

  public final fw a(Activity paramActivity)
  {
    return new f(paramActivity);
  }

  public final N b(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, ek paramek, VersionInfoParcel paramVersionInfoParcel)
  {
    au localau = aD.M;
    if (((Boolean)P.n().a(localau)).booleanValue())
      return new df(paramContext, paramString, paramek, paramVersionInfoParcel, k.a());
    return new v(paramContext, paramAdSizeParcel, paramString, paramek, paramVersionInfoParcel, k.a());
  }

  public final fd b(Activity paramActivity)
  {
    return new com.google.android.gms.ads.internal.overlay.k(paramActivity);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.a
 * JD-Core Version:    0.6.0
 */