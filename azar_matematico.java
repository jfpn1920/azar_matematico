import java.util.Random;
import java.util.Scanner;
public class azar_matematico {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        int[] numeros = new int[100];
        int total = 0;
        int opcion;
        //---------------------------------------//
        //--|menu_principal_de_azar_matematico|--//
        //---------------------------------------//
        do {
            System.out.println("menu principal de azar matematico");
            System.out.println("1) Generar numero aleatorio");
            System.out.println("2) Generar varios numeros");
            System.out.println("3) Calcular estadisticas");
            System.out.println("4) Contar resultados");
            System.out.println("5) Reiniciar");
            System.out.println("6) Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                //------------------------------//
                //--|generar_numero_aleatorio|--//
                //------------------------------//
                case 1:
                    System.out.print("Ingrese el valor minimo: ");
                    int minimo = entrada.nextInt();
                    System.out.print("Ingrese el valor maximo: ");
                    int maximo = entrada.nextInt();
                    if (minimo <= maximo) {
                        int numero = aleatorio.nextInt(maximo - minimo + 1) + minimo;
                        System.out.println("Numero aleatorio generado: " + numero);
                        if (total < numeros.length) {
                            numeros[total] = numero;
                            total++;
                            System.out.println("Numero agregado a los resultados.");
                        } else {
                            System.out.println("No hay espacio para almacenar mas numeros.");
                        }
                    } else {
                        System.out.println("El valor minimo no puede ser mayor que el maximo.");
                    }
                    break;
                //----------------------------//
                //--|generar_varios_numeros|--//
                //----------------------------//
                case 2:
                    System.out.print("Ingrese la cantidad de numeros a generar: ");
                    int cantidad = entrada.nextInt();
                    System.out.print("Ingrese el valor minimo: ");
                    minimo = entrada.nextInt();
                    System.out.print("Ingrese el valor maximo: ");
                    maximo = entrada.nextInt();
                    if (cantidad > 0 && minimo <= maximo) {
                        if (total + cantidad <= numeros.length) {
                            System.out.println("Numeros generados:");
                            for (int i = 0; i < cantidad; i++) {
                                numeros[total] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
                                System.out.print(numeros[total]);
                                if (i < cantidad - 1) {
                                    System.out.print(" | ");
                                }
                                total++;
                            }
                            System.out.println();
                        } else {
                            System.out.println("La cantidad supera el espacio disponible.");
                        }
                    } else {
                        System.out.println("Los datos ingresados no son validos.");
                    }
                    break;
                //---------------------------//
                //--|calcular_estadisticas|--//
                //---------------------------//
                case 3:
                    if (total == 0) {
                        System.out.println("No existen numeros generados.");
                        break;
                    }
                    int suma = 0;
                    int mayor = numeros[0];
                    int menor = numeros[0];
                    for (int i = 0; i < total; i++) {
                        suma += numeros[i];
                        if (numeros[i] > mayor) {
                            mayor = numeros[i];
                        }
                        if (numeros[i] < menor) {
                            menor = numeros[i];
                        }
                    }
                    double promedio = (double) suma / total;
                    System.out.println("Estadisticas de los numeros");
                    System.out.println("Cantidad: " + total);
                    System.out.println("Suma: " + suma);
                    System.out.println("Promedio: " + promedio);
                    System.out.println("Mayor: " + mayor);
                    System.out.println("Menor: " + menor);
                    break;
                //-----------------------//
                //--|contar_resultados|--//
                //-----------------------//
                case 4:
                    if (total == 0) {
                        System.out.println("No existen numeros generados.");
                        break;
                    }
                    System.out.println("Resultados generados:");
                    for (int i = 0; i < total; i++) {
                        System.out.print(numeros[i]);
                        if (i < total - 1) {
                            System.out.print(" | ");
                        }
                    }
                    System.out.println();
                    System.out.println("Frecuencia de cada resultado:");
                    boolean[] contado = new boolean[total];
                    for (int i = 0; i < total; i++) {
                        if (!contado[i]) {
                            int frecuencia = 0;
                            for (int j = 0; j < total; j++) {
                                if (numeros[i] == numeros[j]) {
                                    frecuencia++;
                                }
                            }
                            for (int j = i; j < total; j++) {
                                if (numeros[i] == numeros[j]) {
                                    contado[j] = true;
                                }
                            }
                            System.out.println("Numero: " + numeros[i] + " | Veces: " + frecuencia);
                        }
                    }
                    break;
                //---------------//
                //--|reiniciar|--//
                //---------------//
                case 5:
                    total = 0;
                    System.out.println("Resultados reiniciados correctamente.");
                    break;
                //------------------------------//
                //--|salir_del_menu_principal|--//
                //------------------------------//
                case 6:
                    System.out.println("Gracias por utilizar Azar Matematico.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);
        entrada.close();
    }
}