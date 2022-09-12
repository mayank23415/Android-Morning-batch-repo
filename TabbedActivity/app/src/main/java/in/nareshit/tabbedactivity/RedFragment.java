package in.nareshit.tabbedactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RedFragment extends Fragment {

    EditText num1,num2;
    Button btn;
    public RedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_red, container, false);

        num1 = v.findViewById(R.id.first_num);
        num2 = v.findViewById(R.id.second_num);
        btn = v.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());
                Toast.makeText(getContext(), ""+(n1+n2), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}