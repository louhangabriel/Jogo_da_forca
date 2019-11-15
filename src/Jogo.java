import javax.swing.JOptionPane;
public class Jogo {

	public static void main(String[] args) {
		int x,y,confirm,tam_dica,tam_palavra, vidas = 6;
		int acertos=0;
		boolean erro= false;
		String jogador,amigo, dica_str, palavra_str, teste, str_traco;
		char letra;
		char[] palavra = new char[50];
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
		JOptionPane.showMessageDialog(null, "O Jogo começa agora! \n"+amigo+
				" chame "+jogador+" para jogar!");
		teste = "false";
		x=0;
		
		while(vidas > 0 || acertos != tam_palavra) {	
			str_traco=String.copyValueOf(traco);
			letra=JOptionPane.showInputDialog(null,"Vidas: "+vidas+
					"   Letras: "
					+tam_palavra+"   Acertos: "+acertos+"\n\nDica: "+dica_str+"\n\nPalavra: "+str_traco+
					"\n\nDigite uma letra: ").charAt(0);
			for(y=0;y<tam_palavra;y++) {
				if(letra == palavra[y]) {
					JOptionPane.showMessageDialog(null, "LETRA CORRETA!");
					traco[y]=palavra[y];
					acertos++;
				}else {
					erro = true;
				}
			}
			if(acertos == tam_palavra) {
				JOptionPane.showMessageDialog(null,"FIM DE JOGO! \nVOCÊ GANHOU!"
						+"\n\nRELATORIO DA PARTIDA: "+ "\nJogador: "+jogador+
						"  Proponente: "+amigo+"\nVidas: "+vidas+
						"   Letras: "
						+tam_palavra+"   Acertos: "+acertos+"\n\nDica: "+dica_str+
						"\n\nPalavra: "+palavra_str+"\nLetras acertadas: "+str_traco);
				break;
			}
			if(erro == true) {
				JOptionPane.showMessageDialog(null, "LETRA INCORRETA!");
				erro = false;
				vidas --;
				if(vidas == 0) {
					teste="false";
					JOptionPane.showMessageDialog(null,"FIM DE JOGO! \nVOCÊ PERDEU!"
							+"\n\nRELATORIO DA PARTIDA: "+ "\nJogador: "+jogador+
							"  Proponente: "+amigo+ "\nVidas: "+vidas+
							"   Letras: "
							+tam_palavra+"   Acertos: "+acertos+"\n\nDica: "+dica_str+
							"\n\nPalavra: "+palavra_str+"\nLetras acertadas: "+str_traco);
					break;
				}
			}
		}
		
	}

}
