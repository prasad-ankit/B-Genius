package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.scenes.scene2d.utils.Selection;
import com.badlogic.gdx.utils.Array;

public class Tree extends WidgetGroup
{
  private ClickListener clickListener;
  private Tree.Node foundNode;
  float iconSpacingLeft = 2.0F;
  float iconSpacingRight = 2.0F;
  float indentSpacing;
  private float leftColumnWidth;
  Tree.Node overNode;
  float padding = 0.0F;
  private float prefHeight;
  private float prefWidth;
  final Array rootNodes = new Array();
  final Selection selection = new Selection();
  private boolean sizeInvalid = true;
  Tree.TreeStyle style;
  float ySpacing = 4.0F;

  public Tree(Skin paramSkin)
  {
    this((Tree.TreeStyle)paramSkin.get(Tree.TreeStyle.class));
  }

  public Tree(Skin paramSkin, String paramString)
  {
    this((Tree.TreeStyle)paramSkin.get(paramString, Tree.TreeStyle.class));
  }

  public Tree(Tree.TreeStyle paramTreeStyle)
  {
    this.selection.setActor(this);
    this.selection.setMultiple(true);
    setStyle(paramTreeStyle);
    initialize();
  }

  static void collapseAll(Array paramArray)
  {
    int i = paramArray.size;
    for (int j = 0; j < i; j++)
    {
      Tree.Node localNode = (Tree.Node)paramArray.get(j);
      localNode.setExpanded(false);
      collapseAll(localNode.children);
    }
  }

  private void computeSize()
  {
    this.sizeInvalid = false;
    this.prefWidth = this.style.plus.getMinWidth();
    this.prefWidth = Math.max(this.prefWidth, this.style.minus.getMinWidth());
    this.prefHeight = getHeight();
    this.leftColumnWidth = 0.0F;
    computeSize(this.rootNodes, this.indentSpacing);
    this.leftColumnWidth += this.iconSpacingLeft + this.padding;
    this.prefWidth += this.leftColumnWidth + this.padding;
    this.prefHeight = (getHeight() - this.prefHeight);
  }

  private void computeSize(Array paramArray, float paramFloat)
  {
    float f1 = this.ySpacing;
    float f2 = this.iconSpacingLeft + this.iconSpacingRight;
    int i = paramArray.size;
    int j = 0;
    if (j < i)
    {
      Tree.Node localNode = (Tree.Node)paramArray.get(j);
      float f3 = paramFloat + this.iconSpacingRight;
      Actor localActor = localNode.actor;
      float f5;
      if ((localActor instanceof Layout))
      {
        Layout localLayout = (Layout)localActor;
        float f6 = f3 + localLayout.getPrefWidth();
        localNode.height = localLayout.getPrefHeight();
        localLayout.pack();
        f5 = f6;
      }
      while (true)
      {
        if (localNode.icon != null)
        {
          f5 += f2 + localNode.icon.getMinWidth();
          localNode.height = Math.max(localNode.height, localNode.icon.getMinHeight());
        }
        this.prefWidth = Math.max(this.prefWidth, f5);
        this.prefHeight -= f1 + localNode.height;
        if (localNode.expanded)
          computeSize(localNode.children, paramFloat + this.indentSpacing);
        j++;
        break;
        float f4 = f3 + localActor.getWidth();
        localNode.height = localActor.getHeight();
        f5 = f4;
      }
    }
  }

