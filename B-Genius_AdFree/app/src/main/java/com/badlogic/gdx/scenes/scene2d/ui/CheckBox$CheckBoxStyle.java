package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class CheckBox$CheckBoxStyle extends TextButton.TextButtonStyle
{
  public Drawable checkboxOff;
  public Drawable checkboxOffDisabled;
  public Drawable checkboxOn;
  public Drawable checkboxOnDisabled;
  public Drawable checkboxOver;

  public CheckBox$CheckBoxStyle()
  {
  }

  public CheckBox$CheckBoxStyle(CheckBoxStyle paramCheckBoxStyle)
  {
    this.checkboxOff = paramCheckBoxStyle.checkboxOff;
    this.checkboxOn = paramCheckBoxStyle.checkboxOn;
    this.checkboxOver = paramCheckBoxStyle.checkboxOver;
    this.checkboxOffDisabled = paramCheckBoxStyle.checkboxOffDisabled;
    this.checkboxOnDisabled = paramCheckBoxStyle.checkboxOnDisabled;
    this.font = paramCheckBoxStyle.font;
    this.fontColor = new Color(paramCheckBoxStyle.fontColor);
  }

  public CheckBox$CheckBoxStyle(Drawable paramDrawable1, Drawable paramDrawable2, BitmapFont paramBitmapFont, Color paramColor)
  {
    this.checkboxOff = paramDrawable1;
    this.checkboxOn = paramDrawable2;
    this.font = paramBitmapFont;
    this.fontColor = paramColor;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle
 * JD-Core Version:    0.6.0
 */