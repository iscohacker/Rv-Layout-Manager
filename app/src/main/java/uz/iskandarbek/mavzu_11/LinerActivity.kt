package uz.iskandarbek.mavzu_11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.iskandarbek.mavzu_11.adapters.LinerAdapter
import uz.iskandarbek.mavzu_11.databinding.ActivityLinerBinding
import uz.iskandarbek.mavzu_11.model.LinerData

class LinerActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLinerBinding.inflate(layoutInflater) }
    lateinit var list: ArrayList<LinerData>
    lateinit var linerAdapter: LinerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loaData()
        val fab = findViewById<FloatingActionButton>(R.id.btnS)
        var isAlternativeAnimation = false

        fab.setOnClickListener {
            linerAdapter.isAlternativeAnimation = !linerAdapter.isAlternativeAnimation
            linerAdapter.notifyItemRangeChanged(0, linerAdapter.itemCount)
        }
        linerAdapter = LinerAdapter(list)
        binding.rv.adapter = linerAdapter

    }

    private fun loaData() {
        list = ArrayList()
        for (i in 0 until 20) {
            list.add(
                LinerData(
                    R.drawable.kelajaku,
                    "Kelajak Urishi",
                    "View:5000",
                    "Data:12.12.2023"
                )
            )
            list.add(LinerData(R.drawable.qahramon, "Qahramon", "View:1100", "Data:12.12.2023"))
            list.add(LinerData(R.drawable.ragnaryok, "Ragnaryok", "View:400", "Data:12.12.2023"))
            list.add(LinerData(R.drawable.sirliqita, "Sirli Qit'a", "View:2500", "Data:12.12.2023"))
            list.add(LinerData(R.drawable.supermen, "Supermen", "View:4522", "Data:12.12.2023"))
        }
    }
}