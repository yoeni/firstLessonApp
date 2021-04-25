package online.sezeryildirim.firstlessonapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class secondFragment extends Fragment {
    public secondFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_second, container, false);
        TextView tv=rootView.findViewById(R.id.secondFragmentTextview);
        Button visibleButton=rootView.findViewById(R.id.fragmentSecondVisibleButton);
        Button goneButton=rootView.findViewById(R.id.fragmentSecondGoneButton);
        Button invisibleButton=rootView.findViewById(R.id.fragmentSeconInvisibleButton);

        visibleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.VISIBLE);
            }
        });

        goneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.GONE);
            }
        });

        invisibleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.INVISIBLE);
            }
        });
        return rootView;
    }
}