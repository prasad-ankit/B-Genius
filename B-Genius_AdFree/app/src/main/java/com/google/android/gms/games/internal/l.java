package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.i;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.video.VideoCapabilities;

public abstract class l extends Binder
  implements k
{
  public l()
  {
    attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
  }

  public static k a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof k)))
      return (k)localIInterface;
    return new m(paramIBinder);
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.games.internal.IGamesCallbacks");
      return true;
    case 5001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      a(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5002:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      if (paramParcel1.readInt() != 0);
      for (DataHolder localDataHolder53 = i.a(paramParcel1); ; localDataHolder53 = null)
      {
        a(localDataHolder53);
        paramParcel2.writeNoException();
        return true;
      }
    case 5003:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      b(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5004:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i55 = paramParcel1.readInt();
      DataHolder localDataHolder52 = null;
      if (i55 != 0)
        localDataHolder52 = i.a(paramParcel1);
      c(localDataHolder52);
      paramParcel2.writeNoException();
      return true;
    case 5005:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      if (paramParcel1.readInt() != 0);
      for (DataHolder localDataHolder50 = i.a(paramParcel1); ; localDataHolder50 = null)
      {
        int i54 = paramParcel1.readInt();
        DataHolder localDataHolder51 = null;
        if (i54 != 0)
          localDataHolder51 = i.a(paramParcel1);
        a(localDataHolder50, localDataHolder51);
        paramParcel2.writeNoException();
        return true;
      }
    case 5006:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i53 = paramParcel1.readInt();
      DataHolder localDataHolder49 = null;
      if (i53 != 0)
        localDataHolder49 = i.a(paramParcel1);
      d(localDataHolder49);
      paramParcel2.writeNoException();
      return true;
    case 5007:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i52 = paramParcel1.readInt();
      DataHolder localDataHolder48 = null;
      if (i52 != 0)
        localDataHolder48 = i.a(paramParcel1);
      e(localDataHolder48);
      paramParcel2.writeNoException();
      return true;
    case 5008:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i51 = paramParcel1.readInt();
      DataHolder localDataHolder47 = null;
      if (i51 != 0)
        localDataHolder47 = i.a(paramParcel1);
      f(localDataHolder47);
      paramParcel2.writeNoException();
      return true;
    case 5009:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i50 = paramParcel1.readInt();
      DataHolder localDataHolder46 = null;
      if (i50 != 0)
        localDataHolder46 = i.a(paramParcel1);
      g(localDataHolder46);
      paramParcel2.writeNoException();
      return true;
    case 5010:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i49 = paramParcel1.readInt();
      DataHolder localDataHolder45 = null;
      if (i49 != 0)
        localDataHolder45 = i.a(paramParcel1);
      h(localDataHolder45);
      paramParcel2.writeNoException();
      return true;
    case 5011:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i48 = paramParcel1.readInt();
      DataHolder localDataHolder44 = null;
      if (i48 != 0)
        localDataHolder44 = i.a(paramParcel1);
      i(localDataHolder44);
      paramParcel2.writeNoException();
      return true;
    case 5016:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      a();
      paramParcel2.writeNoException();
      return true;
    case 5017:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i47 = paramParcel1.readInt();
      DataHolder localDataHolder43 = null;
      if (i47 != 0)
        localDataHolder43 = i.a(paramParcel1);
      k(localDataHolder43);
      paramParcel2.writeNoException();
      return true;
    case 5037:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i46 = paramParcel1.readInt();
      DataHolder localDataHolder42 = null;
      if (i46 != 0)
        localDataHolder42 = i.a(paramParcel1);
      l(localDataHolder42);
      paramParcel2.writeNoException();
      return true;
    case 5018:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i45 = paramParcel1.readInt();
      DataHolder localDataHolder41 = null;
      if (i45 != 0)
        localDataHolder41 = i.a(paramParcel1);
      s(localDataHolder41);
      paramParcel2.writeNoException();
      return true;
    case 5019:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i44 = paramParcel1.readInt();
      DataHolder localDataHolder40 = null;
      if (i44 != 0)
        localDataHolder40 = i.a(paramParcel1);
      t(localDataHolder40);
      paramParcel2.writeNoException();
      return true;
    case 5020:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      d(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5021:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i43 = paramParcel1.readInt();
      DataHolder localDataHolder39 = null;
      if (i43 != 0)
        localDataHolder39 = i.a(paramParcel1);
      u(localDataHolder39);
      paramParcel2.writeNoException();
      return true;
    case 5022:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i42 = paramParcel1.readInt();
      DataHolder localDataHolder38 = null;
      if (i42 != 0)
        localDataHolder38 = i.a(paramParcel1);
      v(localDataHolder38);
      paramParcel2.writeNoException();
      return true;
    case 5023:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i41 = paramParcel1.readInt();
      DataHolder localDataHolder37 = null;
      if (i41 != 0)
        localDataHolder37 = i.a(paramParcel1);
      w(localDataHolder37);
      paramParcel2.writeNoException();
      return true;
    case 5024:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i40 = paramParcel1.readInt();
      DataHolder localDataHolder36 = null;
      if (i40 != 0)
        localDataHolder36 = i.a(paramParcel1);
      x(localDataHolder36);
      paramParcel2.writeNoException();
      return true;
    case 5025:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i39 = paramParcel1.readInt();
      DataHolder localDataHolder35 = null;
      if (i39 != 0)
        localDataHolder35 = i.a(paramParcel1);
      y(localDataHolder35);
      paramParcel2.writeNoException();
      return true;
    case 5026:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i38 = paramParcel1.readInt();
      DataHolder localDataHolder34 = null;
      if (i38 != 0)
        localDataHolder34 = i.a(paramParcel1);
      a(localDataHolder34, paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 5027:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i37 = paramParcel1.readInt();
      DataHolder localDataHolder33 = null;
      if (i37 != 0)
        localDataHolder33 = i.a(paramParcel1);
      b(localDataHolder33, paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 5028:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i36 = paramParcel1.readInt();
      DataHolder localDataHolder32 = null;
      if (i36 != 0)
        localDataHolder32 = i.a(paramParcel1);
      c(localDataHolder32, paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 5029:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i35 = paramParcel1.readInt();
      DataHolder localDataHolder31 = null;
      if (i35 != 0)
        localDataHolder31 = i.a(paramParcel1);
      d(localDataHolder31, paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 5030:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i34 = paramParcel1.readInt();
      DataHolder localDataHolder30 = null;
      if (i34 != 0)
        localDataHolder30 = i.a(paramParcel1);
      e(localDataHolder30, paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 5031:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i33 = paramParcel1.readInt();
      DataHolder localDataHolder29 = null;
      if (i33 != 0)
        localDataHolder29 = i.a(paramParcel1);
      f(localDataHolder29, paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 5032:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      if (paramParcel1.readInt() != 0);
      for (RealTimeMessage localRealTimeMessage = (RealTimeMessage)RealTimeMessage.CREATOR.createFromParcel(paramParcel1); ; localRealTimeMessage = null)
      {
        a(localRealTimeMessage);
        paramParcel2.writeNoException();
        return true;
      }
    case 5033:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5034:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i31 = paramParcel1.readInt();
      String str2 = paramParcel1.readString();
      int i32 = paramParcel1.readInt();
      boolean bool2 = false;
      if (i32 != 0)
        bool2 = true;
      a(i31, str2, bool2);
      paramParcel2.writeNoException();
      return true;
    case 5038:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i30 = paramParcel1.readInt();
      DataHolder localDataHolder28 = null;
      if (i30 != 0)
        localDataHolder28 = i.a(paramParcel1);
      z(localDataHolder28);
      paramParcel2.writeNoException();
      return true;
    case 5035:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i29 = paramParcel1.readInt();
      DataHolder localDataHolder27 = null;
      if (i29 != 0)
        localDataHolder27 = i.a(paramParcel1);
      A(localDataHolder27);
      paramParcel2.writeNoException();
      return true;
    case 5036:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 5039:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i28 = paramParcel1.readInt();
      DataHolder localDataHolder26 = null;
      if (i28 != 0)
        localDataHolder26 = i.a(paramParcel1);
      B(localDataHolder26);
      paramParcel2.writeNoException();
      return true;
    case 5040:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      b(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 6001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      d(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 6002:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      e(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i27 = paramParcel1.readInt();
      DataHolder localDataHolder25 = null;
      if (i27 != 0)
        localDataHolder25 = i.a(paramParcel1);
      C(localDataHolder25);
      paramParcel2.writeNoException();
      return true;
    case 8002:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i26 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle5 = null)
      {
        a(i26, localBundle5);
        paramParcel2.writeNoException();
        return true;
      }
    case 8003:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i25 = paramParcel1.readInt();
      DataHolder localDataHolder24 = null;
      if (i25 != 0)
        localDataHolder24 = i.a(paramParcel1);
      n(localDataHolder24);
      paramParcel2.writeNoException();
      return true;
    case 8004:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i24 = paramParcel1.readInt();
      DataHolder localDataHolder23 = null;
      if (i24 != 0)
        localDataHolder23 = i.a(paramParcel1);
      o(localDataHolder23);
      paramParcel2.writeNoException();
      return true;
    case 8005:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i23 = paramParcel1.readInt();
      DataHolder localDataHolder22 = null;
      if (i23 != 0)
        localDataHolder22 = i.a(paramParcel1);
      p(localDataHolder22);
      paramParcel2.writeNoException();
      return true;
    case 8006:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i22 = paramParcel1.readInt();
      DataHolder localDataHolder21 = null;
      if (i22 != 0)
        localDataHolder21 = i.a(paramParcel1);
      q(localDataHolder21);
      paramParcel2.writeNoException();
      return true;
    case 8007:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      c(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8008:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i21 = paramParcel1.readInt();
      DataHolder localDataHolder20 = null;
      if (i21 != 0)
        localDataHolder20 = i.a(paramParcel1);
      r(localDataHolder20);
      paramParcel2.writeNoException();
      return true;
    case 8009:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      c(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8010:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 9001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i20 = paramParcel1.readInt();
      DataHolder localDataHolder19 = null;
      if (i20 != 0)
        localDataHolder19 = i.a(paramParcel1);
      j(localDataHolder19);
      paramParcel2.writeNoException();
      return true;
    case 10001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i19 = paramParcel1.readInt();
      DataHolder localDataHolder18 = null;
      if (i19 != 0)
        localDataHolder18 = i.a(paramParcel1);
      m(localDataHolder18);
      paramParcel2.writeNoException();
      return true;
    case 10002:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      b(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 10003:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i18 = paramParcel1.readInt();
      DataHolder localDataHolder17 = null;
      if (i18 != 0)
        localDataHolder17 = i.a(paramParcel1);
      D(localDataHolder17);
      paramParcel2.writeNoException();
      return true;
    case 10004:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i17 = paramParcel1.readInt();
      DataHolder localDataHolder16 = null;
      if (i17 != 0)
        localDataHolder16 = i.a(paramParcel1);
      E(localDataHolder16);
      paramParcel2.writeNoException();
      return true;
    case 10005:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i16 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle4 = null)
      {
        b(i16, localBundle4);
        paramParcel2.writeNoException();
        return true;
      }
    case 10006:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i15 = paramParcel1.readInt();
      DataHolder localDataHolder15 = null;
      if (i15 != 0)
        localDataHolder15 = i.a(paramParcel1);
      F(localDataHolder15);
      paramParcel2.writeNoException();
      return true;
    case 11001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i14 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle3 = null)
      {
        c(i14, localBundle3);
        paramParcel2.writeNoException();
        return true;
      }
    case 12001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i13 = paramParcel1.readInt();
      DataHolder localDataHolder14 = null;
      if (i13 != 0)
        localDataHolder14 = i.a(paramParcel1);
      G(localDataHolder14);
      paramParcel2.writeNoException();
      return true;
    case 12004:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      DataHolder localDataHolder13;
      if (paramParcel1.readInt() != 0)
      {
        localDataHolder13 = i.a(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label2955;
      }
      for (Contents localContents4 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1); ; localContents4 = null)
      {
        a(localDataHolder13, localContents4);
        paramParcel2.writeNoException();
        return true;
        localDataHolder13 = null;
        break;
      }
    case 12017:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      DataHolder localDataHolder12;
      String str1;
      Contents localContents1;
      if (paramParcel1.readInt() != 0)
      {
        localDataHolder12 = i.a(paramParcel1);
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() == 0)
          break label3086;
        localContents1 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label3092;
      }
      for (Contents localContents2 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1); ; localContents2 = null)
      {
        int i12 = paramParcel1.readInt();
        Contents localContents3 = null;
        if (i12 != 0)
          localContents3 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        a(localDataHolder12, str1, localContents1, localContents2, localContents3);
        paramParcel2.writeNoException();
        return true;
        localDataHolder12 = null;
        break;
        localContents1 = null;
        break label3011;
      }
    case 12005:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i11 = paramParcel1.readInt();
      DataHolder localDataHolder11 = null;
      if (i11 != 0)
        localDataHolder11 = i.a(paramParcel1);
      H(localDataHolder11);
      paramParcel2.writeNoException();
      return true;
    case 12012:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      e(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12003:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i10 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle2 = null)
      {
        d(i10, localBundle2);
        paramParcel2.writeNoException();
        return true;
      }
    case 12013:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i9 = paramParcel1.readInt();
      DataHolder localDataHolder10 = null;
      if (i9 != 0)
        localDataHolder10 = i.a(paramParcel1);
      N(localDataHolder10);
      paramParcel2.writeNoException();
      return true;
    case 12011:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i8 = paramParcel1.readInt();
      DataHolder localDataHolder9 = null;
      if (i8 != 0)
        localDataHolder9 = i.a(paramParcel1);
      b(localDataHolder9);
      paramParcel2.writeNoException();
      return true;
    case 12006:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i7 = paramParcel1.readInt();
      DataHolder localDataHolder8 = null;
      if (i7 != 0)
        localDataHolder8 = i.a(paramParcel1);
      I(localDataHolder8);
      paramParcel2.writeNoException();
      return true;
    case 12007:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i6 = paramParcel1.readInt();
      DataHolder localDataHolder7 = null;
      if (i6 != 0)
        localDataHolder7 = i.a(paramParcel1);
      J(localDataHolder7);
      paramParcel2.writeNoException();
      return true;
    case 12014:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i5 = paramParcel1.readInt();
      DataHolder localDataHolder6 = null;
      if (i5 != 0)
        localDataHolder6 = i.a(paramParcel1);
      K(localDataHolder6);
      paramParcel2.writeNoException();
      return true;
    case 12016:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i4 = paramParcel1.readInt();
      DataHolder localDataHolder5 = null;
      if (i4 != 0)
        localDataHolder5 = i.a(paramParcel1);
      L(localDataHolder5);
      paramParcel2.writeNoException();
      return true;
    case 12008:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i3 = paramParcel1.readInt();
      DataHolder localDataHolder4 = null;
      if (i3 != 0)
        localDataHolder4 = i.a(paramParcel1);
      M(localDataHolder4);
      paramParcel2.writeNoException();
      return true;
    case 12015:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i2 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle1 = null)
      {
        e(i2, localBundle1);
        paramParcel2.writeNoException();
        return true;
      }
    case 13001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int i1 = paramParcel1.readInt();
      DataHolder localDataHolder3 = null;
      if (i1 != 0)
        localDataHolder3 = i.a(paramParcel1);
      O(localDataHolder3);
      paramParcel2.writeNoException();
      return true;
    case 13002:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      c(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 14001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      a((DataHolder[])paramParcel1.createTypedArray(DataHolder.CREATOR));
      paramParcel2.writeNoException();
      return true;
    case 15001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int n = paramParcel1.readInt();
      DataHolder localDataHolder2 = null;
      if (n != 0)
        localDataHolder2 = i.a(paramParcel1);
      P(localDataHolder2);
      paramParcel2.writeNoException();
      return true;
    case 17001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int m = paramParcel1.readInt();
      DataHolder localDataHolder1 = null;
      if (m != 0)
        localDataHolder1 = i.a(paramParcel1);
      Q(localDataHolder1);
      paramParcel2.writeNoException();
      return true;
    case 17002:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      d(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 19001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      int k = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0);
      for (VideoCapabilities localVideoCapabilities = (VideoCapabilities)VideoCapabilities.CREATOR.createFromParcel(paramParcel1); ; localVideoCapabilities = null)
      {
        a(k, localVideoCapabilities);
        paramParcel2.writeNoException();
        return true;
      }
    case 19002:
      label2955: label3011: paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
      label3086: label3092: int i = paramParcel1.readInt();
      int j = paramParcel1.readInt();
      boolean bool1 = false;
      if (j != 0)
        bool1 = true;
      a(i, bool1);
      paramParcel2.writeNoException();
      return true;
    case 19003:
    }
    paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
    a(paramParcel1.readInt(), paramParcel1.createLongArray());
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.l
 * JD-Core Version:    0.6.0
 */