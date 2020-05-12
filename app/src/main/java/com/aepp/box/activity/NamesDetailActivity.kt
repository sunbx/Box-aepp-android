package com.aepp.box.activity

import android.content.Context
import android.content.Intent
import android.view.View
import com.aepp.box.BoxApp
import com.aepp.box.R
import com.aepp.box.api.BoxService
import com.aepp.box.models.NameInfoModel
import com.aepp.box.models.TxModel
import com.afollestad.materialdialogs.MaterialDialog
import com.pep.core.libbase.EasyBaseActivity
import com.pep.core.libnet.EasyHttpManager
import com.pep.core.uibase.EasyLoadingView
import com.pep.core.uibase.EasyToast
import kotlinx.android.synthetic.main.activity_names_detail.*
import kotlinx.android.synthetic.main.activity_names_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

/**
 * @name Box-aepp-Android
 * @class name：com.aepp.box.activity
 * @class describe
 * @author sunbaixin QQ:283122529
 * @time 2020-05-09 14:04
 * @change
 * @chang time
 * @class describe
 */
class NamesDetailActivity : EasyBaseActivity() {
    override fun initData() {
        loadingview.setLoadingType(EasyLoadingView.EASY_LOADING_LOAD)
        val name = intent.getStringExtra("NAME")
        val params = HashMap<String , Any>()
        params["signingKey"] = BoxApp.instance().getAccount().toString()
        params["name"] = name
        EasyHttpManager.getInstance().getService(BoxService::class.java).apiNameInfo(params).enqueue(object : Callback<NameInfoModel?> {


            override fun onFailure(call: Call<NameInfoModel?> , t: Throwable) {
                loadingview.setLoadingType(EasyLoadingView.EASY_LOADING_ERROR)
                EasyToast.show(BoxApp.instance() , t.message)
            }

            override fun onResponse(call: Call<NameInfoModel?> , response: Response<NameInfoModel?>) {
                loadingview.setLoadingType(EasyLoadingView.EASY_LOADING_FINISH)
                if (response.body() != null) {
                    if (response.body()!!.code == 200) {
                        tv_name.setText(response.body()!!.data.name)
                        tv_create_height.setText(response.body()!!.data.start_height.toString())
                        tv_end_height.setText(response.body()!!.data.end_height.toString())
                        tv_expires_height.setText(response.body()!!.data.over_height.toString())
                        tv_price.setText(response.body()!!.data.current_price + " AE")
                        tv_owner.setText(response.body()!!.data.owner)

                        if (response.body()!!.data.end_height > response.body()!!.data.current_height) {
                            mb_premium.visibility = View.VISIBLE
                        }else{
                            if (BoxApp.instance().getAddress() == response.body()!!.data.owner) {
                                mb_renewal.visibility = View.VISIBLE
                                mb_transfer.visibility = View.VISIBLE
                            }
                        }


                    } else {
                        EasyToast.show(BoxApp.instance() , response.body()!!.msg)
                    }
                } else {
                    EasyToast.show(BoxApp.instance() , response.message())
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()


    }

    override fun initView() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_names_detail
    }


    companion object {
        operator fun invoke(context: Context , name: String) {
            val intent = Intent(context , NamesDetailActivity::class.java)
            intent.putExtra("NAME" , name)
            context.startActivity(intent)
        }
    }

    fun transfer(view: View) {
        MaterialDialog(mContext).show {
            cancelable(false)
            cancelOnTouchOutside(false)
            title(text = "Hint")
            message(text ="In development, look forward to it")
            positiveButton(text = "ok") { dialog ->
            }
            negativeButton(text = "cancel") { dialog ->
            }
        }
    }
    fun premium(view: View) {
        RegisterNamesActivity.invoke(this,intent.getStringExtra("NAME").toString().split(".")[0])
    }
    fun renewal(view: View) {

        showProgress()
        val params = HashMap<String , Any>()
        params["name"] = intent.getStringExtra("NAME").toString()
        params["signingKey"] = BoxApp.instance().getAccount().toString()
        EasyHttpManager.getInstance().getService(BoxService::class.java).apiNameUpdate(params).enqueue(object : Callback<TxModel?> {


            override fun onFailure(call: Call<TxModel?> , t: Throwable) {
                EasyToast.show(BoxApp.instance() , t.message)
                dismissProgress()
            }

            override fun onResponse(call: Call<TxModel?> , response: Response<TxModel?>) {
                dismissProgress()
                if (response.body() != null) {
                    if (response.body()!!.code == 200) {
                        MaterialDialog(mContext).show {
                            cancelable(false)
                            cancelOnTouchOutside(false)
                            title(text = "Broadcast success")
                            message(text = "Please refresh the list after 5 minutes.")
                            positiveButton(text = "ok") { dialog ->
                                finish()
                            }
                            negativeButton(text = "cancel") { dialog ->
                            }
                        }

                    } else {
                        MaterialDialog(mContext).show {
                            cancelable(false)
                            cancelOnTouchOutside(false)
                            title(text = "Hint")
                            message(text = response.body()!!.msg)
                            positiveButton(text = "ok") { dialog ->
                            }
                            negativeButton(text = "cancel") { dialog ->
                            }
                        }
//                        EasyToast.show(BoxApp.instance() , response.body()!!.msg)
                    }
                } else {
                    EasyToast.show(BoxApp.instance() , response.message())
                }
            }
        })
    }
    fun back(view: View) {
        finish()
    }

}