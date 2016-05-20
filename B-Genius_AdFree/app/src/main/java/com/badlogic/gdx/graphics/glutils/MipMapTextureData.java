package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class MipMapTextureData
  implements TextureData
{
  TextureData[] mips;

  public MipMapTextureData(TextureData[] paramArrayOfTextureData)
  {
    this.mips = new TextureData[paramArrayOfTextureData.length];
    System.arraycopy(paramArrayOfTextureData, 0, this.mips, 0, paramArrayOfTextureData.length);
  }

  public void consumeCustomData(int paramInt)
  {
    for (int i = 0; i < this.mips.length; i++)
      GLTexture.uploadImageData(paramInt, this.mips[i], i);
  }

  public Pixmap consumePixmap()
  {
    throw new GdxRuntimeException("It's compressed, use the compressed method");
  }

  public boolean disposePixmap()
  {
    return false;
  }

  public Pixmap.Format getFormat()
  {
    return this.mips[0].getFormat();
  }

  public int getHeight()
  {
    return this.mips[0].getHeight();
  }

  public TextureData.TextureDataType getType()
  {
    return TextureData.TextureDataType.Custom;
  }

  public int getWidth()
  {
    return this.mips[0].getWidth();
  }

  public boolean isManaged()
  {
    return true;
  }

  public boolean isPrepared()
  {
    return true;
  }

  public void prepare()
  {
  }

  public boolean useMipMaps()
  {
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.MipMapTextureData
 * JD-Core Version:    0.6.0
 */