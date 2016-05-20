package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;
import java.util.Iterator;

public class Group extends Actor
  implements Cullable
{
  private static final Vector2 tmp = new Vector2();
  final SnapshotArray children = new SnapshotArray(true, 4, Actor.class);
  private final Matrix4 computedTransform = new Matrix4();
  private Rectangle cullingArea;
  private final Matrix4 oldTransform = new Matrix4();
  boolean transform = true;
  private final Affine2 worldTransform = new Affine2();

  public void act(float paramFloat)
  {
    super.act(paramFloat);
    Actor[] arrayOfActor = (Actor[])this.children.begin();
    int i = 0;
    int j = this.children.size;
    while (i < j)
    {
      arrayOfActor[i].act(paramFloat);
      i++;
    }
    this.children.end();
  }

  public void addActor(Actor paramActor)
  {
    if (paramActor.parent != null)
      paramActor.parent.removeActor(paramActor, false);
    this.children.add(paramActor);
    paramActor.setParent(this);
    paramActor.setStage(getStage());
    childrenChanged();
  }

  public void addActorAfter(Actor paramActor1, Actor paramActor2)
  {
    if (paramActor2.parent != null)
      paramActor2.parent.removeActor(paramActor2, false);
    int i = this.children.indexOf(paramActor1, true);
    if (i == this.children.size)
      this.children.add(paramActor2);
    while (true)
    {
      paramActor2.setParent(this);
      paramActor2.setStage(getStage());
      childrenChanged();
      return;
      this.children.insert(i + 1, paramActor2);
    }
  }

  public void addActorAt(int paramInt, Actor paramActor)
  {
    if (paramActor.parent != null)
      paramActor.parent.removeActor(paramActor, false);
    if (paramInt >= this.children.size)
      this.children.add(paramActor);
    while (true)
    {
      paramActor.setParent(this);
      paramActor.setStage(getStage());
      childrenChanged();
      return;
      this.children.insert(paramInt, paramActor);
    }
  }

  public void addActorBefore(Actor paramActor1, Actor paramActor2)
  {
    if (paramActor2.parent != null)
      paramActor2.parent.removeActor(paramActor2, false);
    int i = this.children.indexOf(paramActor1, true);
    this.children.insert(i, paramActor2);
    paramActor2.setParent(this);
    paramActor2.setStage(getStage());
    childrenChanged();
  }

  protected void applyTransform(Batch paramBatch, Matrix4 paramMatrix4)
  {
    this.oldTransform.set(paramBatch.getTransformMatrix());
    paramBatch.setTransformMatrix(paramMatrix4);
  }

  protected void applyTransform(ShapeRenderer paramShapeRenderer, Matrix4 paramMatrix4)
  {
    this.oldTransform.set(paramShapeRenderer.getTransformMatrix());
    paramShapeRenderer.setTransformMatrix(paramMatrix4);
  }

  protected void childrenChanged()
  {
  }

  public void clear()
  {
    super.clear();
    clearChildren();
  }

  public void clearChildren()
  {
    Actor[] arrayOfActor = (Actor[])this.children.begin();
    int i = 0;
    int j = this.children.size;
    while (i < j)
    {
      Actor localActor = arrayOfActor[i];
      localActor.setStage(null);
      localActor.setParent(null);
      i++;
    }
    this.children.end();
    this.children.clear();
    childrenChanged();
  }

  protected Matrix4 computeTransform()
  {
    Affine2 localAffine2 = this.worldTransform;
    float f1 = this.originX;
    float f2 = this.originY;
    float f3 = this.rotation;
    float f4 = this.scaleX;
    float f5 = this.scaleY;
    localAffine2.setToTrnRotScl(f1 + this.x, f2 + this.y, f3, f4, f5);
    if ((f1 != 0.0F) || (f2 != 0.0F))
      localAffine2.translate(-f1, -f2);
    for (Group localGroup = this.parent; (localGroup != null) && (!localGroup.transform); localGroup = localGroup.parent);
    if (localGroup != null)
      localAffine2.preMul(localGroup.worldTransform);
    this.computedTransform.set(localAffine2);
    return this.computedTransform;
  }

  public Group debugAll()
  {
    setDebug(true, true);
    return this;
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    if (this.transform)
      applyTransform(paramBatch, computeTransform());
    drawChildren(paramBatch, paramFloat);
    if (this.transform)
      resetTransform(paramBatch);
  }

  protected void drawChildren(Batch paramBatch, float paramFloat)
  {
    float f1 = paramFloat * this.color.a;
    SnapshotArray localSnapshotArray = this.children;
    Actor[] arrayOfActor = (Actor[])localSnapshotArray.begin();
    Rectangle localRectangle = this.cullingArea;
    if (localRectangle != null)
    {
      float f6 = localRectangle.x;
      float f7 = f6 + localRectangle.width;
      float f8 = localRectangle.y;
      float f9 = f8 + localRectangle.height;
      if (this.transform)
      {
        int i2 = 0;
        int i3 = localSnapshotArray.size;
        while (i2 < i3)
        {
          Actor localActor4 = arrayOfActor[i2];
          if (localActor4.isVisible())
          {
            float f14 = localActor4.x;
            float f15 = localActor4.y;
            if ((f14 <= f7) && (f15 <= f9) && (f14 + localActor4.width >= f6) && (f15 + localActor4.height >= f8))
              localActor4.draw(paramBatch, f1);
          }
          i2++;
        }
      }
      float f10 = this.x;
      float f11 = this.y;
      this.x = 0.0F;
      this.y = 0.0F;
      int n = 0;
      int i1 = localSnapshotArray.size;
      while (n < i1)
      {
        Actor localActor3 = arrayOfActor[n];
        if (localActor3.isVisible())
        {
          float f12 = localActor3.x;
          float f13 = localActor3.y;
          if ((f12 <= f7) && (f13 <= f9) && (f12 + localActor3.width >= f6) && (f13 + localActor3.height >= f8))
          {
            localActor3.x = (f12 + f10);
            localActor3.y = (f13 + f11);
            localActor3.draw(paramBatch, f1);
            localActor3.x = f12;
            localActor3.y = f13;
          }
        }
        n++;
      }
      this.x = f10;
      this.y = f11;
    }
    while (true)
    {
      localSnapshotArray.end();
      return;
      if (this.transform)
      {
        int k = 0;
        int m = localSnapshotArray.size;
        while (k < m)
        {
          Actor localActor2 = arrayOfActor[k];
          if (localActor2.isVisible())
            localActor2.draw(paramBatch, f1);
          k++;
        }
        continue;
      }
      float f2 = this.x;
      float f3 = this.y;
      this.x = 0.0F;
      this.y = 0.0F;
      int i = 0;
      int j = localSnapshotArray.size;
      while (i < j)
      {
        Actor localActor1 = arrayOfActor[i];
        if (localActor1.isVisible())
        {
          float f4 = localActor1.x;
          float f5 = localActor1.y;
          localActor1.x = (f4 + f2);
          localActor1.y = (f5 + f3);
          localActor1.draw(paramBatch, f1);
          localActor1.x = f4;
          localActor1.y = f5;
        }
        i++;
      }
      this.x = f2;
      this.y = f3;
    }
  }

  public void drawDebug(ShapeRenderer paramShapeRenderer)
  {
    drawDebugBounds(paramShapeRenderer);
    if (this.transform)
      applyTransform(paramShapeRenderer, computeTransform());
    drawDebugChildren(paramShapeRenderer);
    if (this.transform)
      resetTransform(paramShapeRenderer);
  }

  protected void drawDebugChildren(ShapeRenderer paramShapeRenderer)
  {
    int i = 0;
    SnapshotArray localSnapshotArray = this.children;
    Actor[] arrayOfActor = (Actor[])localSnapshotArray.begin();
    if (this.transform)
    {
      int k = localSnapshotArray.size;
      while (i < k)
      {
        Actor localActor2 = arrayOfActor[i];
        if ((localActor2.isVisible()) && ((localActor2.getDebug()) || ((localActor2 instanceof Group))))
          localActor2.drawDebug(paramShapeRenderer);
        i++;
      }
      paramShapeRenderer.flush();
    }
    while (true)
    {
      localSnapshotArray.end();
      return;
      float f1 = this.x;
      float f2 = this.y;
      this.x = 0.0F;
      this.y = 0.0F;
      int j = localSnapshotArray.size;
      while (i < j)
      {
        Actor localActor1 = arrayOfActor[i];
        if ((localActor1.isVisible()) && ((localActor1.getDebug()) || ((localActor1 instanceof Group))))
        {
          float f3 = localActor1.x;
          float f4 = localActor1.y;
          localActor1.x = (f3 + f1);
          localActor1.y = (f4 + f2);
          localActor1.drawDebug(paramShapeRenderer);
          localActor1.x = f3;
          localActor1.y = f4;
        }
        i++;
      }
      this.x = f1;
      this.y = f2;
    }
  }

  public Actor findActor(String paramString)
  {
    int i = 0;
    SnapshotArray localSnapshotArray = this.children;
    int j = localSnapshotArray.size;
    Actor localActor2;
    for (int k = 0; k < j; k++)
    {
      if (!paramString.equals(((Actor)localSnapshotArray.get(k)).getName()))
        continue;
      localActor2 = (Actor)localSnapshotArray.get(k);
      return localActor2;
    }
    int m = localSnapshotArray.size;
    while (true)
    {
      if (i >= m)
        break label114;
      Actor localActor1 = (Actor)localSnapshotArray.get(i);
      if ((localActor1 instanceof Group))
      {
        localActor2 = ((Group)localActor1).findActor(paramString);
        if (localActor2 != null)
          break;
      }
      i++;
    }
    label114: return null;
  }

  public SnapshotArray getChildren()
  {
    return this.children;
  }

  public Rectangle getCullingArea()
  {
    return this.cullingArea;
  }

  public boolean hasChildren()
  {
    return this.children.size > 0;
  }

  public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((paramBoolean) && (getTouchable() == Touchable.disabled))
      return null;
    Vector2 localVector2 = tmp;
    Actor[] arrayOfActor = (Actor[])this.children.items;
    for (int i = -1 + this.children.size; i >= 0; i--)
    {
      Actor localActor1 = arrayOfActor[i];
      if (!localActor1.isVisible())
        continue;
      localActor1.parentToLocalCoordinates(localVector2.set(paramFloat1, paramFloat2));
      Actor localActor2 = localActor1.hit(localVector2.x, localVector2.y, paramBoolean);
      if (localActor2 != null)
        return localActor2;
    }
    return super.hit(paramFloat1, paramFloat2, paramBoolean);
  }

  public boolean isTransform()
  {
    return this.transform;
  }

  public Vector2 localToDescendantCoordinates(Actor paramActor, Vector2 paramVector2)
  {
    Group localGroup = paramActor.parent;
    if (localGroup == null)
      throw new IllegalArgumentException("Child is not a descendant: " + paramActor);
    if (localGroup != this)
      localToDescendantCoordinates(localGroup, paramVector2);
    paramActor.parentToLocalCoordinates(paramVector2);
    return paramVector2;
  }

  public boolean removeActor(Actor paramActor)
  {
    return removeActor(paramActor, true);
  }

  public boolean removeActor(Actor paramActor, boolean paramBoolean)
  {
    if (!this.children.removeValue(paramActor, true))
      return false;
    if (paramBoolean)
    {
      Stage localStage = getStage();
      if (localStage != null)
        localStage.unfocus(paramActor);
    }
    paramActor.setParent(null);
    paramActor.setStage(null);
    childrenChanged();
    return true;
  }

  protected void resetTransform(Batch paramBatch)
  {
    paramBatch.setTransformMatrix(this.oldTransform);
  }

  protected void resetTransform(ShapeRenderer paramShapeRenderer)
  {
    paramShapeRenderer.setTransformMatrix(this.oldTransform);
  }

  public void setCullingArea(Rectangle paramRectangle)
  {
    this.cullingArea = paramRectangle;
  }

  public void setDebug(boolean paramBoolean1, boolean paramBoolean2)
  {
    setDebug(paramBoolean1);
    if (paramBoolean2)
    {
      Iterator localIterator = this.children.iterator();
      while (localIterator.hasNext())
      {
        Actor localActor = (Actor)localIterator.next();
        if ((localActor instanceof Group))
        {
          ((Group)localActor).setDebug(paramBoolean1, paramBoolean2);
          continue;
        }
        localActor.setDebug(paramBoolean1);
      }
    }
  }

  protected void setStage(Stage paramStage)
  {
    super.setStage(paramStage);
    Actor[] arrayOfActor = (Actor[])this.children.items;
    int i = 0;
    int j = this.children.size;
    while (i < j)
    {
      arrayOfActor[i].setStage(paramStage);
      i++;
    }
  }

  public void setTransform(boolean paramBoolean)
  {
    this.transform = paramBoolean;
  }

  public boolean swapActor(int paramInt1, int paramInt2)
  {
    int i = this.children.size;
    if ((paramInt1 < 0) || (paramInt1 >= i));
    do
      return false;
    while ((paramInt2 < 0) || (paramInt2 >= i));
    this.children.swap(paramInt1, paramInt2);
    return true;
  }

  public boolean swapActor(Actor paramActor1, Actor paramActor2)
  {
    int i = this.children.indexOf(paramActor1, true);
    int j = this.children.indexOf(paramActor2, true);
    if ((i == -1) || (j == -1))
      return false;
    this.children.swap(i, j);
    return true;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    toString(localStringBuilder, 1);
    localStringBuilder.setLength(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  void toString(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append(super.toString());
    paramStringBuilder.append('\n');
    Actor[] arrayOfActor = (Actor[])this.children.begin();
    int i = this.children.size;
    int j = 0;
    if (j < i)
    {
      for (int k = 0; k < paramInt; k++)
        paramStringBuilder.append("|  ");
      Actor localActor = arrayOfActor[j];
      if ((localActor instanceof Group))
        ((Group)localActor).toString(paramStringBuilder, paramInt + 1);
      while (true)
      {
        j++;
        break;
        paramStringBuilder.append(localActor);
        paramStringBuilder.append('\n');
      }
    }
    this.children.end();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.Group
 * JD-Core Version:    0.6.0
 */