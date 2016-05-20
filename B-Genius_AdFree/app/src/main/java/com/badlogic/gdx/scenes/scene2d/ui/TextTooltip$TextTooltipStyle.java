package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class TextTooltip$TextTooltipStyle
{
  public Drawable background;
  public Label.LabelStyle label;

  public TextTooltip$TextTooltipStyle()
  {
  }

  public TextTooltip$TextTooltipStyle(Label.LabelStyle paramLabelStyle, Drawable paramDrawable)
  {
    this.label = paramLabelStyle;
    this.background = paramDrawable;
  }

  public TextTooltip$TextTooltipStyle(TextTooltipStyle paramTextTooltipStyle)
  {
    this.label = new Label.LabelStyle(paramTextTooltipStyle.label);
    this.background = paramTextTooltipStyle.background;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextTooltip.TextTooltipStyle
 * JD-Core Version:    0.6.0
 */