package com.raquo.domtypes.fixtures.builders

import com.raquo.domtypes.fixtures.builders.ExampleReflectedHtmlAttrBuilder.ReflectedAttr
import com.raquo.domtypes.fixtures.keys.Prop
import com.raquo.domtypes.generic.builders.ReflectedHtmlAttrBuilder
import com.raquo.domtypes.generic.codecs.Codec

/** Example implementation of [[ReflectedHtmlAttrBuilder]], using our own [[Prop]] class.
  *
  * If you are using this implementation, create an implicit value class
  * around [[Prop]] – there you can e.g. implement the `:=` method.
  *
  * Alternatively, you can use [[ReflectedPropBuilder]], or implement your own
  * [[ReflectedHtmlAttrBuilder]] that uses either a subclass of either [[Prop]] or
  * [[com.raquo.domtypes.fixtures.keys.HtmlAttr]], or a completely unrelated type of your own.
  */
trait ExampleReflectedHtmlAttrBuilder extends ReflectedHtmlAttrBuilder[ReflectedAttr] {

  override protected def reflectedAttr[V, DomPropV](
    attrKey: String,
    propKey: String,
    attrCodec: Codec[V, String],
    propCodec: Codec[V, DomPropV]
  ): Prop[V, DomPropV] = {
    // Note that we use `propKey` and `propCodec` params to build Prop, because it
    // represents a DOM property, not an HTML attribute. If you wanted a representation
    // of an HTML attribute instead, you would use `attrKey` and `attrCodec`.
    new Prop(propKey, propCodec)
  }
}

object ExampleReflectedHtmlAttrBuilder {

  type ReflectedAttr[V, DomV] = Prop[V, DomV]
}
