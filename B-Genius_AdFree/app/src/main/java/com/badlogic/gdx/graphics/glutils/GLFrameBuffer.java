package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class GLFrameBuffer
  implements Disposable
{
  private static final int GL_DEPTH24_STENCIL8_OES = 35056;
  private static final Map buffers = new HashMap();
  private static int defaultFramebufferHandle;
  private static boolean defaultFramebufferHandleInitialized = false;
  protected GLTexture colorTexture;
  private int depthStencilPackedBufferHandle;
  private int depthbufferHandle;
  protected final Pixmap.Format format;
  private int framebufferHandle;
  protected final boolean hasDepth;
  private boolean hasDepthStencilPackedBuffer;
  protected final boolean hasStencil;
  protected final int height;
  private int stencilbufferHandle;
  protected final int width;

  public GLFrameBuffer(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramFormat, paramInt1, paramInt2, paramBoolean, false);
  }

  public GLFrameBuffer(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.format = paramFormat;
    this.hasDepth = paramBoolean1;
    this.hasStencil = paramBoolean2;
    build();
    addManagedFrameBuffer(Gdx.app, this);
  }

  private static void addManagedFrameBuffer(Application paramApplication, GLFrameBuffer paramGLFrameBuffer)
  {
    Array localArray = (Array)buffers.get(paramApplication);
    if (localArray == null)
      localArray = new Array();
    localArray.add(paramGLFrameBuffer);
    buffers.put(paramApplication, localArray);
  }

  private void build()
  {
    GL20 localGL20 = Gdx.gl20;
    int i;
    if (!defaultFramebufferHandleInitialized)
    {
      defaultFramebufferHandleInitialized = true;
      if (Gdx.app.getType() == Application.ApplicationType.iOS)
      {
        IntBuffer localIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
        localGL20.glGetIntegerv(36006, localIntBuffer);
        defaultFramebufferHandle = localIntBuffer.get(0);
      }
    }
    else
    {
      this.colorTexture = createColorTexture();
      this.framebufferHandle = localGL20.glGenFramebuffer();
      if (this.hasDepth)
        this.depthbufferHandle = localGL20.glGenRenderbuffer();
      if (this.hasStencil)
        this.stencilbufferHandle = localGL20.glGenRenderbuffer();
      localGL20.glBindTexture(3553, this.colorTexture.getTextureObjectHandle());
      if (this.hasDepth)
      {
        localGL20.glBindRenderbuffer(36161, this.depthbufferHandle);
        localGL20.glRenderbufferStorage(36161, 33189, this.colorTexture.getWidth(), this.colorTexture.getHeight());
      }
      if (this.hasStencil)
      {
        localGL20.glBindRenderbuffer(36161, this.stencilbufferHandle);
        localGL20.glRenderbufferStorage(36161, 36168, this.colorTexture.getWidth(), this.colorTexture.getHeight());
      }
      localGL20.glBindFramebuffer(36160, this.framebufferHandle);
      localGL20.glFramebufferTexture2D(36160, 36064, 3553, this.colorTexture.getTextureObjectHandle(), 0);
      if (this.hasDepth)
        localGL20.glFramebufferRenderbuffer(36160, 36096, 36161, this.depthbufferHandle);
      if (this.hasStencil)
        localGL20.glFramebufferRenderbuffer(36160, 36128, 36161, this.stencilbufferHandle);
      localGL20.glBindRenderbuffer(36161, 0);
      localGL20.glBindTexture(3553, 0);
      i = localGL20.glCheckFramebufferStatus(36160);
      if ((i == 36061) && (this.hasDepth) && (this.hasStencil) && (Gdx.graphics.supportsExtension("GL_OES_packed_depth_stencil")))
      {
        if (this.hasDepth)
        {
          localGL20.glDeleteRenderbuffer(this.depthbufferHandle);
          this.depthbufferHandle = 0;
        }
        if (this.hasStencil)
        {
          localGL20.glDeleteRenderbuffer(this.stencilbufferHandle);
          this.stencilbufferHandle = 0;
        }
        this.depthStencilPackedBufferHandle = localGL20.glGenRenderbuffer();
        this.hasDepthStencilPackedBuffer = true;
        localGL20.glBindRenderbuffer(36161, this.depthStencilPackedBufferHandle);
        localGL20.glRenderbufferStorage(36161, 35056, this.colorTexture.getWidth(), this.colorTexture.getHeight());
        localGL20.glBindRenderbuffer(36161, 0);
        localGL20.glFramebufferRenderbuffer(36160, 36096, 36161, this.depthStencilPackedBufferHandle);
        localGL20.glFramebufferRenderbuffer(36160, 36128, 36161, this.depthStencilPackedBufferHandle);
        i = localGL20.glCheckFramebufferStatus(36160);
      }
      localGL20.glBindFramebuffer(36160, defaultFramebufferHandle);
      if (i == 36053)
        return;
      disposeColorTexture(this.colorTexture);
      if (!this.hasDepthStencilPackedBuffer)
        break label574;
      localGL20.glDeleteBuffer(this.depthStencilPackedBufferHandle);
    }
    while (true)
    {
      localGL20.glDeleteFramebuffer(this.framebufferHandle);
      if (i != 36054)
        break label611;
      throw new IllegalStateException("frame buffer couldn't be constructed: incomplete attachment");
      defaultFramebufferHandle = 0;
      break;
      label574: if (this.hasDepth)
        localGL20.glDeleteRenderbuffer(this.depthbufferHandle);
      if (!this.hasStencil)
        continue;
      localGL20.glDeleteRenderbuffer(this.stencilbufferHandle);
    }
    label611: if (i == 36057)
      throw new IllegalStateException("frame buffer couldn't be constructed: incomplete dimensions");
    if (i == 36055)
      throw new IllegalStateException("frame buffer couldn't be constructed: missing attachment");
    if (i == 36061)
      throw new IllegalStateException("frame buffer couldn't be constructed: unsupported combination of formats");
    throw new IllegalStateException("frame buffer couldn't be constructed: unknown error " + i);
  }

  public static void clearAllFrameBuffers(Application paramApplication)
  {
    buffers.remove(paramApplication);
  }

  public static String getManagedStatus()
  {
    return getManagedStatus(new StringBuilder()).toString();
  }

  public static StringBuilder getManagedStatus(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("Managed buffers/app: { ");
    Iterator localIterator = buffers.keySet().iterator();
    while (localIterator.hasNext())
    {
      Application localApplication = (Application)localIterator.next();
      paramStringBuilder.append(((Array)buffers.get(localApplication)).size);
      paramStringBuilder.append(" ");
    }
    paramStringBuilder.append("}");
    return paramStringBuilder;
  }

  public static void invalidateAllFrameBuffers(Application paramApplication)
  {
    if (Gdx.gl20 == null);
    while (true)
    {
      return;
      Array localArray = (Array)buffers.get(paramApplication);
      if (localArray == null)
        continue;
      for (int i = 0; i < localArray.size; i++)
        ((GLFrameBuffer)localArray.get(i)).build();
    }
  }

  public static void unbind()
  {
    Gdx.gl20.glBindFramebuffer(36160, defaultFramebufferHandle);
  }

  public void begin()
  {
    bind();
    setFrameBufferViewport();
  }

  public void bind()
  {
    Gdx.gl20.glBindFramebuffer(36160, this.framebufferHandle);
  }

  protected abstract GLTexture createColorTexture();

  public void dispose()
  {
    GL20 localGL20 = Gdx.gl20;
    disposeColorTexture(this.colorTexture);
    if (this.hasDepthStencilPackedBuffer)
      localGL20.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
    while (true)
    {
      localGL20.glDeleteFramebuffer(this.framebufferHandle);
      if (buffers.get(Gdx.app) != null)
        ((Array)buffers.get(Gdx.app)).removeValue(this, true);
      return;
      if (this.hasDepth)
        localGL20.glDeleteRenderbuffer(this.depthbufferHandle);
      if (!this.hasStencil)
        continue;
      localGL20.glDeleteRenderbuffer(this.stencilbufferHandle);
    }
  }

  protected abstract void disposeColorTexture(GLTexture paramGLTexture);

  public void end()
  {
    end(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
  }

  public void end(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    unbind();
    Gdx.gl20.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public GLTexture getColorBufferTexture()
  {
    return this.colorTexture;
  }

  public int getDepth()
  {
    return this.colorTexture.getDepth();
  }

  public int getDepthBufferHandle()
  {
    return this.depthbufferHandle;
  }

  protected int getDepthStencilPackedBuffer()
  {
    return this.depthStencilPackedBufferHandle;
  }

  public int getFramebufferHandle()
  {
    return this.framebufferHandle;
  }

  public int getHeight()
  {
    return this.colorTexture.getHeight();
  }

  public int getStencilBufferHandle()
  {
    return this.stencilbufferHandle;
  }

  public int getWidth()
  {
    return this.colorTexture.getWidth();
  }

  protected void setFrameBufferViewport()
  {
    Gdx.gl20.glViewport(0, 0, this.colorTexture.getWidth(), this.colorTexture.getHeight());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.GLFrameBuffer
 * JD-Core Version:    0.6.0
 */