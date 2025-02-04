package fr.delcey.mvctomvvm.data.pokemon

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenerationIi(

    @field:SerializedName("gold")
    val gold: Gold? = null,

    @field:SerializedName("crystal")
    val crystal: Crystal? = null,

    @field:SerializedName("silver")
    val silver: Silver? = null
) : Parcelable