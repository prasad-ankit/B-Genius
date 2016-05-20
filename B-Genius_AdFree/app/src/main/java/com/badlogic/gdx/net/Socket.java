package com.badlogic.gdx.net;

import com.badlogic.gdx.utils.Disposable;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface Socket extends Disposable
{
  public abstract InputStream getInputStream();

  public abstract OutputStream getOutputStream();

  public abstract String getRemoteAddress();

  public abstract boolean isConnected();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.net.Socket
 * JD-Core Version:    0.6.0
 */