package model

/**
 * Created by mesfinmebrate on 09/08/15.
 */
case class Graph (var nodes: Map[String, Node], var edges: Map[(String, String), Edge]) {

  def addEdge(data1: String, data2: String, cost: Int = 0): Unit = {
    val node1 = if (nodes.contains(data1)) nodes.get(data1).get else Node(data1)
    val node2 = if (nodes.contains(data2)) nodes.get(data2).get else Node(data2)
    nodes = nodes.+((data1, node1))
    nodes = nodes.+((data2, node2))
    nodes.get(data1).foreach(_.addVertex(node2))
    nodes.get(data2).foreach(_.addVertex(node1))
    edges = edges.+(((data1, data2), Edge(nodes.get(data1).get, nodes.get(data2).get, 0)))
  }

  def getEdge(data1: String, data2: String): Option[Edge] = {
    edges.get((data1, data2))
  }

  def getNode(data: String): Option[Node] = {
    nodes.get(data)
  }
}

object Graph {

  def apply(): Graph = {
    Graph(Map.empty, Map.empty)
  }
}