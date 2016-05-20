package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.Timer;

public class TextField$TextFieldClickListener extends ClickListener
{
  public TextField$TextFieldClickListener(TextField paramTextField)
  {
  }

  public void clicked(InputEvent paramInputEvent, float paramFloat1, float paramFloat2)
  {
    int i = getTapCount() % 4;
    if (i == 0)
      this.this$0.clearSelection();
    if (i == 2)
    {
      int[] arrayOfInt = this.this$0.wordUnderCursor(paramFloat1);
      this.this$0.setSelection(arrayOfInt[0], arrayOfInt[1]);
    }
    if (i == 3)
      this.this$0.selectAll();
  }

  protected void goEnd(boolean paramBoolean)
  {
    this.this$0.cursor = this.this$0.text.length();
  }

  protected void goHome(boolean paramBoolean)
  {
    this.this$0.cursor = 0;
  }

  public boolean keyDown(InputEvent paramInputEvent, int paramInt)
  {
    boolean bool1 = true;
    if (this.this$0.disabled)
    {
      bool1 = false;
      return bool1;
    }
    this.this$0.lastBlink = 0L;
    this.this$0.cursorOn = false;
    Stage localStage = this.this$0.getStage();
    if ((localStage == null) || (localStage.getKeyboardFocus() != this.this$0))
      return false;
    boolean bool2 = UIUtils.ctrl();
    boolean bool3;
    if ((bool2) && (!this.this$0.passwordMode))
    {
      bool3 = bool1;
      label83: if (!bool2)
        break label176;
      if (paramInt != 50)
        break label466;
      this.this$0.paste(this.this$0.clipboard.getContents(), bool1);
    }
    label176: label466: for (boolean bool4 = bool1; ; bool4 = false)
    {
      if ((paramInt == 31) || (paramInt == 133))
      {
        this.this$0.copy();
        return bool1;
        bool3 = false;
        break label83;
      }
      if (paramInt == 52)
      {
        this.this$0.cut(bool1);
        return bool1;
      }
      if (paramInt == 29)
      {
        this.this$0.selectAll();
        return bool1;
        bool4 = false;
      }
      if (UIUtils.shift())
      {
        if (paramInt == 133)
          this.this$0.paste(this.this$0.clipboard.getContents(), bool1);
        if (paramInt == 112)
          this.this$0.cut(bool1);
        int i = this.this$0.cursor;
        if (paramInt == 21)
        {
          this.this$0.moveCursor(false, bool3);
          bool4 = bool1;
          label254: if (!this.this$0.hasSelection)
          {
            this.this$0.selectionStart = i;
            this.this$0.hasSelection = bool1;
          }
        }
      }
      while (true)
      {
        this.this$0.cursor = MathUtils.clamp(this.this$0.cursor, 0, this.this$0.text.length());
        if (!bool4)
          break;
        scheduleKeyRepeatTask(paramInt);
        return bool1;
        if (paramInt == 22)
        {
          this.this$0.moveCursor(bool1, bool3);
          bool4 = bool1;
          break label254;
        }
        if (paramInt == 3)
        {
          goHome(bool3);
          break label254;
        }
        if (paramInt != 132)
          continue;
        goEnd(bool3);
        break label254;
        if (paramInt == 21)
        {
          this.this$0.moveCursor(false, bool3);
          this.this$0.clearSelection();
          bool4 = bool1;
        }
        if (paramInt == 22)
        {
          this.this$0.moveCursor(bool1, bool3);
          this.this$0.clearSelection();
          bool4 = bool1;
        }
        if (paramInt == 3)
        {
          goHome(bool3);
          this.this$0.clearSelection();
        }
        if (paramInt != 132)
          continue;
        goEnd(bool3);
        this.this$0.clearSelection();
      }
    }
  }

