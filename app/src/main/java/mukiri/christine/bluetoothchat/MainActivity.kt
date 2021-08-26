package mukiri.christine.bluetoothchat

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mukiri.christine.bluetoothchat.adapters.TextAdapter
import mukiri.christine.bluetoothchat.databinding.ActivityMainBinding
import mukiri.christine.bluetoothchat.models.TextMessage
import org.w3c.dom.Text
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a")

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<TextMessage>()
        data.add(TextMessage("7:53pm", "Hi"))
        data.add(TextMessage("7:54pm", "How are you doing?"))
        data.add(TextMessage("7:57pm","This is a very long message that i have to write"))

        val adapter = TextAdapter(data)

        binding.recyclerview.adapter = adapter

        binding.btnSend.setOnClickListener{
            val dateTime = LocalDateTime.now()

            data.add(
                TextMessage(
                    timeFormatter.format(dateTime),
                    binding.newMessage.getText().toString()
                )
            )

            adapter.notifyDataSetChanged()
            binding.recyclerview.smoothScrollToPosition(adapter.getItemCount() - 1)
            binding.newMessage.setText("")
        }


    }
}