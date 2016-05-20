package com.google.android.gms.b;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

public final class af
  implements Application.ActivityLifecycleCallbacks
{
  private Activity a;
  private Context b;
  private final Object c = new Object();

  public af(Application paramApplication, Activity paramActivity)
  {
    paramApplication.registerActivityLifecycleCallbacks(this);
    a(paramActivity);
    this.b = paramApplication.getApplicationContext();
  }

  private void a(Activity paramActivity)
  {
    synchronized (this.c)
    {
      if (!paramActivity.getClass().getName().startsWith("com.google.android.gms.ads"))
        this.a = paramActivity;
      return;
    }
  }

  public final Activity a()
  {
    return this.a;
  }

  public final Context b()
  {
    return this.b;
  }

  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
  }

  public final void onActivityDestroyed(Activity paramActivity)
  {
    synchronized (this.c)
    {
      if (this.a == null)
        return;
      if (this.a.equals(paramActivity))
        this.a = null;
      return;
    }
  }

  public final void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity);
  }

  public final void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity);
  }

  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
  }

  public final void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity);
  }

  public final void onActivityStopped(Activity paramActivity)
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.af
 * JD-Core Version:    0.6.0
 */