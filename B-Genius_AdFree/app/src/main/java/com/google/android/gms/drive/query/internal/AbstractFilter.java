package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.c;

public abstract class AbstractFilter
  implements Filter
{
  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a(new c());
    return String.format("Filter[%s]", arrayOfObject);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.AbstractFilter
 * JD-Core Version:    0.6.0
 */