package com.google.android.gms.b;

import android.support.v4.app.w;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.LinkedList;

final class dd
{
  private final LinkedList a;
  private AdRequestParcel b;
  private final String c;
  private final int d;

  dd(AdRequestParcel paramAdRequestParcel, String paramString, int paramInt)
  {
    w.a(paramAdRequestParcel);
    w.a(paramString);
    this.a = new LinkedList();
    this.b = paramAdRequestParcel;
    this.c = paramString;
    this.d = paramInt;
  }

  final AdRequestParcel a()
  {
    return this.b;
  }

  final void a(cx paramcx)
  {
    de localde = new de(this, paramcx);
    this.a.add(localde);
    localde.a(this.b);
  }

  final int b()
  {
    return this.d;
  }

  final String c()
  {
    return this.c;
  }

  final de d()
  {
    return (de)this.a.remove();
  }

  final int e()
  {
    return this.a.size();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.dd
 * JD-Core Version:    0.6.0
 */