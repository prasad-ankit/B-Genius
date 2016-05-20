package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Slider extends ProgressBar
{
  int draggingPointer = -1;
  boolean mouseOver;
  private Interpolation visualInterpolationInverse = Interpolation.linear;

  public Slider(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, Skin paramSkin)
  {
  }

  public Slider(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, Skin paramSkin, String paramString)
  {
    this(paramFloat1, paramFloat2, paramFloat3, paramBoolean, (Slider.SliderStyle)paramSkin.get(paramString, Slider.SliderStyle.class));
  }

  public Slider(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, Slider.SliderStyle paramSliderStyle)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramBoolean, paramSliderStyle);
    this.shiftIgnoresSnap = true;
    addListener(new Slider.1(this));
  }

  boolean calculatePositionAndValue(float paramFloat1, float paramFloat2)
  {
    Slider.SliderStyle localSliderStyle = getStyle();
    Drawable localDrawable1 = getKnobDrawable();
    Drawable localDrawable2;
    float f1;
    float f2;
    float f3;
    float f7;
    float f8;
    if ((this.disabled) && (localSliderStyle.disabledBackground != null))
    {
      localDrawable2 = localSliderStyle.disabledBackground;
      f1 = this.position;
      f2 = getMinValue();
      f3 = getMaxValue();
      if (!this.vertical)
        break label207;
      f7 = getHeight() - localDrawable2.getTopHeight() - localDrawable2.getBottomHeight();
      if (localDrawable1 != null)
        break label195;
      f8 = 0.0F;
    }
    float f6;
    while (true)
    {
      this.position = (paramFloat2 - localDrawable2.getBottomHeight() - f8 * 0.5F);
      f6 = f2 + (f3 - f2) * this.visualInterpolationInverse.apply(this.position / (f7 - f8));
      this.position = Math.max(0.0F, this.position);
      this.position = Math.min(f7 - f8, this.position);
      boolean bool = setValue(f6);
      if (f6 == f6)
        this.position = f1;
      return bool;
      localDrawable2 = localSliderStyle.background;
      break;
      label195: f8 = localDrawable1.getMinHeight();
    }
    label207: float f4 = getWidth() - localDrawable2.getLeftWidth() - localDrawable2.getRightWidth();
    float f5;
    if (localDrawable1 == null)
      f5 = 0.0F;
    while (true)
    {
      this.position = (paramFloat1 - localDrawable2.getLeftWidth() - f5 * 0.5F);
      f6 = f2 + (f3 - f2) * this.visualInterpolationInverse.apply(this.position / (f4 - f5));
      this.position = Math.max(0.0F, this.position);
      this.position = Math.min(f4 - f5, this.position);
      break;
      f5 = localDrawable1.getMinWidth();
    }
  }

  protected Drawable getKnobDrawable()
  {
    Slider.SliderStyle localSliderStyle = getStyle();
    if ((this.disabled) && (localSliderStyle.disabledKnob != null))
      return localSliderStyle.disabledKnob;
    if ((isDragging()) && (localSliderStyle.knobDown != null))
      return localSliderStyle.knobDown;
    if ((this.mouseOver) && (localSliderStyle.knobOver != null))
      return localSliderStyle.knobOver;
    return localSliderStyle.knob;
  }

  public Slider.SliderStyle getStyle()
  {
    return (Slider.SliderStyle)super.getStyle();
  }

  public boolean isDragging()
  {
    return this.draggingPointer != -1;
  }

  public void setStyle(Slider.SliderStyle paramSliderStyle)
  {
    if (paramSliderStyle == null)
      throw new NullPointerException("style cannot be null");
    if (!(paramSliderStyle instanceof Slider.SliderStyle))
      throw new IllegalArgumentException("style must be a SliderStyle.");
    super.setStyle(paramSliderStyle);
  }

  public void setVisualInterpolationInverse(Interpolation paramInterpolation)
  {
    this.visualInterpolationInverse = paramInterpolation;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Slider
 * JD-Core Version:    0.6.0
 */