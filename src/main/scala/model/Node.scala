package model

/**
 * Created by mesfinmebrate on 09/08/15.
 */
class Node (data: String, var vertices: Map[String, Node], heuristic: Int) {

  def addVertex(newVertex: Node): Unit = {
    if (!vertices.contains(newVertex.getData)) {
      vertices = vertices.+((newVertex.getData, newVertex))
    }
  }

  def getData: String = {
    data
  }

  def getVertex(data: String): Option[Node] = {
    vertices.get(data)
  }

  def getHeuristic: Int = {
    heuristic
  }

  override def toString: String = {
    data
  }
}

object Node {

  def apply(data: String, heuristic: Int = 0): Node = {
    new Node(data, Map.empty, heuristic)
  }
}