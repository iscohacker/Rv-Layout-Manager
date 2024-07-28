package uz.iskandarbek.mavzu_11.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.iskandarbek.mavzu_11.R
import uz.iskandarbek.mavzu_11.databinding.ItemStaggeredBinding
import uz.iskandarbek.mavzu_11.model.StraggeredData

class StaggeredAdapter(var list: ArrayList<StraggeredData>) :
    RecyclerView.Adapter<StaggeredAdapter.Vh>() {
    var isAlternativeAnimation = false

    inner class Vh(var itemRv: ItemStaggeredBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: StraggeredData) {
            itemRv.namep.text = user.name
            itemRv.imagep.setImageResource(user.image)
            val anim = AnimationUtils.loadAnimation(itemView.context, R.anim.anim_liner)
            itemRv.root.startAnimation(anim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        //         Har bitta Item ni yasalishi

        return Vh(ItemStaggeredBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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