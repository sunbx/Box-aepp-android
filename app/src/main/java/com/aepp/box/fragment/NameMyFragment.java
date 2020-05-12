package com.aepp.box.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.aepp.box.R;
import com.pep.core.libbase.EasyBaseFragment;

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.box.fragment
 * @class describe
 * @time 2020-04-26 18:11
 * @change
 * @chang time
 * @class describe
 */
public class NameMyFragment extends EasyBaseFragment {
    private TextView tvTab1;
    private TextView tvTab2;
    private ViewPager vpView;
    private MyAuctionsFragment auctionsFragment;
    private MyOverdueFragment overdueFragment;
    private NameMyAdapter nameMyAdapter;

    @Override
    public void initView() {

        tvTab1 = (TextView) findViewById(R.id.tv_tab1);
        tvTab2 = (TextView) findViewById(R.id.tv_tab2);
        vpView = (ViewPager) findViewById(R.id.vp_view);
    }

    @Override
    public void initData() {
        auctionsFragment = new MyAuctionsFragment();
        overdueFragment = new MyOverdueFragment();
        nameMyAdapter = new NameMyAdapter(getChildFragmentManager(), 0);
        vpView.setAdapter(nameMyAdapter);
        vpView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    tvTab1.setBackgroundResource(R.drawable.ic_bg_e51363_20);
                    tvTab2.setBackgroundResource(R.drawable.ic_bg_f4f4f4_20);

                    tvTab1.setTextColor(Color.parseColor("#FFFFFF"));
                    tvTab2.setTextColor(Color.parseColor("#000000"));
                } else {
                    tvTab1.setBackgroundResource(R.drawable.ic_bg_f4f4f4_20);
                    tvTab2.setBackgroundResource(R.drawable.ic_bg_e51363_20);

                    tvTab1.setTextColor(Color.parseColor("#000000"));
                    tvTab2.setTextColor(Color.parseColor("#FFFFFF"));

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tvTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpView.setCurrentItem(0);
            }
        });
        tvTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpView.setCurrentItem(1);
            }
        });
    }

    public class NameMyAdapter extends FragmentPagerAdapter {

        public NameMyAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return auctionsFragment;
            } else {
                return overdueFragment;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_names_my;
    }
}
