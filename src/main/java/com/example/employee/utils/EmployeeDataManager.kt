package com.example.employee.utils

import android.content.Context
import android.preference.PreferenceManager
import com.example.employee.models.Employee

object EmployeeDataManager {

    val EMPLOYEE_CLASS: String?="EMPLOYEE_CLASS"
    var employeelist:ArrayList<Employee> = ArrayList()
    var context:Context?=null
    fun addEmplloyeeListToDatabse(employeelist: ArrayList<Employee>,context: Context)
    {
      this.employeelist=employeelist
    }

    fun getEmployeeList():ArrayList<Employee>
    {
        return employeelist;
    }

}