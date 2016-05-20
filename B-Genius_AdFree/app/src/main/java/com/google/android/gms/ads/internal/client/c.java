package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class c
{
  private final HashSet a = new HashSet();
  private final Bundle b = new Bundle();
  private final HashMap c = new HashMap();
  private final HashSet d = new HashSet();
  private final Bundle e = new Bundle();
  private final HashSet f = new HashSet();
  private Date g;
  private int h = -1;
  private Location i;
  private boolean j = false;
  private int k = -1;
  private boolean l;

  public final void a(int paramInt)
  {
    this.h = paramInt;
  }

  public final void a(Location paramLocation)
  {
    this.i = paramLocation;
  }

  public final void a(Class paramClass, Bundle paramBundle)
  {
    this.b.putBundle(paramClass.getName(), paramBundle);
  }

  public final void a(String paramString)
  {
    this.a.add(paramString);
  }

  public final void a(Date paramDate)
  {
    this.g = paramDate;
  }

  public final void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int m = 1; ; m = 0)
    {
      this.k = m;
      return;
    }
  }

  public final void b(String paramString)
  {
    this.d.add(paramString);
  }

  public final void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public final void c(String paramString)
  {
    this.d.remove(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.c
 * JD-Core Version:    0.6.0
 */