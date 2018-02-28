package ai

class InitGbestZeroVelPSO: PSO() {
    override fun updatePosition(p: Particle) {
        for (j in p.x.indices) {
            p.x[j] += p.v[j]
            if(p.x[j] < super.xMin || p.x[j] > super.xMax){
                p.x[j] = super.yBest[j]
                p.v[j] = 0.0
            }
        }
    }
}