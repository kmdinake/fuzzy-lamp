# fuzzy-lamp
Boundary Constrained PSO

# COS 710 - Assignment 1: PSO

## Overview
For this assignment you will implement and analyze some boundary constraint handling mechanisms, and some variations to them. As part of the study, you will also investigate how performance under these boundary constraints is affected for larger dimensions. ``` Note: When you want to determine if one approach is better than another, the outcome of such a comparison should be based on a formal statistical test, such as the Mann-Whitney U test.```


For all the implementations, choose a global PSO, where the global best position is selected as the best personal
best position from the first iteration. That is, use a memory based approach. ``` Note: This may refer to a Star Topology for the PSO. In the sense that, the neighbourhood best is the same for all neighbourhoods, thus, the global best will just be y'(j) instead of y'(i)(j).```

You can also simply implement a synchronous update strategy. ``` Note: This means use the two for loops inside the repeat loop, i.e. one for updating personal best, then the other for global best.```

## Boundary Constraint Mechanisms
1. Update the personal best positions only if the new particle position is better than its current personal best position, and if the new particle position is feasible. That is, a new particle position can not become a personal best position if it violates boundary constraints.

2. Clamping approach: If a particle violates a boundary constraint in a specific dimension, then clamp the corresponding decision variable at the boundary value. That is, if x ij (t + 1) < x min,j then x ij (t + 1) = x min,j , or if x ij (t + 1) > x max,j then x ij (t + 1) = x max,j .

3. Per element reinitialization: For any decision variable of any particle that violates a boundary constraint, reinitialize that decision variable to a random position that satisfies the boundary constraints. That is, if x ij (t + 1) < x min,j or x ij (t + 1) > x max,j , then x ij (t + 1) ∼ U (x min,j , x max,j ).

4. Per element reinitialization and setting velocity to zero: Adapt the per element reinitialization approach above to also set the velocity of the decision variable that violates a boundary constraint to zero. The corresponding decision variable’s new position will therefore not be influenced by the momentum term.

5. Initialize to personal best position: Initialize the boundary violating decision variable to the corresponding personal best position. That is, if x ij (t + 1) violates a baoundary constraint, then x ij (t + 1) = y ij (t).

6. Initialize to personal best position and set velocity to zero: Adapt the intialize to personal best position strategy above to also set the corresponding velocity to 0.

7. Initialize to global best position: As for the above, but x ij (t + 1) = ŷ j (t) for the boundary violating decision variable.

8. Initialize to global best position and set velocity to zero: Adapt the intialize to global best position strategy to also set the corresponding velocity to 0.

9. Reverse velocity: The velocity of the bounadry violating decision variable is simply reversed while that decision variable violates the boundary constraint.

10. Set the bounadry violating decision variable to an arithmetic average of the corresponding personal best and global best position. That is, x ij (t + 1) = αy ij (t) + (1 − α)ŷ j (t), where α ∼ U (0, 1) (randomly selected in the range (0, 1)).

11. The above will earn you at most 85% depending on the quality of your report. In order to increase your mark beyond 85%, you can implement any other boundary handling mechanism(s) that you find in the literature.


# Questions to answer in the report
• Which boundary constraint mechanism results in best performance with reference to solution accuracy?

• Which boundary constraint mechanism results in the highest success rate?

• Which boundary constraint mechanism is the most efficient in terms of computational effort to reach certain accuracy levels?

• Which boundary constraint mechanism is the most scalable?

• Where appropriate, which boundary constraint mechanism wastes the least amount of search effort outside of the feasible region as defined by the boundary constraints?

# Reminder
Check the assignment pdf document on the structure of the report.
