package android.support.v4.c;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class a
{
  private static b a;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new d();
      return;
    }
    if (i >= 11)
    {
      a = new c();
      return;
    }
    a = new b();
  }

  public static void a(LayoutInflater paramLayoutInflater, i parami)
  {
    a.a(paramLayoutInflater, parami);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.c.a
 * JD-Core Version:    0.6.0
 */