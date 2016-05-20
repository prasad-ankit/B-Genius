package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.input.GestureDetector.GestureAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

class ActorGestureListener$1 extends GestureDetector.GestureAdapter
{
  private final Vector2 initialPointer1 = new Vector2();
  private final Vector2 initialPointer2 = new Vector2();
  private final Vector2 pointer1 = new Vector2();
  private final Vector2 pointer2 = new Vector2();

  private void stageToLocalAmount(Vector2 paramVector2)
  {
    this.this$0.actor.stageToLocalCoordinates(paramVector2);
    paramVector2.sub(this.this$0.actor.stageToLocalCoordinates(ActorGestureListener.tmpCoords2.set(0.0F, 0.0F)));
  }

  public boolean fling(float paramFloat1, float paramFloat2, int paramInt)
  {
    stageToLocalAmount(ActorGestureListener.tmpCoords.set(paramFloat1, paramFloat2));
    this.this$0.fling(this.this$0.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, paramInt);
    return true;
  }

  public boolean longPress(float paramFloat1, float paramFloat2)
  {
    this.this$0.actor.stageToLocalCoordinates(ActorGestureListener.tmpCoords.set(paramFloat1, paramFloat2));
    return this.this$0.longPress(this.this$0.actor, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y);
  }

  public boolean pan(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    stageToLocalAmount(ActorGestureListener.tmpCoords.set(paramFloat3, paramFloat4));
    float f1 = ActorGestureListener.tmpCoords.x;
    float f2 = ActorGestureListener.tmpCoords.y;
    this.this$0.actor.stageToLocalCoordinates(ActorGestureListener.tmpCoords.set(paramFloat1, paramFloat2));
    this.this$0.pan(this.this$0.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, f1, f2);
    return true;
  }

  public boolean pinch(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24)
  {
    this.this$0.actor.stageToLocalCoordinates(this.initialPointer1.set(paramVector21));
    this.this$0.actor.stageToLocalCoordinates(this.initialPointer2.set(paramVector22));
    this.this$0.actor.stageToLocalCoordinates(this.pointer1.set(paramVector23));
    this.this$0.actor.stageToLocalCoordinates(this.pointer2.set(paramVector24));
    this.this$0.pinch(this.this$0.event, this.initialPointer1, this.initialPointer2, this.pointer1, this.pointer2);
    return true;
  }

  public boolean tap(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.this$0.actor.stageToLocalCoordinates(ActorGestureListener.tmpCoords.set(paramFloat1, paramFloat2));
    this.this$0.tap(this.this$0.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, paramInt1, paramInt2);
    return true;
  }

  public boolean zoom(float paramFloat1, float paramFloat2)
  {
    this.this$0.zoom(this.this$0.event, paramFloat1, paramFloat2);
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener.1
 * JD-Core Version:    0.6.0
 */