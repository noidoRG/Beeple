/*
 * Copyright (c) 2023. Project for Mobile App Development course. Rodion Gladyshev (@noidoRG).
 */

package com.example.emapp.model

import android.app.Activity
import android.widget.Toast

object Extensions {
    fun Activity.toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}