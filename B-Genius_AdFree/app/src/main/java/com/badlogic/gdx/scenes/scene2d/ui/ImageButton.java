package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Scaling;

public class ImageButton extends Button
{
  private final Image image = new Image();
  private ImageButton.ImageButtonStyle style;

  public ImageButton(ImageButton.ImageButtonStyle paramImageButtonStyle)
  {
    super(paramImageButtonStyle);
    this.image.setScaling(Scaling.fit);
    add(this.image);
    setStyle(paramImageButtonStyle);
    setSize(getPrefWidth(), getPrefHeight());
  }

  public ImageButton(Skin paramSkin)
  {
    this((ImageButton.ImageButtonStyle)paramSkin.get(ImageButton.ImageButtonStyle.class));
  }

  public ImageButton(Skin paramSkin, String paramString)
  {
    this((ImageButton.ImageButtonStyle)paramSkin.get(paramString, ImageButton.ImageButtonStyle.class));
  }

  public ImageButton(Drawable paramDrawable)
  {
    this(new ImageButton.ImageButtonStyle(null, null, null, paramDrawable, null, null));
  }

  public ImageButton(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(new ImageButton.ImageButtonStyle(null, null, null, paramDrawable1, paramDrawable2, null));
  }

  public ImageButton(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    this(new ImageButton.ImageButtonStyle(null, null, null, paramDrawable1, paramDrawable2, paramDrawable3));
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
    super.draw(paramBatch, paramFloat);
  }

  public Image getImage()
  {
    return this.image;
  }

  public Cell getImageCell()
  {
    return getCell(this.image);
  }

  public ImageButton.ImageButtonStyle getStyle()
  {
    return this.style;
  }

  public void setStyle(Button.ButtonStyle paramButtonStyle)
  {
    if (!(paramButtonStyle instanceof ImageButton.ImageButtonStyle))
      throw new IllegalArgumentException("style must be an ImageButtonStyle.");
    super.setStyle(paramButtonStyle);
    this.style = ((ImageButton.ImageButtonStyle)paramButtonStyle);
    if (this.image != null)
      updateImage();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.ImageButton
 * JD-Core Version:    0.6.0
 */