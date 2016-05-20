package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.b;
import java.lang.ref.WeakReference;

final class t extends b
{
  private final WeakReference a;

  t(n paramn)
  {
    this.a = new WeakReference(paramn);
  }

  public final void a(SignInResponse paramSignInResponse)
  {
    n localn = (n)this.a.get();
    if (localn == null)
      return;
    n.d(localn).a(new u(this, localn, localn, paramSignInResponse));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.t
 * JD-Core Version:    0.6.0
 */