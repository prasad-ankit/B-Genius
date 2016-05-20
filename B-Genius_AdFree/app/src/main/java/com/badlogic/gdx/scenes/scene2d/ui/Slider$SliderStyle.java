package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Slider$SliderStyle extends ProgressBar.ProgressBarStyle
{
  public Drawable knobDown;
  public Drawable knobOver;

  public Slider$SliderStyle()
  {
  }

  public Slider$SliderStyle(SliderStyle paramSliderStyle)
  {
    super(paramSliderStyle);
    this.knobOver = paramSliderStyle.knobOver;
    this.knobDown = paramSliderStyle.knobDown;
  }

  public Slider$SliderStyle(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    super(paramDrawable1, paramDrawable2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle
 * JD-Core Version:    0.6.0
 */