package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.ImageResolver.AssetManagerImageResolver;
import com.badlogic.gdx.maps.ImageResolver.DirectImageResolver;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Values;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;
import java.util.Iterator;

public class TmxMapLoader extends BaseTmxMapLoader
{
  public TmxMapLoader()
  {
    super(new InternalFileHandleResolver());
  }

  public TmxMapLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, TmxMapLoader.Parameters paramParameters)
  {
    Array localArray = new Array();
    TextureLoader.TextureParameter localTextureParameter;
    while (true)
    {
      try
      {
        this.root = this.xml.parse(paramFileHandle);
        if (paramParameters != null)
        {
          bool = paramParameters.generateMipMaps;
          localTextureParameter = new TextureLoader.TextureParameter();
          localTextureParameter.genMipMaps = bool;
          if (paramParameters == null)
            continue;
          localTextureParameter.minFilter = paramParameters.textureMinFilter;
          localTextureParameter.magFilter = paramParameters.textureMagFilter;
          Iterator localIterator1 = loadTilesets(this.root, paramFileHandle).iterator();
          if (!localIterator1.hasNext())
            break;
          localArray.add(new AssetDescriptor((FileHandle)localIterator1.next(), Texture.class, localTextureParameter));
          continue;
        }
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", localIOException);
      }
      boolean bool = false;
    }
    Iterator localIterator2 = loadImages(this.root, paramFileHandle).iterator();
    while (localIterator2.hasNext())
      localArray.add(new AssetDescriptor((FileHandle)localIterator2.next(), Texture.class, localTextureParameter));
    return localArray;
  }

  public TiledMap load(String paramString)
  {
    return load(paramString, new TmxMapLoader.Parameters());
  }

  public TiledMap load(String paramString, TmxMapLoader.Parameters paramParameters)
  {
    FileHandle localFileHandle1;
    ObjectMap localObjectMap;
    try
    {
      this.convertObjectToTileSpace = paramParameters.convertObjectToTileSpace;
      this.flipY = paramParameters.flipY;
      localFileHandle1 = resolve(paramString);
      this.root = this.xml.parse(localFileHandle1);
      localObjectMap = new ObjectMap();
      Array localArray = loadTilesets(this.root, localFileHandle1);
      localArray.addAll(loadImages(this.root, localFileHandle1));
      Iterator localIterator = localArray.iterator();
      while (localIterator.hasNext())
      {
        FileHandle localFileHandle2 = (FileHandle)localIterator.next();
        Texture localTexture = new Texture(localFileHandle2, paramParameters.generateMipMaps);
        localTexture.setFilter(paramParameters.textureMinFilter, paramParameters.textureMagFilter);
        localObjectMap.put(localFileHandle2.path(), localTexture);
      }
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", localIOException);
    }
    ImageResolver.DirectImageResolver localDirectImageResolver = new ImageResolver.DirectImageResolver(localObjectMap);
    TiledMap localTiledMap = loadTilemap(this.root, localFileHandle1, localDirectImageResolver);
    localTiledMap.setOwnedResources(localObjectMap.values().toArray());
    return localTiledMap;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TmxMapLoader.Parameters paramParameters)
  {
    this.map = null;
    if (paramParameters != null)
    {
      this.convertObjectToTileSpace = paramParameters.convertObjectToTileSpace;
      this.flipY = paramParameters.flipY;
    }
    try
    {
      while (true)
      {
        this.map = loadTilemap(this.root, paramFileHandle, new ImageResolver.AssetManagerImageResolver(paramAssetManager));
        return;
        this.convertObjectToTileSpace = false;
        this.flipY = true;
      }
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", localException);
  }

  protected Array loadImages(XmlReader.Element paramElement, FileHandle paramFileHandle)
  {
    Array localArray = new Array();
    Iterator localIterator = paramElement.getChildrenByName("imagelayer").iterator();
    while (localIterator.hasNext())
    {
      String str = ((XmlReader.Element)localIterator.next()).getChildByName("image").getAttribute("source", null);
      if (str == null)
        continue;
      FileHandle localFileHandle = getRelativeFileHandle(paramFileHandle, str);
      if (localArray.contains(localFileHandle, false))
        continue;
      localArray.add(localFileHandle);
    }
    return localArray;
  }

  public TiledMap loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TmxMapLoader.Parameters paramParameters)
  {
    return this.map;
  }

  protected void loadTileSet(TiledMap paramTiledMap, XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver)
  {
    String str1;
    int i;
    int j;
    int k;
    int m;
    int n;
    String str3;
    FileHandle localFileHandle1;
    if (paramElement.getName().equals("tileset"))
    {
      str1 = paramElement.get("name", null);
      i = paramElement.getIntAttribute("firstgid", 1);
      j = paramElement.getIntAttribute("tilewidth", 0);
      k = paramElement.getIntAttribute("tileheight", 0);
      m = paramElement.getIntAttribute("spacing", 0);
      n = paramElement.getIntAttribute("margin", 0);
      String str2 = paramElement.getAttribute("source", null);
      str3 = "";
      if (str2 != null)
        localFileHandle1 = getRelativeFileHandle(paramFileHandle, str2);
    }
    while (true)
    {
      TiledMapTileSet localTiledMapTileSet;
      int i14;
      int i15;
      int i16;
      float f2;
      try
      {
        paramElement = this.xml.parse(localFileHandle1);
        String str9 = paramElement.get("name", null);
        int i22 = paramElement.getIntAttribute("tilewidth", 0);
        int i23 = paramElement.getIntAttribute("tileheight", 0);
        int i24 = paramElement.getIntAttribute("spacing", 0);
        int i25 = paramElement.getIntAttribute("margin", 0);
        XmlReader.Element localElement10 = paramElement.getChildByName("tileoffset");
        int i26 = 0;
        int i27 = 0;
        if (localElement10 == null)
          continue;
        i27 = localElement10.getIntAttribute("x", 0);
        i26 = localElement10.getIntAttribute("y", 0);
        XmlReader.Element localElement11 = paramElement.getChildByName("image");
        localObject2 = null;
        int i28 = 0;
        int i29 = 0;
        if (localElement11 == null)
          continue;
        str3 = localElement11.getAttribute("source");
        i29 = localElement11.getIntAttribute("width", 0);
        i28 = localElement11.getIntAttribute("height", 0);
        FileHandle localFileHandle2 = getRelativeFileHandle(localFileHandle1, str3);
        localObject2 = localFileHandle2;
        int i30 = i28;
        str4 = str9;
        i3 = i24;
        i4 = i26;
        i5 = i22;
        i6 = i25;
        localObject1 = str3;
        i11 = i29;
        i10 = i30;
        int i31 = i27;
        i8 = i23;
        i9 = i31;
        localTiledMapTileSet = new TiledMapTileSet();
        localTiledMapTileSet.setName(str4);
        localTiledMapTileSet.getProperties().put("firstgid", Integer.valueOf(i));
        if (localObject2 == null)
          break label789;
        TextureRegion localTextureRegion1 = paramImageResolver.getImage(((FileHandle)localObject2).path());
        MapProperties localMapProperties = localTiledMapTileSet.getProperties();
        localMapProperties.put("imagesource", localObject1);
        localMapProperties.put("imagewidth", Integer.valueOf(i11));
        localMapProperties.put("imageheight", Integer.valueOf(i10));
        localMapProperties.put("tilewidth", Integer.valueOf(i5));
        localMapProperties.put("tileheight", Integer.valueOf(i8));
        localMapProperties.put("margin", Integer.valueOf(i6));
        localMapProperties.put("spacing", Integer.valueOf(i3));
        int i12 = localTextureRegion1.getRegionWidth() - i5;
        int i13 = localTextureRegion1.getRegionHeight() - i8;
        i14 = i6;
        i15 = i;
        if (i14 > i13)
          break label974;
        i16 = i15;
        int i17 = i6;
        if (i17 > i12)
          break label772;
        TextureRegion localTextureRegion2 = new TextureRegion(localTextureRegion1, i17, i14, i5, i8);
        StaticTiledMapTile localStaticTiledMapTile2 = new StaticTiledMapTile(localTextureRegion2);
        localStaticTiledMapTile2.setId(i16);
        localStaticTiledMapTile2.setOffsetX(i9);
        if (!this.flipY)
          break label764;
        f2 = -i4;
        localStaticTiledMapTile2.setOffsetY(f2);
        int i18 = i16 + 1;
        localTiledMapTileSet.putTile(i16, localStaticTiledMapTile2);
        i17 += i5 + i3;
        i16 = i18;
        continue;
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Error parsing external tileset.");
      }
      XmlReader.Element localElement1 = paramElement.getChildByName("tileoffset");
      int i1 = 0;
      int i2 = 0;
      if (localElement1 != null)
      {
        i2 = localElement1.getIntAttribute("x", 0);
        i1 = localElement1.getIntAttribute("y", 0);
      }
      XmlReader.Element localElement2 = paramElement.getChildByName("image");
      if (localElement2 != null)
      {
        String str8 = localElement2.getAttribute("source");
        int i19 = localElement2.getIntAttribute("width", 0);
        int i20 = localElement2.getIntAttribute("height", 0);
        localObject2 = getRelativeFileHandle(paramFileHandle, str8);
        str4 = str1;
        i3 = m;
        i4 = i1;
        i5 = j;
        i6 = n;
        localObject1 = str8;
        i11 = i19;
        i10 = i20;
        int i21 = i2;
        i8 = k;
        i9 = i21;
        continue;
        label764: f2 = i4;
        continue;
        label772: i14 += i8 + i3;
        i15 = i16;
        continue;
        label789: Iterator localIterator1 = paramElement.getChildrenByName("tile").iterator();
        Object localObject3 = localObject2;
        if (localIterator1.hasNext())
        {
          XmlReader.Element localElement8 = (XmlReader.Element)localIterator1.next();
          XmlReader.Element localElement9 = localElement8.getChildByName("image");
          if (localElement9 != null)
          {
            String str7 = localElement9.getAttribute("source");
            localElement9.getIntAttribute("width", 0);
            localElement9.getIntAttribute("height", 0);
            localObject3 = getRelativeFileHandle(paramFileHandle, str7);
          }
          StaticTiledMapTile localStaticTiledMapTile1 = new StaticTiledMapTile(paramImageResolver.getImage(((FileHandle)localObject3).path()));
          localStaticTiledMapTile1.setId(i + localElement8.getIntAttribute("id"));
          localStaticTiledMapTile1.setOffsetX(i9);
          float f1;
          if (this.flipY)
            f1 = -i4;
          while (true)
          {
            localStaticTiledMapTile1.setOffsetY(f1);
            localTiledMapTileSet.putTile(localStaticTiledMapTile1.getId(), localStaticTiledMapTile1);
            break;
            f1 = i4;
          }
        }
        label974: Array localArray1 = paramElement.getChildrenByName("tile");
        Array localArray2 = new Array();
        Iterator localIterator2 = localArray1.iterator();
        XmlReader.Element localElement4;
        TiledMapTile localTiledMapTile;
        Object localObject4;
        while (localIterator2.hasNext())
        {
          localElement4 = (XmlReader.Element)localIterator2.next();
          localTiledMapTile = localTiledMapTileSet.getTile(i + localElement4.getIntAttribute("id", 0));
          if (localTiledMapTile == null)
            continue;
          XmlReader.Element localElement5 = localElement4.getChildByName("animation");
          if (localElement5 == null)
            break label1357;
          Array localArray3 = new Array();
          IntArray localIntArray = new IntArray();
          Iterator localIterator4 = localElement5.getChildrenByName("frame").iterator();
          while (localIterator4.hasNext())
          {
            XmlReader.Element localElement7 = (XmlReader.Element)localIterator4.next();
            localArray3.add((StaticTiledMapTile)localTiledMapTileSet.getTile(i + localElement7.getIntAttribute("tileid")));
            localIntArray.add(localElement7.getIntAttribute("duration"));
          }
          localObject4 = new AnimatedTiledMapTile(localIntArray, localArray3);
          ((AnimatedTiledMapTile)localObject4).setId(localTiledMapTile.getId());
          localArray2.add(localObject4);
        }
        while (true)
        {
          String str5 = localElement4.getAttribute("terrain", null);
          if (str5 != null)
            ((TiledMapTile)localObject4).getProperties().put("terrain", str5);
          String str6 = localElement4.getAttribute("probability", null);
          if (str6 != null)
            ((TiledMapTile)localObject4).getProperties().put("probability", str6);
          XmlReader.Element localElement6 = localElement4.getChildByName("properties");
          if (localElement6 == null)
            break;
          loadProperties(((TiledMapTile)localObject4).getProperties(), localElement6);
          break;
          Iterator localIterator3 = localArray2.iterator();
          while (localIterator3.hasNext())
          {
            AnimatedTiledMapTile localAnimatedTiledMapTile = (AnimatedTiledMapTile)localIterator3.next();
            localTiledMapTileSet.putTile(localAnimatedTiledMapTile.getId(), localAnimatedTiledMapTile);
          }
          XmlReader.Element localElement3 = paramElement.getChildByName("properties");
          if (localElement3 != null)
            loadProperties(localTiledMapTileSet.getProperties(), localElement3);
          paramTiledMap.getTileSets().addTileSet(localTiledMapTileSet);
          return;
          label1357: localObject4 = localTiledMapTile;
        }
      }
      String str4 = str1;
      int i3 = m;
      int i4 = i1;
      int i5 = j;
      int i6 = n;
      Object localObject1 = str3;
      int i7 = i2;
      int i8 = k;
      int i9 = i7;
      Object localObject2 = null;
      int i10 = 0;
      int i11 = 0;
    }
  }

  protected TiledMap loadTilemap(XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver)
  {
    TiledMap localTiledMap = new TiledMap();
    String str1 = paramElement.getAttribute("orientation", null);
    int i = paramElement.getIntAttribute("width", 0);
    int j = paramElement.getIntAttribute("height", 0);
    int k = paramElement.getIntAttribute("tilewidth", 0);
    int m = paramElement.getIntAttribute("tileheight", 0);
    String str2 = paramElement.getAttribute("backgroundcolor", null);
    MapProperties localMapProperties = localTiledMap.getProperties();
    if (str1 != null)
      localMapProperties.put("orientation", str1);
    localMapProperties.put("width", Integer.valueOf(i));
    localMapProperties.put("height", Integer.valueOf(j));
    localMapProperties.put("tilewidth", Integer.valueOf(k));
    localMapProperties.put("tileheight", Integer.valueOf(m));
    if (str2 != null)
      localMapProperties.put("backgroundcolor", str2);
    this.mapTileWidth = k;
    this.mapTileHeight = m;
    this.mapWidthInPixels = (i * k);
    this.mapHeightInPixels = (j * m);
    if ((str1 != null) && ("staggered".equals(str1)) && (j > 1))
    {
      this.mapWidthInPixels += k / 2;
      this.mapHeightInPixels = (this.mapHeightInPixels / 2 + m / 2);
    }
    XmlReader.Element localElement1 = paramElement.getChildByName("properties");
    if (localElement1 != null)
      loadProperties(localTiledMap.getProperties(), localElement1);
    Iterator localIterator = paramElement.getChildrenByName("tileset").iterator();
    while (localIterator.hasNext())
    {
      XmlReader.Element localElement3 = (XmlReader.Element)localIterator.next();
      loadTileSet(localTiledMap, localElement3, paramFileHandle, paramImageResolver);
      paramElement.removeChild(localElement3);
    }
    int n = paramElement.getChildCount();
    int i1 = 0;
    if (i1 < n)
    {
      XmlReader.Element localElement2 = paramElement.getChild(i1);
      String str3 = localElement2.getName();
      if (str3.equals("layer"))
        loadTileLayer(localTiledMap, localElement2);
      while (true)
      {
        i1++;
        break;
        if (str3.equals("objectgroup"))
        {
          loadObjectGroup(localTiledMap, localElement2);
          continue;
        }
        if (!str3.equals("imagelayer"))
          continue;
        loadImageLayer(localTiledMap, localElement2, paramFileHandle, paramImageResolver);
      }
    }
    return localTiledMap;
  }

  protected Array loadTilesets(XmlReader.Element paramElement, FileHandle paramFileHandle)
  {
    Array localArray = new Array();
    Iterator localIterator1 = paramElement.getChildrenByName("tileset").iterator();
    while (localIterator1.hasNext())
    {
      XmlReader.Element localElement1 = (XmlReader.Element)localIterator1.next();
      String str = localElement1.getAttribute("source", null);
      if (str != null)
      {
        FileHandle localFileHandle = getRelativeFileHandle(paramFileHandle, str);
        XmlReader.Element localElement2 = this.xml.parse(localFileHandle);
        if (localElement2.getChildByName("image") != null)
        {
          localArray.add(getRelativeFileHandle(localFileHandle, localElement2.getChildByName("image").getAttribute("source")));
          continue;
        }
        Iterator localIterator3 = localElement2.getChildrenByName("tile").iterator();
        while (localIterator3.hasNext())
          localArray.add(getRelativeFileHandle(localFileHandle, ((XmlReader.Element)localIterator3.next()).getChildByName("image").getAttribute("source")));
        continue;
      }
      if (localElement1.getChildByName("image") != null)
      {
        localArray.add(getRelativeFileHandle(paramFileHandle, localElement1.getChildByName("image").getAttribute("source")));
        continue;
      }
      Iterator localIterator2 = localElement1.getChildrenByName("tile").iterator();
      while (localIterator2.hasNext())
        localArray.add(getRelativeFileHandle(paramFileHandle, ((XmlReader.Element)localIterator2.next()).getChildByName("image").getAttribute("source")));
    }
    return localArray;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TmxMapLoader
 * JD-Core Version:    0.6.0
 */