package com.google.android.gms.ads.b;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import com.google.android.gms.b.aZ;

public class b
{
  private final aZ a;
  private final Drawable b;
  private final Uri c;
  private final double d;

  public b()
  {
  }

  public b(aZ paramaZ)
  {
    this();
    this.a = paramaZ;
    try
    {
      com.google.android.gms.a.a locala = this.a.a();
      if (locala != null)
      {
        localDrawable = (Drawable)d.a(locala);
        this.b = localDrawable;
      }
    }
    catch (RemoteException localRemoteException2)
    {
      try
      {
        Uri localUri2 = this.a.b();
        localUri1 = localUri2;
        this.c = localUri1;
        d1 = 1.0D;
      }
      catch (RemoteException localRemoteException2)
      {
        try
        {
          while (true)
          {
            double d2 = this.a.c();
            double d1 = d2;
            this.d = d1;
            return;
            localRemoteException1 = localRemoteException1;
            android.support.v4.a.a.b("Failed to get drawable.", localRemoteException1);
            Drawable localDrawable = null;
          }
          localRemoteException2 = localRemoteException2;
          android.support.v4.a.a.b("Failed to get uri.", localRemoteException2);
          Uri localUri1 = null;
        }
        catch (RemoteException localRemoteException3)
        {
          while (true)
            android.support.v4.a.a.b("Failed to get scale.", localRemoteException3);
        }
      }
    }
  }

  public Drawable a()
  {
    return this.b;
  }

  public Uri b()
  {
    return this.c;
  }

  public double c()
  {
    return this.d;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.b.b
 * JD-Core Version:    0.6.0
 */