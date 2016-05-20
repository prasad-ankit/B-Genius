package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class Tooltip extends InputListener
{
  static Vector2 tmp = new Vector2();
  boolean always;
  final Container container;
  boolean instant;
  private final TooltipManager manager;
  Actor targetActor;

  public Tooltip(Actor paramActor)
  {
    this(paramActor, TooltipManager.getInstance());
  }

  public Tooltip(Actor paramActor, TooltipManager paramTooltipManager)
  {
    this.manager = paramTooltipManager;
    this.container = new Tooltip.1(this, paramActor);
    this.container.setTouchable(Touchable.disabled);
    this.container.pack();
  }

  private void setContainerPosition(Actor paramActor, float paramFloat1, float paramFloat2)
  {
    this.targetActor = paramActor;
    Stage localStage = paramActor.getStage();
    if (localStage == null)
      return;
    float f1 = this.manager.offsetX;
    float f2 = this.manager.offsetY;
    float f3 = this.manager.edgeDistance;
    Vector2 localVector21 = paramActor.localToStageCoordinates(tmp.set(paramFloat1 + f1, paramFloat2 - f2 - this.container.getHeight()));
    if (localVector21.y < f3)
      localVector21 = paramActor.localToStageCoordinates(tmp.set(f1 + paramFloat1, f2 + paramFloat2));
    if (localVector21.x < f3)
      localVector21.x = f3;
    if (localVector21.x + this.container.getWidth() > localStage.getWidth() - f3)
      localVector21.x = (localStage.getWidth() - f3 - this.container.getWidth());
    if (localVector21.y + this.container.getHeight() > localStage.getHeight() - f3)
      localVector21.y = (localStage.getHeight() - f3 - this.container.getHeight());
    this.container.setPosition(localVector21.x, localVector21.y);
    Vector2 localVector22 = paramActor.localToStageCoordinates(tmp.set(paramActor.getWidth() / 2.0F, paramActor.getHeight() / 2.0F));
    localVector22.sub(this.container.getX(), this.container.getY());
    this.container.setOrigin(localVector22.x, localVector22.y);
  }

  public void enter(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, Actor paramActor)
  {
    if (paramInt != -1);
    Actor localActor;
    do
    {
      do
        return;
      while (Gdx.input.isTouched());
      localActor = paramInputEvent.getListenerActor();
    }
    while ((paramActor != null) && (paramActor.isDescendantOf(localActor)));
    setContainerPosition(localActor, paramFloat1, paramFloat2);
    this.manager.enter(this);
  }

  public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, Actor paramActor)
  {
    if ((paramActor != null) && (paramActor.isDescendantOf(paramInputEvent.getListenerActor())))
      return;
    hide();
  }

  public Actor getActor()
  {
    return this.container.getActor();
  }

  public Container getContainer()
  {
    return this.container;
  }

  public TooltipManager getManager()
  {
    return this.manager;
  }

  public void hide()
  {
    this.manager.hide(this);
  }

  public boolean mouseMoved(InputEvent paramInputEvent, float paramFloat1, float paramFloat2)
  {
    if (this.container.hasParent())
      return false;
    setContainerPosition(paramInputEvent.getListenerActor(), paramFloat1, paramFloat2);
    return true;
  }

  public void setActor(Actor paramActor)
  {
    this.container.setActor(paramActor);
    this.container.pack();
  }

  public void setAlways(boolean paramBoolean)
  {
    this.always = paramBoolean;
  }

  public void setInstant(boolean paramBoolean)
  {
    this.instant = paramBoolean;
  }

  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.instant)
    {
      this.container.toFront();
      return false;
    }
    this.manager.touchDown(this);
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Tooltip
 * JD-Core Version:    0.6.0
 */