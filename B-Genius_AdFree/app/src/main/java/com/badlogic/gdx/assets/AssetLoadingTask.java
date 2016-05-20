package com.badlogic.gdx.assets;

import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.async.AsyncExecutor;
import com.badlogic.gdx.utils.async.AsyncResult;
import com.badlogic.gdx.utils.async.AsyncTask;

class AssetLoadingTask
  implements AsyncTask
{
  volatile Object asset = null;
  final AssetDescriptor assetDesc;
  volatile boolean asyncDone = false;
  volatile boolean cancel = false;
  volatile Array dependencies;
  volatile boolean dependenciesLoaded = false;
  volatile AsyncResult depsFuture = null;
  final AsyncExecutor executor;
  volatile AsyncResult loadFuture = null;
  final AssetLoader loader;
  AssetManager manager;
  final long startTime;
  int ticks = 0;

  public AssetLoadingTask(AssetManager paramAssetManager, AssetDescriptor paramAssetDescriptor, AssetLoader paramAssetLoader, AsyncExecutor paramAsyncExecutor)
  {
    this.manager = paramAssetManager;
    this.assetDesc = paramAssetDescriptor;
    this.loader = paramAssetLoader;
    this.executor = paramAsyncExecutor;
    long l;
    if (paramAssetManager.log.getLevel() == 3)
      l = TimeUtils.nanoTime();
    while (true)
    {
      this.startTime = l;
      return;
      l = 0L;
    }
  }

  private void handleAsyncLoader()
  {
    AsynchronousAssetLoader localAsynchronousAssetLoader = (AsynchronousAssetLoader)this.loader;
    if (!this.dependenciesLoaded)
      if (this.depsFuture == null)
        this.depsFuture = this.executor.submit(this);
    do
    {
      while (true)
      {
        return;
        if (!this.depsFuture.isDone())
          continue;
        try
        {
          this.depsFuture.get();
          this.dependenciesLoaded = true;
          if (!this.asyncDone)
            continue;
          this.asset = localAsynchronousAssetLoader.loadSync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
          return;
        }
        catch (Exception localException2)
        {
          throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.assetDesc.fileName, localException2);
        }
      }
      if ((this.loadFuture == null) && (!this.asyncDone))
      {
        this.loadFuture = this.executor.submit(this);
        return;
      }
      if (!this.asyncDone)
        continue;
      this.asset = localAsynchronousAssetLoader.loadSync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
      return;
    }
    while (!this.loadFuture.isDone());
    try
    {
      this.loadFuture.get();
      this.asset = localAsynchronousAssetLoader.loadSync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
      return;
    }
    catch (Exception localException1)
    {
    }
    throw new GdxRuntimeException("Couldn't load asset: " + this.assetDesc.fileName, localException1);
  }

  private void handleSyncLoader()
  {
    SynchronousAssetLoader localSynchronousAssetLoader = (SynchronousAssetLoader)this.loader;
    if (!this.dependenciesLoaded)
    {
      this.dependenciesLoaded = true;
      this.dependencies = localSynchronousAssetLoader.getDependencies(this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
      if (this.dependencies == null)
      {
        this.asset = localSynchronousAssetLoader.load(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
        return;
      }
      removeDuplicates(this.dependencies);
      this.manager.injectDependencies(this.assetDesc.fileName, this.dependencies);
      return;
    }
    this.asset = localSynchronousAssetLoader.load(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
  }

  private void removeDuplicates(Array paramArray)
  {
    boolean bool = paramArray.ordered;
    paramArray.ordered = true;
    for (int i = 0; i < paramArray.size; i++)
    {
      String str = ((AssetDescriptor)paramArray.get(i)).fileName;
      Class localClass = ((AssetDescriptor)paramArray.get(i)).type;
      for (int j = -1 + paramArray.size; j > i; j--)
      {
        if ((localClass != ((AssetDescriptor)paramArray.get(j)).type) || (!str.equals(((AssetDescriptor)paramArray.get(j)).fileName)))
          continue;
        paramArray.removeIndex(j);
      }
    }
    paramArray.ordered = bool;
  }

  private FileHandle resolve(AssetLoader paramAssetLoader, AssetDescriptor paramAssetDescriptor)
  {
    if (paramAssetDescriptor.file == null)
      paramAssetDescriptor.file = paramAssetLoader.resolve(paramAssetDescriptor.fileName);
    return paramAssetDescriptor.file;
  }

  public Void call()
  {
    AsynchronousAssetLoader localAsynchronousAssetLoader = (AsynchronousAssetLoader)this.loader;
    if (!this.dependenciesLoaded)
    {
      this.dependencies = localAsynchronousAssetLoader.getDependencies(this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
      if (this.dependencies != null)
      {
        removeDuplicates(this.dependencies);
        this.manager.injectDependencies(this.assetDesc.fileName, this.dependencies);
      }
    }
    while (true)
    {
      return null;
      localAsynchronousAssetLoader.loadAsync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
      this.asyncDone = true;
      continue;
      localAsynchronousAssetLoader.loadAsync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
    }
  }

  public Object getAsset()
  {
    return this.asset;
  }

  public boolean update()
  {
    this.ticks = (1 + this.ticks);
    if ((this.loader instanceof SynchronousAssetLoader))
      handleSyncLoader();
    while (this.asset != null)
    {
      return true;
      handleAsyncLoader();
    }
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.AssetLoadingTask
 * JD-Core Version:    0.6.0
 */