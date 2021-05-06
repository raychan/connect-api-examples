/*
 * Copyright 2017 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.catalog.demo.example.clone;

import static org.fest.assertions.Assertions.assertThat;

import com.squareup.catalog.demo.util.Moneys;
import com.squareup.square.models.CatalogTax;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class TaxCloneUtilTest {

  private TaxCloneUtil cloneUtil;

  @Before
  public void setUp() {
    this.cloneUtil = new TaxCloneUtil();
    Moneys.setCurrency("CAD");
  }

  @Test
  public void encodeCatalogData() {
    CatalogTax tax = new CatalogTax.Builder().name("name").percentage("12.34").inclusionType("ADDITIVE").build();
    assertThat(cloneUtil.encodeCatalogData(tax)).isEqualTo("name:::12.34:::ADDITIVE");
  }
}
