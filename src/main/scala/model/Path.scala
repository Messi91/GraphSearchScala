package model

/**
 * Created by mesfinmebrate on 15/08/15.
 */
case class Path (start: Node, edges: Seq[Edge]) {

  def :+(edge: Edge): Path = {
    Path(start, edges :+ edge)
  }

  def last: Node = {
    if (edges.isEmpty) {
      start
    }
    else {
      edges.last.node2
    }
  }

  override def toString: String = {
    if (edges.nonEmpty) {
      (List(start) ::: (edges.map(edge => edge.node2).toList)).mkString("-")
    }
    else {
      "Empty path"
    }
  }
}

object Path {

  def apply(edges: Seq[Edge]): Path = {
    Path(edges.head.node1, edges.tail)
  }
}