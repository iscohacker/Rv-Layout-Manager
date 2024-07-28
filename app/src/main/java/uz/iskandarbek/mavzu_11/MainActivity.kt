package uz.iskandarbek.mavzu_11

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import uz.iskandarbek.mavzu_11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.apply {
            liner.setOnClickListener {
                val intent = Intent(this@MainActivity, LinerActivity::class.java)
                startActivity(intent)
            }
            grid.setOnClickListener {
                val intent = Intent(this@MainActivity, GridActivity::class.java)
                startActivity(intent)
            }
            staggered.setOnClickListener {
                val intent = Intent(this@MainActivity, StaggeredActivity::class.java)
                startActivity(intent)
            }
        }
    }
}