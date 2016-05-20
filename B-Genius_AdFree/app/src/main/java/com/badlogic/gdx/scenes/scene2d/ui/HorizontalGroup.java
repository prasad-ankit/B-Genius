package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.SnapshotArray;

public class HorizontalGroup extends WidgetGroup
{
  private int align;
  private float fill;
  private float padBottom;
  private float padLeft;
  private float padRight;
  private float padTop;
  private float prefHeight;
  private float prefWidth;
  private boolean reverse;
  private boolean round = true;
  private boolean sizeInvalid = true;
  private float spacing;

  public HorizontalGroup()
  {
    setTouchable(Touchable.childrenOnly);
  }

  private void computeSize()
  {
    this.sizeInvalid = false;
    SnapshotArray localSnapshotArray = getChildren();
    int i = localSnapshotArray.size;
    this.prefWidth = (this.padLeft + this.padRight + this.spacing * (i - 1));
    this.prefHeight = 0.0F;
    int j = 0;
    if (j < i)
    {
      Actor localActor = (Actor)localSnapshotArray.get(j);
      Layout localLayout;
      if ((localActor instanceof Layout))
      {
        localLayout = (Layout)localActor;
        this.prefWidth += localLayout.getPrefWidth();
      }
      for (this.prefHeight = Math.max(this.prefHeight, localLayout.getPrefHeight()); ; this.prefHeight = Math.max(this.prefHeight, localActor.getHeight()))
      {
        j++;
        break;
        this.prefWidth += localActor.getWidth();
      }
    }
    this.prefHeight += this.padTop + this.padBottom;
    if (this.round)
    {
      this.prefWidth = Math.round(this.prefWidth);
      this.prefHeight = Math.round(this.prefHeight);
    }
  }

  public HorizontalGroup align(int paramInt)
  {
    this.align = paramInt;
    return this;
  }

  public HorizontalGroup bottom()
  {
    this.align = (0x4 | this.align);
    this.align = (0xFFFFFFFD & this.align);
    return this;
  }

  public HorizontalGroup center()
  {
    this.align = 1;
    return this;
  }

  public HorizontalGroup fill()
  {
    this.fill = 1.0F;
    return this;
  }

  public HorizontalGroup fill(float paramFloat)
  {
    this.fill = paramFloat;
    return this;
  }

  public int getAlign()
  {
    return this.align;
  }

  public float getFill()
  {
    return this.fill;
  }

  public float getPadBottom()
  {
    return this.padBottom;
  }

  public float getPadLeft()
  {
    return this.padLeft;
  }

  public float getPadRight()
  {
    return this.padRight;
  }

  public float getPadTop()
  {
    return this.padTop;
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

  public boolean getReverse()
  {
    return this.reverse;
  }

  public float getSpace()
  {
    return this.spacing;
  }

  public void invalidate()
  {
    super.invalidate();
    this.sizeInvalid = true;
  }

  public void layout()
  {
    float f1 = this.spacing;
    float f2 = this.padBottom;
    int i = this.align;
    boolean bool1 = this.reverse;
    boolean bool2 = this.round;
    float f3 = getHeight() - this.padTop - f2;
    float f4;
    int k;
    float f5;
    label71: Actor localActor;
    Layout localLayout2;
    float f13;
    label123: float f14;
    float f15;
    if (!bool1)
    {
      f4 = this.padLeft;
      SnapshotArray localSnapshotArray = getChildren();
      int j = localSnapshotArray.size;
      k = 0;
      f5 = f4;
      if (k >= j)
        break label392;
      localActor = (Actor)localSnapshotArray.get(k);
      if (!(localActor instanceof Layout))
        break label314;
      localLayout2 = (Layout)localActor;
      if (this.fill <= 0.0F)
        break label297;
      f13 = f3 * this.fill;
      f14 = Math.max(f13, localLayout2.getMinHeight());
      f15 = localLayout2.getMaxHeight();
      if ((f15 <= 0.0F) || (f14 <= f15))
        break label427;
    }
    while (true)
    {
      float f16 = localLayout2.getPrefWidth();
      float f8 = f15;
      float f9 = f16;
      Layout localLayout1 = localLayout2;
      while (true)
      {
        label182: float f10;
        if ((i & 0x2) != 0)
          f10 = f2 + (f3 - f8);
        label197: label245: float f6;
        label297: label314: float f7;
        while (true)
        {
          float f11;
          if (bool1)
            f11 = f5 - (f9 + f1);
          while (true)
          {
            float f12;
            if (bool2)
            {
              localActor.setBounds(Math.round(f11), Math.round(f10), Math.round(f9), Math.round(f8));
              if (bool1)
                break label393;
              f12 = f11 + (f9 + f1);
            }
            while (true)
            {
              if (localLayout1 != null)
                localLayout1.validate();
              k++;
              f5 = f12;
              break label71;
              f4 = f1 + (getWidth() - this.padRight);
              break;
              f13 = Math.min(localLayout2.getPrefHeight(), f3);
              break label123;
              f6 = localActor.getWidth();
              f7 = localActor.getHeight();
              if (this.fill <= 0.0F)
                break label413;
              f8 = f7 * this.fill;
              f9 = f6;
              localLayout1 = null;
              break label182;
              if ((i & 0x4) != 0)
                break label407;
              f10 = f2 + (f3 - f8) / 2.0F;
              break label197;
              localActor.setBounds(f11, f10, f9, f8);
              break label245;
              label392: return;
              label393: f12 = f11;
            }
            f11 = f5;
          }
          label407: f10 = f2;
        }
        label413: f8 = f7;
        f9 = f6;
        localLayout1 = null;
      }
      label427: f15 = f14;
    }
  }

  public HorizontalGroup pad(float paramFloat)
  {
    this.padTop = paramFloat;
    this.padLeft = paramFloat;
    this.padBottom = paramFloat;
    this.padRight = paramFloat;
    return this;
  }

  public HorizontalGroup pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.padTop = paramFloat1;
    this.padLeft = paramFloat2;
    this.padBottom = paramFloat3;
    this.padRight = paramFloat4;
    return this;
  }

  public HorizontalGroup padBottom(float paramFloat)
  {
    this.padBottom = paramFloat;
    return this;
  }

  public HorizontalGroup padLeft(float paramFloat)
  {
    this.padLeft = paramFloat;
    return this;
  }

  public HorizontalGroup padRight(float paramFloat)
  {
    this.padRight = paramFloat;
    return this;
  }

  public HorizontalGroup padTop(float paramFloat)
  {
    this.padTop = paramFloat;
    return this;
  }

  public HorizontalGroup reverse()
  {
    reverse(true);
    return this;
  }

  public HorizontalGroup reverse(boolean paramBoolean)
  {
    this.reverse = paramBoolean;
    return this;
  }

  public void setRound(boolean paramBoolean)
  {
    this.round = paramBoolean;
  }

  public HorizontalGroup space(float paramFloat)
  {
    this.spacing = paramFloat;
    return this;
  }

  public HorizontalGroup top()
  {
    this.align = (0x2 | this.align);
    this.align = (0xFFFFFFFB & this.align);
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup
 * JD-Core Version:    0.6.0
 */