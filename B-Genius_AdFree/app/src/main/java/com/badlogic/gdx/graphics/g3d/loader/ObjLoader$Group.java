package com.badlogic.gdx.graphics.g3d.loader;

import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.utils.Array;

class ObjLoader$Group
{
  Array faces;
  boolean hasNorms;
  boolean hasUVs;
  Material mat;
  String materialName;
  final String name;
  int numFaces;

  ObjLoader$Group(ObjLoader paramObjLoader, String paramString)
  {
    this.name = paramString;
    this.faces = new Array(200);
    this.numFaces = 0;
    this.mat = new Material("");
    this.materialName = "default";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.loader.ObjLoader.Group
 * JD-Core Version:    0.6.0
 */