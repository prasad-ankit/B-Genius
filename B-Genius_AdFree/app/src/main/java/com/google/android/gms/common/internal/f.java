package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.b.kh;
import com.google.android.gms.common.api.a;
import com.google.android.gms.drive.e;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class f
{
  private final Account a;
  private final Set b;
  private final Set c;
  private final Map d;
  private final int e;
  private final View f;
  private final String g;
  private final String h;
  private final kh i;
  private Integer j;

  public f(Account paramAccount, Set paramSet, Map paramMap, int paramInt, View paramView, String paramString1, String paramString2, kh paramkh)
  {
    this.a = paramAccount;
    if (paramSet == null);
    HashSet localHashSet;
    for (Set localSet = Collections.EMPTY_SET; ; localSet = Collections.unmodifiableSet(paramSet))
    {
      this.b = localSet;
      if (paramMap == null)
        paramMap = Collections.EMPTY_MAP;
      this.d = paramMap;
      this.f = paramView;
      this.e = paramInt;
      this.g = paramString1;
      this.h = paramString2;
      this.i = paramkh;
      localHashSet = new HashSet(this.b);
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
        localHashSet.addAll(((e)localIterator.next()).a);
    }
    this.c = Collections.unmodifiableSet(localHashSet);
  }

  public static Q a(Object paramObject)
  {
    return new Q(paramObject, 0);
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public final Account a()
  {
    return this.a;
  }

  public final Set a(a parama)
  {
    e locale = (e)this.d.get(parama);
    if ((locale == null) || (locale.a.isEmpty()))
      return this.b;
    HashSet localHashSet = new HashSet(this.b);
    localHashSet.addAll(locale.a);
    return localHashSet;
  }

  public final void a(Integer paramInteger)
  {
    this.j = paramInteger;
  }

  public final Account b()
  {
    if (this.a != null)
      return this.a;
    return new Account("<<default account>>", "com.google");
  }

  public final int c()
  {
    return this.e;
  }

  public final Set d()
  {
    return this.b;
  }

  public final Set e()
  {
    return this.c;
  }

  public final Map f()
  {
    return this.d;
  }

  public final String g()
  {
    return this.g;
  }

  public final String h()
  {
    return this.h;
  }

  public final View i()
  {
    return this.f;
  }

  public final kh j()
  {
    return this.i;
  }

  public final Integer k()
  {
    return this.j;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.f
 * JD-Core Version:    0.6.0
 */