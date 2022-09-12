package in.nareshit.tabbedactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.viewpager);
        tl = findViewById(R.id.tabLayout);
        VPAdapter vpa = new VPAdapter(getSupportFragmentManager());
        vp.setAdapter(vpa);
        tl.setupWithViewPager(vp);
    }

    // We can use FragmentStateAdapter, FragmentStatePagerAdapter.

    class VPAdapter extends FragmentStatePagerAdapter{

        public VPAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        // This method returns the fragment based on the position
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new RedFragment();
                case 1:
                    return new GreenFragment();
                case 2:
                    return new BlueFragment();
            }
            return null;
        }

        // This returns the total number of fragments that are going to be hosted on the viewpager
        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "RED";
                case 1: return "GREEN";
                case 2: return "BLUE";
            }
            return null;
        }
    }

    // When we work with fragments there are Two components to work around
    // 1. FragmentManager
    // 2. FragmentTransaction
}