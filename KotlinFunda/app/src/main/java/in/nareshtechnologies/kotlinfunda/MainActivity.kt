package `in`.nareshtechnologies.kotlinfunda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count : Int = 0;

        var plus = findViewById<Button>(R.id.button)
        var minus : Button = findViewById(R.id.button2)
        var tv : TextView = findViewById(R.id.textView)

        plus.setOnClickListener(){
            count++
            tv.text = count.toString();
        }

        minus.setOnClickListener(){
            count--
            tv.text = count.toString();
        }
    }
}

