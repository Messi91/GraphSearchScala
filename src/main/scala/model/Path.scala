package model

/**
 * Created by mesfinmebrate on 15/08/15.
 */
case class Path (edges: Seq[Edge]) {

  def :+(edge: Edge): Path = {
    Path(edges :+ edge)
  }

  def getLastNode: Option[Node] = {
    edges.lastOption.map(_.node2)
  }

  override def toString: String = {
    if (edges.nonEmpty) {
      (edges.map(edge => edge.node2).toList).mkString("-")
    }
    else {
      "Empty path"
    }
  }
}

object Path {

  def apply(node: Node): Path = {
    Path(Seq(Edge(node)))
  }
}