package com.example.employee.models

import java.io.Serializable

class Address :Serializable {
    var street: String? = ""
    var suite: String? = ""
    var city: String? = ""
    var zipcode: String? = ""
    var geo: Geo? = null

}