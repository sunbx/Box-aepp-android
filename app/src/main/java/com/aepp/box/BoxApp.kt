package com.aepp.box

import android.R
import android.app.Application
import android.content.Context
import android.text.TextUtils
import com.pep.core.libnet.EasyHttpManager
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator
import com.scwang.smartrefresh.layout.api.RefreshFooter
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.tencent.mmkv.MMKV


/**
 * @name Box-aepp-Android
 * @class name：com.aepp.box
 * @class describe
 * @author sunbaixin QQ:283122529
 * @time 2020-04-11 17:36
 * @change
 * @chang time
 * @class describe
 */
class BoxApp : Application() {
    //static 代码段可以防止内存泄露

    var mmkv: MMKV? = null
    private var sign: String? = null
    private var address: String? = null

    companion object {
        private var instance: BoxApp? = null
        fun instance() = instance!!
    }


    override fun onCreate() {
        super.onCreate()
        instance = this

        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context , layout ->
            layout.setPrimaryColorsId(R.color.white , R.color.black) //全局设置主题颜色
            ClassicsHeader.REFRESH_HEADER_REFRESHING = "Is Refreshing"
            ClassicsHeader.REFRESH_HEADER_PULLING = "Drop down to refresh"
            ClassicsHeader.REFRESH_HEADER_LOADING = "Loading.."
            ClassicsHeader.REFRESH_HEADER_RELEASE = "Release immediate refresh"
            ClassicsHeader.REFRESH_HEADER_FINISH = "Refresh to complete"
            ClassicsHeader.REFRESH_HEADER_FAILED = "Refresh the failure"
            ClassicsHeader.REFRESH_HEADER_UPDATE = "'Last update' M-d HH:mm"

            ClassicsFooter.REFRESH_FOOTER_RELEASE = "Release immediate loading"
            ClassicsFooter.REFRESH_FOOTER_REFRESHING = "Refreshing..."
            ClassicsFooter.REFRESH_FOOTER_LOADING = "Loading..."
            ClassicsFooter.REFRESH_FOOTER_FINISH = "Refresh to complete"
            ClassicsFooter.REFRESH_FOOTER_FAILED = "Refresh the failure"
            ClassicsFooter.REFRESH_FOOTER_NOTHING = "No more data"

            ClassicsHeader(context)

            //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        }

        SmartRefreshLayout.setDefaultRefreshFooterCreator(object : DefaultRefreshFooterCreator {

            override fun createRefreshFooter(context: Context , layout: RefreshLayout): RefreshFooter {
                return ClassicsFooter(context).setDrawableSize(20f)
            }
        })
        EasyHttpManager.getInstance().init("http://box.aeasy.io//")
        MMKV.initialize(this)
        mmkv = MMKV.defaultMMKV()
    }

    fun isLogin(): Boolean {
        if (sign == null || TextUtils.isEmpty(sign)) {
            getAccount()
        }
        return sign != null && !TextUtils.isEmpty(sign)
    }


    fun getAccount(): String? {
        if (BoxApp@ this.sign != null) {
            return BoxApp@ this.sign
        }
        val sign = mmkv?.getString("AEASY_LOGIN_INFO_SIGN" , "")
        if (!TextUtils.isEmpty(sign)) {
            BoxApp@ this.sign = sign
            return sign
        }
        return null
    }

    fun setAccount(sign: String) {
        BoxApp@ this.sign = sign
        mmkv?.putString("AEASY_LOGIN_INFO_SIGN" , sign)
    }

    fun getAddress(): String? {
        if (BoxApp@ this.address != null) {
            return BoxApp@ this.address
        }
        val address = mmkv?.getString("AEASY_LOGIN_INFO_ADDRESS" , "")
        if (!TextUtils.isEmpty(address)) {
            BoxApp@ this.address = address
            return address
        }
        return null
    }

    fun setAddress(address: String) {
        BoxApp@ this.address = address
        mmkv?.putString("AEASY_LOGIN_INFO_ADDRESS" , address)
    }
}