package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.b.fI;
import com.google.android.gms.b.fw;
import com.google.android.gms.b.hc;

public class InAppPurchaseActivity extends Activity
{
  private fw a;

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      if (this.a != null)
        this.a.a(paramInt1, paramInt2, paramIntent);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hc.c("Could not forward onActivityResult to in-app purchase manager:", localRemoteException);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = fI.a(this);
    if (this.a == null)
    {
      hc.d("Could not create in-app purchase manager.");
      finish();
      return;
    }
    try
    {
      this.a.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not forward onCreate to in-app purchase manager:", localRemoteException);
      finish();
    }
  }

  protected void onDestroy()
  {
    try
    {
      if (this.a != null)
        this.a.b();
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hc.c("Could not forward onDestroy to in-app purchase manager:", localRemoteException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.purchase.InAppPurchaseActivity
 * JD-Core Version:    0.6.0
 */