package com.aepp.box.activity

import android.content.Context
import android.content.Intent
import android.webkit.WebView
import android.widget.LinearLayout
import android.widget.TextView
import com.aepp.box.R
import com.pep.core.libbase.EasyBaseActivity

/**
 * @name Box-aepp-Android
 * @class name：com.aepp.box
 * @class describe
 * @author sunbaixin QQ:283122529
 * @time 2020-04-20 18:51
 * @change
 * @chang time
 * @class describe
 */
class WebActivity : EasyBaseActivity() {
    private lateinit var llBack: LinearLayout
    private lateinit var tvTitle: TextView
    private lateinit var webView: WebView
    private lateinit var id: String
    override fun initData() {

        var title = intent.getStringExtra("title")
        id = intent.getStringExtra("id")
        tvTitle.text = title
        webView.loadUrl("http://192.168.0.104/article/info?article_id=$id")
        llBack.setOnClickListener { finish() }
    }

    companion object {
        operator fun invoke(context: Context, title: String, id: String) {
            val intent = Intent(context, WebActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("id", id)
            context.startActivity(intent)
        }
    }

    override fun initView() {


        llBack = findViewById(R.id.ll_back) as LinearLayout
        tvTitle = findViewById(R.id.tv_title) as TextView
        webView = findViewById(R.id.web_view) as WebView


    }

    override fun getLayoutId(): Int {
        return R.layout.activity_web
    }
}