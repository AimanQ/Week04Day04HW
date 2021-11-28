package com.example.week04day04hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

import android.R.attr

import android.R.attr.button
import android.view.Gravity
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var frameLayout:FrameLayout?= null
    private var bottomNavigationView:BottomNavigationView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        connectViews()
        bottomNavigationClicks()
//        chooseFragment(HomeFragment(),"HOME")
        Snackbar.make(frameLayout!!,"kdshfjk",Snackbar.LENGTH_INDEFINITE).setAction("Ok") {
            Toast.makeText(this,"dimissed",Toast.LENGTH_SHORT).apply {
                this.setGravity(Gravity.TOP,0,0)
            }.show()
        }.show()

    }

    private fun connectViews() {
        frameLayout = findViewById(R.id.fContainer)
        bottomNavigationView = findViewById(R.id.bottomNav)
    }
    private fun bottomNavigationClicks(){
        bottomNavigationView?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    chooseFragment(HomeFragment(),"HOME")
                    supportActionBar?.title = "Home"
                }
                R.id.dashboard ->{
                    chooseFragment(DashboardFragment(),"DASHBOARD")
                    supportActionBar?.title = "Dashboard"
                }
                R.id.notification ->{
                    chooseFragment(NotificationFragment(),"NOTIFICATION")
                    supportActionBar?.title = "Notification"
                }
                R.id.profile ->{
                    chooseFragment(ProfileFragment(),"PROFILE")
                    supportActionBar?.title = "Profile"
                }
            }


            true
        }
    }
    private fun chooseFragment(fragment:Fragment,tag:String){
        val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fContainer,fragment,tag)

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        //fragmentTransaction.addToBackStack(tag)

        fragmentTransaction.commit()
    }
}