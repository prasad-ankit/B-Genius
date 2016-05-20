package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class List$ListStyle
{
  public Drawable background;
  public BitmapFont font;
  public Color fontColorSelected = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  public Color fontColorUnselected = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  public Drawable selection;

  public List$ListStyle()
  {
  }

  public List$ListStyle(BitmapFont paramBitmapFont, Color paramColor1, Color paramColor2, Drawable paramDrawable)
  {
    this.font = paramBitmapFont;
    this.fontColorSelected.set(paramColor1);
    this.fontColorUnselected.set(paramColor2);
    this.selection = paramDrawable;
  }

  public List$ListStyle(ListStyle paramListStyle)
  {
    this.font = paramListStyle.font;
    this.fontColorSelected.set(paramListStyle.fontColorSelected);
    this.fontColorUnselected.set(paramListStyle.fontColorUnselected);
    this.selection = paramListStyle.selection;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle
 * JD-Core Version:    0.6.0
 */