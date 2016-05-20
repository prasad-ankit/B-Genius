package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class BitmapFont
  implements Disposable
{
  private static final int LOG2_PAGE_SIZE = 9;
  private static final int PAGES = 128;
  private static final int PAGE_SIZE = 512;
  private final BitmapFontCache cache;
  final BitmapFont.BitmapFontData data;
  private boolean flipped;
  boolean integer;
  private boolean ownsTexture;
  Array regions;

  public BitmapFont()
  {
    this(Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.fnt"), Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.png"), false, true);
  }

  public BitmapFont(FileHandle paramFileHandle)
  {
    this(paramFileHandle, false);
  }

  public BitmapFont(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean)
  {
    this(paramFileHandle1, paramFileHandle2, paramBoolean, true);
  }

  public BitmapFont(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(new BitmapFont.BitmapFontData(paramFileHandle1, paramBoolean1), new TextureRegion(new Texture(paramFileHandle2, false)), paramBoolean2);
    this.ownsTexture = true;
  }

  public BitmapFont(FileHandle paramFileHandle, TextureRegion paramTextureRegion)
  {
    this(paramFileHandle, paramTextureRegion, false);
  }

  public BitmapFont(FileHandle paramFileHandle, TextureRegion paramTextureRegion, boolean paramBoolean)
  {
    this(new BitmapFont.BitmapFontData(paramFileHandle, paramBoolean), paramTextureRegion, true);
  }

  public BitmapFont(FileHandle paramFileHandle, boolean paramBoolean)
  {
    this(new BitmapFont.BitmapFontData(paramFileHandle, paramBoolean), null, true);
  }

  public BitmapFont(BitmapFont.BitmapFontData paramBitmapFontData, TextureRegion paramTextureRegion, boolean paramBoolean)
  {
  }

  public BitmapFont(BitmapFont.BitmapFontData paramBitmapFontData, Array paramArray, boolean paramBoolean)
  {
    this.flipped = paramBitmapFontData.flipped;
    this.data = paramBitmapFontData;
    this.integer = paramBoolean;
    if ((paramArray == null) || (paramArray.size == 0))
    {
      int i = paramBitmapFontData.imagePaths.length;
      this.regions = new Array(i);
      int j = 0;
      if (j < i)
      {
        if (paramBitmapFontData.fontFile == null);
        for (FileHandle localFileHandle = Gdx.files.internal(paramBitmapFontData.imagePaths[j]); ; localFileHandle = Gdx.files.getFileHandle(paramBitmapFontData.imagePaths[j], paramBitmapFontData.fontFile.type()))
        {
          this.regions.add(new TextureRegion(new Texture(localFileHandle, false)));
          j++;
          break;
        }
      }
    }
    for (this.ownsTexture = true; ; this.ownsTexture = false)
    {
      this.cache = newFontCache();
      load(paramBitmapFontData);
      return;
      this.regions = paramArray;
    }
  }

  public BitmapFont(boolean paramBoolean)
  {
    this(Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.fnt"), Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.png"), paramBoolean, true);
  }

  static int indexOf(CharSequence paramCharSequence, char paramChar, int paramInt)
  {
    int i = paramCharSequence.length();
    for (int j = paramInt; j < i; j++)
      if (paramCharSequence.charAt(j) == paramChar)
        return j;
    return i;
  }

  public void dispose()
  {
    if (this.ownsTexture)
      for (int i = 0; i < this.regions.size; i++)
        ((TextureRegion)this.regions.get(i)).getTexture().dispose();
  }

  public GlyphLayout draw(Batch paramBatch, CharSequence paramCharSequence, float paramFloat1, float paramFloat2)
  {
    this.cache.clear();
    GlyphLayout localGlyphLayout = this.cache.addText(paramCharSequence, paramFloat1, paramFloat2);
    this.cache.draw(paramBatch);
    return localGlyphLayout;
  }

  public GlyphLayout draw(Batch paramBatch, CharSequence paramCharSequence, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, boolean paramBoolean)
  {
    this.cache.clear();
    GlyphLayout localGlyphLayout = this.cache.addText(paramCharSequence, paramFloat1, paramFloat2, paramFloat3, paramInt, paramBoolean);
    this.cache.draw(paramBatch);
    return localGlyphLayout;
  }

  public GlyphLayout draw(Batch paramBatch, CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, int paramInt3, boolean paramBoolean)
  {
    this.cache.clear();
    GlyphLayout localGlyphLayout = this.cache.addText(paramCharSequence, paramFloat1, paramFloat2, paramInt1, paramInt2, paramFloat3, paramInt3, paramBoolean);
    this.cache.draw(paramBatch);
    return localGlyphLayout;
  }

  public void draw(Batch paramBatch, GlyphLayout paramGlyphLayout, float paramFloat1, float paramFloat2)
  {
    this.cache.clear();
    this.cache.addText(paramGlyphLayout, paramFloat1, paramFloat2);
    this.cache.draw(paramBatch);
  }

  public float getAscent()
  {
    return this.data.ascent;
  }

  public BitmapFontCache getCache()
  {
    return this.cache;
  }

  public float getCapHeight()
  {
    return this.data.capHeight;
  }

  public Color getColor()
  {
    return this.cache.getColor();
  }

  public BitmapFont.BitmapFontData getData()
  {
    return this.data;
  }

  public float getDescent()
  {
    return this.data.descent;
  }

  public float getLineHeight()
  {
    return this.data.lineHeight;
  }

  public TextureRegion getRegion()
  {
    return (TextureRegion)this.regions.first();
  }

  public TextureRegion getRegion(int paramInt)
  {
    return (TextureRegion)this.regions.get(paramInt);
  }

  public Array getRegions()
  {
    return this.regions;
  }

  public float getScaleX()
  {
    return this.data.scaleX;
  }

  public float getScaleY()
  {
    return this.data.scaleY;
  }

  public float getSpaceWidth()
  {
    return this.data.spaceWidth;
  }

  public float getXHeight()
  {
    return this.data.xHeight;
  }

  public boolean isFlipped()
  {
    return this.flipped;
  }

  protected void load(BitmapFont.BitmapFontData paramBitmapFontData)
  {
    for (BitmapFont.Glyph[] arrayOfGlyph1 : paramBitmapFontData.glyphs)
    {
      if (arrayOfGlyph1 == null)
        continue;
      int k = arrayOfGlyph1.length;
      for (int m = 0; m < k; m++)
      {
        BitmapFont.Glyph localGlyph = arrayOfGlyph1[m];
        if (localGlyph == null)
          continue;
        TextureRegion localTextureRegion = (TextureRegion)this.regions.get(localGlyph.page);
        if (localTextureRegion == null)
          throw new IllegalArgumentException("BitmapFont texture region array cannot contain null elements.");
        paramBitmapFontData.setGlyphRegion(localGlyph, localTextureRegion);
      }
    }
  }

  public BitmapFontCache newFontCache()
  {
    return new BitmapFontCache(this, this.integer);
  }

  public boolean ownsTexture()
  {
    return this.ownsTexture;
  }

  public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.cache.getColor().set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public void setColor(Color paramColor)
  {
    this.cache.getColor().set(paramColor);
  }

  public void setFixedWidthGlyphs(CharSequence paramCharSequence)
  {
    int i = 0;
    BitmapFont.BitmapFontData localBitmapFontData = this.data;
    int j = paramCharSequence.length();
    int k = 0;
    int m = 0;
    while (k < j)
    {
      BitmapFont.Glyph localGlyph2 = localBitmapFontData.getGlyph(paramCharSequence.charAt(k));
      if ((localGlyph2 != null) && (localGlyph2.xadvance > m))
        m = localGlyph2.xadvance;
      k++;
    }
    int n = paramCharSequence.length();
    while (i < n)
    {
      BitmapFont.Glyph localGlyph1 = localBitmapFontData.getGlyph(paramCharSequence.charAt(i));
      if (localGlyph1 != null)
      {
        localGlyph1.xoffset += Math.round((m - localGlyph1.xadvance) / 2);
        localGlyph1.xadvance = m;
        localGlyph1.kerning = null;
      }
      i++;
    }
  }

  public void setOwnsTexture(boolean paramBoolean)
  {
    this.ownsTexture = paramBoolean;
  }

  public void setUseIntegerPositions(boolean paramBoolean)
  {
    this.integer = paramBoolean;
    this.cache.setUseIntegerPositions(paramBoolean);
  }

  public String toString()
  {
    if (this.data.fontFile != null)
      return this.data.fontFile.nameWithoutExtension();
    return super.toString();
  }

  public boolean usesIntegerPositions()
  {
    return this.integer;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.BitmapFont
 * JD-Core Version:    0.6.0
 */