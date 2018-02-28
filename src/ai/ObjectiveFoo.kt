package ai

import kotlin.math.abs

class ObjectiveFoo {
    var fooType: String = ""

    fun exec(x: DoubleArray): Double {
        when (this.fooType) {
            "f0" -> {
                return this.f0(x)
            }
            "f1" -> {
                return this.f1(x)
            }
            "f2" -> {
                return this.f2(x)
            }
            "f3" -> {
                return this.f3(x)
            }
            "f4" -> {
                return this.f4(x)
            }
            "f5" -> {
                return this.f5(x)
            }
            "f6" -> {
                return this.f6(x)
            }
            "f7" -> {
                return this.f7(x)
            }
            "f8" -> {
                return this.f8(x)
            }
            "f9" -> {
                return this.f9(x)
            }
            "f10" -> {
                return this.f10(x)
            }
            else -> {
                return this.f0(x)
            }
        }
    }

    private fun f0 (x: DoubleArray): Double {
        return x.sum()
    }

    private fun f1 (x: DoubleArray): Double {
        // TODO(reason = "Absolute Value Foo Not Implemented")
        return x.indices.sumByDouble({ abs(x[it]) })
    }

    private fun f2 (x: DoubleArray): Double {
        //TODO(reason = "The Schwefel 2.22 Foo Not Implemented")
        var sum = 0.0
        var mul = 1.0
        for (j in x.indices) {
            sum += abs(x[j])
            mul *= abs(x[j])
        }
        return sum + mul
    }

    private fun f3 (x: DoubleArray): Double {
        //TODO(reason = "Vincent Foo Not Implemented")
        val neg = -1.0
        var sum = x.indices.sumByDouble { Math.sin(10.0 * Math.sqrt(x[it])) }
        sum += 1.0
        return neg * sum
    }

    private fun f4 (x: DoubleArray): Double {
        TODO(reason = "f4 Not Implemented")
    }

    private fun f5 (x: DoubleArray): Double {
        TODO(reason = "f5 Not Implemented")
    }

    private fun f6 (x: DoubleArray): Double {
        TODO(reason = "f6 Not Implemented")
    }

    private fun f7 (x: DoubleArray): Double {
        TODO(reason = "f7 Not Implemented")
    }

    private fun f8 (x: DoubleArray): Double {
        TODO(reason = "f8 Not Implemented")
    }

    private fun f9 (x: DoubleArray): Double {
        TODO(reason = "f9 Not Implemented")
    }

    private fun f10 (x: DoubleArray): Double {
        TODO(reason = "f10 Not Implemented")
    }
}