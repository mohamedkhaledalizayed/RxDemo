package com.example.rxdemo

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.Layout
import android.text.Layout.DIR_RIGHT_TO_LEFT
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import javax.inject.Inject
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DefaultItemAnimator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
//https://app.zeplin.io/project/5d4a72af5c75754ba2abf98c/screen/5d4a79491eca0c128be8ae8c
    //https://mindorks.com/android/store/Animations/hanks-zyh/smallbang
    //https://www.androidhive.info/2018/01/android-app-ui-designing-using-sketch-app-and-zeplin/
    @Inject
    lateinit var servicesApi: ServicesApi

    lateinit var mAdapter: ItemAdapter

    private var mShimmerViewContainer: ShimmerFrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShimmerViewContainer = findViewById(R.id.shimmer_view_container)

        //        StateExecuterKt.setState(recyclerView, StatesConstants.LOADING_STATE);
//        mShimmerViewContainer?.layoutDirection = View.LAYOUT_DIRECTION_LTR
//        recyclerView = findViewById(R.id.recycler_view)
        mAdapter = ItemAdapter(this)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recycler_view.layoutManager = mLayoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = mAdapter

        Handler().postDelayed(Runnable {
            ddd()
        },5000)

    }

    fun ddd(){
        mShimmerViewContainer?.stopShimmerAnimation()
        mShimmerViewContainer?.visibility = View.GONE
        recycler_view.visibility = View.VISIBLE
    }

    public override fun onResume() {
        super.onResume()
        recycler_view.visibility = View.GONE
        mShimmerViewContainer?.startShimmerAnimation()
    }

}
