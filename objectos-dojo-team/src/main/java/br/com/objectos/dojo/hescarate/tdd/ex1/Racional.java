/*
* Copyright 2011 Objectos, Fábrica de Software LTDA.
*
* Licensed under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License. You may obtain a copy of
* the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations under
* the License.
*/
package br.com.objectos.dojo.hescarate.tdd.ex1;

import com.google.common.base.Preconditions;

/**
 * @author hellen.escarate@objectos.com.br (Hellen Escarate)
 */
public class Racional {

  Integer numerador;
  Integer denominador;

  public Racional(int numerador, int denominador) {

    Preconditions.checkArgument(denominador != 0);

    int g = mdc(Math.abs(numerador), Math.abs(denominador));

    this.numerador = numerador / g;
    this.denominador = denominador / g;
  }

  private int mdc(int a, int b) {

    return b == 0 ? a : mdc(b, a % b);

  }

  public Racional(int i) {

    this(i, 1);

  }

  @Override
  public String toString() {
    return numerador.toString() + "/" + denominador.toString();
  }

  public Racional soma(Racional numero) {

    int numerador = numero.numerador;
    int denominador = numero.denominador;

    int somaNumerador = this.numerador * denominador + this.denominador * numerador;
    int somaDenominador = this.denominador * denominador;
    return new Racional(somaNumerador, somaDenominador);

  }

  public Racional multiplica(Racional outro) {
    return new Racional(numerador * outro.numerador, denominador * outro.denominador);
  }

}
