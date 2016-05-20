package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.StringBuilder;

public class Label extends Widget
{
  private static final GlyphLayout prefSizeLayout;
  private static final Color tempColor = new Color();
  private BitmapFontCache cache;
  private String ellipsis;
  private float fontScaleX = 1.0F;
  private float fontScaleY = 1.0F;
  private int labelAlign = 8;
  private float lastPrefHeight;
  private final GlyphLayout layout = new GlyphLayout();
  private int lineAlign = 8;
  private final Vector2 prefSize = new Vector2();
  private boolean prefSizeInvalid = true;
  private Label.LabelStyle style;
  private final StringBuilder text = new StringBuilder();
  private boolean wrap;

  static
  {
    prefSizeLayout = new GlyphLayout();
  }

  public Label(CharSequence paramCharSequence, Label.LabelStyle paramLabelStyle)
  {
    if (paramCharSequence != null)
      this.text.append(paramCharSequence);
    setStyle(paramLabelStyle);
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      setSize(getPrefWidth(), getPrefHeight());
  }

  public Label(CharSequence paramCharSequence, Skin paramSkin)
  {
    this(paramCharSequence, (Label.LabelStyle)paramSkin.get(Label.LabelStyle.class));
  }

  public Label(CharSequence paramCharSequence, Skin paramSkin, String paramString)
  {
    this(paramCharSequence, (Label.LabelStyle)paramSkin.get(paramString, Label.LabelStyle.class));
  }

  public Label(CharSequence paramCharSequence, Skin paramSkin, String paramString, Color paramColor)
  {
    this(paramCharSequence, new Label.LabelStyle(paramSkin.getFont(paramString), paramColor));
  }

  public Label(CharSequence paramCharSequence, Skin paramSkin, String paramString1, String paramString2)
  {
    this(paramCharSequence, new Label.LabelStyle(paramSkin.getFont(paramString1), paramSkin.getColor(paramString2)));
  }

  private void computePrefSize()
  {
    this.prefSizeInvalid = false;
    GlyphLayout localGlyphLayout = prefSizeLayout;
    if ((this.wrap) && (this.ellipsis == null))
    {
      float f = getWidth();
      if (this.style.background != null)
        f -= this.style.background.getLeftWidth() + this.style.background.getRightWidth();
      localGlyphLayout.setText(this.cache.getFont(), this.text, Color.WHITE, f, 8, true);
    }
    while (true)
    {
      this.prefSize.set(localGlyphLayout.width, localGlyphLayout.height);
      return;
      localGlyphLayout.setText(this.cache.getFont(), this.text);
    }
  }

  private void scaleAndComputePrefSize()
  {
    BitmapFont localBitmapFont = this.cache.getFont();
    float f1 = localBitmapFont.getScaleX();
    float f2 = localBitmapFont.getScaleY();
    if ((this.fontScaleX != 1.0F) || (this.fontScaleY != 1.0F))
      localBitmapFont.getData().setScale(this.fontScaleX, this.fontScaleY);
    computePrefSize();
    if ((this.fontScaleX != 1.0F) || (this.fontScaleY != 1.0F))
      localBitmapFont.getData().setScale(f1, f2);
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    validate();
    Color localColor = tempColor.set(getColor());
    localColor.a = (paramFloat * localColor.a);
    if (this.style.background != null)
    {
      paramBatch.setColor(localColor.r, localColor.g, localColor.b, localColor.a);
      this.style.background.draw(paramBatch, getX(), getY(), getWidth(), getHeight());
    }
    if (this.style.fontColor != null)
      localColor.mul(this.style.fontColor);
    this.cache.tint(localColor);
    this.cache.setPosition(getX(), getY());
    this.cache.draw(paramBatch);
  }

  protected BitmapFontCache getBitmapFontCache()
  {
    return this.cache;
  }

  public float getFontScaleX()
  {
    return this.fontScaleX;
  }

