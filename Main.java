import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String>options = Arrays.asList("Conta", "Cliente", "Operacoes", "Sair");
    Menu mainMenu =  new Menu("Menu Principal",options);
    
    while(true){
      int opcaoSelecionada = mainMenu.getSelection();
      
      System.out.println("\n>>> A opção " + mainMenu.getSelectionOption(opcaoSelecionada) + " foi selecionada\n");

      if(opcaoSelecionada == options.size()){
        break;
      }
    }
		System.out.println("Fim");
	}

}
