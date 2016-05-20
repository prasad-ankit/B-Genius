package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ClassReflection;

class Skin$1 extends Json
{
  public Object readValue(Class paramClass1, Class paramClass2, JsonValue paramJsonValue)
  {
    if ((paramJsonValue.isString()) && (!ClassReflection.isAssignableFrom(CharSequence.class, paramClass1)))
      return this.this$0.get(paramJsonValue.asString(), paramClass1);
    return super.readValue(paramClass1, paramClass2, paramJsonValue);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Skin.1
 * JD-Core Version:    0.6.0
 */