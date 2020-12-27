object Solution {
    /* FROM https://programmers.co.kr/learn/courses/30/lessons/42748
     * 
     * Note from https://stackoverflow.com/questions/6928327/when-should-i-choose-vector-in-scala
     *  : Default is to use Vector rather than List
     * 
     * (1) Vector.slice(inclusiveIndex, exclusiveIndex)
     */
	
    def solution(array: Vector[Int], commands: Vector[Vector[Int]]): Vector[Int] = {
        val subArrays = commands.map(x => array.slice(x(0)-1, x(1))).map(x => x.sorted) // (1)
        (0 until commands.length).map(x => subArrays(x)(commands(x)(2)-1)).toVector
    }
}
