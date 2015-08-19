package search

import model._

/**
 * Created by mesfinmebrate on 09/08/15.
 */
object Search {

  def apply(problem: Problem, strategy: (Seq[Path]) => Path): Option[Path] = {

    var closed: Set[String] = Set.empty
    var fringe: Seq[Path] = insert(Node(problem.initialState), Seq.empty, problem)

    while (fringe.size > 0) {
      val path = getNext(fringe, strategy)
      val nodeOption = path.getLastNode

      if (nodeOption.map(goalTest(problem, _)).getOrElse(false)) {
        return Some(path)
      }

      if (!nodeOption.map(node => closed.contains(node.data)).getOrElse(false)) {
        closed = nodeOption.map(closed + _.data).getOrElse(closed)
      }

      for (childNode <- nodeOption.map(expand(_, problem)).getOrElse(Seq.empty)) {
        fringe = insert(nodeOption.get, childNode, path, fringe, problem)
      }
      fringe = removePath(fringe, path)
      println("closed = " + closed)
      println("fringe = " + fringe)
      println("path = " + path)
      println("nodeOption = " + nodeOption + "\n")
    }

    None
  }

  def insert(node: Node, fringe: Seq[Path], problem: Problem): Seq[Path] = {
    problem.states.getNode(node.data).map(retrieved => List(fringe.toList, List(Path(retrieved))).flatten.toSeq).getOrElse(fringe)
  }

  def insert(node1: Node, node2: Node, path: Path, fringe: Seq[Path], problem: Problem): Seq[Path] = {
    fringe :+ problem.states.getEdge(node1.data, node2.data).map(edge => path :+ edge).getOrElse(Path(Seq.empty))
  }

  // Should take a list of paths and return the latest addition to the path provided by the strategy
  def getNext(fringe: Seq[Path], strategy: (Seq[Path]) => Path): Path = {
    strategy(fringe)
  }

  def removePath(sequence: Seq[Path], path: Path): Seq[Path] = {
    sequence.filterNot(_.toString == path.toString)
  }

  def goalTest(problem: Problem, node: Node): Boolean = {
    problem.goalTest(node)
  }

  // Should take a node and return a list of edges
  def expand(node: Node, problem: Problem): Seq[Node] = {
//    println(s"expand(node = ${node}) = node.vertices = " + node.vertices)
    problem.states.getNode(node.data).map(_.vertices.values.toSeq).getOrElse(Seq.empty)
  }
}