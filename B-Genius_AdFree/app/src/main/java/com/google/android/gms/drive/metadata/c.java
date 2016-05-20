package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import android.support.v4.app.w;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public abstract class c
  implements a
{
  private final String a;

  protected c(String paramString, int paramInt)
  {
    this.a = ((String)w.a(paramString, "fieldName"));
    Collections.singleton(paramString);
    Collections.emptySet();
  }

  protected c(String paramString, Collection paramCollection1, Collection paramCollection2, int paramInt)
  {
    this.a = ((String)w.a(paramString, "fieldName"));
    Collections.unmodifiableSet(new HashSet(paramCollection1));
    Collections.unmodifiableSet(new HashSet(paramCollection2));
  }

  public final Object a(Bundle paramBundle)
  {
    w.a(paramBundle, "bundle");
    if (paramBundle.get(this.a) != null)
      return b(paramBundle);
    return null;
  }

  protected abstract Object b(Bundle paramBundle);

  public final String d()
  {
    return this.a;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.c
 * JD-Core Version:    0.6.0
 */