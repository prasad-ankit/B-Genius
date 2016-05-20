package com.badlogic.gdx.assets.loaders.resolvers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public class ResolutionFileResolver
  implements FileHandleResolver
{
  protected final FileHandleResolver baseResolver;
  protected final ResolutionFileResolver.Resolution[] descriptors;

  public ResolutionFileResolver(FileHandleResolver paramFileHandleResolver, ResolutionFileResolver.Resolution[] paramArrayOfResolution)
  {
    if (paramArrayOfResolution.length == 0)
      throw new IllegalArgumentException("At least one Resolution needs to be supplied.");
    this.baseResolver = paramFileHandleResolver;
    this.descriptors = paramArrayOfResolution;
  }

  public static ResolutionFileResolver.Resolution choose(ResolutionFileResolver.Resolution[] paramArrayOfResolution)
  {
    int i = Gdx.graphics.getWidth();
    int j = Gdx.graphics.getHeight();
    ResolutionFileResolver.Resolution localResolution1 = paramArrayOfResolution[0];
    if (i < j)
    {
      int n = paramArrayOfResolution.length;
      localResolution2 = localResolution1;
      for (int i1 = 0; i1 < n; i1++)
      {
        ResolutionFileResolver.Resolution localResolution4 = paramArrayOfResolution[i1];
        if ((i < localResolution4.portraitWidth) || (localResolution4.portraitWidth < localResolution2.portraitWidth) || (j < localResolution4.portraitHeight) || (localResolution4.portraitHeight < localResolution2.portraitHeight))
          continue;
        localResolution2 = paramArrayOfResolution[i1];
      }
    }
    int k = paramArrayOfResolution.length;
    ResolutionFileResolver.Resolution localResolution2 = localResolution1;
    for (int m = 0; m < k; m++)
    {
      ResolutionFileResolver.Resolution localResolution3 = paramArrayOfResolution[m];
      if ((i < localResolution3.portraitHeight) || (localResolution3.portraitHeight < localResolution2.portraitHeight) || (j < localResolution3.portraitWidth) || (localResolution3.portraitWidth < localResolution2.portraitWidth))
        continue;
      localResolution2 = paramArrayOfResolution[m];
    }
    return localResolution2;
  }

  public FileHandle resolve(String paramString)
  {
    ResolutionFileResolver.Resolution localResolution = choose(this.descriptors);
    FileHandle localFileHandle1 = new FileHandle(paramString);
    FileHandle localFileHandle2 = this.baseResolver.resolve(resolve(localFileHandle1, localResolution.folder));
    if (!localFileHandle2.exists())
      localFileHandle2 = this.baseResolver.resolve(paramString);
    return localFileHandle2;
  }

  protected String resolve(FileHandle paramFileHandle, String paramString)
  {
    String str = "";
    FileHandle localFileHandle = paramFileHandle.parent();
    if ((localFileHandle != null) && (!localFileHandle.name().equals("")))
      str = localFileHandle + "/";
    return str + paramString + "/" + paramFileHandle.name();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver
 * JD-Core Version:    0.6.0
 */