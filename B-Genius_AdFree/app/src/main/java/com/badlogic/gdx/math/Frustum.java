package com.badlogic.gdx.math;

import com.badlogic.gdx.math.collision.BoundingBox;

public class Frustum
{
  protected static final Vector3[] clipSpacePlanePoints;
  protected static final float[] clipSpacePlanePointsArray;
  private static final Vector3 tmpV;
  public final Vector3[] planePoints;
  protected final float[] planePointsArray;
  public final Plane[] planes = new Plane[6];

  static
  {
    int i = 0;
    Vector3[] arrayOfVector31 = new Vector3[8];
    arrayOfVector31[0] = new Vector3(-1.0F, -1.0F, -1.0F);
    arrayOfVector31[1] = new Vector3(1.0F, -1.0F, -1.0F);
    arrayOfVector31[2] = new Vector3(1.0F, 1.0F, -1.0F);
    arrayOfVector31[3] = new Vector3(-1.0F, 1.0F, -1.0F);
    arrayOfVector31[4] = new Vector3(-1.0F, -1.0F, 1.0F);
    arrayOfVector31[5] = new Vector3(1.0F, -1.0F, 1.0F);
    arrayOfVector31[6] = new Vector3(1.0F, 1.0F, 1.0F);
    arrayOfVector31[7] = new Vector3(-1.0F, 1.0F, 1.0F);
    clipSpacePlanePoints = arrayOfVector31;
    clipSpacePlanePointsArray = new float[24];
    Vector3[] arrayOfVector32 = clipSpacePlanePoints;
    int j = arrayOfVector32.length;
    int k = 0;
    while (i < j)
    {
      Vector3 localVector3 = arrayOfVector32[i];
      float[] arrayOfFloat1 = clipSpacePlanePointsArray;
      int m = k + 1;
      arrayOfFloat1[k] = localVector3.x;
      float[] arrayOfFloat2 = clipSpacePlanePointsArray;
      int n = m + 1;
      arrayOfFloat2[m] = localVector3.y;
      float[] arrayOfFloat3 = clipSpacePlanePointsArray;
      k = n + 1;
      arrayOfFloat3[n] = localVector3.z;
      i++;
    }
    tmpV = new Vector3();
  }

  public Frustum()
  {
    Vector3[] arrayOfVector3 = new Vector3[8];
    arrayOfVector3[0] = new Vector3();
    arrayOfVector3[1] = new Vector3();
    arrayOfVector3[2] = new Vector3();
    arrayOfVector3[3] = new Vector3();
    arrayOfVector3[4] = new Vector3();
    arrayOfVector3[5] = new Vector3();
    arrayOfVector3[6] = new Vector3();
    arrayOfVector3[7] = new Vector3();
    this.planePoints = arrayOfVector3;
    this.planePointsArray = new float[24];
    while (i < 6)
    {
      this.planes[i] = new Plane(new Vector3(), 0.0F);
      i++;
    }
  }

