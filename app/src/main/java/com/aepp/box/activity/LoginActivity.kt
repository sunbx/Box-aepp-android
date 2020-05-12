package com.aepp.box.activity

import android.content.Context
import android.content.Intent
import com.aepp.box.BoxApp
import com.aepp.box.R
import com.google.android.material.button.MaterialButton
import com.pep.core.libbase.EasyBaseActivity
import com.pep.core.uibase.EasyToast

class LoginActivity : EasyBaseActivity() {

    private lateinit var mbLogin: MaterialButton


    override fun initData() {
        mbLogin.setOnClickListener {
           AeasyLoginActivity.invoke(LoginActivity@this)
        }
    }

    override fun initView() {
        mbLogin = findViewById(R.id.mb_login) as MaterialButton

    }

    override fun onResume() {
        super.onResume()
        if (BoxApp.instance().isLogin()){
            AensActivity.invoke(LoginActivity@this)
            finish()
        }
    }

    companion object {
        operator fun invoke(context: Context) {
            val intent = Intent(context , LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun isSwipeBack(): Boolean {
        return false
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }
}
