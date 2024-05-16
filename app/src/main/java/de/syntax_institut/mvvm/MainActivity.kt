package de.syntax_institut.mvvm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mongodb.kotlin.client.coroutine.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("AuthLeak")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Replace the placeholder with your MongoDB deployment's connection string
        val uri = "mongodb+srv://laruschel:L14vE6R0fb5RvHWF@cluster0.cwpjgeg.mongodb.net/queer_map"
        val mongoClient = MongoClient.create(uri)
        val database = mongoClient.getDatabase("q4q")
        // Get a collection of documents of type Movie

        mongoClient.close()


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