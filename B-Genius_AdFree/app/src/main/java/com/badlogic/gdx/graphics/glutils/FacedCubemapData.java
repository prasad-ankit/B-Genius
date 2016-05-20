package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Cubemap.CubemapSide;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.Factory;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class FacedCubemapData
  implements CubemapData
{
  protected final TextureData[] data = new TextureData[6];

  public FacedCubemapData()
  {
    this(null, null, null, null, null, null);
  }

  public FacedCubemapData(int paramInt1, int paramInt2, int paramInt3, Pixmap.Format paramFormat)
  {
    this(new PixmapTextureData(new Pixmap(paramInt3, paramInt2, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt3, paramInt2, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt3, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt3, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true));
  }

  public FacedCubemapData(FileHandle paramFileHandle1, FileHandle paramFileHandle2, FileHandle paramFileHandle3, FileHandle paramFileHandle4, FileHandle paramFileHandle5, FileHandle paramFileHandle6)
  {
    this(TextureData.Factory.loadFromFile(paramFileHandle1, false), TextureData.Factory.loadFromFile(paramFileHandle2, false), TextureData.Factory.loadFromFile(paramFileHandle3, false), TextureData.Factory.loadFromFile(paramFileHandle4, false), TextureData.Factory.loadFromFile(paramFileHandle5, false), TextureData.Factory.loadFromFile(paramFileHandle6, false));
  }

  public FacedCubemapData(FileHandle paramFileHandle1, FileHandle paramFileHandle2, FileHandle paramFileHandle3, FileHandle paramFileHandle4, FileHandle paramFileHandle5, FileHandle paramFileHandle6, boolean paramBoolean)
  {
    this(TextureData.Factory.loadFromFile(paramFileHandle1, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle2, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle3, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle4, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle5, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle6, paramBoolean));
  }

  public FacedCubemapData(Pixmap paramPixmap1, Pixmap paramPixmap2, Pixmap paramPixmap3, Pixmap paramPixmap4, Pixmap paramPixmap5, Pixmap paramPixmap6)
  {
    this(paramPixmap1, paramPixmap2, paramPixmap3, paramPixmap4, paramPixmap5, paramPixmap6, false);
  }

  public FacedCubemapData(Pixmap paramPixmap1, Pixmap paramPixmap2, Pixmap paramPixmap3, Pixmap paramPixmap4, Pixmap paramPixmap5, Pixmap paramPixmap6, boolean paramBoolean)
  {
  }

  public FacedCubemapData(TextureData paramTextureData1, TextureData paramTextureData2, TextureData paramTextureData3, TextureData paramTextureData4, TextureData paramTextureData5, TextureData paramTextureData6)
  {
    this.data[0] = paramTextureData1;
    this.data[1] = paramTextureData2;
    this.data[2] = paramTextureData3;
    this.data[3] = paramTextureData4;
    this.data[4] = paramTextureData5;
    this.data[5] = paramTextureData6;
  }

  public void consumeCubemapData()
  {
    int i = 0;
    Pixmap localPixmap1;
    Pixmap localPixmap2;
    while (true)
      if (i < this.data.length)
      {
        if (this.data[i].getType() == TextureData.TextureDataType.Custom)
        {
          this.data[i].consumeCustomData(i + 34069);
          i++;
          continue;
        }
        localPixmap1 = this.data[i].consumePixmap();
        this.data[i].disposePixmap();
        if (this.data[i].getFormat() == localPixmap1.getFormat())
          break label235;
        localPixmap2 = new Pixmap(localPixmap1.getWidth(), localPixmap1.getHeight(), this.data[i].getFormat());
        Pixmap.Blending localBlending = Pixmap.getBlending();
        Pixmap.setBlending(Pixmap.Blending.None);
        localPixmap2.drawPixmap(localPixmap1, 0, 0, 0, 0, localPixmap1.getWidth(), localPixmap1.getHeight());
        Pixmap.setBlending(localBlending);
        if (!this.data[i].disposePixmap())
          break;
        localPixmap1.dispose();
      }
    label235: for (Pixmap localPixmap3 = localPixmap2; ; localPixmap3 = localPixmap1)
    {
      Gdx.gl.glPixelStorei(3317, 1);
      Gdx.gl.glTexImage2D(i + 34069, 0, localPixmap3.getGLInternalFormat(), localPixmap3.getWidth(), localPixmap3.getHeight(), 0, localPixmap3.getGLFormat(), localPixmap3.getGLType(), localPixmap3.getPixels());
      break;
      return;
    }
  }

  public int getHeight()
  {
    int i;
    if (this.data[Cubemap.CubemapSide.PositiveZ.index] != null)
    {
      i = this.data[Cubemap.CubemapSide.PositiveZ.index].getHeight();
      if (i <= 0);
    }
    while (true)
    {
      if (this.data[Cubemap.CubemapSide.NegativeZ.index] != null)
      {
        int m = this.data[Cubemap.CubemapSide.NegativeZ.index].getHeight();
        if (m > i)
          i = m;
      }
      if (this.data[Cubemap.CubemapSide.PositiveX.index] != null)
      {
        int k = this.data[Cubemap.CubemapSide.PositiveX.index].getHeight();
        if (k > i)
          i = k;
      }
      if (this.data[Cubemap.CubemapSide.NegativeX.index] != null)
      {
        int j = this.data[Cubemap.CubemapSide.NegativeX.index].getHeight();
        if (j > i)
          i = j;
      }
      return i;
      i = 0;
    }
  }

  public TextureData getTextureData(Cubemap.CubemapSide paramCubemapSide)
  {
    return this.data[paramCubemapSide.index];
  }

  public int getWidth()
  {
    int i;
    if (this.data[Cubemap.CubemapSide.PositiveZ.index] != null)
    {
      i = this.data[Cubemap.CubemapSide.PositiveZ.index].getWidth();
      if (i <= 0);
    }
    while (true)
    {
      if (this.data[Cubemap.CubemapSide.NegativeZ.index] != null)
      {
        int m = this.data[Cubemap.CubemapSide.NegativeZ.index].getWidth();
        if (m > i)
          i = m;
      }
      if (this.data[Cubemap.CubemapSide.PositiveY.index] != null)
      {
        int k = this.data[Cubemap.CubemapSide.PositiveY.index].getWidth();
        if (k > i)
          i = k;
      }
      if (this.data[Cubemap.CubemapSide.NegativeY.index] != null)
      {
        int j = this.data[Cubemap.CubemapSide.NegativeY.index].getWidth();
        if (j > i)
          i = j;
      }
      return i;
      i = 0;
    }
  }

  public boolean isComplete()
  {
    for (int i = 0; i < this.data.length; i++)
      if (this.data[i] == null)
        return false;
    return true;
  }

  public boolean isManaged()
  {
    TextureData[] arrayOfTextureData = this.data;
    int i = arrayOfTextureData.length;
    for (int j = 0; j < i; j++)
      if (!arrayOfTextureData[j].isManaged())
        return false;
    return true;
  }

  public boolean isPrepared()
  {
    return false;
  }

  public void load(Cubemap.CubemapSide paramCubemapSide, FileHandle paramFileHandle)
  {
    this.data[paramCubemapSide.index] = TextureData.Factory.loadFromFile(paramFileHandle, false);
  }

  public void load(Cubemap.CubemapSide paramCubemapSide, Pixmap paramPixmap)
  {
    TextureData[] arrayOfTextureData = this.data;
    int i = paramCubemapSide.index;
    PixmapTextureData localPixmapTextureData = null;
    if (paramPixmap == null);
    while (true)
    {
      arrayOfTextureData[i] = localPixmapTextureData;
      return;
      localPixmapTextureData = new PixmapTextureData(paramPixmap, null, false, false);
    }
  }

  public void prepare()
  {
    if (!isComplete())
      throw new GdxRuntimeException("You need to complete your cubemap data before using it");
    for (int i = 0; i < this.data.length; i++)
    {
      if (this.data[i].isPrepared())
        continue;
      this.data[i].prepare();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.FacedCubemapData
 * JD-Core Version:    0.6.0
 */