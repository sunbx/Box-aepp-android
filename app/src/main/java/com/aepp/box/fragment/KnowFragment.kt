package com.aepp.box.fragment

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.aepp.box.R
import com.aepp.box.activity.AensActivity
import com.aepp.box.activity.WebActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.pep.core.libbase.EasyBaseFragment
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class KnowFragment : EasyBaseFragment() {

    private lateinit var lvList: ListView
    private lateinit var smartRefreshLayout: SmartRefreshLayout
    private lateinit var headerView: View
    private lateinit var tvUsdt: TextView
    private lateinit var tvHeiht: TextView
    private lateinit var llAens: LinearLayout
    private var page = 1
//
//    private var articles =
//        ArrayList<ArticleModel.DataBean>()

//    private lateinit var newadapter: NewsAdapter

    override fun initData() {
        netData()
    }

    private fun netData() {
//        AeasyApp.apiBaseData(object : Callback<BaseDataModels> {
//            override fun onResponse(
//                call: Call<BaseDataModels>,
//                response: Response<BaseDataModels>
//            ) {
//                tvUsdt.setText(response.body()?.data?.price_usdt)
//                tvHeiht.setText(response.body()?.data?.block_height)
//            }
//
//            override fun onFailure(call: Call<BaseDataModels>, t: Throwable) {
//
//            }
//        })
//
//        AeasyApp.apiArticleList(object : Callback<ArticleModel> {
//            override fun onResponse(call: Call<ArticleModel>, response: Response<ArticleModel>) {
//                smartRefreshLayout.finishRefresh()
//                smartRefreshLayout.finishLoadMore()
////                if (page == 1) {
////                    articles.clear()
////                }
////                val arrayList = response.body()?.data as ArrayList<ArticleModel.DataBean>
////                if (arrayList.size > 0) {
////                    articles.addAll(arrayList)
////                    newadapter.notifyDataSetChanged()
////                    page++
////                } else {
////                    smartRefreshLayout.finishRefreshWithNoMoreData()
////                }
//
//            }
//
//            override fun onFailure(call: Call<ArticleModel>, t: Throwable) {
//
//            }
//        }, page.toString())
    }

    override fun initView() {
//        headerView = View.inflate(
//            activity,
//            R.layout.layout_header_know, null
//        )
//        tvUsdt = headerView.findViewById(R.id.tv_usdt) as TextView
//        tvHeiht = headerView.findViewById(R.id.tv_height) as TextView
//        llAens = headerView.findViewById(R.id.ll_aens) as LinearLayout
//        lvList = findViewById(R.id.lv_list) as ListView
//        smartRefreshLayout = findViewById(R.id.smart_view) as SmartRefreshLayout
//        newadapter =
//            NewsAdapter(activity, articles)
//        lvList.adapter = newadapter
//        lvList.addHeaderView(headerView)
//
//
//        llAens.setOnClickListener {
//            activity?.let { it1 -> AensActivity.invoke(it1) }
//        }
//        lvList.setOnItemClickListener { parent, view, position, id ->
//            if (position != 0) {
//                activity?.let {
//                    WebActivity.invoke(
//                        it,
//                        articles[position - 1].title,
//                        articles[position - 1].article_id.toString()
//                    )
//                }
//            }
//        }
//
//        smartRefreshLayout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
//            override fun onLoadMore(refreshLayout: RefreshLayout) {
//                netData()
//            }
//
//            override fun onRefresh(refreshLayout: RefreshLayout) {
//                page = 1
//                netData()
//            }
//
//        })
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_know
    }


//    class NewsAdapter(
//        var context: FragmentActivity?,
//        var articles: ArrayList<ArticleModel.DataBean>
//    ) :
//        BaseAdapter() {
//
//        @SuppressLint("ViewHolder")
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//            var holder: TestViewHolder
//            var view: View
//
//            if (convertView == null) {
//                view = View.inflate(context, R.layout.item_news, null)
//                holder = TestViewHolder(view)
//                view.tag = holder
//            } else {
//                view = convertView
//                holder = view.tag as TestViewHolder
//            }
//
//            //直接.text来设置文本。类似与java中的 holder.textView.setText("文本");
//            holder.tvTitle.text = articles[position].title
//            //设置图片圆角角度
//            val roundedCorners = RoundedCorners(16)
//            val options = RequestOptions.bitmapTransform(roundedCorners)
//            context?.let {
//                Glide.with(it).load(articles[position].image).apply(options).centerCrop()
//                    .into(holder.ivImage)
//            }
//            return view
//        }
//
//        class TestViewHolder(var view: View) {
//            var tvTitle: TextView = view.findViewById(R.id.tv_title)
//            var ivImage: ImageView = view.findViewById(R.id.iv_image)
//        }
//
//
//        override fun getItem(position: Int): Any {
//            return articles[position]
//        }
//
//        override fun getItemId(position: Int): Long {
//            return articles[position].id.toLong()
//        }
//
//        override fun getCount(): Int {
//            return articles.size
//        }
//
//    }


}
