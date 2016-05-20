package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Tree$TreeStyle
{
  public Drawable background;
  public Drawable minus;
  public Drawable over;
  public Drawable plus;
  public Drawable selection;

  public Tree$TreeStyle()
  {
  }

  public Tree$TreeStyle(TreeStyle paramTreeStyle)
  {
    this.plus = paramTreeStyle.plus;
    this.minus = paramTreeStyle.minus;
    this.selection = paramTreeStyle.selection;
  }

  public Tree$TreeStyle(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    this.plus = paramDrawable1;
    this.minus = paramDrawable2;
    this.selection = paramDrawable3;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Tree.TreeStyle
 * JD-Core Version:    0.6.0
 */