package io.shiftleft.queryprimitives.steps.types.expressions.generalizations

import gremlin.scala._
import io.shiftleft.codepropertygraph.generated.{EdgeTypes, NodeKeyNames, NodeTypes}
import io.shiftleft.codepropertygraph.generated.nodes
import io.shiftleft.queryprimitives.steps.CpgSteps
import java.lang.{Long => JLong}
import shapeless.HList

class Declaration[Labels <: HList](raw: GremlinScala[Vertex])
    extends CpgSteps[nodes.Declaration, Labels](raw)(Declaration.marshaller)
    with DeclarationBase[nodes.Declaration, Labels]

object Declaration {
  val marshaller: Marshallable[nodes.Declaration] = new Marshallable[nodes.Declaration] {
    override def toCC(element: Element) =
      new nodes.Declaration {
        override def underlying: Vertex = element.asInstanceOf[Vertex]
        override def name: String = element.value[String](NodeKeyNames.NAME)

        // not really needed AFAIK
        override def productArity: Int = ???
        override def productElement(n: Int): Any = ???
        override def canEqual(that: Any): Boolean = ???
      }

    // not really needed AFAIK
    override def fromCC(cc: nodes.Declaration) = ???
  }
}

trait DeclarationBase[NodeType <: nodes.Declaration, Labels <: HList] {
  this: CpgSteps[NodeType, Labels] =>
  // TODO: steps for Declarations go here
}
