package mukiri.christine.bluetoothchat.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mukiri.christine.bluetoothchat.R
import mukiri.christine.bluetoothchat.models.TextMessage


class TextAdapter(private val mList: List<TextMessage>) : RecyclerView.Adapter<TextAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.individual_text, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val TextMessage = mList[position]


        holder.timeSent.text = TextMessage.timeSent
        holder.message.text = TextMessage.message

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val timeSent: TextView = itemView.findViewById(R.id.timeSent)
        val message: TextView = itemView.findViewById(R.id.message)
    }
}
