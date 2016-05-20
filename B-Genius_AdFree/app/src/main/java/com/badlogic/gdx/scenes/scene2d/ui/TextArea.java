package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class TextArea extends TextField
{
  int cursorLine;
  int firstLineShowing;
  private String lastText;
  IntArray linesBreak;
  private int linesShowing;
  float moveOffset;
  private float prefRows;

  public TextArea(String paramString, Skin paramSkin)
  {
    super(paramString, paramSkin);
  }

  public TextArea(String paramString1, Skin paramSkin, String paramString2)
  {
    super(paramString1, paramSkin, paramString2);
  }

  public TextArea(String paramString, TextField.TextFieldStyle paramTextFieldStyle)
  {
    super(paramString, paramTextFieldStyle);
  }

  private int calculateCurrentLineIndex(int paramInt)
  {
    for (int i = 0; (i < this.linesBreak.size) && (paramInt > this.linesBreak.items[i]); i++);
    return i;
  }

  protected void calculateOffsets()
  {
    super.calculateOffsets();
    if (!this.text.equals(this.lastText))
    {
      this.lastText = this.text;
      BitmapFont localBitmapFont = this.style.font;
      float f1 = getWidth();
      float f2;
      if (this.style.background != null)
        f2 = this.style.background.getLeftWidth() + this.style.background.getRightWidth();
      Pool localPool;
      GlyphLayout localGlyphLayout;
      int k;
      while (true)
      {
        float f3 = f1 - f2;
        this.linesBreak.clear();
        localPool = Pools.get(GlyphLayout.class);
        localGlyphLayout = (GlyphLayout)localPool.obtain();
        int i = 0;
        int j = 0;
        k = 0;
        while (true)
        {
          if (i >= this.text.length())
            break label275;
          int m = this.text.charAt(i);
          if ((m == 13) || (m == 10))
          {
            this.linesBreak.add(k);
            this.linesBreak.add(i);
            k = i + 1;
            i++;
            continue;
            f2 = 0.0F;
            break;
          }
        }
        if (continueCursor(i, 0));
        while (true)
        {
          localGlyphLayout.setText(localBitmapFont, this.text.subSequence(k, i + 1));
          if (localGlyphLayout.width <= f3)
            break;
          if (k >= j)
            j = i - 1;
          this.linesBreak.add(k);
          this.linesBreak.add(j + 1);
          j++;
          k = j;
          break;
          j = i;
        }
      }
      label275: localPool.free(localGlyphLayout);
      if (k < this.text.length())
      {
        this.linesBreak.add(k);
        this.linesBreak.add(this.text.length());
      }
      showCursor();
    }
  }

  protected boolean continueCursor(int paramInt1, int paramInt2)
  {
    int i = calculateCurrentLineIndex(paramInt1 + paramInt2);
    return (super.continueCursor(paramInt1, paramInt2)) && ((i < 0) || (i >= -2 + this.linesBreak.size) || (this.linesBreak.items[(i + 1)] != paramInt1) || (this.linesBreak.items[(i + 1)] == this.linesBreak.items[(i + 2)]));
  }

  protected InputListener createInputListener()
  {
    return new TextArea.TextAreaListener(this);
  }

  protected void drawCursor(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2)
  {
    float f;
    if ((this.cursor >= this.glyphPositions.size) || (this.cursorLine << 1 >= this.linesBreak.size))
      f = 0.0F;
    while (true)
    {
      paramDrawable.draw(paramBatch, f + paramFloat1 + this.fontOffset + paramBitmapFont.getData().cursorX, paramFloat2 - paramBitmapFont.getDescent() / 2.0F - (1 + (this.cursorLine - this.firstLineShowing)) * paramBitmapFont.getLineHeight(), paramDrawable.getMinWidth(), paramBitmapFont.getLineHeight());
      return;
      f = this.glyphPositions.get(this.cursor) - this.glyphPositions.get(this.linesBreak.items[(this.cursorLine << 1)]);
    }
  }

  protected void drawSelection(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2)
  {
    int i = this.firstLineShowing << 1;
    int j = Math.min(this.cursor, this.selectionStart);
    int k = Math.max(this.cursor, this.selectionStart);
    float f1 = 0.0F;
    int i4;
    for (int m = i; (m + 1 < this.linesBreak.size) && (m < this.firstLineShowing + this.linesShowing << 1); m = i4)
    {
      int n = this.linesBreak.get(m);
      int i1 = this.linesBreak.get(m + 1);
      if (((j >= n) || (j >= i1) || (k >= n) || (k >= i1)) && ((j <= n) || (j <= i1) || (k <= n) || (k <= i1)))
      {
        int i2 = Math.max(this.linesBreak.get(m), j);
        int i3 = Math.min(this.linesBreak.get(m + 1), k);
        float f2 = this.glyphPositions.get(i2) - this.glyphPositions.get(this.linesBreak.get(m));
        float f3 = this.glyphPositions.get(i3) - this.glyphPositions.get(i2);
        paramDrawable.draw(paramBatch, paramFloat1 + f2 + this.fontOffset, paramFloat2 - this.textHeight - paramBitmapFont.getDescent() - f1, f3, paramBitmapFont.getLineHeight());
      }
      float f4 = f1 + paramBitmapFont.getLineHeight();
      i4 = m + 2;
      f1 = f4;
    }
  }

  protected void drawText(Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2)
  {
    int i = this.firstLineShowing << 1;
    float f1 = 0.0F;
    while ((i < this.firstLineShowing + this.linesShowing << 1) && (i < this.linesBreak.size))
    {
      paramBitmapFont.draw(paramBatch, this.displayText, paramFloat1, paramFloat2 + f1, this.linesBreak.items[i], this.linesBreak.items[(i + 1)], 0.0F, 8, false);
      float f2 = f1 - paramBitmapFont.getLineHeight();
      i += 2;
      f1 = f2;
    }
  }

  public int getCursorLine()
  {
    return this.cursorLine;
  }

  public int getFirstLineShowing()
  {
    return this.firstLineShowing;
  }

  public int getLines()
  {
    int i = this.linesBreak.size / 2;
    if (newLineAtEnd());
    for (int j = 1; ; j = 0)
      return j + i;
  }

  public int getLinesShowing()
  {
    return this.linesShowing;
  }

  public float getPrefHeight()
  {
    float f;
    if (this.prefRows <= 0.0F)
      f = super.getPrefHeight();
    do
    {
      return f;
      f = this.textHeight * this.prefRows;
    }
    while (this.style.background == null);
    return Math.max(f + this.style.background.getBottomHeight() + this.style.background.getTopHeight(), this.style.background.getMinHeight());
  }

  protected float getTextY(BitmapFont paramBitmapFont, Drawable paramDrawable)
  {
    float f = getHeight();
    if (paramDrawable != null)
      f = (int)(f - paramDrawable.getTopHeight());
    return f;
  }

  protected void initialize()
  {
    super.initialize();
    this.writeEnters = true;
    this.linesBreak = new IntArray();
    this.cursorLine = 0;
    this.firstLineShowing = 0;
    this.moveOffset = -1.0F;
    this.linesShowing = 0;
  }

  protected int letterUnderCursor(float paramFloat)
  {
    int i = this.linesBreak.size;
    int j = 0;
    if (i > 0)
    {
      if (this.cursorLine << 1 >= this.linesBreak.size)
        j = this.text.length();
    }
    else
      return j;
    int k = this.linesBreak.items[(this.cursorLine << 1)];
    int m = this.linesBreak.items[(1 + (this.cursorLine << 1))];
    int n = 0;
    int i1 = k;
    while ((i1 <= m) && (n == 0))
    {
      if (this.glyphPositions.items[i1] - this.glyphPositions.items[k] > paramFloat)
      {
        n = 1;
        continue;
      }
      i1++;
    }
    return Math.max(0, i1 - 1);
  }

  protected void moveCursor(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1)
    {
      i = 1;
      int j = i + (this.cursorLine << 1);
      if ((j < 0) || (j + 1 >= this.linesBreak.size) || (this.linesBreak.items[j] != this.cursor) || (this.linesBreak.items[(j + 1)] != this.cursor))
        break label105;
      this.cursorLine = (i + this.cursorLine);
      if (paramBoolean2)
        super.moveCursor(paramBoolean1, paramBoolean2);
      showCursor();
    }
    while (true)
    {
      updateCurrentLine();
      return;
      i = -1;
      break;
      label105: super.moveCursor(paramBoolean1, paramBoolean2);
    }
  }

  public void moveCursorLine(int paramInt)
  {
    if (paramInt < 0)
    {
      this.cursorLine = 0;
      this.cursor = 0;
      this.moveOffset = -1.0F;
    }
    do
    {
      return;
      if (paramInt < getLines())
        continue;
      int m = -1 + getLines();
      this.cursor = this.text.length();
      if ((paramInt > getLines()) || (m == this.cursorLine))
        this.moveOffset = -1.0F;
      this.cursorLine = m;
      return;
    }
    while (paramInt == this.cursorLine);
    float f;
    int i;
    TextArea localTextArea;
    if (this.moveOffset < 0.0F)
    {
      int j = this.linesBreak.size;
      int k = this.cursorLine << 1;
      f = 0.0F;
      if (j <= k)
        this.moveOffset = f;
    }
    else
    {
      this.cursorLine = paramInt;
      if (this.cursorLine << 1 < this.linesBreak.size)
        break label291;
      i = this.text.length();
      localTextArea = this;
    }
    while (true)
    {
      localTextArea.cursor = i;
      if ((this.cursor >= this.text.length()) || (this.cursor > -1 + this.linesBreak.get(1 + (this.cursorLine << 1))) || (this.glyphPositions.get(this.cursor) - this.glyphPositions.get(this.linesBreak.get(this.cursorLine << 1)) >= this.moveOffset))
        break label310;
      i = 1 + this.cursor;
      localTextArea = this;
      continue;
      f = this.glyphPositions.get(this.cursor) - this.glyphPositions.get(this.linesBreak.get(this.cursorLine << 1));
      break;
      label291: i = this.linesBreak.get(this.cursorLine << 1);
      localTextArea = this;
    }
    label310: showCursor();
  }

  public boolean newLineAtEnd()
  {
    return (this.text.length() != 0) && ((this.text.charAt(-1 + this.text.length()) == '\n') || (this.text.charAt(-1 + this.text.length()) == '\r'));
  }

  public void setPrefRows(float paramFloat)
  {
    this.prefRows = paramFloat;
  }

  public void setSelection(int paramInt1, int paramInt2)
  {
    super.setSelection(paramInt1, paramInt2);
    updateCurrentLine();
  }

  void showCursor()
  {
    updateCurrentLine();
    if (this.cursorLine != this.firstLineShowing)
    {
      int i;
      if (this.cursorLine >= this.firstLineShowing)
        i = 1;
      while ((this.firstLineShowing > this.cursorLine) || (-1 + (this.firstLineShowing + this.linesShowing) < this.cursorLine))
      {
        this.firstLineShowing = (i + this.firstLineShowing);
        continue;
        i = -1;
      }
    }
  }

  protected void sizeChanged()
  {
    this.lastText = null;
    BitmapFont localBitmapFont = this.style.font;
    Drawable localDrawable = this.style.background;
    float f1 = getHeight();
    float f2;
    if (localDrawable == null)
      f2 = 0.0F;
    while (true)
    {
      this.linesShowing = (int)Math.floor((f1 - f2) / localBitmapFont.getLineHeight());
      return;
      f2 = localDrawable.getBottomHeight() + localDrawable.getTopHeight();
    }
  }

  void updateCurrentLine()
  {
    int i = calculateCurrentLineIndex(this.cursor);
    int j = i / 2;
    if (((i % 2 == 0) || (i + 1 >= this.linesBreak.size) || (this.cursor != this.linesBreak.items[i]) || (this.linesBreak.items[(i + 1)] != this.linesBreak.items[i])) && ((j < this.linesBreak.size / 2) || (this.text.length() == 0) || (this.text.charAt(-1 + this.text.length()) == '\n') || (this.text.charAt(-1 + this.text.length()) == '\r')))
      this.cursorLine = j;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextArea
 * JD-Core Version:    0.6.0
 */