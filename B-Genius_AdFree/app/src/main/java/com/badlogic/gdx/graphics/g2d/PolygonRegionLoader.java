package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ShortArray;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedReader;
import java.io.IOException;

public class PolygonRegionLoader extends SynchronousAssetLoader
{
  private PolygonRegionLoader.PolygonRegionParameters defaultParameters = new PolygonRegionLoader.PolygonRegionParameters();
  private EarClippingTriangulator triangulator = new EarClippingTriangulator();

  public PolygonRegionLoader()
  {
    this(new InternalFileHandleResolver());
  }

  public PolygonRegionLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, PolygonRegionLoader.PolygonRegionParameters paramPolygonRegionParameters)
  {
    if (paramPolygonRegionParameters == null)
      paramPolygonRegionParameters = this.defaultParameters;
    while (true)
    {
      try
      {
        BufferedReader localBufferedReader = paramFileHandle.reader(paramPolygonRegionParameters.readerBuffer);
        Object localObject = localBufferedReader.readLine();
        if (localObject == null)
          break label239;
        if (!((String)localObject).startsWith(paramPolygonRegionParameters.texturePrefix))
          continue;
        str2 = ((String)localObject).substring(paramPolygonRegionParameters.texturePrefix.length());
        localBufferedReader.close();
        if ((str2 == null) && (paramPolygonRegionParameters.textureExtensions != null))
        {
          String[] arrayOfString = paramPolygonRegionParameters.textureExtensions;
          int i = arrayOfString.length;
          int j = 0;
          if (j < i)
          {
            String str4 = arrayOfString[j];
            FileHandle localFileHandle = paramFileHandle.sibling(paramFileHandle.nameWithoutExtension().concat("." + str4));
            if (!localFileHandle.exists())
              continue;
            str2 = localFileHandle.name();
            j++;
            continue;
            String str1 = localBufferedReader.readLine();
            localObject = str1;
            continue;
          }
        }
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Error reading " + paramString, localIOException);
      }
      String str3 = str2;
      if (str3 != null)
      {
        Array localArray = new Array(1);
        localArray.add(new AssetDescriptor(paramFileHandle.sibling(str3), Texture.class));
        return localArray;
      }
      return null;
      label239: String str2 = null;
    }
  }

  public PolygonRegion load(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, PolygonRegionLoader.PolygonRegionParameters paramPolygonRegionParameters)
  {
    return load(new TextureRegion((Texture)paramAssetManager.get((String)paramAssetManager.getDependencies(paramString).first())), paramFileHandle);
  }

  public PolygonRegion load(TextureRegion paramTextureRegion, FileHandle paramFileHandle)
  {
    BufferedReader localBufferedReader = paramFileHandle.reader(256);
    try
    {
      while (true)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
          break;
        if (!str.startsWith("s"))
          continue;
        String[] arrayOfString = str.substring(1).trim().split(",");
        float[] arrayOfFloat = new float[arrayOfString.length];
        int i = 0;
        int j = arrayOfFloat.length;
        while (i < j)
        {
          arrayOfFloat[i] = Float.parseFloat(arrayOfString[i]);
          i++;
        }
        PolygonRegion localPolygonRegion = new PolygonRegion(paramTextureRegion, arrayOfFloat, this.triangulator.computeTriangles(arrayOfFloat).toArray());
        return localPolygonRegion;
      }
      throw new GdxRuntimeException("Polygon shape not found: " + paramFileHandle);
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("Error reading polygon shape file: " + paramFileHandle, localIOException);
    }
    finally
    {
      StreamUtils.closeQuietly(localBufferedReader);
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.PolygonRegionLoader
 * JD-Core Version:    0.6.0
 */