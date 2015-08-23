package model

/**
 * Created by mesfinmebrate on 15/08/15.
 */
case class Path (edges: Seq[Edge]) {

  def :+(edge: Edge): Path = {
    Path(edges :+ edge)
  }

  def nodes: Seq[Node] = {
    lastNode.map(lastNode => edges.map(_.node1).:+(lastNode)).getOrElse(edges.map(_.node1))
  }

  def lastNode: Option[Node] = {
    edges.lastOption.map(_.node2)
  }
  
  def cost: Int = {
    edges.map(_.cost).sum + lastNode.map(_.getHeuristic).getOrElse(0)
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