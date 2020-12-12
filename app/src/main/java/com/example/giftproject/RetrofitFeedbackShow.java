package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;

import com.example.giftproject.api_interfaces.MyJsonApi;
import com.example.giftproject.models.UserFeedback;

import java.util.List;

public class RetrofitFeedbackShow extends AppCompatActivity {

    TextView textviewresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_feedback_show);

        textviewresult=findViewById(R.id.text_view_result);

        getFeedbacks();
    }

    public void getFeedbacks(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyJsonApi myJsonApi=retrofit.create(MyJsonApi.class);
        Call<List<UserFeedback>> call=myJsonApi.getFeedbacks();

        call.enqueue(new Callback<List<UserFeedback>>() {
            @Override
            public void onResponse(Call<List<UserFeedback>> call, Response<List<UserFeedback>> response) {
                if(!response.isSuccessful()){
                    textviewresult.setText("Code: "+response.code());
                }

                List<UserFeedback> userFeedbacks=response.body();
                for(UserFeedback userFeedback:userFeedbacks){
                    String content="";
                    content += "ID: "+userFeedback.getId()+"\n";
                    content += "Name: "+userFeedback.getName()+"\n";
                    content += "Email: "+userFeedback.getEmail()+"\n";
                    content += "Phone: "+userFeedback.getPhone()+"\n";
                    content += "Product Type: "+userFeedback.getProducttype()+"\n";
                    content += "Feedback: "+userFeedback.getUserfeedback()+"\n\n";

                    textviewresult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<UserFeedback>> call, Throwable t) {
                textviewresult.setText(t.getMessage());
            }
        });
    }
}