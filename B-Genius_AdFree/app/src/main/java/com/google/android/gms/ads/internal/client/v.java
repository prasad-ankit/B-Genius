package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ek;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.fw;

public class v
{
  public static String a = null;
  private w b;

  public v()
  {
    com.google.android.gms.ads.internal.a.a();
    if (a != null)
      try
      {
        this.b = ((w)v.class.getClassLoader().loadClass(a).newInstance());
        return;
      }
      catch (Exception localException)
      {
        android.support.v4.a.a.c("Failed to instantiate ClientApi class.", localException);
        this.b = new android.support.v4.a.a();
        return;
      }
    android.support.v4.a.a.d("No client jar implementation found.");
    this.b = new android.support.v4.a.a();
  }

  public final H a(Context paramContext, String paramString, ek paramek, VersionInfoParcel paramVersionInfoParcel)
  {
    return this.b.a(paramContext, paramString, paramek, paramVersionInfoParcel);
  }

  public final N a(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, ek paramek, VersionInfoParcel paramVersionInfoParcel)
  {
    return this.b.a(paramContext, paramAdSizeParcel, paramString, paramek, paramVersionInfoParcel);
  }

  public final fw a(Activity paramActivity)
  {
    return this.b.a(paramActivity);
  }

  public final N b(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, ek paramek, VersionInfoParcel paramVersionInfoParcel)
  {
    return this.b.b(paramContext, paramAdSizeParcel, paramString, paramek, paramVersionInfoParcel);
  }

  public final fd b(Activity paramActivity)
  {
    return this.b.b(paramActivity);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.v
 * JD-Core Version:    0.6.0
 */