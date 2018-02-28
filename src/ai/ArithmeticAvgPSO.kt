package ai

class ArithmeticAvgPSO: PSO() {
    override fun updatePosition(p: Particle) {
        for (j in p.x.indices) {
            p.x[j] += p.v[j]
            if(p.x[j] < super.xMin || p.x[j] > super.xMax){
                val alpha = super.uniformDist(0.0, 1.0)
                p.x[j] = (alpha * p.y[j]) + ((1 - alpha) * super.yBest[j])
            }
        }
    }
}