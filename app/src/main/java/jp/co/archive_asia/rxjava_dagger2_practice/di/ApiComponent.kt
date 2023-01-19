package jp.co.archive_asia.rxjava_dagger2_practice.di

import dagger.Component
import jp.co.archive_asia.rxjava_dagger2_practice.model.CountriesService
import jp.co.archive_asia.rxjava_dagger2_practice.viewModel.ListViewModel

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)
}