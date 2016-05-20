package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.Vector;

public class APKExpansionSupport
{
  private static final String EXP_PATH = "/Android/obb/";

  static String[] getAPKExpansionFiles(Context paramContext, int paramInt1, int paramInt2)
  {
    String str1 = paramContext.getPackageName();
    Vector localVector = new Vector();
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      File localFile1 = Environment.getExternalStorageDirectory();
      File localFile2 = new File(localFile1.toString() + "/Android/obb/" + str1);
      if (localFile2.exists())
      {
        if (paramInt1 > 0)
        {
          String str3 = localFile2 + File.separator + "main." + paramInt1 + "." + str1 + ".obb";
          if (new File(str3).isFile())
            localVector.add(str3);
        }
        if (paramInt2 > 0)
        {
          String str2 = localFile2 + File.separator + "patch." + paramInt1 + "." + str1 + ".obb";
          if (new File(str2).isFile())
            localVector.add(str2);
        }
      }
    }
    String[] arrayOfString = new String[localVector.size()];
    localVector.toArray(arrayOfString);
    return arrayOfString;
  }

  public static ZipResourceFile getAPKExpansionZipFile(Context paramContext, int paramInt1, int paramInt2)
  {
    return getResourceZipFile(getAPKExpansionFiles(paramContext, paramInt1, paramInt2));
  }

  public static ZipResourceFile getResourceZipFile(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    ZipResourceFile localZipResourceFile = null;
    int j = 0;
    if (j < i)
    {
      String str = paramArrayOfString[j];
      if (localZipResourceFile == null)
        localZipResourceFile = new ZipResourceFile(str);
      while (true)
      {
        j++;
        break;
        localZipResourceFile.addPatchFile(str);
      }
    }
    return localZipResourceFile;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.APKExpansionSupport
 * JD-Core Version:    0.6.0
 */