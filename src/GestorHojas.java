
import java.util.concurrent.CopyOnWriteArrayList;

public class GestorHojas extends Thread {
	/*
	* Utilizamos la clase CopyOnWriteArrayList<E>; es como un ArrayList<E> que realiza las operaciones
	* de add haciendo una copia nueva de la lista subyacente, por lo que no da errores de concurrencia
	* al usarla en hilos.
	* Para que los números se escriban del 0 al 9 de forma ordenada, sacamos el contenido del run() a
	* un método synchronized.
	* */
	private static CopyOnWriteArrayList<String> lista = new CopyOnWriteArrayList<String>();

	@Override
	public void run() {
		addTexto();
	}

	/**
	 * Método que añade texto a la lista y la escribe; lo hace de forma sincronizada.
	 */
	synchronized public static void addTexto(){
		for (int i = 0; i < 10; i++) {
			lista.add(new String("Texto" + i));
		}

		for (String string : lista) {
			System.out.println(string);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new GestorHojas().start();
		}

	}

}
