//package com.example.konetpaypos
//
//import android.app.Activity
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import androidx.activity.result.contract.ActivityResultContracts
//
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val clickButton: Button? = findViewById(R.id.button)
//        clickButton!!.setOnClickListener {
//            val intent = Intent("com.globalaccelerex.keyexchange")
//            launchSomeActivity.launch(intent)
////            doGetParameters();
//        }
//
//    }
//
//    var launchSomeActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val data: Intent? = result.data
//            Log.i("rrrr", data!!.getStringExtra("data").toString())
//
//            openYourActivity("3.00");
////            openlaunchprinter();
//
//        }
//
//    }
//    var launchSomeActivitys = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val data: Intent? = result.data
//            // your operation...
//            Log.i("rrrrsd", data!!.getStringExtra("status").toString())
//        }
//    }
//    //
//    fun openYourActivity(amount: String) {
//        val jsonString =
//            "{ \"transType\": \"PURCHASE\", \"amount\":\"$amount\",\"print\":\"false\" }"
//        val intent = Intent("com.globalaccelerex.transaction")
//        intent.putExtra("requestData", jsonString)
//
//        launchSomeActivitys.launch(intent)
//    }
//
//    var launchprinter = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val data: Intent? = result.data
//            // your operation...
//            Log.i("rrrrsd", data!!.getStringExtra("data").toString())
//        }
//    }
//    //
//    fun openlaunchprinter() {
////    val TextFields:TextField=TextField("RR","rr","rr",false);
////    val Stringss :List<StringField>=Stringss
////    var PrintFields:PrintField=PrintField("dfs",2,Stringss);
////    var Listt:List<PrintField>=List<PrintField>
////     var jsonSrtring:PrintObject= PrintObject(Listt);
//        val intent = Intent("com.globalaccelerex.printer")
//
//        launchprinter.launch(intent)
//    }
//}