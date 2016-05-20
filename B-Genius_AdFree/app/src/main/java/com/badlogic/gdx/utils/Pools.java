package com.badlogic.gdx.utils;

public class Pools
{
  private static final ObjectMap typePools = new ObjectMap();

  public static void free(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("Object cannot be null.");
    Pool localPool = (Pool)typePools.get(paramObject.getClass());
    if (localPool == null)
      return;
    localPool.free(paramObject);
  }

  public static void freeAll(Array paramArray)
  {
    freeAll(paramArray, false);
  }

  public static void freeAll(Array paramArray, boolean paramBoolean)
  {
    if (paramArray == null)
      throw new IllegalArgumentException("Objects cannot be null.");
    int i = paramArray.size;
    int j = 0;
    Pool localPool = null;
    while (j < i)
    {
      Object localObject = paramArray.get(j);
      if (localObject != null)
        if (localPool == null)
        {
          localPool = (Pool)typePools.get(localObject.getClass());
          if (localPool == null);
        }
        else
        {
          localPool.free(localObject);
          if (!paramBoolean)
            localPool = null;
        }
      j++;
    }
  }

  public static Pool get(Class paramClass)
  {
    return get(paramClass, 100);
  }

  public static Pool get(Class paramClass, int paramInt)
  {
    Object localObject = (Pool)typePools.get(paramClass);
    if (localObject == null)
    {
      localObject = new ReflectionPool(paramClass, 4, paramInt);
      typePools.put(paramClass, localObject);
    }
    return (Pool)localObject;
  }

  public static Object obtain(Class paramClass)
  {
    return get(paramClass).obtain();
  }

  public static void set(Class paramClass, Pool paramPool)
  {
    typePools.put(paramClass, paramPool);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Pools
 * JD-Core Version:    0.6.0
 */