  public float getFontScaleY()
  {
    return this.fontScaleY;
  }

  public GlyphLayout getGlyphLayout()
  {
    return this.layout;
  }

  public int getLabelAlign()
  {
    return this.labelAlign;
  }

  public int getLineAlign()
  {
    return this.lineAlign;
  }

  public float getPrefHeight()
  {
    if (this.prefSizeInvalid)
      scaleAndComputePrefSize();
    float f = this.prefSize.y - 2.0F * (this.style.font.getDescent() * this.fontScaleY);
    Drawable localDrawable = this.style.background;
    if (localDrawable != null)
      f += localDrawable.getTopHeight() + localDrawable.getBottomHeight();
    return f;
  }

  public float getPrefWidth()
  {
    float f;
    if (this.wrap)
      f = 0.0F;
    Drawable localDrawable;
    do
    {
      return f;
      if (this.prefSizeInvalid)
        scaleAndComputePrefSize();
      f = this.prefSize.x;
      localDrawable = this.style.background;
    }
    while (localDrawable == null);
    return f + (localDrawable.getLeftWidth() + localDrawable.getRightWidth());
  }

  public Label.LabelStyle getStyle()
  {
    return this.style;
  }

  public StringBuilder getText()
  {
    return this.text;
  }

  public void invalidate()
  {
    super.invalidate();
    this.prefSizeInvalid = true;
  }

  public void layout()
  {
    BitmapFont localBitmapFont = this.cache.getFont();
    float f1 = localBitmapFont.getScaleX();
    float f2 = localBitmapFont.getScaleY();
    if ((this.fontScaleX != 1.0F) || (this.fontScaleY != 1.0F))
      localBitmapFont.getData().setScale(this.fontScaleX, this.fontScaleY);
    boolean bool;
    float f3;
    float f4;
    float f6;
    float f7;
    float f5;
    if ((this.wrap) && (this.ellipsis == null))
    {
      bool = true;
      if (bool)
      {
        float f17 = getPrefHeight();
        if (f17 != this.lastPrefHeight)
        {
          this.lastPrefHeight = f17;
          invalidateHierarchy();
        }
      }
      f3 = getWidth();
      f4 = getHeight();
      Drawable localDrawable = this.style.background;
      if (localDrawable == null)
        break label570;
      float f14 = localDrawable.getLeftWidth();
      float f15 = localDrawable.getBottomHeight();
      f3 -= localDrawable.getLeftWidth() + localDrawable.getRightWidth();
      float f16 = f4 - (localDrawable.getBottomHeight() + localDrawable.getTopHeight());
      f6 = f15;
      f7 = f14;
      f5 = f16;
    }
    while (true)
    {
      GlyphLayout localGlyphLayout = this.layout;
      float f8;
      float f9;
      if ((bool) || (this.text.indexOf("\n") != -1))
      {
        localGlyphLayout.setText(localBitmapFont, this.text, 0, this.text.length, Color.WHITE, f3, this.lineAlign, bool, this.ellipsis);
        f8 = localGlyphLayout.width;
        f9 = localGlyphLayout.height;
        if ((0x8 & this.labelAlign) != 0)
          break label563;
        if ((0x10 & this.labelAlign) != 0)
        {
          f7 += f3 - f8;
          f3 = f8;
        }
      }
      while (true)
      {
        label301: float f13;
        label326: float f10;
        label344: float f11;
        if ((0x2 & this.labelAlign) != 0)
          if (this.cache.getFont().isFlipped())
          {
            f13 = 0.0F;
            f10 = f13 + f6 + this.style.font.getDescent();
            if (this.cache.getFont().isFlipped())
              break label556;
            f11 = f10 + f9;
          }
        while (true)
        {
          localGlyphLayout.setText(localBitmapFont, this.text, 0, this.text.length, Color.WHITE, f3, this.lineAlign, bool, this.ellipsis);
          this.cache.setText(localGlyphLayout, f7, f11);
          if ((this.fontScaleX != 1.0F) || (this.fontScaleY != 1.0F))
            localBitmapFont.getData().setScale(f1, f2);
          return;
          bool = false;
          break;
          f7 += (f3 - f8) / 2.0F;
          f3 = f8;
          break label301;
          f9 = localBitmapFont.getData().capHeight;
          break label301;
          f13 = f5 - f9;
          break label326;
          if ((0x4 & this.labelAlign) != 0)
          {
            float f12;
            if (this.cache.getFont().isFlipped())
              f12 = f5 - f9;
            while (true)
            {
              f10 = f12 + f6 - this.style.font.getDescent();
              break;
              f12 = 0.0F;
            }
          }
          f10 = f6 + (f5 - f9) / 2.0F;
          break label344;
          label556: f11 = f10;
        }
        label563: f3 = f8;
      }
      label570: f5 = f4;
      f6 = 0.0F;
      f7 = 0.0F;
    }
  }

