package com.badlogic.gdx.utils;

import java.util.Iterator;

public class Predicate$PredicateIterator
  implements Iterator
{
  public boolean end = false;
  public Iterator iterator;
  public Object next = null;
  public boolean peeked = false;
  public Predicate predicate;

  public Predicate$PredicateIterator(Iterable paramIterable, Predicate paramPredicate)
  {
    this(paramIterable.iterator(), paramPredicate);
  }

  public Predicate$PredicateIterator(Iterator paramIterator, Predicate paramPredicate)
  {
    set(paramIterator, paramPredicate);
  }

  public boolean hasNext()
  {
    if (this.end)
      return false;
    if (this.next != null)
      return true;
    this.peeked = true;
    while (this.iterator.hasNext())
    {
      Object localObject = this.iterator.next();
      if (!this.predicate.evaluate(localObject))
        continue;
      this.next = localObject;
      return true;
    }
    this.end = true;
    return false;
  }

  public Object next()
  {
    if ((this.next == null) && (!hasNext()))
      return null;
    Object localObject = this.next;
    this.next = null;
    this.peeked = false;
    return localObject;
  }

  public void remove()
  {
    if (this.peeked)
      throw new GdxRuntimeException("Cannot remove between a call to hasNext() and next().");
    this.iterator.remove();
  }

  public void set(Iterable paramIterable, Predicate paramPredicate)
  {
    set(paramIterable.iterator(), paramPredicate);
  }

  public void set(Iterator paramIterator, Predicate paramPredicate)
  {
    this.iterator = paramIterator;
    this.predicate = paramPredicate;
    this.peeked = false;
    this.end = false;
    this.next = null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Predicate.PredicateIterator
 * JD-Core Version:    0.6.0
 */