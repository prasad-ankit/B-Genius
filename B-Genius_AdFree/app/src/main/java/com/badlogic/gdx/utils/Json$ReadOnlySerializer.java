package com.badlogic.gdx.utils;

public abstract class Json$ReadOnlySerializer
  implements Json.Serializer
{
  public abstract Object read(Json paramJson, JsonValue paramJsonValue, Class paramClass);

  public void write(Json paramJson, Object paramObject, Class paramClass)
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Json.ReadOnlySerializer
 * JD-Core Version:    0.6.0
 */