package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.au;
import com.google.android.gms.b.hG;
import com.google.android.gms.b.hV;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.ij;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.k;

public final class p extends l
  implements com.google.android.gms.common.api.j, k
{
  private Context a;
  private VersionInfoParcel b;
  private ij c;
  private final j d;
  private final Object e = new Object();
  private q f;
  private boolean g;

  public p(Context paramContext, VersionInfoParcel paramVersionInfoParcel, ij paramij, j paramj)
  {
    super(paramij, paramj);
    this.a = paramContext;
    this.b = paramVersionInfoParcel;
    this.c = paramij;
    this.d = paramj;
    au localau = aD.p;
    if (((Boolean)P.n().a(localau)).booleanValue())
      this.g = true;
    for (Looper localLooper = P.q().a(); ; localLooper = paramContext.getMainLooper())
    {
      this.f = new q(paramContext, localLooper, this, this, this.b.d);
      this.f.j_();
      return;
    }
  }

  public final void a()
  {
    synchronized (this.e)
    {
      if ((this.f.e()) || (this.f.j()))
        this.f.d();
      Binder.flushPendingCommands();
      if (this.g)
      {
        P.q().b();
        this.g = false;
      }
      return;
    }
  }

  public final void a(int paramInt)
  {
    hc.a("Disconnected from remote ad request service.");
  }

  public final void a(Bundle paramBundle)
  {
    c();
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    hc.a("Cannot connect to remote service, fallback to local instance.");
    new o(this.a, this.c, this.d).e();
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "gms_connection_failed_fallback_to_local");
    P.e().b(this.a, this.b.b, "gmob-apps", localBundle, true);
  }

  public final v b()
  {
    try
    {
      synchronized (this.e)
      {
        v localv = this.f.c();
        return localv;
        label21: return null;
      }
    }
    catch (DeadObjectException localDeadObjectException)
    {
      break label21;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label21;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.p
 * JD-Core Version:    0.6.0
 */