  public boolean boundsInFrustum(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    int i = this.planes.length;
    for (int j = 0; j < i; j++)
      if ((this.planes[j].testPoint(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 - paramFloat6) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramFloat1 + paramFloat4, paramFloat2 - paramFloat5, paramFloat3 + paramFloat6) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramFloat1 + paramFloat4, paramFloat2 - paramFloat5, paramFloat3 - paramFloat6) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramFloat1 - paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramFloat1 - paramFloat4, paramFloat2 + paramFloat5, paramFloat3 - paramFloat6) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramFloat1 - paramFloat4, paramFloat2 - paramFloat5, paramFloat3 + paramFloat6) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramFloat1 - paramFloat4, paramFloat2 - paramFloat5, paramFloat3 - paramFloat6) == Plane.PlaneSide.Back))
        return false;
    return true;
  }

  public boolean boundsInFrustum(Vector3 paramVector31, Vector3 paramVector32)
  {
    return boundsInFrustum(paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x / 2.0F, paramVector32.y / 2.0F, paramVector32.z / 2.0F);
  }

  public boolean boundsInFrustum(BoundingBox paramBoundingBox)
  {
    int i = this.planes.length;
    for (int j = 0; j < i; j++)
      if ((this.planes[j].testPoint(paramBoundingBox.getCorner000(tmpV)) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramBoundingBox.getCorner001(tmpV)) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramBoundingBox.getCorner010(tmpV)) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramBoundingBox.getCorner011(tmpV)) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramBoundingBox.getCorner100(tmpV)) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramBoundingBox.getCorner101(tmpV)) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramBoundingBox.getCorner110(tmpV)) == Plane.PlaneSide.Back) && (this.planes[j].testPoint(paramBoundingBox.getCorner111(tmpV)) == Plane.PlaneSide.Back))
        return false;
    return true;
  }

  public boolean pointInFrustum(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    for (int i = 0; i < this.planes.length; i++)
      if (this.planes[i].testPoint(paramFloat1, paramFloat2, paramFloat3) == Plane.PlaneSide.Back)
        return false;
    return true;
  }

  public boolean pointInFrustum(Vector3 paramVector3)
  {
    for (int i = 0; i < this.planes.length; i++)
      if (this.planes[i].testPoint(paramVector3) == Plane.PlaneSide.Back)
        return false;
    return true;
  }

  public boolean sphereInFrustum(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    for (int i = 0; i < 6; i++)
      if (paramFloat1 * this.planes[i].normal.x + paramFloat2 * this.planes[i].normal.y + paramFloat3 * this.planes[i].normal.z < -paramFloat4 - this.planes[i].d)
        return false;
    return true;
  }

  public boolean sphereInFrustum(Vector3 paramVector3, float paramFloat)
  {
    for (int i = 0; i < 6; i++)
      if (this.planes[i].normal.x * paramVector3.x + this.planes[i].normal.y * paramVector3.y + this.planes[i].normal.z * paramVector3.z < -paramFloat - this.planes[i].d)
        return false;
    return true;
  }

  public boolean sphereInFrustumWithoutNearFar(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    for (int i = 2; i < 6; i++)
      if (paramFloat1 * this.planes[i].normal.x + paramFloat2 * this.planes[i].normal.y + paramFloat3 * this.planes[i].normal.z < -paramFloat4 - this.planes[i].d)
        return false;
    return true;
  }

  public boolean sphereInFrustumWithoutNearFar(Vector3 paramVector3, float paramFloat)
  {
    for (int i = 2; i < 6; i++)
      if (this.planes[i].normal.x * paramVector3.x + this.planes[i].normal.y * paramVector3.y + this.planes[i].normal.z * paramVector3.z < -paramFloat - this.planes[i].d)
        return false;
    return true;
  }

  public void update(Matrix4 paramMatrix4)
  {
    System.arraycopy(clipSpacePlanePointsArray, 0, this.planePointsArray, 0, clipSpacePlanePointsArray.length);
    Matrix4.prj(paramMatrix4.val, this.planePointsArray, 0, 8, 3);
    int i = 0;
    for (int j = 0; j < 8; j++)
    {
      Vector3 localVector3 = this.planePoints[j];
      float[] arrayOfFloat1 = this.planePointsArray;
      int k = i + 1;
      localVector3.x = arrayOfFloat1[i];
      float[] arrayOfFloat2 = this.planePointsArray;
      int m = k + 1;
      localVector3.y = arrayOfFloat2[k];
      float[] arrayOfFloat3 = this.planePointsArray;
      i = m + 1;
      localVector3.z = arrayOfFloat3[m];
    }
    this.planes[0].set(this.planePoints[1], this.planePoints[0], this.planePoints[2]);
    this.planes[1].set(this.planePoints[4], this.planePoints[5], this.planePoints[7]);
    this.planes[2].set(this.planePoints[0], this.planePoints[4], this.planePoints[3]);
    this.planes[3].set(this.planePoints[5], this.planePoints[1], this.planePoints[6]);
    this.planes[4].set(this.planePoints[2], this.planePoints[3], this.planePoints[6]);
    this.planes[5].set(this.planePoints[4], this.planePoints[0], this.planePoints[1]);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Frustum
 * JD-Core Version:    0.6.0
 */