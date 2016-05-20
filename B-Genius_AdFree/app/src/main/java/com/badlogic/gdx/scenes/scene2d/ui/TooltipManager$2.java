package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer.Task;

class TooltipManager$2 extends Timer.Task
{
  public void run()
  {
    if (this.this$0.showTooltip == null);
    do
    {
      Stage localStage;
      do
      {
        return;
        localStage = this.this$0.showTooltip.targetActor.getStage();
      }
      while (localStage == null);
      localStage.addActor(this.this$0.showTooltip.container);
      this.this$0.showTooltip.container.toFront();
      this.this$0.shown.add(this.this$0.showTooltip);
      this.this$0.showTooltip.container.clearActions();
      this.this$0.showAction(this.this$0.showTooltip);
    }
    while (this.this$0.showTooltip.instant);
    this.this$0.time = this.this$0.subsequentTime;
    this.this$0.resetTask.cancel();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TooltipManager.2
 * JD-Core Version:    0.6.0
 */