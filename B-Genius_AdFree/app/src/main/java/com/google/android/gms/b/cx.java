package com.google.android.gms.b;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.k;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v;

public final class cx
{
  private MutableContextWrapper a;
  private final el b;
  private final VersionInfoParcel c;
  private final k d;

  cx(Context paramContext, el paramel, VersionInfoParcel paramVersionInfoParcel, k paramk)
  {
    this.a = new MutableContextWrapper(paramContext.getApplicationContext());
    this.b = paramel;
    this.c = paramVersionInfoParcel;
    this.d = paramk;
  }

  public final v a(String paramString)
  {
    return new v(this.a, new AdSizeParcel(), paramString, this.b, this.c, this.d);
  }

  public final cx a()
  {
    return new cx(this.a.getBaseContext(), this.b, this.c, this.d);
  }

  public final MutableContextWrapper b()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cx
 * JD-Core Version:    0.6.0
 */