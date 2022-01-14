package fr.delcey.mvctomvvm.ui.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import fr.delcey.mvctomvvm.R
import fr.delcey.mvctomvvm.data.PokemonRepository
import fr.delcey.mvctomvvm.data.pokemon.PokemonResponse
import fr.delcey.mvctomvvm.ui.detail.PokemonDetailActivity
import java.util.concurrent.Executors
import java.util.concurrent.Future
import javax.inject.Inject

@AndroidEntryPoint
class PokemonListActivity : AppCompatActivity() {

    private val viewModel by vie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.pokemon_activity)

        setSupportActionBar(findViewById(R.id.pokemons_toolbar))

        val  viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)

        val adapter = PokemonAdapter { id -> startActivity(PokemonDetailActivity.navigate(this, id)) }
        val recyclerView = findViewById<RecyclerView>(R.id.pokemons_recyclerview)
        recyclerView.adapter = adapter

        val searchTextInputEditText = findViewById<TextInputEditText>(R.id.pokemons_search_text_input_edit_text)
        // TODO Every single line of the remaining onCreate() function is critical but can't be tested !! :
        //  remove one line and the application will most likely compile, but will have a (hidden) bug
        //  Testing every behavior is very hard because the Activity is too coupled with the Android framework
        searchTextInputEditText.doAfterTextChanged {
            viewModel.onSearchChanged(it.toString())
            filterAndDisplayPokemons()
        }
    }
}