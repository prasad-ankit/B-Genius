package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.utils.Pools;

public class GlyphLayout
  implements Pool.Poolable
{
  private final Array colorStack = new Array(4);
  public float height;
  public final Array runs = new Array();
  public float width;

  public GlyphLayout()
  {
  }

  public GlyphLayout(BitmapFont paramBitmapFont, CharSequence paramCharSequence)
  {
    setText(paramBitmapFont, paramCharSequence);
  }

  public GlyphLayout(BitmapFont paramBitmapFont, CharSequence paramCharSequence, int paramInt1, int paramInt2, Color paramColor, float paramFloat, int paramInt3, boolean paramBoolean, String paramString)
  {
    setText(paramBitmapFont, paramCharSequence, paramInt1, paramInt2, paramColor, paramFloat, paramInt3, paramBoolean, paramString);
  }

  public GlyphLayout(BitmapFont paramBitmapFont, CharSequence paramCharSequence, Color paramColor, float paramFloat, int paramInt, boolean paramBoolean)
  {
    setText(paramBitmapFont, paramCharSequence, paramColor, paramFloat, paramInt, paramBoolean);
  }

  private void adjustLastGlyph(BitmapFont.BitmapFontData paramBitmapFontData, GlyphLayout.GlyphRun paramGlyphRun)
  {
    BitmapFont.Glyph localGlyph = (BitmapFont.Glyph)paramGlyphRun.glyphs.peek();
    if (paramBitmapFontData.isWhitespace((char)localGlyph.id))
      return;
    float f = (localGlyph.xoffset + localGlyph.width) * paramBitmapFontData.scaleX - paramBitmapFontData.padRight;
    paramGlyphRun.width += f - paramGlyphRun.xAdvances.peek();
    paramGlyphRun.xAdvances.set(-1 + paramGlyphRun.xAdvances.size, f);
  }

  private int parseColorMarkup(CharSequence paramCharSequence, int paramInt1, int paramInt2, Pool paramPool)
  {
    int i = 0;
    if (paramInt1 == paramInt2)
      return -1;
    int i2;
    Color localColor2;
    int j;
    int k;
    int m;
    switch (paramCharSequence.charAt(paramInt1))
    {
    default:
      i2 = paramInt1 + 1;
      if (i2 < paramInt2)
        if (paramCharSequence.charAt(i2) == ']')
        {
          localColor2 = Colors.get(paramCharSequence.subSequence(paramInt1, i2).toString());
          if (localColor2 == null)
            return -1;
        }
    case '#':
      j = paramInt1 + 1;
      k = 0;
      if (j < paramInt2)
      {
        m = paramCharSequence.charAt(j);
        if (m != 93)
          break;
        if ((j >= paramInt1 + 2) && (j <= paramInt1 + 9))
        {
          if (j - paramInt1 > 7)
            break label385;
          int i1 = 9 - (j - paramInt1);
          while (i < i1)
          {
            k <<= 4;
            i++;
          }
        }
      }
    case '[':
    case ']':
    }
    label385: for (int n = k | 0xFF; ; n = k)
    {
      Color localColor1 = (Color)paramPool.obtain();
      this.colorStack.add(localColor1);
      Color.rgba8888ToColor(localColor1, n);
      return j - paramInt1;
      if ((m >= 48) && (m <= 57))
        k = (k << 4) + (m - 48);
      while (true)
      {
        j++;
        break;
        if ((m >= 97) && (m <= 102))
        {
          k = (k << 4) + (m - 87);
          continue;
        }
        if ((m < 65) || (m > 70))
          break label316;
        k = (k << 4) + (m - 55);
      }
      label316: return -1;
      return -1;
      if (this.colorStack.size > 1)
        paramPool.free(this.colorStack.pop());
      return 0;
      Color localColor3 = (Color)paramPool.obtain();
      this.colorStack.add(localColor3);
      localColor3.set(localColor2);
      return i2 - paramInt1;
      i2++;
      break;
      return -1;
    }
  }

  private void truncate(BitmapFont.BitmapFontData paramBitmapFontData, GlyphLayout.GlyphRun paramGlyphRun, float paramFloat, String paramString, int paramInt, Pool paramPool)
  {
    GlyphLayout.GlyphRun localGlyphRun = (GlyphLayout.GlyphRun)paramPool.obtain();
    paramBitmapFontData.getGlyphs(localGlyphRun, paramString, 0, paramString.length());
    int i = localGlyphRun.xAdvances.size;
    float f1 = 0.0F;
    int j = 1;
    while (j < i)
    {
      float f5 = f1 + localGlyphRun.xAdvances.get(j);
      j++;
      f1 = f5;
    }
    float f2 = paramFloat - f1;
    float f3 = paramGlyphRun.x;
    int k = 0;
    if (k < paramGlyphRun.xAdvances.size)
    {
      float f4 = paramGlyphRun.xAdvances.get(k);
      f3 += f4;
      if (f3 > f2)
        paramGlyphRun.width = (f3 - paramGlyphRun.x - f4);
    }
    else
    {
      if (k <= 1)
        break label231;
      paramGlyphRun.glyphs.truncate(k - 1);
      paramGlyphRun.xAdvances.truncate(k);
      adjustLastGlyph(paramBitmapFontData, paramGlyphRun);
      paramGlyphRun.xAdvances.addAll(localGlyphRun.xAdvances, 1, -1 + localGlyphRun.xAdvances.size);
    }
    while (true)
    {
      paramGlyphRun.glyphs.addAll(localGlyphRun.glyphs);
      paramGlyphRun.width = (f1 + paramGlyphRun.width);
      paramPool.free(localGlyphRun);
      return;
      k++;
      break;
      label231: paramGlyphRun.glyphs.clear();
      paramGlyphRun.xAdvances.clear();
      paramGlyphRun.xAdvances.addAll(localGlyphRun.xAdvances);
      paramGlyphRun.width += localGlyphRun.xAdvances.get(0);
    }
  }

  private GlyphLayout.GlyphRun wrap(BitmapFont.BitmapFontData paramBitmapFontData, GlyphLayout.GlyphRun paramGlyphRun, Pool paramPool, int paramInt1, int paramInt2)
  {
    GlyphLayout.GlyphRun localGlyphRun = (GlyphLayout.GlyphRun)paramPool.obtain();
    localGlyphRun.color.set(paramGlyphRun.color);
    int i = paramGlyphRun.glyphs.size;
    if (paramInt1 < i)
    {
      localGlyphRun.glyphs.addAll(paramGlyphRun.glyphs, paramInt1, i - paramInt1);
      localGlyphRun.xAdvances.add(-((BitmapFont.Glyph)localGlyphRun.glyphs.first()).xoffset * paramBitmapFontData.scaleX - paramBitmapFontData.padLeft);
      localGlyphRun.xAdvances.addAll(paramGlyphRun.xAdvances, paramInt1 + 1, paramGlyphRun.xAdvances.size - (paramInt1 + 1));
    }
    int k;
    for (int j = paramInt2; j < paramInt1; j = k)
    {
      float f2 = paramGlyphRun.width;
      FloatArray localFloatArray2 = paramGlyphRun.xAdvances;
      k = j + 1;
      paramGlyphRun.width = (f2 + localFloatArray2.get(j));
    }
    while (j > paramInt1 + 1)
    {
      float f1 = paramGlyphRun.width;
      FloatArray localFloatArray1 = paramGlyphRun.xAdvances;
      j--;
      paramGlyphRun.width = (f1 - localFloatArray1.get(j));
    }
    if (paramInt1 == 0)
    {
      paramPool.free(paramGlyphRun);
      this.runs.pop();
      return localGlyphRun;
    }
    paramGlyphRun.glyphs.truncate(paramInt1);
    paramGlyphRun.xAdvances.truncate(paramInt1 + 1);
    adjustLastGlyph(paramBitmapFontData, paramGlyphRun);
    return localGlyphRun;
  }

  public void reset()
  {
    Pools.get(GlyphLayout.GlyphRun.class).freeAll(this.runs);
    this.runs.clear();
    this.width = 0.0F;
    this.height = 0.0F;
  }

  public void setText(BitmapFont paramBitmapFont, CharSequence paramCharSequence)
  {
    setText(paramBitmapFont, paramCharSequence, 0, paramCharSequence.length(), paramBitmapFont.getColor(), 0.0F, 8, false, null);
  }

  public void setText(BitmapFont paramBitmapFont, CharSequence paramCharSequence, int paramInt1, int paramInt2, Color paramColor, float paramFloat, int paramInt3, boolean paramBoolean, String paramString)
  {
    BitmapFont.BitmapFontData localBitmapFontData;
    boolean bool;
    Pool localPool1;
    Array localArray1;
    float f1;
    float f2;
    float f3;
    int i;
    Array localArray2;
    Pool localPool2;
    int j;
    Color localColor;
    Object localObject1;
    int k;
    int i3;
    int i2;
    if (paramString != null)
    {
      paramBoolean = true;
      localBitmapFontData = paramBitmapFont.data;
      bool = localBitmapFontData.markupEnabled;
      localPool1 = Pools.get(GlyphLayout.GlyphRun.class);
      localArray1 = this.runs;
      localPool1.freeAll(localArray1);
      localArray1.clear();
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      i = 0;
      localArray2 = this.colorStack;
      localArray2.add(paramColor);
      localPool2 = Pools.get(Color.class);
      j = paramInt1;
      localColor = paramColor;
      localObject1 = paramColor;
      k = paramInt1;
      if (k != paramInt2)
        break label435;
      if (j != paramInt2)
      {
        i3 = 0;
        i2 = paramInt2;
      }
    }
    Object localObject3;
    float f10;
    float f11;
    float f9;
    int i9;
    int i10;
    float f12;
    float f13;
    float f20;
    while (true)
    {
      if (i2 == -1)
        break label1211;
      if (i2 == j)
        break label1192;
      GlyphLayout.GlyphRun localGlyphRun1 = (GlyphLayout.GlyphRun)localPool1.obtain();
      localArray1.add(localGlyphRun1);
      localGlyphRun1.color.set((Color)localObject1);
      localGlyphRun1.x = f1;
      localGlyphRun1.y = f2;
      localBitmapFontData.getGlyphs(localGlyphRun1, paramCharSequence, j, i2);
      localObject3 = localGlyphRun1.xAdvances.items;
      int i7 = localGlyphRun1.xAdvances.size;
      f10 = f2;
      i8 = 0;
      f11 = f3;
      f9 = f1;
      i9 = i;
      i10 = i7;
      localObject4 = localGlyphRun1;
      if (i8 >= i10)
        break label793;
      f12 = localObject3[i8];
      f13 = f9 + f12;
      if ((!paramBoolean) || (f13 <= paramFloat) || (i8 <= 1) || (f13 - f12 + (((BitmapFont.Glyph)((GlyphLayout.GlyphRun)localObject4).glyphs.get(i8 - 1)).xoffset + ((BitmapFont.Glyph)((GlyphLayout.GlyphRun)localObject4).glyphs.get(i8 - 1)).width) * localBitmapFontData.scaleX - 1.0E-004F <= paramFloat))
        break label753;
      if (paramString == null)
        break label563;
      truncate(localBitmapFontData, (GlyphLayout.GlyphRun)localObject4, paramFloat, paramString, i8, localPool1);
      float f19 = ((GlyphLayout.GlyphRun)localObject4).x + ((GlyphLayout.GlyphRun)localObject4).width;
      i = i9;
      f3 = f11;
      f1 = f19;
      f20 = Math.max(f3, f1);
      int i15 = 1;
      int i16 = localArray2.size;
      while (i15 < i16)
      {
        localPool2.free(localArray2.get(i15));
        i15++;
      }
      if (paramFloat > paramBitmapFont.data.spaceWidth)
        break;
      paramBoolean = false;
      break;
      label435: int m = k + 1;
      switch (paramCharSequence.charAt(k))
      {
      default:
      case '\n':
      case '[':
      }
      int n;
      do
      {
        do
        {
          k = m;
          i2 = -1;
          i3 = 0;
          break;
          i2 = m - 1;
          k = m;
          i3 = 1;
          break;
        }
        while (!bool);
        n = parseColorMarkup(paramCharSequence, m, paramInt2, localPool2);
      }
      while (n < 0);
      int i1 = m - 1;
      k = m + (n + 1);
      localColor = (Color)localArray2.peek();
      i2 = i1;
      i3 = 0;
    }
    label563: int i13 = localBitmapFontData.getWrapIndex(((GlyphLayout.GlyphRun)localObject4).glyphs, i8);
    if (((((GlyphLayout.GlyphRun)localObject4).x == 0.0F) && (i13 == 0)) || (i13 >= ((GlyphLayout.GlyphRun)localObject4).glyphs.size))
      i13 = i8 - 1;
    GlyphLayout.GlyphRun localGlyphRun2 = wrap(localBitmapFontData, (GlyphLayout.GlyphRun)localObject4, localPool1, i13, i8);
    localArray1.add(localGlyphRun2);
    float f15 = Math.max(f11, ((GlyphLayout.GlyphRun)localObject4).x + ((GlyphLayout.GlyphRun)localObject4).width);
    float f18 = f10 + localBitmapFontData.down;
    int i14 = i9 + 1;
    localGlyphRun2.x = 0.0F;
    localGlyphRun2.y = f18;
    int i8 = -1;
    int i11 = localGlyphRun2.xAdvances.size;
    Object localObject5 = localGlyphRun2.xAdvances.items;
    float f14 = f18;
    float f16 = 0.0F;
    Object localObject4 = localGlyphRun2;
    int i12 = i14;
    while (true)
    {
      i8++;
      localObject3 = localObject5;
      f10 = f14;
      i9 = i12;
      i10 = i11;
      float f17 = f16;
      f11 = f15;
      f9 = f17;
      break;
      label753: ((GlyphLayout.GlyphRun)localObject4).width = (f12 + ((GlyphLayout.GlyphRun)localObject4).width);
      i11 = i10;
      i12 = i9;
      f14 = f10;
      localObject5 = localObject3;
      f15 = f11;
      f16 = f13;
    }
    label793: int i6 = i9;
    float f7 = f11;
    float f8 = f10;
    label805: if (i3 != 0)
    {
      f7 = Math.max(f7, f9);
      f9 = 0.0F;
      f8 += localBitmapFontData.down;
      i6++;
    }
    float f6 = f9;
    Object localObject2 = localColor;
    float f5 = f8;
    float f4 = f7;
    int i5 = i6;
    int i4 = k;
    while (true)
    {
      localObject1 = localObject2;
      f1 = f6;
      f2 = f5;
      f3 = f4;
      i = i5;
      j = i4;
      break;
      localArray2.clear();
      int i17;
      float f21;
      int i18;
      int i19;
      int i20;
      GlyphLayout.GlyphRun localGlyphRun4;
      float f28;
      int i22;
      float f29;
      label992: float f25;
      if ((paramInt3 & 0x8) == 0)
      {
        if ((paramInt3 & 0x1) != 0)
          i17 = 1;
        while (true)
        {
          f21 = 0.0F;
          float f22 = -2.147484E+009F;
          i18 = 0;
          i19 = localArray1.size;
          i20 = 0;
          if (i20 >= i19)
            break;
          localGlyphRun4 = (GlyphLayout.GlyphRun)localArray1.get(i20);
          if (localGlyphRun4.y == f22)
            break label1181;
          float f27 = localGlyphRun4.y;
          f28 = paramFloat - f21;
          if (i17 == 0)
            break label1170;
          float f30 = f28 / 2.0F;
          i22 = i18;
          f29 = f30;
          while (true)
            if (i22 < i20)
            {
              int i23 = i22 + 1;
              GlyphLayout.GlyphRun localGlyphRun5 = (GlyphLayout.GlyphRun)localArray1.get(i22);
              localGlyphRun5.x = (f29 + localGlyphRun5.x);
              i22 = i23;
              continue;
              i17 = 0;
              break;
            }
          f25 = 0.0F;
          f22 = f27;
        }
      }
      while (true)
      {
        float f26 = f25 + localGlyphRun4.width;
        i20++;
        i18 = i22;
        f21 = f26;
        break;
        float f23 = paramFloat - f21;
        float f24;
        if (i17 != 0)
          f24 = f23 / 2.0F;
        while (true)
        {
          if (i18 < i19)
          {
            int i21 = i18 + 1;
            GlyphLayout.GlyphRun localGlyphRun3 = (GlyphLayout.GlyphRun)localArray1.get(i18);
            localGlyphRun3.x = (f24 + localGlyphRun3.x);
            i18 = i21;
            continue;
          }
          this.width = f20;
          this.height = (localBitmapFontData.capHeight + i * localBitmapFontData.lineHeight);
          return;
          f24 = f23;
        }
        label1170: i22 = i18;
        f29 = f28;
        break label992;
        label1181: f25 = f21;
        i22 = i18;
      }
      label1192: i6 = i;
      f7 = f3;
      f8 = f2;
      f9 = f1;
      break label805;
      label1211: i4 = j;
      i5 = i;
      f4 = f3;
      f5 = f2;
      f6 = f1;
      localObject2 = localObject1;
    }
  }

  public void setText(BitmapFont paramBitmapFont, CharSequence paramCharSequence, Color paramColor, float paramFloat, int paramInt, boolean paramBoolean)
  {
    setText(paramBitmapFont, paramCharSequence, 0, paramCharSequence.length(), paramColor, paramFloat, paramInt, paramBoolean, null);
  }

  public String toString()
  {
    if (this.runs.size == 0)
      return "";
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.width);
    localStringBuilder.append('x');
    localStringBuilder.append(this.height);
    localStringBuilder.append('\n');
    int i = this.runs.size;
    for (int j = 0; j < i; j++)
    {
      localStringBuilder.append(((GlyphLayout.GlyphRun)this.runs.get(j)).toString());
      localStringBuilder.append('\n');
    }
    localStringBuilder.setLength(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.GlyphLayout
 * JD-Core Version:    0.6.0
 */