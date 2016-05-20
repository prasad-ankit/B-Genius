package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import java.io.InputStream;

public abstract interface BaseJsonReader
{
  public abstract JsonValue parse(FileHandle paramFileHandle);

  public abstract JsonValue parse(InputStream paramInputStream);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.BaseJsonReader
 * JD-Core Version:    0.6.0
 */