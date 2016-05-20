package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class SplitPane extends WidgetGroup
{
  private Rectangle firstScissors = new Rectangle();
  private Actor firstWidget;
  private Rectangle firstWidgetBounds = new Rectangle();
  Rectangle handleBounds = new Rectangle();
  Vector2 handlePosition = new Vector2();
  Vector2 lastPoint = new Vector2();
  float maxAmount = 1.0F;
  float minAmount;
  private float oldSplitAmount;
  private Rectangle secondScissors = new Rectangle();
  private Actor secondWidget;
  private Rectangle secondWidgetBounds = new Rectangle();
  float splitAmount = 0.5F;
  SplitPane.SplitPaneStyle style;
  boolean vertical;

  public SplitPane(Actor paramActor1, Actor paramActor2, boolean paramBoolean, Skin paramSkin)
  {
  }

  public SplitPane(Actor paramActor1, Actor paramActor2, boolean paramBoolean, Skin paramSkin, String paramString)
  {
    this(paramActor1, paramActor2, paramBoolean, (SplitPane.SplitPaneStyle)paramSkin.get(paramString, SplitPane.SplitPaneStyle.class));
  }

  public SplitPane(Actor paramActor1, Actor paramActor2, boolean paramBoolean, SplitPane.SplitPaneStyle paramSplitPaneStyle)
  {
    this.firstWidget = paramActor1;
    this.secondWidget = paramActor2;
    this.vertical = paramBoolean;
    setStyle(paramSplitPaneStyle);
    setFirstWidget(paramActor1);
    setSecondWidget(paramActor2);
    setSize(getPrefWidth(), getPrefHeight());
    initialize();
  }

  private void calculateHorizBoundsAndPositions()
  {
    Drawable localDrawable = this.style.handle;
    float f1 = getHeight();
    float f2 = getWidth() - localDrawable.getMinWidth();
    float f3 = (int)(f2 * this.splitAmount);
    float f4 = f2 - f3;
    float f5 = localDrawable.getMinWidth();
    this.firstWidgetBounds.set(0.0F, 0.0F, f3, f1);
    this.secondWidgetBounds.set(f3 + f5, 0.0F, f4, f1);
    this.handleBounds.set(f3, 0.0F, f5, f1);
  }

  private void calculateVertBoundsAndPositions()
  {
    Drawable localDrawable = this.style.handle;
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = f2 - localDrawable.getMinHeight();
    float f4 = (int)(f3 * this.splitAmount);
    float f5 = f3 - f4;
    float f6 = localDrawable.getMinHeight();
    this.firstWidgetBounds.set(0.0F, f2 - f4, f1, f4);
    this.secondWidgetBounds.set(0.0F, 0.0F, f1, f5);
    this.handleBounds.set(0.0F, f5, f1, f6);
  }

  private void initialize()
  {
    addListener(new SplitPane.1(this));
  }

  public void addActor(Actor paramActor)
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

  public void draw(Batch paramBatch, float paramFloat)
  {
    validate();
    Color localColor = getColor();
    Drawable localDrawable = this.style.handle;
    applyTransform(paramBatch, computeTransform());
    paramBatch.getTransformMatrix();
    if (this.firstWidget != null)
    {
      getStage().calculateScissors(this.firstWidgetBounds, this.firstScissors);
      if (ScissorStack.pushScissors(this.firstScissors))
      {
        if (this.firstWidget.isVisible())
          this.firstWidget.draw(paramBatch, paramFloat * localColor.a);
        paramBatch.flush();
        ScissorStack.popScissors();
      }
    }
    if (this.secondWidget != null)
    {
      getStage().calculateScissors(this.secondWidgetBounds, this.secondScissors);
      if (ScissorStack.pushScissors(this.secondScissors))
      {
        if (this.secondWidget.isVisible())
          this.secondWidget.draw(paramBatch, paramFloat * localColor.a);
        paramBatch.flush();
        ScissorStack.popScissors();
      }
    }
    paramBatch.setColor(localColor.r, localColor.g, localColor.b, paramFloat * localColor.a);
    localDrawable.draw(paramBatch, this.handleBounds.x, this.handleBounds.y, this.handleBounds.width, this.handleBounds.height);
    resetTransform(paramBatch);
  }

  public float getMinHeight()
  {
    return 0.0F;
  }

  public float getMinWidth()
  {
    return 0.0F;
  }

  public float getPrefHeight()
  {
    float f1;
    float f2;
    if (this.firstWidget == null)
    {
      f1 = 0.0F;
      Actor localActor = this.secondWidget;
      f2 = 0.0F;
      if (localActor != null)
        break label70;
    }
    while (true)
    {
      if (this.vertical)
        break label107;
      return Math.max(f1, f2);
      if ((this.firstWidget instanceof Layout))
      {
        f1 = ((Layout)this.firstWidget).getPrefHeight();
        break;
      }
      f1 = this.firstWidget.getHeight();
      break;
      label70: if ((this.secondWidget instanceof Layout))
      {
        f2 = ((Layout)this.secondWidget).getPrefHeight();
        continue;
      }
      f2 = this.secondWidget.getHeight();
    }
    label107: return f2 + (f1 + this.style.handle.getMinHeight());
  }

  public float getPrefWidth()
  {
    float f1;
    float f2;
    if (this.firstWidget == null)
    {
      f1 = 0.0F;
      Actor localActor = this.secondWidget;
      f2 = 0.0F;
      if (localActor != null)
        break label70;
    }
    while (true)
    {
      if (!this.vertical)
        break label107;
      return Math.max(f1, f2);
      if ((this.firstWidget instanceof Layout))
      {
        f1 = ((Layout)this.firstWidget).getPrefWidth();
        break;
      }
      f1 = this.firstWidget.getWidth();
      break;
      label70: if ((this.secondWidget instanceof Layout))
      {
        f2 = ((Layout)this.secondWidget).getPrefWidth();
        continue;
      }
      f2 = this.secondWidget.getWidth();
    }
    label107: return f2 + (f1 + this.style.handle.getMinWidth());
  }

  public float getSplit()
  {
    return this.splitAmount;
  }

  public SplitPane.SplitPaneStyle getStyle()
  {
    return this.style;
  }

  public void layout()
  {
    if (!this.vertical)
      calculateHorizBoundsAndPositions();
    while (true)
    {
      Actor localActor1 = this.firstWidget;
      if (localActor1 != null)
      {
        Rectangle localRectangle2 = this.firstWidgetBounds;
        localActor1.setBounds(localRectangle2.x, localRectangle2.y, localRectangle2.width, localRectangle2.height);
        if ((localActor1 instanceof Layout))
          ((Layout)localActor1).validate();
      }
      Actor localActor2 = this.secondWidget;
      if (localActor2 != null)
      {
        Rectangle localRectangle1 = this.secondWidgetBounds;
        localActor2.setBounds(localRectangle1.x, localRectangle1.y, localRectangle1.width, localRectangle1.height);
        if ((localActor2 instanceof Layout))
          ((Layout)localActor2).validate();
      }
      return;
      calculateVertBoundsAndPositions();
    }
  }

  public boolean removeActor(Actor paramActor)
  {
    throw new UnsupportedOperationException("Use ScrollPane#setWidget(null).");
  }

  public void setFirstWidget(Actor paramActor)
  {
    if (this.firstWidget != null)
      super.removeActor(this.firstWidget);
    this.firstWidget = paramActor;
    if (paramActor != null)
      super.addActor(paramActor);
    invalidate();
  }

  public void setMaxSplitAmount(float paramFloat)
  {
    if (paramFloat > 1.0F)
      throw new GdxRuntimeException("maxAmount has to be <= 1");
    if (paramFloat <= this.minAmount)
      throw new GdxRuntimeException("maxAmount has to be > minAmount");
    this.maxAmount = paramFloat;
  }

  public void setMinSplitAmount(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new GdxRuntimeException("minAmount has to be >= 0");
    if (paramFloat >= this.maxAmount)
      throw new GdxRuntimeException("minAmount has to be < maxAmount");
    this.minAmount = paramFloat;
  }

  public void setSecondWidget(Actor paramActor)
  {
    if (this.secondWidget != null)
      super.removeActor(this.secondWidget);
    this.secondWidget = paramActor;
    if (paramActor != null)
      super.addActor(paramActor);
    invalidate();
  }

  public void setSplitAmount(float paramFloat)
  {
    this.splitAmount = Math.max(Math.min(this.maxAmount, paramFloat), this.minAmount);
    invalidate();
  }

  public void setStyle(SplitPane.SplitPaneStyle paramSplitPaneStyle)
  {
    this.style = paramSplitPaneStyle;
    invalidateHierarchy();
  }

  public void setVertical(boolean paramBoolean)
  {
    this.vertical = paramBoolean;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.SplitPane
 * JD-Core Version:    0.6.0
 */