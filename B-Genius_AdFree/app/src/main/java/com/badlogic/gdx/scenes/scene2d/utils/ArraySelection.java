package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.OrderedSet;
import com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator;
import java.util.Iterator;

public class ArraySelection extends Selection
{
  private Array array;
  private boolean rangeSelect = true;

  public ArraySelection(Array paramArray)
  {
    this.array = paramArray;
  }

  public void choose(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("item cannot be null.");
    if (this.isDisabled)
      return;
    int i;
    int j;
    if ((this.selected.size > 0) && (this.rangeSelect) && (this.multiple) && ((Gdx.input.isKeyPressed(59)) || (Gdx.input.isKeyPressed(60))))
    {
      i = this.array.indexOf(getLastSelected(), false);
      j = this.array.indexOf(paramObject, false);
      if (i <= j)
        break label166;
    }
    while (true)
    {
      snapshot();
      if (!UIUtils.ctrl())
        this.selected.clear();
      while (j <= i)
      {
        this.selected.add(this.array.get(j));
        j++;
      }
      if (fireChangeEvent())
        revert();
      cleanup();
      return;
      super.choose(paramObject);
      return;
      label166: int k = i;
      i = j;
      j = k;
    }
  }

  public boolean getRangeSelect()
  {
    return this.rangeSelect;
  }

  public void setRangeSelect(boolean paramBoolean)
  {
    this.rangeSelect = paramBoolean;
  }

  public void validate()
  {
    Array localArray = this.array;
    if (localArray.size == 0)
      clear();
    do
    {
      return;
      OrderedSet.OrderedSetIterator localOrderedSetIterator = items().iterator();
      while (localOrderedSetIterator.hasNext())
      {
        if (localArray.contains(localOrderedSetIterator.next(), false))
          continue;
        localOrderedSetIterator.remove();
      }
    }
    while ((!this.required) || (this.selected.size != 0));
    set(localArray.first());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.ArraySelection
 * JD-Core Version:    0.6.0
 */