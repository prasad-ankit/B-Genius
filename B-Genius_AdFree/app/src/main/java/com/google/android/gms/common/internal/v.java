package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.app.w;
import java.util.Arrays;

final class v
{
  private final String a;
  private final ComponentName b;

  public v(String paramString)
  {
    this.a = w.a(paramString);
    this.b = null;
  }

  public final Intent a()
  {
    if (this.a != null)
      return new Intent(this.a).setPackage("com.google.android.gms");
    return new Intent().setComponent(null);
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    v localv;
    do
    {
      return true;
      if (!(paramObject instanceof v))
        return false;
      localv = (v)paramObject;
    }
    while ((f.a(this.a, localv.a)) && (f.a(null, null)));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = null;
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    if (this.a == null)
      return null.flattenToString();
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.v
 * JD-Core Version:    0.6.0
 */