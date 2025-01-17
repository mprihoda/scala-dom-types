package com.raquo.domtypes.fixtures.keys

import com.raquo.domtypes.generic.codecs.Codec

/**
  * This class represents an HTML Element Attribute. Meaning the key that can be set, not the whole a key-value pair.
  *
  * @tparam V type of values that this Attribute can be set to
  */
class HtmlAttr[V] (override val name: String, val codec: Codec[V, String]) extends Key
