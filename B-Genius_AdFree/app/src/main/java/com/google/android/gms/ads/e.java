package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.c;
import java.util.Date;

public final class e
{
  private final c a = new c();

  public e()
  {
    this.a.b(d.a);
  }

  public final d a()
  {
    return new d(this, 0);
  }

  public final e a(int paramInt)
  {
    this.a.a(paramInt);
    return this;
  }

  public final e a(Location paramLocation)
  {
    this.a.a(paramLocation);
    return this;
  }

  public final e a(Class paramClass, Bundle paramBundle)
  {
    this.a.a(paramClass, paramBundle);
    if ((paramClass.equals(AdMobAdapter.class)) && (paramBundle.getBoolean("_emulatorLiveAds")))
      this.a.c(d.a);
    return this;
  }

  public final e a(String paramString)
  {
    this.a.a(paramString);
    return this;
  }

  public final e a(Date paramDate)
  {
    this.a.a(paramDate);
    return this;
  }

  public final e a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
    return this;
  }

  public final e b(String paramString)
  {
    this.a.b(paramString);
    return this;
  }

  public final e b(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.e
 * JD-Core Version:    0.6.0
 */