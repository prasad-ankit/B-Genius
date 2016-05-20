package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.Pools;

public class BitmapFontCache
{
  private static final Color tempColor = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  private static final float whiteTint = Color.WHITE.toFloatBits();
  private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  private float currentTint;
  private final BitmapFont font;
  private int glyphCount;
  private int[] idx;
  private boolean integer;
  private final Array layouts = new Array();
  private IntArray[] pageGlyphIndices;
  private float[][] pageVertices;
  private final Array pooledLayouts = new Array();
  private int[] tempGlyphCount;
  private float x;
  private float y;

  public BitmapFontCache(BitmapFont paramBitmapFont)
  {
    this(paramBitmapFont, paramBitmapFont.usesIntegerPositions());
  }

  public BitmapFontCache(BitmapFont paramBitmapFont, boolean paramBoolean)
  {
    this.font = paramBitmapFont;
    this.integer = paramBoolean;
    int i = paramBitmapFont.regions.size;
    if (i == 0)
      throw new IllegalArgumentException("The specified font must contain at least one texture page.");
    this.pageVertices = new float[i][];
    this.idx = new int[i];
    if (i > 1)
    {
      this.pageGlyphIndices = new IntArray[i];
      int j = 0;
      int k = this.pageGlyphIndices.length;
      while (j < k)
      {
        this.pageGlyphIndices[j] = new IntArray();
        j++;
      }
    }
    this.tempGlyphCount = new int[i];
  }

  private void addGlyph(BitmapFont.Glyph paramGlyph, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = this.font.data.scaleX;
    float f2 = this.font.data.scaleY;
    float f3 = paramFloat1 + f1 * paramGlyph.xoffset;
    float f4 = paramFloat2 + f2 * paramGlyph.yoffset;
    float f5 = f1 * paramGlyph.width;
    float f6 = f2 * paramGlyph.height;
    float f7 = paramGlyph.u;
    float f8 = paramGlyph.u2;
    float f9 = paramGlyph.v;
    float f10 = paramGlyph.v2;
    if (this.integer)
    {
      f3 = Math.round(f3);
      f4 = Math.round(f4);
      f5 = Math.round(f5);
      f6 = Math.round(f6);
    }
    float f11 = f5 + f3;
    float f12 = f6 + f4;
    int i = paramGlyph.page;
    int j = this.idx[i];
    int[] arrayOfInt = this.idx;
    arrayOfInt[i] = (20 + arrayOfInt[i]);
    if (this.pageGlyphIndices != null)
    {
      IntArray localIntArray = this.pageGlyphIndices[i];
      int i17 = this.glyphCount;
      this.glyphCount = (i17 + 1);
      localIntArray.add(i17);
    }
    float[] arrayOfFloat = this.pageVertices[i];
    int k = j + 1;
    arrayOfFloat[j] = f3;
    int m = k + 1;
    arrayOfFloat[k] = f4;
    int n = m + 1;
    arrayOfFloat[m] = paramFloat3;
    int i1 = n + 1;
    arrayOfFloat[n] = f7;
    int i2 = i1 + 1;
    arrayOfFloat[i1] = f9;
    int i3 = i2 + 1;
    arrayOfFloat[i2] = f3;
    int i4 = i3 + 1;
    arrayOfFloat[i3] = f12;
    int i5 = i4 + 1;
    arrayOfFloat[i4] = paramFloat3;
    int i6 = i5 + 1;
    arrayOfFloat[i5] = f7;
    int i7 = i6 + 1;
    arrayOfFloat[i6] = f10;
    int i8 = i7 + 1;
    arrayOfFloat[i7] = f11;
    int i9 = i8 + 1;
    arrayOfFloat[i8] = f12;
    int i10 = i9 + 1;
    arrayOfFloat[i9] = paramFloat3;
    int i11 = i10 + 1;
    arrayOfFloat[i10] = f8;
    int i12 = i11 + 1;
    arrayOfFloat[i11] = f10;
    int i13 = i12 + 1;
    arrayOfFloat[i12] = f11;
    int i14 = i13 + 1;
    arrayOfFloat[i13] = f4;
    int i15 = i14 + 1;
    arrayOfFloat[i14] = paramFloat3;
    int i16 = i15 + 1;
    arrayOfFloat[i15] = f8;
    arrayOfFloat[i16] = f9;
  }

