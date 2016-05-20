package com.badlogic.gdx.utils;

import java.util.Iterator;

public class Predicate$PredicateIterable
  implements Iterable
{
  public Iterable iterable;
  public Predicate.PredicateIterator iterator = null;
  public Predicate predicate;

  public Predicate$PredicateIterable(Iterable paramIterable, Predicate paramPredicate)
  {
    set(paramIterable, paramPredicate);
  }

  public Iterator iterator()
  {
    if (this.iterator == null)
      this.iterator = new Predicate.PredicateIterator(this.iterable.iterator(), this.predicate);
    while (true)
    {
      return this.iterator;
      this.iterator.set(this.iterable.iterator(), this.predicate);
    }
  }

  public void set(Iterable paramIterable, Predicate paramPredicate)
  {
    this.iterable = paramIterable;
    this.predicate = paramPredicate;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Predicate.PredicateIterable
 * JD-Core Version:    0.6.0
 */