package com.google.android.gms.games.request;

import android.os.Bundle;
import java.util.ArrayList;

public class b
{
  public ArrayList a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("requests")))
      return new ArrayList();
    ArrayList localArrayList1 = (ArrayList)paramBundle.get("requests");
    ArrayList localArrayList2 = new ArrayList();
    int i = localArrayList1.size();
    for (int j = 0; j < i; j++)
      localArrayList2.add((GameRequest)localArrayList1.get(j));
    return localArrayList2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.b
 * JD-Core Version:    0.6.0
 */