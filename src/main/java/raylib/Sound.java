/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package raylib;

public class Sound {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Sound(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Sound obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        RaylibJNI.delete_Sound(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setAudioBuffer(SWIGTYPE_p_void value) {
    RaylibJNI.Sound_audioBuffer_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getAudioBuffer() {
    long cPtr = RaylibJNI.Sound_audioBuffer_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setSource(long value) {
    RaylibJNI.Sound_source_set(swigCPtr, this, value);
  }

  public long getSource() {
    return RaylibJNI.Sound_source_get(swigCPtr, this);
  }

  public void setBuffer(long value) {
    RaylibJNI.Sound_buffer_set(swigCPtr, this, value);
  }

  public long getBuffer() {
    return RaylibJNI.Sound_buffer_get(swigCPtr, this);
  }

  public void setFormat(int value) {
    RaylibJNI.Sound_format_set(swigCPtr, this, value);
  }

  public int getFormat() {
    return RaylibJNI.Sound_format_get(swigCPtr, this);
  }

  public Sound() {
    this(RaylibJNI.new_Sound(), true);
  }

}
