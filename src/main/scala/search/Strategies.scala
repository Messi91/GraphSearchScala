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
    fringe.last
  }
}
