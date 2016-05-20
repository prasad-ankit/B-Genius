package com.badlogic.gdx.assets;

import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.I18NBundleLoader;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.assets.loaders.PixmapLoader;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.assets.loaders.SoundLoader;
import com.badlogic.gdx.assets.loaders.TextureAtlasLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonRegionLoader;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.ObjectIntMap;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.ObjectMap.Keys;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.UBJsonReader;
import com.badlogic.gdx.utils.async.AsyncExecutor;
import com.badlogic.gdx.utils.async.ThreadUtils;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import java.util.Iterator;
import java.util.Stack;

public class AssetManager
  implements Disposable
{
  final ObjectMap assetDependencies = new ObjectMap();
  final ObjectMap assetTypes = new ObjectMap();
  final ObjectMap assets = new ObjectMap();
  final AsyncExecutor executor;
  final ObjectSet injected = new ObjectSet();
  AssetErrorListener listener = null;
  final Array loadQueue = new Array();
  int loaded = 0;
  final ObjectMap loaders = new ObjectMap();
  Logger log = new Logger("AssetManager", 0);
  final Stack tasks = new Stack();
  int toLoad = 0;

  public AssetManager()
  {
    this(new InternalFileHandleResolver());
  }

  public AssetManager(FileHandleResolver paramFileHandleResolver)
  {
    this(paramFileHandleResolver, true);
  }

  public AssetManager(FileHandleResolver paramFileHandleResolver, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setLoader(BitmapFont.class, new BitmapFontLoader(paramFileHandleResolver));
      setLoader(Music.class, new MusicLoader(paramFileHandleResolver));
      setLoader(Pixmap.class, new PixmapLoader(paramFileHandleResolver));
      setLoader(Sound.class, new SoundLoader(paramFileHandleResolver));
      setLoader(TextureAtlas.class, new TextureAtlasLoader(paramFileHandleResolver));
      setLoader(Texture.class, new TextureLoader(paramFileHandleResolver));
      setLoader(Skin.class, new SkinLoader(paramFileHandleResolver));
      setLoader(com.badlogic.gdx.graphics.g2d.ParticleEffect.class, new com.badlogic.gdx.assets.loaders.ParticleEffectLoader(paramFileHandleResolver));
      setLoader(com.badlogic.gdx.graphics.g3d.particles.ParticleEffect.class, new com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader(paramFileHandleResolver));
      setLoader(PolygonRegion.class, new PolygonRegionLoader(paramFileHandleResolver));
      setLoader(I18NBundle.class, new I18NBundleLoader(paramFileHandleResolver));
      setLoader(Model.class, ".g3dj", new G3dModelLoader(new JsonReader(), paramFileHandleResolver));
      setLoader(Model.class, ".g3db", new G3dModelLoader(new UBJsonReader(), paramFileHandleResolver));
      setLoader(Model.class, ".obj", new ObjLoader(paramFileHandleResolver));
    }
    this.executor = new AsyncExecutor(1);
  }

  private void addTask(AssetDescriptor paramAssetDescriptor)
  {
    AssetLoader localAssetLoader = getLoader(paramAssetDescriptor.type, paramAssetDescriptor.fileName);
    if (localAssetLoader == null)
      throw new GdxRuntimeException("No loader for type: " + ClassReflection.getSimpleName(paramAssetDescriptor.type));
    this.tasks.push(new AssetLoadingTask(this, paramAssetDescriptor, localAssetLoader, this.executor));
  }

  private void handleTaskError(Throwable paramThrowable)
  {
    this.log.error("Error loading asset.", paramThrowable);
    if (this.tasks.isEmpty())
      throw new GdxRuntimeException(paramThrowable);
    AssetLoadingTask localAssetLoadingTask = (AssetLoadingTask)this.tasks.pop();
    AssetDescriptor localAssetDescriptor = localAssetLoadingTask.assetDesc;
    if ((localAssetLoadingTask.dependenciesLoaded) && (localAssetLoadingTask.dependencies != null))
    {
      Iterator localIterator = localAssetLoadingTask.dependencies.iterator();
      while (localIterator.hasNext())
        unload(((AssetDescriptor)localIterator.next()).fileName);
    }
    this.tasks.clear();
    if (this.listener != null)
    {
      this.listener.error(localAssetDescriptor, paramThrowable);
      return;
    }
    throw new GdxRuntimeException(paramThrowable);
  }

  private void incrementRefCountedDependencies(String paramString)
  {
    Array localArray = (Array)this.assetDependencies.get(paramString);
    if (localArray == null);
    while (true)
    {
      return;
      Iterator localIterator = localArray.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Class localClass = (Class)this.assetTypes.get(str);
        ((RefCountedContainer)((ObjectMap)this.assets.get(localClass)).get(str)).incRefCount();
        incrementRefCountedDependencies(str);
      }
    }
  }

  private void injectDependency(String paramString, AssetDescriptor paramAssetDescriptor)
  {
    monitorenter;
    try
    {
      Array localArray = (Array)this.assetDependencies.get(paramString);
      if (localArray == null)
      {
        localArray = new Array();
        this.assetDependencies.put(paramString, localArray);
      }
      localArray.add(paramAssetDescriptor.fileName);
      if (isLoaded(paramAssetDescriptor.fileName))
      {
        this.log.debug("Dependency already loaded: " + paramAssetDescriptor);
        Class localClass = (Class)this.assetTypes.get(paramAssetDescriptor.fileName);
        ((RefCountedContainer)((ObjectMap)this.assets.get(localClass)).get(paramAssetDescriptor.fileName)).incRefCount();
        incrementRefCountedDependencies(paramAssetDescriptor.fileName);
      }
      while (true)
      {
        return;
        this.log.info("Loading dependency: " + paramAssetDescriptor);
        addTask(paramAssetDescriptor);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void nextTask()
  {
    AssetDescriptor localAssetDescriptor = (AssetDescriptor)this.loadQueue.removeIndex(0);
    if (isLoaded(localAssetDescriptor.fileName))
    {
      this.log.debug("Already loaded: " + localAssetDescriptor);
      Class localClass = (Class)this.assetTypes.get(localAssetDescriptor.fileName);
      ((RefCountedContainer)((ObjectMap)this.assets.get(localClass)).get(localAssetDescriptor.fileName)).incRefCount();
      incrementRefCountedDependencies(localAssetDescriptor.fileName);
      if ((localAssetDescriptor.params != null) && (localAssetDescriptor.params.loadedCallback != null))
        localAssetDescriptor.params.loadedCallback.finishedLoading(this, localAssetDescriptor.fileName, localAssetDescriptor.type);
      this.loaded = (1 + this.loaded);
      return;
    }
    this.log.info("Loading: " + localAssetDescriptor);
    addTask(localAssetDescriptor);
  }

  private boolean updateTask()
  {
    AssetLoadingTask localAssetLoadingTask = (AssetLoadingTask)this.tasks.peek();
    try
    {
      if (!localAssetLoadingTask.cancel)
      {
        boolean bool = localAssetLoadingTask.update();
        if (!bool)
          break label73;
      }
      label73: for (i = 1; ; i = 0)
      {
        if (i == 0)
          break label228;
        if (this.tasks.size() == 1)
          this.loaded = (1 + this.loaded);
        this.tasks.pop();
        if (!localAssetLoadingTask.cancel)
          break;
        return true;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
      {
        localAssetLoadingTask.cancel = true;
        taskFailed(localAssetLoadingTask.assetDesc, localRuntimeException);
        int i = 1;
      }
      addAsset(localAssetLoadingTask.assetDesc.fileName, localAssetLoadingTask.assetDesc.type, localAssetLoadingTask.getAsset());
      if ((localAssetLoadingTask.assetDesc.params != null) && (localAssetLoadingTask.assetDesc.params.loadedCallback != null))
        localAssetLoadingTask.assetDesc.params.loadedCallback.finishedLoading(this, localAssetLoadingTask.assetDesc.fileName, localAssetLoadingTask.assetDesc.type);
      long l = TimeUtils.nanoTime();
      this.log.debug("Loaded: " + (float)(l - localAssetLoadingTask.startTime) / 1000000.0F + "ms " + localAssetLoadingTask.assetDesc);
      return true;
    }
    label228: return false;
  }

  protected void addAsset(String paramString, Class paramClass, Object paramObject)
  {
    this.assetTypes.put(paramString, paramClass);
    ObjectMap localObjectMap = (ObjectMap)this.assets.get(paramClass);
    if (localObjectMap == null)
    {
      localObjectMap = new ObjectMap();
      this.assets.put(paramClass, localObjectMap);
    }
    localObjectMap.put(paramString, new RefCountedContainer(paramObject));
  }

  public void clear()
  {
    monitorenter;
    while (true)
    {
      ObjectIntMap localObjectIntMap;
      Array localArray1;
      try
      {
        this.loadQueue.clear();
        if (!update())
          continue;
        localObjectIntMap = new ObjectIntMap();
        if (this.assetTypes.size <= 0)
          break;
        localObjectIntMap.clear();
        localArray1 = this.assetTypes.keys().toArray();
        Iterator localIterator1 = localArray1.iterator();
        if (localIterator1.hasNext())
        {
          localObjectIntMap.put((String)localIterator1.next(), 0);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      Iterator localIterator2 = localArray1.iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        Array localArray2 = (Array)this.assetDependencies.get(str2);
        if (localArray2 == null)
          continue;
        Iterator localIterator4 = localArray2.iterator();
        while (localIterator4.hasNext())
        {
          String str3 = (String)localIterator4.next();
          localObjectIntMap.put(str3, 1 + localObjectIntMap.get(str3, 0));
        }
      }
      Iterator localIterator3 = localArray1.iterator();
      while (localIterator3.hasNext())
      {
        String str1 = (String)localIterator3.next();
        if (localObjectIntMap.get(str1, 0) != 0)
          continue;
        unload(str1);
      }
    }
    this.assets.clear();
    this.assetTypes.clear();
    this.assetDependencies.clear();
    this.loaded = 0;
    this.toLoad = 0;
    this.loadQueue.clear();
    this.tasks.clear();
    monitorexit;
  }

  public boolean containsAsset(Object paramObject)
  {
    monitorenter;
    try
    {
      ObjectMap localObjectMap = (ObjectMap)this.assets.get(paramObject.getClass());
      int i;
      if (localObjectMap == null)
        i = 0;
      while (true)
      {
        return i;
        ObjectMap.Keys localKeys = localObjectMap.keys().iterator();
        while (true)
          if (localKeys.hasNext())
          {
            Object localObject2 = ((RefCountedContainer)localObjectMap.get((String)localKeys.next())).getObject(Object.class);
            if (localObject2 != paramObject)
            {
              boolean bool = paramObject.equals(localObject2);
              if (!bool)
                continue;
            }
            i = 1;
            break;
          }
        i = 0;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public void dispose()
  {
    monitorenter;
    try
    {
      this.log.debug("Disposing.");
      clear();
      this.executor.dispose();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void finishLoading()
  {
    this.log.debug("Waiting for loading to complete...");
    while (!update())
      ThreadUtils.yield();
    this.log.debug("Loading complete.");
  }

  public void finishLoadingAsset(String paramString)
  {
    this.log.debug("Waiting for asset to be loaded: " + paramString);
    while (!isLoaded(paramString))
    {
      update();
      ThreadUtils.yield();
    }
    this.log.debug("Asset loaded: " + paramString);
  }

  public Object get(AssetDescriptor paramAssetDescriptor)
  {
    monitorenter;
    try
    {
      Object localObject2 = get(paramAssetDescriptor.fileName, paramAssetDescriptor.type);
      monitorexit;
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      monitorexit;
    }
    throw localObject1;
  }

  public Object get(String paramString)
  {
    monitorenter;
    Class localClass;
    try
    {
      localClass = (Class)this.assetTypes.get(paramString);
      if (localClass == null)
        throw new GdxRuntimeException("Asset not loaded: " + paramString);
    }
    finally
    {
      monitorexit;
    }
    ObjectMap localObjectMap = (ObjectMap)this.assets.get(localClass);
    if (localObjectMap == null)
      throw new GdxRuntimeException("Asset not loaded: " + paramString);
    RefCountedContainer localRefCountedContainer = (RefCountedContainer)localObjectMap.get(paramString);
    if (localRefCountedContainer == null)
      throw new GdxRuntimeException("Asset not loaded: " + paramString);
    Object localObject2 = localRefCountedContainer.getObject(localClass);
    if (localObject2 == null)
      throw new GdxRuntimeException("Asset not loaded: " + paramString);
    monitorexit;
    return localObject2;
  }

  public Object get(String paramString, Class paramClass)
  {
    monitorenter;
    ObjectMap localObjectMap;
    try
    {
      localObjectMap = (ObjectMap)this.assets.get(paramClass);
      if (localObjectMap == null)
        throw new GdxRuntimeException("Asset not loaded: " + paramString);
    }
    finally
    {
      monitorexit;
    }
    RefCountedContainer localRefCountedContainer = (RefCountedContainer)localObjectMap.get(paramString);
    if (localRefCountedContainer == null)
      throw new GdxRuntimeException("Asset not loaded: " + paramString);
    Object localObject2 = localRefCountedContainer.getObject(paramClass);
    if (localObject2 == null)
      throw new GdxRuntimeException("Asset not loaded: " + paramString);
    monitorexit;
    return localObject2;
  }

  public Array getAll(Class paramClass, Array paramArray)
  {
    monitorenter;
    try
    {
      ObjectMap localObjectMap = (ObjectMap)this.assets.get(paramClass);
      if (localObjectMap != null)
      {
        ObjectMap.Entries localEntries = localObjectMap.entries().iterator();
        while (localEntries.hasNext())
          paramArray.add(((RefCountedContainer)((ObjectMap.Entry)localEntries.next()).value).getObject(paramClass));
      }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    return paramArray;
  }

  public String getAssetFileName(Object paramObject)
  {
    monitorenter;
    try
    {
      String str;
      boolean bool;
      do
      {
        ObjectMap.Keys localKeys1 = this.assets.keys().iterator();
        ObjectMap localObjectMap;
        ObjectMap.Keys localKeys2;
        while (!localKeys2.hasNext())
        {
          if (!localKeys1.hasNext())
            break;
          Class localClass = (Class)localKeys1.next();
          localObjectMap = (ObjectMap)this.assets.get(localClass);
          localKeys2 = localObjectMap.keys().iterator();
        }
        str = (String)localKeys2.next();
        Object localObject2 = ((RefCountedContainer)localObjectMap.get(str)).getObject(Object.class);
        if (localObject2 == paramObject)
          break;
        bool = paramObject.equals(localObject2);
      }
      while (!bool);
      while (true)
      {
        return str;
        str = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public Array getAssetNames()
  {
    monitorenter;
    try
    {
      Array localArray = this.assetTypes.keys().toArray();
      monitorexit;
      return localArray;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Class getAssetType(String paramString)
  {
    monitorenter;
    try
    {
      Class localClass = (Class)this.assetTypes.get(paramString);
      monitorexit;
      return localClass;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Array getDependencies(String paramString)
  {
    monitorenter;
    try
    {
      Array localArray = (Array)this.assetDependencies.get(paramString);
      monitorexit;
      return localArray;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public String getDiagnostics()
  {
    monitorenter;
    StringBuffer localStringBuffer;
    while (true)
    {
      try
      {
        localStringBuffer = new StringBuffer();
        ObjectMap.Keys localKeys = this.assetTypes.keys().iterator();
        if (!localKeys.hasNext())
          break;
        String str2 = (String)localKeys.next();
        localStringBuffer.append(str2);
        localStringBuffer.append(", ");
        Class localClass = (Class)this.assetTypes.get(str2);
        RefCountedContainer localRefCountedContainer = (RefCountedContainer)((ObjectMap)this.assets.get(localClass)).get(str2);
        Array localArray = (Array)this.assetDependencies.get(str2);
        localStringBuffer.append(ClassReflection.getSimpleName(localClass));
        localStringBuffer.append(", refs: ");
        localStringBuffer.append(localRefCountedContainer.getRefCount());
        if (localArray == null)
          break label203;
        localStringBuffer.append(", deps: [");
        Iterator localIterator = localArray.iterator();
        if (localIterator.hasNext())
        {
          localStringBuffer.append((String)localIterator.next());
          localStringBuffer.append(",");
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localStringBuffer.append("]");
      label203: localStringBuffer.append("\n");
    }
    String str1 = localStringBuffer.toString();
    monitorexit;
    return str1;
  }

  public int getLoadedAssets()
  {
    monitorenter;
    try
    {
      int i = this.assetTypes.size;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public AssetLoader getLoader(Class paramClass)
  {
    return getLoader(paramClass, null);
  }

  public AssetLoader getLoader(Class paramClass, String paramString)
  {
    ObjectMap localObjectMap = (ObjectMap)this.loaders.get(paramClass);
    Object localObject1 = null;
    if (localObjectMap != null)
    {
      int i = localObjectMap.size;
      localObject1 = null;
      if (i > 0);
    }
    else
    {
      return localObject1;
    }
    if (paramString == null)
      return (AssetLoader)localObjectMap.get("");
    int j = -1;
    ObjectMap.Entries localEntries = localObjectMap.entries().iterator();
    label63: Object localObject2;
    int k;
    if (localEntries.hasNext())
    {
      ObjectMap.Entry localEntry = (ObjectMap.Entry)localEntries.next();
      if ((((String)localEntry.key).length() <= j) || (!paramString.endsWith((String)localEntry.key)))
        break label150;
      localObject2 = (AssetLoader)localEntry.value;
      k = ((String)localEntry.key).length();
    }
    while (true)
    {
      j = k;
      localObject1 = localObject2;
      break label63;
      break;
      label150: k = j;
      localObject2 = localObject1;
    }
  }

  public Logger getLogger()
  {
    return this.log;
  }

  public float getProgress()
  {
    float f1 = 1.0F;
    monitorenter;
    try
    {
      int i = this.toLoad;
      if (i == 0);
      while (true)
      {
        return f1;
        float f2 = Math.min(1.0F, this.loaded / this.toLoad);
        f1 = f2;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public int getQueuedAssets()
  {
    monitorenter;
    try
    {
      int i = this.loadQueue.size;
      int j = this.tasks.size();
      int k = i + j;
      monitorexit;
      return k;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getReferenceCount(String paramString)
  {
    monitorenter;
    Class localClass;
    try
    {
      localClass = (Class)this.assetTypes.get(paramString);
      if (localClass == null)
        throw new GdxRuntimeException("Asset not loaded: " + paramString);
    }
    finally
    {
      monitorexit;
    }
    int i = ((RefCountedContainer)((ObjectMap)this.assets.get(localClass)).get(paramString)).getRefCount();
    monitorexit;
    return i;
  }

  void injectDependencies(String paramString, Array paramArray)
  {
    monitorenter;
    ObjectSet localObjectSet;
    try
    {
      localObjectSet = this.injected;
      Iterator localIterator = paramArray.iterator();
      while (localIterator.hasNext())
      {
        AssetDescriptor localAssetDescriptor = (AssetDescriptor)localIterator.next();
        if (localObjectSet.contains(localAssetDescriptor.fileName))
          continue;
        localObjectSet.add(localAssetDescriptor.fileName);
        injectDependency(paramString, localAssetDescriptor);
      }
    }
    finally
    {
      monitorexit;
    }
    localObjectSet.clear();
    monitorexit;
  }

  public boolean isLoaded(String paramString)
  {
    monitorenter;
    int i;
    if (paramString == null)
      i = 0;
    while (true)
    {
      monitorexit;
      return i;
      try
      {
        boolean bool = this.assetTypes.containsKey(paramString);
        i = bool;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  public boolean isLoaded(String paramString, Class paramClass)
  {
    monitorenter;
    try
    {
      ObjectMap localObjectMap = (ObjectMap)this.assets.get(paramClass);
      int i;
      if (localObjectMap == null)
        i = 0;
      while (true)
      {
        return i;
        RefCountedContainer localRefCountedContainer = (RefCountedContainer)localObjectMap.get(paramString);
        if (localRefCountedContainer == null)
        {
          i = 0;
          continue;
        }
        Object localObject2 = localRefCountedContainer.getObject(paramClass);
        if (localObject2 != null)
        {
          i = 1;
          continue;
        }
        i = 0;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public void load(AssetDescriptor paramAssetDescriptor)
  {
    monitorenter;
    try
    {
      load(paramAssetDescriptor.fileName, paramAssetDescriptor.type, paramAssetDescriptor.params);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void load(String paramString, Class paramClass)
  {
    monitorenter;
    try
    {
      load(paramString, paramClass, null);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void load(String paramString, Class paramClass, AssetLoaderParameters paramAssetLoaderParameters)
  {
    monitorenter;
    try
    {
      if (getLoader(paramClass, paramString) == null)
        throw new GdxRuntimeException("No loader for type: " + ClassReflection.getSimpleName(paramClass));
    }
    finally
    {
      monitorexit;
    }
    int k;
    int i;
    if (this.loadQueue.size == 0)
    {
      this.loaded = 0;
      this.toLoad = 0;
      break label444;
      int j = this.loadQueue.size;
      k = 0;
      if (i < j)
      {
        AssetDescriptor localAssetDescriptor1 = (AssetDescriptor)this.loadQueue.get(i);
        if ((!localAssetDescriptor1.fileName.equals(paramString)) || (localAssetDescriptor1.type.equals(paramClass)))
          break label450;
        throw new GdxRuntimeException("Asset with name '" + paramString + "' already in preload queue, but has different type (expected: " + ClassReflection.getSimpleName(paramClass) + ", found: " + ClassReflection.getSimpleName(localAssetDescriptor1.type) + ")");
      }
    }
    while (true)
    {
      if (k < this.tasks.size())
      {
        AssetDescriptor localAssetDescriptor3 = ((AssetLoadingTask)this.tasks.get(k)).assetDesc;
        if ((localAssetDescriptor3.fileName.equals(paramString)) && (!localAssetDescriptor3.type.equals(paramClass)))
          throw new GdxRuntimeException("Asset with name '" + paramString + "' already in task list, but has different type (expected: " + ClassReflection.getSimpleName(paramClass) + ", found: " + ClassReflection.getSimpleName(localAssetDescriptor3.type) + ")");
      }
      else
      {
        Class localClass = (Class)this.assetTypes.get(paramString);
        if ((localClass != null) && (!localClass.equals(paramClass)))
          throw new GdxRuntimeException("Asset with name '" + paramString + "' already loaded, but has different type (expected: " + ClassReflection.getSimpleName(paramClass) + ", found: " + ClassReflection.getSimpleName(localClass) + ")");
        this.toLoad = (1 + this.toLoad);
        AssetDescriptor localAssetDescriptor2 = new AssetDescriptor(paramString, paramClass, paramAssetLoaderParameters);
        this.loadQueue.add(localAssetDescriptor2);
        this.log.debug("Queued: " + localAssetDescriptor2);
        monitorexit;
        return;
        label444: i = 0;
        break;
        label450: i++;
        break;
      }
      k++;
    }
  }

  public void setErrorListener(AssetErrorListener paramAssetErrorListener)
  {
    monitorenter;
    try
    {
      this.listener = paramAssetErrorListener;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setLoader(Class paramClass, AssetLoader paramAssetLoader)
  {
    monitorenter;
    try
    {
      setLoader(paramClass, null, paramAssetLoader);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setLoader(Class paramClass, String paramString, AssetLoader paramAssetLoader)
  {
    monitorenter;
    if (paramClass == null)
      try
      {
        throw new IllegalArgumentException("type cannot be null.");
      }
      finally
      {
        monitorexit;
      }
    if (paramAssetLoader == null)
      throw new IllegalArgumentException("loader cannot be null.");
    this.log.debug("Loader set: " + ClassReflection.getSimpleName(paramClass) + " -> " + ClassReflection.getSimpleName(paramAssetLoader.getClass()));
    ObjectMap localObjectMap1 = (ObjectMap)this.loaders.get(paramClass);
    if (localObjectMap1 == null)
    {
      ObjectMap localObjectMap2 = this.loaders;
      localObjectMap1 = new ObjectMap();
      localObjectMap2.put(paramClass, localObjectMap1);
    }
    while (true)
    {
      localObjectMap1.put(paramString, paramAssetLoader);
      monitorexit;
      return;
      if (paramString != null)
        continue;
      paramString = "";
    }
  }

  public void setLogger(Logger paramLogger)
  {
    this.log = paramLogger;
  }

  public void setReferenceCount(String paramString, int paramInt)
  {
    monitorenter;
    Class localClass;
    try
    {
      localClass = (Class)this.assetTypes.get(paramString);
      if (localClass == null)
        throw new GdxRuntimeException("Asset not loaded: " + paramString);
    }
    finally
    {
      monitorexit;
    }
    ((RefCountedContainer)((ObjectMap)this.assets.get(localClass)).get(paramString)).setRefCount(paramInt);
    monitorexit;
  }

  protected void taskFailed(AssetDescriptor paramAssetDescriptor, RuntimeException paramRuntimeException)
  {
    throw paramRuntimeException;
  }

  public void unload(String paramString)
  {
    monitorenter;
    while (true)
    {
      int i;
      try
      {
        if (this.tasks.size() <= 0)
          continue;
        AssetLoadingTask localAssetLoadingTask = (AssetLoadingTask)this.tasks.firstElement();
        if (!localAssetLoadingTask.assetDesc.fileName.equals(paramString))
          continue;
        localAssetLoadingTask.cancel = true;
        this.log.debug("Unload (from tasks): " + paramString);
        return;
        i = 0;
        if (i >= this.loadQueue.size)
          break label440;
        if (((AssetDescriptor)this.loadQueue.get(i)).fileName.equals(paramString))
        {
          j = i;
          if (j == -1)
            break label173;
          this.toLoad = (-1 + this.toLoad);
          this.loadQueue.removeIndex(j);
          this.log.debug("Unload (from queue): " + paramString);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      i++;
      continue;
      label173: Class localClass = (Class)this.assetTypes.get(paramString);
      if (localClass == null)
        throw new GdxRuntimeException("Asset not loaded: " + paramString);
      RefCountedContainer localRefCountedContainer = (RefCountedContainer)((ObjectMap)this.assets.get(localClass)).get(paramString);
      localRefCountedContainer.decRefCount();
      if (localRefCountedContainer.getRefCount() <= 0)
      {
        this.log.debug("Unload (dispose): " + paramString);
        if ((localRefCountedContainer.getObject(Object.class) instanceof Disposable))
          ((Disposable)localRefCountedContainer.getObject(Object.class)).dispose();
        this.assetTypes.remove(paramString);
        ((ObjectMap)this.assets.get(localClass)).remove(paramString);
      }
      while (true)
      {
        Array localArray = (Array)this.assetDependencies.get(paramString);
        if (localArray == null)
          break;
        Iterator localIterator = localArray.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!isLoaded(str))
            continue;
          unload(str);
        }
        this.log.debug("Unload (decrement): " + paramString);
      }
      if (localRefCountedContainer.getRefCount() > 0)
        continue;
      this.assetDependencies.remove(paramString);
      continue;
      label440: int j = -1;
    }
  }

  public boolean update()
  {
    int i = 1;
    monitorenter;
    try
    {
      if (this.tasks.size() == 0)
        while ((this.loadQueue.size != 0) && (this.tasks.size() == 0))
          nextTask();
    }
    catch (Throwable localThrowable)
    {
      handleTaskError(localThrowable);
      int j = this.loadQueue.size;
      if (j == 0);
      while (true)
      {
        return i;
        if (this.tasks.size() == 0)
          continue;
        if ((updateTask()) && (this.loadQueue.size == 0))
        {
          int k = this.tasks.size();
          if (k == 0)
            continue;
        }
        i = 0;
        continue;
        i = 0;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean update(int paramInt)
  {
    long l = TimeUtils.millis() + paramInt;
    while (true)
    {
      boolean bool = update();
      if ((bool) || (TimeUtils.millis() > l))
        return bool;
      ThreadUtils.yield();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.AssetManager
 * JD-Core Version:    0.6.0
 */