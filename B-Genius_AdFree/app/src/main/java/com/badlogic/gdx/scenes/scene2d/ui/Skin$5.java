package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.ReadOnlySerializer;
import com.badlogic.gdx.utils.JsonValue;

class Skin$5 extends Json.ReadOnlySerializer
{
  public Object read(Json paramJson, JsonValue paramJsonValue, Class paramClass)
  {
    String str = (String)paramJson.readValue("name", String.class, paramJsonValue);
    Color localColor = (Color)paramJson.readValue("color", Color.class, paramJsonValue);
    Drawable localDrawable = this.this$0.newDrawable(str, localColor);
    if ((localDrawable instanceof BaseDrawable))
      ((BaseDrawable)localDrawable).setName(paramJsonValue.name + " (" + str + ", " + localColor + ")");
    return localDrawable;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Skin.5
 * JD-Core Version:    0.6.0
 */