  private void addToCache(GlyphLayout paramGlyphLayout, float paramFloat1, float paramFloat2)
  {
    int i = this.font.regions.size;
    IntArray[] arrayOfIntArray;
    int i1;
    if (this.pageVertices.length < i)
    {
      float[][] arrayOfFloat = new float[i][];
      System.arraycopy(this.pageVertices, 0, arrayOfFloat, 0, this.pageVertices.length);
      this.pageVertices = arrayOfFloat;
      int[] arrayOfInt = new int[i];
      System.arraycopy(this.idx, 0, arrayOfInt, 0, this.idx.length);
      this.idx = arrayOfInt;
      arrayOfIntArray = new IntArray[i];
      if (this.pageGlyphIndices == null)
        break label320;
      i1 = this.pageGlyphIndices.length;
      System.arraycopy(this.pageGlyphIndices, 0, arrayOfIntArray, 0, this.pageGlyphIndices.length);
    }
    while (true)
    {
      if (i1 < i)
      {
        arrayOfIntArray[i1] = new IntArray();
        i1++;
        continue;
      }
      this.pageGlyphIndices = arrayOfIntArray;
      this.tempGlyphCount = new int[i];
      this.layouts.add(paramGlyphLayout);
      requireGlyphs(paramGlyphLayout);
      int j = paramGlyphLayout.runs.size;
      for (int k = 0; k < j; k++)
      {
        GlyphLayout.GlyphRun localGlyphRun = (GlyphLayout.GlyphRun)paramGlyphLayout.runs.get(k);
        Array localArray = localGlyphRun.glyphs;
        FloatArray localFloatArray = localGlyphRun.xAdvances;
        float f1 = localGlyphRun.color.toFloatBits();
        float f2 = paramFloat1 + localGlyphRun.x;
        float f3 = paramFloat2 + localGlyphRun.y;
        int m = localArray.size;
        float f4 = f2;
        for (int n = 0; n < m; n++)
        {
          BitmapFont.Glyph localGlyph = (BitmapFont.Glyph)localArray.get(n);
          f4 += localFloatArray.get(n);
          addGlyph(localGlyph, f4, f3, f1);
        }
      }
      this.currentTint = whiteTint;
      return;
      label320: i1 = 0;
    }
  }

  private void requireGlyphs(GlyphLayout paramGlyphLayout)
  {
    if (this.pageVertices.length == 1)
    {
      int i5 = paramGlyphLayout.runs.size;
      int i6 = 0;
      int i7 = 0;
      while (i6 < i5)
      {
        i7 += ((GlyphLayout.GlyphRun)paramGlyphLayout.runs.get(i6)).glyphs.size;
        i6++;
      }
      requirePageGlyphs(0, i7);
    }
    while (true)
    {
      return;
      int[] arrayOfInt = this.tempGlyphCount;
      int i = arrayOfInt.length;
      for (int j = 0; j < i; j++)
        arrayOfInt[j] = 0;
      int k = paramGlyphLayout.runs.size;
      for (int m = 0; m < k; m++)
      {
        Array localArray = ((GlyphLayout.GlyphRun)paramGlyphLayout.runs.get(m)).glyphs;
        int i2 = localArray.size;
        for (int i3 = 0; i3 < i2; i3++)
        {
          int i4 = ((BitmapFont.Glyph)localArray.get(i3)).page;
          arrayOfInt[i4] = (1 + arrayOfInt[i4]);
        }
      }
      int n = arrayOfInt.length;
      for (int i1 = 0; i1 < n; i1++)
        requirePageGlyphs(i1, arrayOfInt[i1]);
    }
  }

