package android.support.v4.c;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

class c extends b
{
  public void a(LayoutInflater paramLayoutInflater, i parami)
  {
    if (parami != null);
    for (h localh = new h(parami); ; localh = null)
    {
      paramLayoutInflater.setFactory2(localh);
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if (!(localFactory instanceof LayoutInflater.Factory2))
        break;
      g.a(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
      return;
    }
    g.a(paramLayoutInflater, localh);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.c.c
 * JD-Core Version:    0.6.0
 */