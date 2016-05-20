package com.google.ads.mediation;

import com.google.android.gms.b.hc;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class n
{
  public final void a(Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    for (Field localField3 : getClass().getFields())
    {
      p localp = (p)localField3.getAnnotation(p.class);
      if (localp == null)
        continue;
      localHashMap.put(localp.a(), localField3);
    }
    if (localHashMap.isEmpty())
      hc.d("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Field localField2 = (Field)localHashMap.remove(localEntry.getKey());
      if (localField2 != null)
      {
        try
        {
          localField2.set(this, localEntry.getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          hc.d("Server option \"" + (String)localEntry.getKey() + "\" could not be set: Illegal Access");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          hc.d("Server option \"" + (String)localEntry.getKey() + "\" could not be set: Bad Type");
        }
        continue;
      }
      hc.a("Unexpected server option: " + (String)localEntry.getKey() + " = \"" + (String)localEntry.getValue() + "\"");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator2 = localHashMap.values().iterator();
    while (localIterator2.hasNext())
    {
      Field localField1 = (Field)localIterator2.next();
      if (!((p)localField1.getAnnotation(p.class)).b())
        continue;
      hc.d("Required server option missing: " + ((p)localField1.getAnnotation(p.class)).a());
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(((p)localField1.getAnnotation(p.class)).a());
    }
    if (localStringBuilder.length() > 0)
      throw new o("Required server option(s) missing: " + localStringBuilder.toString());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.n
 * JD-Core Version:    0.6.0
 */