package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.OrderedSet;
import com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator;
import com.badlogic.gdx.utils.Pools;
import java.util.Iterator;

public class Selection
  implements Disableable, Iterable
{
  private Actor actor;
  boolean isDisabled;
  Object lastSelected;
  boolean multiple;
  private final OrderedSet old = new OrderedSet();
  private boolean programmaticChangeEvents = true;
  boolean required;
  final OrderedSet selected = new OrderedSet();
  private boolean toggle;

  public void add(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("item cannot be null.");
    if (!this.selected.add(paramObject))
      return;
    if ((this.programmaticChangeEvents) && (fireChangeEvent()))
    {
      this.selected.remove(paramObject);
      return;
    }
    this.lastSelected = paramObject;
  }

  public void addAll(Array paramArray)
  {
    int i = 0;
    snapshot();
    int j = paramArray.size;
    for (int k = 0; k < j; k++)
    {
      Object localObject = paramArray.get(k);
      if (localObject == null)
        throw new IllegalArgumentException("item cannot be null.");
      if (!this.selected.add(localObject))
        continue;
      i = 1;
    }
    if ((i != 0) && (this.programmaticChangeEvents) && (fireChangeEvent()))
      revert();
    while (true)
    {
      cleanup();
      return;
      this.lastSelected = paramArray.peek();
    }
  }

  public void choose(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("item cannot be null.");
    if (this.isDisabled)
      return;
    snapshot();
    try
    {
      if (((this.toggle) || ((!this.required) && (this.selected.size == 1)) || (UIUtils.ctrl())) && (this.selected.contains(paramObject)))
      {
        if (this.required)
        {
          int k = this.selected.size;
          if (k == 1)
            return;
        }
        this.selected.remove(paramObject);
      }
      for (this.lastSelected = null; ; this.lastSelected = paramObject)
      {
        if (fireChangeEvent())
          revert();
        return;
        int j;
        if (this.multiple)
        {
          boolean bool3 = this.toggle;
          j = 0;
          if (!bool3)
          {
            boolean bool4 = UIUtils.ctrl();
            j = 0;
            if (bool4);
          }
        }
        else
        {
          if (this.selected.size == 1)
          {
            boolean bool2 = this.selected.contains(paramObject);
            if (bool2)
              return;
          }
          int i = this.selected.size;
          j = 0;
          if (i > 0)
            j = 1;
          this.selected.clear();
        }
        boolean bool1 = this.selected.add(paramObject);
        if ((!bool1) && (j == 0))
          return;
      }
    }
    finally
    {
      cleanup();
    }
    throw localObject;
  }

  void cleanup()
  {
    this.old.clear(32);
  }

  public void clear()
  {
    if (this.selected.size == 0)
      return;
    snapshot();
    this.selected.clear();
    if ((this.programmaticChangeEvents) && (fireChangeEvent()))
      revert();
    while (true)
    {
      cleanup();
      return;
      this.lastSelected = null;
    }
  }

  public boolean contains(Object paramObject)
  {
    if (paramObject == null)
      return false;
    return this.selected.contains(paramObject);
  }

  public boolean fireChangeEvent()
  {
    if (this.actor == null)
      return false;
    ChangeListener.ChangeEvent localChangeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
    try
    {
      boolean bool = this.actor.fire(localChangeEvent);
      return bool;
    }
    finally
    {
      Pools.free(localChangeEvent);
    }
    throw localObject;
  }

  public Object first()
  {
    if (this.selected.size == 0)
      return null;
    return this.selected.first();
  }

  public Object getLastSelected()
  {
    if (this.lastSelected != null)
      return this.lastSelected;
    if (this.selected.size > 0)
      return this.selected.first();
    return null;
  }

  public boolean getMultiple()
  {
    return this.multiple;
  }

  public boolean getRequired()
  {
    return this.required;
  }

  public boolean getToggle()
  {
    return this.toggle;
  }

  public boolean hasItems()
  {
    return this.selected.size > 0;
  }

  public boolean isDisabled()
  {
    return this.isDisabled;
  }

  public boolean isEmpty()
  {
    return this.selected.size == 0;
  }

  public OrderedSet items()
  {
    return this.selected;
  }

  public Iterator iterator()
  {
    return this.selected.iterator();
  }

  public void remove(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("item cannot be null.");
    if (!this.selected.remove(paramObject))
      return;
    if ((this.programmaticChangeEvents) && (fireChangeEvent()))
    {
      this.selected.add(paramObject);
      return;
    }
    this.lastSelected = null;
  }

  public void removeAll(Array paramArray)
  {
    int i = 0;
    snapshot();
    int j = paramArray.size;
    for (int k = 0; k < j; k++)
    {
      Object localObject = paramArray.get(k);
      if (localObject == null)
        throw new IllegalArgumentException("item cannot be null.");
      if (!this.selected.remove(localObject))
        continue;
      i = 1;
    }
    if ((i != 0) && (this.programmaticChangeEvents) && (fireChangeEvent()))
      revert();
    while (true)
    {
      cleanup();
      return;
      this.lastSelected = null;
    }
  }

  void revert()
  {
    this.selected.clear();
    this.selected.addAll(this.old);
  }

  public void set(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("item cannot be null.");
    if ((this.selected.size == 1) && (this.selected.first() == paramObject))
      return;
    snapshot();
    this.selected.clear();
    this.selected.add(paramObject);
    if ((this.programmaticChangeEvents) && (fireChangeEvent()))
      revert();
    while (true)
    {
      cleanup();
      return;
      this.lastSelected = paramObject;
    }
  }

  public void setActor(Actor paramActor)
  {
    this.actor = paramActor;
  }

  public void setAll(Array paramArray)
  {
    int i = 0;
    snapshot();
    this.selected.clear();
    int j = paramArray.size;
    for (int k = 0; k < j; k++)
    {
      Object localObject = paramArray.get(k);
      if (localObject == null)
        throw new IllegalArgumentException("item cannot be null.");
      if (!this.selected.add(localObject))
        continue;
      i = 1;
    }
    if ((i != 0) && (this.programmaticChangeEvents) && (fireChangeEvent()))
      revert();
    while (true)
    {
      cleanup();
      return;
      this.lastSelected = paramArray.peek();
    }
  }

  public void setDisabled(boolean paramBoolean)
  {
    this.isDisabled = paramBoolean;
  }

  public void setMultiple(boolean paramBoolean)
  {
    this.multiple = paramBoolean;
  }

  public void setProgrammaticChangeEvents(boolean paramBoolean)
  {
    this.programmaticChangeEvents = paramBoolean;
  }

  public void setRequired(boolean paramBoolean)
  {
    this.required = paramBoolean;
  }

  public void setToggle(boolean paramBoolean)
  {
    this.toggle = paramBoolean;
  }

  public int size()
  {
    return this.selected.size;
  }

  void snapshot()
  {
    this.old.clear();
    this.old.addAll(this.selected);
  }

  public Array toArray()
  {
    return this.selected.iterator().toArray();
  }

  public Array toArray(Array paramArray)
  {
    return this.selected.iterator().toArray(paramArray);
  }

  public String toString()
  {
    return this.selected.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.Selection
 * JD-Core Version:    0.6.0
 */