package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.support.v4.a.c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public final class j extends h
  implements c
{
  public static final d a = new k();

  public j(int paramInt)
  {
    super("parents", Collections.emptySet(), Arrays.asList(new String[] { "parentsExtra", "dbInstanceId", "parentsExtraHolder" }), 4100000);
  }

  protected final Collection c(Bundle paramBundle)
  {
    Collection localCollection = super.c(paramBundle);
    if (localCollection == null)
      return null;
    return new HashSet(localCollection);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.j
 * JD-Core Version:    0.6.0
 */