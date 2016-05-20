package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

class h extends ViewGroup
{
  private final com.google.android.gms.ads.internal.client.d a = new com.google.android.gms.ads.internal.client.d(this, false);

  public h(Context paramContext, int paramInt)
  {
    super(paramContext);
  }

  public void a()
  {
    this.a.d();
  }

  public void a(a parama)
  {
    this.a.a(parama);
    if ((parama != null) && ((parama instanceof com.google.android.gms.ads.internal.client.a)))
      this.a.a((com.google.android.gms.ads.internal.client.a)parama);
    do
      return;
    while (parama != null);
    this.a.a(null);
  }

  public void a(d paramd)
  {
    this.a.a(paramd.a());
  }

  public void a(f paramf)
  {
    this.a.a(new f[] { paramf });
  }

  public void a(String paramString)
  {
    this.a.a(paramString);
  }

  public void b()
  {
    this.a.c();
  }

  public f c()
  {
    return this.a.b();
  }

  public void d()
  {
    this.a.a();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      int k = (paramInt3 - paramInt1 - i) / 2;
      int m = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(k, m, i + k, j + m);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(0);
    int j;
    int i;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      measureChild(localView, paramInt1, paramInt2);
      j = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
    }
    while (true)
    {
      int k = Math.max(j, getSuggestedMinimumWidth());
      int m = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(k, paramInt1), View.resolveSize(m, paramInt2));
      return;
      f localf = c();
      if (localf != null)
      {
        Context localContext = getContext();
        j = localf.b(localContext);
        i = localf.a(localContext);
        continue;
      }
      i = 0;
      j = 0;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.h
 * JD-Core Version:    0.6.0
 */