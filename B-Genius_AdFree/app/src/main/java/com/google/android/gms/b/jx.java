package com.google.android.gms.b;

import android.os.Handler;
import java.util.concurrent.Executor;

public class jx
{
  private final Executor a;

  public jx(Handler paramHandler)
  {
    this.a = new db(this, paramHandler);
  }

  public void a(iR paramiR, jq paramjq)
  {
    a(paramiR, paramjq, null);
  }

  public void a(iR paramiR, jq paramjq, Runnable paramRunnable)
  {
    paramiR.m();
    paramiR.a("post-response");
    this.a.execute(new dc(this, paramiR, paramjq, paramRunnable));
  }

  public void a(iR paramiR, kb paramkb)
  {
    paramiR.a("post-error");
    jq localjq = jq.a(paramkb);
    this.a.execute(new dc(this, paramiR, localjq, null));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jx
 * JD-Core Version:    0.6.0
 */