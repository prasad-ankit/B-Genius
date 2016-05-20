package com.badlogic.gdx.graphics;

import com.badlogic.gdx.assets.AssetLoaderParameters.LoadedCallback;
import com.badlogic.gdx.assets.AssetManager;

final class Cubemap$1
  implements AssetLoaderParameters.LoadedCallback
{
  public final void finishedLoading(AssetManager paramAssetManager, String paramString, Class paramClass)
  {
    paramAssetManager.setReferenceCount(paramString, this.val$refCount);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.Cubemap.1
 * JD-Core Version:    0.6.0
 */