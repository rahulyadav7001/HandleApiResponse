package com.example.handleapiresponse.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.handleapiresponse.R;
import com.example.handleapiresponse.model.RequestBody;
import com.example.handleapiresponse.model.ResponseObj;
import com.example.handleapiresponse.model.Vehicle;
import com.example.handleapiresponse.service.APIClient;
import com.example.handleapiresponse.service.APIInterface;
import com.example.handleapiresponse.utils.NetworkUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_eventList;
    private VehiclesRecyclerViewAdapter recyclerviewAdapter;
    private ArrayList<Vehicle> vehicleList;
    private APIInterface apiInterface;
    private ProgressDialog progressDoalog;
    private Button btn_getData;
    private TextView tv_vehicleCount;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_eventList = findViewById(R.id.rv_eventList);
        btn_getData = findViewById(R.id.btn_getData);
        tv_vehicleCount = findViewById(R.id.tv_vehicleCount);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage(getString(R.string.PleaseWait));
        progressDoalog.setCancelable(false);
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        recyclerviewAdapter = new VehiclesRecyclerViewAdapter( vehicleList,MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_eventList.setLayoutManager(layoutManager);
        rv_eventList.setAdapter(recyclerviewAdapter);

        btn_getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEventData();
            }
        });
    }

    private void getEventData() {
        if (NetworkUtility.isNetworkAvailable(MainActivity.this)) {
            progressDoalog.show();
            RequestBody requestBody = new RequestBody("get_vehicles", "kunal", "kunal");
            Map<String, String> params = new HashMap<String, String>();
            params.put("cmd", "get_vehicles");
            params.put("user", "kunal");
            params.put("pass", "kunal");
            Call<ResponseObj> call = apiInterface.getInfromationFromServer(requestBody);
            call.enqueue(new Callback<ResponseObj>() {
                @Override
                public void onResponse(Call<ResponseObj> call, Response<ResponseObj> response) {
                    Log.d("url ", "" + call.request().url().toString());
                    Log.d("Service call :", "Success");
                    Log.d("Service call :", "Response : " + response.body().getResponseData().get(0).getVehicles());
                    if (response.body() != null
                            && response.body().getResponseData() != null
                            && response.body().getResponseData().get(0) != null &&
                            response.body().getResponseData().get(0).getVehicles() != null
                            && response.body().getResponseData().get(0).getVehicles().size() > 0) {
                        Log.d("Service call", " data = "+response.body().getResponseData().get(0).getVehicles().toString());
                        vehicleList = response.body().getResponseData().get(0).getVehicles();
                        tv_vehicleCount.setText("Number of vehicles found = "+ response.body().getResponseData().get(0).getVehicles().size());
                        recyclerviewAdapter.refreshData(vehicleList);
                    }else{
                        Toast.makeText(MainActivity.this,"Data not found", Toast.LENGTH_SHORT).show();

                    }
                    progressDoalog.dismiss();
                }

                @Override
                public void onFailure(Call<ResponseObj> call, Throwable t) {
                    Log.d("url ", "" + call.request().url().toString());
                    Log.e("Service call :", "failed");
                    Log.e("Service call :", "Error: " + t.getMessage());
                    progressDoalog.dismiss();
                }
            });
        } else {
            Toast.makeText(MainActivity.this, getResources().getString(R.string.ConnectionIssue), Toast.LENGTH_SHORT).show();
        }
    }

}