package mx.edu.itt.ladm_u2_practica3_danielmora


class Jugador (){

    var puntos = 0

    fun acumularPuntos(p: Int){
        this.puntos += p
    }

    fun Puntos(): Int{
        return this.puntos
    }
    fun reset(){
        puntos=0
    }

}