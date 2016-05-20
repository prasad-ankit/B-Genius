package com.google.android.gms.b;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.common.api.o;
import java.lang.ref.WeakReference;

public abstract class cq
  implements o
{
  protected Context a;
  private WeakReference b;

  public cq(is paramis)
  {
    this.a = paramis.getContext();
    P.e().a(this.a, paramis.o().b);
    this.b = new WeakReference(paramis);
  }

  public final void a()
  {
  }

  protected final void a(String paramString1, String paramString2, int paramInt)
  {
    a.a.post(new cs(this, paramString1, paramString2, paramInt));
  }

  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a.a.post(new ct(this, paramString1, paramString2, paramString3, paramString4));
  }

  public abstract boolean a(String paramString);

  public abstract void b();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cq
 * JD-Core Version:    0.6.0
 */