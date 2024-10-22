package com.example.demonavigationcomponetinandroid

import android.os.Parcel
import android.os.Parcelable

data class User(val id: String, val name: String, val address: String): Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString().toString(), parcel.readString().toString(), parcel.readString().toString()
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
