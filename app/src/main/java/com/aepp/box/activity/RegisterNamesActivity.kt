package com.aepp.box.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.aepp.box.BoxApp
import com.aepp.box.R
import com.aepp.box.api.BoxService
import com.aepp.box.models.TxModel
import com.aepp.box.models.UserInfoModel
import com.afollestad.materialdialogs.MaterialDialog
import com.pep.core.libbase.EasyBaseActivity
import com.pep.core.libnet.EasyHttpManager
import com.pep.core.uibase.EasyToast
import kotlinx.android.synthetic.main.activity_names_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * @name Box-aepp-Android
 * @class name：com.aepp.box.activity
 * @class describe
 * @author sunbaixin QQ:283122529
 * @time 2020-05-08 22:19
 * @change
 * @chang time
 * @class describe
 */
class RegisterNamesActivity : EasyBaseActivity() {
    override fun initData() {

        et_name.setText(intent.getStringExtra("NAME"))

        et_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence? , start: Int , count: Int , after: Int) {
            }

            override fun onTextChanged(s: CharSequence? , start: Int , before: Int , count: Int) {
                //                et_name.setText(s.toString() + ".chain")
            }

        })
        et_name.setSelection(et_name.length())
        val params = HashMap<String , Any>()
        params["signingKey"] = BoxApp.instance().getAccount().toString()
        EasyHttpManager.getInstance().getService(BoxService::class.java).apiUserInfo(params).enqueue(object : Callback<UserInfoModel?> {


            override fun onFailure(call: Call<UserInfoModel?> , t: Throwable) {
                EasyToast.show(BoxApp.instance() , t.message)
            }

            override fun onResponse(call: Call<UserInfoModel?> , response: Response<UserInfoModel?>) {
                if (response.body() != null) {
                    if (response.body()!!.code == 200) {
                        tv_balance.setText(response.body()!!.data.balance)

                    } else {
                        EasyToast.show(BoxApp.instance() , response.body()!!.msg)
                    }
                } else {
                    EasyToast.show(BoxApp.instance() , response.message())
                }
            }
        })

        //        val createQRCodeBitmap = Utils.createQRCodeBitmap("123123" , 800 , 800 , "UTF-8" , "H" , "1" , Color.BLACK , Color.WHITE , null , 0F)

    }

    override fun initView() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_names_register
    }


    companion object {
        operator fun invoke(context: Context) {
            val intent = Intent(context , RegisterNamesActivity::class.java)
            intent.putExtra("NAME" , "")
            context.startActivity(intent)
        }

        operator fun invoke(context: Context , name: String) {
            val intent = Intent(context , RegisterNamesActivity::class.java)
            intent.putExtra("NAME" , name)
            context.startActivity(intent)
        }
    }

    fun back(view: View) {
        finish()
    }

    fun register(view: View) {
        showProgress()
        val params = HashMap<String , Any>()
        params["name"] = et_name.text.toString() + ".chain"
        params["signingKey"] = BoxApp.instance().getAccount().toString()
        EasyHttpManager.getInstance().getService(BoxService::class.java).apiNameAdd(params).enqueue(object : Callback<TxModel?> {


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
                            message(text = "If the broadcast is sent successfully, it does not mean that the registration is successful. Please wait for the synchronization block to be completed within 10 minutes. Please refresh the list to view it later.")
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
                        EasyToast.show(BoxApp.instance() , response.body()!!.msg)
                    }
                } else {
                    EasyToast.show(BoxApp.instance() , response.message())
                }
            }
        })
    }

    fun copy(view: View) {

        //获取剪贴板管理器：

        //获取剪贴板管理器：
        val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        // 创建普通字符型ClipData
        // 创建普通字符型ClipData
        val mClipData = ClipData.newPlainText("Label" , BoxApp.instance().getAddress())
        // 将ClipData内容放到系统剪贴板里。
        // 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData)
        EasyToast.show(BoxApp.instance() , "Copy Sucess")
    }


}