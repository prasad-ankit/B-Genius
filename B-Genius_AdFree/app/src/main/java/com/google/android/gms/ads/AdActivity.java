package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.a.a;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.b.fb;
import com.google.android.gms.b.fd;

public class AdActivity extends Activity
{
  private fd a;

  private void a()
  {
    if (this.a != null);
    try
    {
      this.a.l();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not forward setContentViewSet to ad overlay:", localRemoteException);
    }
  }

  public void onBackPressed()
  {
    int i = 1;
    try
    {
      if (this.a != null)
      {
        boolean bool = this.a.e();
        i = bool;
      }
      if (i != 0)
        super.onBackPressed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        a.c("Could not forward onBackPressed to ad overlay:", localRemoteException);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = fb.a(this);
    if (this.a == null)
    {
      a.d("Could not create ad overlay.");
      finish();
      return;
    }
    try
    {
      this.a.a(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not forward onCreate to ad overlay:", localRemoteException);
      finish();
    }
  }

  protected void onDestroy()
  {
    try
    {
      if (this.a != null)
        this.a.k();
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        a.c("Could not forward onDestroy to ad overlay:", localRemoteException);
    }
  }

  protected void onPause()
  {
    try
    {
      if (this.a != null)
        this.a.i();
      super.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        a.c("Could not forward onPause to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  protected void onRestart()
  {
    super.onRestart();
    try
    {
      if (this.a != null)
        this.a.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not forward onRestart to ad overlay:", localRemoteException);
      finish();
    }
  }

  protected void onResume()
  {
    super.onResume();
    try
    {
      if (this.a != null)
        this.a.h();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not forward onResume to ad overlay:", localRemoteException);
      finish();
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      if (this.a != null)
        this.a.b(paramBundle);
      super.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        a.c("Could not forward onSaveInstanceState to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  protected void onStart()
  {
    super.onStart();
    try
    {
      if (this.a != null)
        this.a.g();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not forward onStart to ad overlay:", localRemoteException);
      finish();
    }
  }

  protected void onStop()
  {
    try
    {
      if (this.a != null)
        this.a.j();
      super.onStop();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        a.c("Could not forward onStop to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    a();
  }

  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    a();
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    a();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdActivity
 * JD-Core Version:    0.6.0
 */