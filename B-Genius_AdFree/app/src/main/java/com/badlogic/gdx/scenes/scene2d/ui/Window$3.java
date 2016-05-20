package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

class Window$3 extends InputListener
{
  int edge;
  float lastX;
  float lastY;
  float startX;
  float startY;

  public boolean keyDown(InputEvent paramInputEvent, int paramInt)
  {
    return this.this$0.isModal;
  }

  public boolean keyTyped(InputEvent paramInputEvent, char paramChar)
  {
    return this.this$0.isModal;
  }

  public boolean keyUp(InputEvent paramInputEvent, int paramInt)
  {
    return this.this$0.isModal;
  }

  public boolean mouseMoved(InputEvent paramInputEvent, float paramFloat1, float paramFloat2)
  {
    return this.this$0.isModal;
  }

  public boolean scrolled(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    return this.this$0.isModal;
  }

  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    Window localWindow;
    if (paramInt2 == 0)
    {
      int j = this.this$0.resizeBorder;
      float f1 = this.this$0.getWidth();
      float f2 = this.this$0.getHeight();
      this.edge = 0;
      if ((this.this$0.isResizable) && (paramFloat1 >= 0.0F) && (paramFloat1 < f1) && (paramFloat2 >= 0.0F) && (paramFloat2 < f2))
      {
        if (paramFloat1 < j)
          this.edge = (0x8 | this.edge);
        if (paramFloat1 > f1 - j)
          this.edge = (0x10 | this.edge);
        if (paramFloat2 < j)
          this.edge = (0x4 | this.edge);
        if (paramFloat2 > f2 - j)
          this.edge = (0x2 | this.edge);
        if (this.edge != 0)
          j += 25;
        if (paramFloat1 < j)
          this.edge = (0x8 | this.edge);
        if (paramFloat1 > f1 - j)
          this.edge = (0x10 | this.edge);
        if (paramFloat2 < j)
          this.edge = (0x4 | this.edge);
        if (paramFloat2 > f2 - j)
          this.edge = (0x2 | this.edge);
      }
      if ((this.this$0.isMovable) && (this.edge == 0) && (paramFloat2 <= f2) && (paramFloat2 >= f2 - this.this$0.getPadTop()) && (paramFloat1 >= 0.0F) && (paramFloat1 <= f1))
        this.edge = 32;
      localWindow = this.this$0;
      if (this.edge == 0)
        break label374;
    }
    label374: for (boolean bool2 = true; ; bool2 = false)
    {
      localWindow.dragging = bool2;
      this.startX = paramFloat1;
      this.startY = paramFloat2;
      this.lastX = paramFloat1;
      this.lastY = paramFloat2;
      int i;
      if (this.edge == 0)
      {
        boolean bool1 = this.this$0.isModal;
        i = 0;
        if (!bool1);
      }
      else
      {
        i = 1;
      }
      return i;
    }
  }

  public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (!this.this$0.dragging)
      return;
    float f1 = this.this$0.getWidth();
    float f2 = this.this$0.getHeight();
    float f3 = this.this$0.getX();
    float f4 = this.this$0.getY();
    float f5 = this.this$0.getMinWidth();
    this.this$0.getMaxWidth();
    float f6 = this.this$0.getMinHeight();
    this.this$0.getMaxHeight();
    Stage localStage = this.this$0.getStage();
    int i;
    float f7;
    if ((this.this$0.keepWithinStage) && (this.this$0.getParent() == localStage.getRoot()))
    {
      i = 1;
      if ((0x20 & this.edge) != 0)
      {
        float f16 = paramFloat1 - this.startX;
        float f17 = paramFloat2 - this.startY;
        f3 += f16;
        f4 += f17;
      }
      if ((0x8 & this.edge) == 0)
        break label524;
      float f14 = paramFloat1 - this.startX;
      if (f1 - f14 < f5)
        f14 = -(f5 - f1);
      if ((i != 0) && (f3 + f14 < 0.0F))
        f14 = -f3;
      float f15 = f1 - f14;
      f3 += f14;
      f7 = f15;
    }
    while (true)
    {
      float f8;
      if ((0x4 & this.edge) != 0)
      {
        float f12 = paramFloat2 - this.startY;
        if (f2 - f12 < f6)
          f12 = -(f6 - f2);
        if ((i != 0) && (f4 + f12 < 0.0F))
          f12 = -f4;
        float f13 = f2 - f12;
        f4 += f12;
        f8 = f13;
      }
      while (true)
      {
        if ((0x10 & this.edge) != 0)
        {
          float f11 = paramFloat1 - this.lastX;
          if (f7 + f11 < f5)
            f11 = f5 - f7;
          if ((i != 0) && (f11 + (f3 + f7) > localStage.getWidth()))
            f11 = localStage.getWidth() - f3 - f7;
          f7 += f11;
        }
        float f9;
        float f10;
        if ((0x2 & this.edge) != 0)
        {
          f9 = paramFloat2 - this.lastY;
          if (f8 + f9 < f6)
            f9 = f6 - f8;
          if ((i == 0) || (f9 + (f4 + f8) <= localStage.getHeight()))
            break label510;
          f10 = localStage.getHeight() - f4 - f8;
        }
        while (true)
        {
          f8 += f10;
          this.lastX = paramFloat1;
          this.lastY = paramFloat2;
          this.this$0.setBounds(Math.round(f3), Math.round(f4), Math.round(f7), Math.round(f8));
          return;
          i = 0;
          break;
          label510: f10 = f9;
        }
        f8 = f2;
      }
      label524: f7 = f1;
    }
  }

  public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.this$0.dragging = false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Window.3
 * JD-Core Version:    0.6.0
 */