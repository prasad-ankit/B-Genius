package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.SnapshotArray;

public class VerticalGroup extends WidgetGroup
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

  public VerticalGroup()
  {
    setTouchable(Touchable.childrenOnly);
  }

  private void computeSize()
  {
    this.sizeInvalid = false;
    SnapshotArray localSnapshotArray = getChildren();
    int i = localSnapshotArray.size;
    this.prefWidth = 0.0F;
    this.prefHeight = (this.padTop + this.padBottom + this.spacing * (i - 1));
    int j = 0;
    if (j < i)
    {
      Actor localActor = (Actor)localSnapshotArray.get(j);
      if ((localActor instanceof Layout))
      {
        Layout localLayout = (Layout)localActor;
        this.prefWidth = Math.max(this.prefWidth, localLayout.getPrefWidth());
        this.prefHeight += localLayout.getPrefHeight();
      }
      while (true)
      {
        j++;
        break;
        this.prefWidth = Math.max(this.prefWidth, localActor.getWidth());
        this.prefHeight += localActor.getHeight();
      }
    }
    this.prefWidth += this.padLeft + this.padRight;
    if (this.round)
    {
      this.prefWidth = Math.round(this.prefWidth);
      this.prefHeight = Math.round(this.prefHeight);
    }
  }

  public VerticalGroup align(int paramInt)
  {
    this.align = paramInt;
    return this;
  }

  public VerticalGroup center()
  {
    this.align = 1;
    return this;
  }

  public VerticalGroup fill()
  {
    this.fill = 1.0F;
    return this;
  }

  public VerticalGroup fill(float paramFloat)
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
    float f2 = this.padLeft;
    int i = this.align;
    boolean bool1 = this.reverse;
    boolean bool2 = this.round;
    float f3 = getWidth() - f2 - this.padRight;
    float f4;
    int k;
    float f5;
    label71: Actor localActor;
    Layout localLayout2;
    float f14;
    label123: float f15;
    float f16;
    if (bool1)
    {
      f4 = this.padBottom;
      SnapshotArray localSnapshotArray = getChildren();
      int j = localSnapshotArray.size;
      k = 0;
      f5 = f4;
      if (k >= j)
        break label394;
      localActor = (Actor)localSnapshotArray.get(k);
      if (!(localActor instanceof Layout))
        break label311;
      localLayout2 = (Layout)localActor;
      if (this.fill <= 0.0F)
        break label294;
      f14 = f3 * this.fill;
      f15 = Math.max(f14, localLayout2.getMinWidth());
      f16 = localLayout2.getMaxWidth();
      if ((f16 <= 0.0F) || (f15 <= f16))
        break label429;
    }
    while (true)
    {
      float f8 = localLayout2.getPrefHeight();
      float f9 = f16;
      Layout localLayout1 = localLayout2;
      while (true)
      {
        label178: float f10;
        if ((i & 0x10) != 0)
          f10 = f2 + (f3 - f9);
        label194: label242: float f6;
        label294: label311: float f7;
        while (true)
        {
          float f11;
          if (!bool1)
            f11 = f5 - (f8 + f1);
          while (true)
          {
            float f12;
            if (bool2)
            {
              localActor.setBounds(Math.round(f10), Math.round(f11), Math.round(f9), Math.round(f8));
              if (!bool1)
                break label395;
              f12 = f11 + (f8 + f1);
            }
            while (true)
            {
              if (localLayout1 != null)
                localLayout1.validate();
              k++;
              f5 = f12;
              break label71;
              f4 = f1 + (getHeight() - this.padTop);
              break;
              f14 = Math.min(localLayout2.getPrefWidth(), f3);
              break label123;
              f6 = localActor.getWidth();
              f7 = localActor.getHeight();
              if (this.fill <= 0.0F)
                break label415;
              float f13 = f6 * this.fill;
              f8 = f7;
              f9 = f13;
              localLayout1 = null;
              break label178;
              if ((i & 0x8) != 0)
                break label409;
              f10 = f2 + (f3 - f9) / 2.0F;
              break label194;
              localActor.setBounds(f10, f11, f9, f8);
              break label242;
              label394: return;
              label395: f12 = f11;
            }
            f11 = f5;
          }
          label409: f10 = f2;
        }
        label415: f8 = f7;
        f9 = f6;
        localLayout1 = null;
      }
      label429: f16 = f15;
    }
  }

  public VerticalGroup left()
  {
    this.align = (0x8 | this.align);
    this.align = (0xFFFFFFEF & this.align);
    return this;
  }

  public VerticalGroup pad(float paramFloat)
  {
    this.padTop = paramFloat;
    this.padLeft = paramFloat;
    this.padBottom = paramFloat;
    this.padRight = paramFloat;
    return this;
  }

  public VerticalGroup pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.padTop = paramFloat1;
    this.padLeft = paramFloat2;
    this.padBottom = paramFloat3;
    this.padRight = paramFloat4;
    return this;
  }

  public VerticalGroup padBottom(float paramFloat)
  {
    this.padBottom = paramFloat;
    return this;
  }

  public VerticalGroup padLeft(float paramFloat)
  {
    this.padLeft = paramFloat;
    return this;
  }

  public VerticalGroup padRight(float paramFloat)
  {
    this.padRight = paramFloat;
    return this;
  }

  public VerticalGroup padTop(float paramFloat)
  {
    this.padTop = paramFloat;
    return this;
  }

  public VerticalGroup reverse()
  {
    reverse(true);
    return this;
  }

  public VerticalGroup reverse(boolean paramBoolean)
  {
    this.reverse = paramBoolean;
    return this;
  }

  public VerticalGroup right()
  {
    this.align = (0x10 | this.align);
    this.align = (0xFFFFFFF7 & this.align);
    return this;
  }

  public void setRound(boolean paramBoolean)
  {
    this.round = paramBoolean;
  }

  public VerticalGroup space(float paramFloat)
  {
    this.spacing = paramFloat;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup
 * JD-Core Version:    0.6.0
 */