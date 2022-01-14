package fr.delcey.mvctomvvm.ui.list

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.delcey.mvctomvvm.R
import fr.delcey.mvctomvvm.data.pokemon.PokemonResponse

class PokemonAdapter(private val listener: (String) -> Unit) :
    ListAdapter<PokemonViewState, PokemonAdapter.PokemonViewHolder>(PokemonDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PokemonViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.pokemon_itemview, parent, false)
    )

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val pokemonCardView = itemView.findViewById<CardView>(R.id.pokemon_itemview_cardview)
        private val pokemonImageView = itemView.findViewById<ImageView>(R.id.pokemon_itemview_iv)
        private val pokemonNameTextView = itemView.findViewById<TextView>(R.id.pokemon_itemview_tv_name)
        private val pokemonType1TextView = itemView.findViewById<TextView>(R.id.pokemon_itemview_tv_type1)
        private val pokemonType2TextView = itemView.findViewById<TextView>(R.id.pokemon_itemview_tv_type2)

        fun bind(pokemonViewState: PokemonViewState, listener: (String) -> Unit) {
            Glide.with(pokemonImageView)
                .load(pokemonViewState.imageUrl)
                .fitCenter()
                .into(pokemonImageView)

            pokemonNameTextView.text = pokemonViewState.name

            pokemonType1TextView.isVisible = pokemonViewState.isType1Visible
            pokemonType1TextView.text = pokemonViewState.typeName1
            //pokemonType1TextView.backgroundTintList = ColorStateList.valueOf(firstType.getColorInt())

            pokemonType2TextView.isVisible = pokemonViewState.isType2Visible
            pokemonType2TextView.text = pokemonViewState.typeName2
            //pokemonType2TextView.backgroundTintList = ColorStateList.valueOf(secondType.getColorInt())

            pokemonCardView.setOnClickListener { listener(pokemonViewState.id) }
        }
    }

    private class PokemonDiffCallback : DiffUtil.ItemCallback<PokemonViewState>() {
        override fun areItemsTheSame(oldItem: PokemonViewState, newItem: PokemonViewState) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PokemonViewState, newItem: PokemonViewState) = oldItem == newItem
    }
}