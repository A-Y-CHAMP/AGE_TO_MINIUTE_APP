package com.example.udemyproject1

import android.graphics.Color.blue
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.util.*

var cnt =0
val xvalue = ArrayList<String>()
val lineentry =  ArrayList<Entry>()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



     // setLineChart()

        val button1 = findViewById<Button>(R.id.button)

        val edittext = findViewById<EditText>(R.id.editText)




        button1.setOnClickListener {
            val data= edittext.text.toString()
          if(data.isEmpty()){ Toast.makeText(this,"no data enetered", Toast.LENGTH_SHORT).show()
              edittext.text.clear()

          }

            else{
                addvalue(data.toFloat())

          }

        }
    }

    fun addvalue(data : Float){
        cnt++

        xvalue.add(cnt.toString())




        lineentry.add(Entry(data,cnt-1))
        val lineDataSet = LineDataSet(lineentry, " ")

        lineDataSet.color=resources.getColor(R.color.blue)

        val data = LineData(xvalue,lineDataSet)
        val linechart = findViewById<LineChart>(R.id.LineGraph)

        linechart.data=data

        linechart.setBackgroundColor(resources.getColor(R.color.white))
        linechart.getLegend().setEnabled(false);
        linechart.xAxis.isEnabled = false
        /* linechart.axisLeft.isEnabled = false
         linechart.axisRight.isEnabled = false*/

        linechart.setDescription(null)
        linechart.invalidate()


    }

    fun setLineChart() {

        val xvalue = ArrayList<String>()

        xvalue.add("1")
        xvalue.add("2")
        xvalue.add("3")
        xvalue.add("4")
        xvalue.add("5")
        xvalue.add("6")
        cnt=6



        val lineentry =  ArrayList<Entry>()

        lineentry.add(Entry(29f,0))
        lineentry.add(Entry(30f,1))
        lineentry.add(Entry(10f,2))
        lineentry.add(Entry(34f,3))
        lineentry.add(Entry(39f,4))
        lineentry.add(Entry(21f,5))


        val lineDataSet = LineDataSet(lineentry, " ")

        lineDataSet.color=resources.getColor(R.color.blue)

        val data = LineData(xvalue,lineDataSet)
        val linechart = findViewById<LineChart>(R.id.LineGraph)

        linechart.data=data

        linechart.setBackgroundColor(resources.getColor(R.color.white))
        linechart.getLegend().setEnabled(false);
      linechart.xAxis.isEnabled = false
       /* linechart.axisLeft.isEnabled = false
        linechart.axisRight.isEnabled = false*/

        linechart.setDescription(null)

    }

}