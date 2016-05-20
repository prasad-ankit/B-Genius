package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

class DragAndDrop$1 extends DragListener
{
  public void drag(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    int i = 0;
    if (this.this$0.payload == null);
    do
      return;
    while (paramInt != this.this$0.activePointer);
    Stage localStage = paramInputEvent.getStage();
    Touchable localTouchable2;
    if (this.this$0.dragActor != null)
    {
      localTouchable2 = this.this$0.dragActor.getTouchable();
      this.this$0.dragActor.setTouchable(Touchable.disabled);
    }
    for (Touchable localTouchable1 = localTouchable2; ; localTouchable1 = null)
    {
      this.this$0.isValidTarget = false;
      float f1 = paramInputEvent.getStageX() + this.this$0.touchOffsetX;
      float f2 = paramInputEvent.getStageY() + this.this$0.touchOffsetY;
      Actor localActor1 = paramInputEvent.getStage().hit(f1, f2, true);
      if (localActor1 == null);
      for (Actor localActor2 = paramInputEvent.getStage().hit(f1, f2, false); ; localActor2 = localActor1)
      {
        DragAndDrop.Target localTarget;
        if (localActor2 != null)
        {
          int j = this.this$0.targets.size;
          if (i < j)
          {
            localTarget = (DragAndDrop.Target)this.this$0.targets.get(i);
            if (localTarget.actor.isAscendantOf(localActor2))
              localTarget.actor.stageToLocalCoordinates(DragAndDrop.tmpVector.set(f1, f2));
          }
        }
        while (true)
        {
          if (localTarget != this.this$0.target)
          {
            if (this.this$0.target != null)
              this.this$0.target.reset(this.val$source, this.this$0.payload);
            this.this$0.target = localTarget;
          }
          if (localTarget != null)
            this.this$0.isValidTarget = localTarget.drag(this.val$source, this.this$0.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, paramInt);
          if (this.this$0.dragActor != null)
            this.this$0.dragActor.setTouchable(localTouchable1);
          Actor localActor3;
          if (this.this$0.target != null)
            if (this.this$0.isValidTarget)
              localActor3 = this.this$0.payload.validDragActor;
          while (true)
          {
            label361: if (localActor3 == null);
            for (Actor localActor4 = this.this$0.payload.dragActor; ; localActor4 = localActor3)
            {
              if (localActor4 == null)
                break label592;
              if (this.this$0.dragActor != localActor4)
              {
                if (this.this$0.dragActor != null)
                  this.this$0.dragActor.remove();
                this.this$0.dragActor = localActor4;
                localStage.addActor(localActor4);
              }
              float f3 = paramInputEvent.getStageX() + this.this$0.dragActorX;
              float f4 = paramInputEvent.getStageY() + this.this$0.dragActorY - localActor4.getHeight();
              if (this.this$0.keepWithinStage)
              {
                if (f3 < 0.0F)
                  f3 = 0.0F;
                if (f4 < 0.0F)
                  f4 = 0.0F;
                if (f3 + localActor4.getWidth() > localStage.getWidth())
                  f3 = localStage.getWidth() - localActor4.getWidth();
                if (f4 + localActor4.getHeight() > localStage.getHeight())
                  f4 = localStage.getHeight() - localActor4.getHeight();
              }
              localActor4.setPosition(f3, f4);
              return;
              i++;
              break;
              localActor3 = this.this$0.payload.invalidDragActor;
              break label361;
            }
            label592: break;
            localActor3 = null;
          }
          localTarget = null;
        }
      }
    }
  }

  public void dragStart(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (this.this$0.activePointer != -1)
      paramInputEvent.stop();
    do
    {
      return;
      this.this$0.activePointer = paramInt;
      this.this$0.dragStartTime = System.currentTimeMillis();
      this.this$0.payload = this.val$source.dragStart(paramInputEvent, getTouchDownX(), getTouchDownY(), paramInt);
      paramInputEvent.stop();
    }
    while ((!this.this$0.cancelTouchFocus) || (this.this$0.payload == null));
    this.val$source.getActor().getStage().cancelTouchFocusExcept(this, this.val$source.getActor());
  }

  public void dragStop(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramInt != this.this$0.activePointer);
    do
    {
      return;
      this.this$0.activePointer = -1;
    }
    while (this.this$0.payload == null);
    if (System.currentTimeMillis() - this.this$0.dragStartTime < this.this$0.dragTime)
      this.this$0.isValidTarget = false;
    if (this.this$0.dragActor != null)
      this.this$0.dragActor.remove();
    if (this.this$0.isValidTarget)
    {
      float f1 = paramInputEvent.getStageX() + this.this$0.touchOffsetX;
      float f2 = paramInputEvent.getStageY() + this.this$0.touchOffsetY;
      this.this$0.target.actor.stageToLocalCoordinates(DragAndDrop.tmpVector.set(f1, f2));
      this.this$0.target.drop(this.val$source, this.this$0.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, paramInt);
    }
    DragAndDrop.Source localSource = this.val$source;
    DragAndDrop.Payload localPayload = this.this$0.payload;
    if (this.this$0.isValidTarget);
    for (DragAndDrop.Target localTarget = this.this$0.target; ; localTarget = null)
    {
      localSource.dragStop(paramInputEvent, paramFloat1, paramFloat2, paramInt, localPayload, localTarget);
      if (this.this$0.target != null)
        this.this$0.target.reset(this.val$source, this.this$0.payload);
      this.this$0.payload = null;
      this.this$0.target = null;
      this.this$0.isValidTarget = false;
      this.this$0.dragActor = null;
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.1
 * JD-Core Version:    0.6.0
 */