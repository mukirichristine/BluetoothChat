package mukiri.christine.bluetoothchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mukiri.christine.bluetoothchat.adapters.TextAdapter
import mukiri.christine.bluetoothchat.models.TextMessage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<TextMessage>()
        data.add(TextMessage("7:53pm", "Hi"))
        data.add(TextMessage("7:54pm", "How are you doing?"))
        data.add(TextMessage("7:57pm","This is a very long message that i have to write"))

        val adapter = TextAdapter(data)

        recyclerview.adapter = adapter


    }
}