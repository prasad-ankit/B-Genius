package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.support.v4.app.j;

public class ThinAdSizeParcel extends AdSizeParcel
{
  public ThinAdSizeParcel(AdSizeParcel paramAdSizeParcel)
  {
    super(paramAdSizeParcel.a, paramAdSizeParcel.b, paramAdSizeParcel.c, paramAdSizeParcel.d, paramAdSizeParcel.e, paramAdSizeParcel.f, paramAdSizeParcel.g, paramAdSizeParcel.h, paramAdSizeParcel.i, paramAdSizeParcel.j, paramAdSizeParcel.k);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, this.a);
    j.a(paramParcel, 2, this.b, false);
    j.a(paramParcel, 3, this.c);
    j.a(paramParcel, 6, this.f);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.ThinAdSizeParcel
 * JD-Core Version:    0.6.0
 */