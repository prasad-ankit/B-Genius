package com.google.ads.mediation.customevent;

import android.support.v4.app.z;
import android.view.View;
import com.google.ads.mediation.j;
import com.google.ads.mediation.l;
import com.google.android.gms.ads.mediation.customevent.e;
import com.google.android.gms.b.hc;

public final class CustomEventAdapter
  implements j, l
{
  private z a;
  private z b;

  private static Object a(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      hc.d("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    return null;
  }

  public final Class a()
  {
    return e.class;
  }

  public final Class b()
  {
    return c.class;
  }

  public final View c()
  {
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.customevent.CustomEventAdapter
 * JD-Core Version:    0.6.0
 */