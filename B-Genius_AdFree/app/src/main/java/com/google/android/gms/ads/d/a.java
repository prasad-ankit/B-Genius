package com.google.android.gms.ads.d;

import android.os.RemoteException;

public class a
{
  private final com.google.android.gms.ads.internal.reward.a.a a;

  public a(com.google.android.gms.ads.internal.reward.a.a parama)
  {
    this.a = parama;
  }

  public String a()
  {
    if (this.a == null)
      return null;
    try
    {
      String str = this.a.a();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Could not forward getType to RewardItem", localRemoteException);
    }
    return null;
  }

  public int b()
  {
    if (this.a == null)
      return 0;
    try
    {
      int i = this.a.b();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Could not forward getAmount to RewardItem", localRemoteException);
    }
    return 0;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.d.a
 * JD-Core Version:    0.6.0
 */