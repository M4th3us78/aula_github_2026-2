import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;

	public Menu(List<String> options) {
		//delega a função de nome generico ao construtor que faz a checagem
    this(null,options);
	}

	public Menu(String title, List<String> options) {
		
    if(options == null){
      throw new IllegalArgumentException("A lista de opções não pode ser nula.");
    } 

    if(options.isEmpty()){
      throw new IllegalArgumentException("A lista de opções não pode ser vazia.");
    }

    if(title == null || title.trim().isEmpty()){
      this.title = "Menu";
    }else{
      this.title = title;
    }

		this.options = options;
	}

	public int getSelection() {
		int op = 0;
		while (op==0){
			System.out.println(title+"\n");
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			
			if (str.trim().isEmpty()) {
				System.out.println("Entrada invalida: informe um numero.");
				op = 0;
			} else {
				try {
					op = Integer.parseInt(str);
					
					// Critério de aceitação: Entrada numérica fora do intervalo
					if (op <= 0 || op >= i) { 
						System.out.println("Opcao errada!");
						op = 0;
					}
				} catch (NumberFormatException e) {
					// Critério de aceitação: Entrada não numérica
					System.out.println("Entrada invalida: informe um numero.");
					op = 0;
				}
			}

		}
		return op;
	}
}
