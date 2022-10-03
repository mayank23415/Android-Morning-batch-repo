package in.nareshit.scoretrackeradvanced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import in.nareshit.scoretrackeradvanced.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding  binding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        /*setContentView(R.layout.activity_main);*/

        mainViewModel = new ViewModelProvider(this)
                .get(MainViewModel.class);

        // Every Time system encounters onCreate() method, we need to display what ever the value that is there
        // on the viewmodels count variable.
        /*binding.result.setText(String.valueOf(mainViewModel.count));*/
        binding.result.setText(String.valueOf(mainViewModel.count.getValue()));
        binding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.increment();
               /* binding.result.setText(String.valueOf(mainViewModel.count));*/
            }
        });

        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.decrement();
                /*binding.result.setText(String.valueOf(mainViewModel.count));*/
            }
        });

        mainViewModel.count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.result.setText(String.valueOf(mainViewModel.count.getValue()));
            }
        });
    }
}