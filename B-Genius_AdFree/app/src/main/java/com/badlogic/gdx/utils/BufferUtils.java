package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class BufferUtils
{
  static int allocatedUnsafe;
  static Array unsafeBuffers = new Array();

  static
  {
    allocatedUnsafe = 0;
  }

  private static int bytesToElements(Buffer paramBuffer, int paramInt)
  {
    if ((paramBuffer instanceof ByteBuffer))
      return paramInt;
    if ((paramBuffer instanceof ShortBuffer))
      return paramInt >>> 1;
    if ((paramBuffer instanceof CharBuffer))
      return paramInt >>> 1;
    if ((paramBuffer instanceof IntBuffer))
      return paramInt >>> 2;
    if ((paramBuffer instanceof LongBuffer))
      return paramInt >>> 3;
    if ((paramBuffer instanceof FloatBuffer))
      return paramInt >>> 2;
    if ((paramBuffer instanceof DoubleBuffer))
      return paramInt >>> 3;
    throw new GdxRuntimeException("Can't copy to a " + paramBuffer.getClass().getName() + " instance");
  }

  public static native void clear(ByteBuffer paramByteBuffer, int paramInt);

  public static void copy(Buffer paramBuffer1, Buffer paramBuffer2, int paramInt)
  {
    int i = elementsToBytes(paramBuffer1, paramInt);
    paramBuffer2.limit(paramBuffer2.position() + bytesToElements(paramBuffer2, i));
    copyJni(paramBuffer1, positionInBytes(paramBuffer1), paramBuffer2, positionInBytes(paramBuffer2), i);
  }

  public static void copy(byte[] paramArrayOfByte, int paramInt1, Buffer paramBuffer, int paramInt2)
  {
    paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2));
    copyJni(paramArrayOfByte, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2);
  }

  public static void copy(char[] paramArrayOfChar, int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    copyJni(paramArrayOfChar, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 1);
  }

  public static void copy(char[] paramArrayOfChar, int paramInt1, Buffer paramBuffer, int paramInt2)
  {
    paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 1));
    copyJni(paramArrayOfChar, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 1);
  }

  public static void copy(double[] paramArrayOfDouble, int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    copyJni(paramArrayOfDouble, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 3);
  }

  public static void copy(double[] paramArrayOfDouble, int paramInt1, Buffer paramBuffer, int paramInt2)
  {
    paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 3));
    copyJni(paramArrayOfDouble, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 3);
  }

  public static void copy(float[] paramArrayOfFloat, int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    copyJni(paramArrayOfFloat, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 2);
  }

  public static void copy(float[] paramArrayOfFloat, int paramInt1, Buffer paramBuffer, int paramInt2)
  {
    paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 2));
    copyJni(paramArrayOfFloat, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 2);
  }

  public static void copy(float[] paramArrayOfFloat, Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    if ((paramBuffer instanceof ByteBuffer))
      paramBuffer.limit(paramInt1 << 2);
    while (true)
    {
      copyJni(paramArrayOfFloat, paramBuffer, paramInt1, paramInt2);
      paramBuffer.position(0);
      return;
      if (!(paramBuffer instanceof FloatBuffer))
        continue;
      paramBuffer.limit(paramInt1);
    }
  }

  public static void copy(int[] paramArrayOfInt, int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    copyJni(paramArrayOfInt, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 2);
  }

  public static void copy(int[] paramArrayOfInt, int paramInt1, Buffer paramBuffer, int paramInt2)
  {
    paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 2));
    copyJni(paramArrayOfInt, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 2);
  }

  public static void copy(long[] paramArrayOfLong, int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    copyJni(paramArrayOfLong, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 3);
  }

  public static void copy(long[] paramArrayOfLong, int paramInt1, Buffer paramBuffer, int paramInt2)
  {
    paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 3));
    copyJni(paramArrayOfLong, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 3);
  }

  public static void copy(short[] paramArrayOfShort, int paramInt1, Buffer paramBuffer, int paramInt2)
  {
    paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 1));
    copyJni(paramArrayOfShort, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 1);
  }

  private static native void copyJni(Buffer paramBuffer1, int paramInt1, Buffer paramBuffer2, int paramInt2, int paramInt3);

  private static native void copyJni(byte[] paramArrayOfByte, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);

  private static native void copyJni(char[] paramArrayOfChar, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);

  private static native void copyJni(double[] paramArrayOfDouble, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);

  private static native void copyJni(float[] paramArrayOfFloat, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);

  private static native void copyJni(float[] paramArrayOfFloat, Buffer paramBuffer, int paramInt1, int paramInt2);

  private static native void copyJni(int[] paramArrayOfInt, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);

  private static native void copyJni(long[] paramArrayOfLong, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);

  private static native void copyJni(short[] paramArrayOfShort, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);

  public static void disposeUnsafeByteBuffer(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.capacity();
    synchronized (unsafeBuffers)
    {
      if (!unsafeBuffers.removeValue(paramByteBuffer, true))
        throw new IllegalArgumentException("buffer not allocated with newUnsafeByteBuffer or already disposed");
    }
    monitorexit;
    allocatedUnsafe -= i;
    freeMemory(paramByteBuffer);
  }

  private static int elementsToBytes(Buffer paramBuffer, int paramInt)
  {
    if ((paramBuffer instanceof ByteBuffer))
      return paramInt;
    if ((paramBuffer instanceof ShortBuffer))
      return paramInt << 1;
    if ((paramBuffer instanceof CharBuffer))
      return paramInt << 1;
    if ((paramBuffer instanceof IntBuffer))
      return paramInt << 2;
    if ((paramBuffer instanceof LongBuffer))
      return paramInt << 3;
    if ((paramBuffer instanceof FloatBuffer))
      return paramInt << 2;
    if ((paramBuffer instanceof DoubleBuffer))
      return paramInt << 3;
    throw new GdxRuntimeException("Can't copy to a " + paramBuffer.getClass().getName() + " instance");
  }

  private static native long find(Buffer paramBuffer1, int paramInt1, int paramInt2, Buffer paramBuffer2, int paramInt3, int paramInt4);

  private static native long find(Buffer paramBuffer1, int paramInt1, int paramInt2, Buffer paramBuffer2, int paramInt3, int paramInt4, float paramFloat);

  private static native long find(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, int paramInt4);

  private static native long find(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, int paramInt4, float paramFloat);

  private static native long find(float[] paramArrayOfFloat, int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3, int paramInt4);

  private static native long find(float[] paramArrayOfFloat, int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3, int paramInt4, float paramFloat);

  private static native long find(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3, int paramInt4);

  private static native long find(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3, int paramInt4, float paramFloat);

  public static long findFloats(Buffer paramBuffer1, int paramInt1, Buffer paramBuffer2, int paramInt2)
  {
    return find(paramBuffer1, positionInBytes(paramBuffer1), paramInt1, paramBuffer2, positionInBytes(paramBuffer2), paramInt2);
  }

  public static long findFloats(Buffer paramBuffer1, int paramInt1, Buffer paramBuffer2, int paramInt2, float paramFloat)
  {
    return find(paramBuffer1, positionInBytes(paramBuffer1), paramInt1, paramBuffer2, positionInBytes(paramBuffer2), paramInt2, paramFloat);
  }

  public static long findFloats(Buffer paramBuffer, int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    return find(paramBuffer, positionInBytes(paramBuffer), paramInt1, paramArrayOfFloat, 0, paramInt2);
  }

  public static long findFloats(Buffer paramBuffer, int paramInt1, float[] paramArrayOfFloat, int paramInt2, float paramFloat)
  {
    return find(paramBuffer, positionInBytes(paramBuffer), paramInt1, paramArrayOfFloat, 0, paramInt2, paramFloat);
  }

  public static long findFloats(float[] paramArrayOfFloat, int paramInt1, Buffer paramBuffer, int paramInt2)
  {
    return find(paramArrayOfFloat, 0, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2);
  }

  public static long findFloats(float[] paramArrayOfFloat, int paramInt1, Buffer paramBuffer, int paramInt2, float paramFloat)
  {
    return find(paramArrayOfFloat, 0, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2, paramFloat);
  }

  public static long findFloats(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2)
  {
    return find(paramArrayOfFloat1, 0, paramInt1, paramArrayOfFloat2, 0, paramInt2);
  }

  public static long findFloats(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2, float paramFloat)
  {
    return find(paramArrayOfFloat1, 0, paramInt1, paramArrayOfFloat2, 0, paramInt2, paramFloat);
  }

  private static native void freeMemory(ByteBuffer paramByteBuffer);

  public static int getAllocatedBytesUnsafe()
  {
    return allocatedUnsafe;
  }

  private static native long getBufferAddress(Buffer paramBuffer);

  public static long getUnsafeBufferAddress(Buffer paramBuffer)
  {
    return getBufferAddress(paramBuffer) + paramBuffer.position();
  }

  public static ByteBuffer newByteBuffer(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer;
  }

  public static CharBuffer newCharBuffer(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt << 1);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.asCharBuffer();
  }

  private static native ByteBuffer newDisposableByteBuffer(int paramInt);

  public static DoubleBuffer newDoubleBuffer(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt << 3);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.asDoubleBuffer();
  }

  public static FloatBuffer newFloatBuffer(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt << 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.asFloatBuffer();
  }

  public static IntBuffer newIntBuffer(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt << 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.asIntBuffer();
  }

  public static LongBuffer newLongBuffer(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt << 3);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.asLongBuffer();
  }

  public static ShortBuffer newShortBuffer(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt << 1);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.asShortBuffer();
  }

  public static ByteBuffer newUnsafeByteBuffer(int paramInt)
  {
    ByteBuffer localByteBuffer = newDisposableByteBuffer(paramInt);
    localByteBuffer.order(ByteOrder.nativeOrder());
    allocatedUnsafe = paramInt + allocatedUnsafe;
    synchronized (unsafeBuffers)
    {
      unsafeBuffers.add(localByteBuffer);
      return localByteBuffer;
    }
  }

  public static ByteBuffer newUnsafeByteBuffer(ByteBuffer paramByteBuffer)
  {
    allocatedUnsafe += paramByteBuffer.capacity();
    synchronized (unsafeBuffers)
    {
      unsafeBuffers.add(paramByteBuffer);
      return paramByteBuffer;
    }
  }

  private static int positionInBytes(Buffer paramBuffer)
  {
    if ((paramBuffer instanceof ByteBuffer))
      return paramBuffer.position();
    if ((paramBuffer instanceof ShortBuffer))
      return paramBuffer.position() << 1;
    if ((paramBuffer instanceof CharBuffer))
      return paramBuffer.position() << 1;
    if ((paramBuffer instanceof IntBuffer))
      return paramBuffer.position() << 2;
    if ((paramBuffer instanceof LongBuffer))
      return paramBuffer.position() << 3;
    if ((paramBuffer instanceof FloatBuffer))
      return paramBuffer.position() << 2;
    if ((paramBuffer instanceof DoubleBuffer))
      return paramBuffer.position() << 3;
    throw new GdxRuntimeException("Can't copy to a " + paramBuffer.getClass().getName() + " instance");
  }

  public static void transform(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, Matrix3 paramMatrix3)
  {
    transform(paramBuffer, paramInt1, paramInt2, paramInt3, paramMatrix3, 0);
  }

  public static void transform(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, Matrix3 paramMatrix3, int paramInt4)
  {
    switch (paramInt1)
    {
    default:
      throw new IllegalArgumentException();
    case 3:
      transformV3M3Jni(paramBuffer, paramInt2, paramInt3, paramMatrix3.val, paramInt4 + positionInBytes(paramBuffer));
      return;
    case 2:
    }
    transformV2M3Jni(paramBuffer, paramInt2, paramInt3, paramMatrix3.val, paramInt4 + positionInBytes(paramBuffer));
  }

  public static void transform(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, Matrix4 paramMatrix4)
  {
    transform(paramBuffer, paramInt1, paramInt2, paramInt3, paramMatrix4, 0);
  }

  public static void transform(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, Matrix4 paramMatrix4, int paramInt4)
  {
    switch (paramInt1)
    {
    default:
      throw new IllegalArgumentException();
    case 4:
      transformV4M4Jni(paramBuffer, paramInt2, paramInt3, paramMatrix4.val, paramInt4 + positionInBytes(paramBuffer));
      return;
    case 3:
      transformV3M4Jni(paramBuffer, paramInt2, paramInt3, paramMatrix4.val, paramInt4 + positionInBytes(paramBuffer));
      return;
    case 2:
    }
    transformV2M4Jni(paramBuffer, paramInt2, paramInt3, paramMatrix4.val, paramInt4 + positionInBytes(paramBuffer));
  }

  public static void transform(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, Matrix3 paramMatrix3)
  {
    transform(paramArrayOfFloat, paramInt1, paramInt2, paramInt3, paramMatrix3, 0);
  }

  public static void transform(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, Matrix3 paramMatrix3, int paramInt4)
  {
    switch (paramInt1)
    {
    default:
      throw new IllegalArgumentException();
    case 3:
      transformV3M3Jni(paramArrayOfFloat, paramInt2, paramInt3, paramMatrix3.val, paramInt4);
      return;
    case 2:
    }
    transformV2M3Jni(paramArrayOfFloat, paramInt2, paramInt3, paramMatrix3.val, paramInt4);
  }

  public static void transform(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, Matrix4 paramMatrix4)
  {
    transform(paramArrayOfFloat, paramInt1, paramInt2, paramInt3, paramMatrix4, 0);
  }

  public static void transform(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, Matrix4 paramMatrix4, int paramInt4)
  {
    switch (paramInt1)
    {
    default:
      throw new IllegalArgumentException();
    case 4:
      transformV4M4Jni(paramArrayOfFloat, paramInt2, paramInt3, paramMatrix4.val, paramInt4);
      return;
    case 3:
      transformV3M4Jni(paramArrayOfFloat, paramInt2, paramInt3, paramMatrix4.val, paramInt4);
      return;
    case 2:
    }
    transformV2M4Jni(paramArrayOfFloat, paramInt2, paramInt3, paramMatrix4.val, paramInt4);
  }

  private static native void transformV2M3Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3);

  private static native void transformV2M3Jni(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3);

  private static native void transformV2M4Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3);

  private static native void transformV2M4Jni(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3);

  private static native void transformV3M3Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3);

  private static native void transformV3M3Jni(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3);

  private static native void transformV3M4Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3);

  private static native void transformV3M4Jni(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3);

  private static native void transformV4M4Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3);

  private static native void transformV4M4Jni(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.BufferUtils
 * JD-Core Version:    0.6.0
 */