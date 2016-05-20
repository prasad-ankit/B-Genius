package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class g
{
  private static final Set a = Collections.newSetFromMap(new WeakHashMap());

  public Looper a()
  {
    throw new UnsupportedOperationException();
  }

  public e a(f paramf)
  {
    throw new UnsupportedOperationException();
  }

  public b a(b paramb)
  {
    throw new UnsupportedOperationException();
  }

  public abstract void a(k paramk);

  public abstract void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);

  public boolean a(a parama)
  {
    throw new UnsupportedOperationException();
  }

  public b b(b paramb)
  {
    throw new UnsupportedOperationException();
  }

  public abstract void b();

  public abstract void b(k paramk);

  public abstract boolean b(a parama);

  public abstract void c();

  public abstract boolean d();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.g
 * JD-Core Version:    0.6.0
 */