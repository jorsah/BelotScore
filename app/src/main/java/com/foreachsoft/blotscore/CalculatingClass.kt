package com.foreachsoft.blotscore

class CalculatingClass(private val p1: Player, private val p2: Player) {

    fun win(b1:Boolean,b2:Boolean): Pair<Player, Player> {
        var x1: Int
        var x2: Int
        if (isBlue()) {
            x1 = p1.x + 25 + p1.z
            x2 = p2.z
        } else {
            x1 = 16 - p2.y!! + p1.z + p1.x
            x2 = p2.y!! + p2.z
        }
        if (b1){
            x1 = 16+p1.x*2+p1.z+p2.z
            x2 = 0
            if(b2){
                x1 += p1.x*2
                x2 = 0
            }
        }
        p1.t = x1
        p2.t = x2
        return Pair(p1, p2)
    }

    fun winB(b1:Boolean, b2: Boolean): Pair<Player, Player> {
        var x1: Int
        var x2: Int
        if (isBlue()) {
            x1 = 25 + p1.x * 2 + p1.z
            x2 = p2.z
        } else {
            x2 = p2.y!! + p2.z
            x1 = 16 - p2.y!! + p1.x * 2 + p1.z
        }
        if (b1){
            x1 = 16+p1.x*3+p1.z+p2.z
            x2 = 0
            if(b2){
                x1 += p1.x*2
                x2 = 0
            }
        }
        p1.t = x1
        p2.t = x2
        return Pair(p1, p2)
    }

    fun defLoseScore(b1:Boolean,b2:Boolean): Pair<Player, Player> {
        p1.t = 0
        p2.t = 16 + p1.x + p1.z + p2.z
        if (b1){
            p2.t = 16+p1.x*2+p1.z+p2.z
            p1.t = 0
            if(b2){
                p2.t += p1.x*2
                p1.t = 0
            }
        }
        return Pair(p1, p2)
    }

    fun defBLoseScore(b1:Boolean,b2:Boolean): Pair<Player, Player> {
        p2.t = p1.x * 2 + p1.z + p2.z + 16
        p1.t = 0
        if (b1){
            p2.t = 16+p1.x*3+p1.z+p2.z
            p1.t = 0
            if(b2){
                p2.t += p1.x*2
                p1.t = 0
            }
        }
        return Pair(p1, p2)
    }

    fun isLose(): Boolean {
        return if (p2.y != null) 16 - p2.y!! + p1.z < p1.x
        else 16 + p1.z < p1.x
    }

    private fun isBlue(): Boolean {
        return p2.y == null
    }

}
