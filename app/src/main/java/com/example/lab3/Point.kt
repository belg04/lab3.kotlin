package com.example.lab3

class Point(
    val position: Boolean,
    val height: Int,
    val speed: Int,
    val time: Int
) {
    fun getAltitude(): Int
    {

        if (position) {
            var result=height + speed*time - 10*(time * time / 2)
            if(result>0) return result
        }
        else {
            var result=height - speed*time - 10* (time * time / 2)
            if(result>0) return result
        }
        return 0
    }
}

