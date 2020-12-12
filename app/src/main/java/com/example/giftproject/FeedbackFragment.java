package com.example.giftproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.giftproject.models.Feedbacks;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedbackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedbackFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText fEmail;
    EditText fName;
    EditText fPhone;
    EditText fProduct;
    EditText fQuery;
    Button submit_btn;
    String name;
    String email;
    String phone;
    String product;
    String query;
    FirebaseFirestore db;
    FirebaseAuth fAuth;

    public FeedbackFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedbackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedbackFragment newInstance(String param1, String param2) {
        FeedbackFragment fragment = new FeedbackFragment();
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
        View hid= inflater.inflate(R.layout.fragment_feedback, container, false);

        fEmail=hid.findViewById(R.id.Email);
        fName=hid.findViewById(R.id.Name);
        fPhone=hid.findViewById(R.id.phone);
        fProduct=hid.findViewById(R.id.product);
        fQuery=hid.findViewById(R.id.query);
        submit_btn=hid.findViewById(R.id.submitBtn);
        db= FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 email = fEmail.getText().toString().trim();
                 name=fName.getText().toString();
                 phone=fPhone.getText().toString();
                 product=fProduct.getText().toString();
                 query=fQuery.getText().toString();
                addData(email,name,phone,product,query);
            }
        });
        return hid;
    }
    public void addData(String fEmail,String fName,String fPhone,String fProduct,String fQuery){
        Feedbacks feedbacks=new Feedbacks(fEmail,fName,fPhone,fProduct,fQuery);
        db.collection("Feedbacks")
                .add(feedbacks)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                       // getFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                        Intent intent=new Intent(getActivity(),RetrofitFeedbackInsert.class);
                        intent.putExtra("fname",name);
                        intent.putExtra("femail",email);
                        intent.putExtra("fphone",phone);
                        intent.putExtra("fproduct",product);
                        intent.putExtra("ffeedback",query);
                        Toast.makeText(getActivity(), "Feedback Saved Successfully", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Error:"+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}