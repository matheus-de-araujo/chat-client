import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTCP {
	ObjectOutputStream saida;
	ObjectInputStream entrada;
	Socket conexao;
	
	public Message enviarDados(Message message) {
        
        try {
			conexao = new Socket("localhost", 9000);
			saida = new ObjectOutputStream(conexao.getOutputStream());
			entrada = new ObjectInputStream(conexao.getInputStream());
			
			//enviando message para calcular imc
			saida.writeObject(message);
			
			// recebendo a resposta do servidor
			message = (Message) entrada.readObject();
			
			return message;
			
		} catch (Exception e) {
			return null;
		}
	}

	public void encerrarConexao() throws IOException{	
		if(conexao != null){
			entrada.close();		
			saida.close();
			conexao.close();
		}
	}
}
