package jp.co.archive_asia.rxjava_dagger2_practice.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import jp.co.archive_asia.rxjava_dagger2_practice.R
import jp.co.archive_asia.rxjava_dagger2_practice.databinding.FragmentCountryBinding
import jp.co.archive_asia.rxjava_dagger2_practice.viewModel.ListViewModel

class CountryFragment : Fragment() {

    private lateinit var binding: FragmentCountryBinding
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setListAdapter()
    }

    private fun setListAdapter() {

        val countriesAdapter = CountryListAdapter(arrayListOf())
        binding.countriesList.adapter = countriesAdapter

        viewModel.countries.observe(viewLifecycleOwner) { countries ->
            countries?.let { countriesAdapter.updateCountries(it) }
        }

        viewModel.countryLoadError.observe(viewLifecycleOwner) { isError ->
            isError?.let { binding.listError.visibility = if (it) View.VISIBLE else View.GONE }
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            isLoading?.let {
                binding.loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.listError.visibility = View.GONE
                    binding.countriesList.visibility = View.GONE
                }
            }


        }
    }

}