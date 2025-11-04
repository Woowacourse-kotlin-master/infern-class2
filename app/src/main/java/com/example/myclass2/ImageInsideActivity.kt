package com.example.myclass2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImageInsideActivity : AppCompatActivity() {
    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image_inside)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val memberImage = findViewById<ImageView>(R.id.memberImageArea)

        val getData = intent.getStringExtra("data")
        // Toast.makeText(this, getData, Toast.LENGTH_LONG).show()

        val resName = "member_${getData}"  // 문자열 조합
        val resId = resources.getIdentifier(resName, "drawable", packageName)

        if (resId != 0) {
            memberImage.setImageResource(resId)
            memberImage.post {
                Toast.makeText(this, "선택된 번호: $getData", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "해당 이미지를 찾을 수 없습니다.", Toast.LENGTH_LONG).show()
        }

        /*if (getData == "1") {
            memberImage.setImageResource(R.drawable.member_1)
        }

        if (getData == "2") {
            memberImage.setImageResource(R.drawable.member_2)
        }

        if (getData == "3") {
            memberImage.setImageResource(R.drawable.member_3)
        }

        if (getData == "4") {
            memberImage.setImageResource(R.drawable.member_4)
        }
        if (getData == "5") {
            memberImage.setImageResource(R.drawable.member_5)
        }

        if (getData == "6") {
            memberImage.setImageResource(R.drawable.member_6)
        }

        if (getData == "7") {
            memberImage.setImageResource(R.drawable.member_7)
        }

        if (getData == "8") {
            memberImage.setImageResource(R.drawable.member_8)
        }

        if (getData == "9") {
            memberImage.setImageResource(R.drawable.member_9)
        }*/


    }
}