/*
 * Copyright © 2021 Mark Raynsford <code@io7m.com> https://www.io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

import com.io7m.medrina.parser.api.MPolicyParserFactoryType;
import com.io7m.medrina.parser.api.MPolicySerializerFactoryType;
import com.io7m.medrina.vanilla.MPolicyParsers;
import com.io7m.medrina.vanilla.MPolicySerializers;

/**
 * Mandatory Access Control (Vanilla implementation)
 */

module com.io7m.medrina.vanilla
{
  requires static org.osgi.annotation.bundle;
  requires static org.osgi.annotation.versioning;

  requires transitive com.io7m.medrina.parser.api;
  requires transitive com.io7m.anethum.common;

  requires com.io7m.jdeferthrow.core;
  requires com.io7m.jeucreader.core;
  requires com.io7m.jsx.core;
  requires com.io7m.jsx.parser.api;
  requires com.io7m.jsx.parser;
  requires com.io7m.jsx.prettyprint;
  requires com.io7m.junreachable.core;
  requires com.io7m.jxtrand.vanilla;
  requires org.slf4j;

  exports com.io7m.medrina.vanilla;

  provides MPolicyParserFactoryType
    with MPolicyParsers;
  provides MPolicySerializerFactoryType
    with MPolicySerializers;
}
