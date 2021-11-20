import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Message message = new Message();
		Scanner scan = new Scanner(System.in);
		message.setFim(false);

		System.out.println("Digite sua Mensagem");
		message.setMessage(scan.next());
		
		ClienteTCP clienteTCP = new ClienteTCP();
		message = clienteTCP.enviarDados(message);
		
		System.out.println("Pessoa 2: " + message.getMessage());
	}
}
