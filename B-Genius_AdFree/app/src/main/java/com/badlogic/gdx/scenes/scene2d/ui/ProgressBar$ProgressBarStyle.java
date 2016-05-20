package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class ProgressBar$ProgressBarStyle
{
  public Drawable background;
  public Drawable disabledBackground;
  public Drawable disabledKnob;
  public Drawable disabledKnobAfter;
  public Drawable disabledKnobBefore;
  public Drawable knob;
  public Drawable knobAfter;
  public Drawable knobBefore;

  public ProgressBar$ProgressBarStyle()
  {
  }

  public ProgressBar$ProgressBarStyle(ProgressBarStyle paramProgressBarStyle)
  {
    this.background = paramProgressBarStyle.background;
    this.disabledBackground = paramProgressBarStyle.disabledBackground;
    this.knob = paramProgressBarStyle.knob;
    this.disabledKnob = paramProgressBarStyle.disabledKnob;
    this.knobBefore = paramProgressBarStyle.knobBefore;
    this.knobAfter = paramProgressBarStyle.knobAfter;
    this.disabledKnobBefore = paramProgressBarStyle.disabledKnobBefore;
    this.disabledKnobAfter = paramProgressBarStyle.disabledKnobAfter;
  }

  public ProgressBar$ProgressBarStyle(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.background = paramDrawable1;
    this.knob = paramDrawable2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle
 * JD-Core Version:    0.6.0
 */