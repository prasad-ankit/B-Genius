package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public abstract class MeshSpawnShapeValue extends SpawnShapeValue
{
  protected Mesh mesh;
  protected Model model;

  public MeshSpawnShapeValue()
  {
  }

  public MeshSpawnShapeValue(MeshSpawnShapeValue paramMeshSpawnShapeValue)
  {
    super(paramMeshSpawnShapeValue);
  }

  public void load(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    ResourceData.SaveData localSaveData = paramResourceData.getSaveData();
    AssetDescriptor localAssetDescriptor = localSaveData.loadAsset();
    if (localAssetDescriptor != null)
    {
      Model localModel = (Model)paramAssetManager.get(localAssetDescriptor);
      setMesh((Mesh)localModel.meshes.get(((Integer)localSaveData.load("index")).intValue()), localModel);
    }
  }

  public void load(ParticleValue paramParticleValue)
  {
    super.load(paramParticleValue);
    MeshSpawnShapeValue localMeshSpawnShapeValue = (MeshSpawnShapeValue)paramParticleValue;
    setMesh(localMeshSpawnShapeValue.mesh, localMeshSpawnShapeValue.model);
  }

  public void save(AssetManager paramAssetManager, ResourceData paramResourceData)
  {
    if (this.model != null)
    {
      ResourceData.SaveData localSaveData = paramResourceData.createSaveData();
      localSaveData.saveAsset(paramAssetManager.getAssetFileName(this.model), Model.class);
      localSaveData.save("index", Integer.valueOf(this.model.meshes.indexOf(this.mesh, true)));
    }
  }

  public void setMesh(Mesh paramMesh)
  {
    setMesh(paramMesh, null);
  }

  public void setMesh(Mesh paramMesh, Model paramModel)
  {
    if (paramMesh.getVertexAttribute(1) == null)
      throw new GdxRuntimeException("Mesh vertices must have Usage.Position");
    this.model = paramModel;
    this.mesh = paramMesh;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.MeshSpawnShapeValue
 * JD-Core Version:    0.6.0
 */