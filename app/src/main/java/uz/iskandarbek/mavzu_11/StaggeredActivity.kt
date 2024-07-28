package uz.iskandarbek.mavzu_11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.iskandarbek.mavzu_11.adapters.StaggeredAdapter
import uz.iskandarbek.mavzu_11.databinding.ActivityStaggeredBinding
import uz.iskandarbek.mavzu_11.model.StraggeredData

class StaggeredActivity : AppCompatActivity() {
    lateinit var list: ArrayList<StraggeredData>
    lateinit var staggeredAdapter: StaggeredAdapter
    private val binding by lazy { ActivityStaggeredBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        val fab = findViewById<FloatingActionButton>(R.id.btnS)
        var isAlternativeAnimation = false

        fab.setOnClickListener {
            staggeredAdapter.isAlternativeAnimation = !staggeredAdapter.isAlternativeAnimation
            staggeredAdapter.notifyItemRangeChanged(0, staggeredAdapter.itemCount)
        }
        staggeredAdapter = StaggeredAdapter(list)
        binding.rv.adapter = staggeredAdapter
        binding.rv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }

    private fun loadData() {
        list = ArrayList()
        for (i in 0..100) {
            list.add(StraggeredData(R.drawable.pc1, "Ajoyib PC"))
            list.add(StraggeredData(R.drawable.pc2, "Zo'r PC"))
            list.add(StraggeredData(R.drawable.pc3, "Mazza PC"))
            list.add(StraggeredData(R.drawable.pc4, "Chotki PC"))
            list.add(StraggeredData(R.drawable.pc5, "Qichig' PC"))
        }
    }
}