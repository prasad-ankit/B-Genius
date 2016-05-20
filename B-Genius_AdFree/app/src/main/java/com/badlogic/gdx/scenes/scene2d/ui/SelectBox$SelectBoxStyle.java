package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class SelectBox$SelectBoxStyle
{
  public Drawable background;
  public Drawable backgroundDisabled;
  public Drawable backgroundOpen;
  public Drawable backgroundOver;
  public Color disabledFontColor;
  public BitmapFont font;
  public Color fontColor = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  public List.ListStyle listStyle;
  public ScrollPane.ScrollPaneStyle scrollStyle;

  public SelectBox$SelectBoxStyle()
  {
  }

  public SelectBox$SelectBoxStyle(BitmapFont paramBitmapFont, Color paramColor, Drawable paramDrawable, ScrollPane.ScrollPaneStyle paramScrollPaneStyle, List.ListStyle paramListStyle)
  {
    this.font = paramBitmapFont;
    this.fontColor.set(paramColor);
    this.background = paramDrawable;
    this.scrollStyle = paramScrollPaneStyle;
    this.listStyle = paramListStyle;
  }

  public SelectBox$SelectBoxStyle(SelectBoxStyle paramSelectBoxStyle)
  {
    this.font = paramSelectBoxStyle.font;
    this.fontColor.set(paramSelectBoxStyle.fontColor);
    if (paramSelectBoxStyle.disabledFontColor != null)
      this.disabledFontColor = new Color(paramSelectBoxStyle.disabledFontColor);
    this.background = paramSelectBoxStyle.background;
    this.backgroundOver = paramSelectBoxStyle.backgroundOver;
    this.backgroundOpen = paramSelectBoxStyle.backgroundOpen;
    this.backgroundDisabled = paramSelectBoxStyle.backgroundDisabled;
    this.scrollStyle = new ScrollPane.ScrollPaneStyle(paramSelectBoxStyle.scrollStyle);
    this.listStyle = new List.ListStyle(paramSelectBoxStyle.listStyle);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxStyle
 * JD-Core Version:    0.6.0
 */