package com.example.clown.first;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.clown.first.Adapter.FragmentAdapter;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialVariable();
        tabSetup();
    }

    private void tabSetup() {
        final TabLayout.Tab tabJabatan = tabLayout.newTab();
        tabJabatan.setText("Jabatan");
        tabLayout.addTab(tabJabatan);

        final TabLayout.Tab tabDokumen = tabLayout.newTab();
        tabDokumen.setText("Dokumen");
        tabLayout.addTab(tabDokumen);

        final TabLayout.Tab tabPegawai= tabLayout.newTab();
        tabPegawai.setText("Pegawai");
        tabLayout.addTab(tabPegawai);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager = (ViewPager) findViewById(R.id.viewPagerMain);
        viewPager.setAdapter(fragmentAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tabJabatan.select();
                        break;
                    case 1:
                        tabDokumen.select();
                        break;
                    case 2:
                        tabPegawai.select();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initialVariable() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutJS);
    }


}
