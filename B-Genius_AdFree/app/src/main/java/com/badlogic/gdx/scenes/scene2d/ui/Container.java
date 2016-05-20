package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

public class Container extends WidgetGroup
{
  private Actor actor;
  private int align;
  private Drawable background;
  private boolean clip;
  private float fillX;
  private float fillY;
  private Value maxHeight = Value.zero;
  private Value maxWidth = Value.zero;
  private Value minHeight = Value.minHeight;
  private Value minWidth = Value.minWidth;
  private Value padBottom = Value.zero;
  private Value padLeft = Value.zero;
  private Value padRight = Value.zero;
  private Value padTop = Value.zero;
  private Value prefHeight = Value.prefHeight;
  private Value prefWidth = Value.prefWidth;
  private boolean round = true;

  public Container()
  {
    setTouchable(Touchable.childrenOnly);
    setTransform(false);
  }

  public Container(Actor paramActor)
  {
    this();
    setActor(paramActor);
  }

  public void addActor(Actor paramActor)
  {
    throw new UnsupportedOperationException("Use Container#setActor.");
  }

  public void addActorAfter(Actor paramActor1, Actor paramActor2)
  {
    throw new UnsupportedOperationException("Use Container#setActor.");
  }

  public void addActorAt(int paramInt, Actor paramActor)
  {
    throw new UnsupportedOperationException("Use Container#setActor.");
  }

  public void addActorBefore(Actor paramActor1, Actor paramActor2)
  {
    throw new UnsupportedOperationException("Use Container#setActor.");
  }

  public Container align(int paramInt)
  {
    this.align = paramInt;
    return this;
  }

  public Container background(Drawable paramDrawable)
  {
    setBackground(paramDrawable);
    return this;
  }

  public Container bottom()
  {
    this.align = (0x4 | this.align);
    this.align = (0xFFFFFFFD & this.align);
    return this;
  }

  public Container center()
  {
    this.align = 1;
    return this;
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    validate();
    if (isTransform())
    {
      applyTransform(paramBatch, computeTransform());
      drawBackground(paramBatch, paramFloat, 0.0F, 0.0F);
      if (this.clip)
      {
        paramBatch.flush();
        float f1 = this.padLeft.get(this);
        float f2 = this.padBottom.get(this);
        if (clipBegin(f1, f2, getWidth() - f1 - this.padRight.get(this), getHeight() - f2 - this.padTop.get(this)))
        {
          drawChildren(paramBatch, paramFloat);
          paramBatch.flush();
          clipEnd();
        }
      }
      while (true)
      {
        resetTransform(paramBatch);
        return;
        drawChildren(paramBatch, paramFloat);
      }
    }
    drawBackground(paramBatch, paramFloat, getX(), getY());
    super.draw(paramBatch, paramFloat);
  }

