package com.google.android.gms.b;

import android.os.RemoteException;
import android.support.v4.a.c;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.i;
import com.google.android.gms.ads.mediation.b;
import com.google.android.gms.ads.mediation.customevent.e;
import java.util.Map;

public final class ek extends em
{
  private Map a;

  private eo c(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString, false, ek.class.getClassLoader());
      if (i.class.isAssignableFrom(localClass))
      {
        i locali = (i)localClass.newInstance();
        return new eI(locali, (c)this.a.get(locali.a()));
      }
      if (b.class.isAssignableFrom(localClass))
        return new eF((b)localClass.newInstance());
      android.support.v4.a.a.d("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable)
    {
    }
    return d(paramString);
  }

  private eo d(String paramString)
  {
    do
    {
      try
      {
        android.support.v4.a.a.a("Reflection failed, retrying using direct instantiation");
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(paramString))
          return new eF(new AdMobAdapter());
        if ("com.google.ads.mediation.AdUrlAdapter".equals(paramString))
        {
          eF localeF = new eF(new AdUrlAdapter());
          return localeF;
        }
      }
      catch (Throwable localThrowable)
      {
        android.support.v4.a.a.c("Could not instantiate mediation adapter: " + paramString + ". ", localThrowable);
        throw new RemoteException();
      }
      if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
        return new eF(new com.google.android.gms.ads.mediation.customevent.CustomEventAdapter());
    }
    while (!"com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString));
    eI localeI = new eI(new com.google.ads.mediation.customevent.CustomEventAdapter(), (e)this.a.get(e.class));
    return localeI;
  }

  public final eo a(String paramString)
  {
    return c(paramString);
  }

  public final void a(Map paramMap)
  {
    this.a = paramMap;
  }

  public final boolean b(String paramString)
  {
    try
    {
      boolean bool = com.google.android.gms.ads.mediation.customevent.a.class.isAssignableFrom(Class.forName(paramString, false, ek.class.getClassLoader()));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      android.support.v4.a.a.d("Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
    }
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ek
 * JD-Core Version:    0.6.0
 */