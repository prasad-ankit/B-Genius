package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

public class Widget extends Actor
  implements Layout
{
  private boolean fillParent;
  private boolean layoutEnabled = true;
  private boolean needsLayout = true;

  public void draw(Batch paramBatch, float paramFloat)
  {
    validate();
  }

  public float getMaxHeight()
  {
    return 0.0F;
  }

  public float getMaxWidth()
  {
    return 0.0F;
  }

  public float getMinHeight()
  {
    return getPrefHeight();
  }

  public float getMinWidth()
  {
    return getPrefWidth();
  }

  public float getPrefHeight()
  {
    return 0.0F;
  }

  public float getPrefWidth()
  {
    return 0.0F;
  }

  public void invalidate()
  {
    this.needsLayout = true;
  }

  public void invalidateHierarchy()
  {
    if (!this.layoutEnabled);
    Group localGroup;
    do
    {
      return;
      invalidate();
      localGroup = getParent();
    }
    while (!(localGroup instanceof Layout));
    ((Layout)localGroup).invalidateHierarchy();
  }

  public void layout()
  {
  }

  public boolean needsLayout()
  {
    return this.needsLayout;
  }

  public void pack()
  {
    setSize(getPrefWidth(), getPrefHeight());
    validate();
  }

  public void setFillParent(boolean paramBoolean)
  {
    this.fillParent = paramBoolean;
  }

  public void setLayoutEnabled(boolean paramBoolean)
  {
    this.layoutEnabled = paramBoolean;
    if (paramBoolean)
      invalidateHierarchy();
  }

  protected void sizeChanged()
  {
    invalidate();
  }

  public void validate()
  {
    if (!this.layoutEnabled)
      return;
    Group localGroup = getParent();
    float f1;
    float f2;
    if ((this.fillParent) && (localGroup != null))
    {
      Stage localStage = getStage();
      if ((localStage == null) || (localGroup != localStage.getRoot()))
        break label76;
      f1 = localStage.getWidth();
      f2 = localStage.getHeight();
    }
    while (true)
    {
      setSize(f1, f2);
      if (!this.needsLayout)
        break;
      this.needsLayout = false;
      layout();
      return;
      label76: f1 = localGroup.getWidth();
      f2 = localGroup.getHeight();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Widget
 * JD-Core Version:    0.6.0
 */