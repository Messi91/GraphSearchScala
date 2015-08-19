package model

/**
 * Created by mesfinmebrate on 09/08/15.
 */
case class Edge (node1: Node, node2: Node, cost: Int) {

  override def toString: String = {
    node1.toString + "<-->" + node2.toString
  }
}

object Edge {

  def apply(data1: String, data2: String, cost: Int): Edge = {
    Edge(Node(data1), Node(data2), cost)
  }
}