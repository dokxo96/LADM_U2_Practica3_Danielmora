package mx.edu.itt.ladm_u2_practica3_danielmora

import android.graphics.Color
import android.os.AsyncTask
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
class Hilo (p:MainActivity):Thread(){
    private var puntero = p
    private var iniciado = false
    private var tirando = 1
    var turno =0
    var contdado1=0
    var contdado2=0

    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){
            sleep(3000)

            puntero.j1.setTextColor(Color.WHITE)
            puntero.j2.setTextColor(Color.WHITE)
            puntero.j3.setTextColor(Color.WHITE)
            puntero.j4.setTextColor(Color.WHITE)

            if(tirando==1){
                puntero.runOnUiThread {

                    puntero.setTitle("Turno ${turno+1} :Jugador 1")
                    puntero.j1.setTextColor(Color.YELLOW)


                    TirarDados()

                    puntero.p1.acumularPuntos(contdado1+contdado2)

                    puntero.txt1.setText(puntero.p1.puntos.toString())
                    tirando=2
                    if(turno==4){

                        tirando=0
                        Ganador()


                    }

                }
            }
            if(tirando==2){
                puntero.runOnUiThread {
                    puntero.setTitle("Turno ${turno+1} :Jugador 2")
                    puntero.j2.setTextColor(Color.YELLOW)

                    TirarDados()

                    sleep(300)

                    puntero.p2.acumularPuntos(contdado1+contdado2)
                    puntero.txt2.setText(puntero.p2.puntos.toString())
                    tirando=3
                    puntero.j2.setTextColor(Color.YELLOW)

                }
            }
            if(tirando==3){
                puntero.runOnUiThread {
                    puntero.setTitle("Turno ${turno+1} :Jugador 3")
                    puntero.j3.setTextColor(Color.YELLOW)


                    TirarDados()

                    sleep(300)
                    puntero.p3.acumularPuntos(contdado1+contdado2)
                    puntero.txt3.setText(puntero.p3.puntos.toString())
                    tirando=4
                    puntero.j3.setTextColor(Color.YELLOW)

                }
            }
            if(tirando==4){
                puntero.runOnUiThread {
                    puntero.setTitle("Turno ${turno+1} :Jugador 4")
                    puntero.j4.setTextColor(Color.YELLOW)

                    TirarDados()

                    sleep(300)
                    puntero.p4.acumularPuntos(contdado1+contdado2)
                    puntero.txt4.setText(puntero.p4.puntos.toString())
                    tirando=1
                    turno+=1
                    puntero.j4.setTextColor(Color.YELLOW)

                }
            }
        }

    }

    fun Ganador() {
        puntero.setTitle("Juego Finalizado:Hubo Empate")
        if(puntero.p1.puntos>puntero.p2.puntos && puntero.p1.puntos >puntero.p3.puntos && puntero.p1.puntos>puntero.p4.puntos)
        {
            puntero.setTitle("Juego Finalizado:Ganador [Jugador 1]")
            sleep(5000)
            puntero.j1.setTextColor(Color.YELLOW)
            puntero.j2.setTextColor(Color.BLACK)
            puntero.j3.setTextColor(Color.BLACK)
            puntero.j4.setTextColor(Color.BLACK)

            detener()

        }
        if(puntero.p2.puntos>puntero.p1.puntos && puntero.p2.puntos >puntero.p3.puntos && puntero.p2.puntos>puntero.p4.puntos)
        {puntero.setTitle("Juego Finalizado:Ganador [Jugador 2]")
            sleep(5000)
            puntero.j1.setTextColor(Color.BLACK)
            puntero.j2.setTextColor(Color.YELLOW)

            puntero.j3.setTextColor(Color.BLACK)
            puntero.j4.setTextColor(Color.BLACK)


            detener()
        }
        if(puntero.p3.puntos>puntero.p2.puntos && puntero.p3.puntos >puntero.p1.puntos && puntero.p3.puntos>puntero.p4.puntos)
        {puntero.setTitle("Juego Finalizado:Ganador [Jugador 3]")
            sleep(5000)
            puntero.j1.setTextColor(Color.BLACK)
            puntero.j2.setTextColor(Color.BLACK)
            puntero.j3.setTextColor(Color.YELLOW)

            puntero.j4.setTextColor(Color.BLACK)

            detener()

        }
        if(puntero.p4.puntos>puntero.p2.puntos && puntero.p4.puntos >puntero.p3.puntos && puntero.p4.puntos>puntero.p1.puntos)
        {puntero.setTitle("Juego Finalizado:Ganador [Jugador 4]")
            sleep(5000)
            puntero.j1.setTextColor(Color.BLACK)
            puntero.j2.setTextColor(Color.BLACK)
            puntero.j3.setTextColor(Color.BLACK)
            puntero.j4.setTextColor(Color.YELLOW)

            detener()


        }

    }
    fun TirarDados(){

        sleep(1000)

        contdado1= Random.nextInt(1,6)
        puntero.dado1.setText(contdado1.toString())

        contdado2= Random.nextInt(1,6)
        puntero.dado2.setText(contdado2.toString())


    }

    fun estaIniciado(): Boolean {
        return iniciado
    }



    fun detener() {

        puntero.resul.setText("Resultado anterior: \n" +
                " J1: ${puntero.p1.puntos} \n" +
                " J2: ${puntero.p2.puntos} \n" +
                " J3: ${puntero.p3.puntos} \n" +
                " J4: ${puntero.p4.puntos} \n")

        puntero.p1.reset()
        puntero.p2.reset()
        puntero.p3.reset()
        puntero.p4.reset()

         turno =0
        contdado1=0
        contdado2=0

        puntero.txt1.setText("0")
        puntero.txt2.setText("0")
        puntero.txt3.setText("0")
        puntero.txt4.setText("0")
        puntero.dado1.setText("0")
        puntero.dado2.setText("0")

    }


    fun Reiniciar() {
        Ganador()
        tirando=1
    }

}