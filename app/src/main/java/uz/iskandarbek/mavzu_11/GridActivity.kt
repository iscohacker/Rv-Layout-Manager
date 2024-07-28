package uz.iskandarbek.mavzu_11

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.iskandarbek.mavzu_11.adapters.GridAdapter
import uz.iskandarbek.mavzu_11.databinding.ActivityGridBinding
import uz.iskandarbek.mavzu_11.model.GridData

class GridActivity : AppCompatActivity() {
    private val binding by lazy { ActivityGridBinding.inflate(layoutInflater) }
    lateinit var list: ArrayList<GridData>
    lateinit var gridAdapter: GridAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onBind()
        val fab = findViewById<FloatingActionButton>(R.id.btnS)
        var isAlternativeAnimation = false

        fab.setOnClickListener {
            gridAdapter.isAlternativeAnimation = !gridAdapter.isAlternativeAnimation
            gridAdapter.notifyItemRangeChanged(0, gridAdapter.itemCount)
        }
        gridAdapter = GridAdapter(list)
        binding.rv.adapter = gridAdapter
    }


    private fun onBind() {
        list = ArrayList()
        for (i in 0..100) {
            list.add(GridData(R.drawable.avto, "AUTOMOTIVE", Color.parseColor("#CD5E38")))
            list.add(GridData(R.drawable.batery, "BATTERIES", Color.parseColor("#D27E3B")))
            list.add(GridData(R.drawable.bolga, "CONSTRUCTION", Color.parseColor("#E7B245")))
            list.add(GridData(R.drawable.power, "ELECTRONICS", Color.parseColor("#F6E34E")))
            list.add(GridData(R.drawable.barg, "GARDEN", Color.parseColor("#92B650")))
            list.add(GridData(R.drawable.botl1, "GLASS", Color.parseColor("#4CA48A")))
            list.add(GridData(R.drawable.diqqat, "HAZARDOUS", Color.parseColor("#458EC1")))
            list.add(GridData(R.drawable.home, "HOUSEHOLD", Color.parseColor("#2C72B2")))
            list.add(GridData(R.drawable.mettal, "METAL", Color.parseColor("#685184")))
            list.add(GridData(R.drawable.chelak, "PAINT", Color.parseColor("#8D4B7C")))
            list.add(GridData(R.drawable.papper, "PAPER", Color.parseColor("#EA6E6F")))
            list.add(GridData(R.drawable.plastic, "PLASTIC", Color.parseColor("#CD5D56")))
        }
    }
}