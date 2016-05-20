package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.v4.app.w;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;

public final class f
  implements j, k
{
  public final a a;
  private final int b;
  private H c;

  public f(a parama, int paramInt)
  {
    this.a = parama;
    this.b = paramInt;
  }

  private void a()
  {
    w.a(this.c, "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
  }

  public final void a(int paramInt)
  {
    a();
    this.c.a(paramInt);
  }

  public final void a(Bundle paramBundle)
  {
    a();
    this.c.a(paramBundle);
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    a();
    this.c.a(paramConnectionResult, this.a, this.b);
  }

  public final void a(H paramH)
  {
    this.c = paramH;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.f
 * JD-Core Version:    0.6.0
 */