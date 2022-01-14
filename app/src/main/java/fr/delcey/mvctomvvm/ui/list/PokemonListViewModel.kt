package fr.delcey.mvctomvvm.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.delcey.mvctomvvm.data.PokemonRepository
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel(){

    private val executor = Executors.newFixedThreadPool(4)

    private val pokemonListMutableLiveData = MutableLiveData<List<PokemonViewState>>()

    fun getPokemonListLiveData() : MutableLiveData<List<PokemonViewState>> = pokemonListMutableLiveData

    init {
        pokemonListMutableLiveData.value = listOf(
            PokemonViewState(
                "1",
                "Bulbizarre",
                imageUrl = "https://www.pokepedia.fr/images/e/ef/Bulbizarre-RFVF.png",
                "Plante",
                true,
                "Posion",
                true)
        )
    }


}