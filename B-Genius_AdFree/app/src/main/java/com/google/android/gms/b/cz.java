package com.google.android.gms.b;

import com.google.android.gms.ads.internal.client.C;
import java.util.List;

final class cz extends C
{
  cz(cy paramcy)
  {
  }

  public final void a()
  {
    cy.a(this.a).add(new cA(this));
  }

  public final void a(int paramInt)
  {
    cy.a(this.a).add(new cB(this, paramInt));
    hc.e("Pooled interstitial failed to load.");
  }

  public final void b()
  {
    cy.a(this.a).add(new cC(this));
  }

  public final void c()
  {
    cy.a(this.a).add(new cD(this));
    hc.e("Pooled interstitial loaded.");
  }

  public final void d()
  {
    cy.a(this.a).add(new cE(this));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cz
 * JD-Core Version:    0.6.0
 */