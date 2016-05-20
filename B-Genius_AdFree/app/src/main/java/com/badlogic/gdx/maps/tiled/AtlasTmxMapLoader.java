package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Values;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;
import java.util.Iterator;

public class AtlasTmxMapLoader extends BaseTmxMapLoader
{
  protected Array trackedTextures = new Array();

  public AtlasTmxMapLoader()
  {
    super(new InternalFileHandleResolver());
  }

  public AtlasTmxMapLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  private void setTextureFilters(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2)
  {
    Iterator localIterator = this.trackedTextures.iterator();
    while (localIterator.hasNext())
      ((Texture)localIterator.next()).setFilter(paramTextureFilter1, paramTextureFilter2);
    this.trackedTextures.clear();
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, AtlasTmxMapLoader.AtlasTiledMapLoaderParameters paramAtlasTiledMapLoaderParameters)
  {
    Array localArray = new Array();
    try
    {
      this.root = this.xml.parse(paramFileHandle);
      XmlReader.Element localElement1 = this.root.getChildByName("properties");
      if (localElement1 != null)
      {
        Iterator localIterator = localElement1.getChildrenByName("property").iterator();
        while (localIterator.hasNext())
        {
          XmlReader.Element localElement2 = (XmlReader.Element)localIterator.next();
          String str1 = localElement2.getAttribute("name");
          String str2 = localElement2.getAttribute("value");
          if (!str1.startsWith("atlas"))
            continue;
          localArray.add(new AssetDescriptor(getRelativeFileHandle(paramFileHandle, str2), TextureAtlas.class));
        }
      }
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("Unable to parse .tmx file.");
    }
    return localArray;
  }

  public TiledMap load(String paramString)
  {
    return load(paramString, new AtlasTmxMapLoader.AtlasTiledMapLoaderParameters());
  }

