package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.e;
import java.util.ArrayList;
import java.util.Iterator;

final class s extends w
{
  private final ArrayList a;

  public s(n paramn, ArrayList paramArrayList)
  {
    super(paramn, 0);
    this.a = paramArrayList;
  }

  public final void a()
  {
    n.d(this.b).d.b = n.g(this.b);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((e)localIterator.next()).a(n.h(this.b), n.d(this.b).d.b);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.s
 * JD-Core Version:    0.6.0
 */