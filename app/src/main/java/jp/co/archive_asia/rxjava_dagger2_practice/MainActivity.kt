package jp.co.archive_asia.rxjava_dagger2_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import jp.co.archive_asia.rxjava_dagger2_practice.databinding.ItemCountryBinding
import jp.co.archive_asia.rxjava_dagger2_practice.view.CountryListAdapter
import jp.co.archive_asia.rxjava_dagger2_practice.viewModel.ListViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}