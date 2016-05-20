package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class TextButton$TextButtonStyle extends Button.ButtonStyle
{
  public Color checkedFontColor;
  public Color checkedOverFontColor;
  public Color disabledFontColor;
  public Color downFontColor;
  public BitmapFont font;
  public Color fontColor;
  public Color overFontColor;

  public TextButton$TextButtonStyle()
  {
  }

  public TextButton$TextButtonStyle(TextButtonStyle paramTextButtonStyle)
  {
    super(paramTextButtonStyle);
    this.font = paramTextButtonStyle.font;
    if (paramTextButtonStyle.fontColor != null)
      this.fontColor = new Color(paramTextButtonStyle.fontColor);
    if (paramTextButtonStyle.downFontColor != null)
      this.downFontColor = new Color(paramTextButtonStyle.downFontColor);
    if (paramTextButtonStyle.overFontColor != null)
      this.overFontColor = new Color(paramTextButtonStyle.overFontColor);
    if (paramTextButtonStyle.checkedFontColor != null)
      this.checkedFontColor = new Color(paramTextButtonStyle.checkedFontColor);
    if (paramTextButtonStyle.checkedOverFontColor != null)
      this.checkedFontColor = new Color(paramTextButtonStyle.checkedOverFontColor);
    if (paramTextButtonStyle.disabledFontColor != null)
      this.disabledFontColor = new Color(paramTextButtonStyle.disabledFontColor);
  }

  public TextButton$TextButtonStyle(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, BitmapFont paramBitmapFont)
  {
    super(paramDrawable1, paramDrawable2, paramDrawable3);
    this.font = paramBitmapFont;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
 * JD-Core Version:    0.6.0
 */