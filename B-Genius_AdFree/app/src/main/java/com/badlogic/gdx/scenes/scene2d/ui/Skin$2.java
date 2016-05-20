package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.ReadOnlySerializer;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

class Skin$2 extends Json.ReadOnlySerializer
{
  private void readNamedObjects(Json paramJson, Class paramClass, JsonValue paramJsonValue)
  {
    Object localObject1;
    if (paramClass == Skin.TintedDrawable.class)
      localObject1 = Drawable.class;
    while (true)
    {
      JsonValue localJsonValue = paramJsonValue.child;
      label16: if (localJsonValue == null)
        break;
      Object localObject2 = paramJson.readValue(paramClass, localJsonValue);
      if (localObject2 != null);
      try
      {
        this.this$0.add(localJsonValue.name(), localObject2, (Class)localObject1);
        localJsonValue = localJsonValue.next;
        break label16;
        localObject1 = paramClass;
      }
      catch (Exception localException)
      {
        throw new SerializationException("Error reading " + ClassReflection.getSimpleName(paramClass) + ": " + localJsonValue.name(), localException);
      }
    }
  }

  public Skin read(Json paramJson, JsonValue paramJsonValue, Class paramClass)
  {
    JsonValue localJsonValue = paramJsonValue.child;
    while (localJsonValue != null)
      try
      {
        readNamedObjects(paramJson, ClassReflection.forName(localJsonValue.name()), localJsonValue);
        localJsonValue = localJsonValue.next;
      }
      catch (ReflectionException localReflectionException)
      {
        throw new SerializationException(localReflectionException);
      }
    return this.val$skin;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Skin.2
 * JD-Core Version:    0.6.0
 */