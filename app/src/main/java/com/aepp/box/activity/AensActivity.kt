package com.aepp.box.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.aepp.box.BoxApp
import com.aepp.box.R
import com.aepp.box.fragment.AuctionsFragment
import com.aepp.box.fragment.NameMyFragment
import com.aepp.box.fragment.NewRegisterFragment
import com.aepp.box.fragment.OverdueFragment
import com.afollestad.materialdialogs.MaterialDialog
import com.pep.core.libbase.EasyBaseActivity
import kotlinx.android.synthetic.main.activity_aens.*


/**
 * @name Box-aepp-Android
 * @class name：com.aepp.box
 * @class describe
 * @author sunbaixin QQ:283122529
 * @time 2020-04-24 17:29
 * @change
 * @chang time
 * @class describe
 */
class AensActivity : EasyBaseActivity() {
    private lateinit var llBack: LinearLayout
    private lateinit var tvTitle: TextView
    private lateinit var vpView: ViewPager

    private lateinit var tvTab1: TextView
    private lateinit var viewTab1: View
    private lateinit var tvTab2: TextView
    private lateinit var viewTab2: View
    private lateinit var tvTab3: TextView
    private lateinit var viewTab3: View
    private lateinit var tvTab4: TextView
    private lateinit var viewTab4: View

    private lateinit var auctionsFragment: AuctionsFragment
    private lateinit var overdueFragment: OverdueFragment
    private lateinit var newRegisterFragment: NewRegisterFragment
    private lateinit var nameMyFragment: NameMyFragment

    override fun initData() {
        auctionsFragment = AuctionsFragment()
        overdueFragment = OverdueFragment()
        newRegisterFragment = NewRegisterFragment()
        nameMyFragment = NameMyFragment()
        vpView.adapter = AensAdapter(supportFragmentManager , 0)

        llBack.setOnClickListener {
            finish()
        }
        vpView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int , positionOffset: Float , positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                clearDefTab()
                if (position == 0) {
                    tvTab1.setTextSize(TypedValue.COMPLEX_UNIT_DIP , 18f)
                    tvTab1.setTextColor(Color.parseColor("#000000"))
                    viewTab1.visibility = View.VISIBLE
                } else if (position == 1) {
                    tvTab2.setTextSize(TypedValue.COMPLEX_UNIT_DIP , 18f)
                    tvTab2.setTextColor(Color.parseColor("#000000"))
                    viewTab2.visibility = View.VISIBLE
                } else if (position == 2) {
                    tvTab3.setTextSize(TypedValue.COMPLEX_UNIT_DIP , 18f)
                    tvTab3.setTextColor(Color.parseColor("#000000"))
                    viewTab3.visibility = View.VISIBLE
                } else if (position == 3) {
                    tvTab4.setTextSize(TypedValue.COMPLEX_UNIT_DIP , 18f)
                    tvTab4.setTextColor(Color.parseColor("#000000"))
                    viewTab4.visibility = View.VISIBLE
                }
            }

        })
        vpView.offscreenPageLimit = 4
        ll_right.setOnClickListener {
            MaterialDialog(this).show {
                cancelable(false)
                cancelOnTouchOutside(false)
                title(text = "Log out")
                message(text = "Would you like to log out?")
                positiveButton(text = "out") { dialog ->
                    BoxApp.instance().setAccount("")
                    LoginActivity.invoke(context)
                    finish()
                }
                negativeButton(text = "dimiss") { dialog ->
                }
            }
        }
    }

    override fun initView() {
        llBack = findViewById(R.id.ll_back) as LinearLayout
        tvTitle = findViewById(R.id.tv_title) as TextView
        vpView = findViewById(R.id.vp_view) as ViewPager


        tvTab1 = findViewById(R.id.tv_tab1) as TextView
        viewTab1 = findViewById(R.id.view_tab1)
        tvTab2 = findViewById(R.id.tv_tab2) as TextView
        viewTab2 = findViewById(R.id.view_tab2)
        tvTab3 = findViewById(R.id.tv_tab3) as TextView
        viewTab3 = findViewById(R.id.view_tab3)
        tvTab4 = findViewById(R.id.tv_tab4) as TextView
        viewTab4 = findViewById(R.id.view_tab4)
        vpView = findViewById(R.id.vp_view) as ViewPager

    }

    override fun isSwipeBack(): Boolean {
        return false
    }


    inner class AensAdapter(fm: FragmentManager , behavior: Int) : FragmentPagerAdapter(fm , behavior) {


        override fun getItem(position: Int): Fragment {
            if (position == 0) {
                return auctionsFragment
            } else if (position == 1) {
                return newRegisterFragment
            } else if (position == 2) {
                return overdueFragment
            } else if (position == 3) {
                return nameMyFragment
            }
            return auctionsFragment
        }

        override fun getCount(): Int {
            return 4
        }
    }

    private fun clearDefTab() {
        tvTab1.setTextSize(TypedValue.COMPLEX_UNIT_DIP , 15f)
        tvTab2.setTextSize(TypedValue.COMPLEX_UNIT_DIP , 15f)
        tvTab3.setTextSize(TypedValue.COMPLEX_UNIT_DIP , 15f)
        tvTab4.setTextSize(TypedValue.COMPLEX_UNIT_DIP , 15f)

        tvTab1.setTextColor(Color.parseColor("#666666"))
        tvTab2.setTextColor(Color.parseColor("#666666"))
        tvTab3.setTextColor(Color.parseColor("#666666"))
        tvTab4.setTextColor(Color.parseColor("#666666"))

        viewTab1.visibility = View.GONE
        viewTab2.visibility = View.GONE
        viewTab3.visibility = View.GONE
        viewTab4.visibility = View.GONE


    }

    override fun getLayoutId(): Int {
        return R.layout.activity_aens
    }

    companion object {
        operator fun invoke(context: Context) {
            val intent = Intent(context , AensActivity::class.java)
            context.startActivity(intent)
        }
    }

    fun tab1(view: View) {
        vpView.currentItem = 0
    }

    fun tab2(view: View) {
        vpView.currentItem = 1
    }

    fun tab3(view: View) {
        vpView.currentItem = 2
    }

    fun tab4(view: View) {
        vpView.currentItem = 3
    }

    fun nameRegister(view: View) {
        RegisterNamesActivity.invoke(context = this)
    }
}