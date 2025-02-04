package fr.delcey.mvctomvvm.data.pokemon

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OmegarubyAlphasapphire(

    @field:SerializedName("front_shiny_female")
    val frontShinyFemale: String? = null,

    @field:SerializedName("front_default")
    val frontDefault: String? = null,

    @field:SerializedName("front_female")
    val frontFemale: String? = null,

    @field:SerializedName("front_shiny")
    val frontShiny: String? = null
) : Parcelable