package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

public final class du
{
  private final Object a = new Object();
  private final Context b;
  private final String c;
  private final VersionInfoParcel d;
  private dG e;
  private dG f;
  private dM g;
  private int h = 1;

  public du(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString)
  {
    this.c = paramString;
    this.b = paramContext.getApplicationContext();
    this.d = paramVersionInfoParcel;
    this.e = new dH();
    this.f = new dH();
  }

  public du(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString, dG paramdG1, dG paramdG2)
  {
    this(paramContext, paramVersionInfoParcel, paramString);
    this.e = paramdG1;
    this.f = paramdG2;
  }

  protected final dM a()
  {
    dM localdM = new dM(this.f);
    hu.a(new dv(this, localdM));
    localdM.a(new dD(this, localdM), new dE(this, localdM));
    return localdM;
  }

  public final dI b()
  {
    synchronized (this.a)
    {
      if ((this.g == null) || (this.g.e() == -1))
      {
        this.h = 2;
        this.g = a();
        dI localdI1 = this.g.a();
        return localdI1;
      }
      if (this.h == 0)
      {
        dI localdI5 = this.g.a();
        return localdI5;
      }
    }
    if (this.h == 1)
    {
      this.h = 2;
      a();
      dI localdI4 = this.g.a();
      monitorexit;
      return localdI4;
    }
    if (this.h == 2)
    {
      dI localdI3 = this.g.a();
      monitorexit;
      return localdI3;
    }
    dI localdI2 = this.g.a();
    monitorexit;
    return localdI2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.du
 * JD-Core Version:    0.6.0
 */