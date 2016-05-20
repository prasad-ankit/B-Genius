package com.badlogic.gdx.net;

import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.utils.Disposable;

public abstract interface ServerSocket extends Disposable
{
  public abstract Socket accept(SocketHints paramSocketHints);

  public abstract Net.Protocol getProtocol();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.net.ServerSocket
 * JD-Core Version:    0.6.0
 */