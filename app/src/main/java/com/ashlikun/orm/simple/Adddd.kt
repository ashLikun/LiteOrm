package com.ashlikun.orm.simple

import android.os.Parcel
import android.os.Parcelable

data class Adddd(var aaa: String? = "") : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(aaa)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Adddd> {
        override fun createFromParcel(parcel: Parcel): Adddd {
            return Adddd(parcel)
        }

        override fun newArray(size: Int): Array<Adddd?> {
            return arrayOfNulls(size)
        }
    }


}