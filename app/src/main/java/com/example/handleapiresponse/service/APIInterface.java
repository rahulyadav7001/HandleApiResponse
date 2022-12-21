package com.example.handleapiresponse.service;

import com.example.handleapiresponse.model.RequestBody;
import com.example.handleapiresponse.model.ResponseObj;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIInterface {

	@POST("/demo/api/index_gps.php")
	Call<ResponseObj> getInfromationFromServer(@Body RequestBody params);
}
