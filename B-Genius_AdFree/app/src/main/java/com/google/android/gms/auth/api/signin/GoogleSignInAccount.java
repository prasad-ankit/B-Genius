package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import android.text.TextUtils;
import com.google.android.gms.b.ju;
import com.google.android.gms.b.jv;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  private static ju c = jv.d();
  private static Comparator l = new a();
  final int a;
  List b;
  private String d;
  private String e;
  private String f;
  private String g;
  private Uri h;
  private String i;
  private long j;
  private String k;

  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List paramList)
  {
    this.a = paramInt;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramUri;
    this.i = paramString5;
    this.j = paramLong;
    this.k = paramString6;
    this.b = paramList;
  }

  public static GoogleSignInAccount a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    JSONObject localJSONObject = new JSONObject(paramString);
    String str1 = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(str1));
    for (Uri localUri = Uri.parse(str1); ; localUri = null)
    {
      long l1 = Long.parseLong(localJSONObject.getString("expirationTime"));
      HashSet localHashSet = new HashSet();
      JSONArray localJSONArray = localJSONObject.getJSONArray("grantedScopes");
      int m = localJSONArray.length();
      for (int n = 0; n < m; n++)
        localHashSet.add(new Scope(localJSONArray.getString(n)));
      String str2 = localJSONObject.optString("id");
      String str3 = localJSONObject.optString("tokenId", null);
      String str4 = localJSONObject.optString("email", null);
      String str5 = localJSONObject.optString("displayName", null);
      Long localLong1 = Long.valueOf(l1);
      String str6 = localJSONObject.getString("obfuscatedIdentifier");
      if (localLong1 == null);
      for (Long localLong2 = Long.valueOf(c.a() / 1000L); ; localLong2 = localLong1)
      {
        GoogleSignInAccount localGoogleSignInAccount = new GoogleSignInAccount(2, str2, str3, str4, str5, localUri, null, localLong2.longValue(), w.a(str6), new ArrayList((Collection)w.a(localHashSet)));
        localGoogleSignInAccount.i = localJSONObject.optString("serverAuthCode", null);
        return localGoogleSignInAccount;
      }
    }
  }

  private JSONObject i()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      if (this.d != null)
        localJSONObject.put("id", this.d);
      if (this.e != null)
        localJSONObject.put("tokenId", this.e);
      if (this.f != null)
        localJSONObject.put("email", this.f);
      if (this.g != null)
        localJSONObject.put("displayName", this.g);
      if (this.h != null)
        localJSONObject.put("photoUrl", this.h.toString());
      if (this.i != null)
        localJSONObject.put("serverAuthCode", this.i);
      localJSONObject.put("expirationTime", this.j);
      localJSONObject.put("obfuscatedIdentifier", this.k);
      localJSONArray = new JSONArray();
      Collections.sort(this.b, l);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((Scope)localIterator.next()).a());
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    localJSONObject.put("grantedScopes", localJSONArray);
    return localJSONObject;
  }

  public final String a()
  {
    return this.d;
  }

  public final String b()
  {
    return this.e;
  }

  public final String c()
  {
    return this.f;
  }

  public final String d()
  {
    return this.g;
  }

  public int describeContents()
  {
    return 0;
  }

  public final Uri e()
  {
    return this.h;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleSignInAccount))
      return false;
    return ((GoogleSignInAccount)paramObject).i().toString().equals(i().toString());
  }

  public final String f()
  {
    return this.i;
  }

  public final long g()
  {
    return this.j;
  }

  public final String h()
  {
    return this.k;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInAccount
 * JD-Core Version:    0.6.0
 */