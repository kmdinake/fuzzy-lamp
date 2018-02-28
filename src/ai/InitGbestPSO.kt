package ai

class InitGbestPSO: PSO() {
    override fun updatePosition(p: Particle) {
        for (j in p.x.indices) {
            p.x[j] += p.v[j]
            if(p.x[j] < super.xMin || p.x[j] > super.xMax){
                p.x[j] = super.yBest[j]
            }
        }
    }
}