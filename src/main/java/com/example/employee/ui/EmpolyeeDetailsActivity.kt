package com.example.employee.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.employee.R
import com.example.employee.models.Employee
import com.example.employee.utils.EmployeeDataManager
import kotlinx.android.synthetic.main.activity_employee.*

class EmpolyeeDetailsActivity : AppCompatActivity(){

    lateinit var employee:Employee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        employee=intent.getSerializableExtra(EmployeeDataManager.EMPLOYEE_CLASS) as Employee
        initViews()
    }

    private fun initViews() {
        Glide.with(this).load(employee.profile_image).into(profile_image)
        user_name.text=employee.username
        name.text=employee.name
        email.text=employee.email
        if(employee.address!=null){street.text=employee.address!!.street
            suite.text=employee.address!!.suite
            city.text=employee.address!!.city
            zip.text=employee.address!!.zipcode
        }
        if(employee.company!=null)
        {
            company_name.text=employee.company!!.name
            catchphrase.text=employee.company!!.catchPhrase
            field.text=employee.company!!.bs
        }

    }


}