  private void requirePageGlyphs(int paramInt1, int paramInt2)
  {
    if ((this.pageGlyphIndices != null) && (paramInt2 > this.pageGlyphIndices[paramInt1].items.length))
      this.pageGlyphIndices[paramInt1].ensureCapacity(paramInt2 - this.pageGlyphIndices[paramInt1].items.length);
    int i = this.idx[paramInt1] + paramInt2 * 20;
    float[] arrayOfFloat1 = this.pageVertices[paramInt1];
    if (arrayOfFloat1 == null)
      this.pageVertices[paramInt1] = new float[i];
    do
      return;
    while (arrayOfFloat1.length >= i);
    float[] arrayOfFloat2 = new float[i];
    System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, this.idx[paramInt1]);
    this.pageVertices[paramInt1] = arrayOfFloat2;
  }

  public GlyphLayout addText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2)
  {
    return addText(paramCharSequence, paramFloat1, paramFloat2, 0, paramCharSequence.length(), 0.0F, 8, false);
  }

  public GlyphLayout addText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, boolean paramBoolean)
  {
    return addText(paramCharSequence, paramFloat1, paramFloat2, 0, paramCharSequence.length(), paramFloat3, paramInt, paramBoolean);
  }

  public GlyphLayout addText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, int paramInt3, boolean paramBoolean)
  {
    GlyphLayout localGlyphLayout = (GlyphLayout)Pools.obtain(GlyphLayout.class);
    this.pooledLayouts.add(localGlyphLayout);
    localGlyphLayout.setText(this.font, paramCharSequence, paramInt1, paramInt2, this.color, paramFloat3, paramInt3, paramBoolean, null);
    addText(localGlyphLayout, paramFloat1, paramFloat2);
    return localGlyphLayout;
  }

  public void addText(GlyphLayout paramGlyphLayout, float paramFloat1, float paramFloat2)
  {
    addToCache(paramGlyphLayout, paramFloat1, paramFloat2 + this.font.data.ascent);
  }

  public void clear()
  {
    this.x = 0.0F;
    this.y = 0.0F;
    Pools.freeAll(this.pooledLayouts, true);
    this.pooledLayouts.clear();
    this.layouts.clear();
    int i = this.idx.length;
    for (int j = 0; j < i; j++)
    {
      if (this.pageGlyphIndices != null)
        this.pageGlyphIndices[j].clear();
      this.idx[j] = 0;
    }
  }

  public void draw(Batch paramBatch)
  {
    Array localArray = this.font.getRegions();
    int i = this.pageVertices.length;
    for (int j = 0; j < i; j++)
    {
      if (this.idx[j] <= 0)
        continue;
      float[] arrayOfFloat = this.pageVertices[j];
      paramBatch.draw(((TextureRegion)localArray.get(j)).getTexture(), arrayOfFloat, 0, this.idx[j]);
    }
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    if (paramFloat == 1.0F)
    {
      draw(paramBatch);
      return;
    }
    Color localColor = getColor();
    float f = localColor.a;
    localColor.a = (paramFloat * localColor.a);
    setColors(localColor);
    draw(paramBatch);
    localColor.a = f;
    setColors(localColor);
  }

  public void draw(Batch paramBatch, int paramInt1, int paramInt2)
  {
    if (this.pageVertices.length == 1)
    {
      paramBatch.draw(this.font.getRegion().getTexture(), this.pageVertices[0], paramInt1 * 20, 20 * (paramInt2 - paramInt1));
      return;
    }
    Array localArray = this.font.getRegions();
    int i = this.pageVertices.length;
    int j = 0;
    label61: int m;
    int n;
    int i1;
    if (j < i)
    {
      IntArray localIntArray = this.pageGlyphIndices[j];
      int k = localIntArray.size;
      m = 0;
      n = 0;
      i1 = -1;
      label93: if (m < k)
      {
        int i2 = localIntArray.get(m);
        if (i2 < paramInt2)
        {
          if ((i1 == -1) && (i2 >= paramInt1))
            i1 = m;
          if (i2 < paramInt1)
            break label206;
        }
      }
    }
    label206: for (int i3 = n + 1; ; i3 = n)
    {
      m++;
      n = i3;
      break label93;
      if ((i1 != -1) && (n != 0))
        paramBatch.draw(((TextureRegion)localArray.get(j)).getTexture(), this.pageVertices[j], i1 * 20, n * 20);
      j++;
      break label61;
      break;
    }
  }

  public Color getColor()
  {
    return this.color;
  }

  public BitmapFont getFont()
  {
    return this.font;
  }

  public Array getLayouts()
  {
    return this.layouts;
  }

  public float[] getVertices()
  {
    return getVertices(0);
  }

  public float[] getVertices(int paramInt)
  {
    return this.pageVertices[paramInt];
  }

  public float getX()
  {
    return this.x;
  }

  public float getY()
  {
    return this.y;
  }

  public void setAlphas(float paramFloat)
  {
    float f1 = 0.0F;
    int i = (int)(254.0F * paramFloat) << 24;
    int j = this.pageVertices.length;
    int k = 0;
    float f2 = 0.0F;
    while (k < j)
    {
      float[] arrayOfFloat = this.pageVertices[k];
      int m = this.idx[k];
      int n = 2;
      if (n < m)
      {
        float f3 = arrayOfFloat[n];
        if ((f3 == f1) && (n != 2))
          arrayOfFloat[n] = f2;
        while (true)
        {
          n += 5;
          break;
          f2 = NumberUtils.intToFloatColor(i | 0xFFFFFF & NumberUtils.floatToIntColor(f3));
          arrayOfFloat[n] = f2;
          f1 = f3;
        }
      }
      k++;
    }
  }

  public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public void setColor(Color paramColor)
  {
    this.color.set(paramColor);
  }

  public void setColors(float paramFloat)
  {
    int i = this.pageVertices.length;
    for (int j = 0; j < i; j++)
    {
      float[] arrayOfFloat = this.pageVertices[j];
      int k = 2;
      int m = this.idx[j];
      while (k < m)
      {
        arrayOfFloat[k] = paramFloat;
        k += 5;
      }
    }
  }

  public void setColors(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setColors(NumberUtils.intToFloatColor((int)(255.0F * paramFloat4) << 24 | (int)(255.0F * paramFloat3) << 16 | (int)(255.0F * paramFloat2) << 8 | (int)(255.0F * paramFloat1)));
  }

  public void setColors(float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.pageVertices.length == 1)
    {
      float[] arrayOfFloat2 = this.pageVertices[0];
      int i2 = 2 + paramInt1 * 20;
      int i3 = paramInt2 * 20;
      while (i2 < i3)
      {
        arrayOfFloat2[i2] = paramFloat;
        i2 += 5;
      }
    }
    int i = this.pageVertices.length;
    for (int j = 0; j < i; j++)
    {
      float[] arrayOfFloat1 = this.pageVertices[j];
      IntArray localIntArray = this.pageGlyphIndices[j];
      int k = localIntArray.size;
      for (int m = 0; m < k; m++)
      {
        int n = localIntArray.items[m];
        if (n >= paramInt2)
          break;
        if (n < paramInt1)
          continue;
        for (int i1 = 0; i1 < 20; i1 += 5)
          arrayOfFloat1[(i1 + (2 + m * 20))] = paramFloat;
      }
    }
  }

  public void setColors(Color paramColor)
  {
    setColors(paramColor.toFloatBits());
  }

  public void setColors(Color paramColor, int paramInt1, int paramInt2)
  {
    setColors(paramColor.toFloatBits(), paramInt1, paramInt2);
  }

  public void setPosition(float paramFloat1, float paramFloat2)
  {
    translate(paramFloat1 - this.x, paramFloat2 - this.y);
  }

  public GlyphLayout setText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2)
  {
    clear();
    return addText(paramCharSequence, paramFloat1, paramFloat2, 0, paramCharSequence.length(), 0.0F, 8, false);
  }

  public GlyphLayout setText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, boolean paramBoolean)
  {
    clear();
    return addText(paramCharSequence, paramFloat1, paramFloat2, 0, paramCharSequence.length(), paramFloat3, paramInt, paramBoolean);
  }

  public GlyphLayout setText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, int paramInt3, boolean paramBoolean)
  {
    clear();
    return addText(paramCharSequence, paramFloat1, paramFloat2, paramInt1, paramInt2, paramFloat3, paramInt3, paramBoolean);
  }

  public void setText(GlyphLayout paramGlyphLayout, float paramFloat1, float paramFloat2)
  {
    clear();
    addText(paramGlyphLayout, paramFloat1, paramFloat2);
  }

  public void setUseIntegerPositions(boolean paramBoolean)
  {
    this.integer = paramBoolean;
  }

  public void tint(Color paramColor)
  {
    float f1 = paramColor.toFloatBits();
    if (this.currentTint == f1);
    while (true)
    {
      return;
      this.currentTint = f1;
      int[] arrayOfInt = this.tempGlyphCount;
      int i = 0;
      int j = arrayOfInt.length;
      while (i < j)
      {
        arrayOfInt[i] = 0;
        i++;
      }
      int k = this.layouts.size;
      for (int m = 0; m < k; m++)
      {
        GlyphLayout localGlyphLayout = (GlyphLayout)this.layouts.get(m);
        int n = localGlyphLayout.runs.size;
        for (int i1 = 0; i1 < n; i1++)
        {
          GlyphLayout.GlyphRun localGlyphRun = (GlyphLayout.GlyphRun)localGlyphLayout.runs.get(i1);
          Array localArray = localGlyphRun.glyphs;
          float f2 = tempColor.set(localGlyphRun.color).mul(paramColor).toFloatBits();
          int i2 = localArray.size;
          for (int i3 = 0; i3 < i2; i3++)
          {
            int i4 = ((BitmapFont.Glyph)localArray.get(i3)).page;
            int i5 = 2 + 20 * arrayOfInt[i4];
            arrayOfInt[i4] = (1 + arrayOfInt[i4]);
            float[] arrayOfFloat = this.pageVertices[i4];
            for (int i6 = 0; i6 < 20; i6 += 5)
              arrayOfFloat[(i5 + i6)] = f2;
          }
        }
      }
    }
  }

  public void translate(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F));
    while (true)
    {
      return;
      if (this.integer)
      {
        paramFloat1 = Math.round(paramFloat1);
        paramFloat2 = Math.round(paramFloat2);
      }
      this.x = (paramFloat1 + this.x);
      this.y = (paramFloat2 + this.y);
      int i = this.pageVertices.length;
      for (int j = 0; j < i; j++)
      {
        float[] arrayOfFloat = this.pageVertices[j];
        int k = this.idx[j];
        for (int m = 0; m < k; m += 5)
        {
          arrayOfFloat[m] = (paramFloat1 + arrayOfFloat[m]);
          int n = m + 1;
          arrayOfFloat[n] = (paramFloat2 + arrayOfFloat[n]);
        }
      }
    }
  }

  public boolean usesIntegerPositions()
  {
    return this.integer;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.BitmapFontCache
 * JD-Core Version:    0.6.0
 */