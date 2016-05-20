package com.badlogic.gdx.utils.reflect;

public final class Annotation
{
  private java.lang.annotation.Annotation annotation;

  Annotation(java.lang.annotation.Annotation paramAnnotation)
  {
    this.annotation = paramAnnotation;
  }

  public final java.lang.annotation.Annotation getAnnotation(Class paramClass)
  {
    if (this.annotation.annotationType().equals(paramClass))
      return this.annotation;
    return null;
  }

  public final Class getAnnotationType()
  {
    return this.annotation.annotationType();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.reflect.Annotation
 * JD-Core Version:    0.6.0
 */