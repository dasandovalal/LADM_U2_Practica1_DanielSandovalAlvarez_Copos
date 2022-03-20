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
        for (copo in copos) {
            copo.mover()
            copo.pintar(c)
        }
    }

}