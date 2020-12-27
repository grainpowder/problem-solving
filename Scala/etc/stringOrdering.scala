object Solution {
    /* FROM https://programmers.co.kr/learn/courses/30/lessons/12915
     *
     * (1) string.sortBy(element => (priority1, priority2, ...))
     */

    def solution(strings: Vector[String], n: Int): Vector[String] = {
        strings.sortBy(string => (string(n), string)) // (1)
    }
}
