package com.demo.sampleapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.demo.sampleapp.R
import com.demo.sampleapp.databinding.FragmentHomeBinding
import com.demo.sampleapp.ui.vm.SharedViewModel
import timber.log.Timber

class HomeFragment : Fragment(), ListAdapter.ICallback {

    private var contextAttach: Context? = null

    private var _bindingHome: FragmentHomeBinding? = null

    private var postsAdapter: ListAdapter? = null

    private val sharedViewModel by viewModels<SharedViewModel>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contextAttach = context
        Timber.i("onAttach")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindingHome = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return _bindingHome?.root
    }

    override fun onResume() {
        super.onResume()
        initUI()
    }

    private fun initUI() {
        with(_bindingHome) {
            this?.let {
                postsAdapter = ListAdapter(activity as Context, this@HomeFragment)
                recyclerViewBPFrag.layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                recyclerViewBPFrag.adapter = postsAdapter

                callHomeAPI()

                //includeRetryList.buttonRetry.setOnClickListener(this@BlogFragment)
            }
        }
    }

    private fun callHomeAPI() {
        //sharedViewModel.
    }

    override fun selection(position: Int) {
        TODO("Not yet implemented")
    }
}