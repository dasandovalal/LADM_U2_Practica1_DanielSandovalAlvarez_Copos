package mx.tecnm.ladm_u2_practica1_danielsandovalalvarez_copos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Copo(l:Lienzo){
    var x = 0f
    var y = 0f
    val ancho = 2640
    val largo = 1540
    var movY = 0f

    init {
        x = rand(ancho)
        y = rand(largo)
        movY = rand(5)+1
    }

    private fun rand(hasta:Int) : Float{
        return Random.nextInt(hasta).toFloat()
    }

    fun mover(){
        y += movY
        if(y>largo)y=0f
    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color = Color.WHITE
        canvas.drawCircle(x,y,5f,p)
    }
}