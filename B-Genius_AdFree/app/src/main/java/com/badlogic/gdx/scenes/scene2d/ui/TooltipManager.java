package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import java.util.Iterator;

public class TooltipManager
{
  private static Application app;
  private static TooltipManager instance;
  public boolean animations = true;
  public float edgeDistance = 7.0F;
  public boolean enabled = true;
  public float initialTime = 2.0F;
  public float maxWidth = 2.147484E+009F;
  public float offsetX = 15.0F;
  public float offsetY = 19.0F;
  final Timer.Task resetTask = new TooltipManager.1(this);
  public float resetTime = 1.5F;
  final Timer.Task showTask = new TooltipManager.2(this);
  Tooltip showTooltip;
  final Array shown = new Array();
  public float subsequentTime = 0.0F;
  float time = this.initialTime;

  public static TooltipManager getInstance()
  {
    if ((app == null) || (app != Gdx.app))
    {
      app = Gdx.app;
      instance = new TooltipManager();
    }
    return instance;
  }

  public void enter(Tooltip paramTooltip)
  {
    this.showTooltip = paramTooltip;
    this.showTask.cancel();
    if ((this.enabled) || (paramTooltip.always))
    {
      if ((this.time == 0.0F) || (paramTooltip.instant))
        this.showTask.run();
    }
    else
      return;
    Timer.schedule(this.showTask, this.time);
  }

  public void hide(Tooltip paramTooltip)
  {
    this.showTooltip = null;
    this.showTask.cancel();
    if (paramTooltip.container.hasParent())
    {
      this.shown.removeValue(paramTooltip, true);
      hideAction(paramTooltip);
      this.resetTask.cancel();
      Timer.schedule(this.resetTask, this.resetTime);
    }
  }

  protected void hideAction(Tooltip paramTooltip)
  {
    paramTooltip.container.addAction(Actions.sequence(Actions.parallel(Actions.alpha(0.2F, 0.2F, Interpolation.fade), Actions.scaleTo(0.05F, 0.05F, 0.2F, Interpolation.fade)), Actions.removeActor()));
  }

  public void hideAll()
  {
    Iterator localIterator = this.shown.iterator();
    while (localIterator.hasNext())
      ((Tooltip)localIterator.next()).hide();
    this.shown.clear();
  }

  public void instant()
  {
    this.time = 0.0F;
    this.showTask.run();
    this.showTask.cancel();
  }

  protected void showAction(Tooltip paramTooltip)
  {
    float f;
    if (this.animations)
      if (this.time > 0.0F)
        f = 0.5F;
    while (true)
    {
      paramTooltip.container.setTransform(true);
      paramTooltip.container.getColor().a = 0.2F;
      paramTooltip.container.setScale(0.05F);
      paramTooltip.container.addAction(Actions.parallel(Actions.fadeIn(f, Interpolation.fade), Actions.scaleTo(1.0F, 1.0F, f, Interpolation.fade)));
      return;
      f = 0.15F;
      continue;
      f = 0.1F;
    }
  }

  public void touchDown(Tooltip paramTooltip)
  {
    this.showTask.cancel();
    if (paramTooltip.container.remove())
      this.resetTask.cancel();
    this.resetTask.run();
    if ((this.enabled) || (paramTooltip.always))
    {
      this.showTooltip = paramTooltip;
      Timer.schedule(this.showTask, this.time);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TooltipManager
 * JD-Core Version:    0.6.0
 */