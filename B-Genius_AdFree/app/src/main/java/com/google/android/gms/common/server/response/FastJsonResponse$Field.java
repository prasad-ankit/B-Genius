package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import java.util.Map;

public class FastJsonResponse$Field
  implements SafeParcelable
{
  public static final b CREATOR = new b();
  private final int a;
  private int b;
  private boolean c;
  private int d;
  private boolean e;
  private String f;
  private int g;
  private Class h;
  private String i;
  private FieldMappingDictionary j;
  private a k;

  FastJsonResponse$Field(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, ConverterWrapper paramConverterWrapper)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean1;
    this.d = paramInt3;
    this.e = paramBoolean2;
    this.f = paramString1;
    this.g = paramInt4;
    if (paramString2 == null)
      this.h = null;
    for (this.i = null; paramConverterWrapper == null; this.i = paramString2)
    {
      this.k = null;
      return;
      this.h = SafeParcelResponse.class;
    }
    this.k = paramConverterWrapper.c();
  }

  private FastJsonResponse$Field(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class paramClass, a parama)
  {
    this.a = 1;
    this.b = paramInt1;
    this.c = paramBoolean1;
    this.d = paramInt2;
    this.e = paramBoolean2;
    this.f = paramString;
    this.g = paramInt3;
    this.h = paramClass;
    if (paramClass == null);
    for (this.i = null; ; this.i = paramClass.getCanonicalName())
    {
      this.k = parama;
      return;
    }
  }

  public static Field a(String paramString, int paramInt)
  {
    return new Field(0, false, 0, false, paramString, paramInt, null, null);
  }

  public static Field a(String paramString, int paramInt, a parama, boolean paramBoolean)
  {
    return new Field(7, false, 0, false, paramString, paramInt, null, parama);
  }

  public static Field a(String paramString, int paramInt, Class paramClass)
  {
    return new Field(11, false, 11, false, paramString, paramInt, paramClass, null);
  }

  public static Field b(String paramString, int paramInt)
  {
    return new Field(6, false, 6, false, paramString, paramInt, null, null);
  }

  public static Field b(String paramString, int paramInt, Class paramClass)
  {
    return new Field(11, true, 11, true, paramString, paramInt, paramClass, null);
  }

  public static Field c(String paramString, int paramInt)
  {
    return new Field(7, false, 7, false, paramString, paramInt, null, null);
  }

  public final int a()
  {
    return this.a;
  }

  public final Object a(Object paramObject)
  {
    return this.k.a(paramObject);
  }

  public final void a(FieldMappingDictionary paramFieldMappingDictionary)
  {
    this.j = paramFieldMappingDictionary;
  }

  public final int b()
  {
    return this.b;
  }

  public final boolean c()
  {
    return this.c;
  }

  public final int d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public final boolean e()
  {
    return this.e;
  }

  public final String f()
  {
    return this.f;
  }

  public final int g()
  {
    return this.g;
  }

  public final Class h()
  {
    return this.h;
  }

  final String i()
  {
    if (this.i == null)
      return null;
    return this.i;
  }

  public final boolean j()
  {
    return this.k != null;
  }

  final ConverterWrapper k()
  {
    if (this.k == null)
      return null;
    return ConverterWrapper.a(this.k);
  }

  public final Map l()
  {
    w.a(this.i);
    w.a(this.j);
    return this.j.a(this.i);
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Field\n");
    localStringBuilder1.append("            versionCode=").append(this.a).append('\n');
    localStringBuilder1.append("                 typeIn=").append(this.b).append('\n');
    localStringBuilder1.append("            typeInArray=").append(this.c).append('\n');
    localStringBuilder1.append("                typeOut=").append(this.d).append('\n');
    localStringBuilder1.append("           typeOutArray=").append(this.e).append('\n');
    localStringBuilder1.append("        outputFieldName=").append(this.f).append('\n');
    localStringBuilder1.append("      safeParcelFieldId=").append(this.g).append('\n');
    localStringBuilder1.append("       concreteTypeName=").append(i()).append('\n');
    if (this.h != null)
      localStringBuilder1.append("     concreteType.class=").append(this.h.getCanonicalName()).append('\n');
    StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
    if (this.k == null);
    for (String str = "null"; ; str = this.k.getClass().getCanonicalName())
    {
      localStringBuilder2.append(str).append('\n');
      return localStringBuilder1.toString();
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastJsonResponse.Field
 * JD-Core Version:    0.6.0
 */