  public TiledMap load(String paramString, AtlasTmxMapLoader.AtlasTiledMapLoaderParameters paramAtlasTiledMapLoaderParameters)
  {
    if (paramAtlasTiledMapLoaderParameters != null);
    FileHandle localFileHandle1;
    ObjectMap localObjectMap;
    FileHandle localFileHandle2;
    while (true)
    {
      try
      {
        this.convertObjectToTileSpace = paramAtlasTiledMapLoaderParameters.convertObjectToTileSpace;
        this.flipY = paramAtlasTiledMapLoaderParameters.flipY;
        localFileHandle1 = resolve(paramString);
        this.root = this.xml.parse(localFileHandle1);
        localObjectMap = new ObjectMap();
        localFileHandle2 = loadAtlas(this.root, localFileHandle1);
        if (localFileHandle2 != null)
          break;
        throw new GdxRuntimeException("Couldn't load atlas");
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", localIOException);
      }
      this.convertObjectToTileSpace = false;
      this.flipY = true;
    }
    TextureAtlas localTextureAtlas = new TextureAtlas(localFileHandle2);
    localObjectMap.put(localFileHandle2.path(), localTextureAtlas);
    AtlasTmxMapLoader.AtlasResolver.DirectAtlasResolver localDirectAtlasResolver = new AtlasTmxMapLoader.AtlasResolver.DirectAtlasResolver(localObjectMap);
    TiledMap localTiledMap = loadMap(this.root, localFileHandle1, localDirectAtlasResolver);
    localTiledMap.setOwnedResources(localObjectMap.values().toArray());
    setTextureFilters(paramAtlasTiledMapLoaderParameters.textureMinFilter, paramAtlasTiledMapLoaderParameters.textureMagFilter);
    return localTiledMap;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, AtlasTmxMapLoader.AtlasTiledMapLoaderParameters paramAtlasTiledMapLoaderParameters)
  {
    this.map = null;
    if (paramAtlasTiledMapLoaderParameters != null)
    {
      this.convertObjectToTileSpace = paramAtlasTiledMapLoaderParameters.convertObjectToTileSpace;
      this.flipY = paramAtlasTiledMapLoaderParameters.flipY;
    }
    try
    {
      while (true)
      {
        this.map = loadMap(this.root, paramFileHandle, new AtlasTmxMapLoader.AtlasResolver.AssetManagerAtlasResolver(paramAssetManager));
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

  protected FileHandle loadAtlas(XmlReader.Element paramElement, FileHandle paramFileHandle)
  {
    XmlReader.Element localElement1 = paramElement.getChildByName("properties");
    Iterator localIterator;
    if (localElement1 != null)
      localIterator = localElement1.getChildrenByName("property").iterator();
    while (true)
    {
      XmlReader.Element localElement2;
      String str2;
      if (localIterator.hasNext())
      {
        localElement2 = (XmlReader.Element)localIterator.next();
        String str1 = localElement2.getAttribute("name", null);
        str2 = localElement2.getAttribute("value", null);
        if (!str1.equals("atlas"))
          continue;
        if (str2 != null)
          break label148;
      }
      label148: for (String str3 = localElement2.getText(); (str3 != null) && (str3.length() != 0); str3 = str2)
      {
        FileHandle localFileHandle = getRelativeFileHandle(paramFileHandle, str3);
        do
        {
          return localFileHandle;
          localFileHandle = paramFileHandle.sibling(paramFileHandle.nameWithoutExtension() + ".atlas");
        }
        while (localFileHandle.exists());
        return null;
      }
    }
  }

  protected TiledMap loadMap(XmlReader.Element paramElement, FileHandle paramFileHandle, AtlasTmxMapLoader.AtlasResolver paramAtlasResolver)
  {
    int i = 0;
    TiledMap localTiledMap = new TiledMap();
    String str1 = paramElement.getAttribute("orientation", null);
    int j = paramElement.getIntAttribute("width", 0);
    int k = paramElement.getIntAttribute("height", 0);
    int m = paramElement.getIntAttribute("tilewidth", 0);
    int n = paramElement.getIntAttribute("tileheight", 0);
    String str2 = paramElement.getAttribute("backgroundcolor", null);
    MapProperties localMapProperties = localTiledMap.getProperties();
    if (str1 != null)
      localMapProperties.put("orientation", str1);
    localMapProperties.put("width", Integer.valueOf(j));
    localMapProperties.put("height", Integer.valueOf(k));
    localMapProperties.put("tilewidth", Integer.valueOf(m));
    localMapProperties.put("tileheight", Integer.valueOf(n));
    if (str2 != null)
      localMapProperties.put("backgroundcolor", str2);
    this.mapTileWidth = m;
    this.mapTileHeight = n;
    this.mapWidthInPixels = (j * m);
    this.mapHeightInPixels = (k * n);
    if ((str1 != null) && ("staggered".equals(str1)) && (k > 1))
    {
      this.mapWidthInPixels += m / 2;
      this.mapHeightInPixels = (this.mapHeightInPixels / 2 + n / 2);
    }
    int i1 = paramElement.getChildCount();
    if (i < i1)
    {
      XmlReader.Element localElement = paramElement.getChild(i);
      String str3 = localElement.getName();
      if (str3.equals("properties"))
        loadProperties(localTiledMap.getProperties(), localElement);
      while (true)
      {
        i++;
        break;
        if (str3.equals("tileset"))
        {
          loadTileset(localTiledMap, localElement, paramFileHandle, paramAtlasResolver);
          continue;
        }
        if (str3.equals("layer"))
        {
          loadTileLayer(localTiledMap, localElement);
          continue;
        }
        if (!str3.equals("objectgroup"))
          continue;
        loadObjectGroup(localTiledMap, localElement);
      }
    }
    return localTiledMap;
  }

  public TiledMap loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, AtlasTmxMapLoader.AtlasTiledMapLoaderParameters paramAtlasTiledMapLoaderParameters)
  {
    if (paramAtlasTiledMapLoaderParameters != null)
      setTextureFilters(paramAtlasTiledMapLoaderParameters.textureMinFilter, paramAtlasTiledMapLoaderParameters.textureMagFilter);
    return this.map;
  }

  protected void loadTileset(TiledMap paramTiledMap, XmlReader.Element paramElement, FileHandle paramFileHandle, AtlasTmxMapLoader.AtlasResolver paramAtlasResolver)
  {
    TiledMapTileSet localTiledMapTileSet;
    label1194: Array localArray2;
    XmlReader.Element localElement4;
    TiledMapTile localTiledMapTile;
    Object localObject1;
    if (paramElement.getName().equals("tileset"))
    {
      String str1 = paramElement.get("name", null);
      int i = paramElement.getIntAttribute("firstgid", 1);
      int j = paramElement.getIntAttribute("tilewidth", 0);
      int k = paramElement.getIntAttribute("tileheight", 0);
      int m = paramElement.getIntAttribute("spacing", 0);
      int n = paramElement.getIntAttribute("margin", 0);
      String str2 = paramElement.getAttribute("source", null);
      String str3 = "";
      FileHandle localFileHandle2;
      if (str2 != null)
        localFileHandle2 = getRelativeFileHandle(paramFileHandle, str2);
      String str4;
      int i5;
      int i6;
      int i7;
      int i8;
      int i9;
      int i10;
      String str5;
      int i11;
      int i12;
      String str6;
      while (true)
      {
        try
        {
          paramElement = this.xml.parse(localFileHandle2);
          String str13 = paramElement.get("name", null);
          int i16 = paramElement.getIntAttribute("tilewidth", 0);
          int i17 = paramElement.getIntAttribute("tileheight", 0);
          int i18 = paramElement.getIntAttribute("spacing", 0);
          int i19 = paramElement.getIntAttribute("margin", 0);
          XmlReader.Element localElement11 = paramElement.getChildByName("tileoffset");
          int i20 = 0;
          int i21 = 0;
          if (localElement11 == null)
            continue;
          i21 = localElement11.getIntAttribute("x", 0);
          i20 = localElement11.getIntAttribute("y", 0);
          XmlReader.Element localElement12 = paramElement.getChildByName("image");
          int i22 = 0;
          int i23 = 0;
          if (localElement12 == null)
            continue;
          str3 = localElement12.getAttribute("source");
          i23 = localElement12.getIntAttribute("width", 0);
          i22 = localElement12.getIntAttribute("height", 0);
          getRelativeFileHandle(localFileHandle2, str3);
          str4 = str13;
          i5 = i16;
          i6 = i17;
          i7 = i18;
          i8 = i19;
          i9 = i21;
          i10 = i20;
          str5 = str3;
          i11 = i23;
          i12 = i22;
          str6 = (String)paramTiledMap.getProperties().get("atlas", String.class);
          if (str6 != null)
            continue;
          FileHandle localFileHandle1 = paramFileHandle.sibling(paramFileHandle.nameWithoutExtension() + ".atlas");
          if (!localFileHandle1.exists())
            continue;
          str6 = localFileHandle1.name();
          if (str6 != null)
            break;
          throw new GdxRuntimeException("The map is missing the 'atlas' property");
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
        int i3 = 0;
        int i4 = 0;
        if (localElement2 != null)
        {
          str3 = localElement2.getAttribute("source");
          i4 = localElement2.getIntAttribute("width", 0);
          i3 = localElement2.getIntAttribute("height", 0);
          getRelativeFileHandle(paramFileHandle, str3);
        }
        str4 = str1;
        i5 = j;
        i6 = k;
        i7 = m;
        i8 = n;
        i9 = i2;
        i10 = i1;
        str5 = str3;
        i11 = i4;
        i12 = i3;
      }
      TextureAtlas localTextureAtlas = paramAtlasResolver.getAtlas(resolve(getRelativeFileHandle(paramFileHandle, str6).path()).path());
      ObjectSet.ObjectSetIterator localObjectSetIterator = localTextureAtlas.getTextures().iterator();
      while (localObjectSetIterator.hasNext())
      {
        Texture localTexture = (Texture)localObjectSetIterator.next();
        this.trackedTextures.add(localTexture);
      }
      localTiledMapTileSet = new TiledMapTileSet();
      MapProperties localMapProperties = localTiledMapTileSet.getProperties();
      localTiledMapTileSet.setName(str4);
      localMapProperties.put("firstgid", Integer.valueOf(i));
      localMapProperties.put("imagesource", str5);
      localMapProperties.put("imagewidth", Integer.valueOf(i11));
      localMapProperties.put("imageheight", Integer.valueOf(i12));
      localMapProperties.put("tilewidth", Integer.valueOf(i5));
      localMapProperties.put("tileheight", Integer.valueOf(i6));
      localMapProperties.put("margin", Integer.valueOf(i8));
      localMapProperties.put("spacing", Integer.valueOf(i7));
      if ((str5 != null) && (str5.length() > 0))
      {
        int i14 = -1 + (i + i11 / i5 * (i12 / i6));
        Iterator localIterator5 = localTextureAtlas.findRegions(str4).iterator();
        while (localIterator5.hasNext())
        {
          TextureAtlas.AtlasRegion localAtlasRegion2 = (TextureAtlas.AtlasRegion)localIterator5.next();
          if (localAtlasRegion2 == null)
            continue;
          int i15 = 1 + localAtlasRegion2.index;
          if ((i15 < i) || (i15 > i14))
            continue;
          StaticTiledMapTile localStaticTiledMapTile2 = new StaticTiledMapTile(localAtlasRegion2);
          localStaticTiledMapTile2.setId(i15);
          localStaticTiledMapTile2.setOffsetX(i9);
          float f2;
          if (this.flipY)
            f2 = -i10;
          while (true)
          {
            localStaticTiledMapTile2.setOffsetY(f2);
            localTiledMapTileSet.putTile(i15, localStaticTiledMapTile2);
            break;
            f2 = i10;
          }
        }
      }
      Iterator localIterator1 = paramElement.getChildrenByName("tile").iterator();
      if (localIterator1.hasNext())
      {
        XmlReader.Element localElement8 = (XmlReader.Element)localIterator1.next();
        int i13 = i + localElement8.getIntAttribute("id", 0);
        Object localObject2 = localTiledMapTileSet.getTile(i13);
        StaticTiledMapTile localStaticTiledMapTile1;
        float f1;
        if (localObject2 == null)
        {
          XmlReader.Element localElement10 = localElement8.getChildByName("image");
          if (localElement10 != null)
          {
            String str11 = localElement10.getAttribute("source");
            String str12 = str11.substring(0, str11.lastIndexOf('.'));
            TextureAtlas.AtlasRegion localAtlasRegion1 = localTextureAtlas.findRegion(str12);
            if (localAtlasRegion1 == null)
              throw new GdxRuntimeException("Tileset region not found: " + str12);
            localStaticTiledMapTile1 = new StaticTiledMapTile(localAtlasRegion1);
            localStaticTiledMapTile1.setId(i13);
            localStaticTiledMapTile1.setOffsetX(i9);
            if (!this.flipY)
              break label1194;
            f1 = -i10;
          }
        }
        while (true)
        {
          localStaticTiledMapTile1.setOffsetY(f1);
          localTiledMapTileSet.putTile(i13, localStaticTiledMapTile1);
          localObject2 = localStaticTiledMapTile1;
          if (localObject2 == null)
            break;
          String str9 = localElement8.getAttribute("terrain", null);
          if (str9 != null)
            ((TiledMapTile)localObject2).getProperties().put("terrain", str9);
          String str10 = localElement8.getAttribute("probability", null);
          if (str10 != null)
            ((TiledMapTile)localObject2).getProperties().put("probability", str10);
          XmlReader.Element localElement9 = localElement8.getChildByName("properties");
          if (localElement9 == null)
            break;
          loadProperties(((TiledMapTile)localObject2).getProperties(), localElement9);
          break;
          f1 = i10;
        }
      }
      Array localArray1 = paramElement.getChildrenByName("tile");
      localArray2 = new Array();
      Iterator localIterator2 = localArray1.iterator();
      while (localIterator2.hasNext())
      {
        localElement4 = (XmlReader.Element)localIterator2.next();
        localTiledMapTile = localTiledMapTileSet.getTile(i + localElement4.getIntAttribute("id", 0));
        if (localTiledMapTile == null)
          continue;
        XmlReader.Element localElement5 = localElement4.getChildByName("animation");
        if (localElement5 == null)
          break label1583;
        Array localArray3 = new Array();
        IntArray localIntArray = new IntArray();
        Iterator localIterator4 = localElement5.getChildrenByName("frame").iterator();
        while (localIterator4.hasNext())
        {
          XmlReader.Element localElement7 = (XmlReader.Element)localIterator4.next();
          localArray3.add((StaticTiledMapTile)localTiledMapTileSet.getTile(i + localElement7.getIntAttribute("tileid")));
          localIntArray.add(localElement7.getIntAttribute("duration"));
        }
        localObject1 = new AnimatedTiledMapTile(localIntArray, localArray3);
        ((AnimatedTiledMapTile)localObject1).setId(localTiledMapTile.getId());
        localArray2.add(localObject1);
      }
    }
    while (true)
    {
      String str7 = localElement4.getAttribute("terrain", null);
      if (str7 != null)
        ((TiledMapTile)localObject1).getProperties().put("terrain", str7);
      String str8 = localElement4.getAttribute("probability", null);
      if (str8 != null)
        ((TiledMapTile)localObject1).getProperties().put("probability", str8);
      XmlReader.Element localElement6 = localElement4.getChildByName("properties");
      if (localElement6 == null)
        break;
      loadProperties(((TiledMapTile)localObject1).getProperties(), localElement6);
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
      label1583: localObject1 = localTiledMapTile;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.AtlasTmxMapLoader
 * JD-Core Version:    0.6.0
 */