package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class CheckBox extends TextButton
{
  private Image image;
  private Cell imageCell;
  private CheckBox.CheckBoxStyle style;

  public CheckBox(String paramString, CheckBox.CheckBoxStyle paramCheckBoxStyle)
  {
    super(paramString, paramCheckBoxStyle);
    clearChildren();
    Label localLabel = getLabel();
    Image localImage = new Image(paramCheckBoxStyle.checkboxOff);
    this.image = localImage;
    this.imageCell = add(localImage);
    add(localLabel);
    localLabel.setAlignment(8);
    setSize(getPrefWidth(), getPrefHeight());
  }

  public CheckBox(String paramString, Skin paramSkin)
  {
    this(paramString, (CheckBox.CheckBoxStyle)paramSkin.get(CheckBox.CheckBoxStyle.class));
  }

  public CheckBox(String paramString1, Skin paramSkin, String paramString2)
  {
    this(paramString1, (CheckBox.CheckBoxStyle)paramSkin.get(paramString2, CheckBox.CheckBoxStyle.class));
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    boolean bool = isDisabled();
    Drawable localDrawable = null;
    if (bool)
    {
      if ((this.isChecked) && (this.style.checkboxOnDisabled != null))
        localDrawable = this.style.checkboxOnDisabled;
    }
    else if (localDrawable == null)
    {
      if ((!this.isChecked) || (this.style.checkboxOn == null))
        break label97;
      localDrawable = this.style.checkboxOn;
    }
    while (true)
    {
      this.image.setDrawable(localDrawable);
      super.draw(paramBatch, paramFloat);
      return;
      localDrawable = this.style.checkboxOffDisabled;
      break;
      label97: if ((isOver()) && (this.style.checkboxOver != null) && (!isDisabled()))
      {
        localDrawable = this.style.checkboxOver;
        continue;
      }
      localDrawable = this.style.checkboxOff;
    }
  }

  public Image getImage()
  {
    return this.image;
  }

  public Cell getImageCell()
  {
    return this.imageCell;
  }

  public CheckBox.CheckBoxStyle getStyle()
  {
    return this.style;
  }

  public void setStyle(Button.ButtonStyle paramButtonStyle)
  {
    if (!(paramButtonStyle instanceof CheckBox.CheckBoxStyle))
      throw new IllegalArgumentException("style must be a CheckBoxStyle.");
    super.setStyle(paramButtonStyle);
    this.style = ((CheckBox.CheckBoxStyle)paramButtonStyle);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.CheckBox
 * JD-Core Version:    0.6.0
 */