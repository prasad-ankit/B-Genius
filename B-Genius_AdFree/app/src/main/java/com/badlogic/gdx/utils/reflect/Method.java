package com.badlogic.gdx.utils.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public final class Method
{
  private final java.lang.reflect.Method method;

  Method(java.lang.reflect.Method paramMethod)
  {
    this.method = paramMethod;
  }

  public final Annotation getDeclaredAnnotation(Class paramClass)
  {
    java.lang.annotation.Annotation[] arrayOfAnnotation = this.method.getDeclaredAnnotations();
    if (arrayOfAnnotation == null);
    while (true)
    {
      return null;
      int i = arrayOfAnnotation.length;
      for (int j = 0; j < i; j++)
      {
        java.lang.annotation.Annotation localAnnotation = arrayOfAnnotation[j];
        if (localAnnotation.annotationType().equals(paramClass))
          return new Annotation(localAnnotation);
      }
    }
  }

  public final Annotation[] getDeclaredAnnotations()
  {
    java.lang.annotation.Annotation[] arrayOfAnnotation = this.method.getDeclaredAnnotations();
    Annotation[] arrayOfAnnotation1 = new Annotation[arrayOfAnnotation.length];
    for (int i = 0; i < arrayOfAnnotation.length; i++)
      arrayOfAnnotation1[i] = new Annotation(arrayOfAnnotation[i]);
    return arrayOfAnnotation1;
  }

  public final Class getDeclaringClass()
  {
    return this.method.getDeclaringClass();
  }

  public final String getName()
  {
    return this.method.getName();
  }

  public final Class[] getParameterTypes()
  {
    return this.method.getParameterTypes();
  }

  public final Class getReturnType()
  {
    return this.method.getReturnType();
  }

  public final Object invoke(Object paramObject, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = this.method.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ReflectionException("Illegal argument(s) supplied to method: " + getName(), localIllegalArgumentException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ReflectionException("Illegal access to method: " + getName(), localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new ReflectionException("Exception occurred in method: " + getName(), localInvocationTargetException);
  }

  public final boolean isAbstract()
  {
    return Modifier.isAbstract(this.method.getModifiers());
  }

  public final boolean isAccessible()
  {
    return this.method.isAccessible();
  }

  public final boolean isAnnotationPresent(Class paramClass)
  {
    return this.method.isAnnotationPresent(paramClass);
  }

  public final boolean isDefaultAccess()
  {
    return (!isPrivate()) && (!isProtected()) && (!isPublic());
  }

  public final boolean isFinal()
  {
    return Modifier.isFinal(this.method.getModifiers());
  }

  public final boolean isNative()
  {
    return Modifier.isNative(this.method.getModifiers());
  }

  public final boolean isPrivate()
  {
    return Modifier.isPrivate(this.method.getModifiers());
  }

  public final boolean isProtected()
  {
    return Modifier.isProtected(this.method.getModifiers());
  }

  public final boolean isPublic()
  {
    return Modifier.isPublic(this.method.getModifiers());
  }

  public final boolean isStatic()
  {
    return Modifier.isStatic(this.method.getModifiers());
  }

  public final boolean isVarArgs()
  {
    return this.method.isVarArgs();
  }

  public final void setAccessible(boolean paramBoolean)
  {
    this.method.setAccessible(paramBoolean);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.reflect.Method
 * JD-Core Version:    0.6.0
 */