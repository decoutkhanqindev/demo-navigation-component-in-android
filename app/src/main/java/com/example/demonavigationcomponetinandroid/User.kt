package com.example.demonavigationcomponetinandroid

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep

// to prevent your Parcelable, Serializable, and Enum class names from being obfuscated as
// part of the minification process.
// two ways:
// Use @Keep annotations.
// Use keepnames rules.
@Keep
data class User(val id: String, val name: String, val address: String) : Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString()!!, parcel.readString()!!, parcel.readString()!!
  )
  
  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(id)
    parcel.writeString(name)
    parcel.writeString(address)
  }
  
  override fun describeContents(): Int {
    return 0
  }
  
  companion object CREATOR : Parcelable.Creator<User> {
    override fun createFromParcel(parcel: Parcel): User {
      return User(parcel)
    }
    
    override fun newArray(size: Int): Array<User?> {
      return arrayOfNulls(size)
    }
  }
}
