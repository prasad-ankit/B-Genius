package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;

public class Stack extends WidgetGroup
{
  private float maxHeight;
  private float maxWidth;
  private float minHeight;
  private float minWidth;
  private float prefHeight;
  private float prefWidth;
  private boolean sizeInvalid = true;

  public Stack()
  {
    setTransform(false);
    setWidth(150.0F);
    setHeight(150.0F);
    setTouchable(Touchable.childrenOnly);
  }

  private void computeSize()
  {
    this.sizeInvalid = false;
    this.prefWidth = 0.0F;
    this.prefHeight = 0.0F;
    this.minWidth = 0.0F;
    this.minHeight = 0.0F;
    this.maxWidth = 0.0F;
    this.maxHeight = 0.0F;
    SnapshotArray localSnapshotArray = getChildren();
    int i = localSnapshotArray.size;
    int j = 0;
    if (j < i)
    {
      Actor localActor = (Actor)localSnapshotArray.get(j);
      float f2;
      float f1;
      label171: label187: float f3;
      if ((localActor instanceof Layout))
      {
        Layout localLayout = (Layout)localActor;
        this.prefWidth = Math.max(this.prefWidth, localLayout.getPrefWidth());
        this.prefHeight = Math.max(this.prefHeight, localLayout.getPrefHeight());
        this.minWidth = Math.max(this.minWidth, localLayout.getMinWidth());
        this.minHeight = Math.max(this.minHeight, localLayout.getMinHeight());
        float f4 = localLayout.getMaxWidth();
        f2 = localLayout.getMaxHeight();
        f1 = f4;
        if (f1 > 0.0F)
        {
          if (this.maxWidth != 0.0F)
            break label298;
          this.maxWidth = f1;
        }
        if (f2 > 0.0F)
        {
          if (this.maxHeight != 0.0F)
            break label312;
          f3 = f2;
        }
      }
      while (true)
      {
        this.maxHeight = f3;
        j++;
        break;
        this.prefWidth = Math.max(this.prefWidth, localActor.getWidth());
        this.prefHeight = Math.max(this.prefHeight, localActor.getHeight());
        this.minWidth = Math.max(this.minWidth, localActor.getWidth());
        this.minHeight = Math.max(this.minHeight, localActor.getHeight());
        f1 = 0.0F;
        f2 = 0.0F;
        break label171;
        label298: f1 = Math.min(this.maxWidth, f1);
        break label187;
        label312: f3 = Math.min(this.maxHeight, f2);
      }
    }
  }

  public void add(Actor paramActor)
  {
    addActor(paramActor);
  }

  public float getMaxHeight()
  {
    if (this.sizeInvalid)
      computeSize();
    return this.maxHeight;
  }

  public float getMaxWidth()
  {
    if (this.sizeInvalid)
      computeSize();
    return this.maxWidth;
  }

  public float getMinHeight()
  {
    if (this.sizeInvalid)
      computeSize();
    return this.minHeight;
  }

  public float getMinWidth()
  {
    if (this.sizeInvalid)
      computeSize();
    return this.minWidth;
  }

  public float getPrefHeight()
  {
    if (this.sizeInvalid)
      computeSize();
    return this.prefHeight;
  }

  public float getPrefWidth()
  {
    if (this.sizeInvalid)
      computeSize();
    return this.prefWidth;
  }

  public void invalidate()
  {
    super.invalidate();
    this.sizeInvalid = true;
  }

  public void layout()
  {
    if (this.sizeInvalid)
      computeSize();
    float f1 = getWidth();
    float f2 = getHeight();
    SnapshotArray localSnapshotArray = getChildren();
    int i = localSnapshotArray.size;
    for (int j = 0; j < i; j++)
    {
      Actor localActor = (Actor)localSnapshotArray.get(j);
      localActor.setBounds(0.0F, 0.0F, f1, f2);
      if (!(localActor instanceof Layout))
        continue;
      ((Layout)localActor).validate();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Stack
 * JD-Core Version:    0.6.0
 */