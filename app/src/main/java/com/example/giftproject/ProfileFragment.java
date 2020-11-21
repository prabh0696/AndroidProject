package com.example.giftproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giftproject.models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView userEmail;
    TextView userName;
    TextView userPhone;
    TextView userAddress;
    TextView userCity;
    TextView userProvince;
    TextView userCountry;
    TextView userPostal;
    Button update_btn;
    String userID;
    FirebaseFirestore db;
    FirebaseAuth fAuth;
    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View hid= inflater.inflate(R.layout.fragment_profile, container, false);
         userEmail=hid.findViewById(R.id.Email);
         userName=hid.findViewById(R.id.Name);
         userPhone=hid.findViewById(R.id.phone);
         userAddress=hid.findViewById(R.id.apt);
         userCity=hid.findViewById(R.id.city);
         userProvince=hid.findViewById(R.id.province);
         userCountry=hid.findViewById(R.id.country);
         userPostal=hid.findViewById(R.id.postal);
         update_btn=hid.findViewById(R.id.updateBtn);
         db= FirebaseFirestore.getInstance();
         fAuth = FirebaseAuth.getInstance();

         getData();

         update_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                         new HomeFragment()).commit();
             }
         });

        return hid;
    }
    public void getData(){
        userID=fAuth.getCurrentUser().getUid();
        db.collection("Users").document(userID).collection("UserData")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String email = "";
                            String Name="";
                            String phone="";
                            String address="";
                            String city="";
                            String province="";
                            String country="";
                            String postal="";

                            for (DocumentSnapshot document : task.getResult()) {
                                Users user = document.toObject(Users.class);
                                email = user.getuEmail();
                                Name = user.getuName();
                                phone = user.getuPhone();
                                address = user.getuAddress();
                                city = user.getuCity();
                                province = user.getuProvince();
                                country = user.getuCountry();
                                postal = user.getuPostal();
                            }
                            userEmail.setText(email);
                            userName.setText(Name);
                            userPhone.setText(phone);
                            userAddress.setText(address);
                            userCity.setText(city);
                            userProvince.setText(province);
                            userCountry.setText(country);
                            userPostal.setText(postal);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Error:"+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}