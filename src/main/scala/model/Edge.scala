package model

/**
 * Created by mesfinmebrate on 09/08/15.
 */
case class Edge (node1: Node, node2: Node, cost: Int) {

  override def toString: String = {
    if (node1 == node2) {
      node1.toString
    }
    else {
      node1.toString + "<-->" + node2.toString
    }
  }
}

object Edge {

  def apply(data1: String, data2: String, cost: Int): Edge = {
    Edge(Node(data1), Node(data2), cost)
  }

  def apply(node: Node): Edge = {
    Edge(node, node, 0)
  }
}