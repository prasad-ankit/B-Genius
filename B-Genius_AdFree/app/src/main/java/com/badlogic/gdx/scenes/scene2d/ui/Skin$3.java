package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.ReadOnlySerializer;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;

class Skin$3 extends Json.ReadOnlySerializer
{
  public BitmapFont read(Json paramJson, JsonValue paramJsonValue, Class paramClass)
  {
    String str1 = (String)paramJson.readValue("file", String.class, paramJsonValue);
    int i = ((Integer)paramJson.readValue("scaledSize", Integer.TYPE, Integer.valueOf(-1), paramJsonValue)).intValue();
    Boolean localBoolean1 = (Boolean)paramJson.readValue("flip", Boolean.class, Boolean.valueOf(false), paramJsonValue);
    Boolean localBoolean2 = (Boolean)paramJson.readValue("markupEnabled", Boolean.class, Boolean.valueOf(false), paramJsonValue);
    FileHandle localFileHandle1 = this.val$skinFile.parent().child(str1);
    if (!localFileHandle1.exists())
      localFileHandle1 = Gdx.files.internal(str1);
    if (!localFileHandle1.exists())
      throw new SerializationException("Font file not found: " + localFileHandle1);
    String str2 = localFileHandle1.nameWithoutExtension();
    BitmapFont localBitmapFont;
    while (true)
    {
      try
      {
        TextureRegion localTextureRegion = (TextureRegion)this.val$skin.optional(str2, TextureRegion.class);
        if (localTextureRegion == null)
          continue;
        localBitmapFont = new BitmapFont(localFileHandle1, localTextureRegion, localBoolean1.booleanValue());
        localBitmapFont.getData().markupEnabled = localBoolean2.booleanValue();
        if (i == -1)
          break;
        localBitmapFont.getData().setScale(i / localBitmapFont.getCapHeight());
        return localBitmapFont;
        FileHandle localFileHandle2 = localFileHandle1.parent().child(str2 + ".png");
        if (localFileHandle2.exists())
        {
          localBitmapFont = new BitmapFont(localFileHandle1, localFileHandle2, localBoolean1.booleanValue());
          continue;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        throw new SerializationException("Error loading bitmap font: " + localFileHandle1, localRuntimeException);
      }
      localBitmapFont = new BitmapFont(localFileHandle1, localBoolean1.booleanValue());
    }
    return localBitmapFont;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Skin.3
 * JD-Core Version:    0.6.0
 */