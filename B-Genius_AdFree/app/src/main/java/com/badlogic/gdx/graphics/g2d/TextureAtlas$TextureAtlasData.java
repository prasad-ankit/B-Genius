package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TextureAtlas$TextureAtlasData
{
  final Array pages = new Array();
  final Array regions = new Array();

  public TextureAtlas$TextureAtlasData(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramFileHandle1.read()), 64);
    TextureAtlas.TextureAtlasData.Page localPage = null;
    while (true)
    {
      String str1;
      String str2;
      try
      {
        str1 = localBufferedReader.readLine();
        if (str1 == null)
          break;
        if (str1.trim().length() != 0)
          continue;
        localPage = null;
        continue;
        if (localPage != null)
          break label329;
        FileHandle localFileHandle = paramFileHandle2.child(str1);
        int i = TextureAtlas.readTuple(localBufferedReader);
        float f1 = 0.0F;
        float f2 = 0.0F;
        if (i != 2)
          continue;
        f1 = Integer.parseInt(TextureAtlas.tuple[0]);
        f2 = Integer.parseInt(TextureAtlas.tuple[1]);
        TextureAtlas.readTuple(localBufferedReader);
        Pixmap.Format localFormat = Pixmap.Format.valueOf(TextureAtlas.tuple[0]);
        TextureAtlas.readTuple(localBufferedReader);
        Texture.TextureFilter localTextureFilter1 = Texture.TextureFilter.valueOf(TextureAtlas.tuple[0]);
        Texture.TextureFilter localTextureFilter2 = Texture.TextureFilter.valueOf(TextureAtlas.tuple[1]);
        str2 = TextureAtlas.readValue(localBufferedReader);
        localTextureWrap1 = Texture.TextureWrap.ClampToEdge;
        localTextureWrap2 = Texture.TextureWrap.ClampToEdge;
        if (str2.equals("x"))
        {
          localTextureWrap1 = Texture.TextureWrap.Repeat;
          localPage = new TextureAtlas.TextureAtlasData.Page(localFileHandle, f1, f2, localTextureFilter1.isMipMap(), localFormat, localTextureFilter1, localTextureFilter2, localTextureWrap1, localTextureWrap2);
          this.pages.add(localPage);
          continue;
        }
      }
      catch (Exception localException)
      {
        throw new GdxRuntimeException("Error reading pack file: " + paramFileHandle1, localException);
      }
      finally
      {
        StreamUtils.closeQuietly(localBufferedReader);
      }
      if (str2.equals("y"))
      {
        localTextureWrap2 = Texture.TextureWrap.Repeat;
        continue;
      }
      if (!str2.equals("xy"))
        continue;
      Texture.TextureWrap localTextureWrap1 = Texture.TextureWrap.Repeat;
      Texture.TextureWrap localTextureWrap2 = Texture.TextureWrap.Repeat;
      continue;
      label329: boolean bool = Boolean.valueOf(TextureAtlas.readValue(localBufferedReader)).booleanValue();
      TextureAtlas.readTuple(localBufferedReader);
      int j = Integer.parseInt(TextureAtlas.tuple[0]);
      int k = Integer.parseInt(TextureAtlas.tuple[1]);
      TextureAtlas.readTuple(localBufferedReader);
      int m = Integer.parseInt(TextureAtlas.tuple[0]);
      int n = Integer.parseInt(TextureAtlas.tuple[1]);
      TextureAtlas.TextureAtlasData.Region localRegion = new TextureAtlas.TextureAtlasData.Region();
      localRegion.page = localPage;
      localRegion.left = j;
      localRegion.top = k;
      localRegion.width = m;
      localRegion.height = n;
      localRegion.name = str1;
      localRegion.rotate = bool;
      if (TextureAtlas.readTuple(localBufferedReader) == 4)
      {
        int[] arrayOfInt1 = new int[4];
        arrayOfInt1[0] = Integer.parseInt(TextureAtlas.tuple[0]);
        arrayOfInt1[1] = Integer.parseInt(TextureAtlas.tuple[1]);
        arrayOfInt1[2] = Integer.parseInt(TextureAtlas.tuple[2]);
        arrayOfInt1[3] = Integer.parseInt(TextureAtlas.tuple[3]);
        localRegion.splits = arrayOfInt1;
        if (TextureAtlas.readTuple(localBufferedReader) == 4)
        {
          int[] arrayOfInt2 = new int[4];
          arrayOfInt2[0] = Integer.parseInt(TextureAtlas.tuple[0]);
          arrayOfInt2[1] = Integer.parseInt(TextureAtlas.tuple[1]);
          arrayOfInt2[2] = Integer.parseInt(TextureAtlas.tuple[2]);
          arrayOfInt2[3] = Integer.parseInt(TextureAtlas.tuple[3]);
          localRegion.pads = arrayOfInt2;
          TextureAtlas.readTuple(localBufferedReader);
        }
      }
      localRegion.originalWidth = Integer.parseInt(TextureAtlas.tuple[0]);
      localRegion.originalHeight = Integer.parseInt(TextureAtlas.tuple[1]);
      TextureAtlas.readTuple(localBufferedReader);
      localRegion.offsetX = Integer.parseInt(TextureAtlas.tuple[0]);
      localRegion.offsetY = Integer.parseInt(TextureAtlas.tuple[1]);
      localRegion.index = Integer.parseInt(TextureAtlas.readValue(localBufferedReader));
      if (paramBoolean)
        localRegion.flip = true;
      this.regions.add(localRegion);
    }
    StreamUtils.closeQuietly(localBufferedReader);
    this.regions.sort(TextureAtlas.indexComparator);
  }

  public Array getPages()
  {
    return this.pages;
  }

  public Array getRegions()
  {
    return this.regions;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData
 * JD-Core Version:    0.6.0
 */