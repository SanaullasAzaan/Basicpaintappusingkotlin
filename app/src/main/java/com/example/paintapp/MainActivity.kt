package com.example.paintapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.paintapp.paint_view.Companion.colorList
import com.example.paintapp.paint_view.Companion.currentBrush
import com.example.paintapp.paint_view.Companion.pathList

class MainActivity : AppCompatActivity() {
    companion object {//on decleraing companion object we can access value inside it globaly
        var path = Path()//impot from android graphics
        var paintBrush = Paint()//import from android graphics
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //for hiding  top the action bar
        supportActionBar?.hide()

        val redBtn =findViewById<ImageButton>(R.id.redColor)
        val blueBtn =findViewById<ImageButton>(R.id.blueColor)
        val blackBtn =findViewById<ImageButton>(R.id.blackColor)
        val eraser = findViewById<ImageButton>(R.id.whiteColor)


        redBtn.setOnClickListener{
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            //Toast.makeText(this:"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color=Color.RED
            currentColor(paintBrush.color)
        }
        blueBtn.setOnClickListener{
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

            paintBrush.color=Color.BLUE
            currentColor(paintBrush.color)
        }
        blackBtn.setOnClickListener{
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

            paintBrush.color=Color.BLACK
            currentColor(paintBrush.color)
        }
        eraser.setOnClickListener{
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

            pathList.clear()
            colorList.clear()
            path.reset()
        }
    }
    private fun currentColor(color:Int){
        currentBrush = color
        path=Path()
    }
}

//note one this if everything is correct agin its sayint gradel eerror then try to build and rebuild the project.