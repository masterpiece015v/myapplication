package tokyo.mp015v.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewを変数にして操作できるようにする
        val edtQuantity : EditText=findViewById(R.id.edt_quantity) as EditText
        val edtDid : EditText = findViewById(R.id.edt_bid) as EditText
        val txtTotal : TextView = findViewById(R.id.txt_total) as TextView
        val btnCalc : Button = findViewById(R.id.btn_calc) as Button
        val swtTax :Switch = findViewById( R.id.swt_tax ) as Switch

        //btn_calcのクリックイベントイベントの割り当て
        btnCalc.setOnClickListener {
            //数量の取得
            val quantity = Integer.parseInt( edtQuantity.text.toString() )
            //単価の取得
            val bid = Integer.parseInt( edtDid.text.toString() )
            //消費税のチェック
            val chktax = swtTax.isChecked
            //税率
            val taxrate = if( chktax ) 0.1 else 0.08
            //税金
            val sum = quantity * bid
            //金額の計算
            val total = ceil(sum * ( 1 + taxrate )).toInt()
            //金額の表示
            txtTotal.text = total.toString()
        }

        //chk_taxのチェンジイベント
        swtTax.setOnCheckedChangeListener { buttonView, isChecked ->
            swtTax.text = if( isChecked ){ "10%" }else{ "8%" }
        }
    }


}
