package search

import model.{Node, Graph}

/**
 * Created by mesfinmebrate on 09/08/15.
 */
case class Problem (states: Graph, initialState: String, goalTest: (Node) => Boolean)