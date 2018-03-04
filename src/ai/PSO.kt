package ai

import java.util.Random

open class PSO {
    var numberOfParticles: Int = 0
    var numberOfDimensions: Int = 0
    var numberOfEpochs: Int = 0
    protected var yBest: DoubleArray = DoubleArray(0)
    protected var xMin: Double = Double.MIN_VALUE // default
    protected var xMax: Double = Double.MAX_VALUE // default
    private var particles: MutableList<Particle> = mutableListOf<Particle>()
    protected val foo: ObjectiveFoo = ObjectiveFoo()
    private val w: Double = 0.729844
    private val c1: Double = 1.49618
    private val c2: Double = 1.49618
    private var r1: DoubleArray = DoubleArray(0)
    private var r2: DoubleArray = DoubleArray(0)

    fun initialize(fooType: String){
        this.particles = mutableListOf()
        this.foo.fooType = fooType
        when (fooType) {
            "f0" -> {
                this.xMin = 0.0
                this.xMax = 1.0
                println("Using Objective Function => f0")
            }
            "f1" -> {
                this.xMin = -600.0
                this.xMax = 600.0
                println("Using Objective Function => f6")
            }
            "f2" -> {
                this.xMin = -100.0
                this.xMax = 100.0
                println("Using Objective Function => f15")
            }
            "f3" -> {
                this.xMin = 0.25
                this.xMax = 10.0
                println("Using Objective Function => f24")
            }
            "f4" -> {
                this.xMin = -100.0
                this.xMax = 100.0
                println("Using Objective Function => f16")
            }
            "f5" -> {
                this.xMin = -5.12
                this.xMax = 5.12
                println("Using Objective Function => f22")
            }
            "f6" -> {
                this.xMin = 0.0
                this.xMax = Math.PI
            }
            "f7" -> {
                this.xMin = -1.1
                this.xMax = 1.1
            }
            "f8" -> {
                this.xMin = -0.5
                this.xMax = 0.5
            }
            "f9" -> {
                this.xMin = -100.0
                this.xMax = 100.0
            }
            "f10" -> {
                this.xMin = -10.0
                this.xMax = 10.0
            }
            else -> {
                this.xMin = 0.0
                this.xMax = 0.0
            }
        }
    }

    fun optimize() {
        //TODO("Implement the standard synchronous Star topological PSO a.k.a. gbest PSO")
        createSwarm()
        println("=================> Optimizing Swarm <=================")
        (0.until(this.numberOfEpochs)).forEach { i ->
            //println("Running Epoch $i ...")
            this.particles.forEach { p ->
                updatePersonalAndGlobalBestPositions(p)
            }
            this.particles.forEach { p ->
                updateVelocity(p)
                updatePosition(p)
            }
            //printResults()
            randomizeRs()
        }
    }

    fun printResults(){
        println("=================> Printing Swarm Results <=================")
        for (p in this.particles){
            p.stringifyPosbest()
        }
        print("PSO Best: [")
        for (j in this.yBest.indices) {
            print(" ${this.yBest[j]} ")
        }
        println("]")
    }

    protected fun uniformDist(min: Double, max: Double): Double {
        return Random().nextDouble() * (max - min) + min
    }

    private fun randomizeRs() {
        (0.until(this.numberOfDimensions)).forEach { i ->
            this.r1[i] = uniformDist(0.0, 1.0)
            this.r2[i] = uniformDist(0.0, 1.0)
        }
    }

    protected open fun createSwarm() {
        println("=================> Initializing Swarm <=================")
        this.r1 = DoubleArray(this.numberOfDimensions)
        this.r2 = DoubleArray(this.numberOfDimensions)
        this.yBest = DoubleArray(this.numberOfDimensions)

        (0.until(this.numberOfParticles)).forEach { i ->
            val p = Particle(i, this.numberOfDimensions)
            for (j in p.x.indices) {
                p.x[j] = uniformDist(this.xMin, this.xMax)
                p.y[j] = p.x[j] // y(i)(j)(0) = x(i)(j)(0)
            }
            //p.stringifyPos()
            //p.stringifyVel()
            //p.stringifyPosbest()
            this.particles.add(p.id, p)
        }
        println("${this.particles.size} particles have been initialized.")
        randomizeRs()
    }

    protected open fun updatePersonalAndGlobalBestPositions(p: Particle) {
        //TODO("Implement the objective function required to determine the particle's best and neighbourhood's best values")
        if (foo.exec(p.x) < foo.exec(p.y)){
            p.y = p.x
        }
        if (foo.exec(p.y) < foo.exec(this.yBest)) {
            this.yBest = p.y
        }
    }

    protected open fun updateVelocity(p: Particle) {
        //TODO("Update and return the velocity of a particle")
        for (j in p.v.indices) {
            val cognitiveComponent = (this.c1 * this.r1[j]) * (p.y[j] - p.x[j])
            val socialComponent = (this.c2 * this.r2[j]) * (this.yBest[j] - p.x[j]) // yHat here is the global best position, i.e y^(t)
            p.v[j] += ((this.w * p.v[j]) + cognitiveComponent + socialComponent)
        }
    }

    protected open fun updatePosition(p: Particle){
        //TODO("Update and return the position of a particle")
        for (j in p.x.indices) {
            p.x[j] += p.v[j]
        }
    }
}

