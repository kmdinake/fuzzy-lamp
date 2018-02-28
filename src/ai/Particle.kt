package ai

data class Particle(val id: Int, val dim: Int) { // shorthand syntax for declaring properties and initializing the properties from primary constructor
    var x: DoubleArray = DoubleArray(this.dim)
    var v: DoubleArray = DoubleArray(this.dim)
    var y: DoubleArray = DoubleArray(this.dim)

    fun stringifyPosbest() {
        print("Personal Best for Particle ${this.id} (y) => [")
        (0.until(this.dim)).forEach { j ->
            print(" ${this.y[j]} ")
        }
        println("]")
    }

    fun stringifyPos(){
        print("Position for Particle ${this.id} (x) => [")
        (0.until(this.dim)).forEach { j ->
            print(" ${this.x[j]} ")
        }
        println("]")
    }

    fun stringifyVel(){
        print("Velocity for Particle ${this.id} (v) => [")
        (0.until(this.dim)).forEach { j ->
            print(" ${this.v[j]} ")
        }
        println("]")
    }
}