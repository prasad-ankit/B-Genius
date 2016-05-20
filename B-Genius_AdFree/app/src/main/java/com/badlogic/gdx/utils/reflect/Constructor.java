package com.badlogic.gdx.utils.reflect;

import java.lang.reflect.InvocationTargetException;

public final class Constructor
{
  private final java.lang.reflect.Constructor constructor;

  Constructor(java.lang.reflect.Constructor paramConstructor)
  {
    this.constructor = paramConstructor;
  }

  public final Class getDeclaringClass()
  {
    return this.constructor.getDeclaringClass();
  }

  public final Class[] getParameterTypes()
  {
    return this.constructor.getParameterTypes();
  }

  public final boolean isAccessible()
  {
    return this.constructor.isAccessible();
  }

  public final Object newInstance(Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = this.constructor.newInstance(paramArrayOfObject);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ReflectionException("Illegal argument(s) supplied to constructor for class: " + getDeclaringClass().getName(), localIllegalArgumentException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new ReflectionException("Could not instantiate instance of class: " + getDeclaringClass().getName(), localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ReflectionException("Could not instantiate instance of class: " + getDeclaringClass().getName(), localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new ReflectionException("Exception occurred in constructor for class: " + getDeclaringClass().getName(), localInvocationTargetException);
  }

  public final void setAccessible(boolean paramBoolean)
  {
    this.constructor.setAccessible(paramBoolean);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.reflect.Constructor
 * JD-Core Version:    0.6.0
 */