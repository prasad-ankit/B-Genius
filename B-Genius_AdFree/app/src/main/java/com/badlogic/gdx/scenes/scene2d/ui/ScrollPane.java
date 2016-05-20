package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class ScrollPane extends WidgetGroup
{
  float amountX;
  float amountY;
  float areaHeight;
  float areaWidth;
  boolean cancelTouchFocus = true;
  private boolean clamp = true;
  private boolean disableX;
  private boolean disableY;
  int draggingPointer = -1;
  float fadeAlpha;
  float fadeAlphaSeconds = 1.0F;
  float fadeDelay;
  float fadeDelaySeconds = 1.0F;
  private boolean fadeScrollBars = true;
  boolean flickScroll = true;
  private ActorGestureListener flickScrollListener;
  float flingTime = 1.0F;
  float flingTimer;
  private boolean forceScrollX;
  private boolean forceScrollY;
  final Rectangle hKnobBounds = new Rectangle();
  final Rectangle hScrollBounds = new Rectangle();
  boolean hScrollOnBottom = true;
  final Vector2 lastPoint = new Vector2();
  float maxX;
  float maxY;
  private float overscrollDistance = 50.0F;
  private float overscrollSpeedMax = 200.0F;
  private float overscrollSpeedMin = 30.0F;
  private boolean overscrollX = true;
  private boolean overscrollY = true;
  private final Rectangle scissorBounds = new Rectangle();
  boolean scrollX;
  boolean scrollY;
  private boolean scrollbarsOnTop;
  private boolean smoothScrolling = true;
  private ScrollPane.ScrollPaneStyle style;
  boolean touchScrollH;
  boolean touchScrollV;
  final Rectangle vKnobBounds = new Rectangle();
  final Rectangle vScrollBounds = new Rectangle();
  boolean vScrollOnRight = true;
  private boolean variableSizeKnobs = true;
  float velocityX;
  float velocityY;
  float visualAmountX;
  float visualAmountY;
  private Actor widget;
  private final Rectangle widgetAreaBounds = new Rectangle();
  private final Rectangle widgetCullingArea = new Rectangle();

  public ScrollPane(Actor paramActor)
  {
    this(paramActor, new ScrollPane.ScrollPaneStyle());
  }

  public ScrollPane(Actor paramActor, ScrollPane.ScrollPaneStyle paramScrollPaneStyle)
  {
    if (paramScrollPaneStyle == null)
      throw new IllegalArgumentException("style cannot be null.");
    this.style = paramScrollPaneStyle;
    setWidget(paramActor);
    setSize(150.0F, 150.0F);
    addCaptureListener(new ScrollPane.1(this));
    this.flickScrollListener = new ScrollPane.2(this);
    addListener(this.flickScrollListener);
    addListener(new ScrollPane.3(this));
  }

  public ScrollPane(Actor paramActor, Skin paramSkin)
  {
    this(paramActor, (ScrollPane.ScrollPaneStyle)paramSkin.get(ScrollPane.ScrollPaneStyle.class));
  }

  public ScrollPane(Actor paramActor, Skin paramSkin, String paramString)
  {
    this(paramActor, (ScrollPane.ScrollPaneStyle)paramSkin.get(paramString, ScrollPane.ScrollPaneStyle.class));
  }

  public void act(float paramFloat)
  {
    super.act(paramFloat);
    boolean bool1 = this.flickScrollListener.getGestureDetector().isPanning();
    boolean bool2 = this.fadeAlpha < 0.0F;
    int i = 0;
    if (bool2)
    {
      boolean bool3 = this.fadeScrollBars;
      i = 0;
      if (bool3)
      {
        i = 0;
        if (!bool1)
        {
          boolean bool4 = this.touchScrollH;
          i = 0;
          if (!bool4)
          {
            boolean bool5 = this.touchScrollV;
            i = 0;
            if (!bool5)
            {
              this.fadeDelay -= paramFloat;
              if (this.fadeDelay <= 0.0F)
                this.fadeAlpha = Math.max(0.0F, this.fadeAlpha - paramFloat);
              i = 1;
            }
          }
        }
      }
    }
    if (this.flingTimer > 0.0F)
    {
      resetFade();
      float f = this.flingTimer / this.flingTime;
      this.amountX -= paramFloat * (f * this.velocityX);
      this.amountY -= paramFloat * (f * this.velocityY);
      clamp();
      if (this.amountX == -this.overscrollDistance)
        this.velocityX = 0.0F;
      if (this.amountX >= this.maxX + this.overscrollDistance)
        this.velocityX = 0.0F;
      if (this.amountY == -this.overscrollDistance)
        this.velocityY = 0.0F;
      if (this.amountY >= this.maxY + this.overscrollDistance)
        this.velocityY = 0.0F;
      this.flingTimer -= paramFloat;
      if (this.flingTimer <= 0.0F)
      {
        this.velocityX = 0.0F;
        this.velocityY = 0.0F;
      }
      i = 1;
    }
    if ((this.smoothScrolling) && (this.flingTimer <= 0.0F) && (!bool1) && ((!this.touchScrollH) || ((this.scrollX) && (this.maxX / (this.hScrollBounds.width - this.hKnobBounds.width) > 0.1F * this.areaWidth))) && ((!this.touchScrollV) || ((this.scrollY) && (this.maxY / (this.vScrollBounds.height - this.vKnobBounds.height) > 0.1F * this.areaHeight))))
      if (this.visualAmountX != this.amountX)
      {
        if (this.visualAmountX < this.amountX)
        {
          visualScrollX(Math.min(this.amountX, this.visualAmountX + Math.max(200.0F * paramFloat, paramFloat * (7.0F * (this.amountX - this.visualAmountX)))));
          i = 1;
        }
      }
      else
      {
        if (this.visualAmountY != this.amountY)
        {
          if (this.visualAmountY >= this.amountY)
            break label766;
          visualScrollY(Math.min(this.amountY, this.visualAmountY + Math.max(200.0F * paramFloat, paramFloat * (7.0F * (this.amountY - this.visualAmountY)))));
          label526: i = 1;
        }
        label529: if (!bool1)
        {
          if ((this.overscrollX) && (this.scrollX))
          {
            if (this.amountX >= 0.0F)
              break label849;
            resetFade();
            this.amountX += paramFloat * (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -this.amountX / this.overscrollDistance);
            if (this.amountX > 0.0F)
              scrollX(0.0F);
            i = 1;
          }
          label613: if ((this.overscrollY) && (this.scrollY))
          {
            if (this.amountY >= 0.0F)
              break label932;
            resetFade();
            this.amountY += paramFloat * (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -this.amountY / this.overscrollDistance);
            if (this.amountY > 0.0F)
              scrollY(0.0F);
            i = 1;
          }
        }
      }
    while (true)
    {
      if (i != 0)
      {
        Stage localStage = getStage();
        if ((localStage != null) && (localStage.getActionsRequestRendering()))
          Gdx.graphics.requestRendering();
      }
      return;
      visualScrollX(Math.max(this.amountX, this.visualAmountX - Math.max(200.0F * paramFloat, paramFloat * (7.0F * (this.visualAmountX - this.amountX)))));
      break;
      label766: visualScrollY(Math.max(this.amountY, this.visualAmountY - Math.max(200.0F * paramFloat, paramFloat * (7.0F * (this.visualAmountY - this.amountY)))));
      break label526;
      if (this.visualAmountX != this.amountX)
        visualScrollX(this.amountX);
      if (this.visualAmountY == this.amountY)
        break label529;
      visualScrollY(this.amountY);
      break label529;
      label849: if (this.amountX <= this.maxX)
        break label613;
      resetFade();
      this.amountX -= paramFloat * (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -(this.maxX - this.amountX) / this.overscrollDistance);
      if (this.amountX < this.maxX)
        scrollX(this.maxX);
      i = 1;
      break label613;
      label932: if (this.amountY <= this.maxY)
        continue;
      resetFade();
      this.amountY -= paramFloat * (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -(this.maxY - this.amountY) / this.overscrollDistance);
      if (this.amountY < this.maxY)
        scrollY(this.maxY);
      i = 1;
    }
  }

  public void addActor(Actor paramActor)
  {
    throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
  }

  public void addActorAfter(Actor paramActor1, Actor paramActor2)
  {
    throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
  }

  public void addActorAt(int paramInt, Actor paramActor)
  {
    throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
  }

  public void addActorBefore(Actor paramActor1, Actor paramActor2)
  {
    throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
  }

  public void cancel()
  {
    this.draggingPointer = -1;
    this.touchScrollH = false;
    this.touchScrollV = false;
    this.flickScrollListener.getGestureDetector().cancel();
  }

  public void cancelTouchFocus()
  {
    Stage localStage = getStage();
    if (localStage != null)
      localStage.cancelTouchFocusExcept(this.flickScrollListener, this);
  }

  void clamp()
  {
    if (!this.clamp)
      return;
    float f1;
    float f2;
    if (this.overscrollX)
    {
      f1 = MathUtils.clamp(this.amountX, -this.overscrollDistance, this.maxX + this.overscrollDistance);
      scrollX(f1);
      if (!this.overscrollY)
        break label93;
      f2 = MathUtils.clamp(this.amountY, -this.overscrollDistance, this.maxY + this.overscrollDistance);
    }
    while (true)
    {
      scrollY(f2);
      return;
      f1 = MathUtils.clamp(this.amountX, 0.0F, this.maxX);
      break;
      label93: f2 = MathUtils.clamp(this.amountY, 0.0F, this.maxY);
    }
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    if (this.widget == null)
      return;
    validate();
    applyTransform(paramBatch, computeTransform());
    if (this.scrollX)
      this.hKnobBounds.x = (this.hScrollBounds.x + (int)((this.hScrollBounds.width - this.hKnobBounds.width) * getVisualScrollPercentX()));
    if (this.scrollY)
      this.vKnobBounds.y = (this.vScrollBounds.y + (int)((this.vScrollBounds.height - this.vKnobBounds.height) * (1.0F - getVisualScrollPercentY())));
    float f1 = this.widgetAreaBounds.y;
    float f2;
    float f3;
    float f5;
    if (!this.scrollY)
    {
      f2 = f1 - (int)this.maxY;
      f3 = this.widgetAreaBounds.x;
      if (this.scrollX)
        f3 -= (int)this.visualAmountX;
      if ((!this.fadeScrollBars) && (this.scrollbarsOnTop))
        if ((this.scrollX) && (this.hScrollOnBottom))
        {
          if (this.style.hScrollKnob == null)
            break label915;
          f5 = this.style.hScrollKnob.getMinHeight();
        }
    }
    while (true)
    {
      if (this.style.hScroll != null)
        f5 = Math.max(f5, this.style.hScroll.getMinHeight());
      f2 += f5;
      float f4;
      if ((this.scrollY) && (!this.vScrollOnRight))
      {
        if (this.style.hScrollKnob == null)
          break label909;
        f4 = this.style.hScrollKnob.getMinWidth();
      }
      while (true)
      {
        if (this.style.hScroll != null)
          f4 = Math.max(f4, this.style.hScroll.getMinWidth());
        f3 += f4;
        this.widget.setPosition(f3, f2);
        if ((this.widget instanceof Cullable))
        {
          this.widgetCullingArea.x = (-this.widget.getX() + this.widgetAreaBounds.x);
          this.widgetCullingArea.y = (-this.widget.getY() + this.widgetAreaBounds.y);
          this.widgetCullingArea.width = this.widgetAreaBounds.width;
          this.widgetCullingArea.height = this.widgetAreaBounds.height;
          ((Cullable)this.widget).setCullingArea(this.widgetCullingArea);
        }
        Color localColor = getColor();
        paramBatch.setColor(localColor.r, localColor.g, localColor.b, paramFloat * localColor.a);
        if (this.style.background != null)
        {
          this.style.background.draw(paramBatch, 0.0F, 0.0F, getWidth(), getHeight());
          paramBatch.flush();
        }
        getStage().calculateScissors(this.widgetAreaBounds, this.scissorBounds);
        if (ScissorStack.pushScissors(this.scissorBounds))
        {
          drawChildren(paramBatch, paramFloat);
          paramBatch.flush();
          ScissorStack.popScissors();
        }
        paramBatch.setColor(localColor.r, localColor.g, localColor.b, paramFloat * localColor.a * Interpolation.fade.apply(this.fadeAlpha / this.fadeAlphaSeconds));
        if ((this.scrollX) && (this.scrollY) && (this.style.corner != null))
          this.style.corner.draw(paramBatch, this.hScrollBounds.x + this.hScrollBounds.width, this.hScrollBounds.y, this.vScrollBounds.width, this.vScrollBounds.y);
        if (this.scrollX)
        {
          if (this.style.hScroll != null)
            this.style.hScroll.draw(paramBatch, this.hScrollBounds.x, this.hScrollBounds.y, this.hScrollBounds.width, this.hScrollBounds.height);
          if (this.style.hScrollKnob != null)
            this.style.hScrollKnob.draw(paramBatch, this.hKnobBounds.x, this.hKnobBounds.y, this.hKnobBounds.width, this.hKnobBounds.height);
        }
        if (this.scrollY)
        {
          if (this.style.vScroll != null)
            this.style.vScroll.draw(paramBatch, this.vScrollBounds.x, this.vScrollBounds.y, this.vScrollBounds.width, this.vScrollBounds.height);
          if (this.style.vScrollKnob != null)
            this.style.vScrollKnob.draw(paramBatch, this.vKnobBounds.x, this.vKnobBounds.y, this.vKnobBounds.width, this.vKnobBounds.height);
        }
        resetTransform(paramBatch);
        return;
        f2 = f1 - (int)(this.maxY - this.visualAmountY);
        break;
        label909: f4 = 0.0F;
      }
      label915: f5 = 0.0F;
    }
  }

  public void drawDebug(ShapeRenderer paramShapeRenderer)
  {
    paramShapeRenderer.flush();
    applyTransform(paramShapeRenderer, computeTransform());
    if (ScissorStack.pushScissors(this.scissorBounds))
    {
      drawDebugChildren(paramShapeRenderer);
      ScissorStack.popScissors();
    }
    resetTransform(paramShapeRenderer);
  }

  public void fling(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.flingTimer = paramFloat1;
    this.velocityX = paramFloat2;
    this.velocityY = paramFloat3;
  }

  public float getMaxX()
  {
    return this.maxX;
  }

  public float getMaxY()
  {
    return this.maxY;
  }

  public float getMinHeight()
  {
    return 0.0F;
  }

  public float getMinWidth()
  {
    return 0.0F;
  }

  protected float getMouseWheelX()
  {
    return Math.max(0.9F * this.areaWidth, 0.1F * this.maxX) / 4.0F;
  }

  protected float getMouseWheelY()
  {
    return Math.max(0.9F * this.areaHeight, 0.1F * this.maxY) / 4.0F;
  }

  public float getPrefHeight()
  {
    if ((this.widget instanceof Layout))
    {
      float f1 = ((Layout)this.widget).getPrefHeight();
      if (this.style.background != null)
        f1 += this.style.background.getTopHeight() + this.style.background.getBottomHeight();
      if (this.forceScrollX)
      {
        Drawable localDrawable = this.style.hScrollKnob;
        float f2 = 0.0F;
        if (localDrawable != null)
          f2 = this.style.hScrollKnob.getMinHeight();
        if (this.style.hScroll != null)
          f2 = Math.max(f2, this.style.hScroll.getMinHeight());
        f1 += f2;
      }
      return f1;
    }
    return 150.0F;
  }

  public float getPrefWidth()
  {
    if ((this.widget instanceof Layout))
    {
      float f1 = ((Layout)this.widget).getPrefWidth();
      if (this.style.background != null)
        f1 += this.style.background.getLeftWidth() + this.style.background.getRightWidth();
      if (this.forceScrollY)
      {
        Drawable localDrawable = this.style.vScrollKnob;
        float f2 = 0.0F;
        if (localDrawable != null)
          f2 = this.style.vScrollKnob.getMinWidth();
        if (this.style.vScroll != null)
          f2 = Math.max(f2, this.style.vScroll.getMinWidth());
        f1 += f2;
      }
      return f1;
    }
    return 150.0F;
  }

  public float getScrollBarHeight()
  {
    boolean bool = this.scrollX;
    float f = 0.0F;
    if (!bool);
    do
    {
      return f;
      Drawable localDrawable = this.style.hScrollKnob;
      f = 0.0F;
      if (localDrawable == null)
        continue;
      f = this.style.hScrollKnob.getMinHeight();
    }
    while (this.style.hScroll == null);
    return Math.max(f, this.style.hScroll.getMinHeight());
  }

  public float getScrollBarWidth()
  {
    boolean bool = this.scrollY;
    float f = 0.0F;
    if (!bool);
    do
    {
      return f;
      Drawable localDrawable = this.style.vScrollKnob;
      f = 0.0F;
      if (localDrawable == null)
        continue;
      f = this.style.vScrollKnob.getMinWidth();
    }
    while (this.style.vScroll == null);
    return Math.max(f, this.style.vScroll.getMinWidth());
  }

  public float getScrollHeight()
  {
    return this.areaHeight;
  }

  public float getScrollPercentX()
  {
    return MathUtils.clamp(this.amountX / this.maxX, 0.0F, 1.0F);
  }

  public float getScrollPercentY()
  {
    return MathUtils.clamp(this.amountY / this.maxY, 0.0F, 1.0F);
  }

  public float getScrollWidth()
  {
    return this.areaWidth;
  }

  public float getScrollX()
  {
    return this.amountX;
  }

  public float getScrollY()
  {
    return this.amountY;
  }

  public ScrollPane.ScrollPaneStyle getStyle()
  {
    return this.style;
  }

  public boolean getVariableSizeKnobs()
  {
    return this.variableSizeKnobs;
  }

  public float getVelocityX()
  {
    return this.velocityX;
  }

  public float getVelocityY()
  {
    return this.velocityY;
  }

  public float getVisualScrollPercentX()
  {
    return MathUtils.clamp(this.visualAmountX / this.maxX, 0.0F, 1.0F);
  }

  public float getVisualScrollPercentY()
  {
    return MathUtils.clamp(this.visualAmountY / this.maxY, 0.0F, 1.0F);
  }

  public float getVisualScrollX()
  {
    if (!this.scrollX)
      return 0.0F;
    return this.visualAmountX;
  }

  public float getVisualScrollY()
  {
    if (!this.scrollY)
      return 0.0F;
    return this.visualAmountY;
  }

  public Actor getWidget()
  {
    return this.widget;
  }

  public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat1 >= getWidth()) || (paramFloat2 < 0.0F) || (paramFloat2 >= getHeight()))
      this = null;
    do
      return this;
    while (((this.scrollX) && (this.hScrollBounds.contains(paramFloat1, paramFloat2))) || ((this.scrollY) && (this.vScrollBounds.contains(paramFloat1, paramFloat2))));
    return super.hit(paramFloat1, paramFloat2, paramBoolean);
  }

  public boolean isBottomEdge()
  {
    return (!this.scrollY) || (this.amountY >= this.maxY);
  }

  public boolean isDragging()
  {
    return this.draggingPointer != -1;
  }

  public boolean isFlinging()
  {
    return this.flingTimer > 0.0F;
  }

  public boolean isForceScrollX()
  {
    return this.forceScrollX;
  }

  public boolean isForceScrollY()
  {
    return this.forceScrollY;
  }

  public boolean isLeftEdge()
  {
    return (!this.scrollX) || (this.amountX <= 0.0F);
  }

  public boolean isPanning()
  {
    return this.flickScrollListener.getGestureDetector().isPanning();
  }

  public boolean isRightEdge()
  {
    return (!this.scrollX) || (this.amountX >= this.maxX);
  }

  public boolean isScrollX()
  {
    return this.scrollX;
  }

  public boolean isScrollY()
  {
    return this.scrollY;
  }

  public boolean isScrollingDisabledX()
  {
    return this.disableX;
  }

  public boolean isScrollingDisabledY()
  {
    return this.disableY;
  }

  public boolean isTopEdge()
  {
    return (!this.scrollY) || (this.amountY <= 0.0F);
  }

  public void layout()
  {
    Drawable localDrawable1 = this.style.background;
    Drawable localDrawable2 = this.style.hScrollKnob;
    Drawable localDrawable3 = this.style.vScrollKnob;
    float f4;
    float f3;
    float f2;
    float f1;
    if (localDrawable1 != null)
    {
      float f20 = localDrawable1.getLeftWidth();
      float f21 = localDrawable1.getRightWidth();
      float f22 = localDrawable1.getTopHeight();
      float f23 = localDrawable1.getBottomHeight();
      f4 = f20;
      f3 = f21;
      f2 = f22;
      f1 = f23;
    }
    while (true)
    {
      float f5 = getWidth();
      float f6 = getHeight();
      float f7 = 0.0F;
      if (localDrawable2 != null)
        f7 = localDrawable2.getMinHeight();
      float f8;
      if (this.style.hScroll != null)
        f8 = Math.max(f7, this.style.hScroll.getMinHeight());
      while (true)
      {
        float f9 = 0.0F;
        if (localDrawable3 != null)
          f9 = localDrawable3.getMinWidth();
        float f10;
        if (this.style.vScroll != null)
          f10 = Math.max(f9, this.style.vScroll.getMinWidth());
        while (true)
        {
          this.areaWidth = (f5 - f4 - f3);
          this.areaHeight = (f6 - f2 - f1);
          if (this.widget == null)
            return;
          float f11;
          float f12;
          label245: boolean bool1;
          label272: boolean bool2;
          label305: label488: float f13;
          label501: float f14;
          label514: float f17;
          label644: float f18;
          label655: float f19;
          label666: label724: float f15;
          label788: label823: float f16;
          if ((this.widget instanceof Layout))
          {
            Layout localLayout = (Layout)this.widget;
            f11 = localLayout.getPrefWidth();
            f12 = localLayout.getPrefHeight();
            if ((!this.forceScrollX) && ((f11 <= this.areaWidth) || (this.disableX)))
              break label1050;
            bool1 = true;
            this.scrollX = bool1;
            if ((!this.forceScrollY) && ((f12 <= this.areaHeight) || (this.disableY)))
              break label1056;
            bool2 = true;
            this.scrollY = bool2;
            boolean bool3 = this.fadeScrollBars;
            if (!bool3)
            {
              if (this.scrollY)
              {
                this.areaWidth -= f10;
                if ((!this.scrollX) && (f11 > this.areaWidth) && (!this.disableX))
                  this.scrollX = true;
              }
              if (this.scrollX)
              {
                this.areaHeight -= f8;
                if ((!this.scrollY) && (f12 > this.areaHeight) && (!this.disableY))
                {
                  this.scrollY = true;
                  this.areaWidth -= f10;
                }
              }
            }
            this.widgetAreaBounds.set(f4, f1, this.areaWidth, this.areaHeight);
            if (!bool3)
              break label1062;
            if ((this.scrollX) && (this.scrollY))
            {
              this.areaHeight -= f8;
              this.areaWidth -= f10;
            }
            if (!this.disableX)
              break label1193;
            f13 = this.areaWidth;
            if (!this.disableY)
              break label1207;
            f14 = this.areaHeight;
            this.maxX = (f13 - this.areaWidth);
            this.maxY = (f14 - this.areaHeight);
            if ((bool3) && (this.scrollX) && (this.scrollY))
            {
              this.maxY -= f8;
              this.maxX -= f10;
            }
            scrollX(MathUtils.clamp(this.amountX, 0.0F, this.maxX));
            scrollY(MathUtils.clamp(this.amountY, 0.0F, this.maxY));
            if (this.scrollX)
            {
              if (localDrawable2 == null)
                break label1271;
              if (this.style.hScroll == null)
                break label1221;
              f17 = this.style.hScroll.getMinHeight();
              if (!this.vScrollOnRight)
                break label1232;
              f18 = f4;
              if (!this.hScrollOnBottom)
                break label1242;
              f19 = f1;
              this.hScrollBounds.set(f18, f19, this.areaWidth, f17);
              if (!this.variableSizeKnobs)
                break label1255;
              this.hKnobBounds.width = Math.max(localDrawable2.getMinWidth(), (int)(this.hScrollBounds.width * this.areaWidth / f13));
              this.hKnobBounds.height = localDrawable2.getMinHeight();
              this.hKnobBounds.x = (this.hScrollBounds.x + (int)((this.hScrollBounds.width - this.hKnobBounds.width) * getScrollPercentX()));
              this.hKnobBounds.y = this.hScrollBounds.y;
            }
            if (this.scrollY)
            {
              if (localDrawable3 == null)
                break label1344;
              if (this.style.vScroll == null)
                break label1298;
              f15 = this.style.vScroll.getMinWidth();
              if (this.hScrollOnBottom)
                f1 = f6 - f2 - this.areaHeight;
              if (!this.vScrollOnRight)
                break label1309;
              f16 = f5 - f3 - f15;
              label859: this.vScrollBounds.set(f16, f1, f15, this.areaHeight);
              this.vKnobBounds.width = localDrawable3.getMinWidth();
              if (!this.variableSizeKnobs)
                break label1316;
              this.vKnobBounds.height = Math.max(localDrawable3.getMinHeight(), (int)(this.vScrollBounds.height * this.areaHeight / f14));
              label930: if (!this.vScrollOnRight)
                break label1332;
              this.vKnobBounds.x = (f5 - f3 - localDrawable3.getMinWidth());
              label956: this.vKnobBounds.y = (this.vScrollBounds.y + (int)((this.vScrollBounds.height - this.vKnobBounds.height) * (1.0F - getScrollPercentY())));
            }
          }
          while (true)
          {
            this.widget.setSize(f13, f14);
            if (!(this.widget instanceof Layout))
              break;
            ((Layout)this.widget).validate();
            return;
            f11 = this.widget.getWidth();
            f12 = this.widget.getHeight();
            break label245;
            label1050: bool1 = false;
            break label272;
            label1056: bool2 = false;
            break label305;
            label1062: if (this.scrollbarsOnTop)
            {
              if (this.scrollX)
              {
                Rectangle localRectangle4 = this.widgetAreaBounds;
                localRectangle4.height = (f8 + localRectangle4.height);
              }
              if (!this.scrollY)
                break label488;
              Rectangle localRectangle3 = this.widgetAreaBounds;
              localRectangle3.width = (f10 + localRectangle3.width);
              break label488;
            }
            if ((this.scrollX) && (this.hScrollOnBottom))
            {
              Rectangle localRectangle2 = this.widgetAreaBounds;
              localRectangle2.y = (f8 + localRectangle2.y);
            }
            if ((!this.scrollY) || (this.vScrollOnRight))
              break label488;
            Rectangle localRectangle1 = this.widgetAreaBounds;
            localRectangle1.x = (f10 + localRectangle1.x);
            break label488;
            label1193: f13 = Math.max(this.areaWidth, f11);
            break label501;
            label1207: f14 = Math.max(this.areaHeight, f12);
            break label514;
            label1221: f17 = localDrawable2.getMinHeight();
            break label644;
            label1232: f18 = f10 + f4;
            break label655;
            label1242: f19 = f6 - f2 - f17;
            break label666;
            label1255: this.hKnobBounds.width = localDrawable2.getMinWidth();
            break label724;
            label1271: this.hScrollBounds.set(0.0F, 0.0F, 0.0F, 0.0F);
            this.hKnobBounds.set(0.0F, 0.0F, 0.0F, 0.0F);
            break label788;
            label1298: f15 = localDrawable3.getMinWidth();
            break label823;
            label1309: f16 = f4;
            break label859;
            label1316: this.vKnobBounds.height = localDrawable3.getMinHeight();
            break label930;
            label1332: this.vKnobBounds.x = f4;
            break label956;
            label1344: this.vScrollBounds.set(0.0F, 0.0F, 0.0F, 0.0F);
            this.vKnobBounds.set(0.0F, 0.0F, 0.0F, 0.0F);
          }
          f10 = f9;
        }
        f8 = f7;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = 0.0F;
    }
  }

  public boolean removeActor(Actor paramActor)
  {
    if (paramActor != this.widget)
      return false;
    setWidget(null);
    return true;
  }

  void resetFade()
  {
    this.fadeAlpha = this.fadeAlphaSeconds;
    this.fadeDelay = this.fadeDelaySeconds;
  }

  public void scrollTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    scrollTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, false, false);
  }

  public void scrollTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f1 = this.amountX;
    float f2;
    if (paramBoolean1)
    {
      paramFloat1 = paramFloat1 - this.areaWidth / 2.0F + paramFloat3 / 2.0F;
      scrollX(MathUtils.clamp(paramFloat1, 0.0F, this.maxX));
      f2 = this.amountY;
      if (!paramBoolean2)
        break label120;
      f2 = this.maxY - paramFloat2 + this.areaHeight / 2.0F - paramFloat4 / 2.0F;
    }
    while (true)
    {
      scrollY(MathUtils.clamp(f2, 0.0F, this.maxY));
      return;
      if (paramFloat1 + paramFloat3 > f1 + this.areaWidth)
        f1 = paramFloat1 + paramFloat3 - this.areaWidth;
      if (paramFloat1 < f1)
        break;
      paramFloat1 = f1;
      break;
      label120: if (f2 > this.maxY - paramFloat2 - paramFloat4 + this.areaHeight)
        f2 = this.maxY - paramFloat2 - paramFloat4 + this.areaHeight;
      if (f2 >= this.maxY - paramFloat2)
        continue;
      f2 = this.maxY - paramFloat2;
    }
  }

  protected void scrollX(float paramFloat)
  {
    this.amountX = paramFloat;
  }

  protected void scrollY(float paramFloat)
  {
    this.amountY = paramFloat;
  }

  public void setCancelTouchFocus(boolean paramBoolean)
  {
    this.cancelTouchFocus = paramBoolean;
  }

  public void setClamp(boolean paramBoolean)
  {
    this.clamp = paramBoolean;
  }

  public void setFadeScrollBars(boolean paramBoolean)
  {
    if (this.fadeScrollBars == paramBoolean)
      return;
    this.fadeScrollBars = paramBoolean;
    if (!paramBoolean)
      this.fadeAlpha = this.fadeAlphaSeconds;
    invalidate();
  }

  public void setFlickScroll(boolean paramBoolean)
  {
    if (this.flickScroll == paramBoolean)
      return;
    this.flickScroll = paramBoolean;
    if (paramBoolean)
      addListener(this.flickScrollListener);
    while (true)
    {
      invalidate();
      return;
      removeListener(this.flickScrollListener);
    }
  }

  public void setFlickScrollTapSquareSize(float paramFloat)
  {
    this.flickScrollListener.getGestureDetector().setTapSquareSize(paramFloat);
  }

  public void setFlingTime(float paramFloat)
  {
    this.flingTime = paramFloat;
  }

  public void setForceScroll(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.forceScrollX = paramBoolean1;
    this.forceScrollY = paramBoolean2;
  }

  public void setOverscroll(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.overscrollX = paramBoolean1;
    this.overscrollY = paramBoolean2;
  }

  public void setScrollBarPositions(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.hScrollOnBottom = paramBoolean1;
    this.vScrollOnRight = paramBoolean2;
  }

  public void setScrollPercentX(float paramFloat)
  {
    scrollX(this.maxX * MathUtils.clamp(paramFloat, 0.0F, 1.0F));
  }

  public void setScrollPercentY(float paramFloat)
  {
    scrollY(this.maxY * MathUtils.clamp(paramFloat, 0.0F, 1.0F));
  }

  public void setScrollX(float paramFloat)
  {
    scrollX(MathUtils.clamp(paramFloat, 0.0F, this.maxX));
  }

  public void setScrollY(float paramFloat)
  {
    scrollY(MathUtils.clamp(paramFloat, 0.0F, this.maxY));
  }

  public void setScrollbarsOnTop(boolean paramBoolean)
  {
    this.scrollbarsOnTop = paramBoolean;
    invalidate();
  }

  public void setScrollingDisabled(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.disableX = paramBoolean1;
    this.disableY = paramBoolean2;
  }

  public void setSmoothScrolling(boolean paramBoolean)
  {
    this.smoothScrolling = paramBoolean;
  }

  public void setStyle(ScrollPane.ScrollPaneStyle paramScrollPaneStyle)
  {
    if (paramScrollPaneStyle == null)
      throw new IllegalArgumentException("style cannot be null.");
    this.style = paramScrollPaneStyle;
    invalidateHierarchy();
  }

  public void setVariableSizeKnobs(boolean paramBoolean)
  {
    this.variableSizeKnobs = paramBoolean;
  }

  public void setVelocityX(float paramFloat)
  {
    this.velocityX = paramFloat;
  }

  public void setVelocityY(float paramFloat)
  {
    this.velocityY = paramFloat;
  }

  public void setWidget(Actor paramActor)
  {
    if (paramActor == this)
      throw new IllegalArgumentException("widget cannot be the ScrollPane.");
    if (this.widget != null)
      super.removeActor(this.widget);
    this.widget = paramActor;
    if (paramActor != null)
      super.addActor(paramActor);
  }

  public void setupFadeScrollBars(float paramFloat1, float paramFloat2)
  {
    this.fadeAlphaSeconds = paramFloat1;
    this.fadeDelaySeconds = paramFloat2;
  }

  public void setupOverscroll(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.overscrollDistance = paramFloat1;
    this.overscrollSpeedMin = paramFloat2;
    this.overscrollSpeedMax = paramFloat3;
  }

  public void updateVisualScroll()
  {
    this.visualAmountX = this.amountX;
    this.visualAmountY = this.amountY;
  }

  protected void visualScrollX(float paramFloat)
  {
    this.visualAmountX = paramFloat;
  }

  protected void visualScrollY(float paramFloat)
  {
    this.visualAmountY = paramFloat;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
 * JD-Core Version:    0.6.0
 */