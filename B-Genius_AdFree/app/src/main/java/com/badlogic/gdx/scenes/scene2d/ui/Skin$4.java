package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.ReadOnlySerializer;
import com.badlogic.gdx.utils.JsonValue;

class Skin$4 extends Json.ReadOnlySerializer
{
  public Color read(Json paramJson, JsonValue paramJsonValue, Class paramClass)
  {
    if (paramJsonValue.isString())
      return (Color)this.this$0.get(paramJsonValue.asString(), Color.class);
    String str = (String)paramJson.readValue("hex", String.class, null, paramJsonValue);
    if (str != null)
      return Color.valueOf(str);
    return new Color(((Float)paramJson.readValue("r", Float.TYPE, Float.valueOf(0.0F), paramJsonValue)).floatValue(), ((Float)paramJson.readValue("g", Float.TYPE, Float.valueOf(0.0F), paramJsonValue)).floatValue(), ((Float)paramJson.readValue("b", Float.TYPE, Float.valueOf(0.0F), paramJsonValue)).floatValue(), ((Float)paramJson.readValue("a", Float.TYPE, Float.valueOf(1.0F), paramJsonValue)).floatValue());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Skin.4
 * JD-Core Version:    0.6.0
 */