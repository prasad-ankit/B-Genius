package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class JsonValue$JsonIterator
  implements Iterable, Iterator
{
  JsonValue current;
  JsonValue entry = this.this$0.child;

  public JsonValue$JsonIterator(JsonValue paramJsonValue)
  {
  }

  public boolean hasNext()
  {
    return this.entry != null;
  }

  public Iterator iterator()
  {
    return this;
  }

  public JsonValue next()
  {
    this.current = this.entry;
    if (this.current == null)
      throw new NoSuchElementException();
    this.entry = this.current.next;
    return this.current;
  }

  public void remove()
  {
    if (this.current.prev == null)
    {
      this.this$0.child = this.current.next;
      if (this.this$0.child != null)
        this.this$0.child.prev = null;
    }
    while (true)
    {
      JsonValue localJsonValue = this.this$0;
      localJsonValue.size = (-1 + localJsonValue.size);
      return;
      this.current.prev.next = this.current.next;
      if (this.current.next == null)
        continue;
      this.current.next.prev = this.current.prev;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.JsonValue.JsonIterator
 * JD-Core Version:    0.6.0
 */