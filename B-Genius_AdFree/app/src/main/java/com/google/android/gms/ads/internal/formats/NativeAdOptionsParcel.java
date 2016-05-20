package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.b.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class NativeAdOptionsParcel
  implements SafeParcelable
{
  public static final i CREATOR = new i();
  public final int a;
  public final boolean b;
  public final int c;
  public final boolean d;

  public NativeAdOptionsParcel(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    this.a = paramInt1;
    this.b = paramBoolean1;
    this.c = paramInt2;
    this.d = paramBoolean2;
  }

  public NativeAdOptionsParcel(c paramc)
  {
    this(1, paramc.a(), paramc.b(), paramc.c());
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel
 * JD-Core Version:    0.6.0
 */