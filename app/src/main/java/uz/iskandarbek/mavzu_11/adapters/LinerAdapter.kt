package uz.iskandarbek.mavzu_11.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.iskandarbek.mavzu_11.R
import uz.iskandarbek.mavzu_11.databinding.ItemLinerBinding
import uz.iskandarbek.mavzu_11.model.LinerData

class LinerAdapter(var list: ArrayList<LinerData>) : RecyclerView.Adapter<LinerAdapter.Vh>() {
    var isAlternativeAnimation = false

    inner class Vh(var itemRv: ItemLinerBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: LinerData) {
            itemRv.name.text = user.name
            itemRv.view.text = user.view
            itemRv.data.text = user.data
            itemRv.image.setImageResource(user.image)
            val anim = AnimationUtils.loadAnimation(itemView.context, R.anim.anim_liner)
            itemRv.root.startAnimation(anim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        //         Har bitta Item ni yasalishi

        return Vh(ItemLinerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size
    //            Nechta item yasay


    override fun onBindViewHolder(holder: Vh, position: Int) {
//            Item qiymatlarini beruchi

        holder.onBind(list[position])

        val animation = if (isAlternativeAnimation) {
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim2)
        } else {
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim_liner)
        }
        holder.itemView.startAnimation(animation)

    }
}