package android.support.v4.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

class f
  implements LayoutInflater.Factory
{
  final i a;

  f(i parami)
  {
    this.a = parami;
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.a(null, paramString, paramContext, paramAttributeSet);
  }

  public String toString()
  {
    return getClass().getName() + "{" + this.a + "}";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.c.f
 * JD-Core Version:    0.6.0
 */