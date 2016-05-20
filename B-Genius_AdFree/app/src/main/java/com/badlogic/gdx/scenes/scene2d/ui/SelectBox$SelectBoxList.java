package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;

class SelectBox$SelectBoxList extends ScrollPane
{
  private InputListener hideListener;
  final List list;
  int maxListCount;
  private Actor previousScrollFocus;
  private final Vector2 screenPosition = new Vector2();
  private final SelectBox selectBox;

  public SelectBox$SelectBoxList(SelectBox paramSelectBox)
  {
    super(null, paramSelectBox.style.scrollStyle);
    this.selectBox = paramSelectBox;
    setOverscroll(false, false);
    setFadeScrollBars(false);
    setScrollingDisabled(true, false);
    this.list = new SelectBox.SelectBoxList.1(this, paramSelectBox.style.listStyle, paramSelectBox);
    this.list.setTouchable(Touchable.disabled);
    setWidget(this.list);
    this.list.addListener(new SelectBox.SelectBoxList.2(this, paramSelectBox));
    addListener(new SelectBox.SelectBoxList.3(this, paramSelectBox));
    this.hideListener = new SelectBox.SelectBoxList.4(this, paramSelectBox);
  }

  public void act(float paramFloat)
  {
    super.act(paramFloat);
    toFront();
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    this.selectBox.localToStageCoordinates(SelectBox.temp.set(0.0F, 0.0F));
    if (!SelectBox.temp.equals(this.screenPosition))
      hide();
    super.draw(paramBatch, paramFloat);
  }

  public void hide()
  {
    if ((!this.list.isTouchable()) || (!hasParent()))
      return;
    this.list.setTouchable(Touchable.disabled);
    Stage localStage = getStage();
    if (localStage != null)
    {
      localStage.removeCaptureListener(this.hideListener);
      if ((this.previousScrollFocus != null) && (this.previousScrollFocus.getStage() == null))
        this.previousScrollFocus = null;
      Actor localActor = localStage.getScrollFocus();
      if ((localActor == null) || (isAscendantOf(localActor)))
        localStage.setScrollFocus(this.previousScrollFocus);
    }
    clearActions();
    this.selectBox.onHide(this);
  }

  public void show(Stage paramStage)
  {
    if (this.list.isTouchable())
      return;
    paramStage.removeCaptureListener(this.hideListener);
    paramStage.addCaptureListener(this.hideListener);
    paramStage.addActor(this);
    this.selectBox.localToStageCoordinates(this.screenPosition.set(0.0F, 0.0F));
    float f1 = this.list.getItemHeight();
    int i;
    float f2;
    Drawable localDrawable1;
    float f3;
    boolean bool;
    if (this.maxListCount <= 0)
    {
      i = this.selectBox.items.size;
      f2 = f1 * i;
      localDrawable1 = getStyle().background;
      if (localDrawable1 != null)
        f2 += localDrawable1.getTopHeight() + localDrawable1.getBottomHeight();
      Drawable localDrawable2 = this.list.getStyle().background;
      if (localDrawable2 != null)
        f2 += localDrawable2.getTopHeight() + localDrawable2.getBottomHeight();
      f3 = this.screenPosition.y;
      float f4 = paramStage.getCamera().viewportHeight - this.screenPosition.y - this.selectBox.getHeight();
      if (f2 <= f3)
        break label503;
      if (f4 <= f3)
        break label475;
      float f6 = Math.min(f2, f4);
      bool = false;
      f3 = f6;
    }
    while (true)
    {
      label224: if (bool)
        setY(this.screenPosition.y - f3);
      while (true)
      {
        setX(this.screenPosition.x);
        setHeight(f3);
        validate();
        float f5 = Math.max(getPrefWidth(), this.selectBox.getWidth());
        if (getPrefHeight() > f3)
          f5 += getScrollBarWidth();
        if (localDrawable1 != null)
          f5 += Math.max(0.0F, localDrawable1.getRightWidth() - localDrawable1.getLeftWidth());
        setWidth(f5);
        validate();
        scrollTo(0.0F, this.list.getHeight() - f1 * this.selectBox.getSelectedIndex() - f1 / 2.0F, 0.0F, 0.0F, true, true);
        updateVisualScroll();
        this.previousScrollFocus = null;
        Actor localActor = paramStage.getScrollFocus();
        if ((localActor != null) && (!localActor.isDescendantOf(this)))
          this.previousScrollFocus = localActor;
        paramStage.setScrollFocus(this);
        this.list.selection.set(this.selectBox.getSelected());
        this.list.setTouchable(Touchable.enabled);
        clearActions();
        this.selectBox.onShow(this, bool);
        return;
        i = Math.min(this.maxListCount, this.selectBox.items.size);
        break;
        label475: bool = true;
        break label224;
        setY(this.screenPosition.y + this.selectBox.getHeight());
      }
      label503: bool = true;
      f3 = f2;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxList
 * JD-Core Version:    0.6.0
 */