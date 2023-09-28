package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paintapp.MainActivity.Companion.paintBrush
import com.example.paintapp.MainActivity.Companion.path

class paint_view: View {
    //params is responsible for hight and width of the canvas
    var params:ViewGroup.LayoutParams?=null
    //to acrees in the main acivity we will declere some functions here
    companion object{
        var pathList =ArrayList<Path>()//import path from android graphic
        var colorList =ArrayList<Int>()
        var currentBrush=Color.BLACK;
    }
    //insted of writeing all constructur for scratch we can copy it form google
    //in search bar type-->constructor of view in android studio kotlin
    constructor(context: Context) : this(context, null){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    {
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    {
        init()
    }
    //intialze brush
    private fun init(){
        paintBrush.isAntiAlias=true
        paintBrush.color= currentBrush
        paintBrush.style=Paint.Style.STROKE
        paintBrush.strokeJoin=Paint.Join.ROUND
        paintBrush.strokeWidth=8f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }
    //To register the moments of screen
    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y
//switch is when in kotlin
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE->{
                path.lineTo(x, y)
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else->return false
        }
        postInvalidate()//some changes have been dine on ui
        return false;
    }
    //draw something on screen
    override fun onDrawForeground(canvas: Canvas) {
        //geting the path
        for (i in pathList.indices){
            paintBrush.setColor(colorList[i])
            canvas.drawPath(pathList[i], paintBrush)
            invalidate()
        }
    }

}