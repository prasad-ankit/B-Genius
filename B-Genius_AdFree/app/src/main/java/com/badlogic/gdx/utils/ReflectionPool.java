package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Constructor;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class ReflectionPool extends Pool
{
  private final Constructor constructor = findConstructor(paramClass);

  public ReflectionPool(Class paramClass)
  {
    this(paramClass, 16, 2147483647);
  }

  public ReflectionPool(Class paramClass, int paramInt)
  {
    this(paramClass, paramInt, 2147483647);
  }

  public ReflectionPool(Class paramClass, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    if (this.constructor == null)
      throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + paramClass.getName());
  }

  private Constructor findConstructor(Class paramClass)
  {
    try
    {
      Constructor localConstructor2 = ClassReflection.getConstructor(paramClass, null);
      return localConstructor2;
    }
    catch (Exception localException)
    {
      try
      {
        Constructor localConstructor1 = ClassReflection.getDeclaredConstructor(paramClass, null);
        localConstructor1.setAccessible(true);
        return localConstructor1;
      }
      catch (ReflectionException localReflectionException)
      {
      }
    }
    return null;
  }

  protected Object newObject()
  {
    try
    {
      Object localObject = this.constructor.newInstance(null);
      return localObject;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Unable to create new instance: " + this.constructor.getDeclaringClass().getName(), localException);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ReflectionPool
 * JD-Core Version:    0.6.0
 */