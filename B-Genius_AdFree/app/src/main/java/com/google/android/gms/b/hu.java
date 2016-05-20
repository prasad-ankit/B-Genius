package com.google.android.gms.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.support.v4.app.w;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.F;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.common.q;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hu
{
  public static final Handler a = new hd(Looper.getMainLooper());
  private final Object b = new Object();
  private boolean c = true;
  private String d;
  private boolean e = false;

  public static Bitmap a(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }

  public static DisplayMetrics a(WindowManager paramWindowManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  public static PopupWindow a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new PopupWindow(paramView, paramInt1, paramInt2, false);
  }

  private static String a(Context paramContext, y paramy, String paramString)
  {
    if (paramy == null)
      return paramString;
    try
    {
      Uri localUri = Uri.parse(paramString);
      if (paramy.b(localUri))
        localUri = paramy.a(localUri, paramContext);
      String str = localUri.toString();
      return str;
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }

  public static String a(InputStreamReader paramInputStreamReader)
  {
    StringBuilder localStringBuilder = new StringBuilder(8192);
    char[] arrayOfChar = new char[2048];
    while (true)
    {
      int i = paramInputStreamReader.read(arrayOfChar);
      if (i == -1)
        break;
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder.toString();
  }

  public static String a(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }

  public static Map a(Uri paramUri)
  {
    if (paramUri == null)
      return null;
    HashMap localHashMap = new HashMap();
    Iterator localIterator = P.g().a(paramUri).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramUri.getQueryParameter(str));
    }
    return localHashMap;
  }

  private JSONArray a(Collection paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      a(localJSONArray, localIterator.next());
    return localJSONArray;
  }

  private JSONObject a(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }

  public static void a(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    Window localWindow = paramActivity.getWindow();
    if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().getViewTreeObserver() != null))
      localWindow.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(paramOnGlobalLayoutListener);
  }

  public static void a(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    Window localWindow = paramActivity.getWindow();
    if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().getViewTreeObserver() != null))
      localWindow.getDecorView().getViewTreeObserver().addOnScrollChangedListener(paramOnScrollChangedListener);
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Context localContext = paramContext.getApplicationContext();
      if (localContext == null)
        localContext = paramContext;
      paramBundle.putString("os", Build.VERSION.RELEASE);
      paramBundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
      P.e();
      paramBundle.putString("device", c());
      paramBundle.putString("appid", localContext.getPackageName());
      paramBundle.putString("eids", TextUtils.join(",", aD.a()));
      if (paramString1 == null)
        break label173;
      paramBundle.putString("js", paramString1);
    }
    Uri.Builder localBuilder;
    while (true)
    {
      localBuilder = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", paramString2);
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBuilder.appendQueryParameter(str, paramBundle.getString(str));
      }
      label173: paramBundle.putString("gmscore_version", Integer.toString(q.f(paramContext)));
    }
    P.e().a(paramContext, paramString1, localBuilder.toString());
  }

  public static void a(Context paramContext, String paramString, List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      new hX(paramContext, paramString, (String)localIterator.next()).g();
  }

  public static void a(Context paramContext, String paramString1, List paramList, String paramString2)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      new hX(paramContext, paramString1, (String)localIterator.next(), paramString2).g();
  }

  public static void a(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    a.post(paramRunnable);
  }

  private void a(JSONArray paramJSONArray, Object paramObject)
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(a((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(a((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(a((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      JSONArray localJSONArray = new JSONArray();
      int i = arrayOfObject.length;
      for (int j = 0; j < i; j++)
        a(localJSONArray, arrayOfObject[j]);
      paramJSONArray.put(localJSONArray);
      return;
    }
    paramJSONArray.put(paramObject);
  }

  private void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, a((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, a((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      if (paramString != null);
      while (true)
      {
        paramJSONObject.put(paramString, a((Collection)paramObject));
        return;
        paramString = "null";
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONObject.put(paramString, a(Arrays.asList((Object[])paramObject)));
      return;
    }
    paramJSONObject.put(paramString, paramObject);
  }

  public static void a(boolean paramBoolean, HttpURLConnection paramHttpURLConnection, String paramString)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(true);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", paramString);
    paramHttpURLConnection.setUseCaches(false);
  }

  public static boolean a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
    if ((localResolveInfo == null) || (localResolveInfo.activityInfo == null))
    {
      hc.d("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
      return false;
    }
    if ((0x10 & localResolveInfo.activityInfo.configChanges) == 0)
      hc.d(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboard" }));
    for (int i = 0; ; i = 1)
    {
      if ((0x20 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        hc.d(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboardHidden" }));
        i = 0;
      }
      if ((0x80 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        hc.d(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "orientation" }));
        i = 0;
      }
      if ((0x100 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        hc.d(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenLayout" }));
        i = 0;
      }
      if ((0x200 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        hc.d(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "uiMode" }));
        i = 0;
      }
      if ((0x400 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        hc.d(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenSize" }));
        i = 0;
      }
      if ((0x800 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        hc.d(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "smallestScreenSize" }));
        return false;
      }
      return i;
    }
  }

  public static boolean a(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    w.c("saveImageToFile must not be called on the main UI thread.");
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput(paramString, 0);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
      localFileOutputStream.close();
      paramBitmap.recycle();
      return true;
    }
    catch (Exception localException)
    {
      hc.b("Fail to save file", localException);
    }
    return false;
  }

  public static boolean a(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    return paramPackageManager.checkPermission(paramString2, paramString1) == 0;
  }

  public static boolean a(ClassLoader paramClassLoader, Class paramClass, String paramString)
  {
    try
    {
      boolean bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static int b(View paramView)
  {
    if (paramView == null)
      return -1;
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (!(localViewParent instanceof AdapterView)); localViewParent = localViewParent.getParent());
    if (localViewParent == null)
      return -1;
    return ((AdapterView)localViewParent).getPositionForView(paramView);
  }

  public static int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      hc.d("Could not parse value:" + localNumberFormatException);
    }
    return 0;
  }

  public static Bitmap b(Context paramContext, String paramString)
  {
    w.c("getBackgroundImage must not be called on the main UI thread.");
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput(paramString);
      Bitmap localBitmap = BitmapFactory.decodeStream(localFileInputStream);
      localFileInputStream.close();
      return localBitmap;
    }
    catch (Exception localException)
    {
      hc.b("Fail to get background image");
    }
    return null;
  }

  public static String b()
  {
    UUID localUUID = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(localUUID.getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(localUUID.getMostSignificantBits()).toByteArray();
    Object localObject = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (true)
    {
      if (i < 2);
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(arrayOfByte1);
        localMessageDigest.update(arrayOfByte2);
        byte[] arrayOfByte3 = new byte[8];
        System.arraycopy(localMessageDigest.digest(), 0, arrayOfByte3, 0, 8);
        String str = new BigInteger(1, arrayOfByte3).toString();
        localObject = str;
        label106: i++;
        continue;
        return localObject;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        break label106;
      }
    }
  }

  public static void b(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    Window localWindow = paramActivity.getWindow();
    if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().getViewTreeObserver() != null))
      localWindow.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(paramOnScrollChangedListener);
  }

  public static String c()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1))
      return str2;
    return str1 + " " + str2;
  }

  protected static String c(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }

  public static void c(Context paramContext, String paramString)
  {
    w.c("deleteFile must not be called on the main UI thread.");
    paramContext.deleteFile(paramString);
  }

  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
  }

  public static float d()
  {
    P.s();
    F localF = F.b();
    if ((localF != null) && (localF.d()))
      return localF.c();
    return 1.0F;
  }

  public static AlertDialog.Builder d(Context paramContext)
  {
    return new AlertDialog.Builder(paramContext);
  }

  public static ar e(Context paramContext)
  {
    return new ar(paramContext);
  }

  private static String e()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("Mozilla/5.0 (Linux; U; Android");
    if (Build.VERSION.RELEASE != null)
      localStringBuffer.append(" ").append(Build.VERSION.RELEASE);
    localStringBuffer.append("; ").append(Locale.getDefault());
    if (Build.DEVICE != null)
    {
      localStringBuffer.append("; ").append(Build.DEVICE);
      if (Build.DISPLAY != null)
        localStringBuffer.append(" Build/").append(Build.DISPLAY);
    }
    localStringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
    return localStringBuffer.toString();
  }

  private static int[] f()
  {
    return new int[] { 0, 0 };
  }

  public static Bitmap g(Context paramContext)
  {
    if (!(paramContext instanceof Activity))
      return null;
    try
    {
      View localView = ((Activity)paramContext).getWindow().getDecorView();
      Bitmap localBitmap = Bitmap.createBitmap(localView.getWidth(), localView.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localView.layout(0, 0, localView.getWidth(), localView.getHeight());
      localView.draw(localCanvas);
      return localBitmap;
    }
    catch (RuntimeException localRuntimeException)
    {
      hc.b("Fail to capture screen shot", localRuntimeException);
    }
    return null;
  }

  public static float h(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    if (localAudioManager == null)
      return 0.0F;
    int i = localAudioManager.getStreamMaxVolume(3);
    int j = localAudioManager.getStreamVolume(3);
    if (i == 0)
      return 0.0F;
    return j / i;
  }

  public static int i(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    if (localApplicationInfo == null)
      return 0;
    return localApplicationInfo.targetSdkVersion;
  }

  private static String j(Context paramContext)
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (localActivityManager == null)
        return null;
      List localList = localActivityManager.getRunningTasks(1);
      if ((localList != null) && (!localList.isEmpty()))
      {
        ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)localList.get(0);
        if ((localRunningTaskInfo != null) && (localRunningTaskInfo.topActivity != null))
        {
          String str = localRunningTaskInfo.topActivity.getClassName();
          return str;
        }
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final String a(Context paramContext, View paramView, AdSizeParcel paramAdSizeParcel)
  {
    au localau = aD.J;
    if (!((Boolean)P.n().a(localau)).booleanValue())
      return null;
    while (true)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("width", paramAdSizeParcel.f);
        localJSONObject2.put("height", paramAdSizeParcel.c);
        localJSONObject1.put("size", localJSONObject2);
        localJSONObject1.put("activity", j(paramContext));
        if (paramAdSizeParcel.e)
          continue;
        JSONArray localJSONArray = new JSONArray();
        if (paramView == null)
          continue;
        ViewParent localViewParent = paramView.getParent();
        if (localViewParent == null)
          continue;
        int i = -1;
        if (!(localViewParent instanceof ViewGroup))
          continue;
        i = ((ViewGroup)localViewParent).indexOfChild(paramView);
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("type", localViewParent.getClass().getName());
        localJSONObject3.put("index_of_child", i);
        localJSONArray.put(localJSONObject3);
        if ((localViewParent != null) && ((localViewParent instanceof View)))
        {
          paramView = (View)localViewParent;
          continue;
          if (localJSONArray.length() <= 0)
            continue;
          localJSONObject1.put("parents", localJSONArray);
          String str = localJSONObject1.toString();
          return str;
        }
      }
      catch (JSONException localJSONException)
      {
        hc.c("Fail to get view hierarchy json", localJSONException);
        return null;
      }
      paramView = null;
    }
  }

  public final String a(Context paramContext, String paramString)
  {
    synchronized (this.b)
    {
      if (this.d != null)
      {
        String str3 = this.d;
        return str3;
      }
    }
    try
    {
      this.d = P.g().a(paramContext);
      label36: if (TextUtils.isEmpty(this.d))
      {
        x.a();
        if (!a.b())
        {
          this.d = null;
          a.post(new hv(this, paramContext));
          while (true)
          {
            String str2 = this.d;
            if (str2 != null)
              break;
            try
            {
              this.b.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              this.d = e();
              hc.d("Interrupted, use default user agent: " + this.d);
            }
            continue;
            localObject2 = finally;
            monitorexit;
            throw localObject2;
          }
        }
      }
      try
      {
        this.d = c(paramContext);
        this.d = (this.d + " (Mobile; " + paramString + ")");
        String str1 = this.d;
        monitorexit;
        return str1;
      }
      catch (Exception localException2)
      {
        while (true)
          this.d = e();
      }
    }
    catch (Exception localException1)
    {
      break label36;
    }
  }

  public final String a(is paramis, String paramString)
  {
    return a(paramis.getContext(), paramis.n(), paramString);
  }

  public final JSONObject a(Map paramMap)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(localJSONObject, str, paramMap.get(str));
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new JSONException("Could not convert map to JSON: " + localClassCastException.getMessage());
    }
    return localJSONObject;
  }

  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    a(paramContext, paramString1, localArrayList);
  }

  public final void a(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", a(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(false);
  }

  public final boolean a()
  {
    return this.c;
  }

  public final boolean a(View paramView, PowerManager paramPowerManager, KeyguardManager paramKeyguardManager)
  {
    if ((paramView.getVisibility() == 0) && (paramView.isShown()))
    {
      int i;
      if ((paramPowerManager == null) || (paramPowerManager.isScreenOn()))
      {
        i = 1;
        if (i == 0)
          break label71;
        if (!P.e().c)
          if (paramKeyguardManager != null)
            break label62;
      }
      label62: for (boolean bool = false; ; bool = paramKeyguardManager.inKeyguardRestrictedInputMode())
      {
        if (bool)
          break label71;
        return true;
        i = 0;
        break;
      }
    }
    label71: return false;
  }

  public final int[] a(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    if (localWindow != null)
    {
      View localView = localWindow.findViewById(16908290);
      if (localView != null)
      {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = localView.getWidth();
        arrayOfInt[1] = localView.getHeight();
        return arrayOfInt;
      }
    }
    return f();
  }

  public final void b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    au localau = aD.U;
    if (((Boolean)P.n().a(localau)).booleanValue())
      a(paramContext, paramString1, paramString2, paramBundle, paramBoolean);
  }

  public final boolean b(Context paramContext)
  {
    if (this.e)
      return false;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.getApplicationContext().registerReceiver(new hw(this, 0), localIntentFilter);
    this.e = true;
    return true;
  }

  public final int[] b(Activity paramActivity)
  {
    int[] arrayOfInt1 = a(paramActivity);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = x.a().b(paramActivity, arrayOfInt1[0]);
    arrayOfInt2[1] = x.a().b(paramActivity, arrayOfInt1[1]);
    return arrayOfInt2;
  }

  public final int[] c(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    int[] arrayOfInt1;
    if (localWindow != null)
    {
      View localView = localWindow.findViewById(16908290);
      if (localView != null)
      {
        arrayOfInt1 = new int[2];
        arrayOfInt1[0] = localView.getTop();
        arrayOfInt1[1] = localView.getBottom();
      }
    }
    while (true)
    {
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = x.a().b(paramActivity, arrayOfInt1[0]);
      arrayOfInt2[1] = x.a().b(paramActivity, arrayOfInt1[1]);
      return arrayOfInt2;
      arrayOfInt1 = f();
    }
  }

  public final boolean f(Context paramContext)
  {
    int i;
    label152: 
    do
    {
      try
      {
        ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
        if ((localActivityManager != null) && (localKeyguardManager != null))
        {
          List localList = localActivityManager.getRunningAppProcesses();
          if (localList == null)
            return false;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
            if (Process.myPid() != localRunningAppProcessInfo.pid)
              continue;
            if ((localRunningAppProcessInfo.importance != 100) || (localKeyguardManager.inKeyguardRestrictedInputMode()))
              break;
            PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
            if (localPowerManager == null)
            {
              i = 0;
              break label152;
            }
            boolean bool = localPowerManager.isScreenOn();
            i = bool;
            break label152;
          }
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
      return false;
    }
    while (i == 0);
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.hu
 * JD-Core Version:    0.6.0
 */