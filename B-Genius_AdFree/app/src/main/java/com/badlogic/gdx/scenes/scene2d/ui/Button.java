package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.SnapshotArray;

public class Button extends Table
  implements Disableable
{
  ButtonGroup buttonGroup;
  private ClickListener clickListener;
  boolean isChecked;
  boolean isDisabled;
  private boolean programmaticChangeEvents = true;
  private Button.ButtonStyle style;

  public Button()
  {
    initialize();
  }

  public Button(Actor paramActor, Button.ButtonStyle paramButtonStyle)
  {
    initialize();
    add(paramActor);
    setStyle(paramButtonStyle);
    setSize(getPrefWidth(), getPrefHeight());
  }

  public Button(Actor paramActor, Skin paramSkin)
  {
    this(paramActor, (Button.ButtonStyle)paramSkin.get(Button.ButtonStyle.class));
  }

  public Button(Actor paramActor, Skin paramSkin, String paramString)
  {
    this(paramActor, (Button.ButtonStyle)paramSkin.get(paramString, Button.ButtonStyle.class));
  }

  public Button(Button.ButtonStyle paramButtonStyle)
  {
    initialize();
    setStyle(paramButtonStyle);
    setSize(getPrefWidth(), getPrefHeight());
  }

  public Button(Skin paramSkin)
  {
    super(paramSkin);
    initialize();
    setStyle((Button.ButtonStyle)paramSkin.get(Button.ButtonStyle.class));
    setSize(getPrefWidth(), getPrefHeight());
  }

  public Button(Skin paramSkin, String paramString)
  {
    super(paramSkin);
    initialize();
    setStyle((Button.ButtonStyle)paramSkin.get(paramString, Button.ButtonStyle.class));
    setSize(getPrefWidth(), getPrefHeight());
  }

  public Button(Drawable paramDrawable)
  {
    this(new Button.ButtonStyle(paramDrawable, null, null));
  }

  public Button(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(new Button.ButtonStyle(paramDrawable1, paramDrawable2, null));
  }

  public Button(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    this(new Button.ButtonStyle(paramDrawable1, paramDrawable2, paramDrawable3));
  }

  private void initialize()
  {
    setTouchable(Touchable.enabled);
    Button.1 local1 = new Button.1(this);
    this.clickListener = local1;
    addListener(local1);
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    int i = 0;
    validate();
    boolean bool1 = isPressed();
    boolean bool2 = isDisabled();
    Drawable localDrawable2;
    float f3;
    float f4;
    if ((bool2) && (this.style.disabled != null))
    {
      localDrawable2 = this.style.disabled;
      setBackground(localDrawable2);
      if ((!bool1) || (bool2))
        break label269;
      float f5 = this.style.pressedOffsetX;
      float f6 = this.style.pressedOffsetY;
      f3 = f5;
      f4 = f6;
    }
    SnapshotArray localSnapshotArray;
    while (true)
    {
      localSnapshotArray = getChildren();
      for (int j = 0; j < localSnapshotArray.size; j++)
        ((Actor)localSnapshotArray.get(j)).moveBy(f3, f4);
      if ((bool1) && (this.style.down != null))
      {
        localDrawable2 = this.style.down;
        break;
      }
      if ((this.isChecked) && (this.style.checked != null))
      {
        if ((this.style.checkedOver != null) && (isOver()))
        {
          localDrawable2 = this.style.checkedOver;
          break;
        }
        localDrawable2 = this.style.checked;
        break;
      }
      if ((isOver()) && (this.style.over != null))
      {
        localDrawable2 = this.style.over;
        break;
      }
      Drawable localDrawable1 = this.style.up;
      localDrawable2 = null;
      if (localDrawable1 == null)
        break;
      localDrawable2 = this.style.up;
      break;
      label269: float f1 = this.style.unpressedOffsetX;
      float f2 = this.style.unpressedOffsetY;
      f3 = f1;
      f4 = f2;
    }
    super.draw(paramBatch, paramFloat);
    while (i < localSnapshotArray.size)
    {
      ((Actor)localSnapshotArray.get(i)).moveBy(-f3, -f4);
      i++;
    }
    Stage localStage = getStage();
    if ((localStage != null) && (localStage.getActionsRequestRendering()) && (bool1 != this.clickListener.isPressed()))
      Gdx.graphics.requestRendering();
  }

  public ButtonGroup getButtonGroup()
  {
    return this.buttonGroup;
  }

  public ClickListener getClickListener()
  {
    return this.clickListener;
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
    float f = super.getPrefHeight();
    if (this.style.up != null)
      f = Math.max(f, this.style.up.getMinHeight());
    if (this.style.down != null)
      f = Math.max(f, this.style.down.getMinHeight());
    if (this.style.checked != null)
      f = Math.max(f, this.style.checked.getMinHeight());
    return f;
  }

  public float getPrefWidth()
  {
    float f = super.getPrefWidth();
    if (this.style.up != null)
      f = Math.max(f, this.style.up.getMinWidth());
    if (this.style.down != null)
      f = Math.max(f, this.style.down.getMinWidth());
    if (this.style.checked != null)
      f = Math.max(f, this.style.checked.getMinWidth());
    return f;
  }

  public Button.ButtonStyle getStyle()
  {
    return this.style;
  }

  public boolean isChecked()
  {
    return this.isChecked;
  }

  public boolean isDisabled()
  {
    return this.isDisabled;
  }

  public boolean isOver()
  {
    return this.clickListener.isOver();
  }

  public boolean isPressed()
  {
    return this.clickListener.isVisualPressed();
  }

  public void setChecked(boolean paramBoolean)
  {
    setChecked(paramBoolean, this.programmaticChangeEvents);
  }

  void setChecked(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.isChecked == paramBoolean1);
    do
    {
      do
        return;
      while ((this.buttonGroup != null) && (!this.buttonGroup.canCheck(this, paramBoolean1)));
      this.isChecked = paramBoolean1;
    }
    while (!paramBoolean2);
    ChangeListener.ChangeEvent localChangeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
    if (fire(localChangeEvent))
      if (paramBoolean1)
        break label72;
    label72: for (boolean bool = true; ; bool = false)
    {
      this.isChecked = bool;
      Pools.free(localChangeEvent);
      return;
    }
  }

  public void setDisabled(boolean paramBoolean)
  {
    this.isDisabled = paramBoolean;
  }

  public void setProgrammaticChangeEvents(boolean paramBoolean)
  {
    this.programmaticChangeEvents = paramBoolean;
  }

  public void setStyle(Button.ButtonStyle paramButtonStyle)
  {
    if (paramButtonStyle == null)
      throw new IllegalArgumentException("style cannot be null.");
    this.style = paramButtonStyle;
    Drawable localDrawable;
    if ((isPressed()) && (!isDisabled()))
      if (paramButtonStyle.down == null)
        localDrawable = paramButtonStyle.up;
    while (true)
    {
      setBackground(localDrawable);
      return;
      localDrawable = paramButtonStyle.down;
      continue;
      if ((isDisabled()) && (paramButtonStyle.disabled != null))
      {
        localDrawable = paramButtonStyle.disabled;
        continue;
      }
      if ((this.isChecked) && (paramButtonStyle.checked != null))
      {
        if ((isOver()) && (paramButtonStyle.checkedOver != null))
        {
          localDrawable = paramButtonStyle.checkedOver;
          continue;
        }
        localDrawable = paramButtonStyle.checked;
        continue;
      }
      if ((isOver()) && (paramButtonStyle.over != null))
      {
        localDrawable = paramButtonStyle.over;
        continue;
      }
      localDrawable = paramButtonStyle.up;
    }
  }

  public void toggle()
  {
    if (!this.isChecked);
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Button
 * JD-Core Version:    0.6.0
 */