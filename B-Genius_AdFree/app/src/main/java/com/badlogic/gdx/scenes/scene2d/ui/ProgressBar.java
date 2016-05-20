package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Pools;

public class ProgressBar extends Widget
  implements Disableable
{
  private float animateDuration;
  private float animateFromValue;
  private Interpolation animateInterpolation = Interpolation.linear;
  private float animateTime;
  boolean disabled;
  private float max;
  private float min;
  float position;
  boolean shiftIgnoresSnap;
  private float[] snapValues;
  private float stepSize;
  private ProgressBar.ProgressBarStyle style;
  private float threshold;
  private float value;
  final boolean vertical;
  private Interpolation visualInterpolation = Interpolation.linear;

  public ProgressBar(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, ProgressBar.ProgressBarStyle paramProgressBarStyle)
  {
    if (paramFloat1 > paramFloat2)
      throw new IllegalArgumentException("max must be > min. min,max: " + paramFloat1 + ", " + paramFloat2);
    if (paramFloat3 <= 0.0F)
      throw new IllegalArgumentException("stepSize must be > 0: " + paramFloat3);
    setStyle(paramProgressBarStyle);
    this.min = paramFloat1;
    this.max = paramFloat2;
    this.stepSize = paramFloat3;
    this.vertical = paramBoolean;
    this.value = paramFloat1;
    setSize(getPrefWidth(), getPrefHeight());
  }

  public ProgressBar(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, Skin paramSkin)
  {
  }

  public ProgressBar(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, Skin paramSkin, String paramString)
  {
    this(paramFloat1, paramFloat2, paramFloat3, paramBoolean, (ProgressBar.ProgressBarStyle)paramSkin.get(paramString, ProgressBar.ProgressBarStyle.class));
  }

  private float snap(float paramFloat)
  {
    if (this.snapValues == null);
    while (true)
    {
      return paramFloat;
      for (int i = 0; i < this.snapValues.length; i++)
        if (Math.abs(paramFloat - this.snapValues[i]) <= this.threshold)
          return this.snapValues[i];
    }
  }

  public void act(float paramFloat)
  {
    super.act(paramFloat);
    if (this.animateTime > 0.0F)
    {
      this.animateTime -= paramFloat;
      Stage localStage = getStage();
      if ((localStage != null) && (localStage.getActionsRequestRendering()))
        Gdx.graphics.requestRendering();
    }
  }

  protected float clamp(float paramFloat)
  {
    return MathUtils.clamp(paramFloat, this.min, this.max);
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    ProgressBar.ProgressBarStyle localProgressBarStyle = this.style;
    boolean bool1 = this.disabled;
    Drawable localDrawable1 = getKnobDrawable();
    Drawable localDrawable2;
    Drawable localDrawable3;
    label53: Drawable localDrawable4;
    label71: float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    label109: float f6;
    label117: float f7;
    float f18;
    float f17;
    if ((bool1) && (localProgressBarStyle.disabledBackground != null))
    {
      localDrawable2 = localProgressBarStyle.disabledBackground;
      if ((!bool1) || (localProgressBarStyle.disabledKnobBefore == null))
        break label480;
      localDrawable3 = localProgressBarStyle.disabledKnobBefore;
      if ((!bool1) || (localProgressBarStyle.disabledKnobAfter == null))
        break label489;
      localDrawable4 = localProgressBarStyle.disabledKnobAfter;
      Color localColor = getColor();
      f1 = getX();
      f2 = getY();
      f3 = getWidth();
      f4 = getHeight();
      if (localDrawable1 != null)
        break label498;
      f5 = 0.0F;
      if (localDrawable1 != null)
        break label510;
      f6 = 0.0F;
      f7 = getVisualPercent();
      paramBatch.setColor(localColor.r, localColor.g, localColor.b, paramFloat * localColor.a);
      if (!this.vertical)
        break label583;
      if (localDrawable2 == null)
        break label982;
      localDrawable2.draw(paramBatch, f1 + (int)(0.5F * (f3 - localDrawable2.getMinWidth())), f2, localDrawable2.getMinWidth(), f4);
      f18 = localDrawable2.getTopHeight();
      f17 = f4 - (f18 + localDrawable2.getBottomHeight());
    }
    while (true)
    {
      boolean bool3 = this.min < this.max;
      float f19 = 0.0F;
      if (bool3)
      {
        if (localDrawable1 != null)
          break label537;
        if (localDrawable3 == null)
        {
          f19 = 0.0F;
          label256: this.position = (f7 * (f17 - f19));
          this.position = Math.min(f17 - f19, this.position);
          label284: this.position = Math.max(0.0F, this.position);
        }
      }
      else if (localDrawable3 != null)
      {
        if (localDrawable2 == null)
          break label976;
      }
      while (true)
      {
        localDrawable3.draw(paramBatch, f1 + (int)(0.5F * (f3 - localDrawable3.getMinWidth())), f2 + f18, localDrawable3.getMinWidth(), (int)(f19 + this.position));
        if (localDrawable4 != null)
        {
          float f20 = f1 + (int)(0.5F * (f3 - localDrawable4.getMinWidth()));
          float f21 = f2 + (int)(f19 + this.position);
          float f22 = localDrawable4.getMinWidth();
          float f23 = f4 - (int)(f19 + this.position);
          localDrawable4.draw(paramBatch, f20, f21, f22, f23);
        }
        if (localDrawable1 != null)
          localDrawable1.draw(paramBatch, f1 + (int)(0.5F * (f3 - f6)), (int)(f2 + this.position), f6, f5);
        return;
        localDrawable2 = localProgressBarStyle.background;
        break;
        label480: localDrawable3 = localProgressBarStyle.knobBefore;
        break label53;
        label489: localDrawable4 = localProgressBarStyle.knobAfter;
        break label71;
        label498: f5 = localDrawable1.getMinHeight();
        break label109;
        label510: f6 = localDrawable1.getMinWidth();
        break label117;
        f19 = 0.5F * localDrawable3.getMinHeight();
        break label256;
        label537: f19 = 0.5F * f5;
        this.position = (f7 * (f17 - f5));
        this.position = (Math.min(f17 - f5, this.position) + localDrawable2.getBottomHeight());
        break label284;
        label583: float f9;
        float f8;
        if (localDrawable2 != null)
        {
          float f15 = f2 + (int)(0.5F * (f4 - localDrawable2.getMinHeight()));
          float f16 = localDrawable2.getMinHeight();
          localDrawable2.draw(paramBatch, f1, f15, f3, f16);
          f9 = localDrawable2.getLeftWidth();
          f8 = f3 - (f9 + localDrawable2.getRightWidth());
        }
        while (true)
        {
          boolean bool2 = this.min < this.max;
          float f10 = 0.0F;
          if (bool2)
          {
            if (localDrawable1 != null)
              break label919;
            if (localDrawable3 == null)
            {
              f10 = 0.0F;
              label689: this.position = (f7 * (f8 - f10));
              this.position = Math.min(f8 - f10, this.position);
              label717: this.position = Math.max(0.0F, this.position);
            }
          }
          else if (localDrawable3 != null)
          {
            if (localDrawable2 == null)
              break label960;
          }
          while (true)
          {
            localDrawable3.draw(paramBatch, f1 + f9, f2 + (int)(0.5F * (f4 - localDrawable3.getMinHeight())), (int)(f10 + this.position), localDrawable3.getMinHeight());
            if (localDrawable4 != null)
            {
              float f11 = f1 + (int)(f10 + this.position);
              float f12 = f2 + (int)(0.5F * (f4 - localDrawable4.getMinHeight()));
              float f13 = f3 - (int)(f10 + this.position);
              float f14 = localDrawable4.getMinHeight();
              localDrawable4.draw(paramBatch, f11, f12, f13, f14);
            }
            if (localDrawable1 == null)
              break;
            localDrawable1.draw(paramBatch, (int)(f1 + this.position), (int)(f2 + 0.5F * (f4 - f5)), f6, f5);
            return;
            f10 = 0.5F * localDrawable3.getMinWidth();
            break label689;
            label919: f10 = 0.5F * f6;
            this.position = (f7 * (f8 - f6));
            this.position = (f9 + Math.min(f8 - f6, this.position));
            break label717;
            label960: f9 = 0.0F;
          }
          f8 = f3;
          f9 = 0.0F;
        }
        label976: f18 = 0.0F;
      }
      label982: f17 = f4;
      f18 = 0.0F;
    }
  }

  protected Drawable getKnobDrawable()
  {
    if ((this.disabled) && (this.style.disabledKnob != null))
      return this.style.disabledKnob;
    return this.style.knob;
  }

  protected float getKnobPosition()
  {
    return this.position;
  }

  public float getMaxValue()
  {
    return this.max;
  }

  public float getMinValue()
  {
    return this.min;
  }

  public float getPercent()
  {
    return (this.value - this.min) / (this.max - this.min);
  }

  public float getPrefHeight()
  {
    if (this.vertical)
      return 140.0F;
    Drawable localDrawable1 = getKnobDrawable();
    Drawable localDrawable2;
    float f1;
    label47: float f2;
    if ((this.disabled) && (this.style.disabledBackground != null))
    {
      localDrawable2 = this.style.disabledBackground;
      if (localDrawable1 != null)
        break label72;
      f1 = 0.0F;
      f2 = 0.0F;
      if (localDrawable2 != null)
        break label82;
    }
    while (true)
    {
      return Math.max(f1, f2);
      localDrawable2 = this.style.background;
      break;
      label72: f1 = localDrawable1.getMinHeight();
      break label47;
      label82: f2 = localDrawable2.getMinHeight();
    }
  }

  public float getPrefWidth()
  {
    if (this.vertical)
    {
      Drawable localDrawable1 = getKnobDrawable();
      Drawable localDrawable2;
      float f;
      if ((this.disabled) && (this.style.disabledBackground != null))
      {
        localDrawable2 = this.style.disabledBackground;
        if (localDrawable1 != null)
          break label65;
        f = 0.0F;
      }
      while (true)
      {
        return Math.max(f, localDrawable2.getMinWidth());
        localDrawable2 = this.style.background;
        break;
        label65: f = localDrawable1.getMinWidth();
      }
    }
    return 140.0F;
  }

  public float getStepSize()
  {
    return this.stepSize;
  }

  public ProgressBar.ProgressBarStyle getStyle()
  {
    return this.style;
  }

  public float getValue()
  {
    return this.value;
  }

  public float getVisualPercent()
  {
    return this.visualInterpolation.apply((getVisualValue() - this.min) / (this.max - this.min));
  }

  public float getVisualValue()
  {
    if (this.animateTime > 0.0F)
      return this.animateInterpolation.apply(this.animateFromValue, this.value, 1.0F - this.animateTime / this.animateDuration);
    return this.value;
  }

  public boolean isDisabled()
  {
    return this.disabled;
  }

  public void setAnimateDuration(float paramFloat)
  {
    this.animateDuration = paramFloat;
  }

  public void setAnimateInterpolation(Interpolation paramInterpolation)
  {
    if (paramInterpolation == null)
      throw new IllegalArgumentException("animateInterpolation cannot be null.");
    this.animateInterpolation = paramInterpolation;
  }

  public void setDisabled(boolean paramBoolean)
  {
    this.disabled = paramBoolean;
  }

  public void setRange(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2)
      throw new IllegalArgumentException("min must be <= max");
    this.min = paramFloat1;
    this.max = paramFloat2;
    if (this.value < paramFloat1)
      setValue(paramFloat1);
    do
      return;
    while (this.value <= paramFloat2);
    setValue(paramFloat2);
  }

  public void setSnapToValues(float[] paramArrayOfFloat, float paramFloat)
  {
    this.snapValues = paramArrayOfFloat;
    this.threshold = paramFloat;
  }

  public void setStepSize(float paramFloat)
  {
    if (paramFloat <= 0.0F)
      throw new IllegalArgumentException("steps must be > 0: " + paramFloat);
    this.stepSize = paramFloat;
  }

  public void setStyle(ProgressBar.ProgressBarStyle paramProgressBarStyle)
  {
    if (paramProgressBarStyle == null)
      throw new IllegalArgumentException("style cannot be null.");
    this.style = paramProgressBarStyle;
    invalidateHierarchy();
  }

  public boolean setValue(float paramFloat)
  {
    float f1 = clamp(Math.round(paramFloat / this.stepSize) * this.stepSize);
    if ((!this.shiftIgnoresSnap) || ((!Gdx.input.isKeyPressed(59)) && (!Gdx.input.isKeyPressed(60))))
      f1 = snap(f1);
    float f2 = this.value;
    if (f1 == f2)
      return false;
    float f3 = getVisualValue();
    this.value = f1;
    ChangeListener.ChangeEvent localChangeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
    boolean bool = fire(localChangeEvent);
    if (bool)
      this.value = f2;
    while (true)
    {
      Pools.free(localChangeEvent);
      if (bool)
        break;
      return true;
      if (this.animateDuration <= 0.0F)
        continue;
      this.animateFromValue = f3;
      this.animateTime = this.animateDuration;
    }
    return false;
  }

  public void setVisualInterpolation(Interpolation paramInterpolation)
  {
    this.visualInterpolation = paramInterpolation;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.ProgressBar
 * JD-Core Version:    0.6.0
 */