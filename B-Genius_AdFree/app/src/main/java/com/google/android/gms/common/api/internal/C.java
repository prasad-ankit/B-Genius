package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.r;
import java.lang.ref.WeakReference;

final class C
  implements IBinder.DeathRecipient, E
{
  private final WeakReference a;
  private final WeakReference b;
  private final WeakReference c;

  private C(F paramF, r paramr, IBinder paramIBinder)
  {
    this.b = new WeakReference(paramr);
    this.a = new WeakReference(paramF);
    this.c = new WeakReference(paramIBinder);
  }

  private void a()
  {
    F localF = (F)this.a.get();
    r localr = (r)this.b.get();
    if ((localr != null) && (localF != null))
    {
      localF.a().intValue();
      localr.a();
    }
    ((IBinder)this.c.get()).unlinkToDeath(this, 0);
  }

  public final void a(F paramF)
  {
    a();
  }

  public final void binderDied()
  {
    a();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.C
 * JD-Core Version:    0.6.0
 */