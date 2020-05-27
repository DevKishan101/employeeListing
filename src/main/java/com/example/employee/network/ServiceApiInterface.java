package com.example.employee.network;

import com.example.employee.models.Employee;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApiInterface {

    @GET("v2/5d565297300000680030a986 ")
    Call<ArrayList<Employee>> getEmployeeList();
}
