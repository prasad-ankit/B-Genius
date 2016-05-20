package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.d.a;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class RewardItemParcel
  implements SafeParcelable
{
  public static final d CREATOR = new d();
  public final int a;
  public final String b;
  public final int c;

  public RewardItemParcel(int paramInt1, String paramString, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
  }

  public RewardItemParcel(a parama)
  {
    this(1, parama.a(), parama.b());
  }

  public RewardItemParcel(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }

  public static RewardItemParcel a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      RewardItemParcel localRewardItemParcel = a(new JSONArray(paramString));
      return localRewardItemParcel;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static RewardItemParcel a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
      return null;
    return new RewardItemParcel(paramJSONArray.getJSONObject(0).optString("rb_type"), paramJSONArray.getJSONObject(0).optInt("rb_amount"));
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof RewardItemParcel)));
    RewardItemParcel localRewardItemParcel;
    do
    {
      return false;
      localRewardItemParcel = (RewardItemParcel)paramObject;
    }
    while ((!f.a(this.b, localRewardItemParcel.b)) || (!f.a(Integer.valueOf(this.c), Integer.valueOf(localRewardItemParcel.c))));
    return true;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = Integer.valueOf(this.c);
    return Arrays.hashCode(arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel
 * JD-Core Version:    0.6.0
 */