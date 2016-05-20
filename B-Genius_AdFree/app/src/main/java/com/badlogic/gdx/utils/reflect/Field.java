package com.badlogic.gdx.utils.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class Field
{
  private final java.lang.reflect.Field field;

  Field(java.lang.reflect.Field paramField)
  {
    this.field = paramField;
  }

  public final Object get(Object paramObject)
  {
    try
    {
      Object localObject = this.field.get(paramObject);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ReflectionException("Object is not an instance of " + getDeclaringClass(), localIllegalArgumentException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new ReflectionException("Illegal access to field: " + getName(), localIllegalAccessException);
  }

  public final Annotation getDeclaredAnnotation(Class paramClass)
  {
    java.lang.annotation.Annotation[] arrayOfAnnotation = this.field.getDeclaredAnnotations();
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
    java.lang.annotation.Annotation[] arrayOfAnnotation = this.field.getDeclaredAnnotations();
    Annotation[] arrayOfAnnotation1 = new Annotation[arrayOfAnnotation.length];
    for (int i = 0; i < arrayOfAnnotation.length; i++)
      arrayOfAnnotation1[i] = new Annotation(arrayOfAnnotation[i]);
    return arrayOfAnnotation1;
  }

  public final Class getDeclaringClass()
  {
    return this.field.getDeclaringClass();
  }

  public final Class getElementType(int paramInt)
  {
    Type localType1 = this.field.getGenericType();
    if ((localType1 instanceof ParameterizedType))
    {
      Type[] arrayOfType = ((ParameterizedType)localType1).getActualTypeArguments();
      if (-1 + arrayOfType.length >= paramInt)
      {
        Type localType2 = arrayOfType[paramInt];
        if ((localType2 instanceof Class))
          return (Class)localType2;
        if ((localType2 instanceof ParameterizedType))
          return (Class)((ParameterizedType)localType2).getRawType();
        if ((localType2 instanceof GenericArrayType))
        {
          Type localType3 = ((GenericArrayType)localType2).getGenericComponentType();
          if ((localType3 instanceof Class))
            return ArrayReflection.newInstance((Class)localType3, 0).getClass();
        }
      }
    }
    return null;
  }

  public final String getName()
  {
    return this.field.getName();
  }

  public final Class getType()
  {
    return this.field.getType();
  }

  public final boolean isAccessible()
  {
    return this.field.isAccessible();
  }

  public final boolean isAnnotationPresent(Class paramClass)
  {
    return this.field.isAnnotationPresent(paramClass);
  }

  public final boolean isDefaultAccess()
  {
    return (!isPrivate()) && (!isProtected()) && (!isPublic());
  }

  public final boolean isFinal()
  {
    return Modifier.isFinal(this.field.getModifiers());
  }

  public final boolean isPrivate()
  {
    return Modifier.isPrivate(this.field.getModifiers());
  }

  public final boolean isProtected()
  {
    return Modifier.isProtected(this.field.getModifiers());
  }

  public final boolean isPublic()
  {
    return Modifier.isPublic(this.field.getModifiers());
  }

  public final boolean isStatic()
  {
    return Modifier.isStatic(this.field.getModifiers());
  }

  public final boolean isSynthetic()
  {
    return this.field.isSynthetic();
  }

  public final boolean isTransient()
  {
    return Modifier.isTransient(this.field.getModifiers());
  }

  public final boolean isVolatile()
  {
    return Modifier.isVolatile(this.field.getModifiers());
  }

  public final void set(Object paramObject1, Object paramObject2)
  {
    try
    {
      this.field.set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ReflectionException("Argument not valid for field: " + getName(), localIllegalArgumentException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new ReflectionException("Illegal access to field: " + getName(), localIllegalAccessException);
  }

  public final void setAccessible(boolean paramBoolean)
  {
    this.field.setAccessible(paramBoolean);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.reflect.Field
 * JD-Core Version:    0.6.0
 */