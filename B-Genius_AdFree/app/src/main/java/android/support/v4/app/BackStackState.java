package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new k();
  private int[] a;
  private int b;
  private int c;
  private String d;
  private int e;
  private int f;
  private CharSequence g;
  private int h;
  private CharSequence i;
  private ArrayList j;
  private ArrayList k;

  public BackStackState(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.h = paramParcel.readInt();
    this.i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.j = paramParcel.createStringArrayList();
    this.k = paramParcel.createStringArrayList();
  }

  public BackStackState(f paramf)
  {
    i locali1 = paramf.a;
    int m = 0;
    while (locali1 != null)
    {
      if (locali1.i != null)
        m += locali1.i.size();
      locali1 = locali1.a;
    }
    this.a = new int[m + 7 * paramf.b];
    if (!paramf.e)
      throw new IllegalStateException("Not on back stack");
    i locali2 = paramf.a;
    int n = 0;
    if (locali2 != null)
    {
      int[] arrayOfInt1 = this.a;
      int i1 = n + 1;
      arrayOfInt1[n] = locali2.c;
      int[] arrayOfInt2 = this.a;
      int i2 = i1 + 1;
      int i3;
      if (locali2.d != null)
        i3 = locali2.d.mIndex;
      int i7;
      while (true)
      {
        arrayOfInt2[i1] = i3;
        int[] arrayOfInt3 = this.a;
        int i4 = i2 + 1;
        arrayOfInt3[i2] = locali2.e;
        int[] arrayOfInt4 = this.a;
        int i5 = i4 + 1;
        arrayOfInt4[i4] = locali2.f;
        int[] arrayOfInt5 = this.a;
        int i6 = i5 + 1;
        arrayOfInt5[i5] = locali2.g;
        int[] arrayOfInt6 = this.a;
        i7 = i6 + 1;
        arrayOfInt6[i6] = locali2.h;
        if (locali2.i == null)
          break;
        int i8 = locali2.i.size();
        int[] arrayOfInt8 = this.a;
        int i9 = i7 + 1;
        arrayOfInt8[i7] = i8;
        int i10 = 0;
        while (true)
          if (i10 < i8)
          {
            int[] arrayOfInt9 = this.a;
            int i11 = i9 + 1;
            arrayOfInt9[i9] = ((Fragment)locali2.i.get(i10)).mIndex;
            i10++;
            i9 = i11;
            continue;
            i3 = -1;
            break;
          }
        n = i9;
      }
      while (true)
      {
        locali2 = locali2.a;
        break;
        int[] arrayOfInt7 = this.a;
        n = i7 + 1;
        arrayOfInt7[i7] = 0;
      }
    }
    this.b = paramf.c;
    this.c = paramf.d;
    this.d = paramf.f;
    this.e = paramf.g;
    this.f = paramf.h;
    this.g = paramf.i;
    this.h = paramf.j;
    this.i = paramf.k;
    this.j = paramf.l;
    this.k = paramf.m;
  }

  public final f a(A paramA)
  {
    f localf = new f(paramA);
    int m = 0;
    while (m < this.a.length)
    {
      i locali = new i();
      int[] arrayOfInt1 = this.a;
      int n = m + 1;
      locali.c = arrayOfInt1[m];
      int[] arrayOfInt2 = this.a;
      int i1 = n + 1;
      int i2 = arrayOfInt2[n];
      if (i2 >= 0);
      for (locali.d = ((Fragment)paramA.b.get(i2)); ; locali.d = null)
      {
        int[] arrayOfInt3 = this.a;
        int i3 = i1 + 1;
        locali.e = arrayOfInt3[i1];
        int[] arrayOfInt4 = this.a;
        int i4 = i3 + 1;
        locali.f = arrayOfInt4[i3];
        int[] arrayOfInt5 = this.a;
        int i5 = i4 + 1;
        locali.g = arrayOfInt5[i4];
        int[] arrayOfInt6 = this.a;
        int i6 = i5 + 1;
        locali.h = arrayOfInt6[i5];
        int[] arrayOfInt7 = this.a;
        m = i6 + 1;
        int i7 = arrayOfInt7[i6];
        if (i7 <= 0)
          break;
        locali.i = new ArrayList(i7);
        int i8 = 0;
        while (i8 < i7)
        {
          ArrayList localArrayList = paramA.b;
          int[] arrayOfInt8 = this.a;
          int i9 = m + 1;
          Fragment localFragment = (Fragment)localArrayList.get(arrayOfInt8[m]);
          locali.i.add(localFragment);
          i8++;
          m = i9;
        }
      }
      localf.a(locali);
    }
    localf.c = this.b;
    localf.d = this.c;
    localf.f = this.d;
    localf.g = this.e;
    localf.e = true;
    localf.h = this.f;
    localf.i = this.g;
    localf.j = this.h;
    localf.k = this.i;
    localf.l = this.j;
    localf.m = this.k;
    localf.a(1);
    return localf;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    TextUtils.writeToParcel(this.g, paramParcel, 0);
    paramParcel.writeInt(this.h);
    TextUtils.writeToParcel(this.i, paramParcel, 0);
    paramParcel.writeStringList(this.j);
    paramParcel.writeStringList(this.k);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.6.0
 */