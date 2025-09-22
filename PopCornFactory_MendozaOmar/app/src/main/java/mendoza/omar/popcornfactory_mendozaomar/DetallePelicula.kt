package mendoza.omar.popcornfactory_mendozaomar

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)

        var infoPelicula = intent.extras

        if (infoPelicula != null) {
            findViewById<android.widget.ImageView>(R.id.iv_pelicula_imagen).setImageResource(infoPelicula.getInt("header"))
            findViewById<android.widget.TextView>(R.id.tv_nombre_pelicula).setText(infoPelicula.getString("titulo"))
            findViewById<android.widget.TextView>(R.id.tv_pelicula_desc).setText(infoPelicula.getString("sinopsis"))

            findViewById<TextView>(R.id.tv_pelicula_desc).movementMethod = android.text.method.ScrollingMovementMethod()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}