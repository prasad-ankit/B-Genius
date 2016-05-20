package com.badlogic.gdx.graphics;

public enum Texture$TextureWrap
{
  final int glEnum;

  static
  {
    ClampToEdge = new TextureWrap("ClampToEdge", 1, 33071);
    Repeat = new TextureWrap("Repeat", 2, 10497);
    TextureWrap[] arrayOfTextureWrap = new TextureWrap[3];
    arrayOfTextureWrap[0] = MirroredRepeat;
    arrayOfTextureWrap[1] = ClampToEdge;
    arrayOfTextureWrap[2] = Repeat;
    $VALUES = arrayOfTextureWrap;
  }

  private Texture$TextureWrap(int arg3)
  {
    int j;
    this.glEnum = j;
  }

  public final int getGLEnum()
  {
    return this.glEnum;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.Texture.TextureWrap
 * JD-Core Version:    0.6.0
 */