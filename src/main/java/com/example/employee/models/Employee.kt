package com.example.employee.models

import java.io.Serializable

class Employee :Serializable{
    var id = 0
    var name: String? = ""
    var username: String? = ""
    var email: String? = ""
    var profile_image: String? = ""
    var address: Address? = null
    var phone: String? = ""
    var website: String? = ""
    var company: Company? = null

}