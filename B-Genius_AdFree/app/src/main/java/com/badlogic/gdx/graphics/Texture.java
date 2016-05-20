package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Texture extends GLTexture
{
  private static AssetManager assetManager;
  static final Map managedTextures = new HashMap();
  TextureData data;

  public Texture(int paramInt1, int paramInt2, Pixmap.Format paramFormat)
  {
    this(new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true));
  }

  public Texture(FileHandle paramFileHandle)
  {
    this(paramFileHandle, null, false);
  }

  public Texture(FileHandle paramFileHandle, Pixmap.Format paramFormat, boolean paramBoolean)
  {
    this(TextureData.Factory.loadFromFile(paramFileHandle, paramFormat, paramBoolean));
  }

  public Texture(FileHandle paramFileHandle, boolean paramBoolean)
  {
    this(paramFileHandle, null, paramBoolean);
  }

  public Texture(Pixmap paramPixmap)
  {
    this(new PixmapTextureData(paramPixmap, null, false, false));
  }

  public Texture(Pixmap paramPixmap, Pixmap.Format paramFormat, boolean paramBoolean)
  {
    this(new PixmapTextureData(paramPixmap, paramFormat, paramBoolean, false));
  }

  public Texture(Pixmap paramPixmap, boolean paramBoolean)
  {
    this(new PixmapTextureData(paramPixmap, null, paramBoolean, false));
  }

  public Texture(TextureData paramTextureData)
  {
    super(3553, Gdx.gl.glGenTexture());
    load(paramTextureData);
    if (paramTextureData.isManaged())
      addManagedTexture(Gdx.app, this);
  }

  public Texture(String paramString)
  {
    this(Gdx.files.internal(paramString));
  }

  private static void addManagedTexture(Application paramApplication, Texture paramTexture)
  {
    Array localArray = (Array)managedTextures.get(paramApplication);
    if (localArray == null)
      localArray = new Array();
    localArray.add(paramTexture);
    managedTextures.put(paramApplication, localArray);
  }

  public static void clearAllTextures(Application paramApplication)
  {
    managedTextures.remove(paramApplication);
  }

  public static String getManagedStatus()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Managed textures/app: { ");
    Iterator localIterator = managedTextures.keySet().iterator();
    while (localIterator.hasNext())
    {
      Application localApplication = (Application)localIterator.next();
      localStringBuilder.append(((Array)managedTextures.get(localApplication)).size);
      localStringBuilder.append(" ");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public static int getNumManagedTextures()
  {
    return ((Array)managedTextures.get(Gdx.app)).size;
  }

  public static void invalidateAllTextures(Application paramApplication)
  {
    Array localArray1 = (Array)managedTextures.get(paramApplication);
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
        ((Texture)localArray1.get(i)).reload();
        i++;
      }
    }
    assetManager.finishLoading();
    Array localArray2 = new Array(localArray1);
    Iterator localIterator = localArray2.iterator();
    while (localIterator.hasNext())
    {
      Texture localTexture = (Texture)localIterator.next();
      String str = assetManager.getAssetFileName(localTexture);
      if (str == null)
      {
        localTexture.reload();
        continue;
      }
      int j = assetManager.getReferenceCount(str);
      assetManager.setReferenceCount(str, 0);
      localTexture.glHandle = 0;
      TextureLoader.TextureParameter localTextureParameter = new TextureLoader.TextureParameter();
      localTextureParameter.textureData = localTexture.getTextureData();
      localTextureParameter.minFilter = localTexture.getMinFilter();
      localTextureParameter.magFilter = localTexture.getMagFilter();
      localTextureParameter.wrapU = localTexture.getUWrap();
      localTextureParameter.wrapV = localTexture.getVWrap();
      localTextureParameter.genMipMaps = localTexture.data.useMipMaps();
      localTextureParameter.texture = localTexture;
      localTextureParameter.loadedCallback = new Texture.1(j);
      assetManager.unload(str);
      localTexture.glHandle = Gdx.gl.glGenTexture();
      assetManager.load(str, Texture.class, localTextureParameter);
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
    while ((!this.data.isManaged()) || (managedTextures.get(Gdx.app) == null));
    ((Array)managedTextures.get(Gdx.app)).removeValue(this, true);
  }

  public void draw(Pixmap paramPixmap, int paramInt1, int paramInt2)
  {
    if (this.data.isManaged())
      throw new GdxRuntimeException("can't draw to a managed texture");
    bind();
    Gdx.gl.glTexSubImage2D(this.glTarget, 0, paramInt1, paramInt2, paramPixmap.getWidth(), paramPixmap.getHeight(), paramPixmap.getGLFormat(), paramPixmap.getGLType(), paramPixmap.getPixels());
  }

  public int getDepth()
  {
    return 0;
  }

  public int getHeight()
  {
    return this.data.getHeight();
  }

  public TextureData getTextureData()
  {
    return this.data;
  }

  public int getWidth()
  {
    return this.data.getWidth();
  }

  public boolean isManaged()
  {
    return this.data.isManaged();
  }

  public void load(TextureData paramTextureData)
  {
    if ((this.data != null) && (paramTextureData.isManaged() != this.data.isManaged()))
      throw new GdxRuntimeException("New data must have the same managed status as the old data");
    this.data = paramTextureData;
    if (!paramTextureData.isPrepared())
      paramTextureData.prepare();
    bind();
    uploadImageData(3553, paramTextureData);
    setFilter(this.minFilter, this.magFilter);
    setWrap(this.uWrap, this.vWrap);
    Gdx.gl.glBindTexture(this.glTarget, 0);
  }

  protected void reload()
  {
    if (!isManaged())
      throw new GdxRuntimeException("Tried to reload unmanaged Texture");
    this.glHandle = Gdx.gl.glGenTexture();
    load(this.data);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.Texture
 * JD-Core Version:    0.6.0
 */