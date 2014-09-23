package com.nigazuki.campusfestival.app;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TimetableActivity extends ActionBarActivity {

    // アダプターを定義
    SectionsPagerAdapter mSectionsPagerAdapter;

    // ViewPagerを定義
    public ViewPager mViewPager;

    int x;
    int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        setTitle("タイムテーブル");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        // FragmentPagerAdapterを継承したクラスのアダプターを作成
        mSectionsPagerAdapter = new SectionsPagerAdapter(
                getSupportFragmentManager());

        // ViewPagerにSectionPagerAdapterをセット
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        SharedPreferences pref = getSharedPreferences( "DisplaySize", MODE_PRIVATE );

        x = pref.getInt( "user_width", 0) - 40;
        y = pref.getInt( "user_height", 0);

        LinearLayout layout_Top = (LinearLayout) findViewById(R.id.TimeTable_Top_Area);
        layout_Top.setLayoutParams(createPram_Top());

        LinearLayout layout_Button = (LinearLayout)findViewById(R.id.Timetable_Button_Area);
        layout_Button.setLayoutParams(createPram_Button());

        LinearLayout layout_Scroll = (LinearLayout)findViewById(R.id.Timetable_Scroll_Area);
        layout_Scroll.setLayoutParams(createPram_Scroll());

        LinearLayout layout_Bottom = (LinearLayout)findViewById(R.id.TimeTable_Bottom_Area);
        layout_Bottom.setLayoutParams(createPram_Bottom());

//        LinearLayout layout_schedule = (LinearLayout)findViewById(R.id.timetable_schedule);
//        layout_schedule.setLayoutParams(createPram_Schedule());

        LinearLayout layout = (LinearLayout) findViewById(R.id.timetabele_time);
        for (int i = 9; i < 19; i++) {
            View view = getLayoutInflater().inflate(R.layout.timetable_time, null);
            LinearLayout layout_height = (LinearLayout) view.findViewById(R.id.TimeTable_timeheight);
            layout_height.setLayoutParams(createParam_Time());
            TextView timeTxt = (TextView) view.findViewById(R.id.Timetable_timetxt);
            timeTxt.setText(i + ":00");
            layout.addView(view);
        }

        {//ボタン管理
            Button first_gymBtn = (Button) findViewById(R.id.first_gym);
            first_gymBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimetableActivity.this.mViewPager.setCurrentItem(0);
                }
            });
            Button second_gymBtn = (Button) findViewById(R.id.second_gym);
            second_gymBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimetableActivity.this.mViewPager.setCurrentItem(1);
                }
            });
            Button cafeBtn = (Button) findViewById(R.id.cafe);
            cafeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimetableActivity.this.mViewPager.setCurrentItem(2);
                }
            });
        }

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Button first_gymbtn = (Button)findViewById(R.id.first_gym);
                Button second_gymbtn = (Button)findViewById(R.id.second_gym);
                Button cafebtn = (Button)findViewById(R.id.cafe);
                switch(position){
                    case 0:
                        first_gymbtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.on));
                        second_gymbtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.off));
                        cafebtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.off));
                        return;
                    case 1:
                        first_gymbtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.off));
                        second_gymbtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.on));
                        cafebtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.off));
                        return;
                    case 2:
                        first_gymbtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.off));
                        second_gymbtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.off));
                        cafebtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.on));
                        return;
                }

            }
        });
    }

    private LinearLayout.LayoutParams createPram_Schedule() {
        int w = x - 200;
        int h = (int)(y / 1.295);
        return new LinearLayout.LayoutParams(w, h);    }

    private LinearLayout.LayoutParams createPram_Bottom() {
        int w = x;
        int h = (int)(y / 12.38);
        return new LinearLayout.LayoutParams(w, h);
    }

    private LinearLayout.LayoutParams createPram_Scroll() {
        int w = x;
        int h = (int)(y / 1.295);
        return new LinearLayout.LayoutParams(w, h);
    }

    private LinearLayout.LayoutParams createPram_Button(){
        int w = x;
        int h = (int)(y / 8.7);
        return new LinearLayout.LayoutParams(w, h);
    }

    private LinearLayout.LayoutParams createPram_Top() {
        int w = x;
        int h = (int)(y / 15.1);
        return new LinearLayout.LayoutParams(w, h);
    }

    private LinearLayout.LayoutParams createParam_Time(){
        int w = x / 6;
        int h = (int)(y / 4.765);
        return new LinearLayout.LayoutParams(w, h);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Timetable_tab1Activity fragment0 = new Timetable_tab1Activity();
                    return fragment0;
                case 1:
                    Timetable_tab2Activity fragment1 = new Timetable_tab2Activity();
                    return fragment1;
                case 2:
                    Timetable_tab3Activity fragment2 = new Timetable_tab3Activity();
                    return fragment2;
                default:
                    return null;
            }
        }

        //タブの数
        @Override
        public int getCount() {
            return 3;
        }

        //タブのタイトル
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "第一体育館";
                case 1:
                    return "第二体育館";
                case 2:
                    return "その他";
            }
            return null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = true;
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                result = super.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
