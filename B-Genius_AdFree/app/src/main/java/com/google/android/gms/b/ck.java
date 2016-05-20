package com.google.android.gms.b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Map;

public final class ck
  implements bU
{
  private final cl a;

  public ck(cl paramcl)
  {
    this.a = paramcl;
  }

  public final void a(is paramis, Map paramMap)
  {
    String str1 = (String)paramMap.get("action");
    if ("grant".equals(str1));
    do
      try
      {
        int i = Integer.parseInt((String)paramMap.get("amount"));
        String str2 = (String)paramMap.get("type");
        if (!TextUtils.isEmpty(str2))
        {
          RewardItemParcel localRewardItemParcel2 = new RewardItemParcel(str2, i);
          localRewardItemParcel1 = localRewardItemParcel2;
          this.a.b(localRewardItemParcel1);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
        {
          hc.c("Unable to parse reward amount.", localNumberFormatException);
          RewardItemParcel localRewardItemParcel1 = null;
        }
      }
    while (!"video_start".equals(str1));
    this.a.D();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ck
 * JD-Core Version:    0.6.0
 */