  public boolean keyTyped(InputEvent paramInputEvent, char paramChar)
  {
    if (this.this$0.disabled)
      return false;
    switch (paramChar)
    {
    case '\013':
    case '\f':
    default:
      if (paramChar >= ' ')
        break;
      return false;
    case '\b':
    case '\t':
    case '\n':
    case '\r':
    }
    Stage localStage = this.this$0.getStage();
    if ((localStage == null) || (localStage.getKeyboardFocus() != this.this$0))
      return false;
    if ((UIUtils.isMac) && (Gdx.input.isKeyPressed(63)))
      return true;
    if (((paramChar == '\t') || (paramChar == '\n')) && (this.this$0.focusTraversal))
    {
      this.this$0.next(UIUtils.shift());
      if (this.this$0.listener != null)
        this.this$0.listener.keyTyped(this.this$0, paramChar);
      return true;
    }
    int i;
    label176: int j;
    label185: int k;
    label200: boolean bool;
    label214: int m;
    label227: String str1;
    int n;
    if (paramChar == '')
    {
      i = 1;
      if (paramChar != '\b')
        break label333;
      j = 1;
      if ((paramChar != '\r') && (paramChar != '\n'))
        break label339;
      k = 1;
      if (k == 0)
        break label345;
      bool = this.this$0.writeEnters;
      if ((j == 0) && (i == 0))
        break label387;
      m = 1;
      if ((!bool) && (m == 0))
        break label391;
      str1 = this.this$0.text;
      n = this.this$0.cursor;
      if (!this.this$0.hasSelection)
        break label393;
      this.this$0.cursor = this.this$0.delete(false);
    }
    while (true)
    {
      if ((!bool) || (m != 0))
        break label679;
      if ((k != 0) || (this.this$0.filter == null) || (this.this$0.filter.acceptChar(this.this$0, paramChar)))
        break label593;
      return true;
      i = 0;
      break label176;
      label333: j = 0;
      break label185;
      label339: k = 0;
      break label200;
      label345: if ((!this.this$0.onlyFontChars) || (this.this$0.style.font.getData().hasGlyph(paramChar)))
      {
        bool = true;
        break label214;
      }
      bool = false;
      break label214;
      label387: m = 0;
      break label227;
      label391: break;
      label393: if ((j != 0) && (this.this$0.cursor > 0))
      {
        TextField localTextField4 = this.this$0;
        StringBuilder localStringBuilder = new StringBuilder().append(this.this$0.text.substring(0, -1 + this.this$0.cursor));
        String str3 = this.this$0.text;
        TextField localTextField5 = this.this$0;
        int i2 = localTextField5.cursor;
        localTextField5.cursor = (i2 - 1);
        localTextField4.text = str3.substring(i2);
        this.this$0.renderOffset = 0.0F;
      }
      if ((i == 0) || (this.this$0.cursor >= this.this$0.text.length()))
        continue;
      this.this$0.text = (this.this$0.text.substring(0, this.this$0.cursor) + this.this$0.text.substring(1 + this.this$0.cursor));
    }
    label593: if (!this.this$0.withinMaxLength(this.this$0.text.length()))
      return true;
    if (k != 0);
    for (String str2 = "\n"; ; str2 = String.valueOf(paramChar))
    {
      TextField localTextField1 = this.this$0;
      TextField localTextField2 = this.this$0;
      TextField localTextField3 = this.this$0;
      int i1 = localTextField3.cursor;
      localTextField3.cursor = (i1 + 1);
      localTextField1.text = localTextField2.insert(i1, str2, this.this$0.text);
      label679: if (!this.this$0.changeText(str1, this.this$0.text))
        this.this$0.cursor = n;
      this.this$0.updateDisplayText();
      break;
    }
  }

  public boolean keyUp(InputEvent paramInputEvent, int paramInt)
  {
    if (this.this$0.disabled)
      return false;
    this.this$0.keyRepeatTask.cancel();
    return true;
  }

  protected void scheduleKeyRepeatTask(int paramInt)
  {
    if ((!this.this$0.keyRepeatTask.isScheduled()) || (this.this$0.keyRepeatTask.keycode != paramInt))
    {
      this.this$0.keyRepeatTask.keycode = paramInt;
      this.this$0.keyRepeatTask.cancel();
      Timer.schedule(this.this$0.keyRepeatTask, TextField.keyRepeatInitialTime, TextField.keyRepeatTime);
    }
  }

  protected void setCursorPosition(float paramFloat1, float paramFloat2)
  {
    this.this$0.lastBlink = 0L;
    this.this$0.cursorOn = false;
    this.this$0.cursor = this.this$0.letterUnderCursor(paramFloat1);
  }

  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (!super.touchDown(paramInputEvent, paramFloat1, paramFloat2, paramInt1, paramInt2));
    do
      return false;
    while ((paramInt1 == 0) && (paramInt2 != 0));
    if (this.this$0.disabled)
      return true;
    setCursorPosition(paramFloat1, paramFloat2);
    this.this$0.selectionStart = this.this$0.cursor;
    Stage localStage = this.this$0.getStage();
    if (localStage != null)
      localStage.setKeyboardFocus(this.this$0);
    this.this$0.keyboard.show(true);
    this.this$0.hasSelection = true;
    return true;
  }

  public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    super.touchDragged(paramInputEvent, paramFloat1, paramFloat2, paramInt);
    setCursorPosition(paramFloat1, paramFloat2);
  }

  public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.this$0.selectionStart == this.this$0.cursor)
      this.this$0.hasSelection = false;
    super.touchUp(paramInputEvent, paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldClickListener
 * JD-Core Version:    0.6.0
 */