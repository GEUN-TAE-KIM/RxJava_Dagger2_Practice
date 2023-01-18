package jp.co.archive_asia.rxjava_dagger2_practice.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.co.archive_asia.rxjava_dagger2_practice.databinding.ItemCountryBinding
import jp.co.archive_asia.rxjava_dagger2_practice.model.Country
import jp.co.archive_asia.rxjava_dagger2_practice.util.getProgressDrawable
import jp.co.archive_asia.rxjava_dagger2_practice.util.loadImage

class CountryListAdapter(var countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding =
            ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class CountryViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {



        fun bind(country: Country) {
            binding.data = country
            binding.executePendingBindings()
            binding.imageView.loadImage(country.flag)
        }
    }

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }
}