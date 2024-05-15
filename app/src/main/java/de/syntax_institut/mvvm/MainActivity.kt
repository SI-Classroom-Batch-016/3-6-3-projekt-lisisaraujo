package de.syntax_institut.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.util.Log
//import com.mongodb.ConnectionString
//import com.mongodb.MongoClientSettings
//import com.mongodb.kotlin.client.coroutine.MongoClient
//import com.mongodb.kotlin.client.coroutine.MongoDatabase
//import de.syntax_institut.mvvm.data.model.Location
//import org.bson.Document

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        val connectionString =
//            ConnectionString("mongodb+srv://laruschel:L14vE6R0fb5RvHWF@cluster0.cwpjgeg.mongodb.net/queer_map")
//        val settings = MongoClientSettings.builder().applyConnectionString(connectionString).build()
//        val mongoClient = MongoClient.create(settings)
//
//        val database: MongoDatabase = mongoClient.getDatabase("q4q-database")
//
//        val locations = database.getCollection<String>("locations")
//        Log.d("Main", locations.toString())


    }
}