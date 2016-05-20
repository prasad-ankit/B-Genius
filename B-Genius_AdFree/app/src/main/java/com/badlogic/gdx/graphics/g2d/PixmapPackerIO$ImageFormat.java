package com.badlogic.gdx.graphics.g2d;

public enum PixmapPackerIO$ImageFormat
{
  private final String extension;

  static
  {
    ImageFormat[] arrayOfImageFormat = new ImageFormat[2];
    arrayOfImageFormat[0] = CIM;
    arrayOfImageFormat[1] = PNG;
    $VALUES = arrayOfImageFormat;
  }

  private PixmapPackerIO$ImageFormat(String arg3)
  {
    Object localObject;
    this.extension = localObject;
  }

  public final String getExtension()
  {
    return this.extension;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.PixmapPackerIO.ImageFormat
 * JD-Core Version:    0.6.0
 */