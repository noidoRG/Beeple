/*
 * Copyright (c) 2023. Project for Mobile App Development course. Rodion Gladyshev (@noidoRG).
 */

package com.example.emapp.contract

import android.widget.EditText
import androidx.fragment.app.Fragment

interface AccountUserInterface {
    interface View {
        fun initView()
        fun replaceFragment(fragment: Fragment)
        fun logOut()
    }

    interface Presenter {
        fun signOut()
    }

    interface Model {

    }

}