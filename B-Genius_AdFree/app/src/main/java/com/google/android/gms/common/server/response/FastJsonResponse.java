package com.google.android.gms.common.server.response;

import android.support.v4.app.j;
import android.support.v4.app.w;
import com.google.android.gms.b.jy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class FastJsonResponse
{
  protected static Object a(FastJsonResponse.Field paramField, Object paramObject)
  {
    if (FastJsonResponse.Field.a(paramField) != null)
      paramObject = paramField.a(paramObject);
    return paramObject;
  }

  private static void a(StringBuilder paramStringBuilder, FastJsonResponse.Field paramField, Object paramObject)
  {
    if (paramField.b() == 11)
    {
      paramStringBuilder.append(((FastJsonResponse)paramField.h().cast(paramObject)).toString());
      return;
    }
    if (paramField.b() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(jy.a((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }

  private void a(StringBuilder paramStringBuilder, FastJsonResponse.Field paramField, ArrayList paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      if (i > 0)
        paramStringBuilder.append(",");
      Object localObject = paramArrayList.get(i);
      if (localObject != null)
        a(paramStringBuilder, paramField, localObject);
      i++;
    }
    paramStringBuilder.append("]");
  }

  public abstract Map a();

  protected boolean a(FastJsonResponse.Field paramField)
  {
    if (paramField.d() == 11)
    {
      if (paramField.e())
      {
        paramField.f();
        throw new UnsupportedOperationException("Concrete type arrays not supported");
      }
      paramField.f();
      throw new UnsupportedOperationException("Concrete types not supported");
    }
    paramField.f();
    return i_();
  }

  protected abstract Object b();

  protected Object b(FastJsonResponse.Field paramField)
  {
    String str1 = paramField.f();
    if (paramField.h() != null)
    {
      paramField.f();
      b();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramField.f();
      w.a(true, "Concrete field shouldn't be value object: %s", arrayOfObject);
      paramField.e();
      try
      {
        String str2 = "get" + Character.toUpperCase(str1.charAt(0)) + str1.substring(1);
        Object localObject = getClass().getMethod(str2, new Class[0]).invoke(this, new Object[0]);
        return localObject;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    paramField.f();
    return b();
  }

  protected abstract boolean i_();

  public String toString()
  {
    Map localMap = a();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localMap.get(str);
      if (!a(localField))
        continue;
      Object localObject = a(localField, b(localField));
      if (localStringBuilder.length() == 0)
        localStringBuilder.append("{");
      while (true)
      {
        localStringBuilder.append("\"").append(str).append("\":");
        if (localObject != null)
          break label138;
        localStringBuilder.append("null");
        break;
        localStringBuilder.append(",");
      }
      label138: switch (localField.d())
      {
      default:
        if (localField.c())
          a(localStringBuilder, localField, (ArrayList)localObject);
        break;
      case 8:
        localStringBuilder.append("\"").append(j.a((byte[])localObject)).append("\"");
        break;
      case 9:
        localStringBuilder.append("\"").append(j.b((byte[])localObject)).append("\"");
        break;
      case 10:
        j.a(localStringBuilder, (HashMap)localObject);
        continue;
        a(localStringBuilder, localField, localObject);
      }
    }
    if (localStringBuilder.length() > 0)
      localStringBuilder.append("}");
    while (true)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastJsonResponse
 * JD-Core Version:    0.6.0
 */