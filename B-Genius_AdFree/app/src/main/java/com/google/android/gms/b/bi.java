package com.google.android.gms.b;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.ads.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bi extends f
{
  private final bf a;
  private final List b = new ArrayList();
  private final b c;

  public bi(bf parambf)
  {
    this.a = parambf;
    while (true)
    {
      aZ localaZ2;
      try
      {
        List localList = this.a.b();
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            Object localObject = localIterator.next();
            if (!(localObject instanceof IBinder))
              break label150;
            localaZ2 = ba.a((IBinder)localObject);
            if (localaZ2 == null)
              continue;
            this.b.add(new b(localaZ2));
            continue;
          }
        }
      }
      catch (RemoteException localRemoteException1)
      {
        android.support.v4.a.a.b("Failed to get image.", localRemoteException1);
      }
      try
      {
        aZ localaZ1 = this.a.d();
        if (localaZ1 != null)
        {
          localb = new b(localaZ1);
          this.c = localb;
          return;
          label150: localaZ2 = null;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        while (true)
        {
          android.support.v4.a.a.b("Failed to get icon.", localRemoteException2);
          b localb = null;
        }
      }
    }
  }

  private com.google.android.gms.a.a j()
  {
    try
    {
      com.google.android.gms.a.a locala = this.a.i();
      return locala;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.b("Failed to retrieve native ad engine.", localRemoteException);
    }
    return null;
  }

  public final CharSequence b()
  {
    try
    {
      String str = this.a.a();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.b("Failed to get headline.", localRemoteException);
    }
    return null;
  }

  public final List c()
  {
    return this.b;
  }

  public final CharSequence d()
  {
    try
    {
      String str = this.a.c();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.b("Failed to get body.", localRemoteException);
    }
    return null;
  }

  public final b e()
  {
    return this.c;
  }

  public final CharSequence f()
  {
    try
    {
      String str = this.a.e();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.b("Failed to get call to action.", localRemoteException);
    }
    return null;
  }

  public final Double g()
  {
    try
    {
      double d = this.a.f();
      if (d == -1.0D)
        return null;
      Double localDouble = Double.valueOf(d);
      return localDouble;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.b("Failed to get star rating.", localRemoteException);
    }
    return null;
  }

  public final CharSequence h()
  {
    try
    {
      String str = this.a.g();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.b("Failed to get store", localRemoteException);
    }
    return null;
  }

  public final CharSequence i()
  {
    try
    {
      String str = this.a.h();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.b("Failed to get price.", localRemoteException);
    }
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.bi
 * JD-Core Version:    0.6.0
 */