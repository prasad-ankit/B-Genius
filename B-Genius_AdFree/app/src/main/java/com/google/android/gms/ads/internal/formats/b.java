package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.b.ba;

public final class b extends ba
{
  private final Drawable a;
  private final Uri b;
  private final double c;

  public b(Drawable paramDrawable, Uri paramUri, double paramDouble)
  {
    this.a = paramDrawable;
    this.b = paramUri;
    this.c = paramDouble;
  }

  public final a a()
  {
    return d.a(this.a);
  }

  public final Uri b()
  {
    return this.b;
  }

  public final double c()
  {
    return this.c;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.formats.b
 * JD-Core Version:    0.6.0
 */