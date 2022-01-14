package fr.delcey.mvctomvvm.ui.list

data class PokemonViewState(
    val id :  String,
    val name : String,
    val imageUrl : String,
    val typeName1 : String,
    val isType1Visible: Boolean,
    val typeName2 : String,
    val isType2Visible: Boolean,
)