  protected void drawBackground(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.background == null)
      return;
    Color localColor = getColor();
    paramBatch.setColor(localColor.r, localColor.g, localColor.b, paramFloat1 * localColor.a);
    this.background.draw(paramBatch, paramFloat2, paramFloat3, getWidth(), getHeight());
  }

  public void drawDebug(ShapeRenderer paramShapeRenderer)
  {
    validate();
    if (isTransform())
    {
      applyTransform(paramShapeRenderer, computeTransform());
      float f1;
      float f2;
      boolean bool;
      if (this.clip)
      {
        paramShapeRenderer.flush();
        f1 = this.padLeft.get(this);
        f2 = this.padBottom.get(this);
        if (this.background == null)
        {
          bool = clipBegin(0.0F, 0.0F, getWidth(), getHeight());
          if (bool)
          {
            drawDebugChildren(paramShapeRenderer);
            clipEnd();
          }
        }
      }
      while (true)
      {
        resetTransform(paramShapeRenderer);
        return;
        bool = clipBegin(f1, f2, getWidth() - f1 - this.padRight.get(this), getHeight() - f2 - this.padTop.get(this));
        break;
        drawDebugChildren(paramShapeRenderer);
      }
    }
    super.drawDebug(paramShapeRenderer);
  }

  public Container fill()
  {
    this.fillX = 1.0F;
    this.fillY = 1.0F;
    return this;
  }

  public Container fill(float paramFloat1, float paramFloat2)
  {
    this.fillX = paramFloat1;
    this.fillY = paramFloat2;
    return this;
  }

  public Container fill(boolean paramBoolean)
  {
    float f1 = 1.0F;
    float f2;
    if (paramBoolean)
    {
      f2 = f1;
      this.fillX = f2;
      if (!paramBoolean)
        break label29;
    }
    while (true)
    {
      this.fillY = f1;
      return this;
      f2 = 0.0F;
      break;
      label29: f1 = 0.0F;
    }
  }

  public Container fill(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f1 = 1.0F;
    float f2;
    if (paramBoolean1)
    {
      f2 = f1;
      this.fillX = f2;
      if (!paramBoolean2)
        break label32;
    }
    while (true)
    {
      this.fillY = f1;
      return this;
      f2 = 0.0F;
      break;
      label32: f1 = 0.0F;
    }
  }

  public Container fillX()
  {
    this.fillX = 1.0F;
    return this;
  }

  public Container fillY()
  {
    this.fillY = 1.0F;
    return this;
  }

  public Actor getActor()
  {
    return this.actor;
  }

  public int getAlign()
  {
    return this.align;
  }

  public Drawable getBackground()
  {
    return this.background;
  }

  public boolean getClip()
  {
    return this.clip;
  }

  public float getFillX()
  {
    return this.fillX;
  }

  public float getFillY()
  {
    return this.fillY;
  }

  public float getMaxHeight()
  {
    float f = this.maxHeight.get(this.actor);
    if (f > 0.0F)
      f += this.padTop.get(this) + this.padBottom.get(this);
    return f;
  }

  public Value getMaxHeightValue()
  {
    return this.maxHeight;
  }

  public float getMaxWidth()
  {
    float f = this.maxWidth.get(this.actor);
    if (f > 0.0F)
      f += this.padLeft.get(this) + this.padRight.get(this);
    return f;
  }

  public Value getMaxWidthValue()
  {
    return this.maxWidth;
  }

  public float getMinHeight()
  {
    return this.minHeight.get(this.actor) + this.padTop.get(this) + this.padBottom.get(this);
  }

  public Value getMinHeightValue()
  {
    return this.minHeight;
  }

  public float getMinWidth()
  {
    return this.minWidth.get(this.actor) + this.padLeft.get(this) + this.padRight.get(this);
  }

  public float getPadBottom()
  {
    return this.padBottom.get(this);
  }

  public Value getPadBottomValue()
  {
    return this.padBottom;
  }

  public float getPadLeft()
  {
    return this.padLeft.get(this);
  }

  public Value getPadLeftValue()
  {
    return this.padLeft;
  }

  public float getPadRight()
  {
    return this.padRight.get(this);
  }

  public Value getPadRightValue()
  {
    return this.padRight;
  }

  public float getPadTop()
  {
    return this.padTop.get(this);
  }

  public Value getPadTopValue()
  {
    return this.padTop;
  }

  public float getPadX()
  {
    return this.padLeft.get(this) + this.padRight.get(this);
  }

  public float getPadY()
  {
    return this.padTop.get(this) + this.padBottom.get(this);
  }

  public float getPrefHeight()
  {
    float f = this.prefHeight.get(this.actor);
    if (this.background != null)
      f = Math.max(f, this.background.getMinHeight());
    return Math.max(getMinHeight(), f + this.padTop.get(this) + this.padBottom.get(this));
  }

  public Value getPrefHeightValue()
  {
    return this.prefHeight;
  }

  public float getPrefWidth()
  {
    float f = this.prefWidth.get(this.actor);
    if (this.background != null)
      f = Math.max(f, this.background.getMinWidth());
    return Math.max(getMinWidth(), f + this.padLeft.get(this) + this.padRight.get(this));
  }

  public Value getPrefWidthValue()
  {
    return this.prefWidth;
  }

  public Container height(float paramFloat)
  {
    height(new Value.Fixed(paramFloat));
    return this;
  }

  public Container height(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.minHeight = paramValue;
    this.prefHeight = paramValue;
    this.maxHeight = paramValue;
    return this;
  }

  public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.clip)
    {
      if ((paramBoolean) && (getTouchable() == Touchable.disabled));
      do
        return null;
      while ((paramFloat1 < 0.0F) || (paramFloat1 >= getWidth()) || (paramFloat2 < 0.0F) || (paramFloat2 >= getHeight()));
    }
    return super.hit(paramFloat1, paramFloat2, paramBoolean);
  }

  public void layout()
  {
    if (this.actor == null)
      return;
    float f1 = this.padLeft.get(this);
    float f2 = this.padBottom.get(this);
    float f3 = getWidth() - f1 - this.padRight.get(this);
    float f4 = getHeight() - f2 - this.padTop.get(this);
    float f5 = this.minWidth.get(this.actor);
    float f6 = this.minHeight.get(this.actor);
    float f7 = this.prefWidth.get(this.actor);
    float f8 = this.prefHeight.get(this.actor);
    float f9 = this.maxWidth.get(this.actor);
    float f10 = this.maxHeight.get(this.actor);
    float f11;
    if (this.fillX > 0.0F)
    {
      f11 = f3 * this.fillX;
      label154: if (f11 >= f5)
        break label427;
    }
    while (true)
    {
      if ((f9 > 0.0F) && (f5 > f9));
      while (true)
      {
        float f12;
        label195: float f13;
        if (this.fillY > 0.0F)
        {
          f12 = f4 * this.fillY;
          if (f12 < f6)
            f12 = f6;
          if ((f10 > 0.0F) && (f12 > f10))
            f12 = f10;
          if ((0x10 & this.align) == 0)
            break label362;
          f13 = f1 + (f3 - f9);
        }
        while (true)
        {
          label244: float f14;
          if ((0x2 & this.align) != 0)
            f14 = f2 + (f4 - f12);
          while (true)
          {
            if (this.round)
            {
              f13 = Math.round(f13);
              f14 = Math.round(f14);
              f9 = Math.round(f9);
              f12 = Math.round(f12);
            }
            this.actor.setBounds(f13, f14, f9, f12);
            if (!(this.actor instanceof Layout))
              break;
            ((Layout)this.actor).validate();
            return;
            f11 = Math.min(f7, f3);
            break label154;
            f12 = Math.min(f8, f4);
            break label195;
            label362: if ((0x8 & this.align) != 0)
              break label414;
            f13 = f1 + (f3 - f9) / 2.0F;
            break label244;
            if ((0x4 & this.align) == 0)
            {
              f14 = f2 + (f4 - f12) / 2.0F;
              continue;
            }
            f14 = f2;
          }
          label414: f13 = f1;
        }
        f9 = f5;
      }
      label427: f5 = f11;
    }
  }

  public Container left()
  {
    this.align = (0x8 | this.align);
    this.align = (0xFFFFFFEF & this.align);
    return this;
  }

  public Container maxHeight(float paramFloat)
  {
    this.maxHeight = new Value.Fixed(paramFloat);
    return this;
  }

  public Container maxHeight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("maxHeight cannot be null.");
    this.maxHeight = paramValue;
    return this;
  }

  public Container maxSize(float paramFloat)
  {
    maxSize(new Value.Fixed(paramFloat));
    return this;
  }

  public Container maxSize(float paramFloat1, float paramFloat2)
  {
    maxSize(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2));
    return this;
  }

  public Container maxSize(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("size cannot be null.");
    this.maxWidth = paramValue;
    this.maxHeight = paramValue;
    return this;
  }

  public Container maxSize(Value paramValue1, Value paramValue2)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("width cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.maxWidth = paramValue1;
    this.maxHeight = paramValue2;
    return this;
  }

  public Container maxWidth(float paramFloat)
  {
    this.maxWidth = new Value.Fixed(paramFloat);
    return this;
  }

  public Container maxWidth(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("maxWidth cannot be null.");
    this.maxWidth = paramValue;
    return this;
  }

  public Container minHeight(float paramFloat)
  {
    this.minHeight = new Value.Fixed(paramFloat);
    return this;
  }

  public Container minHeight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("minHeight cannot be null.");
    this.minHeight = paramValue;
    return this;
  }

  public Container minSize(float paramFloat)
  {
    minSize(new Value.Fixed(paramFloat));
    return this;
  }

  public Container minSize(float paramFloat1, float paramFloat2)
  {
    minSize(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2));
    return this;
  }

  public Container minSize(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("size cannot be null.");
    this.minWidth = paramValue;
    this.minHeight = paramValue;
    return this;
  }

  public Container minSize(Value paramValue1, Value paramValue2)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("width cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.minWidth = paramValue1;
    this.minHeight = paramValue2;
    return this;
  }

  public Container minWidth(float paramFloat)
  {
    this.minWidth = new Value.Fixed(paramFloat);
    return this;
  }

  public Container minWidth(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("minWidth cannot be null.");
    this.minWidth = paramValue;
    return this;
  }

  public Container pad(float paramFloat)
  {
    Value.Fixed localFixed = new Value.Fixed(paramFloat);
    this.padTop = localFixed;
    this.padLeft = localFixed;
    this.padBottom = localFixed;
    this.padRight = localFixed;
    return this;
  }

  public Container pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.padTop = new Value.Fixed(paramFloat1);
    this.padLeft = new Value.Fixed(paramFloat2);
    this.padBottom = new Value.Fixed(paramFloat3);
    this.padRight = new Value.Fixed(paramFloat4);
    return this;
  }

  public Container pad(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("pad cannot be null.");
    this.padTop = paramValue;
    this.padLeft = paramValue;
    this.padBottom = paramValue;
    this.padRight = paramValue;
    return this;
  }

  public Container pad(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("top cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("left cannot be null.");
    if (paramValue3 == null)
      throw new IllegalArgumentException("bottom cannot be null.");
    if (paramValue4 == null)
      throw new IllegalArgumentException("right cannot be null.");
    this.padTop = paramValue1;
    this.padLeft = paramValue2;
    this.padBottom = paramValue3;
    this.padRight = paramValue4;
    return this;
  }

  public Container padBottom(float paramFloat)
  {
    this.padBottom = new Value.Fixed(paramFloat);
    return this;
  }

  public Container padBottom(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padBottom cannot be null.");
    this.padBottom = paramValue;
    return this;
  }

  public Container padLeft(float paramFloat)
  {
    this.padLeft = new Value.Fixed(paramFloat);
    return this;
  }

  public Container padLeft(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padLeft cannot be null.");
    this.padLeft = paramValue;
    return this;
  }

  public Container padRight(float paramFloat)
  {
    this.padRight = new Value.Fixed(paramFloat);
    return this;
  }

  public Container padRight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padRight cannot be null.");
    this.padRight = paramValue;
    return this;
  }

  public Container padTop(float paramFloat)
  {
    this.padTop = new Value.Fixed(paramFloat);
    return this;
  }

  public Container padTop(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padTop cannot be null.");
    this.padTop = paramValue;
    return this;
  }

  public Container prefHeight(float paramFloat)
  {
    this.prefHeight = new Value.Fixed(paramFloat);
    return this;
  }

  public Container prefHeight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("prefHeight cannot be null.");
    this.prefHeight = paramValue;
    return this;
  }

  public Container prefSize(float paramFloat)
  {
    prefSize(new Value.Fixed(paramFloat));
    return this;
  }

  public Container prefSize(float paramFloat1, float paramFloat2)
  {
    prefSize(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2));
    return this;
  }

  public Container prefSize(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("size cannot be null.");
    this.prefWidth = paramValue;
    this.prefHeight = paramValue;
    return this;
  }

  public Container prefSize(Value paramValue1, Value paramValue2)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("width cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.prefWidth = paramValue1;
    this.prefHeight = paramValue2;
    return this;
  }

  public Container prefWidth(float paramFloat)
  {
    this.prefWidth = new Value.Fixed(paramFloat);
    return this;
  }

  public Container prefWidth(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("prefWidth cannot be null.");
    this.prefWidth = paramValue;
    return this;
  }

  public boolean removeActor(Actor paramActor)
  {
    if (paramActor != this.actor)
      return false;
    setActor(null);
    return true;
  }

  public Container right()
  {
    this.align = (0x10 | this.align);
    this.align = (0xFFFFFFF7 & this.align);
    return this;
  }

  public void setActor(Actor paramActor)
  {
    if (paramActor == this)
      throw new IllegalArgumentException("actor cannot be the Container.");
    if (paramActor == this.actor);
    do
    {
      return;
      if (this.actor != null)
        super.removeActor(this.actor);
      this.actor = paramActor;
    }
    while (paramActor == null);
    super.addActor(paramActor);
  }

  public void setBackground(Drawable paramDrawable)
  {
    setBackground(paramDrawable, true);
  }

  public void setBackground(Drawable paramDrawable, boolean paramBoolean)
  {
    if (this.background == paramDrawable);
    do
    {
      return;
      this.background = paramDrawable;
    }
    while (!paramBoolean);
    if (paramDrawable == null)
      pad(Value.zero);
    while (true)
    {
      invalidate();
      return;
      pad(paramDrawable.getTopHeight(), paramDrawable.getLeftWidth(), paramDrawable.getBottomHeight(), paramDrawable.getRightWidth());
    }
  }

  public void setClip(boolean paramBoolean)
  {
    this.clip = paramBoolean;
    setTransform(paramBoolean);
    invalidate();
  }

  public void setRound(boolean paramBoolean)
  {
    this.round = paramBoolean;
  }

  public Container size(float paramFloat)
  {
    size(new Value.Fixed(paramFloat));
    return this;
  }

  public Container size(float paramFloat1, float paramFloat2)
  {
    size(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2));
    return this;
  }

  public Container size(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("size cannot be null.");
    this.minWidth = paramValue;
    this.minHeight = paramValue;
    this.prefWidth = paramValue;
    this.prefHeight = paramValue;
    this.maxWidth = paramValue;
    this.maxHeight = paramValue;
    return this;
  }

  public Container size(Value paramValue1, Value paramValue2)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("width cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.minWidth = paramValue1;
    this.minHeight = paramValue2;
    this.prefWidth = paramValue1;
    this.prefHeight = paramValue2;
    this.maxWidth = paramValue1;
    this.maxHeight = paramValue2;
    return this;
  }

  public Container top()
  {
    this.align = (0x2 | this.align);
    this.align = (0xFFFFFFFB & this.align);
    return this;
  }

  public Container width(float paramFloat)
  {
    width(new Value.Fixed(paramFloat));
    return this;
  }

  public Container width(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("width cannot be null.");
    this.minWidth = paramValue;
    this.prefWidth = paramValue;
    this.maxWidth = paramValue;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Container
 * JD-Core Version:    0.6.0
 */