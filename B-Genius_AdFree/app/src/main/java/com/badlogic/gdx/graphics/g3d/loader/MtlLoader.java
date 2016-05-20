package com.badlogic.gdx.graphics.g3d.loader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.utils.Array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

class MtlLoader
{
  public Array materials = new Array();

  public ModelMaterial getMaterial(String paramString)
  {
    Iterator localIterator = this.materials.iterator();
    while (localIterator.hasNext())
    {
      ModelMaterial localModelMaterial2 = (ModelMaterial)localIterator.next();
      if (localModelMaterial2.id.equals(paramString))
        return localModelMaterial2;
    }
    ModelMaterial localModelMaterial1 = new ModelMaterial();
    localModelMaterial1.id = paramString;
    localModelMaterial1.diffuse = new Color(Color.WHITE);
    this.materials.add(localModelMaterial1);
    return localModelMaterial1;
  }

  public void load(FileHandle paramFileHandle)
  {
    Color localColor1 = Color.WHITE;
    Color localColor2 = Color.WHITE;
    String str1 = null;
    if ((paramFileHandle == null) || (!paramFileHandle.exists()))
      return;
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramFileHandle.read()), 4096);
    Object localObject1 = "default";
    Object localObject2 = localColor2;
    float f1 = 0.0F;
    Object localObject3 = localColor1;
    float f2 = 1.0F;
    try
    {
      String[] arrayOfString;
      String str3;
      while (true)
      {
        String str2 = localBufferedReader.readLine();
        if (str2 != null)
        {
          if ((str2.length() > 0) && (str2.charAt(0) == '\t'))
            str2 = str2.substring(1).trim();
          arrayOfString = str2.split("\\s+");
          if ((arrayOfString[0].length() == 0) || (arrayOfString[0].charAt(0) == '#'))
            continue;
          str3 = arrayOfString[0].toLowerCase();
          if (!str3.equals("newmtl"))
            break;
          ModelMaterial localModelMaterial1 = new ModelMaterial();
          localModelMaterial1.id = ((String)localObject1);
          localModelMaterial1.diffuse = new Color((Color)localObject3);
          localModelMaterial1.specular = new Color((Color)localObject2);
          localModelMaterial1.opacity = f2;
          localModelMaterial1.shininess = f1;
          if (str1 != null)
          {
            ModelTexture localModelTexture1 = new ModelTexture();
            localModelTexture1.usage = 2;
            localModelTexture1.fileName = new String(str1);
            if (localModelMaterial1.textures == null)
              localModelMaterial1.textures = new Array(1);
            localModelMaterial1.textures.add(localModelTexture1);
          }
          this.materials.add(localModelMaterial1);
          if (arrayOfString.length <= 1)
            break label692;
        }
      }
      label692: for (String str4 = arrayOfString[1].replace('.', '_'); ; str4 = "default")
      {
        Color localColor3 = Color.WHITE;
        Color localColor4 = Color.WHITE;
        localObject1 = str4;
        localObject3 = localColor3;
        localObject2 = localColor4;
        f2 = 1.0F;
        f1 = 0.0F;
        break;
        if ((str3.equals("kd")) || (str3.equals("ks")))
        {
          float f3 = Float.parseFloat(arrayOfString[1]);
          float f4 = Float.parseFloat(arrayOfString[2]);
          float f5 = Float.parseFloat(arrayOfString[3]);
          float f6 = 1.0F;
          if (arrayOfString.length > 4)
            f6 = Float.parseFloat(arrayOfString[4]);
          if (arrayOfString[0].toLowerCase().equals("kd"))
          {
            localObject3 = new Color();
            ((Color)localObject3).set(f3, f4, f5, f6);
            break;
          }
          localObject2 = new Color();
          ((Color)localObject2).set(f3, f4, f5, f6);
          break;
        }
        if ((str3.equals("tr")) || (str3.equals("d")))
        {
          f2 = Float.parseFloat(arrayOfString[1]);
          break;
        }
        if (str3.equals("ns"))
        {
          f1 = Float.parseFloat(arrayOfString[1]);
          break;
        }
        if (!str3.equals("map_kd"))
          break;
        str1 = paramFileHandle.parent().child(arrayOfString[1]).path();
        break;
        localBufferedReader.close();
        ModelMaterial localModelMaterial2 = new ModelMaterial();
        localModelMaterial2.id = ((String)localObject1);
        localModelMaterial2.diffuse = new Color((Color)localObject3);
        localModelMaterial2.specular = new Color((Color)localObject2);
        localModelMaterial2.opacity = f2;
        localModelMaterial2.shininess = f1;
        if (str1 != null)
        {
          ModelTexture localModelTexture2 = new ModelTexture();
          localModelTexture2.usage = 2;
          localModelTexture2.fileName = new String(str1);
          if (localModelMaterial2.textures == null)
            localModelMaterial2.textures = new Array(1);
          localModelMaterial2.textures.add(localModelTexture2);
        }
        this.materials.add(localModelMaterial2);
        return;
      }
    }
    catch (IOException localIOException)
    {
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.loader.MtlLoader
 * JD-Core Version:    0.6.0
 */