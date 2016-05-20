package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.SnapshotArray;

public class Actor
{
  private final Array actions = new Array(0);
  private final DelayedRemovalArray captureListeners = new DelayedRemovalArray(0);
  final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  private boolean debug;
  float height;
  private final DelayedRemovalArray listeners = new DelayedRemovalArray(0);
  private String name;
  float originX;
  float originY;
  Group parent;
  float rotation;
  float scaleX = 1.0F;
  float scaleY = 1.0F;
  private Stage stage;
  private Touchable touchable = Touchable.enabled;
  private Object userObject;
  private boolean visible = true;
  float width;
  float x;
  float y;

  public void act(float paramFloat)
  {
    Array localArray = this.actions;
    if (localArray.size > 0)
    {
      if ((this.stage != null) && (this.stage.getActionsRequestRendering()))
        Gdx.graphics.requestRendering();
      int i = 0;
      if (i < localArray.size)
      {
        Action localAction = (Action)localArray.get(i);
        if ((localAction.act(paramFloat)) && (i < localArray.size))
          if ((Action)localArray.get(i) != localAction)
            break label118;
        label118: for (int j = i; ; j = localArray.indexOf(localAction, true))
        {
          if (j != -1)
          {
            localArray.removeIndex(j);
            localAction.setActor(null);
            i--;
          }
          i++;
          break;
        }
      }
    }
  }

  public void addAction(Action paramAction)
  {
    paramAction.setActor(this);
    this.actions.add(paramAction);
    if ((this.stage != null) && (this.stage.getActionsRequestRendering()))
      Gdx.graphics.requestRendering();
  }

  public boolean addCaptureListener(EventListener paramEventListener)
  {
    if (!this.captureListeners.contains(paramEventListener, true))
      this.captureListeners.add(paramEventListener);
    return true;
  }

  public boolean addListener(EventListener paramEventListener)
  {
    if (!this.listeners.contains(paramEventListener, true))
    {
      this.listeners.add(paramEventListener);
      return true;
    }
    return false;
  }

  public void clear()
  {
    clearActions();
    clearListeners();
  }

  public void clearActions()
  {
    for (int i = -1 + this.actions.size; i >= 0; i--)
      ((Action)this.actions.get(i)).setActor(null);
    this.actions.clear();
  }

  public void clearListeners()
  {
    this.listeners.clear();
    this.captureListeners.clear();
  }

  public boolean clipBegin()
  {
    return clipBegin(this.x, this.y, this.width, this.height);
  }

