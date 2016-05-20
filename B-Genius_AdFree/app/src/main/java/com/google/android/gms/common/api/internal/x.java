package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public final class x
  implements G
{
  private final H a;

  public x(H paramH)
  {
    this.a = paramH;
  }

  public final b a(b paramb)
  {
    this.a.d.a.add(paramb);
    return paramb;
  }

  public final void a()
  {
    Iterator localIterator = this.a.a.values().iterator();
    while (localIterator.hasNext())
      ((e)localIterator.next()).d();
    this.a.d.b = Collections.emptySet();
  }

  public final void a(int paramInt)
  {
  }

  public final void a(Bundle paramBundle)
  {
  }

  public final void a(ConnectionResult paramConnectionResult, a parama, int paramInt)
  {
  }

  public final b b(b paramb)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }

  public final boolean b()
  {
    return true;
  }

  public final void c()
  {
    this.a.d();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.x
 * JD-Core Version:    0.6.0
 */