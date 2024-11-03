import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int opcion = 0;
        while (opcion != 8) {
            System.out.println("******************************\n" +
                    "Bienvenidos Al conversor de monedas\n\n" +
                    "Ingresa la conversión que deseas realizar\n\n" +
                    "1. Dollar a Peso Argentino (USD a ARS)\n" +
                    "2. Peso Argentino a Dollar (ARS a USD)\n" +
                    "3. Dollar a Real Brasilero (USD a BRL)\n" +
                    "4. Real Brasilero a Dollar (BRL a USD)\n" +
                    "5. Dollar a Peso Colombiano (USD a COP)\n" +
                    "6. Peso Colombiano a Dollar (COP a USD)\n" +
                    "7. Convertir otra moneda\n" +
                    "8. Salir");
            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1:
                    ConvertirMoneda.convertir("USD", "ARS", consulta, lectura);
                    break;
                case 2:
                    ConvertirMoneda.convertir("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", consulta, lectura);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", consulta, lectura);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "COP", consulta, lectura);
                    break;
                case 6:
                    ConvertirMoneda.convertir("COP", "USD", consulta, lectura);
                    break;
                case 7:
                    ConvertirMoneda.convertirOtraMoneda(consulta, lectura);
                    break; // Agregamos el "break" aquí
                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        lectura.close(); // Cierra el escáner al final del uso
    }
}
