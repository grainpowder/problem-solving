object Solution {
    /* FROM https://programmers.co.kr/learn/courses/30/lessons/42840
     *
     * (1) Vector.sortWith((element1:Type, element2:Type) => OrderingCondition)
     * (2) Vector.filter(filteringCondition) : _ is placeholder for each of its element
     */
 
    private val patterns = Vector((1 to 5).toVector,
                           	Vector(2,1,2,3,2,4,2,5),
                          	Vector(3,3,1,1,2,2,4,4,5,5))
    
    private def toInt(x:Boolean): Int = if (x) 1 else 0
    
    def solution(answers: Vector[Int]): Vector[Int] = {
        
        def countCorrect(index:Int, scoreAcc:Vector[Int]): Vector[Int] = {
            if (index == answers.length) scoreAcc
            else {
                val mark = patterns.map(x => toInt(x(index % x.length) == answers(index)))
                countCorrect(index+1, (0 to 2).toVector.map(x => mark(x) + scoreAcc(x)))
            }
        }
        
        val nCorrects = countCorrect(0, Vector(0,0,0))
        val result = (0 to 2).
            map(x => Vector(x+1, nCorrects(x))).
            sortWith((p1:Vector[Int], p2:Vector[Int]) => p1(1) > p2(1)). // (1) Also true: sortWith(_(1) > _(1))
            filter(_(1) == nCorrects.max). // (2)
            map(x => x(0)).sorted
        
        result.toVector
    }
}
