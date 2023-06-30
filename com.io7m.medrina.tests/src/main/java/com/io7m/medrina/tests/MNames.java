/*
 * Copyright © 2023 Mark Raynsford <code@io7m.com> https://www.io7m.com
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


package com.io7m.medrina.tests;

import com.io7m.lanark.core.RDottedName;
import com.io7m.medrina.api.MActionName;
import com.io7m.medrina.api.MAttributeName;
import com.io7m.medrina.api.MAttributeValue;
import com.io7m.medrina.api.MRoleName;
import com.io7m.medrina.api.MRuleName;
import com.io7m.medrina.api.MTypeName;
import net.jqwik.api.Arbitraries;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class MNames
{
  @TestFactory
  public Stream<DynamicTest> testComparable()
  {
    return Stream.of(
      MActionName.class,
      MAttributeName.class,
      MAttributeValue.class,
      MRoleName.class,
      MRuleName.class,
      MTypeName.class
    ).map(MNames::testComparableFor);
  }

  private static DynamicTest testComparableFor(
    final Class<? extends Record> c)
  {
    try {
      return DynamicTest.dynamicTest("testComparableFor_" + c, () -> {
        final var arb =
          Arbitraries.defaultFor(RDottedName.class);
        final var of =
          c.getMethod("of", String.class);

        for (int index = 0; index < 10; ++index) {
          final var name0 =
            arb.sample();
          final var name1 =
            arb.sample();

          final var cName0 =
            of.invoke(c, name0.value());
          final var cName1 =
            of.invoke(c, name1.value());

          final var compare =
            c.getMethod("compareTo", c);

          assertEquals(
            name0.compareTo(name1),
            compare.invoke(cName0, cName1)
          );
        }
      });
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }
}