package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.i;

public final class q extends i
{
  public q(Context paramContext, Looper paramLooper, j paramj, k paramk, int paramInt)
  {
    super(paramContext, paramLooper, 8, new h(paramContext).a(), paramj, paramk);
  }

  protected final String a()
  {
    return "com.google.android.gms.ads.service.START";
  }

  protected final String b()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }

  public final v c()
  {
    return (v)super.o();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.q
 * JD-Core Version:    0.6.0
 */