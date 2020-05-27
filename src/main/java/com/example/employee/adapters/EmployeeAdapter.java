package com.example.employee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.employee.R;
import com.example.employee.baseclasses.ListClickListener;
import com.example.employee.models.Employee;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private List<Employee> employeeList;
    private Context context;
    private ListClickListener listener;

    public EmployeeAdapter(List<Employee> employeeList, Context context, ListClickListener listener) {
        this.employeeList = employeeList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.ViewHolder holder, int position) {
        final Employee employee = employeeList.get(position);
        if(employee!=null)
        {
            if(employee.getCompany()!=null && employee.getCompany().getName()!=null)
         holder.companyName.setText(employee.getCompany().getName());
         holder.employeeName.setText(employee.getName());
            Glide.with(context).load(employee.getProfile_image()).into(holder.profile);
            holder.rootLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(employee);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public void appendData(@NotNull ArrayList<Employee> employeeList) {
        employeeList.clear();
        employeeList.addAll(employeeList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView employeeName,companyName;
        ImageView profile;
        ConstraintLayout rootLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            employeeName=itemView.findViewById(R.id.employee_name);
            companyName=itemView.findViewById(R.id.company_name);
            profile=itemView.findViewById(R.id.employee_image);
            rootLayout=itemView.findViewById(R.id.root_layout);
        }
    }
}
