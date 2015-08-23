package controller

import model.{Path, Node, Edge}
import search.{Strategies, Problem, Search}

/**
 * Created by mesfinmebrate on 09/08/15.
 */
object Main extends App {

//  val s = "S"
//  val a = "A"
//  val b = "B"
//  val c = "C"
//  val d = "D"
//  val g = "G"

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

//  var graph = model.Graph()
//  graph.addEdge(s, a, 2, 3)
//  graph.addEdge(s, b, 1, 3)
//  graph.addEdge(a, b, 1, 3)
//  graph.addEdge(a, c, 3, 1)
//  graph.addEdge(a, d, 1, 2)
//  graph.addEdge(b, d, 5, 2)
//  graph.addEdge(b, g, 10)
//  graph.addEdge(c, g, 7)
//  graph.addEdge(d, g, 4)
//  def strategy(fringe: Seq[Path]) = Strategies.a_*(fringe)

  val Arad = "Arad"
  val Zerind = "Zerind"
  val Oradea = "Oradea"
  val Sibiu = "Sibiu"
  val Timisoara = "Timisoara"
  val Lugoj = "Lugoj"
  val Mehadia = "Mehadia"
  val Dobreta = "Dobreta"
  val Craiora = "Craiora"
  val Rimnica_Vilcea = "Rimnica_Vilcea"
  val Fagaras = "Fagaras"
  val Pitesti = "Pitesti"
  val Bucharest = "Bucharest"
  val Giurgiu = "Giurgiu"
  val Urziceni = "Urziceni"
  val Hirsova = "Hirsova"
  val Eforie = "Eforie"
  val Vaslui = "Vaslui"
  val Iasi = "Iasi"
  val Neamt = "Neamt"

  var graph = model.Graph()
  graph.addEdge(Arad, Zerind, 75)
  graph.addEdge(Arad, Sibiu, 140)
  graph.addEdge(Arad, Timisoara, 118)
  graph.addEdge(Zerind, Oradea, 71)
  graph.addEdge(Oradea, Sibiu, 151)
  graph.addEdge(Sibiu, Fagaras, 99)
  graph.addEdge(Sibiu, Rimnica_Vilcea, 80)
  graph.addEdge(Timisoara, Lugoj, 111)
  graph.addEdge(Lugoj, Mehadia, 70)
  graph.addEdge(Mehadia, Dobreta, 75)
  graph.addEdge(Dobreta, Craiora, 120)
  graph.addEdge(Craiora, Rimnica_Vilcea, 146)
  graph.addEdge(Craiora, Pitesti, 138)
  graph.addEdge(Rimnica_Vilcea, Pitesti, 97)
  graph.addEdge(Pitesti, Bucharest, 101)
  graph.addEdge(Fagaras, Bucharest, 211)
  graph.addEdge(Bucharest, Giurgiu, 90)
  graph.addEdge(Bucharest, Urziceni, 85)
  graph.addEdge(Urziceni, Vaslui, 142)
  graph.addEdge(Urziceni, Hirsova, 98)
  graph.addEdge(Hirsova, Eforie, 86)
  graph.addEdge(Vaslui, Iasi, 92)
  graph.addEdge(Iasi, Neamt, 87)
  def strategy(fringe: Seq[Path]) = Strategies.ucs(fringe)

  Search(Problem(graph, Arad, (node: Node) => node.getData == Bucharest), strategy)

  def show(message: Option[Path]): Unit = {
    if (message.isEmpty) {
      println("No solution found.")
    }
    else {
      message.foreach(println(_))
    }
  }
}
