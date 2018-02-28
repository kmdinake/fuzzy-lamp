package ai

class FeasiblePSO : PSO() {
    override fun updatePersonalAndGlobalBestPositions(p: Particle) {
        val feasible = p.x.indices.none({ p.x[it] < this.xMin || p.x[it] > this.xMax })
        if (feasible) {
            if (foo.exec(p.x) < foo.exec(p.y)){
                p.y = p.x
            }
            if (foo.exec(p.y) < foo.exec(this.yBest)) {
                this.yBest = p.y
            }
        }
    }
}