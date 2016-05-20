package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

class SelectBox$SelectBoxList$2 extends ClickListener
{
  public void clicked(InputEvent paramInputEvent, float paramFloat1, float paramFloat2)
  {
    this.val$selectBox.selection.choose(this.this$0.list.getSelected());
    this.this$0.hide();
  }

  public boolean mouseMoved(InputEvent paramInputEvent, float paramFloat1, float paramFloat2)
  {
    this.this$0.list.setSelectedIndex(Math.min(-1 + this.val$selectBox.items.size, (int)((this.this$0.list.getHeight() - paramFloat2) / this.this$0.list.getItemHeight())));
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxList.2
 * JD-Core Version:    0.6.0
 */