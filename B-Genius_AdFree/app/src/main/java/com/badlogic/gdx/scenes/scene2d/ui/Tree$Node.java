package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;

public class Tree$Node
{
  Actor actor;
  final Array children = new Array(0);
  boolean expanded;
  float height;
  Drawable icon;
  Object object;
  Node parent;
  boolean selectable = true;

  public Tree$Node(Actor paramActor)
  {
    if (paramActor == null)
      throw new IllegalArgumentException("actor cannot be null.");
    this.actor = paramActor;
  }

  public void add(Node paramNode)
  {
    insert(this.children.size, paramNode);
  }

  public void addAll(Array paramArray)
  {
    int i = paramArray.size;
    for (int j = 0; j < i; j++)
      insert(this.children.size, (Node)paramArray.get(j));
  }

  protected void addToTree(Tree paramTree)
  {
    paramTree.addActor(this.actor);
    if (!this.expanded);
    while (true)
    {
      return;
      int i = this.children.size;
      for (int j = 0; j < i; j++)
        ((Node)this.children.get(j)).addToTree(paramTree);
    }
  }

  public void collapseAll()
  {
    setExpanded(false);
    Tree.collapseAll(this.children);
  }

  public void expandAll()
  {
    setExpanded(true);
    if (this.children.size > 0)
      Tree.expandAll(this.children);
  }

  public void expandTo()
  {
    for (Node localNode = this.parent; localNode != null; localNode = localNode.parent)
      localNode.setExpanded(true);
  }

  public void findExpandedObjects(Array paramArray)
  {
    if ((this.expanded) && (!Tree.findExpandedObjects(this.children, paramArray)))
      paramArray.add(this.object);
  }

  public Node findNode(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("object cannot be null.");
    if (paramObject.equals(this.object))
      return this;
    return Tree.findNode(this.children, paramObject);
  }

  public Actor getActor()
  {
    return this.actor;
  }

  public Array getChildren()
  {
    return this.children;
  }

  public Drawable getIcon()
  {
    return this.icon;
  }

  public int getLevel()
  {
    int i = 0;
    do
    {
      i++;
      this = getParent();
    }
    while (this != null);
    return i;
  }

  public Object getObject()
  {
    return this.object;
  }

  public Node getParent()
  {
    return this.parent;
  }

  public Tree getTree()
  {
    Group localGroup = this.actor.getParent();
    if (!(localGroup instanceof Tree))
      return null;
    return (Tree)localGroup;
  }

  public void insert(int paramInt, Node paramNode)
  {
    paramNode.parent = this;
    this.children.insert(paramInt, paramNode);
    updateChildren();
  }

  public boolean isExpanded()
  {
    return this.expanded;
  }

  public boolean isSelectable()
  {
    return this.selectable;
  }

  public void remove()
  {
    Tree localTree = getTree();
    if (localTree != null)
      localTree.remove(this);
    do
      return;
    while (this.parent == null);
    this.parent.remove(this);
  }

  public void remove(Node paramNode)
  {
    this.children.removeValue(paramNode, true);
    if (!this.expanded);
    do
    {
      Tree localTree;
      do
      {
        return;
        localTree = getTree();
      }
      while (localTree == null);
      paramNode.removeFromTree(localTree);
    }
    while (this.children.size != 0);
    this.expanded = false;
  }

  public void removeAll()
  {
    Tree localTree = getTree();
    if (localTree != null)
    {
      int i = this.children.size;
      for (int j = 0; j < i; j++)
        ((Node)this.children.get(j)).removeFromTree(localTree);
    }
    this.children.clear();
  }

  protected void removeFromTree(Tree paramTree)
  {
    paramTree.removeActor(this.actor);
    if (!this.expanded);
    while (true)
    {
      return;
      int i = this.children.size;
      for (int j = 0; j < i; j++)
        ((Node)this.children.get(j)).removeFromTree(paramTree);
    }
  }

  public void restoreExpandedObjects(Array paramArray)
  {
    int i = 0;
    int j = paramArray.size;
    while (i < j)
    {
      Node localNode = findNode(paramArray.get(i));
      if (localNode != null)
      {
        localNode.setExpanded(true);
        localNode.expandTo();
      }
      i++;
    }
  }

  public void setExpanded(boolean paramBoolean)
  {
    if (paramBoolean == this.expanded);
    Tree localTree;
    do
    {
      do
      {
        return;
        this.expanded = paramBoolean;
      }
      while (this.children.size == 0);
      localTree = getTree();
    }
    while (localTree == null);
    if (paramBoolean)
    {
      int k = this.children.size;
      for (int m = 0; m < k; m++)
        ((Node)this.children.get(m)).addToTree(localTree);
    }
    int i = this.children.size;
    for (int j = 0; j < i; j++)
      ((Node)this.children.get(j)).removeFromTree(localTree);
    localTree.invalidateHierarchy();
  }

  public void setIcon(Drawable paramDrawable)
  {
    this.icon = paramDrawable;
  }

  public void setObject(Object paramObject)
  {
    this.object = paramObject;
  }

  public void setSelectable(boolean paramBoolean)
  {
    this.selectable = paramBoolean;
  }

  public void updateChildren()
  {
    if (!this.expanded);
    while (true)
    {
      return;
      Tree localTree = getTree();
      if (localTree == null)
        continue;
      int i = this.children.size;
      for (int j = 0; j < i; j++)
        ((Node)this.children.get(j)).addToTree(localTree);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Tree.Node
 * JD-Core Version:    0.6.0
 */