  private void draw(Batch paramBatch, Array paramArray, float paramFloat)
  {
    Drawable localDrawable1 = this.style.plus;
    Drawable localDrawable2 = this.style.minus;
    float f1 = getX();
    float f2 = getY();
    int i = paramArray.size;
    int j = 0;
    if (j < i)
    {
      Tree.Node localNode = (Tree.Node)paramArray.get(j);
      Actor localActor = localNode.actor;
      if ((this.selection.contains(localNode)) && (this.style.selection != null))
      {
        this.style.selection.draw(paramBatch, f1, f2 + localActor.getY() - this.ySpacing / 2.0F, getWidth(), localNode.height + this.ySpacing);
        label130: if (localNode.icon != null)
        {
          float f4 = localActor.getY() + Math.round((localNode.height - localNode.icon.getMinHeight()) / 2.0F);
          paramBatch.setColor(localActor.getColor());
          localNode.icon.draw(paramBatch, f1 + localNode.actor.getX() - this.iconSpacingRight - localNode.icon.getMinWidth(), f2 + f4, localNode.icon.getMinWidth(), localNode.icon.getMinHeight());
          paramBatch.setColor(Color.WHITE);
        }
        if (localNode.children.size != 0)
          if (!localNode.expanded)
            break label433;
      }
      label433: for (Drawable localDrawable3 = localDrawable2; ; localDrawable3 = localDrawable1)
      {
        float f3 = localActor.getY() + Math.round((localNode.height - localDrawable3.getMinHeight()) / 2.0F);
        localDrawable3.draw(paramBatch, f1 + paramFloat - this.iconSpacingLeft, f2 + f3, localDrawable3.getMinWidth(), localDrawable3.getMinHeight());
        if (localNode.expanded)
          draw(paramBatch, localNode.children, paramFloat + this.indentSpacing);
        j++;
        break;
        if ((localNode != this.overNode) || (this.style.over == null))
          break label130;
        this.style.over.draw(paramBatch, f1, f2 + localActor.getY() - this.ySpacing / 2.0F, getWidth(), localNode.height + this.ySpacing);
        break label130;
      }
    }
  }

  static void expandAll(Array paramArray)
  {
    int i = paramArray.size;
    for (int j = 0; j < i; j++)
      ((Tree.Node)paramArray.get(j)).expandAll();
  }

  static boolean findExpandedObjects(Array paramArray1, Array paramArray2)
  {
    int i = paramArray1.size;
    for (int j = 0; j < i; j++)
    {
      Tree.Node localNode = (Tree.Node)paramArray1.get(j);
      if ((!localNode.expanded) || (findExpandedObjects(localNode.children, paramArray2)))
        continue;
      paramArray2.add(localNode.object);
    }
    return false;
  }

  static Tree.Node findNode(Array paramArray, Object paramObject)
  {
    int i = 0;
    int j = paramArray.size;
    Tree.Node localNode;
    for (int k = 0; k < j; k++)
    {
      localNode = (Tree.Node)paramArray.get(k);
      if (paramObject.equals(localNode.object))
        return localNode;
    }
    int m = paramArray.size;
    while (true)
    {
      if (i >= m)
        break label88;
      localNode = findNode(((Tree.Node)paramArray.get(i)).children, paramObject);
      if (localNode != null)
        break;
      i++;
    }
    label88: return null;
  }

  private float getNodeAt(Array paramArray, float paramFloat1, float paramFloat2)
  {
    int i = paramArray.size;
    int j = 0;
    float f1 = paramFloat2;
    while (j < i)
    {
      Tree.Node localNode = (Tree.Node)paramArray.get(j);
      if ((paramFloat1 >= f1 - localNode.height - this.ySpacing) && (paramFloat1 < f1))
      {
        this.foundNode = localNode;
        return -1.0F;
      }
      float f2 = f1 - (localNode.height + this.ySpacing);
      float f3;
      if (localNode.expanded)
      {
        f3 = getNodeAt(localNode.children, paramFloat1, f2);
        if (f3 == -1.0F)
          return -1.0F;
      }
      else
      {
        f3 = f2;
      }
      j++;
      f1 = f3;
    }
    return f1;
  }

  private void initialize()
  {
    Tree.1 local1 = new Tree.1(this);
    this.clickListener = local1;
    addListener(local1);
  }

  private float layout(Array paramArray, float paramFloat1, float paramFloat2)
  {
    float f1 = this.ySpacing;
    int i = paramArray.size;
    int j = 0;
    Tree.Node localNode;
    float f2;
    if (j < i)
    {
      localNode = (Tree.Node)paramArray.get(j);
      if (localNode.icon == null)
        break label128;
      f2 = paramFloat1 + localNode.icon.getMinWidth();
    }
    while (true)
    {
      float f3 = paramFloat2 - localNode.height;
      localNode.actor.setPosition(f2, f3);
      float f4 = f3 - f1;
      float f5;
      if (localNode.expanded)
        f5 = layout(localNode.children, paramFloat1 + this.indentSpacing, f4);
      while (true)
      {
        j++;
        paramFloat2 = f5;
        break;
        return paramFloat2;
        f5 = f4;
      }
      label128: f2 = paramFloat1;
    }
  }

