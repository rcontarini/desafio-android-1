package contarini.com.desafio_android.ui.home

import contarini.com.desafio_android.data.models.BaseRepositoriesResponse
import contarini.com.desafio_android.data.models.RepositoriesResponse
import contarini.com.desafio_android.ui.base.BasePresenter
import contarini.com.desafio_android.ui.base.BaseView


interface HomeContract {

    interface View : BaseView<Presenter> {
        fun displayError(msg: String?)
        fun displayIncidents(incidents : BaseRepositoriesResponse)
        fun loadIncidentsDetail(item : RepositoriesResponse)
        fun showLoading(loading : Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun getIncidents(page : Int)
        fun onClickItem(item : RepositoriesResponse)
        fun setIncidents(incidents : BaseRepositoriesResponse)
        fun setError(error : Throwable)
    }

    interface Model {
        fun loadIncidents(page : Int)
    }
}