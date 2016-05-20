package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.SnapshotArray;

public class WidgetGroup extends Group
  implements Layout
{
  private boolean fillParent;
  private boolean layoutEnabled = true;
  private boolean needsLayout = true;

  public WidgetGroup()
  {
  }

  public WidgetGroup(Actor[] paramArrayOfActor)
  {
    int i = paramArrayOfActor.length;
    for (int j = 0; j < i; j++)
      addActor(paramArrayOfActor[j]);
  }

  private void setLayoutEnabled(Group paramGroup, boolean paramBoolean)
  {
    SnapshotArray localSnapshotArray = paramGroup.getChildren();
    int i = localSnapshotArray.size;
    int j = 0;
    if (j < i)
    {
      Actor localActor = (Actor)localSnapshotArray.get(j);
      if ((localActor instanceof Layout))
        ((Layout)localActor).setLayoutEnabled(paramBoolean);
      while (true)
      {
        j++;
        break;
        if (!(localActor instanceof Group))
          continue;
        setLayoutEnabled((Group)localActor, paramBoolean);
      }
    }
  }

  protected void childrenChanged()
  {
    invalidateHierarchy();
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    validate();
    super.draw(paramBatch, paramFloat);
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
    invalidate();
    Group localGroup = getParent();
    if ((localGroup instanceof Layout))
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
    if (this.needsLayout)
    {
      setSize(getPrefWidth(), getPrefHeight());
      validate();
    }
  }

  public void setFillParent(boolean paramBoolean)
  {
    this.fillParent = paramBoolean;
  }

  public void setLayoutEnabled(boolean paramBoolean)
  {
    if (this.layoutEnabled == paramBoolean)
      return;
    this.layoutEnabled = paramBoolean;
    setLayoutEnabled(this, paramBoolean);
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
        break label103;
      f1 = localStage.getWidth();
      f2 = localStage.getHeight();
    }
    while (true)
    {
      if ((getWidth() != f1) || (getHeight() != f2))
      {
        setWidth(f1);
        setHeight(f2);
        invalidate();
      }
      if (!this.needsLayout)
        break;
      this.needsLayout = false;
      layout();
      return;
      label103: f1 = localGroup.getWidth();
      f2 = localGroup.getHeight();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
 * JD-Core Version:    0.6.0
 */