  public void setAlignment(int paramInt)
  {
    setAlignment(paramInt, paramInt);
  }

  public void setAlignment(int paramInt1, int paramInt2)
  {
    this.labelAlign = paramInt1;
    if ((paramInt2 & 0x8) != 0)
      this.lineAlign = 8;
    while (true)
    {
      invalidate();
      return;
      if ((paramInt2 & 0x10) != 0)
      {
        this.lineAlign = 16;
        continue;
      }
      this.lineAlign = 1;
    }
  }

  public void setEllipsis(String paramString)
  {
    this.ellipsis = paramString;
  }

  public void setEllipsis(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ellipsis = "...";
      return;
    }
    this.ellipsis = null;
  }

  public void setFontScale(float paramFloat)
  {
    this.fontScaleX = paramFloat;
    this.fontScaleY = paramFloat;
    invalidateHierarchy();
  }

  public void setFontScale(float paramFloat1, float paramFloat2)
  {
    this.fontScaleX = paramFloat1;
    this.fontScaleY = paramFloat2;
    invalidateHierarchy();
  }

  public void setFontScaleX(float paramFloat)
  {
    this.fontScaleX = paramFloat;
    invalidateHierarchy();
  }

  public void setFontScaleY(float paramFloat)
  {
    this.fontScaleY = paramFloat;
    invalidateHierarchy();
  }

  public void setStyle(Label.LabelStyle paramLabelStyle)
  {
    if (paramLabelStyle == null)
      throw new IllegalArgumentException("style cannot be null.");
    if (paramLabelStyle.font == null)
      throw new IllegalArgumentException("Missing LabelStyle font.");
    this.style = paramLabelStyle;
    this.cache = paramLabelStyle.font.newFontCache();
    invalidateHierarchy();
  }

  public void setText(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null);
    for (Object localObject = ""; ; localObject = paramCharSequence)
    {
      if ((localObject instanceof StringBuilder))
      {
        if (this.text.equals(localObject))
          return;
        this.text.setLength(0);
        this.text.append((StringBuilder)localObject);
      }
      while (true)
      {
        invalidateHierarchy();
        return;
        if (textEquals((CharSequence)localObject))
          break;
        this.text.setLength(0);
        this.text.append((CharSequence)localObject);
      }
    }
  }

  public void setWrap(boolean paramBoolean)
  {
    this.wrap = paramBoolean;
    invalidateHierarchy();
  }

  public boolean textEquals(CharSequence paramCharSequence)
  {
    int i = this.text.length;
    char[] arrayOfChar = this.text.chars;
    if (i != paramCharSequence.length())
      return false;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label58;
      if (arrayOfChar[j] != paramCharSequence.charAt(j))
        break;
    }
    label58: return true;
  }

  public String toString()
  {
    return super.toString() + ": " + this.text;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Label
 * JD-Core Version:    0.6.0
 */