package com.google.android.gms.b;

final class dc
  implements Runnable
{
  private final iR a;
  private final jq b;
  private final Runnable c;

  public dc(jx paramjx, iR paramiR, jq paramjq, Runnable paramRunnable)
  {
    this.a = paramiR;
    this.b = paramjq;
    this.c = paramRunnable;
  }

  public final void run()
  {
    int i;
    if (this.b.c == null)
    {
      i = 1;
      if (i == 0)
        break label76;
      this.a.a(this.b.a);
      label35: if (!this.b.d)
        break label93;
      this.a.a("intermediate-response");
    }
    while (true)
    {
      if (this.c != null)
        this.c.run();
      return;
      i = 0;
      break;
      label76: this.a.b(this.b.c);
      break label35;
      label93: this.a.b("done");
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.dc
 * JD-Core Version:    0.6.0
 */