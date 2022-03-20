package mx.tecnm.ladm_u2_practica1_danielsandovalalvarez_copos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Lienzo(este:MainActivity):View(este) {
    val este = este
    val copos = Array<Copo>(300, { Copo(this) })
    var fondo = Color.BLACK

    val corutina = GlobalScope.launch {
        while (true) {
            este.runOnUiThread {
                invalidate()
            }
            delay(20L)
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        c.drawColor(fondo)

        //MONTAÑA IZQUIERDA
        p.style = Paint.Style.FILL
        p.color = Color.rgb(185,230,187)
        c.drawOval(-500f,749f,1450f,2700f,p)
        p.style = Paint.Style.STROKE
        p.strokeWidth = 10f
        p.color = Color.rgb(106,106,106)
        c.drawOval(-500f,749f,1450f,2700f,p)

        //MONTAÑA DERECHA
        p.style = Paint.Style.FILL
        p.color = Color.rgb(185,230,187)
        c.drawOval(1200f,600f,3000f,1200f,p)
        p.style = Paint.Style.STROKE
        p.strokeWidth = 10f
        p.color = Color.rgb(106,106,106)
        c.drawOval(1200f,600f,3000f,1200f,p)

        //MONTAÑA CENTRO
        p.style = Paint.Style.FILL
        p.color = Color.rgb(185,230,187)
        c.drawOval(400f,549f,2200f,2000f,p)
        p.style = Paint.Style.STROKE
        p.strokeWidth = 10f
        p.color = Color.rgb(106,106,106)
        c.drawOval(400f,549f,2200f,2000f,p)

        for (copo in copos) {
            copo.mover()
            copo.pintar(c)
        }



    }

}