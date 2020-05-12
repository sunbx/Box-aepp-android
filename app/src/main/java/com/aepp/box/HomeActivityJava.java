package com.aepp.box;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.aepp.box.api.BoxService;
import com.aepp.box.fragment.KnowFragment;
import com.aepp.box.models.AeasyLoginModel;
import com.pep.core.libbase.EasyBaseActivity;
import com.pep.core.libnet.EasyHttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.box
 * @class describe
 * @time 2020-04-20 18:33
 * @change
 * @chang time
 * @class describe
 */
public class HomeActivityJava extends EasyBaseActivity {
    private ViewPager viewPager;
    private KnowFragment knowFragment;

    @Override
    public void initView() {

        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    @Override
    public void initData() {
        knowFragment = new KnowFragment();

//        ListView listView = new ListView();
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });

        EasyHttpManager.getInstance().getService(BoxService.class).register(null).enqueue(new Callback<AeasyLoginModel>() {
            @Override
            public void onResponse(Call<AeasyLoginModel> call, Response<AeasyLoginModel> response) {

            }

            @Override
            public void onFailure(Call<AeasyLoginModel> call, Throwable t) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    class HomeAdapter extends FragmentPagerAdapter{

        public HomeAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return knowFragment;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }
}
