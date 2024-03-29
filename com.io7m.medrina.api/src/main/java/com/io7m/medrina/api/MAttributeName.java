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

package com.io7m.medrina.api;

import com.io7m.lanark.core.RDottedName;

import java.util.Comparator;
import java.util.Objects;

/**
 * The name of an attribute.
 *
 * @param value The name
 */

public record MAttributeName(RDottedName value)
  implements Comparable<MAttributeName>
{
  /**
   * The name of an attribute.
   *
   * @param value The name
   */

  public MAttributeName
  {
    Objects.requireNonNull(value, "value");
  }

  /**
   * Construct a name.
   *
   * @param name The name string
   *
   * @return The name
   */

  public static MAttributeName of(
    final String name)
  {
    return new MAttributeName(new RDottedName(name));
  }

  @Override
  public int compareTo(
    final MAttributeName other)
  {
    return Comparator.comparing(MAttributeName::value).compare(this, other);
  }
}
