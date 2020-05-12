package com.aepp.box.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import com.aepp.box.BoxApp
import com.aepp.box.R
import com.aepp.box.api.BoxService
import com.aepp.box.fragment.MnemonicDialogFragment
import com.aepp.box.models.AeasyLoginModel
import com.google.android.material.button.MaterialButton
import com.pep.core.libbase.EasyBaseActivity
import com.pep.core.libnet.EasyHttpManager
import com.pep.core.uibase.EasyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.aeasy_sdk_library.activity
 * @class describe
 * @time 2020-04-11 16:25
 * @change
 * @chang time
 * @class describe
 */
class AeasyLoginActivity : EasyBaseActivity() {
    private var etMnemonic: EditText? = null
    private var mbRecover: MaterialButton? = null
    private var mbCreate: MaterialButton? = null
    private var rlClose: RelativeLayout? = null
    override fun initView() {
        etMnemonic = findViewById(R.id.et_mnemonic) as EditText
        mbRecover = findViewById(R.id.mb_recover) as MaterialButton
        mbCreate = findViewById(R.id.mb_create) as MaterialButton
        rlClose = findViewById(R.id.rl_close) as RelativeLayout
    }

    override fun initData() {}
    override fun initListener() {
        super.initListener()
        mbRecover!!.setOnClickListener(View.OnClickListener {
            val mnemonic = etMnemonic!!.text.toString().trim { it <= ' ' }
            if (TextUtils.isEmpty(mnemonic)) {
                EasyToast.show(mContext , "mnemonic is nil")
                return@OnClickListener
            }
            showProgress()
            val params = HashMap<String , Any>()
            params["mnemonic"] = mnemonic

            EasyHttpManager.getInstance().getService(BoxService::class.java).login(params).enqueue(object : Callback<AeasyLoginModel?> {
                override fun onResponse(call: Call<AeasyLoginModel?> , response: Response<AeasyLoginModel?>) {
                    if (response.body()?.code == 200) {
                        response.body()?.data?.signingKey?.let { it1 -> BoxApp.instance().setAccount(it1) }
                        response.body()?.data?.address?.let { it1 -> BoxApp.instance().setAddress(it1) }
                        finish()
                    } else {
                        EasyToast.show(mContext , response.body()?.msg)
                    }
                    dismissProgress()
                }

                override fun onFailure(call: Call<AeasyLoginModel?> , t: Throwable) {
                    dismissProgress()
                }
            })
        })
        mbCreate!!.setOnClickListener {
            showProgress()
            val params = HashMap<String , Any>()
            EasyHttpManager.getInstance().getService(BoxService::class.java).register(params).enqueue(object : Callback<AeasyLoginModel?> {
                override fun onResponse(call: Call<AeasyLoginModel?> , response: Response<AeasyLoginModel?>) {
                    if (response.body()?.code == 200) {
                        val mnemonicDialogFragment = MnemonicDialogFragment()
                        val bundle = Bundle()
                        bundle.putString("mnemonic" , response.body()!!.data.mnemonic)
                        mnemonicDialogFragment.setArguments(bundle)
                        mnemonicDialogFragment.show(
                            supportFragmentManager , "MnemonicDialogFragment"
                        )
                        mnemonicDialogFragment.setOnDismissListener {
                            response.body()?.data?.signingKey?.let { it1 -> BoxApp.instance().setAccount(it1) }
                            response.body()?.data?.address?.let { it1 -> BoxApp.instance().setAddress(it1) }
                            finish()
                        }
                    } else {
                        EasyToast.show(mContext , response.body()?.msg)
                    }
                    dismissProgress()
                }

                override fun onFailure(call: Call<AeasyLoginModel?> , t: Throwable) {
                    dismissProgress()
                }
            })

        }
        rlClose!!.setOnClickListener { finish() }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_oauth
    }

    companion object {
        operator fun invoke(context: Context) {
            val intent = Intent(context , AeasyLoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}