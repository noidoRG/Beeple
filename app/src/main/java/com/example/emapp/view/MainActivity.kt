package com.example.emapp.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.notification.Condition
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.emapp.R
import com.example.emapp.contract.ContractInterface.*
import com.example.emapp.presenter.MainActivityPresenter
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {

    private var presenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)

        // Write a message to the database
        //val database = Firebase.database("https://beeple-rmp-default-rtdb.europe-west1.firebasedatabase.app")
        //val myRef = database.getReference("message")

        //myRef.setValue("Hello, World!")
    }

    override fun initView() {

        EnterButton.setOnClickListener {
            presenter?.enterData(edEmail.editText?.text.toString(),edPassword.editText?.text.toString())
        }
        CreateAccButton.setOnClickListener{
            startActivity(Intent( this, CreateAccount::class.java))
            finish()
        }

        edEmail.editText?.addTextChangedListener {
            presenter?.validateEmail(edEmail.editText?.text.toString())
        }

        edPassword.editText?.addTextChangedListener{
            presenter?.validatePassword(edPassword.editText?.text.toString())

        }




    }

    override fun signInIntent() {
        startActivity(Intent( this, AccountUser::class.java))
        finish()
    }

    override fun toastWrong() {
        Toast.makeText(this,getString(R.string.user_not_found),Toast.LENGTH_LONG).show()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val view = this.currentFocus
        when(event?.actionMasked){
            MotionEvent.ACTION_DOWN ->{
                val hideMe = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                hideMe.hideSoftInputFromWindow(view?.windowToken,0)
            }
        }

        return true
    }

}