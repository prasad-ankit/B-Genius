package com.badlogic.gdx.utils.reflect;

import java.lang.reflect.Modifier;

public final class ClassReflection
{
  public static Class forName(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    throw new ReflectionException("Class not found: " + paramString, localClassNotFoundException);
  }

  public static Annotation getAnnotation(Class paramClass1, Class paramClass2)
  {
    java.lang.annotation.Annotation localAnnotation = paramClass1.getAnnotation(paramClass2);
    if (localAnnotation != null)
      return new Annotation(localAnnotation);
    return null;
  }

  public static Annotation[] getAnnotations(Class paramClass)
  {
    java.lang.annotation.Annotation[] arrayOfAnnotation = paramClass.getAnnotations();
    Annotation[] arrayOfAnnotation1 = new Annotation[arrayOfAnnotation.length];
    for (int i = 0; i < arrayOfAnnotation.length; i++)
      arrayOfAnnotation1[i] = new Annotation(arrayOfAnnotation[i]);
    return arrayOfAnnotation1;
  }

  public static Constructor getConstructor(Class paramClass, Class[] paramArrayOfClass)
  {
    try
    {
      Constructor localConstructor = new Constructor(paramClass.getConstructor(paramArrayOfClass));
      return localConstructor;
    }
    catch (SecurityException localSecurityException)
    {
      throw new ReflectionException("Security violation occurred while getting constructor for class: '" + paramClass.getName() + "'.", localSecurityException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    throw new ReflectionException("Constructor not found for class: " + paramClass.getName(), localNoSuchMethodException);
  }

  public static Constructor[] getConstructors(Class paramClass)
  {
    java.lang.reflect.Constructor[] arrayOfConstructor = paramClass.getConstructors();
    Constructor[] arrayOfConstructor1 = new Constructor[arrayOfConstructor.length];
    int i = 0;
    int j = arrayOfConstructor.length;
    while (i < j)
    {
      arrayOfConstructor1[i] = new Constructor(arrayOfConstructor[i]);
      i++;
    }
    return arrayOfConstructor1;
  }

  public static Annotation getDeclaredAnnotation(Class paramClass1, Class paramClass2)
  {
    for (java.lang.annotation.Annotation localAnnotation : paramClass1.getDeclaredAnnotations())
      if (localAnnotation.annotationType().equals(paramClass2))
        return new Annotation(localAnnotation);
    return null;
  }

  public static Annotation[] getDeclaredAnnotations(Class paramClass)
  {
    java.lang.annotation.Annotation[] arrayOfAnnotation = paramClass.getDeclaredAnnotations();
    Annotation[] arrayOfAnnotation1 = new Annotation[arrayOfAnnotation.length];
    for (int i = 0; i < arrayOfAnnotation.length; i++)
      arrayOfAnnotation1[i] = new Annotation(arrayOfAnnotation[i]);
    return arrayOfAnnotation1;
  }

  public static Constructor getDeclaredConstructor(Class paramClass, Class[] paramArrayOfClass)
  {
    try
    {
      Constructor localConstructor = new Constructor(paramClass.getDeclaredConstructor(paramArrayOfClass));
      return localConstructor;
    }
    catch (SecurityException localSecurityException)
    {
      throw new ReflectionException("Security violation while getting constructor for class: " + paramClass.getName(), localSecurityException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    throw new ReflectionException("Constructor not found for class: " + paramClass.getName(), localNoSuchMethodException);
  }

  public static Field getDeclaredField(Class paramClass, String paramString)
  {
    try
    {
      Field localField = new Field(paramClass.getDeclaredField(paramString));
      return localField;
    }
    catch (SecurityException localSecurityException)
    {
      throw new ReflectionException("Security violation while getting field: " + paramString + ", for class: " + paramClass.getName(), localSecurityException);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
    }
    throw new ReflectionException("Field not found: " + paramString + ", for class: " + paramClass.getName(), localNoSuchFieldException);
  }

  public static Field[] getDeclaredFields(Class paramClass)
  {
    java.lang.reflect.Field[] arrayOfField = paramClass.getDeclaredFields();
    Field[] arrayOfField1 = new Field[arrayOfField.length];
    int i = 0;
    int j = arrayOfField.length;
    while (i < j)
    {
      arrayOfField1[i] = new Field(arrayOfField[i]);
      i++;
    }
    return arrayOfField1;
  }

  public static Method getDeclaredMethod(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      Method localMethod = new Method(paramClass.getDeclaredMethod(paramString, paramArrayOfClass));
      return localMethod;
    }
    catch (SecurityException localSecurityException)
    {
      throw new ReflectionException("Security violation while getting method: " + paramString + ", for class: " + paramClass.getName(), localSecurityException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    throw new ReflectionException("Method not found: " + paramString + ", for class: " + paramClass.getName(), localNoSuchMethodException);
  }

  public static Method[] getDeclaredMethods(Class paramClass)
  {
    java.lang.reflect.Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    Method[] arrayOfMethod1 = new Method[arrayOfMethod.length];
    int i = 0;
    int j = arrayOfMethod.length;
    while (i < j)
    {
      arrayOfMethod1[i] = new Method(arrayOfMethod[i]);
      i++;
    }
    return arrayOfMethod1;
  }

  public static Field getField(Class paramClass, String paramString)
  {
    try
    {
      Field localField = new Field(paramClass.getField(paramString));
      return localField;
    }
    catch (SecurityException localSecurityException)
    {
      throw new ReflectionException("Security violation while getting field: " + paramString + ", for class: " + paramClass.getName(), localSecurityException);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
    }
    throw new ReflectionException("Field not found: " + paramString + ", for class: " + paramClass.getName(), localNoSuchFieldException);
  }

  public static Field[] getFields(Class paramClass)
  {
    java.lang.reflect.Field[] arrayOfField = paramClass.getFields();
    Field[] arrayOfField1 = new Field[arrayOfField.length];
    int i = 0;
    int j = arrayOfField.length;
    while (i < j)
    {
      arrayOfField1[i] = new Field(arrayOfField[i]);
      i++;
    }
    return arrayOfField1;
  }

  public static Method getMethod(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      Method localMethod = new Method(paramClass.getMethod(paramString, paramArrayOfClass));
      return localMethod;
    }
    catch (SecurityException localSecurityException)
    {
      throw new ReflectionException("Security violation while getting method: " + paramString + ", for class: " + paramClass.getName(), localSecurityException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    throw new ReflectionException("Method not found: " + paramString + ", for class: " + paramClass.getName(), localNoSuchMethodException);
  }

  public static Method[] getMethods(Class paramClass)
  {
    java.lang.reflect.Method[] arrayOfMethod = paramClass.getMethods();
    Method[] arrayOfMethod1 = new Method[arrayOfMethod.length];
    int i = 0;
    int j = arrayOfMethod.length;
    while (i < j)
    {
      arrayOfMethod1[i] = new Method(arrayOfMethod[i]);
      i++;
    }
    return arrayOfMethod1;
  }

  public static String getSimpleName(Class paramClass)
  {
    return paramClass.getSimpleName();
  }

  public static boolean isAnnotationPresent(Class paramClass1, Class paramClass2)
  {
    return paramClass1.isAnnotationPresent(paramClass2);
  }

  public static boolean isArray(Class paramClass)
  {
    return paramClass.isArray();
  }

  public static boolean isAssignableFrom(Class paramClass1, Class paramClass2)
  {
    return paramClass1.isAssignableFrom(paramClass2);
  }

  public static boolean isInstance(Class paramClass, Object paramObject)
  {
    return paramClass.isInstance(paramObject);
  }

  public static boolean isMemberClass(Class paramClass)
  {
    return paramClass.isMemberClass();
  }

  public static boolean isStaticClass(Class paramClass)
  {
    return Modifier.isStatic(paramClass.getModifiers());
  }

  public static Object newInstance(Class paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new ReflectionException("Could not instantiate instance of class: " + paramClass.getName(), localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new ReflectionException("Could not instantiate instance of class: " + paramClass.getName(), localIllegalAccessException);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.reflect.ClassReflection
 * JD-Core Version:    0.6.0
 */