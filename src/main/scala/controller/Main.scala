package controller

import model.{Path, Node, Edge}
import search.{Strategies, Problem, Search}

/**
 * Created by mesfinmebrate on 09/08/15.
 */
object Main extends App {

  val s = "S"
  val a = "A"
  val b = "B"
  val c = "C"
  val g = "G"

  var graph = model.Graph.apply()
  graph.addEdge(s, a)
  graph.addEdge(s, c)
  graph.addEdge(a, b)
  graph.addEdge(a, g)
  graph.addEdge(c, b)
  graph.addEdge(b, g)

  show(Search(Problem(graph, s, (node: Node) => node.data == g), Strategies.dfs))

  def show(message: Option[Path]): Unit = {
    if (message.isEmpty) {
      println("No solution found.")
    }
    else {
      message.foreach(println(_))
    }
  }
}
