package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class ImageTextButton$ImageTextButtonStyle extends TextButton.TextButtonStyle
{
  public Drawable imageChecked;
  public Drawable imageCheckedOver;
  public Drawable imageDisabled;
  public Drawable imageDown;
  public Drawable imageOver;
  public Drawable imageUp;

  public ImageTextButton$ImageTextButtonStyle()
  {
  }

  public ImageTextButton$ImageTextButtonStyle(ImageTextButtonStyle paramImageTextButtonStyle)
  {
    super(paramImageTextButtonStyle);
    if (paramImageTextButtonStyle.imageUp != null)
      this.imageUp = paramImageTextButtonStyle.imageUp;
    if (paramImageTextButtonStyle.imageDown != null)
      this.imageDown = paramImageTextButtonStyle.imageDown;
    if (paramImageTextButtonStyle.imageOver != null)
      this.imageOver = paramImageTextButtonStyle.imageOver;
    if (paramImageTextButtonStyle.imageChecked != null)
      this.imageChecked = paramImageTextButtonStyle.imageChecked;
    if (paramImageTextButtonStyle.imageCheckedOver != null)
      this.imageCheckedOver = paramImageTextButtonStyle.imageCheckedOver;
    if (paramImageTextButtonStyle.imageDisabled != null)
      this.imageDisabled = paramImageTextButtonStyle.imageDisabled;
  }

  public ImageTextButton$ImageTextButtonStyle(TextButton.TextButtonStyle paramTextButtonStyle)
  {
    super(paramTextButtonStyle);
  }

  public ImageTextButton$ImageTextButtonStyle(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, BitmapFont paramBitmapFont)
  {
    super(paramDrawable1, paramDrawable2, paramDrawable3, paramBitmapFont);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle
 * JD-Core Version:    0.6.0
 */