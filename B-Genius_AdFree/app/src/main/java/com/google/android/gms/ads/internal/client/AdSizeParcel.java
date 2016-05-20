package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AdSizeParcel
  implements SafeParcelable
{
  public static final t CREATOR = new t();
  public final int a;
  public final String b;
  public final int c;
  public final int d;
  public final boolean e;
  public final int f;
  public final int g;
  public final AdSizeParcel[] h;
  public final boolean i;
  public final boolean j;
  public boolean k;

  public AdSizeParcel()
  {
    this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
  }

  AdSizeParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, AdSizeParcel[] paramArrayOfAdSizeParcel, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramBoolean1;
    this.f = paramInt4;
    this.g = paramInt5;
    this.h = paramArrayOfAdSizeParcel;
    this.i = paramBoolean2;
    this.j = paramBoolean3;
    this.k = paramBoolean4;
  }

  public AdSizeParcel(Context paramContext, f paramf)
  {
    this(paramContext, new f[] { paramf });
  }

  public AdSizeParcel(Context paramContext, f[] paramArrayOff)
  {
    f localf = paramArrayOff[0];
    this.a = 5;
    this.e = false;
    this.j = localf.c();
    int m;
    label64: int n;
    label76: DisplayMetrics localDisplayMetrics;
    label134: int i2;
    label174: int i3;
    if (this.j)
    {
      this.f = f.a.b();
      this.c = f.a.a();
      if (this.f != -1)
        break label314;
      m = 1;
      if (this.c != -2)
        break label320;
      n = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (m == 0)
        break label338;
      x.a();
      if (!a.c(paramContext))
        break label326;
      x.a();
      if (!a.d(paramContext))
        break label326;
      int i6 = localDisplayMetrics.widthPixels;
      x.a();
      this.g = (i6 - a.e(paramContext));
      double d1 = this.g / localDisplayMetrics.density;
      int i5 = (int)d1;
      if (d1 - (int)d1 >= 0.01D)
        i5++;
      i2 = i5;
      if (n == 0)
        break label368;
      i3 = c(localDisplayMetrics);
      label186: x.a();
      this.d = a.a(localDisplayMetrics, i3);
      if ((m == 0) && (n == 0))
        break label377;
      this.b = (i2 + "x" + i3 + "_as");
    }
    while (true)
    {
      if (paramArrayOff.length <= 1)
        break label404;
      this.h = new AdSizeParcel[paramArrayOff.length];
      for (int i4 = 0; i4 < paramArrayOff.length; i4++)
        this.h[i4] = new AdSizeParcel(paramContext, paramArrayOff[i4]);
      this.f = localf.b();
      this.c = localf.a();
      break;
      label314: m = 0;
      break label64;
      label320: n = 0;
      break label76;
      label326: this.g = localDisplayMetrics.widthPixels;
      break label134;
      label338: int i1 = this.f;
      x.a();
      this.g = a.a(localDisplayMetrics, this.f);
      i2 = i1;
      break label174;
      label368: i3 = this.c;
      break label186;
      label377: if (this.j)
      {
        this.b = "320x50_mb";
        continue;
      }
      this.b = localf.toString();
    }
    label404: this.h = null;
    this.i = false;
    this.k = false;
  }

  public AdSizeParcel(AdSizeParcel paramAdSizeParcel, AdSizeParcel[] paramArrayOfAdSizeParcel)
  {
    this(5, paramAdSizeParcel.b, paramAdSizeParcel.c, paramAdSizeParcel.d, paramAdSizeParcel.e, paramAdSizeParcel.f, paramAdSizeParcel.g, paramArrayOfAdSizeParcel, paramAdSizeParcel.i, paramAdSizeParcel.j, paramAdSizeParcel.k);
  }

  public static int a(DisplayMetrics paramDisplayMetrics)
  {
    return paramDisplayMetrics.widthPixels;
  }

  public static AdSizeParcel a()
  {
    return new AdSizeParcel(5, "320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
  }

  public static int b(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(c(paramDisplayMetrics) * paramDisplayMetrics.density);
  }

  public static AdSizeParcel b()
  {
    return new AdSizeParcel(5, "reward_mb", 0, 0, true, 0, 0, null, false, false, false);
  }

  private static int c(DisplayMetrics paramDisplayMetrics)
  {
    int m = (int)(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density);
    if (m <= 400)
      return 32;
    if (m <= 720)
      return 50;
    return 90;
  }

  public final f c()
  {
    return c.a(this.f, this.c, this.b);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    t.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.AdSizeParcel
 * JD-Core Version:    0.6.0
 */