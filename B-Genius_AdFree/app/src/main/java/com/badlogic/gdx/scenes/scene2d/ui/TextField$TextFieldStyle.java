package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class TextField$TextFieldStyle
{
  public Drawable background;
  public Drawable cursor;
  public Drawable disabledBackground;
  public Color disabledFontColor;
  public Drawable focusedBackground;
  public Color focusedFontColor;
  public BitmapFont font;
  public Color fontColor;
  public BitmapFont messageFont;
  public Color messageFontColor;
  public Drawable selection;

  public TextField$TextFieldStyle()
  {
  }

  public TextField$TextFieldStyle(BitmapFont paramBitmapFont, Color paramColor, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    this.background = paramDrawable3;
    this.cursor = paramDrawable1;
    this.font = paramBitmapFont;
    this.fontColor = paramColor;
    this.selection = paramDrawable2;
  }

  public TextField$TextFieldStyle(TextFieldStyle paramTextFieldStyle)
  {
    this.messageFont = paramTextFieldStyle.messageFont;
    if (paramTextFieldStyle.messageFontColor != null)
      this.messageFontColor = new Color(paramTextFieldStyle.messageFontColor);
    this.background = paramTextFieldStyle.background;
    this.focusedBackground = paramTextFieldStyle.focusedBackground;
    this.disabledBackground = paramTextFieldStyle.disabledBackground;
    this.cursor = paramTextFieldStyle.cursor;
    this.font = paramTextFieldStyle.font;
    if (paramTextFieldStyle.fontColor != null)
      this.fontColor = new Color(paramTextFieldStyle.fontColor);
    if (paramTextFieldStyle.focusedFontColor != null)
      this.focusedFontColor = new Color(paramTextFieldStyle.focusedFontColor);
    if (paramTextFieldStyle.disabledFontColor != null)
      this.disabledFontColor = new Color(paramTextFieldStyle.disabledFontColor);
    this.selection = paramTextFieldStyle.selection;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle
 * JD-Core Version:    0.6.0
 */