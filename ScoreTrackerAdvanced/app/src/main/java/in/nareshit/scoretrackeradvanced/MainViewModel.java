package in.nareshit.scoretrackeradvanced;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

// Step 1: Create a class and extend ViewModel class.
// Note: If you want to store data and manage UI for one Activity or Fragment, you need to create
// a ViewModel class like this and associate it to the Activity or Fragment.
public class MainViewModel extends ViewModel {

    MutableLiveData<Integer> count;
    public MainViewModel() {
        count = new MutableLiveData<>();
        count.setValue(0);
        Log.i("MAIN","MainViewModel is Created!");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("MAIN","MainViewModel is Destroyed!");
    }

    public void increment(){
        count.setValue(count.getValue() + 1);
    }

    public void decrement(){
        count.setValue(count.getValue() - 1);
    }
}
