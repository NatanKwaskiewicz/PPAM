package com.example.a04_02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentInfo extends Fragment {


    private TextView textViewEmail2, textViewImie2, textViewNazwisko2;
    private String email, imie, nazwisko;

    public FragmentInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentInfo newInstance(String param1, String param2) {
        FragmentInfo fragment = new FragmentInfo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                email = bundle.getString("email");
                imie = bundle.getString("imie");
                nazwisko = bundle.getString("nazwisko");

                setInfoWhenReady();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        textViewEmail2 = view.findViewById(R.id.textViewEmail2);
        textViewImie2 = view.findViewById(R.id.textViewImie2);
        textViewNazwisko2 = view.findViewById(R.id.textViewNazwisko2);

        setInfoWhenReady();

        return view;
    }

    private void setInfoWhenReady() {
        if (email == null || imie == null || nazwisko == null) return;

        textViewEmail2.setText(email);
        textViewImie2.setText(imie);
        textViewNazwisko2.setText(nazwisko);
    }
}