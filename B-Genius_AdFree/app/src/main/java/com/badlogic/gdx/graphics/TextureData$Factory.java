package com.badlogic.gdx.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.ETC1TextureData;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.graphics.glutils.KTXTextureData;

public class TextureData$Factory
{
  public static TextureData loadFromFile(FileHandle paramFileHandle, Pixmap.Format paramFormat, boolean paramBoolean)
  {
    if (paramFileHandle == null)
      return null;
    if (paramFileHandle.name().endsWith(".cim"))
      return new FileTextureData(paramFileHandle, PixmapIO.readCIM(paramFileHandle), paramFormat, paramBoolean);
    if (paramFileHandle.name().endsWith(".etc1"))
      return new ETC1TextureData(paramFileHandle, paramBoolean);
    if ((paramFileHandle.name().endsWith(".ktx")) || (paramFileHandle.name().endsWith(".zktx")))
      return new KTXTextureData(paramFileHandle, paramBoolean);
    return new FileTextureData(paramFileHandle, new Pixmap(paramFileHandle), paramFormat, paramBoolean);
  }

  public static TextureData loadFromFile(FileHandle paramFileHandle, boolean paramBoolean)
  {
    return loadFromFile(paramFileHandle, null, paramBoolean);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.TextureData.Factory
 * JD-Core Version:    0.6.0
 */