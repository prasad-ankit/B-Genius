package com.google.android.gms.b;

import com.google.android.gms.ads.internal.P;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class az
{
  private final Collection a = new ArrayList();
  private final Collection b = new ArrayList();
  private final Collection c = new ArrayList();

  public final List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      String str = (String)P.n().a(localau);
      if (str == null)
        continue;
      localArrayList.add(str);
    }
    return localArrayList;
  }

  public final void a(au paramau)
  {
    this.a.add(paramau);
  }

  public final List b()
  {
    List localList = a();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      String str = (String)P.n().a(localau);
      if (str == null)
        continue;
      localList.add(str);
    }
    return localList;
  }

  public final void b(au paramau)
  {
    this.b.add(paramau);
  }

  public final void c(au paramau)
  {
    this.c.add(paramau);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.az
 * JD-Core Version:    0.6.0
 */