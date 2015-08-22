package search

import model.Path

/**
 * Created by mesfinmebrate on 16/08/15.
 */
object Strategies {

  def dfs(fringe: Seq[Path]): Path = {
    fringe.sortBy(_.toString).head
  }

  def bfs(fringe: Seq[Path]): Path = {
    fringe.sortBy(_.edges.size).head
  }

  def ucs(fringe: Seq[Path]): Path = {
    fringe.sortBy(_.edges.map(_.cost).sum).head
  }

  def a_*(fringe: Seq[Path]): Path = {
    fringe.sortBy(_.cost).head
  }
}
