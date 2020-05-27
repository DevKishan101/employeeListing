package com.example.employee.network;

import android.content.Context;
import android.widget.Toast;

import com.example.employee.baseclasses.SucessListener;
import com.example.employee.models.Employee;
import com.example.employee.utils.EmployeeDataManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeApi {

    private final Call<ArrayList<Employee>> call;

    public EmployeeApi(final Context context, final SucessListener listener) {
        call=ApiService.Companion.client().getEmployeeList();
        call.enqueue(new Callback<ArrayList<Employee>>() {
            @Override
            public void onResponse(Call<ArrayList<Employee>> call, Response<ArrayList<Employee>> response) {
                if(response.body()!=null)
                {
                    EmployeeDataManager.INSTANCE.addEmplloyeeListToDatabse(response.body(),context);
                    listener.excecute();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Employee>> call, Throwable t) {
                Toast.makeText(context,"Something wnt wrong",Toast.LENGTH_LONG).show();
            }
        });
    }
}
