package com.google.android.gms.common.api.internal;

import com.google.android.gms.b.kg;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class q extends w
{
  private final Map b;

  public q(n paramn, Map paramMap)
  {
    super(paramn, 0);
    this.b = paramMap;
  }

  public final void a()
  {
    int i = n.b(this.a).a(n.a(this.a));
    if (i != 0)
    {
      ConnectionResult localConnectionResult = new ConnectionResult(i, null);
      n.d(this.a).a(new r(this, this.a, localConnectionResult));
    }
    while (true)
    {
      return;
      if (n.e(this.a))
        n.f(this.a).i();
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        locale.a((l)this.b.get(locale));
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.q
 * JD-Core Version:    0.6.0
 */