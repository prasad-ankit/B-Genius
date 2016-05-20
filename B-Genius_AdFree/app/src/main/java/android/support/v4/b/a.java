package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a extends k
  implements Map
{
  private e c;

  public a()
  {
  }

  public a(int paramInt)
  {
    super(paramInt);
  }

  private e a()
  {
    if (this.c == null)
      this.c = new b(this);
    return this.c;
  }

  public final boolean a(Collection paramCollection)
  {
    return e.a(this, paramCollection);
  }

  public Set entrySet()
  {
    e locale = a();
    if (locale.a == null)
      locale.a = new g(locale);
    return locale.a;
  }

  public Set keySet()
  {
    e locale = a();
    if (locale.b == null)
      locale.b = new h(locale);
    return locale.b;
  }

  public void putAll(Map paramMap)
  {
    a(this.b + paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }

  public Collection values()
  {
    e locale = a();
    if (locale.c == null)
      locale.c = new j(locale);
    return locale.c;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.b.a
 * JD-Core Version:    0.6.0
 */