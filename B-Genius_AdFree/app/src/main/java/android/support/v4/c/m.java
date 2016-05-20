package android.support.v4.c;

import android.graphics.Paint;
import android.view.View;

class m extends l
{
  public final int a(View paramView)
  {
    return paramView.getLayerType();
  }

  public final void a(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }

  public final void a(View paramView, boolean paramBoolean)
  {
    paramView.setSaveFromParentEnabled(paramBoolean);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.c.m
 * JD-Core Version:    0.6.0
 */