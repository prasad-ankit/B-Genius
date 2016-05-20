package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Selection;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;

class Tree$1 extends ClickListener
{
  public void clicked(InputEvent paramInputEvent, float paramFloat1, float paramFloat2)
  {
    Tree.Node localNode = this.this$0.getNodeAt(paramFloat2);
    if (localNode == null);
    do
    {
      do
        return;
      while (localNode != this.this$0.getNodeAt(getTouchDownY()));
      if ((this.this$0.selection.getMultiple()) && (this.this$0.selection.hasItems()) && (UIUtils.shift()))
      {
        float f2 = ((Tree.Node)this.this$0.selection.getLastSelected()).actor.getY();
        float f3 = localNode.actor.getY();
        if (!UIUtils.ctrl())
          this.this$0.selection.clear();
        if (f2 > f3)
          this.this$0.selectNodes(this.this$0.rootNodes, f3, f2);
        while (true)
        {
          this.this$0.selection.fireChangeEvent();
          return;
          this.this$0.selectNodes(this.this$0.rootNodes, f2, f3);
        }
      }
      if ((localNode.children.size <= 0) || ((this.this$0.selection.getMultiple()) && (UIUtils.ctrl())))
        continue;
      float f1 = localNode.actor.getX();
      if (localNode.icon != null)
        f1 -= this.this$0.iconSpacingRight + localNode.icon.getMinWidth();
      if (paramFloat1 >= f1)
        continue;
      if (!localNode.expanded);
      for (boolean bool = true; ; bool = false)
      {
        localNode.setExpanded(bool);
        return;
      }
    }
    while (!localNode.isSelectable());
    this.this$0.selection.choose(localNode);
  }

  public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, Actor paramActor)
  {
    super.exit(paramInputEvent, paramFloat1, paramFloat2, paramInt, paramActor);
    if ((paramActor == null) || (!paramActor.isDescendantOf(this.this$0)))
      this.this$0.setOverNode(null);
  }

  public boolean mouseMoved(InputEvent paramInputEvent, float paramFloat1, float paramFloat2)
  {
    this.this$0.setOverNode(this.this$0.getNodeAt(paramFloat2));
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Tree.1
 * JD-Core Version:    0.6.0
 */