package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.Set;

public final class g extends i
{
  private final PlusSession c;

  public g(Context paramContext, Looper paramLooper, f paramf, PlusSession paramPlusSession, j paramj, k paramk)
  {
    super(paramContext, paramLooper, 2, paramf, paramj, paramk);
    this.c = paramPlusSession;
  }

  protected final String a()
  {
    return "com.google.android.gms.plus.service.START";
  }

  protected final void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person")))
      PersonEntity.a(paramBundle.getByteArray("loaded_person"));
    super.a(paramInt1, paramIBinder, paramBundle, paramInt2);
  }

  protected final String b()
  {
    return "com.google.android.gms.plus.internal.IPlusService";
  }

  public final void c()
  {
    n();
    try
    {
      ((d)o()).b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException(localRemoteException);
  }

  public final boolean f()
  {
    Set localSet = l().a(com.google.android.gms.plus.d.a);
    if ((localSet == null) || (localSet.isEmpty()));
    do
      return false;
    while ((localSet.size() == 1) && (localSet.contains(new Scope("plus_one_placeholder_scope"))));
    return true;
  }

  protected final Bundle m()
  {
    Bundle localBundle = this.c.k();
    localBundle.putStringArray("request_visible_actions", this.c.d());
    localBundle.putString("auth_package", this.c.f());
    return localBundle;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.g
 * JD-Core Version:    0.6.0
 */