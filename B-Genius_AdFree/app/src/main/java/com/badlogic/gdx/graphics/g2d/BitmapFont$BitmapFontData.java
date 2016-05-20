package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BitmapFont$BitmapFontData
{
  public float ascent;
  public char[] breakChars;
  public char[] capChars = { 77, 78, 66, 68, 67, 69, 70, 75, 65, 71, 72, 73, 74, 76, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
  public float capHeight = 1.0F;
  public float cursorX;
  public float descent;
  public float down;
  public boolean flipped;
  public FileHandle fontFile;
  public final BitmapFont.Glyph[][] glyphs = new BitmapFont.Glyph[''][];
  public String[] imagePaths;
  public float lineHeight;
  public boolean markupEnabled;
  public float padBottom;
  public float padLeft;
  public float padRight;
  public float padTop;
  public float scaleX = 1.0F;
  public float scaleY = 1.0F;
  public float spaceWidth;
  public char[] xChars = { 120, 101, 97, 111, 110, 115, 114, 99, 117, 109, 118, 119, 122 };
  public float xHeight = 1.0F;

  public BitmapFont$BitmapFontData()
  {
  }

  public BitmapFont$BitmapFontData(FileHandle paramFileHandle, boolean paramBoolean)
  {
    this.fontFile = paramFileHandle;
    this.flipped = paramBoolean;
    load(paramFileHandle, paramBoolean);
  }

  public BitmapFont.Glyph getFirstGlyph()
  {
    for (BitmapFont.Glyph[] arrayOfGlyph1 : this.glyphs)
    {
      if (arrayOfGlyph1 == null)
        continue;
      int k = arrayOfGlyph1.length;
      for (int m = 0; m < k; m++)
      {
        BitmapFont.Glyph localGlyph = arrayOfGlyph1[m];
        if ((localGlyph != null) && (localGlyph.height != 0) && (localGlyph.width != 0))
          return localGlyph;
      }
    }
    throw new GdxRuntimeException("No glyphs found.");
  }

  public FileHandle getFontFile()
  {
    return this.fontFile;
  }

  public BitmapFont.Glyph getGlyph(char paramChar)
  {
    BitmapFont.Glyph[] arrayOfGlyph = this.glyphs[(paramChar / 'Ȁ')];
    if (arrayOfGlyph != null)
      return arrayOfGlyph[(paramChar & 0x1FF)];
    return null;
  }

  public void getGlyphs(GlyphLayout.GlyphRun paramGlyphRun, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool = this.markupEnabled;
    float f = this.scaleX;
    Array localArray = paramGlyphRun.glyphs;
    FloatArray localFloatArray = paramGlyphRun.xAdvances;
    Object localObject = null;
    while (true)
    {
      int i;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1 + 1;
        char c = paramCharSequence.charAt(paramInt1);
        BitmapFont.Glyph localGlyph = getGlyph(c);
        if (localGlyph != null)
        {
          localArray.add(localGlyph);
          if (localObject == null)
            localFloatArray.add(f * -localGlyph.xoffset - this.padLeft);
          while (true)
          {
            if ((bool) && (c == '[') && (i < paramInt2) && (paramCharSequence.charAt(i) == '['))
              i++;
            localObject = localGlyph;
            paramInt1 = i;
            break;
            localFloatArray.add(f * (localObject.xadvance + localObject.getKerning(c)));
          }
        }
      }
      else
      {
        if (localObject != null)
          localFloatArray.add(f * (localObject.xoffset + localObject.width) - this.padRight);
        return;
      }
      paramInt1 = i;
    }
  }

  public String getImagePath(int paramInt)
  {
    return this.imagePaths[paramInt];
  }

  public String[] getImagePaths()
  {
    return this.imagePaths;
  }

  public int getWrapIndex(Array paramArray, int paramInt)
  {
    for (int i = paramInt - 1; (i > 0) && (isWhitespace((char)((BitmapFont.Glyph)paramArray.get(i)).id)); i--);
    while (true)
    {
      i--;
      if (i <= 0)
        break;
      char c = (char)((BitmapFont.Glyph)paramArray.get(i)).id;
      if ((isWhitespace(c)) || (isBreakChar(c)))
        return i + 1;
    }
    return 0;
  }

  public boolean hasGlyph(char paramChar)
  {
    return getGlyph(paramChar) != null;
  }

  public boolean isBreakChar(char paramChar)
  {
    if (this.breakChars == null);
    while (true)
    {
      return false;
      char[] arrayOfChar = this.breakChars;
      int i = arrayOfChar.length;
      for (int j = 0; j < i; j++)
        if (paramChar == arrayOfChar[j])
          return true;
    }
  }

  public boolean isWhitespace(char paramChar)
  {
    switch (paramChar)
    {
    default:
      return false;
    case '\t':
    case '\n':
    case '\r':
    case ' ':
    }
    return true;
  }

  public void load(FileHandle paramFileHandle, boolean paramBoolean)
  {
    if (this.imagePaths != null)
      throw new IllegalStateException("Already loaded.");
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramFileHandle.read()), 512);
    String str1;
    try
    {
      str1 = localBufferedReader.readLine();
      if (str1 == null)
        throw new GdxRuntimeException("File is empty.");
    }
    catch (Exception localException)
    {
      throw new GdxRuntimeException("Error loading font file: " + paramFileHandle, localException);
    }
    finally
    {
      StreamUtils.closeQuietly(localBufferedReader);
    }
    String str2 = str1.substring(8 + str1.indexOf("padding="));
    String[] arrayOfString1 = str2.substring(0, str2.indexOf(' ')).split(",", 4);
    if (arrayOfString1.length != 4)
      throw new GdxRuntimeException("Invalid padding.");
    this.padTop = Integer.parseInt(arrayOfString1[0]);
    this.padLeft = Integer.parseInt(arrayOfString1[1]);
    this.padBottom = Integer.parseInt(arrayOfString1[2]);
    this.padRight = Integer.parseInt(arrayOfString1[3]);
    float f1 = this.padTop + this.padBottom;
    String str3 = localBufferedReader.readLine();
    if (str3 == null)
      throw new GdxRuntimeException("Missing common header.");
    String[] arrayOfString2 = str3.split(" ", 7);
    if (arrayOfString2.length < 3)
      throw new GdxRuntimeException("Invalid common header.");
    if (!arrayOfString2[1].startsWith("lineHeight="))
      throw new GdxRuntimeException("Missing: lineHeight");
    this.lineHeight = Integer.parseInt(arrayOfString2[1].substring(11));
    if (!arrayOfString2[2].startsWith("base="))
      throw new GdxRuntimeException("Missing: base");
    float f2 = Integer.parseInt(arrayOfString2[2].substring(5));
    if ((arrayOfString2.length >= 6) && (arrayOfString2[5] != null))
    {
      boolean bool3 = arrayOfString2[5].startsWith("pages=");
      if (!bool3);
    }
    while (true)
    {
      int i4;
      int i6;
      try
      {
        int i8 = Math.max(1, Integer.parseInt(arrayOfString2[5].substring(6)));
        i = i8;
        this.imagePaths = new String[i];
        int j = 0;
        if (j >= i)
          continue;
        String str4 = localBufferedReader.readLine();
        if (str4 != null)
          continue;
        throw new GdxRuntimeException("Missing additional page definitions.");
        String[] arrayOfString3 = str4.split(" ", 4);
        if (arrayOfString3[2].startsWith("file="))
          continue;
        throw new GdxRuntimeException("Missing: file");
        boolean bool1 = arrayOfString3[1].startsWith("id=");
        if (!bool1)
          continue;
        try
        {
          if (Integer.parseInt(arrayOfString3[1].substring(3)) == j)
            continue;
          throw new GdxRuntimeException("Page IDs must be indices starting at 0: " + arrayOfString3[1].substring(3));
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          throw new GdxRuntimeException("Invalid page id: " + arrayOfString3[1].substring(3), localNumberFormatException1);
        }
        if (!arrayOfString3[2].endsWith("\""))
          continue;
        String str5 = arrayOfString3[2].substring(6, -1 + arrayOfString3[2].length());
        this.imagePaths[j] = paramFileHandle.parent().child(str5).path().replaceAll("\\\\", "/");
        j++;
        continue;
        str5 = arrayOfString3[2].substring(5, arrayOfString3[2].length());
        continue;
        this.descent = 0.0F;
        String str6 = localBufferedReader.readLine();
        if ((str6 == null) || (str6.startsWith("kernings ")))
          continue;
        if (!str6.startsWith("char "))
          continue;
        BitmapFont.Glyph localGlyph7 = new BitmapFont.Glyph();
        StringTokenizer localStringTokenizer2 = new StringTokenizer(str6, " =");
        localStringTokenizer2.nextToken();
        localStringTokenizer2.nextToken();
        int i7 = Integer.parseInt(localStringTokenizer2.nextToken());
        if (i7 > 65535)
          continue;
        setGlyph(i7, localGlyph7);
        localGlyph7.id = i7;
        localStringTokenizer2.nextToken();
        localGlyph7.srcX = Integer.parseInt(localStringTokenizer2.nextToken());
        localStringTokenizer2.nextToken();
        localGlyph7.srcY = Integer.parseInt(localStringTokenizer2.nextToken());
        localStringTokenizer2.nextToken();
        localGlyph7.width = Integer.parseInt(localStringTokenizer2.nextToken());
        localStringTokenizer2.nextToken();
        localGlyph7.height = Integer.parseInt(localStringTokenizer2.nextToken());
        localStringTokenizer2.nextToken();
        localGlyph7.xoffset = Integer.parseInt(localStringTokenizer2.nextToken());
        localStringTokenizer2.nextToken();
        if (!paramBoolean)
          continue;
        localGlyph7.yoffset = Integer.parseInt(localStringTokenizer2.nextToken());
        localStringTokenizer2.nextToken();
        localGlyph7.xadvance = Integer.parseInt(localStringTokenizer2.nextToken());
        if (!localStringTokenizer2.hasMoreTokens())
          continue;
        localStringTokenizer2.nextToken();
        boolean bool2 = localStringTokenizer2.hasMoreTokens();
        if (!bool2)
          continue;
        try
        {
          localGlyph7.page = Integer.parseInt(localStringTokenizer2.nextToken());
          if ((localGlyph7.width <= 0) || (localGlyph7.height <= 0))
            continue;
          this.descent = Math.min(f2 + localGlyph7.yoffset, this.descent);
          continue;
          localGlyph7.yoffset = (-(localGlyph7.height + Integer.parseInt(localStringTokenizer2.nextToken())));
          continue;
          this.descent += this.padBottom;
          String str7 = localBufferedReader.readLine();
          if ((str7 == null) || (!str7.startsWith("kerning ")))
            continue;
          StringTokenizer localStringTokenizer1 = new StringTokenizer(str7, " =");
          localStringTokenizer1.nextToken();
          localStringTokenizer1.nextToken();
          int k = Integer.parseInt(localStringTokenizer1.nextToken());
          localStringTokenizer1.nextToken();
          int m = Integer.parseInt(localStringTokenizer1.nextToken());
          if ((k < 0) || (k > 65535) || (m < 0) || (m > 65535))
            continue;
          BitmapFont.Glyph localGlyph1 = getGlyph((char)k);
          localStringTokenizer1.nextToken();
          int n = Integer.parseInt(localStringTokenizer1.nextToken());
          if (localGlyph1 == null)
            continue;
          localGlyph1.setKerning(m, n);
          continue;
          BitmapFont.Glyph localGlyph2 = getGlyph(' ');
          if (localGlyph2 != null)
            continue;
          localGlyph2 = new BitmapFont.Glyph();
          localGlyph2.id = 32;
          BitmapFont.Glyph localGlyph3 = getGlyph('l');
          if (localGlyph3 != null)
            continue;
          localGlyph3 = getFirstGlyph();
          localGlyph2.xadvance = localGlyph3.xadvance;
          setGlyph(32, localGlyph2);
          if (localGlyph2.width != 0)
            continue;
          localGlyph2.width = (int)(localGlyph2.xadvance + this.padRight);
          localGlyph2.xoffset = (int)(-this.padLeft);
          this.spaceWidth = localGlyph2.width;
          BitmapFont.Glyph localGlyph4 = null;
          int i1 = 0;
          if (i1 >= this.xChars.length)
            continue;
          localGlyph4 = getGlyph(this.xChars[i1]);
          if (localGlyph4 != null)
            continue;
          i1++;
          continue;
          if (localGlyph4 != null)
            continue;
          localGlyph4 = getFirstGlyph();
          this.xHeight = (localGlyph4.height - f1);
          BitmapFont.Glyph localGlyph5 = null;
          int i2 = 0;
          if (i2 >= this.capChars.length)
            continue;
          localGlyph5 = getGlyph(this.capChars[i2]);
          if (localGlyph5 != null)
            continue;
          i2++;
          continue;
          if (localGlyph5 != null)
            continue;
          BitmapFont.Glyph[][] arrayOfGlyph = this.glyphs;
          int i3 = arrayOfGlyph.length;
          i4 = 0;
          if (i4 >= i3)
            continue;
          BitmapFont.Glyph[] arrayOfGlyph1 = arrayOfGlyph[i4];
          if (arrayOfGlyph1 == null)
            break label1565;
          int i5 = arrayOfGlyph1.length;
          i6 = 0;
          if (i6 >= i5)
            break label1565;
          BitmapFont.Glyph localGlyph6 = arrayOfGlyph1[i6];
          if ((localGlyph6 == null) || (localGlyph6.height == 0) || (localGlyph6.width == 0))
            break label1559;
          this.capHeight = Math.max(this.capHeight, localGlyph6.height);
          break label1559;
          this.capHeight = localGlyph5.height;
          this.capHeight -= f1;
          this.ascent = (f2 - this.capHeight);
          this.down = (-this.lineHeight);
          if (!paramBoolean)
            continue;
          this.ascent = (-this.ascent);
          this.down = (-this.down);
          StreamUtils.closeQuietly(localBufferedReader);
          return;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          continue;
        }
      }
      catch (NumberFormatException localNumberFormatException3)
      {
      }
      int i = 1;
      continue;
      label1559: i6++;
      continue;
      label1565: i4++;
    }
  }

  public void scale(float paramFloat)
  {
    setScale(paramFloat + this.scaleX, paramFloat + this.scaleY);
  }

  public void setGlyph(int paramInt, BitmapFont.Glyph paramGlyph)
  {
    BitmapFont.Glyph[] arrayOfGlyph = this.glyphs[(paramInt / 512)];
    if (arrayOfGlyph == null)
    {
      BitmapFont.Glyph[][] arrayOfGlyph1 = this.glyphs;
      int i = paramInt / 512;
      arrayOfGlyph = new BitmapFont.Glyph[512];
      arrayOfGlyph1[i] = arrayOfGlyph;
    }
    arrayOfGlyph[(paramInt & 0x1FF)] = paramGlyph;
  }

  public void setGlyphRegion(BitmapFont.Glyph paramGlyph, TextureRegion paramTextureRegion)
  {
    Texture localTexture = paramTextureRegion.getTexture();
    float f1 = 1.0F / localTexture.getWidth();
    float f2 = 1.0F / localTexture.getHeight();
    float f3 = paramTextureRegion.u;
    float f4 = paramTextureRegion.v;
    float f5 = paramTextureRegion.getRegionWidth();
    float f6 = paramTextureRegion.getRegionHeight();
    boolean bool = paramTextureRegion instanceof TextureAtlas.AtlasRegion;
    float f7 = 0.0F;
    float f8 = 0.0F;
    if (bool)
    {
      TextureAtlas.AtlasRegion localAtlasRegion = (TextureAtlas.AtlasRegion)paramTextureRegion;
      f8 = localAtlasRegion.offsetX;
      f7 = localAtlasRegion.originalHeight - localAtlasRegion.packedHeight - localAtlasRegion.offsetY;
    }
    float f9 = paramGlyph.srcX;
    float f10 = paramGlyph.srcX + paramGlyph.width;
    float f11 = paramGlyph.srcY;
    float f12 = paramGlyph.srcY + paramGlyph.height;
    float f17;
    float f18;
    float f13;
    if (f8 > 0.0F)
    {
      f17 = f9 - f8;
      if (f17 < 0.0F)
      {
        paramGlyph.width = (int)(f17 + paramGlyph.width);
        paramGlyph.xoffset = (int)(paramGlyph.xoffset - f17);
        f17 = 0.0F;
      }
      f18 = f10 - f8;
      if (f18 > f5)
      {
        paramGlyph.width = (int)(paramGlyph.width - (f18 - f5));
        f13 = f17;
      }
    }
    while (true)
    {
      float f15;
      float f14;
      if (f7 > 0.0F)
      {
        f15 = f11 - f7;
        if (f15 < 0.0F)
        {
          paramGlyph.height = (int)(f15 + paramGlyph.height);
          f15 = 0.0F;
        }
        f14 = f12 - f7;
        if (f14 > f6)
        {
          float f16 = f14 - f6;
          paramGlyph.height = (int)(paramGlyph.height - f16);
          paramGlyph.yoffset = (int)(f16 + paramGlyph.yoffset);
          f14 = f6;
        }
      }
      while (true)
      {
        paramGlyph.u = (f3 + f13 * f1);
        paramGlyph.u2 = (f3 + f5 * f1);
        if (this.flipped)
        {
          paramGlyph.v = (f4 + f15 * f2);
          paramGlyph.v2 = (f4 + f14 * f2);
          return;
        }
        paramGlyph.v2 = (f4 + f15 * f2);
        paramGlyph.v = (f4 + f14 * f2);
        return;
        f14 = f12;
        f15 = f11;
      }
      f5 = f18;
      f13 = f17;
      continue;
      f5 = f10;
      f13 = f9;
    }
  }

  public void setLineHeight(float paramFloat)
  {
    this.lineHeight = (paramFloat * this.scaleY);
    float f;
    if (this.flipped)
      f = this.lineHeight;
    while (true)
    {
      this.down = f;
      return;
      f = -this.lineHeight;
    }
  }

  public void setScale(float paramFloat)
  {
    setScale(paramFloat, paramFloat);
  }

  public void setScale(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == 0.0F)
      throw new IllegalArgumentException("scaleX cannot be 0.");
    if (paramFloat2 == 0.0F)
      throw new IllegalArgumentException("scaleY cannot be 0.");
    float f1 = paramFloat1 / this.scaleX;
    float f2 = paramFloat2 / this.scaleY;
    this.lineHeight = (f2 * this.lineHeight);
    this.spaceWidth = (f1 * this.spaceWidth);
    this.xHeight = (f2 * this.xHeight);
    this.capHeight = (f2 * this.capHeight);
    this.ascent = (f2 * this.ascent);
    this.descent = (f2 * this.descent);
    this.down = (f2 * this.down);
    this.padTop = (f2 * this.padTop);
    this.padLeft = (f2 * this.padLeft);
    this.padBottom = (f2 * this.padBottom);
    this.padRight = (f2 * this.padRight);
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData
 * JD-Core Version:    0.6.0
 */