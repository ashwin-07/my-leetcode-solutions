func arraySign(nums []int) int {
    var negativeNumCount int = 0
    for _, elem := range nums {
        if elem < 0 {
            negativeNumCount++
        } else if elem == 0 {
            return 0
        }
    }
    
    if negativeNumCount%2 == 0 {
        return 1
    } else {
        return -1
    }
}