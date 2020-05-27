package com.example.employee.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employee.R
import com.example.employee.adapters.EmployeeAdapter
import com.example.employee.baseclasses.ListClickListener
import com.example.employee.baseclasses.SucessListener
import com.example.employee.models.Employee
import com.example.employee.network.ApiService
import com.example.employee.network.EmployeeApi
import com.example.employee.utils.EmployeeDataManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), ListClickListener, SucessListener
{
    var adapter: EmployeeAdapter?=null
    var employeeList :ArrayList<Employee>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        populateDatabase()
       }

    private fun populateDatabase() {

        var apICall=EmployeeApi(this,this)
    }


    override fun onClick(item:Employee) {
      var intent= Intent(this,EmpolyeeDetailsActivity::class.java)
         intent.putExtra(EmployeeDataManager.EMPLOYEE_CLASS,item)
        startActivity(intent)
    }

    override fun excecute() {
        employeeList= EmployeeDataManager.getEmployeeList()
        adapter = EmployeeAdapter(employeeList, this, this)
        var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        employee_list.layoutManager = layoutManager
        employee_list.adapter = adapter
    }

}