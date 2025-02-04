package fr.delcey.mvctomvvm.data.pokemon

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VersionGroupDetailsItem(

    @field:SerializedName("level_learned_at")
    val levelLearnedAt: Int? = null,

    @field:SerializedName("version_group")
    val versionGroup: VersionGroup? = null,

    @field:SerializedName("move_learn_method")
    val moveLearnMethod: MoveLearnMethod? = null
) : Parcelable