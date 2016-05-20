package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Field;
import java.util.Map;

class Json$FieldMetadata
{
  Class elementType;
  Field field;

  public Json$FieldMetadata(Field paramField)
  {
    this.field = paramField;
    if ((ClassReflection.isAssignableFrom(ObjectMap.class, paramField.getType())) || (ClassReflection.isAssignableFrom(Map.class, paramField.getType())));
    for (int i = 1; ; i = 0)
    {
      this.elementType = paramField.getElementType(i);
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Json.FieldMetadata
 * JD-Core Version:    0.6.0
 */