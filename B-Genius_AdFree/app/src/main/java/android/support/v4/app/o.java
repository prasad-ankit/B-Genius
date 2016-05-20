package android.support.v4.app;

import android.view.View;

final class o extends v
{
  o(Fragment paramFragment)
  {
  }

  public final View a(int paramInt)
  {
    if (this.a.mView == null)
      throw new IllegalStateException("Fragment does not have a view");
    return this.a.mView.findViewById(paramInt);
  }

  public final boolean a()
  {
    return this.a.mView != null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.o
 * JD-Core Version:    0.6.0
 */