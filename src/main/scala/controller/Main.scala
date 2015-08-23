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
  val d = "D"
  val g = "G"

//  var graph = model.Graph()
//  graph.addEdge(s, a)
//  graph.addEdge(s, c)
//  graph.addEdge(a, b)
//  graph.addEdge(a, g)
//  graph.addEdge(c, b)
//  graph.addEdge(b, g)
//  def strategy(fringe: Seq[Path]) = Strategies.dfs(fringe)

//  var graph = model.Graph()
//  graph.addEdge(s, b)
//  graph.addEdge(b, a)
//  graph.addEdge(b, c)
//  graph.addEdge(b, g)
//  graph.addEdge(a, c)
//  graph.addEdge(c, g)
//  def strategy(fringe: Seq[Path]) = Strategies.bfs(fringe)

//  var graph = model.Graph()
//  graph.addEdge(s, b)
//  graph.addEdge(s, c)
//  graph.addEdge(b, c)
//  graph.addEdge(c, a)
//  graph.addEdge(c, g)
//  def strategy(fringe: Seq[Path]) = Strategies.bfs(fringe)

  var graph = model.Graph()
  graph.addEdge(s, a, 2, 3)
  graph.addEdge(s, b, 1, 3)
  graph.addEdge(a, b, 1, 3)
  graph.addEdge(a, c, 3, 1)
  graph.addEdge(a, d, 1, 2)
  graph.addEdge(b, d, 5, 2)
  graph.addEdge(b, g, 10)
  graph.addEdge(c, g, 7)
  graph.addEdge(d, g, 4)
  def strategy(fringe: Seq[Path]) = Strategies.a_*(fringe)

  Search(Problem(graph, s, (node: Node) => node.getData == g), strategy)

  def show(message: Option[Path]): Unit = {
    if (message.isEmpty) {
      println("No solution found.")
    }
    else {
      message.foreach(println(_))
    }
  }
}
