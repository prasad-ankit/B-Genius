package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.IntArray;

public class TextArea$TextAreaListener extends TextField.TextFieldClickListener
{
  public TextArea$TextAreaListener(TextArea paramTextArea)
  {
    super(paramTextArea);
  }

  protected void goEnd(boolean paramBoolean)
  {
    if ((paramBoolean) || (this.this$0.cursorLine >= this.this$0.getLines()))
      this.this$0.cursor = this.this$0.text.length();
    do
      return;
    while (1 + (this.this$0.cursorLine << 1) >= this.this$0.linesBreak.size);
    this.this$0.cursor = this.this$0.linesBreak.get(1 + (this.this$0.cursorLine << 1));
  }

  protected void goHome(boolean paramBoolean)
  {
    if (paramBoolean)
      this.this$0.cursor = 0;
    do
      return;
    while (this.this$0.cursorLine << 1 >= this.this$0.linesBreak.size);
    this.this$0.cursor = this.this$0.linesBreak.get(this.this$0.cursorLine << 1);
  }

  public boolean keyDown(InputEvent paramInputEvent, int paramInt)
  {
    super.keyDown(paramInputEvent, paramInt);
    Stage localStage = this.this$0.getStage();
    if ((localStage != null) && (localStage.getKeyboardFocus() == this.this$0))
    {
      int i;
      label105: int j;
      if ((Gdx.input.isKeyPressed(59)) || (Gdx.input.isKeyPressed(60)))
      {
        i = 1;
        if (paramInt != 20)
          break label159;
        if (i == 0)
          break label149;
        if (!this.this$0.hasSelection)
        {
          this.this$0.selectionStart = this.this$0.cursor;
          this.this$0.hasSelection = true;
        }
        this.this$0.moveCursorLine(1 + this.this$0.cursorLine);
        j = 1;
      }
      while (true)
      {
        if (j != 0)
          scheduleKeyRepeatTask(paramInt);
        this.this$0.showCursor();
        return true;
        i = 0;
        break;
        label149: this.this$0.clearSelection();
        break label105;
        label159: if (paramInt == 19)
        {
          if (i != 0)
            if (!this.this$0.hasSelection)
            {
              this.this$0.selectionStart = this.this$0.cursor;
              this.this$0.hasSelection = true;
            }
          while (true)
          {
            this.this$0.moveCursorLine(-1 + this.this$0.cursorLine);
            j = 1;
            break;
            this.this$0.clearSelection();
          }
        }
        this.this$0.moveOffset = -1.0F;
        j = 0;
      }
    }
    return false;
  }

  public boolean keyTyped(InputEvent paramInputEvent, char paramChar)
  {
    boolean bool = super.keyTyped(paramInputEvent, paramChar);
    this.this$0.showCursor();
    return bool;
  }

  protected void setCursorPosition(float paramFloat1, float paramFloat2)
  {
    this.this$0.moveOffset = -1.0F;
    Drawable localDrawable = this.this$0.style.background;
    BitmapFont localBitmapFont = this.this$0.style.font;
    float f1 = this.this$0.getHeight();
    if (localDrawable != null)
    {
      f1 -= localDrawable.getTopHeight();
      paramFloat1 -= localDrawable.getLeftWidth();
    }
    float f2 = Math.max(0.0F, paramFloat1);
    if (localDrawable != null)
      paramFloat2 -= localDrawable.getTopHeight();
    this.this$0.cursorLine = ((int)Math.floor((f1 - paramFloat2) / localBitmapFont.getLineHeight()) + this.this$0.firstLineShowing);
    this.this$0.cursorLine = Math.max(0, Math.min(this.this$0.cursorLine, -1 + this.this$0.getLines()));
    super.setCursorPosition(f2, paramFloat2);
    this.this$0.updateCurrentLine();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextArea.TextAreaListener
 * JD-Core Version:    0.6.0
 */