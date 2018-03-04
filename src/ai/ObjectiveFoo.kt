package ai

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
        // TODO(reason = "Griewank Foo Not Implemented -> f6")
        var mul = 1.0
        val sum = x.sumByDouble({ Math.pow(it, 2.0) })
        for (j in x.indices) {
            mul *= Math.cos(x[j] / Math.sqrt(j.toDouble()))
        }
        return 1 + (1.0 / 4000.0) * sum - mul
    }

    private fun f2 (x: DoubleArray): Double {
        //TODO(reason = "The Schaffer 6 Foo Not Implemented -> f15")
        var sum = 0.0
        var powerSum: Double
        var dividend: Double
        var divisor : Double
        (0.until(x.size)).forEach({ j ->
            powerSum = Math.pow(x[j], 2.0) + Math.pow(x[j + 1], 2.0)
            dividend = Math.pow(Math.sin(powerSum), 2.0) - 0.5
            divisor = Math.pow(1.0 + 0.001 * powerSum, 2.0)
            sum += (0.5 + dividend / divisor)
        })
        return sum
    }

    private fun f3 (x: DoubleArray): Double {
        //TODO(reason = "Vincent Foo Not Implemented -> f24")
        val neg = -1.0
        var sum = x.indices.sumByDouble { Math.sin(10.0 * Math.sqrt(x[it])) }
        sum += 1.0
        return neg * sum
    }

    private fun f4 (x: DoubleArray): Double {
        //TODO(reason = "Schwefel 1.2 Not Implemented -> f16")
        var sum = 0.0
        var innerSum: Double
        for (j in x.indices) {
            innerSum = 0.0
            (0.until(j)).forEach({ k ->
                innerSum += x[k]
            })
            sum += Math.pow(innerSum, 2.0)
        }
        return sum
    }

    private fun f5 (x: DoubleArray): Double {
        //TODO(reason = "Spherical Foo Not Implemented -> f22")
        val beta = -450.0
        val gamma = 10.0
        for (j in x.indices) {
            x[j] = x[j] - gamma
        }
        var sum = 0.0
        for (j in x.indices) {
            sum += Math.pow(x[j], 2.0)
        }
        sum += beta
        return sum
    }

    private fun f6 (x: DoubleArray): Double {
        //TODO(reason = "Michalewicz Not Implemented -> f8")
        val neg = -1.0
        val m = 10.0
        var sum = 0.0
        for (j in x.indices) {
            sum += Math.sin(x[j]) * Math.pow(Math.sin(j * Math.pow(x[j], 2.0) / Math.PI), 2.0 * m)
        }
        return sum * neg
    }

    private fun f7 (x: DoubleArray): Double {
        //TODO(reason = "Norwegian Foo Not Implemented -> f9")
        var mul = 1.0
        for (j in x.indices) {
            mul *= Math.cos(Math.PI * Math.pow(x[j], 3.0)) * ((99.0 + x[j]) / 100.0)
        }
        return mul
    }

    private fun f8 (x: DoubleArray): Double {
        //TODO(reason = "Weierstrass Foo Not Implemented -> f25")
        val a = 0.5
        val b = 3.0
        val nx = x.size
        var sum1 = 0.0
        var sum2 = 0.0
        var innerSum: Double
        for (j in x.indices) {
            innerSum = 0.0
            (1.until(21)).forEach({ i ->
                innerSum += (Math.pow(a, i.toDouble()) * Math.cos(2.0 * Math.PI * Math.pow(b, i.toDouble() * (x[j] + 0.5))))
            })
            sum1 += innerSum
        }
        (1.until(21)).forEach({ i ->
            sum2 += (Math.pow(a, i.toDouble()) * Math.cos(Math.PI * Math.pow(b, i.toDouble())))
        })
        return sum1 - (nx * sum2)
    }

    private fun f9 (x: DoubleArray): Double {
        //TODO(reason = "Schwefel 2.22 Foo Not Implemented -> f19")
        var max = Math.abs(Double.MIN_VALUE)
        for (j in x) {
            if (Math.abs(j) > max) {
                max = Math.abs(j)
            }
        }
        return max
    }

    private fun f10 (x: DoubleArray): Double {
        //TODO(reason = "Shubert Foo Not Implemented -> f21")
        var mul = 1.0
        for (j in x.indices) {
            var sum = 0.0
            (1.until(6)).forEach({ i ->
                sum += (i * Math.cos((i + 1.0) * x[j] + i))
            })
            mul *= sum
        }
        return mul
    }
}