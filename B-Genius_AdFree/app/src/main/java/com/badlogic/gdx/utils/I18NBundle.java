package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;

public class I18NBundle
{
  private static final String DEFAULT_ENCODING = "UTF-8";
  private static final Locale ROOT_LOCALE = new Locale("", "", "");
  private static boolean exceptionOnMissingKey;
  private static boolean simpleFormatter = false;
  private TextFormatter formatter;
  private Locale locale;
  private I18NBundle parent;
  private ObjectMap properties;

  static
  {
    exceptionOnMissingKey = true;
  }

  private static boolean checkFileExistence(FileHandle paramFileHandle)
  {
    try
    {
      paramFileHandle.read().close();
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public static I18NBundle createBundle(FileHandle paramFileHandle)
  {
    return createBundleImpl(paramFileHandle, Locale.getDefault(), "UTF-8");
  }

  public static I18NBundle createBundle(FileHandle paramFileHandle, String paramString)
  {
    return createBundleImpl(paramFileHandle, Locale.getDefault(), paramString);
  }

  public static I18NBundle createBundle(FileHandle paramFileHandle, Locale paramLocale)
  {
    return createBundleImpl(paramFileHandle, paramLocale, "UTF-8");
  }

  public static I18NBundle createBundle(FileHandle paramFileHandle, Locale paramLocale, String paramString)
  {
    return createBundleImpl(paramFileHandle, paramLocale, paramString);
  }

  private static I18NBundle createBundleImpl(FileHandle paramFileHandle, Locale paramLocale, String paramString)
  {
    if ((paramFileHandle == null) || (paramLocale == null) || (paramString == null))
      throw new NullPointerException();
    Object localObject1 = null;
    Locale localLocale1 = paramLocale;
    Object localObject2;
    do
    {
      List localList = getCandidateLocales(localLocale1);
      localObject2 = loadBundleChain(paramFileHandle, paramString, localList, 0, (I18NBundle)localObject1);
      if (localObject2 != null)
      {
        Locale localLocale2 = ((I18NBundle)localObject2).getLocale();
        boolean bool = localLocale2.equals(ROOT_LOCALE);
        if ((!bool) || (localLocale2.equals(paramLocale)) || ((localList.size() == 1) && (localLocale2.equals(localList.get(0)))))
          break;
        if ((bool) && (localObject1 == null))
          localObject1 = localObject2;
      }
      localLocale1 = getFallbackLocale(localLocale1);
    }
    while (localLocale1 != null);
    if (localObject2 == null)
    {
      if (localObject1 == null)
        throw new MissingResourceException("Can't find bundle for base file handle " + paramFileHandle.path() + ", locale " + paramLocale, paramFileHandle + "_" + paramLocale, "");
      localObject2 = localObject1;
    }
    return (I18NBundle)(I18NBundle)localObject2;
  }

  private static List getCandidateLocales(Locale paramLocale)
  {
    String str1 = paramLocale.getLanguage();
    String str2 = paramLocale.getCountry();
    String str3 = paramLocale.getVariant();
    ArrayList localArrayList = new ArrayList(4);
    if (str3.length() > 0)
      localArrayList.add(paramLocale);
    Locale localLocale;
    if (str2.length() > 0)
    {
      if (localArrayList.size() == 0)
      {
        localLocale = paramLocale;
        localArrayList.add(localLocale);
      }
    }
    else if (str1.length() > 0)
      if (localArrayList.size() != 0)
        break label125;
    while (true)
    {
      localArrayList.add(paramLocale);
      localArrayList.add(ROOT_LOCALE);
      return localArrayList;
      localLocale = new Locale(str1, str2);
      break;
      label125: paramLocale = new Locale(str1);
    }
  }

  public static boolean getExceptionOnMissingKey()
  {
    return exceptionOnMissingKey;
  }

  private static Locale getFallbackLocale(Locale paramLocale)
  {
    Locale localLocale = Locale.getDefault();
    if (paramLocale.equals(localLocale))
      localLocale = null;
    return localLocale;
  }

  public static boolean getSimpleFormatter()
  {
    return simpleFormatter;
  }

  // ERROR //
  private static I18NBundle loadBundle(FileHandle paramFileHandle, String paramString, Locale paramLocale)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokestatic 163	com/badlogic/gdx/utils/I18NBundle:toFileHandle	(Lcom/badlogic/gdx/files/FileHandle;Ljava/util/Locale;)Lcom/badlogic/gdx/files/FileHandle;
    //   5: astore 8
    //   7: aload 8
    //   9: invokestatic 165	com/badlogic/gdx/utils/I18NBundle:checkFileExistence	(Lcom/badlogic/gdx/files/FileHandle;)Z
    //   12: ifeq +115 -> 127
    //   15: new 2	com/badlogic/gdx/utils/I18NBundle
    //   18: dup
    //   19: invokespecial 166	com/badlogic/gdx/utils/I18NBundle:<init>	()V
    //   22: astore 9
    //   24: aload 8
    //   26: aload_1
    //   27: invokevirtual 170	com/badlogic/gdx/files/FileHandle:reader	(Ljava/lang/String;)Ljava/io/Reader;
    //   30: astore 10
    //   32: aload 10
    //   34: astore 11
    //   36: aload 9
    //   38: aload 11
    //   40: invokevirtual 174	com/badlogic/gdx/utils/I18NBundle:load	(Ljava/io/Reader;)V
    //   43: aload 11
    //   45: invokestatic 180	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   48: aload 9
    //   50: ifnull +9 -> 59
    //   53: aload 9
    //   55: aload_2
    //   56: invokespecial 184	com/badlogic/gdx/utils/I18NBundle:setLocale	(Ljava/util/Locale;)V
    //   59: aload 9
    //   61: areturn
    //   62: astore 6
    //   64: aconst_null
    //   65: astore 5
    //   67: aload 6
    //   69: astore 7
    //   71: new 186	com/badlogic/gdx/utils/GdxRuntimeException
    //   74: dup
    //   75: aload 7
    //   77: invokespecial 189	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   80: athrow
    //   81: astore 4
    //   83: aload 5
    //   85: invokestatic 180	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   88: aload 4
    //   90: athrow
    //   91: astore_3
    //   92: aload_3
    //   93: astore 4
    //   95: aconst_null
    //   96: astore 5
    //   98: goto -15 -> 83
    //   101: astore 13
    //   103: aload 11
    //   105: astore 5
    //   107: aload 13
    //   109: astore 4
    //   111: goto -28 -> 83
    //   114: astore 12
    //   116: aload 11
    //   118: astore 5
    //   120: aload 12
    //   122: astore 7
    //   124: goto -53 -> 71
    //   127: aconst_null
    //   128: astore 11
    //   130: aconst_null
    //   131: astore 9
    //   133: goto -90 -> 43
    //
    // Exception table:
    //   from	to	target	type
    //   0	32	62	java/io/IOException
    //   71	81	81	finally
    //   0	32	91	finally
    //   36	43	101	finally
    //   36	43	114	java/io/IOException
  }

  private static I18NBundle loadBundleChain(FileHandle paramFileHandle, String paramString, List paramList, int paramInt, I18NBundle paramI18NBundle)
  {
    Locale localLocale = (Locale)paramList.get(paramInt);
    I18NBundle localI18NBundle1;
    if (paramInt != -1 + paramList.size())
      localI18NBundle1 = loadBundleChain(paramFileHandle, paramString, paramList, paramInt + 1, paramI18NBundle);
    while (true)
    {
      I18NBundle localI18NBundle2 = loadBundle(paramFileHandle, paramString, localLocale);
      if (localI18NBundle2 == null)
        break;
      localI18NBundle2.parent = localI18NBundle1;
      return localI18NBundle2;
      localI18NBundle1 = null;
      if (paramI18NBundle == null)
        continue;
      boolean bool = localLocale.equals(ROOT_LOCALE);
      localI18NBundle1 = null;
      if (bool)
        return paramI18NBundle;
    }
    return localI18NBundle1;
  }

  public static void setExceptionOnMissingKey(boolean paramBoolean)
  {
    exceptionOnMissingKey = paramBoolean;
  }

  private void setLocale(Locale paramLocale)
  {
    this.locale = paramLocale;
    if (!simpleFormatter);
    for (boolean bool = true; ; bool = false)
    {
      this.formatter = new TextFormatter(paramLocale, bool);
      return;
    }
  }

  public static void setSimpleFormatter(boolean paramBoolean)
  {
    simpleFormatter = paramBoolean;
  }

  private static FileHandle toFileHandle(FileHandle paramFileHandle, Locale paramLocale)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramFileHandle.name());
    String str1;
    String str2;
    boolean bool2;
    if (!paramLocale.equals(ROOT_LOCALE))
    {
      str1 = paramLocale.getLanguage();
      str2 = paramLocale.getCountry();
      String str3 = paramLocale.getVariant();
      boolean bool1 = "".equals(str1);
      bool2 = "".equals(str2);
      boolean bool3 = "".equals(str3);
      if ((!bool1) || (!bool2) || (!bool3))
      {
        localStringBuilder.append('_');
        if (bool3)
          break label132;
        localStringBuilder.append(str1).append('_').append(str2).append('_').append(str3);
      }
    }
    while (true)
    {
      return paramFileHandle.sibling(localStringBuilder.append(".properties").toString());
      label132: if (!bool2)
      {
        localStringBuilder.append(str1).append('_').append(str2);
        continue;
      }
      localStringBuilder.append(str1);
    }
  }

  public String format(String paramString, Object[] paramArrayOfObject)
  {
    return this.formatter.format(get(paramString), paramArrayOfObject);
  }

  public final String get(String paramString)
  {
    String str = (String)this.properties.get(paramString);
    if (str == null)
    {
      if (this.parent != null)
        str = this.parent.get(paramString);
      if (str == null)
      {
        if (exceptionOnMissingKey)
          throw new MissingResourceException("Can't find bundle key " + paramString, getClass().getName(), paramString);
        str = "???" + paramString + "???";
      }
    }
    return str;
  }

  public Locale getLocale()
  {
    return this.locale;
  }

  protected void load(Reader paramReader)
  {
    this.properties = new ObjectMap();
    PropertiesUtils.load(this.properties, paramReader);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.I18NBundle
 * JD-Core Version:    0.6.0
 */