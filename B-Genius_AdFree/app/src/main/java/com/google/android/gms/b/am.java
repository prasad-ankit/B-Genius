package com.google.android.gms.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public final class am
{
  private final int a;
  private final int b;
  private final int c;
  private final al d = new ap();

  public am(int paramInt)
  {
    this.b = paramInt;
    this.a = 6;
    this.c = 0;
  }

  private String a(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\n");
    if (arrayOfString1.length == 0)
      return "";
    ao localao = new ao();
    PriorityQueue localPriorityQueue = new PriorityQueue(this.b, new an(this));
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      String[] arrayOfString2 = d.b(arrayOfString1[i]);
      if (arrayOfString2.length == 0)
        continue;
      d.a(arrayOfString2, this.b, 6, localPriorityQueue);
    }
    Iterator localIterator = localPriorityQueue.iterator();
    while (true)
      if (localIterator.hasNext())
      {
        aq localaq = (aq)localIterator.next();
        try
        {
          localao.a(this.d.a(localaq.b));
        }
        catch (IOException localIOException)
        {
          hc.b("Error while writing hash to byteStream", localIOException);
        }
      }
    return localao.toString();
  }

  public final String a(ArrayList paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(((String)localIterator.next()).toLowerCase(Locale.US));
      localStringBuffer.append('\n');
    }
    return a(localStringBuffer.toString());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.am
 * JD-Core Version:    0.6.0
 */