package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapParameter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.FacedCubemapData;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cubemap extends GLTexture
{
  private static AssetManager assetManager;
  static final Map managedCubemaps = new HashMap();
  protected CubemapData data;

  public Cubemap(int paramInt1, int paramInt2, int paramInt3, Pixmap.Format paramFormat)
  {
    this(new PixmapTextureData(new Pixmap(paramInt3, paramInt2, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt3, paramInt2, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt3, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt3, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true));
  }

  public Cubemap(FileHandle paramFileHandle1, FileHandle paramFileHandle2, FileHandle paramFileHandle3, FileHandle paramFileHandle4, FileHandle paramFileHandle5, FileHandle paramFileHandle6)
  {
    this(paramFileHandle1, paramFileHandle2, paramFileHandle3, paramFileHandle4, paramFileHandle5, paramFileHandle6, false);
  }

  public Cubemap(FileHandle paramFileHandle1, FileHandle paramFileHandle2, FileHandle paramFileHandle3, FileHandle paramFileHandle4, FileHandle paramFileHandle5, FileHandle paramFileHandle6, boolean paramBoolean)
  {
    this(TextureData.Factory.loadFromFile(paramFileHandle1, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle2, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle3, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle4, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle5, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle6, paramBoolean));
  }

  public Cubemap(CubemapData paramCubemapData)
  {
    super(34067);
    this.data = paramCubemapData;
    load(paramCubemapData);
  }

  public Cubemap(Pixmap paramPixmap1, Pixmap paramPixmap2, Pixmap paramPixmap3, Pixmap paramPixmap4, Pixmap paramPixmap5, Pixmap paramPixmap6)
  {
    this(paramPixmap1, paramPixmap2, paramPixmap3, paramPixmap4, paramPixmap5, paramPixmap6, false);
  }

  public Cubemap(Pixmap paramPixmap1, Pixmap paramPixmap2, Pixmap paramPixmap3, Pixmap paramPixmap4, Pixmap paramPixmap5, Pixmap paramPixmap6, boolean paramBoolean)
  {
  }

  public Cubemap(TextureData paramTextureData1, TextureData paramTextureData2, TextureData paramTextureData3, TextureData paramTextureData4, TextureData paramTextureData5, TextureData paramTextureData6)
  {
    super(34067);
    this.minFilter = Texture.TextureFilter.Nearest;
    this.magFilter = Texture.TextureFilter.Nearest;
    this.uWrap = Texture.TextureWrap.ClampToEdge;
    this.vWrap = Texture.TextureWrap.ClampToEdge;
    this.data = new FacedCubemapData(paramTextureData1, paramTextureData2, paramTextureData3, paramTextureData4, paramTextureData5, paramTextureData6);
    load(this.data);
  }

  private static void addManagedCubemap(Application paramApplication, Cubemap paramCubemap)
  {
    Array localArray = (Array)managedCubemaps.get(paramApplication);
    if (localArray == null)
      localArray = new Array();
    localArray.add(paramCubemap);
    managedCubemaps.put(paramApplication, localArray);
  }

  public static void clearAllCubemaps(Application paramApplication)
  {
    managedCubemaps.remove(paramApplication);
  }

  public static String getManagedStatus()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Managed cubemap/app: { ");
    Iterator localIterator = managedCubemaps.keySet().iterator();
    while (localIterator.hasNext())
    {
      Application localApplication = (Application)localIterator.next();
      localStringBuilder.append(((Array)managedCubemaps.get(localApplication)).size);
      localStringBuilder.append(" ");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public static int getNumManagedCubemaps()
  {
    return ((Array)managedCubemaps.get(Gdx.app)).size;
  }

  public static void invalidateAllCubemaps(Application paramApplication)
  {
    Array localArray1 = (Array)managedCubemaps.get(paramApplication);
    if (localArray1 == null);
    while (true)
    {
      return;
      AssetManager localAssetManager = assetManager;
      int i = 0;
      if (localAssetManager != null)
        break;
      while (i < localArray1.size)
      {
        ((Cubemap)localArray1.get(i)).reload();
        i++;
      }
    }
    assetManager.finishLoading();
    Array localArray2 = new Array(localArray1);
    Iterator localIterator = localArray2.iterator();
    while (localIterator.hasNext())
    {
      Cubemap localCubemap = (Cubemap)localIterator.next();
      String str = assetManager.getAssetFileName(localCubemap);
      if (str == null)
      {
        localCubemap.reload();
        continue;
      }
      int j = assetManager.getReferenceCount(str);
      assetManager.setReferenceCount(str, 0);
      localCubemap.glHandle = 0;
      CubemapLoader.CubemapParameter localCubemapParameter = new CubemapLoader.CubemapParameter();
      localCubemapParameter.cubemapData = localCubemap.getCubemapData();
      localCubemapParameter.minFilter = localCubemap.getMinFilter();
      localCubemapParameter.magFilter = localCubemap.getMagFilter();
      localCubemapParameter.wrapU = localCubemap.getUWrap();
      localCubemapParameter.wrapV = localCubemap.getVWrap();
      localCubemapParameter.cubemap = localCubemap;
      localCubemapParameter.loadedCallback = new Cubemap.1(j);
      assetManager.unload(str);
      localCubemap.glHandle = Gdx.gl.glGenTexture();
      assetManager.load(str, Cubemap.class, localCubemapParameter);
    }
    localArray1.clear();
    localArray1.addAll(localArray2);
  }

  public static void setAssetManager(AssetManager paramAssetManager)
  {
    assetManager = paramAssetManager;
  }

  public void dispose()
  {
    if (this.glHandle == 0);
    do
    {
      return;
      delete();
    }
    while ((!this.data.isManaged()) || (managedCubemaps.get(Gdx.app) == null));
    ((Array)managedCubemaps.get(Gdx.app)).removeValue(this, true);
  }

  public CubemapData getCubemapData()
  {
    return this.data;
  }

  public int getDepth()
  {
    return 0;
  }

  public int getHeight()
  {
    return this.data.getHeight();
  }

  public int getWidth()
  {
    return this.data.getWidth();
  }

  public boolean isManaged()
  {
    return this.data.isManaged();
  }

  public void load(CubemapData paramCubemapData)
  {
    if (!paramCubemapData.isPrepared())
      paramCubemapData.prepare();
    bind();
    unsafeSetFilter(this.minFilter, this.magFilter, true);
    unsafeSetWrap(this.uWrap, this.vWrap, true);
    paramCubemapData.consumeCubemapData();
    Gdx.gl.glBindTexture(this.glTarget, 0);
  }

  protected void reload()
  {
    if (!isManaged())
      throw new GdxRuntimeException("Tried to reload an unmanaged Cubemap");
    this.glHandle = Gdx.gl.glGenTexture();
    load(this.data);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.Cubemap
 * JD-Core Version:    0.6.0
 */