package mx.edu.itt.ladm_u2_practica3_danielmora

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var p1 = Jugador()
    var p2 = Jugador()
    var p3 = Jugador()
    var p4 = Jugador()



    var Juego : Hilo?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Juego = Hilo(this)


        button2.setOnClickListener {

            Juego?.start()
            button2.setVisibility(View.GONE)
            button3.setVisibility(View.VISIBLE)
        }
        button3.setOnClickListener {
            Juego?.Reiniciar()
        }

    }
}


