package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Iterator;
import java.util.Set;

final class e
{
  static a a(MetadataBundle paramMetadataBundle)
  {
    Set localSet = paramMetadataBundle.a();
    if (localSet.size() != 1)
      throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    return (a)localSet.iterator().next();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.e
 * JD-Core Version:    0.6.0
 */