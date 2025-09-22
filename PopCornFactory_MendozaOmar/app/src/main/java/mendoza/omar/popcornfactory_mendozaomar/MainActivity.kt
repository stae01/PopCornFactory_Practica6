package mendoza.omar.popcornfactory_mendozaomar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val peliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gridview = findViewById<GridView>(R.id.gridview)

        var adapter: PeliculaAdapter? = null


        cargarPeliculas ()
        adapter = PeliculaAdapter(this, peliculas)
        gridview.adapter = adapter


    }

    fun cargarPeliculas() {

        peliculas.add(
            Pelicula(
                "Bones",
                R.drawable.bones,
                R.drawable.bonesheader,
                "Dr. Temperance Brennan is a brilliant, but lonely, anthropologist who is approached by an ambitious FBI agent, Seely Booth, to help solve unsolved crimes by identifying the long-dead bodies of missing persons by their bone structure. Together they face red tape, corruption, and local noncooperation."
            )
        )

        peliculas.add(
            Pelicula(
                "Dr. House",
                R.drawable.drhouse,
                R.drawable.drhouse, // Asegúrate que este header sea correcto
                "The series follows the life of anti-social, painkiller-addicted, witty, and arrogant medical doctor Gregory House (Hugh Laurie), who with only half a muscle in his right leg, leads a team of doctors trying to solve complex and rare diseases in the U.S."
            )
        )

        peliculas.add(
            Pelicula(
                "Big Hero 6",
                R.drawable.bighero6,
                R.drawable.headerbighero6,
                "When a devastating event befalls the city of San Fransokyo, Hiro turns to Baymax and his close friends: Go Go Tomago, Wasabi, Honey Lemon, and Fred. Together they form a band of high-tech heroes called 'Big Hero 6' to uncover the mystery and fight the danger."
            )
        )

        peliculas.add(
            Pelicula(
                "Dr. Who",
                R.drawable.drwho,
                R.drawable.drwhoheader,
                "Traveling across time and space, the immortal time-lord known as 'The Doctor' journeys through the universe with companions and his loyal shape-shifting spaceship, the TARDIS, facing threats like The Daleks, The Cybermen, and The Master."
            )
        )

        peliculas.add(
            Pelicula(
                "Friends",
                R.drawable.friends,
                R.drawable.friendsheader,
                "Rachel Green, Ross Geller, Monica Geller, Joey Tribbiani, Chandler Bing, and Phoebe Buffay are six 20-somethings living in New York City. Over ten years, they experience romance, fights, laughs, tears, and surprises while discovering the true meaning of friendship."
            )
        )

        peliculas.add(
            Pelicula(
                "Inception",
                R.drawable.inception,
                R.drawable.inceptionheader,
                "Dom Cobb is a skilled thief, the best at stealing secrets from the subconscious during dreams. He's offered a chance at redemption: plant an idea instead of stealing one. But a dangerous enemy seems to predict every move—an enemy only Cobb could have seen coming."
            )
        )

        peliculas.add(
            Pelicula(
                "Leap Year",
                R.drawable.leapyear,
                R.drawable.leapyearheader,
                "A woman plans to propose to her boyfriend on Leap Day, following Irish tradition, but bad weather threatens her trip to Dublin. With the help of an innkeeper, her journey may lead her to more than just a proposal—it may lead her to true love."
            )
        )

        peliculas.add(
            Pelicula(
                "Toy Story",
                R.drawable.toystory,
                R.drawable.toystoryheader,
                "When Buzz Lightyear replaces Woody as Andy’s favorite toy, jealousy arises. After Buzz accidentally falls out of the window, Woody is blamed and must rescue him. Together, they face many challenges to return home before Andy notices they're gone."
            )
        )

        peliculas.add(
            Pelicula(
                "Smallville",
                R.drawable.smallville,
                R.drawable.smallvilleheader,
                "Clark Kent’s miraculous rescues in Smallville spark suspicions. Found by Martha and Jonathan Kent during the Meteor Shower, Clark hides his powers. Meanwhile, Lex Luthor investigates Clark's secrets, unaware that Clark is more than just a typical teenager."
            )
        ) }

    class PeliculaAdapter: BaseAdapter {
        var peliculas = ArrayList<Pelicula>()
        var context: Context? = null
        constructor (context: Context, peliculas: ArrayList<Pelicula>) {
            this.context = context
            this.peliculas = peliculas
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any {
            return peliculas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val pelicula = peliculas[position]
            val inflator = LayoutInflater.from(context)
            val vista = convertView ?: inflator.inflate(R.layout.pelicula, parent, false)

            val imagen = vista.findViewById<ImageView>(R.id.iv_pelicula)
            val titulo = vista.findViewById<TextView>(R.id.tv_nombre_pelicula)

            imagen.setImageResource(pelicula.image)
            titulo.text = pelicula.titulo

            imagen.setOnClickListener {
                val intent = Intent(context, DetallePelicula::class.java).apply {
                    putExtra("titulo", pelicula.titulo)
                    putExtra("image", pelicula.image)
                    putExtra("header", pelicula.header)
                    putExtra("sinopsis", pelicula.sinopsis)
                }
                context!!.startActivity(intent)
            }

            return vista
        }

    }

}