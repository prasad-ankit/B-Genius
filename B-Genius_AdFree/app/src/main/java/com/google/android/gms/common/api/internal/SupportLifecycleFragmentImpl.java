package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.support.v4.app.r;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;

public class SupportLifecycleFragmentImpl extends O
{
  protected final void a(int paramInt, ConnectionResult paramConnectionResult)
  {
    e.a(paramConnectionResult.c(), getActivity(), this, 2, this);
  }

  protected final void b(int paramInt, ConnectionResult paramConnectionResult)
  {
    b.a();
    Dialog localDialog = b.a(getActivity(), this);
    this.a = L.a(getActivity().getApplicationContext(), new a(this, localDialog));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl
 * JD-Core Version:    0.6.0
 */