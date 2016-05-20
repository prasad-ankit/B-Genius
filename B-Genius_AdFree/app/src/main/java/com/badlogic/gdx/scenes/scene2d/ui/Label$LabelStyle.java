package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Label$LabelStyle
{
  public Drawable background;
  public BitmapFont font;
  public Color fontColor;

  public Label$LabelStyle()
  {
  }

  public Label$LabelStyle(BitmapFont paramBitmapFont, Color paramColor)
  {
    this.font = paramBitmapFont;
    this.fontColor = paramColor;
  }

  public Label$LabelStyle(LabelStyle paramLabelStyle)
  {
    this.font = paramLabelStyle.font;
    if (paramLabelStyle.fontColor != null)
      this.fontColor = new Color(paramLabelStyle.fontColor);
    this.background = paramLabelStyle.background;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
 * JD-Core Version:    0.6.0
 */