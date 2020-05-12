package com.aepp.box.activity

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.aepp.box.fragment.KnowFragment
import com.aepp.box.R
import com.pep.core.libbase.EasyBaseActivity

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.box
 * @class describe
 * @time 2020-04-20 11:19
 * @change
 * @chang time
 * @class describe
 */
class HomeActivity : EasyBaseActivity() {

    private lateinit var viewPager: ViewPager

    private lateinit var knowFragment: Fragment

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
        viewPager = findViewById(R.id.viewPager) as ViewPager

    }

    override fun initData() {
        knowFragment = KnowFragment()

        viewPager.adapter = HomeAdapter(supportFragmentManager, 0)
    }

    companion object {
        operator fun invoke(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    inner class HomeAdapter(fm: FragmentManager, behavior: Int) :
        FragmentPagerAdapter(fm, behavior) {


        override fun getItem(position: Int): Fragment {
            return knowFragment
        }

        override fun getCount(): Int {
            return 1
        }
    }
}