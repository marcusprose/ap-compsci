# Recursive Runtime
 
T = time as a function of n (number of elements)
 
T(n) = 2•T(n/2) + 5n.
5n comes from the different touches (reads and writes).
2n reads and 1n write to sort into new array.
1n read and 1n write to shift it back into the original array.

T(n/2) = 2•T(n/4) + 5(n/2)
T(n/4) = 2•T(n/8) + 5(n/4)
T(n/8) = 2•T(n/16) + 5(n/8)
 
Expand T(n):
2•T(n/2) + 5n
2(2T(n/4) + 5(n/2)) + 5n
4 • T(n/4) + 2 • 5n
 
4(2T(n/8) + 5(n/4)) + 2• 5n
8• T(n/8) + 3 • 5n
 
8(2T(n/16) + 5(n/8)) + 3• 5n
16 • T(n/16) + 4 • 5n
 
You can see that the relation between these expansions is logarithmic.
 
m • T(n/m) + log2m • 5n
 
The fastest would be if m = n. This is n• log2n.
m • T(n/m) + log2m • 5n
n • T(n/n) + log2n • 5n
n + n• log2n
 
