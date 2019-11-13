import javax.swing.JOptionPane;
public class Jogo {

	public static void main(String[] args) {
		int x,confirm,tam_dica,tam_palavra, vidas = 6;
		String jogador,amigo, dica_str, palavra_str, teste;
		char letra;
		char[] palavra = new char[50];
		char[] dica = new char[50];
		char[] traco = new char[50];
		
		jogador=JOptionPane.showInputDialog("Jogador: ");
		amigo=JOptionPane.showInputDialog("Proponente da partida: ");
		confirm=JOptionPane.showConfirmDialog(null, "Ok, Peça para que "+jogador+" vire enquanto "+amigo+" ira digitar a dica!");
		while(confirm != 0) {
			JOptionPane.showMessageDialog(null, "Não poderemos continuar enquanto o jogador "+jogador+" estiver olhando você digitar, \ncertifique-se que ele não estar olhando e clique em YES para continuar!");
			confirm=JOptionPane.showConfirmDialog(null, amigo+" este momento é reservado para você digitar a dica "+jogador+" não pode estar olhando! ");
		}
		palavra_str=JOptionPane.showInputDialog(null,"Palavra: ");
		dica_str=JOptionPane.showInputDialog(null,"Dica: ");
		tam_palavra=palavra_str.length();
		tam_dica=dica_str.length();
		x=0;
		while(x < tam_palavra) {
			palavra[x]=palavra_str.charAt(x);
			traco[x]='-';
			x++;
		}
		x=0;
		while(x < tam_dica) {
			dica[x]=dica_str.charAt(x);
			x++;
		}
		JOptionPane.showMessageDialog(null, "O Jogo começa agora! \n"+amigo+
				" chame "+jogador+" para jogar!");
		teste = "false";
		x=0;
		while((vidas > 0) || (teste == "false")) {
			letra=JOptionPane.showInputDialog(null,"Vidas: "+vidas+
					"\nLetras: "
					+tam_palavra+"\n"+"\nDigite uma letra: ").charAt(0);
			vidas --;
		}
	}

}
