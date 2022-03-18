package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  static ArrayList<Short> people = new ArrayList<Short>();
  short acess;
  static short logoutOption = 2;
  static int loginOption = 1;
  static Scanner inputScanner = new Scanner(System.in);

  /**
   * warn
   * método main vai chamar a execução da aplicação do sistema.
   * @author Murilo
   * @version 1.0
   */
  public static void main(String[] args) {
    // ESCREVA SEU CÓDIGO AQUI
    // inicio da contagem

    flow();

  }

  /**
   * warn
   * método fluxo vai vai acessar o sistem para cadastro de pessoas pela idade e
   * caso desejado realizar o relatório.
   * @author Murilo
   * @version 1.0
   */
  public static void flow() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    String entrySystemString =
        "1 - Acessar o estabelecimento\n2 - Finalizar sistema e mostrar relatório";
    System.out.println(entrySystemString);

    short inputNumber = 0;

    if (inputScanner.hasNextShort()) {
      inputNumber = inputScanner.nextShort();
    }

    // inputScanner.close();
    if (inputNumber == loginOption) {
      // adiciono a primeira pessoa ao relatorio
      storeUserAge();

      // eu quero contar mais um? então chamo o metodo nomente
      flow();
    } else if (inputNumber != logoutOption) {
      System.out.println("Entre com uma opção válida!");
    } else {
      // quando acabar eu quero que a entidade de relatorio me ofereça o relatorio das
      // pessoas
      int quantityOfPeople = people.size();
      if (quantityOfPeople == 0) {
        flow();
      }
      relatorio();
    }
    // inputScanner.close();
  }

  /**
   * método storeUserAge vai esperar a idade e guardar no arrayList de people.
   * @author Murilo
   * @version 1.0
   */
  public static void storeUserAge() {
    System.out.println("Entre com a sua idade:");
    short age = 0;

    if (inputScanner.hasNextShort()) {
      age = inputScanner.nextShort();
    }
    System.out.println("Pessoa adulta, catraca liberada!");
    people.add(age);
    // inputScanner.close();
  }

  /**
   * método relatorio instancia uma classe de Report que contem
   * metodos para analizar um array de idades.
   * @author Murilo
   * @version 1.0
   */
  public static void relatorio() {
    Report report = new Report(people);
    report.reportQuantityByAges();
    report.reportPercentageByAges();
    report.numberOfPeople();
  }
}
