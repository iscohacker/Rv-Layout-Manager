package uz.iskandarbek.mavzu_11.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.iskandarbek.mavzu_11.R
import uz.iskandarbek.mavzu_11.databinding.ItemGridBinding
import uz.iskandarbek.mavzu_11.model.GridData

class GridAdapter(var list: ArrayList<GridData>) : RecyclerView.Adapter<GridAdapter.Vh>() {
    var isAlternativeAnimation = false

    inner class Vh(var itemRv: ItemGridBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: GridData) {
            itemRv.name.text = user.name
            itemRv.image.setImageResource(user.image)
            itemRv.root.setBackgroundColor(user.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        //         Har bitta Item ni yasalishi

        return Vh(ItemGridBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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