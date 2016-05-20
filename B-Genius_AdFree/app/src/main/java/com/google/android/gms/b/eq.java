package com.google.android.gms.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.a.b;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.List;

final class eq
  implements eo
{
  private IBinder a;

  eq(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final com.google.android.gms.a.a a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      com.google.android.gms.a.a locala = b.a(localParcel2.readStrongBinder());
      return locala;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(com.google.android.gms.a.a parama, AdRequestParcel paramAdRequestParcel, String paramString1, com.google.android.gms.ads.internal.reward.mediation.client.a parama1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      IBinder localIBinder1;
      if (parama != null)
      {
        localIBinder1 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        if (paramAdRequestParcel == null)
          break label129;
        localParcel1.writeInt(1);
        paramAdRequestParcel.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        localParcel1.writeString(paramString1);
        IBinder localIBinder2 = null;
        if (parama1 != null)
          localIBinder2 = parama1.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        localParcel1.writeString(paramString2);
        this.a.transact(10, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder1 = null;
        break;
        label129: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(com.google.android.gms.a.a parama, AdRequestParcel paramAdRequestParcel, String paramString, er paramer)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      IBinder localIBinder1;
      if (parama != null)
      {
        localIBinder1 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        if (paramAdRequestParcel == null)
          break label121;
        localParcel1.writeInt(1);
        paramAdRequestParcel.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        localParcel1.writeString(paramString);
        IBinder localIBinder2 = null;
        if (paramer != null)
          localIBinder2 = paramer.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        this.a.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder1 = null;
        break;
        label121: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(com.google.android.gms.a.a parama, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, er paramer)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      IBinder localIBinder1;
      if (parama != null)
      {
        localIBinder1 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        if (paramAdRequestParcel == null)
          break label129;
        localParcel1.writeInt(1);
        paramAdRequestParcel.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        IBinder localIBinder2 = null;
        if (paramer != null)
          localIBinder2 = paramer.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        this.a.transact(7, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder1 = null;
        break;
        label129: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(com.google.android.gms.a.a parama, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, er paramer, NativeAdOptionsParcel paramNativeAdOptionsParcel, List paramList)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (parama == null)
          continue;
        IBinder localIBinder1 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        if (paramAdRequestParcel == null)
          continue;
        localParcel1.writeInt(1);
        paramAdRequestParcel.writeToParcel(localParcel1, 0);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        IBinder localIBinder2 = null;
        if (paramer == null)
          continue;
        localIBinder2 = paramer.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        if (paramNativeAdOptionsParcel != null)
        {
          localParcel1.writeInt(1);
          paramNativeAdOptionsParcel.writeToParcel(localParcel1, 0);
          localParcel1.writeStringList(paramList);
          this.a.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localIBinder1 = null;
          continue;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
    }
  }

  public final void a(com.google.android.gms.a.a parama, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, er paramer)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (parama == null)
          continue;
        IBinder localIBinder1 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        if (paramAdSizeParcel == null)
          continue;
        localParcel1.writeInt(1);
        paramAdSizeParcel.writeToParcel(localParcel1, 0);
        if (paramAdRequestParcel != null)
        {
          localParcel1.writeInt(1);
          paramAdRequestParcel.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString);
          IBinder localIBinder2 = null;
          if (paramer == null)
            continue;
          localIBinder2 = paramer.asBinder();
          localParcel1.writeStrongBinder(localIBinder2);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localIBinder1 = null;
          continue;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
    }
  }

  public final void a(com.google.android.gms.a.a parama, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, er paramer)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (parama == null)
          continue;
        IBinder localIBinder1 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        if (paramAdSizeParcel == null)
          continue;
        localParcel1.writeInt(1);
        paramAdSizeParcel.writeToParcel(localParcel1, 0);
        if (paramAdRequestParcel != null)
        {
          localParcel1.writeInt(1);
          paramAdRequestParcel.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          IBinder localIBinder2 = null;
          if (paramer == null)
            continue;
          localIBinder2 = paramer.asBinder();
          localParcel1.writeStrongBinder(localIBinder2);
          this.a.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localIBinder1 = null;
          continue;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
    }
  }

  public final void a(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      if (paramAdRequestParcel != null)
      {
        localParcel1.writeInt(1);
        paramAdRequestParcel.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        localParcel1.writeString(paramString);
        this.a.transact(11, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      if (paramAdRequestParcel != null)
      {
        localParcel1.writeInt(1);
        paramAdRequestParcel.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.a.transact(20, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final IBinder asBinder()
  {
    return this.a;
  }

  public final void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void f()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final boolean g()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      int j = 0;
      if (i != 0)
        j = 1;
      return j;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final ey h()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ey localey = ez.a(localParcel2.readStrongBinder());
      return localey;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final eB i()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(16, localParcel1, localParcel2, 0);
      localParcel2.readException();
      eB localeB = eC.a(localParcel2.readStrongBinder());
      return localeB;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Bundle j()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
        return localBundle;
      }
      Bundle localBundle = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final Bundle k()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(18, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
        return localBundle;
      }
      Bundle localBundle = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final Bundle l()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(19, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
        return localBundle;
      }
      Bundle localBundle = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.eq
 * JD-Core Version:    0.6.0
 */