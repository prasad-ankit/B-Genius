package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.b.fq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GInAppPurchaseManagerInfoParcel
  implements SafeParcelable
{
  public static final a CREATOR = new a();
  public final int a;
  public final n b;
  public final fq c;
  public final Context d;
  public final m e;

  GInAppPurchaseManagerInfoParcel(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4)
  {
    this.a = paramInt;
    this.b = ((n)d.a(b.a(paramIBinder1)));
    this.c = ((fq)d.a(b.a(paramIBinder2)));
    this.d = ((Context)d.a(b.a(paramIBinder3)));
    this.e = ((m)d.a(b.a(paramIBinder4)));
  }

  public GInAppPurchaseManagerInfoParcel(Context paramContext, n paramn, fq paramfq, m paramm)
  {
    this.a = 2;
    this.d = paramContext;
    this.b = paramn;
    this.c = paramfq;
    this.e = paramm;
  }

  public static GInAppPurchaseManagerInfoParcel a(Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      localBundle.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
      GInAppPurchaseManagerInfoParcel localGInAppPurchaseManagerInfoParcel = (GInAppPurchaseManagerInfoParcel)localBundle.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      return localGInAppPurchaseManagerInfoParcel;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static void a(Intent paramIntent, GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramGInAppPurchaseManagerInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel
 * JD-Core Version:    0.6.0
 */