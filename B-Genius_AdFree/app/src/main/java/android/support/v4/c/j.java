package android.support.v4.c;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;

public final class j
{
  private static t a;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new s();
      return;
    }
    if (i >= 19)
    {
      a = new r();
      return;
    }
    if (i >= 17)
    {
      a = new p();
      return;
    }
    if (i >= 16)
    {
      a = new o();
      return;
    }
    if (i >= 14)
    {
      a = new n();
      return;
    }
    if (i >= 11)
    {
      a = new m();
      return;
    }
    if (i >= 9)
    {
      a = new l();
      return;
    }
    if (i >= 7)
    {
      a = new k();
      return;
    }
    a = new e();
  }

  public static int a(View paramView)
  {
    return a.a(paramView);
  }

  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    a.a(paramView, paramInt, null);
  }

  public static void a(View paramView, boolean paramBoolean)
  {
    a.a(paramView, false);
  }

  public static boolean b(View paramView)
  {
    return a.b(paramView);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.c.j
 * JD-Core Version:    0.6.0
 */