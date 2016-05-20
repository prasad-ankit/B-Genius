package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Button$ButtonStyle
{
  public Drawable checked;
  public Drawable checkedOver;
  public Drawable disabled;
  public Drawable down;
  public Drawable over;
  public float pressedOffsetX;
  public float pressedOffsetY;
  public float unpressedOffsetX;
  public float unpressedOffsetY;
  public Drawable up;

  public Button$ButtonStyle()
  {
  }

  public Button$ButtonStyle(ButtonStyle paramButtonStyle)
  {
    this.up = paramButtonStyle.up;
    this.down = paramButtonStyle.down;
    this.over = paramButtonStyle.over;
    this.checked = paramButtonStyle.checked;
    this.checkedOver = paramButtonStyle.checkedOver;
    this.disabled = paramButtonStyle.disabled;
    this.pressedOffsetX = paramButtonStyle.pressedOffsetX;
    this.pressedOffsetY = paramButtonStyle.pressedOffsetY;
    this.unpressedOffsetX = paramButtonStyle.unpressedOffsetX;
    this.unpressedOffsetY = paramButtonStyle.unpressedOffsetY;
  }

  public Button$ButtonStyle(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    this.up = paramDrawable1;
    this.down = paramDrawable2;
    this.checked = paramDrawable3;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle
 * JD-Core Version:    0.6.0
 */