  public void add(Tree.Node paramNode)
  {
    insert(this.rootNodes.size, paramNode);
  }

  public void clearChildren()
  {
    super.clearChildren();
    setOverNode(null);
    this.rootNodes.clear();
    this.selection.clear();
  }

  public void collapseAll()
  {
    collapseAll(this.rootNodes);
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    Color localColor = getColor();
    paramBatch.setColor(localColor.r, localColor.g, localColor.b, paramFloat * localColor.a);
    if (this.style.background != null)
      this.style.background.draw(paramBatch, getX(), getY(), getWidth(), getHeight());
    draw(paramBatch, this.rootNodes, this.leftColumnWidth);
    super.draw(paramBatch, paramFloat);
  }

  public void expandAll()
  {
    expandAll(this.rootNodes);
  }

  public void findExpandedObjects(Array paramArray)
  {
    findExpandedObjects(this.rootNodes, paramArray);
  }

  public Tree.Node findNode(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("object cannot be null.");
    return findNode(this.rootNodes, paramObject);
  }

  public ClickListener getClickListener()
  {
    return this.clickListener;
  }

  public float getIndentSpacing()
  {
    return this.indentSpacing;
  }

  public Tree.Node getNodeAt(float paramFloat)
  {
    this.foundNode = null;
    getNodeAt(this.rootNodes, paramFloat, getHeight());
    return this.foundNode;
  }

  public Array getNodes()
  {
    return this.rootNodes;
  }

  public Tree.Node getOverNode()
  {
    return this.overNode;
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

  public Array getRootNodes()
  {
    return this.rootNodes;
  }

  public Selection getSelection()
  {
    return this.selection;
  }

  public Tree.TreeStyle getStyle()
  {
    return this.style;
  }

  public void insert(int paramInt, Tree.Node paramNode)
  {
    remove(paramNode);
    paramNode.parent = null;
    this.rootNodes.insert(paramInt, paramNode);
    paramNode.addToTree(this);
    invalidateHierarchy();
  }

  public void invalidate()
  {
    super.invalidate();
    this.sizeInvalid = true;
  }

  public void layout()
  {
    if (this.sizeInvalid)
      computeSize();
    layout(this.rootNodes, this.leftColumnWidth + this.indentSpacing + this.iconSpacingRight, getHeight() - this.ySpacing / 2.0F);
  }

  public void remove(Tree.Node paramNode)
  {
    if (paramNode.parent != null)
    {
      paramNode.parent.remove(paramNode);
      return;
    }
    this.rootNodes.removeValue(paramNode, true);
    paramNode.removeFromTree(this);
    invalidateHierarchy();
  }

  public void restoreExpandedObjects(Array paramArray)
  {
    int i = 0;
    int j = paramArray.size;
    while (i < j)
    {
      Tree.Node localNode = findNode(paramArray.get(i));
      if (localNode != null)
      {
        localNode.setExpanded(true);
        localNode.expandTo();
      }
      i++;
    }
  }

  void selectNodes(Array paramArray, float paramFloat1, float paramFloat2)
  {
    int i = paramArray.size;
    for (int j = 0; j < i; j++)
    {
      Tree.Node localNode = (Tree.Node)paramArray.get(j);
      if (localNode.actor.getY() < paramFloat1)
        break;
      if (!localNode.isSelectable())
        continue;
      if (localNode.actor.getY() <= paramFloat2)
        this.selection.add(localNode);
      if (!localNode.expanded)
        continue;
      selectNodes(localNode.children, paramFloat1, paramFloat2);
    }
  }

  public void setIconSpacing(float paramFloat1, float paramFloat2)
  {
    this.iconSpacingLeft = paramFloat1;
    this.iconSpacingRight = paramFloat2;
  }

  public void setOverNode(Tree.Node paramNode)
  {
    this.overNode = paramNode;
  }

  public void setPadding(float paramFloat)
  {
    this.padding = paramFloat;
  }

  public void setStyle(Tree.TreeStyle paramTreeStyle)
  {
    this.style = paramTreeStyle;
    this.indentSpacing = (Math.max(paramTreeStyle.plus.getMinWidth(), paramTreeStyle.minus.getMinWidth()) + this.iconSpacingLeft);
  }

  public void setYSpacing(float paramFloat)
  {
    this.ySpacing = paramFloat;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Tree
 * JD-Core Version:    0.6.0
 */