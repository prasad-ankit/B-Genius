package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.TimeUtils;

public class TextField extends Widget
  implements Disableable
{
  private static final char BACKSPACE = '\b';
  private static final char BULLET = '';
  private static final char DELETE = '';
  protected static final char ENTER_ANDROID = '\n';
  protected static final char ENTER_DESKTOP = '\r';
  private static final char TAB = '\t';
  public static float keyRepeatInitialTime;
  public static float keyRepeatTime;
  private static final Vector2 tmp1 = new Vector2();
  private static final Vector2 tmp2 = new Vector2();
  private static final Vector2 tmp3 = new Vector2();
  private float blinkTime = 0.32F;
  Clipboard clipboard;
  protected int cursor;
  boolean cursorOn = true;
  boolean disabled;
  protected CharSequence displayText;
  TextField.TextFieldFilter filter;
  boolean focusTraversal = true;
  protected float fontOffset;
  protected final FloatArray glyphPositions = new FloatArray();
  protected boolean hasSelection;
  InputListener inputListener;
  TextField.KeyRepeatTask keyRepeatTask = new TextField.KeyRepeatTask(this);
  TextField.OnscreenKeyboard keyboard = new TextField.DefaultOnscreenKeyboard();
  long lastBlink;
  protected final GlyphLayout layout = new GlyphLayout();
  TextField.TextFieldListener listener;
  private int maxLength = 0;
  private String messageText;
  boolean onlyFontChars = true;
  private StringBuilder passwordBuffer;
  private char passwordCharacter = '';
  boolean passwordMode;
  boolean programmaticChangeEvents;
  float renderOffset;
  protected int selectionStart;
  private float selectionWidth;
  private float selectionX;
  TextField.TextFieldStyle style;
  protected String text;
  private int textHAlign = 8;
  protected float textHeight;
  protected float textOffset;
  private int visibleTextEnd;
  private int visibleTextStart;
  protected boolean writeEnters;

  static
  {
    keyRepeatInitialTime = 0.4F;
    keyRepeatTime = 0.1F;
  }

  public TextField(String paramString, Skin paramSkin)
  {
    this(paramString, (TextField.TextFieldStyle)paramSkin.get(TextField.TextFieldStyle.class));
  }

  public TextField(String paramString1, Skin paramSkin, String paramString2)
  {
    this(paramString1, (TextField.TextFieldStyle)paramSkin.get(paramString2, TextField.TextFieldStyle.class));
  }

  public TextField(String paramString, TextField.TextFieldStyle paramTextFieldStyle)
  {
    setStyle(paramTextFieldStyle);
    this.clipboard = Gdx.app.getClipboard();
    initialize();
    setText(paramString);
    setSize(getPrefWidth(), getPrefHeight());
  }

  private void blink()
  {
    boolean bool = true;
    if (!Gdx.graphics.isContinuousRendering())
      this.cursorOn = bool;
    long l;
    do
    {
      return;
      l = TimeUtils.nanoTime();
    }
    while ((float)(l - this.lastBlink) / 1.0E+009F <= this.blinkTime);
    if (!this.cursorOn);
    while (true)
    {
      this.cursorOn = bool;
      this.lastBlink = l;
      return;
      bool = false;
    }
  }

  private TextField findNextTextField(Array paramArray, TextField paramTextField, Vector2 paramVector21, Vector2 paramVector22, boolean paramBoolean)
  {
    int i = paramArray.size;
    int j = 0;
    Object localObject = paramTextField;
    if (j < i)
    {
      Actor localActor = (Actor)paramArray.get(j);
      boolean bool1;
      label138: boolean bool2;
      if (localActor != this)
      {
        if (!(localActor instanceof TextField))
          break label237;
        TextField localTextField1 = (TextField)localActor;
        if ((!localTextField1.isDisabled()) && (localTextField1.focusTraversal))
        {
          Vector2 localVector2 = localActor.getParent().localToStageCoordinates(tmp3.set(localActor.getX(), localActor.getY()));
          if ((localVector2.y >= paramVector22.y) && ((localVector2.y != paramVector22.y) || (localVector2.x <= paramVector22.x)))
            break label225;
          bool1 = true;
          if ((bool1 ^ paramBoolean))
            if (localObject != null)
            {
              if ((localVector2.y <= paramVector21.y) && ((localVector2.y != paramVector21.y) || (localVector2.x >= paramVector21.x)))
                break label231;
              bool2 = true;
              label193: if (!(bool2 ^ paramBoolean));
            }
            else
            {
              TextField localTextField2 = (TextField)localActor;
              paramVector21.set(localVector2);
              localObject = localTextField2;
            }
        }
      }
      while (true)
      {
        j++;
        break;
        label225: bool1 = false;
        break label138;
        label231: bool2 = false;
        break label193;
        label237: if (!(localActor instanceof Group))
          continue;
        localObject = findNextTextField(((Group)localActor).getChildren(), (TextField)localObject, paramVector21, paramVector22, paramBoolean);
      }
    }
    return (TextField)localObject;
  }

  public void appendText(String paramString)
  {
    if (paramString == null)
      paramString = "";
    clearSelection();
    this.cursor = this.text.length();
    paste(paramString, this.programmaticChangeEvents);
  }

  protected void calculateOffsets()
  {
    float f1 = getWidth();
    if (this.style.background != null)
      f1 -= this.style.background.getLeftWidth() + this.style.background.getRightWidth();
    float f2 = this.glyphPositions.get(this.cursor) - Math.abs(this.renderOffset);
    float f3;
    int i;
    float[] arrayOfFloat;
    if (f2 <= 0.0F)
      if (this.cursor > 0)
      {
        this.renderOffset = (-this.glyphPositions.get(-1 + this.cursor));
        this.visibleTextStart = 0;
        this.textOffset = 0.0F;
        f3 = Math.abs(this.renderOffset);
        i = this.glyphPositions.size;
        arrayOfFloat = this.glyphPositions.items;
      }
    float f4;
    for (int j = 0; ; j++)
    {
      f4 = 0.0F;
      if (j < i)
      {
        if (arrayOfFloat[j] < f3)
          continue;
        this.visibleTextStart = j;
        f4 = arrayOfFloat[j];
        this.textOffset = (f4 - f3);
      }
      for (this.visibleTextEnd = Math.min(this.displayText.length(), 1 + this.cursor); (this.visibleTextEnd <= this.displayText.length()) && (arrayOfFloat[this.visibleTextEnd] - f4 <= f1); this.visibleTextEnd = (1 + this.visibleTextEnd));
      this.renderOffset = 0.0F;
      break;
      if (f2 <= f1)
        break;
      this.renderOffset -= f2 - f1;
      break;
    }
    this.visibleTextEnd = Math.max(0, -1 + this.visibleTextEnd);
    if (this.hasSelection)
    {
      int k = Math.min(this.cursor, this.selectionStart);
      int m = Math.max(this.cursor, this.selectionStart);
      float f5 = Math.max(arrayOfFloat[k], f4);
      float f6 = Math.min(arrayOfFloat[m], arrayOfFloat[this.visibleTextEnd]);
      this.selectionX = f5;
      this.selectionWidth = (f6 - f5 - this.style.font.getData().cursorX);
    }
    if ((0x8 & this.textHAlign) == 0)
    {
      this.textOffset = (f1 - (arrayOfFloat[this.visibleTextEnd] - f4));
      if ((0x1 & this.textHAlign) != 0)
        this.textOffset = Math.round(0.5F * this.textOffset);
      if (this.hasSelection)
        this.selectionX += this.textOffset;
    }
  }

  boolean changeText(String paramString1, String paramString2)
  {
    if (paramString2.equals(paramString1))
      return false;
    this.text = paramString2;
    ChangeListener.ChangeEvent localChangeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
    boolean bool = fire(localChangeEvent);
    if (bool);
    while (true)
    {
      this.text = paramString1;
      Pools.free(localChangeEvent);
      if (bool)
        break;
      return true;
      paramString1 = paramString2;
    }
    return false;
  }

  public void clearSelection()
  {
    this.hasSelection = false;
  }

  protected boolean continueCursor(int paramInt1, int paramInt2)
  {
    return isWordCharacter(this.text.charAt(paramInt1 + paramInt2));
  }

  public void copy()
  {
    if ((this.hasSelection) && (!this.passwordMode))
      this.clipboard.setContents(this.text.substring(Math.min(this.cursor, this.selectionStart), Math.max(this.cursor, this.selectionStart)));
  }

  protected InputListener createInputListener()
  {
    return new TextField.TextFieldClickListener(this);
  }

  public void cut()
  {
    cut(this.programmaticChangeEvents);
  }

  void cut(boolean paramBoolean)
  {
    if ((this.hasSelection) && (!this.passwordMode))
    {
      copy();
      this.cursor = delete(paramBoolean);
      updateDisplayText();
    }
  }

  int delete(boolean paramBoolean)
  {
    int i = this.selectionStart;
    int j = this.cursor;
    int k = Math.min(i, j);
    int m = Math.max(i, j);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1;
    String str2;
    label89: String str3;
    if (k > 0)
    {
      str1 = this.text.substring(0, k);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
      if (m >= this.text.length())
        break label131;
      str2 = this.text.substring(m, this.text.length());
      str3 = str2;
      if (!paramBoolean)
        break label139;
      changeText(this.text, str3);
    }
    while (true)
    {
      clearSelection();
      return k;
      str1 = "";
      break;
      label131: str2 = "";
      break label89;
      label139: this.text = str3;
    }
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    Stage localStage = getStage();
    int i;
    BitmapFont localBitmapFont1;
    Color localColor1;
    label67: Drawable localDrawable1;
    Drawable localDrawable2;
    Drawable localDrawable3;
    label111: Color localColor2;
    float f1;
    float f2;
    float f3;
    float f5;
    float f6;
    if ((localStage != null) && (localStage.getKeyboardFocus() == this))
    {
      i = 1;
      if (i == 0)
        this.keyRepeatTask.cancel();
      localBitmapFont1 = this.style.font;
      if ((!this.disabled) || (this.style.disabledFontColor == null))
        break label474;
      localColor1 = this.style.disabledFontColor;
      localDrawable1 = this.style.selection;
      localDrawable2 = this.style.cursor;
      if ((!this.disabled) || (this.style.disabledBackground == null))
        break label513;
      localDrawable3 = this.style.disabledBackground;
      localColor2 = getColor();
      f1 = getX();
      f2 = getY();
      f3 = getWidth();
      float f4 = getHeight();
      paramBatch.setColor(localColor2.r, localColor2.g, localColor2.b, paramFloat * localColor2.a);
      if (localDrawable3 == null)
        break label645;
      localDrawable3.draw(paramBatch, f1, f2, f3, f4);
      float f9 = localDrawable3.getLeftWidth();
      f5 = localDrawable3.getRightWidth();
      f6 = f9;
    }
    while (true)
    {
      float f7 = getTextY(localBitmapFont1, localDrawable3);
      calculateOffsets();
      if ((i != 0) && (this.hasSelection) && (localDrawable1 != null))
        drawSelection(localDrawable1, paramBatch, localBitmapFont1, f1 + f6, f2 + f7);
      float f8;
      label277: label364: BitmapFont localBitmapFont2;
      if (localBitmapFont1.isFlipped())
      {
        f8 = -this.textHeight;
        if (this.displayText.length() != 0)
          break label589;
        if ((i == 0) && (this.messageText != null))
        {
          if (this.style.messageFontColor == null)
            break label558;
          localBitmapFont1.setColor(this.style.messageFontColor.r, this.style.messageFontColor.g, this.style.messageFontColor.b, paramFloat * (this.style.messageFontColor.a * localColor2.a));
          if (this.style.messageFont == null)
            break label582;
          localBitmapFont2 = this.style.messageFont;
          label383: localBitmapFont2.draw(paramBatch, this.messageText, f1 + f6, f8 + (f2 + f7), f3 - f6 - f5, this.textHAlign, false);
        }
      }
      while (true)
      {
        if ((i != 0) && (!this.disabled))
        {
          blink();
          if ((this.cursorOn) && (localDrawable2 != null))
            drawCursor(localDrawable2, paramBatch, localBitmapFont1, f1 + f6, f2 + f7);
        }
        return;
        i = 0;
        break;
        label474: if ((i != 0) && (this.style.focusedFontColor != null))
        {
          localColor1 = this.style.focusedFontColor;
          break label67;
        }
        localColor1 = this.style.fontColor;
        break label67;
        label513: if ((i != 0) && (this.style.focusedBackground != null))
        {
          localDrawable3 = this.style.focusedBackground;
          break label111;
        }
        localDrawable3 = this.style.background;
        break label111;
        f8 = 0.0F;
        break label277;
        label558: localBitmapFont1.setColor(0.7F, 0.7F, 0.7F, paramFloat * localColor2.a);
        break label364;
        label582: localBitmapFont2 = localBitmapFont1;
        break label383;
        label589: localBitmapFont1.setColor(localColor1.r, localColor1.g, localColor1.b, paramFloat * (localColor1.a * localColor2.a));
        drawText(paramBatch, localBitmapFont1, f1 + f6, f8 + (f2 + f7));
      }
      label645: f5 = 0.0F;
      f6 = 0.0F;
    }
  }

  protected void drawCursor(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2)
  {
    paramDrawable.draw(paramBatch, paramFloat1 + this.textOffset + this.glyphPositions.get(this.cursor) - this.glyphPositions.get(this.visibleTextStart) + this.fontOffset + paramBitmapFont.getData().cursorX, paramFloat2 - this.textHeight - paramBitmapFont.getDescent(), paramDrawable.getMinWidth(), this.textHeight);
  }

  protected void drawSelection(Drawable paramDrawable, Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2)
  {
    paramDrawable.draw(paramBatch, paramFloat1 + this.selectionX + this.renderOffset + this.fontOffset, paramFloat2 - this.textHeight - paramBitmapFont.getDescent(), this.selectionWidth, this.textHeight);
  }

  protected void drawText(Batch paramBatch, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2)
  {
    paramBitmapFont.draw(paramBatch, this.displayText, paramFloat1 + this.textOffset, paramFloat2, this.visibleTextStart, this.visibleTextEnd, 0.0F, 8, false);
  }

  public int getCursorPosition()
  {
    return this.cursor;
  }

  public InputListener getDefaultInputListener()
  {
    return this.inputListener;
  }

  public int getMaxLength()
  {
    return this.maxLength;
  }

  public String getMessageText()
  {
    return this.messageText;
  }

  public TextField.OnscreenKeyboard getOnscreenKeyboard()
  {
    return this.keyboard;
  }

  public float getPrefHeight()
  {
    float f = this.textHeight;
    if (this.style.background != null)
      f = Math.max(f + this.style.background.getBottomHeight() + this.style.background.getTopHeight(), this.style.background.getMinHeight());
    return f;
  }

  public float getPrefWidth()
  {
    return 150.0F;
  }

  public String getSelection()
  {
    if (this.hasSelection)
      return this.text.substring(Math.min(this.selectionStart, this.cursor), Math.max(this.selectionStart, this.cursor));
    return "";
  }

  public int getSelectionStart()
  {
    return this.selectionStart;
  }

  public TextField.TextFieldStyle getStyle()
  {
    return this.style;
  }

  public String getText()
  {
    return this.text;
  }

  public TextField.TextFieldFilter getTextFieldFilter()
  {
    return this.filter;
  }

  protected float getTextY(BitmapFont paramBitmapFont, Drawable paramDrawable)
  {
    float f1 = getHeight();
    float f2 = this.textHeight / 2.0F + paramBitmapFont.getDescent();
    float f3;
    if (paramDrawable != null)
    {
      float f4 = paramDrawable.getBottomHeight();
      f3 = f4 + (f2 + (f1 - paramDrawable.getTopHeight() - f4) / 2.0F);
    }
    while (true)
    {
      if (paramBitmapFont.usesIntegerPositions())
        f3 = (int)f3;
      return f3;
      f3 = f2 + f1 / 2.0F;
    }
  }

  protected void initialize()
  {
    InputListener localInputListener = createInputListener();
    this.inputListener = localInputListener;
    addListener(localInputListener);
  }

  String insert(int paramInt, CharSequence paramCharSequence, String paramString)
  {
    if (paramString.length() == 0)
      return paramCharSequence.toString();
    return paramString.substring(0, paramInt) + paramCharSequence + paramString.substring(paramInt, paramString.length());
  }

  public boolean isDisabled()
  {
    return this.disabled;
  }

  public boolean isPasswordMode()
  {
    return this.passwordMode;
  }

  protected boolean isWordCharacter(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= '0') && (paramChar <= '9'));
  }

  protected int letterUnderCursor(float paramFloat)
  {
    float f = paramFloat - (this.renderOffset + this.textOffset);
    int i = -1 + this.glyphPositions.size;
    float[] arrayOfFloat = this.glyphPositions.items;
    int j = this.glyphPositions.size;
    for (int k = 0; ; k++)
    {
      if (k < j)
      {
        if (arrayOfFloat[k] <= f)
          continue;
        i = k - 1;
      }
      return Math.max(0, i);
    }
  }

  protected void moveCursor(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    int j;
    if (paramBoolean1)
    {
      i = this.text.length();
      j = 0;
      if (!paramBoolean1)
        break label66;
    }
    label19: label66: label93: 
    while (true)
    {
      if (paramBoolean1)
      {
        int m = 1 + this.cursor;
        this.cursor = m;
        if (m >= i);
      }
      while (true)
      {
        if ((paramBoolean2) && (continueCursor(this.cursor, j)))
          break label93;
        int k;
        do
        {
          return;
          i = 0;
          break;
          j = -1;
          break label19;
          k = -1 + this.cursor;
          this.cursor = k;
        }
        while (k <= i);
      }
    }
  }

  public void next(boolean paramBoolean)
  {
    Stage localStage = getStage();
    if (localStage == null)
      return;
    getParent().localToStageCoordinates(tmp1.set(getX(), getY()));
    TextField localTextField = findNextTextField(localStage.getActors(), null, tmp2, tmp1, paramBoolean);
    if (localTextField == null)
    {
      if (!paramBoolean)
        break label105;
      tmp1.set(1.4E-45F, 1.4E-45F);
    }
    while (true)
    {
      localTextField = findNextTextField(getStage().getActors(), null, tmp2, tmp1, paramBoolean);
      if (localTextField == null)
        break;
      localStage.setKeyboardFocus(localTextField);
      return;
      label105: tmp1.set(3.4028235E+38F, 3.4028235E+38F);
    }
    Gdx.input.setOnscreenKeyboardVisible(false);
  }

  void paste(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = this.text.length();
    if (this.hasSelection)
      i -= Math.abs(this.cursor - this.selectionStart);
    BitmapFont.BitmapFontData localBitmapFontData = this.style.font.getData();
    int j = 0;
    int k = paramString.length();
    while ((j < k) && (withinMaxLength(i + localStringBuilder.length())))
    {
      char c = paramString.charAt(j);
      if (((this.writeEnters) && ((c == '\n') || (c == '\r'))) || (((!this.onlyFontChars) || (localBitmapFontData.hasGlyph(c))) && ((this.filter == null) || (this.filter.acceptChar(this, c)))))
        localStringBuilder.append(c);
      j++;
    }
    String str = localStringBuilder.toString();
    if (this.hasSelection)
      this.cursor = delete(paramBoolean);
    if (paramBoolean)
      changeText(this.text, insert(this.cursor, str, this.text));
    while (true)
    {
      updateDisplayText();
      this.cursor += str.length();
      return;
      this.text = insert(this.cursor, str, this.text);
    }
  }

  public void selectAll()
  {
    setSelection(0, this.text.length());
  }

  public void setAlignment(int paramInt)
  {
    this.textHAlign = paramInt;
  }

  public void setBlinkTime(float paramFloat)
  {
    this.blinkTime = paramFloat;
  }

  public void setClipboard(Clipboard paramClipboard)
  {
    this.clipboard = paramClipboard;
  }

  public void setCursorPosition(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("cursorPosition must be >= 0");
    clearSelection();
    this.cursor = Math.min(paramInt, this.text.length());
  }

  public void setDisabled(boolean paramBoolean)
  {
    this.disabled = paramBoolean;
  }

  public void setFocusTraversal(boolean paramBoolean)
  {
    this.focusTraversal = paramBoolean;
  }

  public void setMaxLength(int paramInt)
  {
    this.maxLength = paramInt;
  }

  public void setMessageText(String paramString)
  {
    this.messageText = paramString;
  }

  public void setOnlyFontChars(boolean paramBoolean)
  {
    this.onlyFontChars = paramBoolean;
  }

  public void setOnscreenKeyboard(TextField.OnscreenKeyboard paramOnscreenKeyboard)
  {
    this.keyboard = paramOnscreenKeyboard;
  }

  public void setPasswordCharacter(char paramChar)
  {
    this.passwordCharacter = paramChar;
    if (this.passwordMode)
      updateDisplayText();
  }

  public void setPasswordMode(boolean paramBoolean)
  {
    this.passwordMode = paramBoolean;
    updateDisplayText();
  }

  public void setProgrammaticChangeEvents(boolean paramBoolean)
  {
    this.programmaticChangeEvents = paramBoolean;
  }

  public void setSelection(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IllegalArgumentException("selectionStart must be >= 0");
    if (paramInt2 < 0)
      throw new IllegalArgumentException("selectionEnd must be >= 0");
    int i = Math.min(this.text.length(), paramInt1);
    int j = Math.min(this.text.length(), paramInt2);
    if (j == i)
    {
      clearSelection();
      return;
    }
    if (j < i);
    while (true)
    {
      this.hasSelection = true;
      this.selectionStart = j;
      this.cursor = i;
      return;
      int k = j;
      j = i;
      i = k;
    }
  }

  public void setStyle(TextField.TextFieldStyle paramTextFieldStyle)
  {
    if (paramTextFieldStyle == null)
      throw new IllegalArgumentException("style cannot be null.");
    this.style = paramTextFieldStyle;
    this.textHeight = (paramTextFieldStyle.font.getCapHeight() - 2.0F * paramTextFieldStyle.font.getDescent());
    invalidateHierarchy();
  }

  public void setText(String paramString)
  {
    if (paramString == null)
      paramString = "";
    if (paramString.equals(this.text))
      return;
    clearSelection();
    String str = this.text;
    this.text = "";
    paste(paramString, false);
    if (this.programmaticChangeEvents)
      changeText(str, this.text);
    this.cursor = 0;
  }

  public void setTextFieldFilter(TextField.TextFieldFilter paramTextFieldFilter)
  {
    this.filter = paramTextFieldFilter;
  }

  public void setTextFieldListener(TextField.TextFieldListener paramTextFieldListener)
  {
    this.listener = paramTextFieldListener;
  }

  void updateDisplayText()
  {
    BitmapFont localBitmapFont = this.style.font;
    BitmapFont.BitmapFontData localBitmapFontData = localBitmapFont.getData();
    String str1 = this.text;
    int i = str1.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    if (j < i)
    {
      char c = str1.charAt(j);
      if (localBitmapFontData.hasGlyph(c));
      while (true)
      {
        localStringBuilder.append(c);
        j++;
        break;
        c = ' ';
      }
    }
    String str2 = localStringBuilder.toString();
    if ((this.passwordMode) && (localBitmapFontData.hasGlyph(this.passwordCharacter)))
    {
      if (this.passwordBuffer == null)
        this.passwordBuffer = new StringBuilder(str2.length());
      if (this.passwordBuffer.length() > i)
        this.passwordBuffer.setLength(i);
    }
    for (this.displayText = this.passwordBuffer; ; this.displayText = str2)
    {
      this.layout.setText(localBitmapFont, this.displayText);
      this.glyphPositions.clear();
      if (this.layout.runs.size <= 0)
        break label307;
      FloatArray localFloatArray = ((GlyphLayout.GlyphRun)this.layout.runs.first()).xAdvances;
      this.fontOffset = localFloatArray.first();
      int k = localFloatArray.size;
      int m = 1;
      f = 0.0F;
      while (m < k)
      {
        this.glyphPositions.add(f);
        f += localFloatArray.get(m);
        m++;
      }
      for (int n = this.passwordBuffer.length(); n < i; n++)
        this.passwordBuffer.append(this.passwordCharacter);
      break;
    }
    label307: this.fontOffset = 0.0F;
    float f = 0.0F;
    this.glyphPositions.add(f);
    if (this.selectionStart > str2.length())
      this.selectionStart = i;
  }

  boolean withinMaxLength(int paramInt)
  {
    return (this.maxLength <= 0) || (paramInt < this.maxLength);
  }

  int[] wordUnderCursor(float paramFloat)
  {
    return wordUnderCursor(letterUnderCursor(paramFloat));
  }

  protected int[] wordUnderCursor(int paramInt)
  {
    String str = this.text;
    int i = str.length();
    int j = paramInt;
    if (j < i)
      if (isWordCharacter(str.charAt(j)));
    while (true)
    {
      int k = paramInt - 1;
      label37: if (k >= 0)
        if (isWordCharacter(str.charAt(k)));
      for (int m = k + 1; ; m = 0)
      {
        return new int[] { m, j };
        j++;
        break;
        k--;
        break label37;
      }
      j = i;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextField
 * JD-Core Version:    0.6.0
 */