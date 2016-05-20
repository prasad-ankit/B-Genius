package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import java.util.Iterator;

public class DragAndDrop
{
  static final Vector2 tmpVector = new Vector2();
  int activePointer = -1;
  private int button;
  boolean cancelTouchFocus = true;
  Actor dragActor;
  float dragActorX = 14.0F;
  float dragActorY = -20.0F;
  long dragStartTime;
  int dragTime = 250;
  boolean isValidTarget;
  boolean keepWithinStage = true;
  DragAndDrop.Payload payload;
  ObjectMap sourceListeners = new ObjectMap();
  private float tapSquareSize = 8.0F;
  DragAndDrop.Target target;
  Array targets = new Array();
  float touchOffsetX;
  float touchOffsetY;

  public void addSource(DragAndDrop.Source paramSource)
  {
    DragAndDrop.1 local1 = new DragAndDrop.1(this, paramSource);
    local1.setTapSquareSize(this.tapSquareSize);
    local1.setButton(this.button);
    paramSource.actor.addCaptureListener(local1);
    this.sourceListeners.put(paramSource, local1);
  }

  public void addTarget(DragAndDrop.Target paramTarget)
  {
    this.targets.add(paramTarget);
  }

  public void clear()
  {
    this.targets.clear();
    ObjectMap.Entries localEntries = this.sourceListeners.entries().iterator();
    while (localEntries.hasNext())
    {
      ObjectMap.Entry localEntry = (ObjectMap.Entry)localEntries.next();
      ((DragAndDrop.Source)localEntry.key).actor.removeCaptureListener((EventListener)localEntry.value);
    }
    this.sourceListeners.clear();
  }

  public Actor getDragActor()
  {
    return this.dragActor;
  }

  public boolean isDragging()
  {
    return this.payload != null;
  }

  public void removeSource(DragAndDrop.Source paramSource)
  {
    DragListener localDragListener = (DragListener)this.sourceListeners.remove(paramSource);
    paramSource.actor.removeCaptureListener(localDragListener);
  }

  public void removeTarget(DragAndDrop.Target paramTarget)
  {
    this.targets.removeValue(paramTarget, true);
  }

  public void setButton(int paramInt)
  {
    this.button = paramInt;
  }

  public void setCancelTouchFocus(boolean paramBoolean)
  {
    this.cancelTouchFocus = paramBoolean;
  }

  public void setDragActorPosition(float paramFloat1, float paramFloat2)
  {
    this.dragActorX = paramFloat1;
    this.dragActorY = paramFloat2;
  }

  public void setDragTime(int paramInt)
  {
    this.dragTime = paramInt;
  }

  public void setKeepWithinStage(boolean paramBoolean)
  {
    this.keepWithinStage = paramBoolean;
  }

  public void setTapSquareSize(float paramFloat)
  {
    this.tapSquareSize = paramFloat;
  }

  public void setTouchOffset(float paramFloat1, float paramFloat2)
  {
    this.touchOffsetX = paramFloat1;
    this.touchOffsetY = paramFloat2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop
 * JD-Core Version:    0.6.0
 */