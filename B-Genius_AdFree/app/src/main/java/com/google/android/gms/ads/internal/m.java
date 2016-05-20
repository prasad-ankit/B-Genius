package com.google.android.gms.ads.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.gT;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.is;

public class m
{
  private final gT a;
  private final is b;

  public m(gT paramgT, is paramis)
  {
    this.a = paramgT;
    this.b = paramis;
  }

  public void a(String paramString)
  {
    hc.a("An auto-clicking creative is blocked");
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.path("//pagead2.googlesyndication.com/pagead/gen_204");
    localBuilder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
    if (!TextUtils.isEmpty(paramString))
      localBuilder.appendQueryParameter("navigationURL", paramString);
    if ((this.a != null) && (this.a.b != null) && (!TextUtils.isEmpty(this.a.b.o)))
      localBuilder.appendQueryParameter("debugDialog", this.a.b.o);
    P.e().a(this.b.getContext(), this.b.o().b, localBuilder.toString());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.m
 * JD-Core Version:    0.6.0
 */