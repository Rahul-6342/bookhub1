package adapter

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahul.bookhub.R

class DashboardRecyclerAdapter {

    class DashboardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textView: TextView =view.findViewById(R.id.txtRecyclerRowItem)
    }
}