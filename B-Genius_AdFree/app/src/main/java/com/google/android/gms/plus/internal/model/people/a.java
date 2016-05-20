package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class a
  implements Parcelable.Creator
{
  public static PersonEntity a(Parcel paramParcel)
  {
    int i = j.a(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    String str1 = null;
    Object localObject1 = null;
    String str2 = null;
    String str3 = null;
    int k = 0;
    Object localObject2 = null;
    String str4 = null;
    String str5 = null;
    int m = 0;
    String str6 = null;
    Object localObject3 = null;
    boolean bool1 = false;
    String str7 = null;
    Object localObject4 = null;
    String str8 = null;
    int n = 0;
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    int i1 = 0;
    int i2 = 0;
    String str9 = null;
    String str10 = null;
    ArrayList localArrayList3 = null;
    boolean bool2 = false;
    while (paramParcel.dataPosition() < i)
    {
      int i3 = paramParcel.readInt();
      switch (0xFFFF & i3)
      {
      case 10:
      case 11:
      case 13:
      case 17:
      default:
        j.b(paramParcel, i3);
        break;
      case 1:
        j = j.e(paramParcel, i3);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        str1 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3:
        PersonEntity.AgeRangeEntity localAgeRangeEntity = (PersonEntity.AgeRangeEntity)j.a(paramParcel, i3, PersonEntity.AgeRangeEntity.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        localObject1 = localAgeRangeEntity;
        break;
      case 4:
        str2 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5:
        str3 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6:
        k = j.e(paramParcel, i3);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7:
        PersonEntity.CoverEntity localCoverEntity = (PersonEntity.CoverEntity)j.a(paramParcel, i3, PersonEntity.CoverEntity.CREATOR);
        localHashSet.add(Integer.valueOf(7));
        localObject2 = localCoverEntity;
        break;
      case 8:
        str4 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9:
        str5 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 12:
        m = j.e(paramParcel, i3);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 14:
        str6 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15:
        PersonEntity.ImageEntity localImageEntity = (PersonEntity.ImageEntity)j.a(paramParcel, i3, PersonEntity.ImageEntity.CREATOR);
        localHashSet.add(Integer.valueOf(15));
        localObject3 = localImageEntity;
        break;
      case 16:
        bool1 = j.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19:
        PersonEntity.NameEntity localNameEntity = (PersonEntity.NameEntity)j.a(paramParcel, i3, PersonEntity.NameEntity.CREATOR);
        localHashSet.add(Integer.valueOf(19));
        localObject4 = localNameEntity;
        break;
      case 18:
        str7 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 21:
        n = j.e(paramParcel, i3);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 20:
        str8 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 23:
        localArrayList2 = j.c(paramParcel, i3, PersonEntity.PlacesLivedEntity.CREATOR);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22:
        localArrayList1 = j.c(paramParcel, i3, PersonEntity.OrganizationsEntity.CREATOR);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 25:
        i2 = j.e(paramParcel, i3);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 24:
        i1 = j.e(paramParcel, i3);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 27:
        str10 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 26:
        str9 = j.m(paramParcel, i3);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 29:
        bool2 = j.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(29));
        break;
      case 28:
        localArrayList3 = j.c(paramParcel, i3, PersonEntity.UrlsEntity.CREATOR);
        localHashSet.add(Integer.valueOf(28));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new PersonEntity(localHashSet, j, str1, localObject1, str2, str3, k, localObject2, str4, str5, m, str6, localObject3, bool1, str7, localObject4, str8, n, localArrayList1, localArrayList2, i1, i2, str9, str10, localArrayList3, bool2);
  }

  static void a(PersonEntity paramPersonEntity, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    Set localSet = paramPersonEntity.a;
    if (localSet.contains(Integer.valueOf(1)))
      j.a(paramParcel, 1, paramPersonEntity.b);
    if (localSet.contains(Integer.valueOf(2)))
      j.a(paramParcel, 2, paramPersonEntity.c, true);
    if (localSet.contains(Integer.valueOf(3)))
      j.a(paramParcel, 3, paramPersonEntity.d, paramInt, true);
    if (localSet.contains(Integer.valueOf(4)))
      j.a(paramParcel, 4, paramPersonEntity.e, true);
    if (localSet.contains(Integer.valueOf(5)))
      j.a(paramParcel, 5, paramPersonEntity.f, true);
    if (localSet.contains(Integer.valueOf(6)))
      j.a(paramParcel, 6, paramPersonEntity.g);
    if (localSet.contains(Integer.valueOf(7)))
      j.a(paramParcel, 7, paramPersonEntity.h, paramInt, true);
    if (localSet.contains(Integer.valueOf(8)))
      j.a(paramParcel, 8, paramPersonEntity.i, true);
    if (localSet.contains(Integer.valueOf(9)))
      j.a(paramParcel, 9, paramPersonEntity.j, true);
    if (localSet.contains(Integer.valueOf(12)))
      j.a(paramParcel, 12, paramPersonEntity.k);
    if (localSet.contains(Integer.valueOf(14)))
      j.a(paramParcel, 14, paramPersonEntity.l, true);
    if (localSet.contains(Integer.valueOf(15)))
      j.a(paramParcel, 15, paramPersonEntity.m, paramInt, true);
    if (localSet.contains(Integer.valueOf(16)))
      j.a(paramParcel, 16, paramPersonEntity.n);
    if (localSet.contains(Integer.valueOf(19)))
      j.a(paramParcel, 19, paramPersonEntity.p, paramInt, true);
    if (localSet.contains(Integer.valueOf(18)))
      j.a(paramParcel, 18, paramPersonEntity.o, true);
    if (localSet.contains(Integer.valueOf(21)))
      j.a(paramParcel, 21, paramPersonEntity.r);
    if (localSet.contains(Integer.valueOf(20)))
      j.a(paramParcel, 20, paramPersonEntity.q, true);
    if (localSet.contains(Integer.valueOf(23)))
      j.b(paramParcel, 23, paramPersonEntity.t, true);
    if (localSet.contains(Integer.valueOf(22)))
      j.b(paramParcel, 22, paramPersonEntity.s, true);
    if (localSet.contains(Integer.valueOf(25)))
      j.a(paramParcel, 25, paramPersonEntity.v);
    if (localSet.contains(Integer.valueOf(24)))
      j.a(paramParcel, 24, paramPersonEntity.u);
    if (localSet.contains(Integer.valueOf(27)))
      j.a(paramParcel, 27, paramPersonEntity.x, true);
    if (localSet.contains(Integer.valueOf(26)))
      j.a(paramParcel, 26, paramPersonEntity.w, true);
    if (localSet.contains(Integer.valueOf(29)))
      j.a(paramParcel, 29, paramPersonEntity.z);
    if (localSet.contains(Integer.valueOf(28)))
      j.b(paramParcel, 28, paramPersonEntity.y, true);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.model.people.a
 * JD-Core Version:    0.6.0
 */