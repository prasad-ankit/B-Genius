package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class r extends Binder
  implements q
{
  public static q a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
    if ((localIInterface != null) && ((localIInterface instanceof q)))
      return (q)localIInterface;
    return new s(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.games.internal.IGamesService");
      return true;
    case 5001:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 5002:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(l.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5003:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      String str = a();
    case 5004:
    case 5005:
    case 5006:
    case 5007:
    case 5064:
    case 5065:
    case 5012:
    case 5013:
    case 5014:
    case 5015:
    case 5016:
    case 5017:
    case 5018:
    case 5019:
    case 5020:
    case 5021:
    case 5022:
    case 5023:
    case 5024:
    case 5025:
    case 5026:
    case 5027:
    case 5028:
    case 5029:
    case 5058:
    case 5059:
    case 5030:
    case 5031:
    case 5032:
    case 5033:
    case 5034:
    case 5035:
    case 5036:
    case 5037:
    case 5038:
    case 5039:
    case 5040:
    case 5041:
    case 5042:
    case 5043:
    case 5044:
    case 5045:
    case 5046:
    case 5047:
    case 5048:
    case 5049:
    case 5050:
    case 5051:
    case 5052:
    case 5053:
    case 5060:
    case 5054:
    case 5061:
    case 5055:
    case 5067:
    case 5068:
    case 5056:
    case 5057:
    case 5062:
    case 5063:
    case 5066:
    case 5501:
    case 5502:
    case 6001:
    case 6002:
    case 6003:
    case 6004:
    case 6501:
    case 6502:
    case 6503:
    case 6504:
    case 6505:
    case 6506:
    case 6507:
    case 7001:
    case 7002:
    case 7003:
    case 8001:
    case 8002:
    case 8003:
    case 8004:
    case 8005:
    case 8006:
    case 8007:
    case 8008:
    case 8009:
    case 8010:
    case 8011:
    case 8012:
    case 8013:
    case 8014:
    case 8024:
    case 8025:
    case 8015:
    case 8016:
    case 8017:
    case 8026:
    case 8018:
    case 8019:
    case 8020:
    case 8021:
    case 8022:
    case 8023:
    case 8027:
    case 9001:
    case 9002:
    case 9003:
    case 9004:
    case 9005:
    case 9006:
    case 9007:
    case 9008:
    case 9009:
    case 9010:
    case 9011:
    case 9012:
    case 9013:
    case 9031:
    case 9019:
    case 9020:
    case 9028:
    case 9030:
    case 10001:
    case 10002:
    case 10003:
    case 10004:
    case 10005:
    case 10006:
    case 10007:
    case 10008:
    case 10009:
    case 10010:
    case 10011:
    case 10012:
    case 10013:
    case 10023:
    case 10015:
    case 10022:
    case 10014:
    case 10016:
    case 10017:
    case 10021:
    case 10018:
    case 10019:
    case 10020:
    case 11001:
    case 11002:
    case 12001:
    case 12002:
    case 12003:
    case 12006:
    case 12007:
    case 12019:
    case 12020:
    case 12033:
    case 12035:
    case 12036:
    case 12005:
    case 12023:
    case 12024:
    case 12021:
    case 12022:
    case 12025:
    case 12026:
    case 12027:
    case 12032:
    case 12016:
    case 12031:
    case 12017:
    case 12008:
    case 12009:
    case 12010:
    case 12029:
    case 12015:
    case 12028:
    case 12011:
    case 12013:
    case 12012:
    case 12014:
    case 12030:
    case 12034:
    case 12018:
    case 13001:
    case 13002:
    case 13003:
    case 13004:
    case 13005:
    case 13006:
    case 14001:
    case 14002:
    case 14003:
    case 15001:
    case 15002:
    case 15501:
    case 15502:
    case 15503:
    case 15504:
    case 16001:
    case 17001:
    case 18001:
    case 19001:
    case 19002:
    case 19003:
    case 19004:
    case 20001:
    case 21001:
    case 21002:
    case 21003:
    case 21004:
    case 21005:
    case 21006:
    case 21007:
    case 21008:
    case 21009:
    case 21010:
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.r
 * JD-Core Version:    0.6.0
 */