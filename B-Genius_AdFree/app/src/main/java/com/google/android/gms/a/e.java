package com.google.android.gms.a;

import android.content.Context;
import android.os.IBinder;
import android.support.v4.app.w;
import com.google.android.gms.common.q;

public abstract class e
{
  private final String a;
  private Object b;

  protected e(String paramString)
  {
    this.a = paramString;
  }

  protected final Object a(Context paramContext)
  {
    ClassLoader localClassLoader;
    if (this.b == null)
    {
      w.a(paramContext);
      Context localContext = q.d(paramContext);
      if (localContext == null)
        throw new f("Could not get remote context.");
      localClassLoader = localContext.getClassLoader();
    }
    try
    {
      this.b = a((IBinder)localClassLoader.loadClass(this.a).newInstance());
      return this.b;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new f("Could not load creator class.", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new f("Could not instantiate creator.", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new f("Could not access creator.", localIllegalAccessException);
  }

  protected abstract Object a(IBinder paramIBinder);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.a.e
 * JD-Core Version:    0.6.0
 */