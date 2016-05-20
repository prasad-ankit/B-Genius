package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap.Keys;
import com.badlogic.gdx.utils.OrderedMap;
import java.io.Writer;
import java.util.Iterator;

public class PixmapPackerIO
{
  public void save(FileHandle paramFileHandle, PixmapPacker paramPixmapPacker)
  {
    save(paramFileHandle, paramPixmapPacker, new PixmapPackerIO.SaveParameters());
  }

  public void save(FileHandle paramFileHandle, PixmapPacker paramPixmapPacker, PixmapPackerIO.SaveParameters paramSaveParameters)
  {
    Writer localWriter = paramFileHandle.writer(false);
    Iterator localIterator = paramPixmapPacker.pages.iterator();
    int i = 0;
    int k;
    if (localIterator.hasNext())
    {
      PixmapPacker.Page localPage = (PixmapPacker.Page)localIterator.next();
      if (localPage.rects.size <= 0)
        break label587;
      StringBuilder localStringBuilder = new StringBuilder().append(paramFileHandle.nameWithoutExtension()).append("_");
      k = i + 1;
      FileHandle localFileHandle = paramFileHandle.sibling(k + paramSaveParameters.format.getExtension());
      switch (PixmapPackerIO.1.$SwitchMap$com$badlogic$gdx$graphics$g2d$PixmapPackerIO$ImageFormat[paramSaveParameters.format.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
      while (true)
      {
        localWriter.write("\n");
        localWriter.write(localFileHandle.name() + "\n");
        localWriter.write("size: " + localPage.image.getWidth() + "," + localPage.image.getHeight() + "\n");
        localWriter.write("format: " + paramPixmapPacker.pageFormat.name() + "\n");
        localWriter.write("filter: " + paramSaveParameters.minFilter.name() + "," + paramSaveParameters.magFilter.name() + "\n");
        localWriter.write("repeat: none\n");
        ObjectMap.Keys localKeys = localPage.rects.keys().iterator();
        while (localKeys.hasNext())
        {
          String str = (String)localKeys.next();
          localWriter.write(str + "\n");
          Rectangle localRectangle = (Rectangle)localPage.rects.get(str);
          localWriter.write("rotate: false\n");
          localWriter.write("xy: " + (int)localRectangle.x + "," + (int)localRectangle.y + "\n");
          localWriter.write("size: " + (int)localRectangle.width + "," + (int)localRectangle.height + "\n");
          localWriter.write("orig: " + (int)localRectangle.width + "," + (int)localRectangle.height + "\n");
          localWriter.write("offset: 0, 0\n");
          localWriter.write("index: -1\n");
        }
        PixmapIO.writeCIM(localFileHandle, localPage.image);
        continue;
        PixmapIO.writePNG(localFileHandle, localPage.image);
      }
    }
    label587: for (int j = k; ; j = i)
    {
      i = j;
      break;
      localWriter.close();
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.PixmapPackerIO
 * JD-Core Version:    0.6.0
 */