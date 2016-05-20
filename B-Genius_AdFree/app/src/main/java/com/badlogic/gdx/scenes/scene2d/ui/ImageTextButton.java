package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Scaling;

public class ImageTextButton extends Button
{
  private final Image image;
  private final Label label;
  private ImageTextButton.ImageTextButtonStyle style;

  public ImageTextButton(String paramString, ImageTextButton.ImageTextButtonStyle paramImageTextButtonStyle)
  {
    super(paramImageTextButtonStyle);
    this.style = paramImageTextButtonStyle;
    defaults().space(3.0F);
    this.image = new Image();
    this.image.setScaling(Scaling.fit);
    this.label = new Label(paramString, new Label.LabelStyle(paramImageTextButtonStyle.font, paramImageTextButtonStyle.fontColor));
    this.label.setAlignment(1);
    add(this.image);
    add(this.label);
    setStyle(paramImageTextButtonStyle);
    setSize(getPrefWidth(), getPrefHeight());
  }

  public ImageTextButton(String paramString, Skin paramSkin)
  {
    this(paramString, (ImageTextButton.ImageTextButtonStyle)paramSkin.get(ImageTextButton.ImageTextButtonStyle.class));
    setSkin(paramSkin);
  }

  public ImageTextButton(String paramString1, Skin paramSkin, String paramString2)
  {
    this(paramString1, (ImageTextButton.ImageTextButtonStyle)paramSkin.get(paramString2, ImageTextButton.ImageTextButtonStyle.class));
    setSkin(paramSkin);
  }

  private void updateImage()
  {
    Drawable localDrawable2;
    if ((isDisabled()) && (this.style.imageDisabled != null))
      localDrawable2 = this.style.imageDisabled;
    while (true)
    {
      this.image.setDrawable(localDrawable2);
      return;
      if ((isPressed()) && (this.style.imageDown != null))
      {
        localDrawable2 = this.style.imageDown;
        continue;
      }
      if ((this.isChecked) && (this.style.imageChecked != null))
      {
        if ((this.style.imageCheckedOver != null) && (isOver()))
        {
          localDrawable2 = this.style.imageCheckedOver;
          continue;
        }
        localDrawable2 = this.style.imageChecked;
        continue;
      }
      if ((isOver()) && (this.style.imageOver != null))
      {
        localDrawable2 = this.style.imageOver;
        continue;
      }
      Drawable localDrawable1 = this.style.imageUp;
      localDrawable2 = null;
      if (localDrawable1 == null)
        continue;
      localDrawable2 = this.style.imageUp;
    }
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    updateImage();
    Color localColor;
    if ((isDisabled()) && (this.style.disabledFontColor != null))
      localColor = this.style.disabledFontColor;
    while (true)
    {
      if (localColor != null)
        this.label.getStyle().fontColor = localColor;
      super.draw(paramBatch, paramFloat);
      return;
      if ((isPressed()) && (this.style.downFontColor != null))
      {
        localColor = this.style.downFontColor;
        continue;
      }
      if ((this.isChecked) && (this.style.checkedFontColor != null))
      {
        if ((isOver()) && (this.style.checkedOverFontColor != null))
        {
          localColor = this.style.checkedOverFontColor;
          continue;
        }
        localColor = this.style.checkedFontColor;
        continue;
      }
      if ((isOver()) && (this.style.overFontColor != null))
      {
        localColor = this.style.overFontColor;
        continue;
      }
      localColor = this.style.fontColor;
    }
  }

  public Image getImage()
  {
    return this.image;
  }

  public Cell getImageCell()
  {
    return getCell(this.image);
  }

  public Label getLabel()
  {
    return this.label;
  }

  public Cell getLabelCell()
  {
    return getCell(this.label);
  }

  public ImageTextButton.ImageTextButtonStyle getStyle()
  {
    return this.style;
  }

  public CharSequence getText()
  {
    return this.label.getText();
  }

  public void setStyle(Button.ButtonStyle paramButtonStyle)
  {
    if (!(paramButtonStyle instanceof ImageTextButton.ImageTextButtonStyle))
      throw new IllegalArgumentException("style must be a ImageTextButtonStyle.");
    super.setStyle(paramButtonStyle);
    this.style = ((ImageTextButton.ImageTextButtonStyle)paramButtonStyle);
    if (this.image != null)
      updateImage();
    if (this.label != null)
    {
      ImageTextButton.ImageTextButtonStyle localImageTextButtonStyle = (ImageTextButton.ImageTextButtonStyle)paramButtonStyle;
      Label.LabelStyle localLabelStyle = this.label.getStyle();
      localLabelStyle.font = localImageTextButtonStyle.font;
      localLabelStyle.fontColor = localImageTextButtonStyle.fontColor;
      this.label.setStyle(localLabelStyle);
    }
  }

  public void setText(CharSequence paramCharSequence)
  {
    this.label.setText(paramCharSequence);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton
 * JD-Core Version:    0.6.0
 */