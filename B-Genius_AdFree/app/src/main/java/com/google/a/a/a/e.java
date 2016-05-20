package com.google.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class e
{
  private static final String[] a = { "*Unknown error.", "*Failed to sign in. Please check your network connection and try again.", "*The application is incorrectly configured. Check that the package name and signing certificate match the client ID created in Developer Console. Also, if the application is not yet published, check that the account you are trying to sign in with is listed as a tester account. See logs for more information.", "*License check failed." };
  private static final int[] b = { 2130968619, 2130968618, 2130968616, 2130968617 };

  static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return String.valueOf(paramInt);
    case -1:
      return "RESULT_OK";
    case 0:
      return "RESULT_CANCELED";
    case 10004:
      return "RESULT_APP_MISCONFIGURED";
    case 10005:
      return "RESULT_LEFT_ROOM";
    case 10003:
      return "RESULT_LICENSE_FAILED";
    case 10001:
      return "RESULT_RECONNECT_REQUIRED";
    case 10002:
    }
    return "SIGN_IN_FAILED";
  }

  static String a(Context paramContext, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 4));
    while (true)
    {
      int i = b[paramInt];
      try
      {
        String str = paramContext.getString(i);
        return str;
        paramInt = 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Log.w("GameHelper", "*** GameHelper could not found resource id #" + i + ". This probably happened because you included it as a stand-alone JAR. " + "BaseGameUtils should be compiled as a LIBRARY PROJECT, so that it can access its resources. Using a fallback string.");
      }
    }
    return a[paramInt];
  }

  static void a(Context paramContext)
  {
    Log.w("GameHelper", "****");
    Log.w("GameHelper", "****");
    Log.w("GameHelper", "**** APP NOT CORRECTLY CONFIGURED TO USE GOOGLE PLAY GAME SERVICES");
    Log.w("GameHelper", "**** This is usually caused by one of these reasons:");
    Log.w("GameHelper", "**** (1) Your package name and certificate fingerprint do not match");
    Log.w("GameHelper", "****     the client ID you registered in Developer Console.");
    Log.w("GameHelper", "**** (2) Your App ID was incorrectly entered.");
    Log.w("GameHelper", "**** (3) Your game settings have not been published and you are ");
    Log.w("GameHelper", "****     trying to log in with an account that is not listed as");
    Log.w("GameHelper", "****     a test account.");
    Log.w("GameHelper", "****");
    if (paramContext == null)
    {
      Log.w("GameHelper", "*** (no Context, so can't print more debug info)");
      return;
    }
    Log.w("GameHelper", "**** To help you debug, here is the information about this app");
    Log.w("GameHelper", "**** Package name         : " + paramContext.getPackageName());
    Log.w("GameHelper", "**** Cert SHA1 fingerprint: " + c(paramContext));
    Log.w("GameHelper", "**** App ID from          : " + b(paramContext));
    Log.w("GameHelper", "****");
    Log.w("GameHelper", "**** Check that the above information matches your setup in ");
    Log.w("GameHelper", "**** Developer Console. Also, check that you're logging in with the");
    Log.w("GameHelper", "**** right account (it should be listed in the Testers section if");
    Log.w("GameHelper", "**** your project is not yet published).");
    Log.w("GameHelper", "****");
    Log.w("GameHelper", "**** For more information, refer to the troubleshooting guide:");
    Log.w("GameHelper", "****   http://developers.google.com/games/services/android/troubleshooting");
  }

  static String b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "Unknown error code " + paramInt;
    case 10:
      return "DEVELOPER_ERROR(" + paramInt + ")";
    case 8:
      return "INTERNAL_ERROR(" + paramInt + ")";
    case 5:
      return "INVALID_ACCOUNT(" + paramInt + ")";
    case 11:
      return "LICENSE_CHECK_FAILED(" + paramInt + ")";
    case 7:
      return "NETWORK_ERROR(" + paramInt + ")";
    case 6:
      return "RESOLUTION_REQUIRED(" + paramInt + ")";
    case 3:
      return "SERVICE_DISABLED(" + paramInt + ")";
    case 9:
      return "SERVICE_INVALID(" + paramInt + ")";
    case 1:
      return "SERVICE_MISSING(" + paramInt + ")";
    case 2:
      return "SERVICE_VERSION_UPDATE_REQUIRED(" + paramInt + ")";
    case 4:
      return "SIGN_IN_REQUIRED(" + paramInt + ")";
    case 0:
    }
    return "SUCCESS(" + paramInt + ")";
  }

  private static String b(Context paramContext)
  {
    try
    {
      Resources localResources = paramContext.getResources();
      String str = localResources.getString(localResources.getIdentifier("app_id", "string", paramContext.getPackageName()));
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "??? (failed to retrieve APP ID)";
  }

  private static String c(Context paramContext)
  {
    try
    {
      Signature[] arrayOfSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures;
      if (arrayOfSignature.length == 0)
        return "ERROR: NO SIGNATURE.";
      if (arrayOfSignature.length > 1)
        return "ERROR: MULTIPLE SIGNATURES";
      byte[] arrayOfByte = MessageDigest.getInstance("SHA1").digest(arrayOfSignature[0].toByteArray());
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < arrayOfByte.length; i++)
      {
        if (i > 0)
          localStringBuilder.append(":");
        int j = arrayOfByte[i];
        if (j < 0)
          j += 256;
        int k = j / 16;
        int m = j % 16;
        localStringBuilder.append("0123456789ABCDEF".substring(k, k + 1));
        localStringBuilder.append("0123456789ABCDEF".substring(m, m + 1));
      }
      String str = localStringBuilder.toString();
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      return "(ERROR: package not found)";
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return "(ERROR: SHA1 algorithm not found)";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.a.a.a.e
 * JD-Core Version:    0.6.0
 */