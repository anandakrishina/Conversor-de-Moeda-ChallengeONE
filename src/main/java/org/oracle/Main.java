package org.oracle;

import org.oracle.model.Moeda;
import org.oracle.service.ConsumirApi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsumirApi consumirApi = new ConsumirApi();

        System.out.println("\n--- Conversor de Moedas ---\n");

        System.out.println("1. Dólar para Real");
        System.out.println("2. Real para Dólar");
        System.out.println("3. Real para Euro");
        System.out.println("4. Euro para Real");
        System.out.println("5. Peso Argentino para Real");
        System.out.println("6. Real para Peso Argentino");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: \n");

        int menuEscolhido = scanner.nextInt();
        scanner.nextLine();

        String moedaOrigem = "";
        String moedaDestino = "";

        switch (menuEscolhido) {
            case 1:
                moedaOrigem = "USD";
                moedaDestino = "BRL";
                break;
            case 2:
                moedaOrigem = "BRL";
                moedaDestino = "USD";
                break;
            case 3:
                moedaOrigem = "BRL";
                moedaDestino = "EUR";
                break;
            case 4:
                moedaOrigem = "EUR";
                moedaDestino = "BRL";
                break;
            case 5:
                moedaOrigem = "ARS";
                moedaDestino = "BRL";
                break;
            case 6:
                moedaOrigem = "BRL";
                moedaDestino = "ARS";
                break;
            case 0:
                System.out.println("Saindo do conversor. Até mais!");
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                return;
        }

        // Solicita o valor a ser convertido
        System.out.print("Digite o valor em " + moedaOrigem + ": ");
        double valor = scanner.nextDouble();

        // Chama a API para obter a taxa de câmbio
        Moeda moeda = consumirApi.obterDados(moedaOrigem);

        // Calcula o valor convertido
        double taxaCambio = moeda.getConversion_rates().get(moedaDestino);
        double valorConvertido = valor * taxaCambio;

        // Exibe o resultado
        System.out.printf("O valor convertido de %s para %s é: %.2f\n", moedaOrigem, moedaDestino, valorConvertido);
    }
}
