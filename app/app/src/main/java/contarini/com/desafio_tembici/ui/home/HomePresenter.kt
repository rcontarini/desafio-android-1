package contarini.com.desafio_tembici.ui.home

import contarini.com.desafio_tembici.data.models.BaseRepositoriesResponse
import contarini.com.desafio_tembici.data.models.RepositoriesResponse

class HomePresenter : HomeContract.Presenter {

    private var mView: HomeContract.View? = null
    private var model: HomeContract.Model = HomeModel(this)

    override fun detachView() {
        mView = null
    }

    override fun attachView(mvpView: HomeContract.View?) {
        mView = mvpView
    }

    override fun onClickItem(item: RepositoriesResponse) {
        mView?.loadIncidentsDetail(item)
    }

    override fun getIncidents(page : Int) {
        model.loadIncidents(page)
    }

    override fun setIncidents(incidents : BaseRepositoriesResponse) {
        mView?.displayIncidents(incidents)
        mView?.showLoading(false)
    }

    override fun setError(error: Throwable) {
        mView?.showLoading(false)
        mView?.displayError(error.message)
    }

}