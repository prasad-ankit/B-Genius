package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.app.w;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.drive.DriveId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ap extends i
{
  private final String c;
  private final Bundle d;
  private volatile DriveId e;
  private volatile DriveId f;
  private volatile boolean g = false;
  private Map h = new HashMap();
  private Map i = new HashMap();
  private Map j = new HashMap();
  private Map k = new HashMap();

  public ap(Context paramContext, Looper paramLooper, f paramf, com.google.android.gms.common.api.j paramj, k paramk, Bundle paramBundle)
  {
    super(paramContext, paramLooper, 11, paramf, paramj, paramk);
    this.c = paramf.g();
    this.d = paramBundle;
    Intent localIntent = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
    localIntent.setPackage(paramContext.getPackageName());
    List localList = paramContext.getPackageManager().queryIntentServices(localIntent, 0);
    switch (localList.size())
    {
    default:
      throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + localIntent.getAction() + " action");
    case 1:
      ServiceInfo localServiceInfo = ((ResolveInfo)localList.get(0)).serviceInfo;
      if (localServiceInfo.exported)
        break;
      throw new IllegalStateException("Drive event service " + localServiceInfo.name + " must be exported in AndroidManifest.xml");
    case 0:
    }
  }

  protected final String a()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }

  protected final void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.e = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.f = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
      this.g = true;
    }
    super.a(paramInt1, paramIBinder, paramBundle, paramInt2);
  }

  protected final String b()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }

  public final void d()
  {
    if (e());
    try
    {
      ((j)o()).a(new DisconnectRequest());
      label26: super.d();
      synchronized (this.h)
      {
        this.h.clear();
        synchronized (this.i)
        {
          this.i.clear();
          synchronized (this.j)
          {
            this.j.clear();
          }
        }
      }
      synchronized (this.k)
      {
        this.k.clear();
        return;
        localObject1 = finally;
        monitorexit;
        throw localObject1;
        localObject2 = finally;
        monitorexit;
        throw localObject2;
        localObject3 = finally;
        monitorexit;
        throw localObject3;
      }
    }
    catch (RemoteException localRemoteException)
    {
      break label26;
    }
  }

  public final boolean f()
  {
    return (!k().getPackageName().equals(this.c)) || (!e.a(k(), Process.myUid()));
  }

  protected final Bundle m()
  {
    String str = k().getPackageName();
    w.a(str);
    if (!l().e().isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      w.b(bool);
      Bundle localBundle = new Bundle();
      if (!str.equals(this.c))
        localBundle.putString("proxy_package_name", this.c);
      localBundle.putAll(this.d);
      return localBundle;
    }
  }

  public final boolean p()
  {
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ap
 * JD-Core Version:    0.6.0
 */