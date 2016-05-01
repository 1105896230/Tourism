package tourism.fmt.com.tourism.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tourism.fmt.com.tourism.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransLateFragmen extends Fragment {


    public TransLateFragmen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_trans_late, container, false);

        return inflate;
    }


}
