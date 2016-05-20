package com.google.android.gms.b;

import android.os.Handler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class cy
{
  private final List a = new LinkedList();

  final void a(cX paramcX)
  {
    Handler localHandler = hu.a;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      localHandler.post(new cV(this, (cW)localIterator.next(), paramcX));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cy
 * JD-Core Version:    0.6.0
 */