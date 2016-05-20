package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.data.DataHolder;

public abstract class j
  implements o, p
{
  private Status a;
  private DataHolder b;

  protected j(DataHolder paramDataHolder, Status paramStatus)
  {
    this.a = paramStatus;
    this.b = paramDataHolder;
  }

  public final void a()
  {
    if (this.b != null)
      this.b.g();
  }

  public final Status b()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.j
 * JD-Core Version:    0.6.0
 */