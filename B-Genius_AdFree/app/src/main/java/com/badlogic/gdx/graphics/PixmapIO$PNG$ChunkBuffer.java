package com.badlogic.gdx.graphics;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

class PixmapIO$PNG$ChunkBuffer extends DataOutputStream
{
  final ByteArrayOutputStream buffer;
  final CRC32 crc;

  PixmapIO$PNG$ChunkBuffer(int paramInt)
  {
    this(new ByteArrayOutputStream(paramInt), new CRC32());
  }

  private PixmapIO$PNG$ChunkBuffer(ByteArrayOutputStream paramByteArrayOutputStream, CRC32 paramCRC32)
  {
    super(new CheckedOutputStream(paramByteArrayOutputStream, paramCRC32));
    this.buffer = paramByteArrayOutputStream;
    this.crc = paramCRC32;
  }

  public void endChunk(DataOutputStream paramDataOutputStream)
  {
    flush();
    paramDataOutputStream.writeInt(-4 + this.buffer.size());
    this.buffer.writeTo(paramDataOutputStream);
    paramDataOutputStream.writeInt((int)this.crc.getValue());
    this.buffer.reset();
    this.crc.reset();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.PixmapIO.PNG.ChunkBuffer
 * JD-Core Version:    0.6.0
 */