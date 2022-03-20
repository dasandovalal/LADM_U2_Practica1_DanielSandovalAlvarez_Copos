package mx.tecnm.ladm_u2_practica1_danielsandovalalvarez_copos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Copo(l:Lienzo){
    val l = l
    var x = 0f
    var y = 0f
    val ancho = 2640
    val largo = 1540
    //var movX = 0f
    var movY = 0f
    var color = Color.BLACK

    init {
        x = rand(ancho)
        y = rand(largo)
        movY = rand(6)+2
        color = Color.WHITE
    }

    private fun rand(hasta:Int) : Float{
        return Random.nextInt(hasta).toFloat()
    }

    fun mover(){
        y += movY
        if(y <0 || y>largo){
            y=1540-y
        }
    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color = color
        canvas.drawCircle(x,y,5f,p)
    }
}