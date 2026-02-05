package com.example.a04_02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLogin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLogin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private Button btn;
    private EditText editTextEmail, editTextImie, editTextNazwisko;

    private Bundle loginInfo;

    static boolean checkRegex(String regex, String string) {
        return string.matches(regex);
    }

    public FragmentLogin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Login.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLogin newInstance(String param1, String param2) {
        FragmentLogin fragment = new FragmentLogin();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__login, container, false);
        btn = view.findViewById(R.id.button);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextImie = view.findViewById(R.id.editTextImie);
        editTextNazwisko = view.findViewById(R.id.editTextNazwisko);
        loginInfo = new Bundle();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String imie = editTextImie.getText().toString();
                String nazwisko = editTextNazwisko.getText().toString();
                if(!checkRegex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email))
                {
                    Toast.makeText(getContext(), "Niepoprawny adres email", Toast.LENGTH_SHORT).show();
                }
                else if(imie.isBlank() || nazwisko.isBlank()) {
                    Toast.makeText(getContext(), "Wypełnij puste pola", Toast.LENGTH_SHORT).show();
                }
                else {
                    loginInfo.putString("email", email);
                    loginInfo.putString("imie", imie);
                    loginInfo.putString("nazwisko", nazwisko);
                    getParentFragmentManager().setFragmentResult("requestKey", loginInfo);
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.main, new FragmentInfo());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        return view;
    }
}