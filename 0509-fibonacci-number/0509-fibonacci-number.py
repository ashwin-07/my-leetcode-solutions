class Solution:
    def fib(self, n: int) -> int:
        if (n == 0):
            return 0
        prev1, prev2, fibSum = 1, 0, 1
        for i in range(n-1):
            fibSum = prev1 + prev2
            prev2 = prev1
            prev1 = fibSum
        return fibSum