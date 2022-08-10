package `in`.nareshit.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var c:Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun incrementScore(view: View) {
        val res : TextView = findViewById(R.id.count_val);
        c++;
        res.text = c.toString();
    }
}