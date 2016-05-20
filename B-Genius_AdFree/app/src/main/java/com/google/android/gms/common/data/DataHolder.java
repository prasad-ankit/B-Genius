package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.w;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class DataHolder
  implements SafeParcelable
{
  public static final i CREATOR = new i();
  Bundle a;
  int b;
  private final int c;
  private final String[] d;
  private final CursorWindow[] e;
  private final int f;
  private final Bundle g;
  private int[] h;
  private boolean i = false;
  private Object j;
  private boolean k = true;

  static
  {
    new c(new String[0], null);
  }

  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    this.c = paramInt1;
    this.d = paramArrayOfString;
    this.e = paramArrayOfCursorWindow;
    this.f = paramInt2;
    this.g = paramBundle;
  }

  private void a(String paramString, int paramInt)
  {
    if ((this.a == null) || (!this.a.containsKey(paramString)))
      throw new IllegalArgumentException("No such column: " + paramString);
    if (h())
      throw new IllegalArgumentException("Buffer is closed.");
    if ((paramInt < 0) || (paramInt >= this.b))
      throw new CursorIndexOutOfBoundsException(paramInt, this.b);
  }

  private boolean h()
  {
    monitorenter;
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final int a(int paramInt)
  {
    int m = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.b))
    {
      bool = true;
      w.b(bool);
    }
    while (true)
    {
      if (m < this.h.length)
      {
        if (paramInt < this.h[m])
          m--;
      }
      else
      {
        if (m == this.h.length)
          m--;
        return m;
        bool = false;
        break;
      }
      m++;
    }
  }

  public final long a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.e[paramInt2].getLong(paramInt1, this.a.getInt(paramString));
  }

  public final void a()
  {
    int m = 0;
    this.a = new Bundle();
    for (int n = 0; n < this.d.length; n++)
      this.a.putInt(this.d[n], n);
    this.h = new int[this.e.length];
    int i1 = 0;
    while (m < this.e.length)
    {
      this.h[m] = i1;
      int i2 = i1 - this.e[m].getStartPosition();
      i1 += this.e[m].getNumRows() - i2;
      m++;
    }
    this.b = i1;
  }

  public final void a(Object paramObject)
  {
    this.j = paramObject;
  }

  final int b()
  {
    return this.c;
  }

  public final int b(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.e[paramInt2].getInt(paramInt1, this.a.getInt(paramString));
  }

  public final String c(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.e[paramInt2].getString(paramInt1, this.a.getInt(paramString));
  }

  final String[] c()
  {
    return this.d;
  }

  public final boolean d(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return Long.valueOf(this.e[paramInt2].getLong(paramInt1, this.a.getInt(paramString))).longValue() == 1L;
  }

  final CursorWindow[] d()
  {
    return this.e;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final int e()
  {
    return this.f;
  }

  public final Uri e(String paramString, int paramInt1, int paramInt2)
  {
    String str = c(paramString, paramInt1, paramInt2);
    if (str == null)
      return null;
    return Uri.parse(str);
  }

  public final Bundle f()
  {
    return this.g;
  }

  public final boolean f(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.e[paramInt2].isNull(paramInt1, this.a.getInt(paramString));
  }

  protected final void finalize()
  {
    try
    {
      if ((this.k) && (this.e.length > 0) && (!h()))
        if (this.j != null)
          break label85;
      label85: String str;
      for (Object localObject2 = "internal object: " + toString(); ; localObject2 = str)
      {
        Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (String)localObject2 + ")");
        g();
        return;
        str = this.j.toString();
      }
    }
    finally
    {
      super.finalize();
    }
    throw localObject1;
  }

  public final void g()
  {
    monitorenter;
    try
    {
      if (!this.i)
      {
        this.i = true;
        for (int m = 0; m < this.e.length; m++)
          this.e[m].close();
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder
 * JD-Core Version:    0.6.0
 */