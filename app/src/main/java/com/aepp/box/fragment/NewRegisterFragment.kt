package com.aepp.box.fragment

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

import com.aepp.box.R
import com.aepp.box.activity.NamesDetailActivity
import com.aepp.box.api.BoxService
import com.aepp.box.models.NamesModel
import com.aepp.box.utils.Utils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.button.MaterialButton
import com.pep.core.libbase.EasyBaseFragment
import com.pep.core.libnet.EasyHttpManager
import com.pep.core.uibase.EasyLoadingView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.fragment_auctions.*
import kotlinx.android.synthetic.main.item_aens.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList
import java.util.HashMap

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.box.fragment
 * @class describe
 * @time 2020-04-26 15:56
 * @change
 * @chang time
 * @class describe
 */
class NewRegisterFragment : EasyBaseFragment() {
    private var lvList: ListView? = null
    private lateinit var smartRefreshLayout: SmartRefreshLayout
    private var page = 1
    private val aucionsAdapter = AucionsAdapter()
    private var names = ArrayList<NamesModel.DataBean>()

    override fun initView() {
        lvList = findViewById(R.id.lv_list) as ListView
        smartRefreshLayout = findViewById(R.id.smart_view) as SmartRefreshLayout
    }

    override fun initData() {
        loadingview.setLoadingType(EasyLoadingView.EASY_LOADING_LOAD)
        loadingview.setOnErrorListener {
            netData()
        }
        netData()
        lvList!!.adapter = aucionsAdapter
        smartRefreshLayout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                netData()
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                page = 1
                netData()
            }

        })
        lvList!!.setOnItemClickListener { parent , view , position , id ->
            activity?.let { NamesDetailActivity.invoke(it , names[position].name) }
        }

    }

    private fun netData() {
        val params = HashMap<String , Any>()
        params["page"] = page
        EasyHttpManager.getInstance().getService(BoxService::class.java).apiNamePrice(params).enqueue(object : Callback<NamesModel?> {
            override fun onResponse(call: Call<NamesModel?> , response: Response<NamesModel?>) {
                loadingview.setLoadingType(EasyLoadingView.EASY_LOADING_FINISH)
                smartRefreshLayout.finishRefresh()
                smartRefreshLayout.finishLoadMore()
                if (page == 1) {
                    names.clear()
                }
                val arrayList = response.body()?.data as ArrayList<NamesModel.DataBean>
                if (arrayList.size > 0) {
                    names.addAll(arrayList)
                    aucionsAdapter.notifyDataSetChanged()
                    page++
                } else {
                    smartRefreshLayout.finishRefreshWithNoMoreData()
                }


            }

            override fun onFailure(call: Call<NamesModel?> , t: Throwable) {
                loadingview.setLoadingType(EasyLoadingView.EASY_LOADING_ERROR)
                smartRefreshLayout.finishRefresh()
                smartRefreshLayout.finishLoadMore()
            }
        })

    }

    internal inner class AucionsAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return names.size
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int , convertView: View? , parent: ViewGroup?): View {
            var holder: ViewHolder
            var view: View

            if (convertView == null) {
                view = View.inflate(
                    context , R.layout.item_aens , null
                )
                holder = ViewHolder(view)
                view.tag = holder
            } else {
                view = convertView
                holder = view.tag as ViewHolder
            }

            holder.tvName.text = names[position].name
            holder.tvAddress.text = "address : " + names[position].owner.substring(0 , 3) + "****" + names[position].owner.substring(names[position].owner.length - 4 , names[position].owner.length)
            holder.tvTime.text = Utils.formatDateTime((names[position].end_height - names[position].current_height) * 3 * 60)
            holder.tvAe.text = names[position].current_price.substring(0 , names[position].current_price.length - 3) + " AE"



            return view
        }
    }

    class ViewHolder(var view: View) {
        var tvName: TextView = view.findViewById(R.id.tv_name)
        var tvTime: TextView = view.findViewById(R.id.tv_time)
        var tvAddress: TextView = view.findViewById(R.id.tv_address)
        var tvAe: TextView = view.findViewById(R.id.tv_ae)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_auctions
    }
}