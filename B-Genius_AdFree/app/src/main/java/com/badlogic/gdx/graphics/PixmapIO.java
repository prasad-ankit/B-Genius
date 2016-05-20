package com.badlogic.gdx.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;

public class PixmapIO
{
  public static Pixmap readCIM(FileHandle paramFileHandle)
  {
    return PixmapIO.CIM.read(paramFileHandle);
  }

  public static void writeCIM(FileHandle paramFileHandle, Pixmap paramPixmap)
  {
    PixmapIO.CIM.write(paramFileHandle, paramPixmap);
  }

  public static void writePNG(FileHandle paramFileHandle, Pixmap paramPixmap)
  {
    try
    {
      PixmapIO.PNG localPNG = new PixmapIO.PNG((int)(1.5F * (paramPixmap.getWidth() * paramPixmap.getHeight())));
      try
      {
        localPNG.setFlipY(false);
        localPNG.write(paramFileHandle, paramPixmap);
        return;
      }
      finally
      {
        localPNG.dispose();
      }
    }
    catch (IOException localIOException)
    {
    }
    throw new GdxRuntimeException("Error writing PNG: " + paramFileHandle, localIOException);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.PixmapIO
 * JD-Core Version:    0.6.0
 */