package tokyo.mp015v.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var edt_quantity : EditText
    lateinit var edt_bid : EditText
    lateinit var txt_total : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        edt_quantity = findViewById<EditText>(R.id.edt_quantity)
        edt_bid = findViewById<EditText>(R.id.edt_bid)
        txt_total = findViewById<TextView>(R.id.txt_total)

        //イベントの割り当て
        findViewById<Button>(R.id.btn_calc).setOnClickListener {
            btn_calc_onClick( it )
        }
    }

    //計算ボタンクリックイベント
    fun btn_calc_onClick( it : View){
        txt_total.text = edt_quantity.text.toString()

    }


}
