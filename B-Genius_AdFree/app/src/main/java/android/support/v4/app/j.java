package android.support.v4.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v4.b.a;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.U;
import com.google.android.gms.b.aN;
import com.google.android.gms.b.aR;
import com.google.android.gms.b.gP;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hn;
import com.google.android.gms.b.iV;
import com.google.android.gms.b.kC;
import com.google.android.gms.b.kF;
import com.google.android.gms.b.kI;
import com.google.android.gms.b.kK;
import com.google.android.gms.b.kL;
import com.google.android.gms.b.ku;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class j
  implements c
{
  public a a;
  public ArrayList b;
  public N c;
  public View d;

  private j()
  {
  }

  public j(f paramf)
  {
    this.a = new a();
    this.b = new ArrayList();
    this.c = new N();
  }

  public static int a(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    int j = a(paramParcel, i);
    int k = paramParcel.dataPosition();
    if ((0xFFFF & i) != 20293)
      throw new p("Expected object header. Got 0x" + Integer.toHexString(i), paramParcel);
    int m = k + j;
    if ((m < k) || (m > paramParcel.dataSize()))
      throw new p("Size read is invalid start=" + k + " end=" + m, paramParcel);
    return m;
  }

  public static int a(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536)
      return 0xFFFF & paramInt >> 16;
    return paramParcel.readInt();
  }

  public static long a(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt)
  {
    byte[] arrayOfByte = new byte[1024];
    long l = 0L;
    try
    {
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1)
          break;
        l += i;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      if (paramBoolean)
      {
        a(paramInputStream);
        a(paramOutputStream);
      }
    }
    if (paramBoolean)
    {
      a(paramInputStream);
      a(paramOutputStream);
    }
    return l;
  }

  public static Parcelable a(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Parcelable localParcelable = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(i + j);
    return localParcelable;
  }

  public static U a(gP paramgP)
  {
    long l1 = System.currentTimeMillis();
    Map localMap = paramgP.b;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    String str1 = (String)localMap.get("Date");
    if (str1 != null)
      l2 = b(str1);
    String str2 = (String)localMap.get("Cache-Control");
    int k;
    int i;
    long l9;
    long l10;
    String str6;
    if (str2 != null)
    {
      String[] arrayOfString = str2.split(",");
      k = 0;
      i = 0;
      l9 = l4;
      l10 = l3;
      if (k < arrayOfString.length)
      {
        str6 = arrayOfString[k].trim();
        if ((str6.equals("no-cache")) || (str6.equals("no-store")))
          return null;
        if (!str6.startsWith("max-age="));
      }
    }
    while (true)
    {
      try
      {
        long l12 = Long.parseLong(str6.substring(8));
        l10 = l12;
        k++;
        break;
        if (!str6.startsWith("stale-while-revalidate="))
          continue;
        try
        {
          long l11 = Long.parseLong(str6.substring(23));
          l9 = l11;
          continue;
          if ((!str6.equals("must-revalidate")) && (!str6.equals("proxy-revalidate")))
            continue;
          i = 1;
          continue;
          l3 = l10;
          l4 = l9;
          j = 1;
          String str3 = (String)localMap.get("Expires");
          if (str3 == null)
            continue;
          l5 = b(str3);
          String str4 = (String)localMap.get("Last-Modified");
          if (str4 == null)
            continue;
          l6 = b(str4);
          String str5 = (String)localMap.get("ETag");
          if (j == 0)
            continue;
          l8 = l1 + 1000L * l3;
          if (i == 0)
            continue;
          l7 = l8;
          U localU = new U();
          localU.a = paramgP.a;
          localU.b = str5;
          localU.f = l8;
          localU.e = l7;
          localU.c = l2;
          localU.d = l6;
          localU.g = localMap;
          return localU;
          l7 = l8 + 1000L * l4;
          continue;
          if ((l2 <= 0L) || (l5 < l2))
            continue;
          l7 = l1 + (l5 - l2);
          l8 = l7;
          continue;
        }
        catch (Exception localException1)
        {
        }
        continue;
      }
      catch (Exception localException2)
      {
        continue;
        long l7 = 0L;
        long l8 = 0L;
        continue;
        long l6 = 0L;
        continue;
        long l5 = 0L;
        continue;
      }
      i = 0;
      int j = 0;
    }
  }

  public static aN a(aR paramaR)
  {
    if (paramaR == null)
      return null;
    return paramaR.a();
  }

  public static aN a(aR paramaR, long paramLong)
  {
    if (paramaR == null)
      return null;
    return paramaR.a(paramLong);
  }

  public static iV a(Context paramContext, kK paramkK)
  {
    File localFile = new File(paramContext.getCacheDir(), "volley");
    Object localObject1 = "volley/0";
    try
    {
      String str1 = paramContext.getPackageName();
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str1, 0);
      String str2 = str1 + "/" + localPackageInfo.versionCode;
      localObject1 = str2;
      label69: if (Build.VERSION.SDK_INT >= 9);
      for (Object localObject2 = new kL(); ; localObject2 = new kI(AndroidHttpClient.newInstance((String)localObject1)))
      {
        kC localkC = new kC((kK)localObject2);
        iV localiV = new iV(new kF(localFile), localkC);
        localiV.a();
        return localiV;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label69;
    }
  }

  public static Object a(Callable paramCallable)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    try
    {
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitDiskReads().permitDiskWrites().build());
      Object localObject2 = paramCallable.call();
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      hc.b("Unexpected exception.", localThrowable);
      P.h().a(localThrowable, true);
      return null;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
    throw localObject1;
  }

  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "unknown status code: " + paramInt;
    case -1:
      return "SUCCESS_CACHE";
    case 0:
      return "SUCCESS";
    case 1:
      return "SERVICE_MISSING";
    case 2:
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3:
      return "SERVICE_DISABLED";
    case 4:
      return "SIGN_IN_REQUIRED";
    case 5:
      return "INVALID_ACCOUNT";
    case 6:
      return "RESOLUTION_REQUIRED";
    case 7:
      return "NETWORK_ERROR";
    case 8:
      return "INTERNAL_ERROR";
    case 9:
      return "SERVICE_INVALID";
    case 10:
      return "DEVELOPER_ERROR";
    case 11:
      return "LICENSE_CHECK_FAILED";
    case 13:
      return "ERROR";
    case 14:
      return "INTERRUPTED";
    case 15:
      return "TIMEOUT";
    case 16:
      return "CANCELED";
    case 17:
      return "API_NOT_CONNECTED";
    case 3000:
      return "AUTH_API_INVALID_CREDENTIALS";
    case 3001:
      return "AUTH_API_ACCESS_FORBIDDEN";
    case 3002:
      return "AUTH_API_CLIENT_ERROR";
    case 3003:
      return "AUTH_API_SERVER_ERROR";
    case 3004:
      return "AUTH_TOKEN_ERROR";
    case 3005:
    }
    return "AUTH_URL_RESOLUTION";
  }

  public static String a(int paramInt1, int paramInt2)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt2 + 3;
    int j = 3;
    if (j < i)
    {
      if (j + 4 >= arrayOfStackTraceElement.length);
      StackTraceElement localStackTraceElement;
      for (String str = "<bottom of call stack>"; ; str = localStackTraceElement.getClassName() + "." + localStackTraceElement.getMethodName() + ":" + localStackTraceElement.getLineNumber())
      {
        localStringBuffer.append(str).append(" ");
        j++;
        break;
        localStackTraceElement = arrayOfStackTraceElement[(j + 4)];
      }
    }
    return localStringBuffer.toString();
  }

  public static String a(Context paramContext, int paramInt, String paramString)
  {
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    default:
      return localResources.getString(2130968593, new Object[] { paramString });
    case 1:
      int j;
      int k;
      if (localResources != null)
        if ((0xF & localResources.getConfiguration().screenLayout) > 3)
        {
          j = 1;
          if ((!c(11)) || (j == 0))
          {
            Configuration localConfiguration = localResources.getConfiguration();
            if (!c(13))
              break label235;
            if (((0xF & localConfiguration.screenLayout) > 3) || (localConfiguration.smallestScreenWidthDp < 600))
              break label229;
            k = 1;
            if (k == 0)
              break label241;
          }
        }
      for (int i = 1; ; i = 0)
      {
        if (i == 0)
          break label247;
        return localResources.getString(2130968582, new Object[] { paramString });
        j = 0;
        break;
        k = 0;
        break label194;
        k = 0;
        break label194;
      }
      return localResources.getString(2130968581, new Object[] { paramString });
    case 3:
      return localResources.getString(2130968578, new Object[] { paramString });
    case 18:
      return localResources.getString(2130968599, new Object[] { paramString });
    case 2:
      return localResources.getString(2130968597, new Object[] { paramString });
    case 42:
      return localResources.getString(2130968601);
    case 9:
      return localResources.getString(2130968594, new Object[] { paramString });
    case 7:
      return localResources.getString(2130968586);
    case 5:
      return localResources.getString(2130968584);
    case 16:
      return localResources.getString(2130968576, new Object[] { paramString });
    case 17:
      label194: label229: label235: label241: label247: return localResources.getString(2130968591);
    case 20:
    }
    return localResources.getString(2130968589);
  }

  public static String a(ku paramku)
  {
    if (paramku == null)
      return "";
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      a(null, paramku, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return "Error printing proto: " + localIllegalAccessException.getMessage();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    return "Error printing proto: " + localInvocationTargetException.getMessage();
  }

  public static String a(Map paramMap)
  {
    String str = (String)paramMap.get("Content-Type");
    if (str != null)
    {
      String[] arrayOfString1 = str.split(";");
      for (int i = 1; i < arrayOfString1.length; i++)
      {
        String[] arrayOfString2 = arrayOfString1[i].trim().split("=");
        if ((arrayOfString2.length == 2) && (arrayOfString2[0].equals("charset")))
          return arrayOfString2[1];
      }
    }
    return "ISO-8859-1";
  }

  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    return Base64.encodeToString(paramArrayOfByte, 0);
  }

  public static PublicKey a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      PublicKey localPublicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrayOfByte));
      return localPublicKey;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
    catch (InvalidKeySpecException localInvalidKeySpecException)
    {
      hc.b("Invalid key specification.");
    }
    throw new IllegalArgumentException(localInvalidKeySpecException);
  }

  public static void a(Parcel paramParcel, int paramInt, float paramFloat)
  {
    d(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }

  public static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    d(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }

  public static void a(Parcel paramParcel, int paramInt, long paramLong)
  {
    d(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }

  public static void a(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null)
      return;
    int i = y(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    z(paramParcel, i);
  }

  public static void a(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    if (paramIBinder == null)
      return;
    int i = y(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    z(paramParcel, i);
  }

  public static void a(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean)
  {
    if (paramParcel2 == null)
      return;
    int i = y(paramParcel1, 2);
    paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
    z(paramParcel1, i);
  }

  public static void a(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable == null)
    {
      if (paramBoolean)
        d(paramParcel, paramInt1, 0);
      return;
    }
    int i = y(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    z(paramParcel, i);
  }

  public static void a(Parcel paramParcel, int paramInt, Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null)
      return;
    d(paramParcel, 3, 4);
    if (paramBoolean.booleanValue());
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }

  public static void a(Parcel paramParcel, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    if (paramInteger == null)
      return;
    d(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
  }

  public static void a(Parcel paramParcel, int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (paramLong == null)
      return;
    d(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong.longValue());
  }

  public static void a(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      if (paramBoolean)
        d(paramParcel, paramInt, 0);
      return;
    }
    int i = y(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    z(paramParcel, i);
  }

  public static void a(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null)
      return;
    int i = y(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    z(paramParcel, i);
  }

  public static void a(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    d(paramParcel, paramInt, 4);
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }

  public static void a(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
      return;
    int i = y(paramParcel, 3);
    paramParcel.writeByteArray(paramArrayOfByte);
    z(paramParcel, i);
  }

  public static void a(Parcel paramParcel, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt == null)
      return;
    int i = y(paramParcel, 4);
    paramParcel.writeIntArray(paramArrayOfInt);
    z(paramParcel, i);
  }

  public static void a(Parcel paramParcel, int paramInt1, Parcelable[] paramArrayOfParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfParcelable == null)
      return;
    int i = y(paramParcel, paramInt1);
    int j = paramArrayOfParcelable.length;
    paramParcel.writeInt(j);
    int k = 0;
    if (k < j)
    {
      Parcelable localParcelable = paramArrayOfParcelable[k];
      if (localParcelable == null)
        paramParcel.writeInt(0);
      while (true)
      {
        k++;
        break;
        a(paramParcel, localParcelable, paramInt2);
      }
    }
    z(paramParcel, i);
  }

  public static void a(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null)
      return;
    int i = y(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    z(paramParcel, i);
  }

  public static void a(Parcel paramParcel, int paramInt, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (paramArrayOfBoolean == null)
      return;
    int i = y(paramParcel, paramInt);
    paramParcel.writeBooleanArray(paramArrayOfBoolean);
    z(paramParcel, i);
  }

  private static void a(Parcel paramParcel, Parcelable paramParcelable, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramParcelable.writeToParcel(paramParcel, paramInt);
    int k = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(k - j);
    paramParcel.setDataPosition(k);
  }

  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static void a(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("null reference");
  }

  public static void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
      return;
    }
    String str = paramObject.getClass().getSimpleName();
    if ((str == null) || (str.length() <= 0))
    {
      str = paramObject.getClass().getName();
      int i = str.lastIndexOf('.');
      if (i > 0)
        str = str.substring(i + 1);
    }
    paramStringBuilder.append(str);
    paramStringBuilder.append('{');
    paramStringBuilder.append(Integer.toHexString(System.identityHashCode(paramObject)));
  }

  private static void a(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
  {
    int i;
    Class localClass1;
    label197: label245: Method[] arrayOfMethod;
    int m;
    int n;
    if (paramObject != null)
    {
      if (!(paramObject instanceof ku))
        break label431;
      i = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(c(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      localClass1 = paramObject.getClass();
      Field[] arrayOfField = localClass1.getFields();
      int j = arrayOfField.length;
      int k = 0;
      if (k < j)
      {
        Field localField = arrayOfField[k];
        int i1 = localField.getModifiers();
        String str6 = localField.getName();
        Object localObject;
        if ((!"cachedSize".equals(str6)) && ((i1 & 0x1) == 1) && ((i1 & 0x8) != 8) && (!str6.startsWith("_")) && (!str6.endsWith("_")))
        {
          Class localClass2 = localField.getType();
          localObject = localField.get(paramObject);
          if (!localClass2.isArray())
            break label245;
          if (localClass2.getComponentType() != Byte.TYPE)
            break label197;
          a(str6, localObject, paramStringBuffer1, paramStringBuffer2);
        }
        while (true)
        {
          k++;
          break;
          if (localObject == null);
          for (int i2 = 0; ; i2 = Array.getLength(localObject))
          {
            for (int i3 = 0; i3 < i2; i3++)
              a(str6, Array.get(localObject, i3), paramStringBuffer1, paramStringBuffer2);
            break;
          }
          a(str6, localObject, paramStringBuffer1, paramStringBuffer2);
        }
      }
      arrayOfMethod = localClass1.getMethods();
      m = arrayOfMethod.length;
      n = 0;
    }
    while (true)
    {
      String str5;
      if (n < m)
      {
        String str4 = arrayOfMethod[n].getName();
        if (str4.startsWith("set"))
          str5 = str4.substring(3);
      }
      try
      {
        Method localMethod1 = localClass1.getMethod("has" + str5, new Class[0]);
        if (((Boolean)localMethod1.invoke(paramObject, new Object[0])).booleanValue());
        try
        {
          Method localMethod2 = localClass1.getMethod("get" + str5, new Class[0]);
          a(str5, localMethod2.invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
          label402: n++;
          continue;
          if (paramString != null)
          {
            paramStringBuffer1.setLength(i);
            paramStringBuffer2.append(paramStringBuffer1).append(">\n");
          }
          return;
          label431: String str1 = c(paramString);
          paramStringBuffer2.append(paramStringBuffer1).append(str1).append(": ");
          if ((paramObject instanceof String))
          {
            String str2 = (String)paramObject;
            if ((!str2.startsWith("http")) && (str2.length() > 200))
              str2 = str2.substring(0, 200) + "[...]";
            String str3 = d(str2);
            paramStringBuffer2.append("\"").append(str3).append("\"");
          }
          while (true)
          {
            paramStringBuffer2.append("\n");
            return;
            if ((paramObject instanceof byte[]))
            {
              a((byte[])paramObject, paramStringBuffer2);
              continue;
            }
            paramStringBuffer2.append(paramObject);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label402;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        break label402;
      }
    }
  }

  public static void a(StringBuilder paramStringBuilder, HashMap paramHashMap)
  {
    paramStringBuilder.append("{");
    Iterator localIterator = paramHashMap.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (i == 0)
        paramStringBuilder.append(",");
      String str2;
      for (int j = i; ; j = 0)
      {
        str2 = (String)paramHashMap.get(str1);
        paramStringBuilder.append("\"").append(str1).append("\":");
        if (str2 != null)
          break label113;
        paramStringBuilder.append("null");
        i = j;
        break;
      }
      label113: paramStringBuilder.append("\"").append(str2).append("\"");
      i = j;
    }
    paramStringBuilder.append("}");
  }

  public static void a(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int i = paramArrayOfDouble.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[j]));
    }
  }

  public static void a(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int i = paramArrayOfFloat.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[j]));
    }
  }

  public static void a(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int i = paramArrayOfLong.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(Long.toString(paramArrayOfLong[j]));
    }
  }

  public static void a(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(paramArrayOfObject[j].toString());
    }
  }

  public static void a(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append("\"").append(paramArrayOfString[j]).append("\"");
    }
  }

  public static void a(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int i = paramArrayOfBoolean.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[j]));
    }
  }

  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }

  private static void a(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuffer.append("\"\"");
      return;
    }
    paramStringBuffer.append('"');
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = 0xFF & paramArrayOfByte[i];
      if ((j == 92) || (j == 34))
        paramStringBuffer.append('\\').append((char)j);
      while (true)
      {
        i++;
        break;
        if ((j >= 32) && (j < 127))
        {
          paramStringBuffer.append((char)j);
          continue;
        }
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(j);
        paramStringBuffer.append(String.format("\\%03o", arrayOfObject));
      }
    }
    paramStringBuffer.append('"');
  }

  public static boolean a()
  {
    return c(11);
  }

  public static boolean a(Context paramContext)
  {
    return (c(20)) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
  }

  public static boolean a(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getApplicationInfo(paramString, 0).flags;
      int j = i & 0x200000;
      int k = 0;
      if (j != 0)
        k = 1;
      return k;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static boolean a(aR paramaR, aN paramaN, String[] paramArrayOfString)
  {
    if ((paramaR == null) || (paramaN == null))
      return false;
    return paramaR.a(paramaN, paramArrayOfString);
  }

  public static boolean a(PublicKey paramPublicKey, String paramString1, String paramString2)
  {
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramString1.getBytes());
      if (!localSignature.verify(Base64.decode(paramString2, 0)))
      {
        hc.b("Signature verification failed.");
        return false;
      }
      return true;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      hc.b("NoSuchAlgorithmException.");
      return false;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      hc.b("Invalid key specification.");
      return false;
    }
    catch (SignatureException localSignatureException)
    {
      hc.b("Signature exception.");
    }
    return false;
  }

  public static String[] a(Set paramSet)
  {
    w.a(paramSet, "scopes can't be null.");
    Scope[] arrayOfScope = (Scope[])paramSet.toArray(new Scope[paramSet.size()]);
    w.a(arrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[arrayOfScope.length];
    for (int i = 0; i < arrayOfScope.length; i++)
      arrayOfString[i] = arrayOfScope[i].a();
    return arrayOfString;
  }

  public static int b(Parcel paramParcel)
  {
    return y(paramParcel, 20293);
  }

  public static long b(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException localDateParseException)
    {
    }
    return 0L;
  }

  public static Status b(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      str = String.format("Status code (%d) not found!", arrayOfObject);
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 14:
    case 15:
    case 500:
    case 1000:
    case 1001:
    case 1002:
    case 1003:
    case 1500:
    case 2000:
    case 2001:
    case 2002:
    case 3000:
    case 3001:
    case 3002:
    case 3003:
    case 4000:
    case 4001:
    case 4002:
    case 4003:
    case 4004:
    case 4006:
    case 6000:
    case 6001:
    case 6002:
    case 6003:
    case 6500:
    case 6501:
    case 6503:
    case 6504:
    case 6505:
    case 6506:
    case 6507:
    case 7000:
    case 7001:
    case 7002:
    case 7003:
    case 7004:
    case 7005:
    case 7006:
    case 7007:
    case 8000:
    case 8001:
    case 8002:
    case 8003:
    case 9000:
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
    case 9014:
    case 9015:
    case 9100:
    case 9101:
    }
    while (true)
    {
      return new Status(paramInt, str);
      str = "STATUS_OK";
      continue;
      str = "STATUS_INTERNAL_ERROR";
      continue;
      str = "STATUS_CLIENT_RECONNECT_REQUIRED";
      continue;
      str = "STATUS_NETWORK_ERROR_STALE_DATA";
      continue;
      str = "STATUS_NETWORK_ERROR_NO_DATA";
      continue;
      str = "STATUS_NETWORK_ERROR_OPERATION_DEFERRED";
      continue;
      str = "STATUS_NETWORK_ERROR_OPERATION_FAILED";
      continue;
      str = "STATUS_LICENSE_CHECK_FAILED";
      continue;
      str = "STATUS_APP_MISCONFIGURED";
      continue;
      str = "STATUS_GAME_NOT_FOUND";
      continue;
      str = "STATUS_INTERRUPTED";
      continue;
      str = "STATUS_TIMEOUT";
      continue;
      str = "STATUS_RESOLVE_STALE_OR_NO_DATA";
      continue;
      str = "STATUS_AUTH_ERROR_HARD";
      continue;
      str = "STATUS_AUTH_ERROR_USER_RECOVERABLE";
      continue;
      str = "STATUS_AUTH_ERROR_UNREGISTERED_CLIENT_ID";
      continue;
      str = "STATUS_AUTH_ERROR_API_ACCESS_DENIED";
      continue;
      str = "STATUS_PLAYER_OOB_REQUIRED";
      continue;
      str = "STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS";
      continue;
      str = "STATUS_REQUEST_UPDATE_TOTAL_FAILURE";
      continue;
      str = "STATUS_REQUEST_TOO_MANY_RECIPIENTS";
      continue;
      str = "STATUS_ACHIEVEMENT_UNLOCK_FAILURE";
      continue;
      str = "STATUS_ACHIEVEMENT_UNKNOWN";
      continue;
      str = "STATUS_ACHIEVEMENT_NOT_INCREMENTAL";
      continue;
      str = "STATUS_ACHIEVEMENT_UNLOCKED";
      continue;
      str = "STATUS_SNAPSHOT_NOT_FOUND";
      continue;
      str = "STATUS_SNAPSHOT_CREATION_FAILED";
      continue;
      str = "STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE";
      continue;
      str = "STATUS_SNAPSHOT_COMMIT_FAILED";
      continue;
      str = "STATUS_SNAPSHOT_CONFLICT";
      continue;
      str = "STATUS_SNAPSHOT_CONFLICT_MISSING";
      continue;
      str = "STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED";
      continue;
      str = "STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER";
      continue;
      str = "STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE";
      continue;
      str = "STATUS_MULTIPLAYER_DISABLED";
      continue;
      str = "STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE";
      continue;
      str = "STATUS_MATCH_ERROR_INACTIVE_MATCH";
      continue;
      str = "STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION";
      continue;
      str = "STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS";
      continue;
      str = "STATUS_MATCH_ERROR_ALREADY_REMATCHED";
      continue;
      str = "STATUS_MATCH_NOT_FOUND";
      continue;
      str = "STATUS_MATCH_ERROR_LOCALLY_MODIFIED";
      continue;
      str = "STATUS_REAL_TIME_CONNECTION_FAILED";
      continue;
      str = "STATUS_REAL_TIME_MESSAGE_SEND_FAILED";
      continue;
      str = "STATUS_INVALID_REAL_TIME_ROOM_ID";
      continue;
      str = "STATUS_PARTICIPANT_NOT_CONNECTED";
      continue;
      str = "STATUS_REAL_TIME_ROOM_NOT_JOINED";
      continue;
      str = "STATUS_REAL_TIME_INACTIVE_ROOM";
      continue;
      str = "STATUS_REAL_TIME_SERVICE_NOT_CONNECTED";
      continue;
      str = "STATUS_OPERATION_IN_FLIGHT";
      continue;
      str = "STATUS_MILESTONE_CLAIMED_PREVIOUSLY";
      continue;
      str = "STATUS_MILESTONE_CLAIM_FAILED";
      continue;
      str = "STATUS_QUEST_NO_LONGER_AVAILABLE";
      continue;
      str = "STATUS_QUEST_NOT_STARTED";
      continue;
      str = "STATUS_VIDEO_NOT_ACTIVE";
      continue;
      str = "STATUS_VIDEO_UNSUPPORTED";
      continue;
      str = "STATUS_VIDEO_PERMISSION_ERROR";
      continue;
      str = "STATUS_VIDEO_STORAGE_ERROR";
      continue;
      str = "STATUS_VIDEO_DISPLAY_ERROR";
      continue;
      str = "STATUS_VIDEO_CODEC_ERROR";
      continue;
      str = "STATUS_VIDEO_ALREADY_RECORDING";
      continue;
      str = "STATUS_VIDEO_STREAM_ERROR";
      continue;
      str = "STATUS_VIDEO_NO_STREAMING_TARGET";
      continue;
      str = "STATUS_VIDEO_OUT_OF_DISK_SPACE";
      continue;
      str = "STATUS_VIDEO_NO_MIC";
      continue;
      str = "STATUS_VIDEO_NO_CAMERA";
      continue;
      str = "STATUS_VIDEO_SCREEN_OFF";
      continue;
      str = "STATUS_VIDEO_INVALID_STATE";
      continue;
      str = "STATUS_VIDEO_AUDIO_ENCODER_ERROR";
      continue;
      str = "STATUS_VIDEO_MEDIA_MUX_ERROR";
      continue;
      str = "STATUS_YOUTUBE_LIVE_STREAM_UNKNOWN_ERROR";
      continue;
      str = "STATUS_YOUTUBE_LIVE_STREAM_NOT_ENABLED";
    }
  }

  public static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    return Base64.encodeToString(paramArrayOfByte, 10);
  }

  public static void b(Parcel paramParcel, int paramInt)
  {
    paramParcel.setDataPosition(a(paramParcel, paramInt) + paramParcel.dataPosition());
  }

  private static void b(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    int i = a(paramParcel, paramInt1);
    if (i != paramInt2)
      throw new p("Expected size " + paramInt2 + " got " + i + " (0x" + Integer.toHexString(i) + ")", paramParcel);
  }

  public static void b(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean)
        d(paramParcel, paramInt, 0);
      return;
    }
    int i = y(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    int k = 0;
    if (k < j)
    {
      Parcelable localParcelable = (Parcelable)paramList.get(k);
      if (localParcelable == null)
        paramParcel.writeInt(0);
      while (true)
      {
        k++;
        break;
        a(paramParcel, localParcelable, 0);
      }
    }
    z(paramParcel, i);
  }

  public static boolean b()
  {
    return c(12);
  }

  public static Object[] b(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Object[] arrayOfObject = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(i + j);
    return arrayOfObject;
  }

  private static String c(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      if (i == 0)
        localStringBuffer.append(Character.toLowerCase(c1));
      while (true)
      {
        i++;
        break;
        if (Character.isUpperCase(c1))
        {
          localStringBuffer.append('_').append(Character.toLowerCase(c1));
          continue;
        }
        localStringBuffer.append(c1);
      }
    }
    return localStringBuffer.toString();
  }

  public static ArrayList c(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(i + j);
    return localArrayList;
  }

  private static void c(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
      throw new p("Expected size " + paramInt2 + " got " + paramInt1 + " (0x" + Integer.toHexString(paramInt1) + ")", paramParcel);
  }

  public static boolean c()
  {
    return c(14);
  }

  private static boolean c(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }

  public static boolean c(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 4);
    return paramParcel.readInt() != 0;
  }

  public static Boolean d(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    if (i == 0)
      return null;
    c(paramParcel, i, 4);
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }

  private static String d(String paramString)
  {
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    int j = 0;
    if (j < i)
    {
      char c1 = paramString.charAt(j);
      if ((c1 >= ' ') && (c1 <= '~') && (c1 != '"') && (c1 != '\''))
        localStringBuilder.append(c1);
      while (true)
      {
        j++;
        break;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(c1);
        localStringBuilder.append(String.format("\\u%04x", arrayOfObject));
      }
    }
    return localStringBuilder.toString();
  }

  private static void d(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt1 | paramInt2 << 16);
  }

  public static boolean d()
  {
    return c(16);
  }

  public static int e(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }

  public static boolean e()
  {
    return c(17);
  }

  public static Integer f(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    if (i == 0)
      return null;
    c(paramParcel, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }

  public static boolean f()
  {
    return c(18);
  }

  public static long g(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }

  public static boolean g()
  {
    return c(19);
  }

  public static Long h(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    if (i == 0)
      return null;
    c(paramParcel, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }

  public static boolean h()
  {
    return c(21);
  }

  public static BigInteger i(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + j);
    return new BigInteger(arrayOfByte);
  }

  public static boolean i()
  {
    return c(21);
  }

  public static float j(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }

  public static boolean j()
  {
    return c(23);
  }

  public static double k(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }

  public static BigDecimal l(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    byte[] arrayOfByte = paramParcel.createByteArray();
    int k = paramParcel.readInt();
    paramParcel.setDataPosition(i + j);
    return new BigDecimal(new BigInteger(arrayOfByte), k);
  }

  public static String m(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    String str = paramParcel.readString();
    paramParcel.setDataPosition(i + j);
    return str;
  }

  public static IBinder n(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(i + j);
    return localIBinder;
  }

  public static Bundle o(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(i + j);
    return localBundle;
  }

  public static byte[] p(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfByte;
  }

  public static boolean[] q(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfBoolean;
  }

  public static int[] r(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfInt;
  }

  public static BigDecimal[] s(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    for (int m = 0; m < k; m++)
    {
      byte[] arrayOfByte = paramParcel.createByteArray();
      int n = paramParcel.readInt();
      arrayOfBigDecimal[m] = new BigDecimal(new BigInteger(arrayOfByte), n);
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfBigDecimal;
  }

  public static String[] t(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfString;
  }

  public static ArrayList u(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(i + j);
    return localArrayList;
  }

  public static Parcel v(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Parcel localParcel = Parcel.obtain();
    localParcel.appendFrom(paramParcel, j, i);
    paramParcel.setDataPosition(i + j);
    return localParcel;
  }

  public static Parcel[] w(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    Parcel[] arrayOfParcel = new Parcel[k];
    int m = 0;
    if (m < k)
    {
      int n = paramParcel.readInt();
      if (n != 0)
      {
        int i1 = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, i1, n);
        arrayOfParcel[m] = localParcel;
        paramParcel.setDataPosition(n + i1);
      }
      while (true)
      {
        m++;
        break;
        arrayOfParcel[m] = null;
      }
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfParcel;
  }

  public static void x(Parcel paramParcel, int paramInt)
  {
    z(paramParcel, paramInt);
  }

  private static int y(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }

  private static void z(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    int j = i - paramInt;
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(j);
    paramParcel.setDataPosition(i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.j
 * JD-Core Version:    0.6.0
 */