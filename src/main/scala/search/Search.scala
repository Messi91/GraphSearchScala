package search

import model._

/**
 * Created by mesfinmebrate on 09/08/15.
 */
object Search {

  def apply(problem: Problem, strategy: (Seq[Path]) => Path): Option[Path] = {

    var closed: Set[Node] = Set.empty
    var fringe: Seq[Path] = insert(Node(problem.initialState), Seq.empty, problem)
    var counter = 1

    while (fringe.size > 0) {
      val path = getNext(fringe, strategy)
      val nodeOption = path.lastNode

      if (nodeOption.map(goalTest(problem, _)).getOrElse(false)) {
        println(s"Step ${counter}: Expand ${path} (${path.cost}), finding the goal.")
        return Some(path)
      }

      if (!nodeOption.map(node => closed.contains(node)).getOrElse(false)) {
        closed = nodeOption.map(closed + _).getOrElse(closed)
      }

      for (childNode <- nodeOption.map(expand(_, problem)).getOrElse(Seq.empty)) {
        fringe = insert(nodeOption.get, childNode, path, fringe, problem)
      }
      fringe = removePath(fringe, path)
      fringe = removeClosed(fringe, closed)
      println(s"Step ${counter}: Expand ${path}")
      println(s"Fringe: ${fringe.map(path => s"${path.toString} (${path.cost})").mkString(", ")}")
      println(s"Closed set: ${closed.mkString(", ")}\n")
      counter += 1
    }

    None
  }

  def insert(node: Node, fringe: Seq[Path], problem: Problem): Seq[Path] = {
    problem.states.getNode(node.getData).map(retrieved => addPathToFringe(Path(retrieved), fringe)).getOrElse(fringe)
  }

  def insert(node1: Node, node2: Node, path: Path, fringe: Seq[Path], problem: Problem): Seq[Path] = {
    addPathToFringe(problem.states.getEdge(node1.getData, node2.getData).map(edge => path :+ edge).getOrElse(Path(Seq.empty)), fringe)
  }

  // Should take a list of paths and return the latest addition to the path provided by the strategy
  def getNext(fringe: Seq[Path], strategy: (Seq[Path]) => Path): Path = {
    strategy(fringe)
  }

  def removePath(sequence: Seq[Path], path: Path): Seq[Path] = {
    sequence.filterNot(_.toString == path.toString)
  }

  def removeClosed(sequence: Seq[Path], closed: Set[Node]): Seq[Path] = {
    sequence.filterNot(_.nodes.map(node => closed.contains(node))
      .fold(true){(result, statement) =>
          result && statement
      }
    )
  }

  def goalTest(problem: Problem, node: Node): Boolean = {
    problem.goalTest(node)
  }

  // Should take a node and return a list of edges
  def expand(node: Node, problem: Problem): Seq[Node] = {
//    println(s"expand(node = ${node}) = node.vertices = " + node.vertices)
    problem.states.getNode(node.getData).map(_.vertices.values.toSeq).getOrElse(Seq.empty)
  }

  def addPathToFringe(path: Path, fringe: Seq[Path]): Seq[Path] = {
    if (path.edges.nonEmpty) List(fringe.toList, List(path)).flatten.toSeq else fringe
  }
}