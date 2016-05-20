package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.util.client.a;

public final class f
{
  public static final f a = new f(320, 50, "320x50_mb");
  public static final f b = new f(468, 60, "468x60_as");
  public static final f c = new f(320, 100, "320x100_as");
  public static final f d = new f(728, 90, "728x90_as");
  public static final f e = new f(300, 250, "300x250_as");
  public static final f f = new f(160, 600, "160x600_as");
  public static final f g = new f(-1, -2, "smart_banner");
  public static final f h = new f(-3, -4, "fluid");
  private final int i;
  private final int j;
  private final String k;

  public f(int paramInt1, int paramInt2)
  {
  }

  f(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1) && (paramInt1 != -3))
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    if ((paramInt2 < 0) && (paramInt2 != -2) && (paramInt2 != -4))
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramString;
  }

  public final int a()
  {
    return this.j;
  }

  public final int a(Context paramContext)
  {
    switch (this.j)
    {
    default:
      return x.a().a(paramContext, this.j);
    case -2:
      return AdSizeParcel.b(paramContext.getResources().getDisplayMetrics());
    case -4:
    case -3:
    }
    return -1;
  }

  public final int b()
  {
    return this.i;
  }

  public final int b(Context paramContext)
  {
    switch (this.i)
    {
    case -2:
    default:
      return x.a().a(paramContext, this.i);
    case -1:
      return AdSizeParcel.a(paramContext.getResources().getDisplayMetrics());
    case -4:
    case -3:
    }
    return -1;
  }

  public final boolean c()
  {
    return (this.i == -3) && (this.j == -4);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    f localf;
    do
    {
      return true;
      if (!(paramObject instanceof f))
        return false;
      localf = (f)paramObject;
    }
    while ((this.i == localf.i) && (this.j == localf.j) && (this.k.equals(localf.k)));
    return false;
  }

  public final int hashCode()
  {
    return this.k.hashCode();
  }

  public final String toString()
  {
    return this.k;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.f
 * JD-Core Version:    0.6.0
 */