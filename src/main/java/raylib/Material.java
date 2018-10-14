/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package raylib;

import static raylib.RaylibConstants.NATIVE_FLOAT_SIZE;
import static raylib.RaylibConstants.NATIVE_INT_SIZE;

public class Material {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Material(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Material obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        RaylibJNI.delete_Material(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setShader(Shader value) {
    RaylibJNI.Material_shader_set(swigCPtr, this, Shader.getCPtr(value), value);
  }

  public Shader getShader() {
    long cPtr = RaylibJNI.Material_shader_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Shader(cPtr, false);
  }

  public void setMaps(MaterialMap value) {
    RaylibJNI.Material_maps_set(swigCPtr, this, MaterialMap.getCPtr(value), value);
  }

  public MaterialMap getMaps() {
    long cPtr = RaylibJNI.Material_maps_get(swigCPtr, this);
    return (cPtr == 0) ? null : new MaterialMap(cPtr, false);
  }

  public MaterialMap getMap(int i) {
    // i * sizeof(MaterialMap)
    // TODO: Add this as a directive in SWIG.  sizeof(MaterialMap) = sizeof(texture) + sizeof(Color) + sizeof(float)
    if(i < 0 || i > RaylibJNI.MAX_MATERIAL_MAPS_get()) {
      return null;
    }
    long cPtr = RaylibJNI.Material_maps_get(swigCPtr + (i*((5*NATIVE_INT_SIZE)+NATIVE_INT_SIZE+NATIVE_FLOAT_SIZE)), this);
    return (cPtr == 0) ? null : new MaterialMap(cPtr, false);
  }

  public void setMap(int i, MaterialMap value) {
    if(i < 0 || i > RaylibJNI.MAX_MATERIAL_MAPS_get()) {
      throw new IndexOutOfBoundsException("Index " + i + " was out of bounds for the range 0 to " + RaylibJNI.MAX_MATERIAL_MAPS_get());
    }
    long cPtr = RaylibJNI.Material_maps_get(swigCPtr + (i*((5*4)+4+4)), this);
    RaylibJNI.Material_maps_set(cPtr, this, MaterialMap.getCPtr(value), value);
  }

  public void setParams(SWIGTYPE_p_float value) {
    RaylibJNI.Material_params_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getParams() {
    long cPtr = RaylibJNI.Material_params_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public Material() {
    this(RaylibJNI.new_Material(), true);
  }

  public MaterialMap getDiffuseMap() {
    return getMap(MAP_DIFFUSE);
  }

  public void setDiffuseMap(MaterialMap map) {
    setMap(MAP_DIFFUSE, map);
  }

  public static final int MAP_DIFFUSE = 0;
  public static final int MAP_ALBEDO = 0;       // MAP_DIFFUSE
  public static final int MAP_SPECULAR = 1;
  public static final int MAP_METALNESS = 1;       // MAP_SPECULAR
  public static final int MAP_NORMAL = 2;
  public static final int MAP_ROUGHNESS = 3;
  public static final int MAP_OCCLUSION = 4;
  public static final int MAP_EMISSION = 5;
  public static final int MAP_HEIGHT = 6;
  public static final int MAP_CUBEMAP = 7; // NOTE: Uses GL_TEXTURE_CUBE_MAP
  public static final int MAP_IRRADIANCE = 8;          // NOTE: Uses GL_TEXTURE_CUBE_MAP
  public static final int MAP_PREFILTER = 9;           // NOTE: Uses GL_TEXTURE_CUBE_MAP
  public static final int MAP_BRDF = 10;

}