  public boolean clipBegin(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat3 <= 0.0F) || (paramFloat4 <= 0.0F))
      return false;
    Rectangle localRectangle1 = Rectangle.tmp;
    localRectangle1.x = paramFloat1;
    localRectangle1.y = paramFloat2;
    localRectangle1.width = paramFloat3;
    localRectangle1.height = paramFloat4;
    Stage localStage = this.stage;
    Rectangle localRectangle2 = (Rectangle)Pools.obtain(Rectangle.class);
    localStage.calculateScissors(localRectangle1, localRectangle2);
    if (ScissorStack.pushScissors(localRectangle2))
      return true;
    Pools.free(localRectangle2);
    return false;
  }

  public void clipEnd()
  {
    Pools.free(ScissorStack.popScissors());
  }

  public Actor debug()
  {
    setDebug(true);
    return this;
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
  }

  public void drawDebug(ShapeRenderer paramShapeRenderer)
  {
    drawDebugBounds(paramShapeRenderer);
  }

  protected void drawDebugBounds(ShapeRenderer paramShapeRenderer)
  {
    if (!this.debug)
      return;
    paramShapeRenderer.set(ShapeRenderer.ShapeType.Line);
    paramShapeRenderer.setColor(this.stage.getDebugColor());
    paramShapeRenderer.rect(this.x, this.y, this.originX, this.originY, this.width, this.height, this.scaleX, this.scaleY, this.rotation);
  }

  public boolean fire(Event paramEvent)
  {
    int i = 0;
    if (paramEvent.getStage() == null)
      paramEvent.setStage(getStage());
    paramEvent.setTarget(this);
    Array localArray = (Array)Pools.obtain(Array.class);
    for (Group localGroup = this.parent; localGroup != null; localGroup = localGroup.parent)
      localArray.add(localGroup);
    try
    {
      Object[] arrayOfObject = localArray.items;
      for (int j = -1 + localArray.size; j >= 0; j--)
      {
        ((Group)arrayOfObject[j]).notify(paramEvent, true);
        if (!paramEvent.isStopped())
          continue;
        boolean bool1 = paramEvent.isCancelled();
        return bool1;
      }
      notify(paramEvent, true);
      if (paramEvent.isStopped())
      {
        boolean bool6 = paramEvent.isCancelled();
        return bool6;
      }
      notify(paramEvent, false);
      if (!paramEvent.getBubbles())
      {
        boolean bool5 = paramEvent.isCancelled();
        return bool5;
      }
      if (paramEvent.isStopped())
      {
        boolean bool4 = paramEvent.isCancelled();
        return bool4;
      }
      int k = localArray.size;
      while (i < k)
      {
        ((Group)arrayOfObject[i]).notify(paramEvent, false);
        if (paramEvent.isStopped())
        {
          boolean bool2 = paramEvent.isCancelled();
          return bool2;
        }
        i++;
      }
      boolean bool3 = paramEvent.isCancelled();
      return bool3;
    }
    finally
    {
      localArray.clear();
      Pools.free(localArray);
    }
    throw localObject;
  }

  public Array getActions()
  {
    return this.actions;
  }

  public Array getCaptureListeners()
  {
    return this.captureListeners;
  }

  public Color getColor()
  {
    return this.color;
  }

  public boolean getDebug()
  {
    return this.debug;
  }

  public float getHeight()
  {
    return this.height;
  }

  public Array getListeners()
  {
    return this.listeners;
  }

  public String getName()
  {
    return this.name;
  }

  public float getOriginX()
  {
    return this.originX;
  }

  public float getOriginY()
  {
    return this.originY;
  }

  public Group getParent()
  {
    return this.parent;
  }

  public float getRight()
  {
    return this.x + this.width;
  }

  public float getRotation()
  {
    return this.rotation;
  }

  public float getScaleX()
  {
    return this.scaleX;
  }

  public float getScaleY()
  {
    return this.scaleY;
  }

  public Stage getStage()
  {
    return this.stage;
  }

  public float getTop()
  {
    return this.y + this.height;
  }

  public Touchable getTouchable()
  {
    return this.touchable;
  }

  public Object getUserObject()
  {
    return this.userObject;
  }

  public float getWidth()
  {
    return this.width;
  }

  public float getX()
  {
    return this.x;
  }

  public float getX(int paramInt)
  {
    float f = this.x;
    if ((paramInt & 0x10) != 0)
      f += this.width;
    do
      return f;
    while ((paramInt & 0x8) != 0);
    return f + this.width / 2.0F;
  }

  public float getY()
  {
    return this.y;
  }

  public float getY(int paramInt)
  {
    float f = this.y;
    if ((paramInt & 0x2) != 0)
      f += this.height;
    do
      return f;
    while ((paramInt & 0x4) != 0);
    return f + this.height / 2.0F;
  }

  public int getZIndex()
  {
    Group localGroup = this.parent;
    if (localGroup == null)
      return -1;
    return localGroup.children.indexOf(this, true);
  }

  public boolean hasActions()
  {
    return this.actions.size > 0;
  }

  public boolean hasParent()
  {
    return this.parent != null;
  }

  public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.touchable != Touchable.enabled))
      this = null;
    do
      return this;
    while ((paramFloat1 >= 0.0F) && (paramFloat1 < this.width) && (paramFloat2 >= 0.0F) && (paramFloat2 < this.height));
    return null;
  }

  public boolean isAscendantOf(Actor paramActor)
  {
    if (paramActor == null)
      throw new IllegalArgumentException("actor cannot be null.");
    do
    {
      paramActor = paramActor.parent;
      if (paramActor == null)
        return false;
    }
    while (paramActor != this);
    return true;
  }

  public boolean isDescendantOf(Actor paramActor)
  {
    if (paramActor == null)
      throw new IllegalArgumentException("actor cannot be null.");
    do
    {
      this = this.parent;
      if (this == null)
        return false;
    }
    while (this != paramActor);
    return true;
  }

  public boolean isTouchable()
  {
    return this.touchable == Touchable.enabled;
  }

  public boolean isVisible()
  {
    return this.visible;
  }

  public Vector2 localToAscendantCoordinates(Actor paramActor, Vector2 paramVector2)
  {
    do
    {
      if (this == null)
        break;
      localToParentCoordinates(paramVector2);
      this = this.parent;
    }
    while (this != paramActor);
    return paramVector2;
  }

  public Vector2 localToParentCoordinates(Vector2 paramVector2)
  {
    float f1 = -this.rotation;
    float f2 = this.scaleX;
    float f3 = this.scaleY;
    float f4 = this.x;
    float f5 = this.y;
    if (f1 == 0.0F)
    {
      if ((f2 == 1.0F) && (f3 == 1.0F))
      {
        paramVector2.x = (f4 + paramVector2.x);
        paramVector2.y = (f5 + paramVector2.y);
        return paramVector2;
      }
      float f12 = this.originX;
      float f13 = this.originY;
      paramVector2.x = (f4 + (f12 + f2 * (paramVector2.x - f12)));
      paramVector2.y = (f5 + (f13 + f3 * (paramVector2.y - f13)));
      return paramVector2;
    }
    float f6 = (float)Math.cos(f1 * 0.01745329F);
    float f7 = (float)Math.sin(f1 * 0.01745329F);
    float f8 = this.originX;
    float f9 = this.originY;
    float f10 = f2 * (paramVector2.x - f8);
    float f11 = f3 * (paramVector2.y - f9);
    paramVector2.x = (f4 + (f8 + (f10 * f6 + f11 * f7)));
    paramVector2.y = (f5 + (f9 + (f10 * -f7 + f11 * f6)));
    return paramVector2;
  }

  public Vector2 localToStageCoordinates(Vector2 paramVector2)
  {
    return localToAscendantCoordinates(null, paramVector2);
  }

  public void moveBy(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      this.x = (paramFloat1 + this.x);
      this.y = (paramFloat2 + this.y);
      positionChanged();
    }
  }

  public boolean notify(Event paramEvent, boolean paramBoolean)
  {
    if (paramEvent.getTarget() == null)
      throw new IllegalArgumentException("The event target cannot be null.");
    if (paramBoolean);
    for (DelayedRemovalArray localDelayedRemovalArray = this.captureListeners; localDelayedRemovalArray.size == 0; localDelayedRemovalArray = this.listeners)
      return paramEvent.isCancelled();
    paramEvent.setListenerActor(this);
    paramEvent.setCapture(paramBoolean);
    if (paramEvent.getStage() == null)
      paramEvent.setStage(this.stage);
    localDelayedRemovalArray.begin();
    int i = localDelayedRemovalArray.size;
    for (int j = 0; j < i; j++)
    {
      EventListener localEventListener = (EventListener)localDelayedRemovalArray.get(j);
      if (!localEventListener.handle(paramEvent))
        continue;
      paramEvent.handle();
      if (!(paramEvent instanceof InputEvent))
        continue;
      InputEvent localInputEvent = (InputEvent)paramEvent;
      if (localInputEvent.getType() != InputEvent.Type.touchDown)
        continue;
      paramEvent.getStage().addTouchFocus(localEventListener, this, localInputEvent.getTarget(), localInputEvent.getPointer(), localInputEvent.getButton());
    }
    localDelayedRemovalArray.end();
    return paramEvent.isCancelled();
  }

  public Vector2 parentToLocalCoordinates(Vector2 paramVector2)
  {
    float f1 = this.rotation;
    float f2 = this.scaleX;
    float f3 = this.scaleY;
    float f4 = this.x;
    float f5 = this.y;
    if (f1 == 0.0F)
    {
      if ((f2 == 1.0F) && (f3 == 1.0F))
      {
        paramVector2.x -= f4;
        paramVector2.y -= f5;
        return paramVector2;
      }
      float f12 = this.originX;
      float f13 = this.originY;
      paramVector2.x = (f12 + (paramVector2.x - f4 - f12) / f2);
      paramVector2.y = (f13 + (paramVector2.y - f5 - f13) / f3);
      return paramVector2;
    }
    float f6 = (float)Math.cos(f1 * 0.01745329F);
    float f7 = (float)Math.sin(f1 * 0.01745329F);
    float f8 = this.originX;
    float f9 = this.originY;
    float f10 = paramVector2.x - f4 - f8;
    float f11 = paramVector2.y - f5 - f9;
    paramVector2.x = (f8 + (f10 * f6 + f11 * f7) / f2);
    paramVector2.y = (f9 + (f10 * -f7 + f11 * f6) / f3);
    return paramVector2;
  }

  protected void positionChanged()
  {
  }

  public boolean remove()
  {
    if (this.parent != null)
      return this.parent.removeActor(this, true);
    return false;
  }

  public void removeAction(Action paramAction)
  {
    if (this.actions.removeValue(paramAction, true))
      paramAction.setActor(null);
  }

  public boolean removeCaptureListener(EventListener paramEventListener)
  {
    return this.captureListeners.removeValue(paramEventListener, true);
  }

  public boolean removeListener(EventListener paramEventListener)
  {
    return this.listeners.removeValue(paramEventListener, true);
  }

  public void rotateBy(float paramFloat)
  {
    this.rotation = (paramFloat + this.rotation);
  }

  public void scaleBy(float paramFloat)
  {
    this.scaleX = (paramFloat + this.scaleX);
    this.scaleY = (paramFloat + this.scaleY);
  }

  public void scaleBy(float paramFloat1, float paramFloat2)
  {
    this.scaleX = (paramFloat1 + this.scaleX);
    this.scaleY = (paramFloat2 + this.scaleY);
  }

  public Vector2 screenToLocalCoordinates(Vector2 paramVector2)
  {
    Stage localStage = this.stage;
    if (localStage == null)
      return paramVector2;
    return stageToLocalCoordinates(localStage.screenToStageCoordinates(paramVector2));
  }

  public void setBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.x != paramFloat1) || (this.y != paramFloat2))
    {
      this.x = paramFloat1;
      this.y = paramFloat2;
      positionChanged();
    }
    if ((this.width != paramFloat3) || (this.height != paramFloat4))
    {
      this.width = paramFloat3;
      this.height = paramFloat4;
      sizeChanged();
    }
  }

  public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public void setColor(Color paramColor)
  {
    this.color.set(paramColor);
  }

  public void setDebug(boolean paramBoolean)
  {
    this.debug = paramBoolean;
    if (paramBoolean)
      Stage.debug = true;
  }

  public void setHeight(float paramFloat)
  {
    float f = this.height;
    this.height = paramFloat;
    if (paramFloat != f)
      sizeChanged();
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setOrigin(float paramFloat1, float paramFloat2)
  {
    this.originX = paramFloat1;
    this.originY = paramFloat2;
  }

  public void setOrigin(int paramInt)
  {
    if ((paramInt & 0x8) != 0)
      this.originX = 0.0F;
    while ((paramInt & 0x4) != 0)
    {
      this.originY = 0.0F;
      return;
      if ((paramInt & 0x10) != 0)
      {
        this.originX = this.width;
        continue;
      }
      this.originX = (this.width / 2.0F);
    }
    if ((paramInt & 0x2) != 0)
    {
      this.originY = this.height;
      return;
    }
    this.originY = (this.height / 2.0F);
  }

  public void setOriginX(float paramFloat)
  {
    this.originX = paramFloat;
  }

  public void setOriginY(float paramFloat)
  {
    this.originY = paramFloat;
  }

  protected void setParent(Group paramGroup)
  {
    this.parent = paramGroup;
  }

  public void setPosition(float paramFloat1, float paramFloat2)
  {
    if ((this.x != paramFloat1) || (this.y != paramFloat2))
    {
      this.x = paramFloat1;
      this.y = paramFloat2;
      positionChanged();
    }
  }

  public void setPosition(float paramFloat1, float paramFloat2, int paramInt)
  {
    if ((paramInt & 0x10) != 0)
    {
      paramFloat1 -= this.width;
      if ((paramInt & 0x2) == 0)
        break label79;
      paramFloat2 -= this.height;
    }
    while (true)
    {
      if ((this.x != paramFloat1) || (this.y != paramFloat2))
      {
        this.x = paramFloat1;
        this.y = paramFloat2;
        positionChanged();
      }
      return;
      if ((paramInt & 0x8) != 0)
        break;
      paramFloat1 -= this.width / 2.0F;
      break;
      label79: if ((paramInt & 0x4) != 0)
        continue;
      paramFloat2 -= this.height / 2.0F;
    }
  }

  public void setRotation(float paramFloat)
  {
    this.rotation = paramFloat;
  }

  public void setScale(float paramFloat)
  {
    this.scaleX = paramFloat;
    this.scaleY = paramFloat;
  }

  public void setScale(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
  }

  public void setScaleX(float paramFloat)
  {
    this.scaleX = paramFloat;
  }

  public void setScaleY(float paramFloat)
  {
    this.scaleY = paramFloat;
  }

  public void setSize(float paramFloat1, float paramFloat2)
  {
    float f1 = this.width;
    float f2 = this.height;
    this.width = paramFloat1;
    this.height = paramFloat2;
    if ((paramFloat1 != f1) || (paramFloat2 != f2))
      sizeChanged();
  }

  protected void setStage(Stage paramStage)
  {
    this.stage = paramStage;
  }

  public void setTouchable(Touchable paramTouchable)
  {
    this.touchable = paramTouchable;
  }

  public void setUserObject(Object paramObject)
  {
    this.userObject = paramObject;
  }

  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }

  public void setWidth(float paramFloat)
  {
    float f = this.width;
    this.width = paramFloat;
    if (paramFloat != f)
      sizeChanged();
  }

  public void setX(float paramFloat)
  {
    if (this.x != paramFloat)
    {
      this.x = paramFloat;
      positionChanged();
    }
  }

  public void setY(float paramFloat)
  {
    if (this.y != paramFloat)
    {
      this.y = paramFloat;
      positionChanged();
    }
  }

  public void setZIndex(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("ZIndex cannot be < 0.");
    Group localGroup = this.parent;
    if (localGroup == null);
    SnapshotArray localSnapshotArray;
    do
    {
      return;
      localSnapshotArray = localGroup.children;
    }
    while ((localSnapshotArray.size == 1) || (!localSnapshotArray.removeValue(this, true)));
    if (paramInt >= localSnapshotArray.size)
    {
      localSnapshotArray.add(this);
      return;
    }
    localSnapshotArray.insert(paramInt, this);
  }

  public void sizeBy(float paramFloat)
  {
    this.width = (paramFloat + this.width);
    this.height = (paramFloat + this.height);
    sizeChanged();
  }

  public void sizeBy(float paramFloat1, float paramFloat2)
  {
    this.width = (paramFloat1 + this.width);
    this.height = (paramFloat2 + this.height);
    sizeChanged();
  }

  protected void sizeChanged()
  {
  }

  public Vector2 stageToLocalCoordinates(Vector2 paramVector2)
  {
    if (this.parent != null)
      this.parent.stageToLocalCoordinates(paramVector2);
    parentToLocalCoordinates(paramVector2);
    return paramVector2;
  }

  public void toBack()
  {
    setZIndex(0);
  }

  public void toFront()
  {
    setZIndex(2147483647);
  }

  public String toString()
  {
    String str = this.name;
    if (str == null)
    {
      str = getClass().getName();
      int i = str.lastIndexOf('.');
      if (i != -1)
        str = str.substring(i + 1);
    }
    return str;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.Actor
 * JD-Core Version:    0.6.0
 */