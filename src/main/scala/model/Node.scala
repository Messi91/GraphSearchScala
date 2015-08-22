package model

/**
 * Created by mesfinmebrate on 09/08/15.
 */
case class Node (data: String, var vertices: Map[String, Node], heuristic: Int) {

  def addVertex(newVertex: Node): Unit = {
    if (!vertices.contains(newVertex.data)) {
      vertices = vertices.+((newVertex.data, newVertex))
    }
  }

  def getVertex(data: String): Option[Node] = {
    vertices.get(data)
  }

  override def toString: String = {
    data
  }
}

object Node {

  def apply(data: String, heuristic: Int = 0): Node = {
    Node(data, Map.empty, heuristic)
  }
}