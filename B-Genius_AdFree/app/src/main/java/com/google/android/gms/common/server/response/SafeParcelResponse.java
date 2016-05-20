package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.j;
import android.support.v4.app.p;
import android.support.v4.app.w;
import com.google.android.gms.b.jy;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  private final int a;
  private final Parcel b;
  private final int c;
  private final FieldMappingDictionary d;
  private final String e;
  private int f;
  private int g;

  SafeParcelResponse(int paramInt, Parcel paramParcel, FieldMappingDictionary paramFieldMappingDictionary)
  {
    this.a = paramInt;
    this.b = ((Parcel)w.a(paramParcel));
    this.c = 2;
    this.d = paramFieldMappingDictionary;
    if (this.d == null);
    for (this.e = null; ; this.e = this.d.c())
    {
      this.f = 2;
      return;
    }
  }

  private static HashMap a(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }

  private static void a(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown type = " + paramInt);
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
      paramStringBuilder.append(paramObject);
      return;
    case 7:
      paramStringBuilder.append("\"").append(jy.a(paramObject.toString())).append("\"");
      return;
    case 8:
      paramStringBuilder.append("\"").append(j.a((byte[])paramObject)).append("\"");
      return;
    case 9:
      paramStringBuilder.append("\"").append(j.b((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10:
      j.a(paramStringBuilder, (HashMap)paramObject);
      return;
    case 11:
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }

  private void a(StringBuilder paramStringBuilder, FastJsonResponse.Field paramField, Parcel paramParcel, int paramInt)
  {
    int i = 0;
    if (paramField.e())
    {
      paramStringBuilder.append("[");
      int[] arrayOfInt;
      int i9;
      int i6;
      int i7;
      Object localObject;
      switch (paramField.d())
      {
      default:
        throw new IllegalStateException("Unknown field type out.");
      case 0:
        arrayOfInt = j.r(paramParcel, paramInt);
        i9 = arrayOfInt.length;
      case 1:
        while (i < i9)
        {
          if (i != 0)
            paramStringBuilder.append(",");
          paramStringBuilder.append(Integer.toString(arrayOfInt[i]));
          i++;
          continue;
          i6 = j.a(paramParcel, paramInt);
          i7 = paramParcel.dataPosition();
          localObject = null;
          if (i6 != 0)
            break label181;
          j.a(paramStringBuilder, localObject);
        }
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      }
      while (true)
      {
        paramStringBuilder.append("]");
        return;
        label181: int i8 = paramParcel.readInt();
        localObject = new BigInteger[i8];
        while (i < i8)
        {
          localObject[i] = new BigInteger(paramParcel.createByteArray());
          i++;
        }
        paramParcel.setDataPosition(i6 + i7);
        break;
        int i4 = j.a(paramParcel, paramInt);
        int i5 = paramParcel.dataPosition();
        long[] arrayOfLong = null;
        if (i4 == 0);
        while (true)
        {
          j.a(paramStringBuilder, arrayOfLong);
          break;
          arrayOfLong = paramParcel.createLongArray();
          paramParcel.setDataPosition(i4 + i5);
        }
        int i2 = j.a(paramParcel, paramInt);
        int i3 = paramParcel.dataPosition();
        float[] arrayOfFloat = null;
        if (i2 == 0);
        while (true)
        {
          j.a(paramStringBuilder, arrayOfFloat);
          break;
          arrayOfFloat = paramParcel.createFloatArray();
          paramParcel.setDataPosition(i2 + i3);
        }
        int n = j.a(paramParcel, paramInt);
        int i1 = paramParcel.dataPosition();
        double[] arrayOfDouble = null;
        if (n == 0);
        while (true)
        {
          j.a(paramStringBuilder, arrayOfDouble);
          break;
          arrayOfDouble = paramParcel.createDoubleArray();
          paramParcel.setDataPosition(n + i1);
        }
        j.a(paramStringBuilder, j.s(paramParcel, paramInt));
        continue;
        j.a(paramStringBuilder, j.q(paramParcel, paramInt));
        continue;
        j.a(paramStringBuilder, j.t(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        Parcel[] arrayOfParcel = j.w(paramParcel, paramInt);
        int k = arrayOfParcel.length;
        for (int m = 0; m < k; m++)
        {
          if (m > 0)
            paramStringBuilder.append(",");
          arrayOfParcel[m].setDataPosition(0);
          a(paramStringBuilder, paramField.l(), arrayOfParcel[m]);
        }
      }
    }
    switch (paramField.d())
    {
    default:
      throw new IllegalStateException("Unknown field type out");
    case 0:
      paramStringBuilder.append(j.e(paramParcel, paramInt));
      return;
    case 1:
      paramStringBuilder.append(j.i(paramParcel, paramInt));
      return;
    case 2:
      paramStringBuilder.append(j.g(paramParcel, paramInt));
      return;
    case 3:
      paramStringBuilder.append(j.j(paramParcel, paramInt));
      return;
    case 4:
      paramStringBuilder.append(j.k(paramParcel, paramInt));
      return;
    case 5:
      paramStringBuilder.append(j.l(paramParcel, paramInt));
      return;
    case 6:
      paramStringBuilder.append(j.c(paramParcel, paramInt));
      return;
    case 7:
      String str2 = j.m(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(jy.a(str2)).append("\"");
      return;
    case 8:
      byte[] arrayOfByte2 = j.p(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(j.a(arrayOfByte2)).append("\"");
      return;
    case 9:
      byte[] arrayOfByte1 = j.p(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(j.b(arrayOfByte1));
      paramStringBuilder.append("\"");
      return;
    case 10:
      Bundle localBundle = j.o(paramParcel, paramInt);
      Set localSet = localBundle.keySet();
      localSet.size();
      paramStringBuilder.append("{");
      Iterator localIterator = localSet.iterator();
      for (int j = 1; localIterator.hasNext(); j = 0)
      {
        String str1 = (String)localIterator.next();
        if (j == 0)
          paramStringBuilder.append(",");
        paramStringBuilder.append("\"").append(str1).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(jy.a(localBundle.getString(str1))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    case 11:
    }
    Parcel localParcel = j.v(paramParcel, paramInt);
    localParcel.setDataPosition(0);
    a(paramStringBuilder, paramField.l(), localParcel);
  }

  private void a(StringBuilder paramStringBuilder, FastJsonResponse.Field paramField, Object paramObject)
  {
    if (paramField.c())
    {
      ArrayList localArrayList = (ArrayList)paramObject;
      paramStringBuilder.append("[");
      int i = localArrayList.size();
      for (int j = 0; j < i; j++)
      {
        if (j != 0)
          paramStringBuilder.append(",");
        a(paramStringBuilder, paramField.b(), localArrayList.get(j));
      }
      paramStringBuilder.append("]");
      return;
    }
    a(paramStringBuilder, paramField.b(), paramObject);
  }

  private void a(StringBuilder paramStringBuilder, Map paramMap, Parcel paramParcel)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator.next();
      localHashMap.put(Integer.valueOf(((FastJsonResponse.Field)localEntry2.getValue()).g()), localEntry2);
    }
    paramStringBuilder.append('{');
    int i = j.a(paramParcel);
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = paramParcel.readInt();
      Map.Entry localEntry1 = (Map.Entry)localHashMap.get(Integer.valueOf(0xFFFF & k));
      if (localEntry1 == null)
        continue;
      if (j != 0)
        paramStringBuilder.append(",");
      String str = (String)localEntry1.getKey();
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localEntry1.getValue();
      paramStringBuilder.append("\"").append(str).append("\":");
      if (localField.j())
        switch (localField.d())
        {
        default:
          throw new IllegalArgumentException("Unknown field out type = " + localField.d());
        case 0:
          a(paramStringBuilder, localField, a(localField, Integer.valueOf(j.e(paramParcel, k))));
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        }
      while (true)
      {
        j = 1;
        break;
        a(paramStringBuilder, localField, a(localField, j.i(paramParcel, k)));
        continue;
        a(paramStringBuilder, localField, a(localField, Long.valueOf(j.g(paramParcel, k))));
        continue;
        a(paramStringBuilder, localField, a(localField, Float.valueOf(j.j(paramParcel, k))));
        continue;
        a(paramStringBuilder, localField, a(localField, Double.valueOf(j.k(paramParcel, k))));
        continue;
        a(paramStringBuilder, localField, a(localField, j.l(paramParcel, k)));
        continue;
        a(paramStringBuilder, localField, a(localField, Boolean.valueOf(j.c(paramParcel, k))));
        continue;
        a(paramStringBuilder, localField, a(localField, j.m(paramParcel, k)));
        continue;
        a(paramStringBuilder, localField, a(localField, j.p(paramParcel, k)));
        continue;
        a(paramStringBuilder, localField, a(localField, a(j.o(paramParcel, k))));
        continue;
        throw new IllegalArgumentException("Method does not accept concrete type.");
        a(paramStringBuilder, localField, paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    paramStringBuilder.append('}');
  }

  public final Map a()
  {
    if (this.d == null)
      return null;
    return this.d.a(this.e);
  }

  protected final Object b()
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  public final int c()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public final Parcel e()
  {
    switch (this.f)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return this.b;
      this.g = j.b(this.b);
      j.x(this.b, this.g);
      this.f = 2;
    }
  }

  final FieldMappingDictionary f()
  {
    return this.d;
  }

  protected final boolean i_()
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  public String toString()
  {
    w.a(this.d, "Cannot convert to JSON on client side.");
    Parcel localParcel = e();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.d.a(this.e), localParcel);
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.SafeParcelResponse
 * JD-Core Version:    0.6.0
 */