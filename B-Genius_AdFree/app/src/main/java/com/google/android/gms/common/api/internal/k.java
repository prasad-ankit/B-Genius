package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class k
  implements G
{
  private final H a;
  private boolean b = false;

  public k(H paramH)
  {
    this.a = paramH;
  }

  public final b a(b paramb)
  {
    return b(paramb);
  }

  public final void a()
  {
  }

  public final void a(int paramInt)
  {
    this.a.a(null);
    this.a.e.a(paramInt, this.b);
  }

  public final void a(Bundle paramBundle)
  {
  }

  public final void a(ConnectionResult paramConnectionResult, a parama, int paramInt)
  {
  }

  public final b b(b paramb)
  {
    try
    {
      this.a.d.a(paramb);
      e locale = this.a.d.a(paramb.b());
      if ((!locale.e()) && (this.a.b.containsKey(paramb.b())))
      {
        paramb.a(new Status(17));
        return paramb;
      }
      paramb.a(locale);
      return paramb;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      this.a.a(new l(this, this));
    }
    return paramb;
  }

  public final boolean b()
  {
    if (this.b)
      return false;
    if (this.a.d.g())
    {
      this.b = true;
      Iterator localIterator = this.a.d.d.iterator();
      while (localIterator.hasNext())
        ((R)localIterator.next()).b();
      return false;
    }
    this.a.a(null);
    return true;
  }

  public final void c()
  {
    if (this.b)
    {
      this.b = false;
      this.a.a(new m(this, this));
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.k
 * JD-Core Version:    0.6.0
 */