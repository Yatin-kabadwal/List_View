package com.example.advanced_list_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var userArrayList : ArrayList<User>
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = arrayOf("Rony" , "Rocky" , "Kaka" , "Pandit", "Mahesh")
        val lastMsg =  arrayOf("Hey what's up", "I am fine ", "Good ", "Awesome","Cool" )
        val lastMsgTime = arrayOf("6:45 AM","9:55 AM","5:00 AM","6:05 AM","12:45 AM")
        val phoneNumber = arrayOf("54543435465","643546844","0021545454","245457864","5454345435465")
        val imgId =  arrayOf(R.drawable.akat,R.drawable.hac,R.drawable.coolmountain,R.drawable.illu,R.drawable.madra)
        userArrayList = ArrayList()

        for(eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex] , lastMsgTime[eachIndex], phoneNumber[eachIndex],imgId[eachIndex])
            userArrayList.add(user)
        }
       val listview = findViewById<ListView>(R.id.view)
        listview.isClickable  =true

        listview.adapter = MyAdapter(this, userArrayList)

        listview.setOnItemClickListener { parent, view, position, id ->

            val username = name[position]
            val userphone = phoneNumber[position]
            val imageId = imgId[position]

            val i = Intent(this,UserActivity:: class.java)

            i.putExtra("name", username)
            i.putExtra("phone",userphone)
            i.putExtra("imageId",imageId)

            startActivity(i)
        }



    }
}