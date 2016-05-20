package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

class SelectBox$1 extends ClickListener
{
  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 != 0));
    do
      return false;
    while (this.this$0.disabled);
    if (this.this$0.selectBoxList.hasParent())
      this.this$0.hideList();
    while (true)
    {
      return true;
      this.this$0.showList();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.SelectBox.1
 * JD-Core Version:    0.6.0
 */