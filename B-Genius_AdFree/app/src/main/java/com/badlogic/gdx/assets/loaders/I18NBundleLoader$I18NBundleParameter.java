package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import java.util.Locale;

public class I18NBundleLoader$I18NBundleParameter extends AssetLoaderParameters
{
  public final String encoding;
  public final Locale locale;

  public I18NBundleLoader$I18NBundleParameter()
  {
    this(null, null);
  }

  public I18NBundleLoader$I18NBundleParameter(Locale paramLocale)
  {
    this(paramLocale, null);
  }

  public I18NBundleLoader$I18NBundleParameter(Locale paramLocale, String paramString)
  {
    this.locale = paramLocale;
    this.encoding = paramString;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.I18NBundleLoader.I18NBundleParameter
 * JD-Core Version:    0.6.0
 */