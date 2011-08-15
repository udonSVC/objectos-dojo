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

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * @author hellen.escarate@objectos.com.br (Hellen Escarate)
 */
@Test
public class TreinoDeTDD {
  public void objetoRacionalToStringDeveImprimirFormaFracionaria() {
    Racional umTerco = new Racional(1, 3);
    assertEquals(umTerco.toString(), "1/3");
  }
  public void qualquerObjetoRacionalToStringDeveImprimirFormaFracionaria() {
    Racional umQuinto = new Racional(1, 5);
    assertEquals(umQuinto.toString(), "1/5");
  }
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void objetoRacionalNaoDeveReceberInstanciaZero() {
    new Racional(100, 0);
  }
  public void objetoRacionalToStringDeveAdicionarCampoQueRetornaSoma() {
    Racional umMeio = new Racional(1, 2);
    Racional doisTercos = new Racional(2, 3);
    Racional resultado = umMeio.soma(doisTercos);
    assertEquals(resultado.toString(), "7/6");
  }
  public void deveSerPossivelConstruirUmRacionalPassandoApenasUmInteiro() {
    Racional tres = new Racional(3);
    assertEquals(tres.toString(), "3/1");
  }
  public void deveRetornarEquivalenteNaFormaReduzida() {
    Racional onzeSetimos = new Racional(66, 42);
    assertEquals(onzeSetimos.toString(), "11/7");
  }
  public void deveRetornarNaFormaReduzidaMesmoParaValoresNegativos() {
    Racional onzeSetimosNegativo = new Racional(-66, 42);
    assertEquals(onzeSetimosNegativo.toString(), "-11/7");
  }
  public void multiplicacaoDeveFuncionarCorretamente() {
    Racional umMeio = new Racional(1, 2);
    Racional tresQuintos = new Racional(3, 5);
    Racional resultado = umMeio.multiplica(tresQuintos);
    assertEquals(resultado.toString(), "3/10");
  }
}
