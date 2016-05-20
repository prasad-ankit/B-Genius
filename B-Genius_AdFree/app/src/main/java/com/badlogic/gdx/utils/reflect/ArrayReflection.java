package com.badlogic.gdx.utils.reflect;

import java.lang.reflect.Array;

public final class ArrayReflection
{
  public static Object get(Object paramObject, int paramInt)
  {
    return Array.get(paramObject, paramInt);
  }

  public static int getLength(Object paramObject)
  {
    return Array.getLength(paramObject);
  }

  public static Object newInstance(Class paramClass, int paramInt)
  {
    return Array.newInstance(paramClass, paramInt);
  }

  public static void set(Object paramObject1, int paramInt, Object paramObject2)
  {
    Array.set(paramObject1, paramInt, paramObject2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.reflect.ArrayReflection
 * JD-Core Version:    0.6.0
 */