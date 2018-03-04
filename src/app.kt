import ai.*

fun main(args: Array<String>){
    println("=================> Boundary Constrained PSO <=================")
    var userInput: String?
    var selectedPSOVariant: Int
    var numberOfEpochs: Int
    var numberOfParticles: Int
    var numberOfDimensions: Int

    do {
        displayPSOVariants()
        print("> ")
        userInput = readLine()
        selectedPSOVariant = userInput.toString().toInt()
        if (userInput == "" || selectedPSOVariant < 0 || selectedPSOVariant > 10){
            println("Invalid option.")
        } else {
            println("You selected option $selectedPSOVariant.")
        }
    } while (selectedPSOVariant < 0 || selectedPSOVariant > 10)

    do {
        println("How many particles should be in the swarm?")
        print("> ")
        userInput = readLine()
        numberOfParticles = userInput.toString().toInt()
        if (userInput == "" || numberOfParticles <= 0){
            println("Invalid option.")
        } else {
            println("Your swarm has $numberOfParticles particles.")
        }
    } while (numberOfParticles < 0)

    do {
        println("What is the dimensionality of the swarm?")
        print("> ")
        userInput = readLine()
        numberOfDimensions = userInput.toString().toInt()
        if (userInput == "" || numberOfDimensions <= 0){
            println("Invalid option.")
        } else {
            println("Space of R^n is where n = $numberOfDimensions.")
        }
    } while(numberOfDimensions < 0)

    do {
        println("How many epochs should the swarm run over?")
        print("> ")
        userInput = readLine()
        numberOfEpochs = userInput.toString().toInt()
        if (userInput == "" || numberOfEpochs <= 0){
            println("Invalid option.")
        } else {
            println("Swarm running over $numberOfEpochs epochs.")
        }
    } while (numberOfEpochs < 0)

    var pso: PSO? = null
    when (selectedPSOVariant) {
        0 -> pso = FeasiblePSO()
        1 -> pso = ClampingPSO()
        2 -> pso = ElemReinitPSO()
        3 -> pso = ElemReinitZeroVelPSO()
        4 -> pso = InitPbestPSO()
        5 -> pso = InitPbestZeroVelPSO()
        6 -> pso = InitGbestPSO()
        7 -> pso = InitGbestZeroVelPSO()
        8 -> pso = ReverseVelPSO()
        9 -> pso = ArithmeticAvgPSO()
        /*10 -> pso = "10"
        11 -> pso = "11"*/
    }
    if(pso != null){
        pso.numberOfDimensions = numberOfDimensions
        pso.numberOfEpochs = numberOfEpochs
        pso.numberOfParticles = numberOfParticles
        (0.until(50)).forEach {
            println("Run[$it]:")
            (0.until(11)).forEach { i ->
                pso.initialize("f$i")
                pso.optimize()
                pso.printResults()
            }
        }
    }
}

fun displayPSOVariants() {
    val variants = listOf(
            "Feasible particle position approach",
            "Clamping approach",
            "Per element reinitialization approach",
            "Per element reinitialization and set velocity to zero approach",
            "Initialize to personal best approach",
            "Initialize to personal best and set velocity to zero approach",
            "Initialize to global best position approach",
            "Initialize to global best position and set velocity to zero approach",
            "Reverse velocity approach",
            "Set boundary violation decision variable to an arithmetic average approach",
            "Literature approach"
    )
    for (index in variants.indices) {
        println("[$index]: ${variants[index]}")
    }
}
