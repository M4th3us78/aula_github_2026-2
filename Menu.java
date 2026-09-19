import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;
	private final Scanner scanner;

	public Menu(List<String> options) {
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
		this.scanner = new Scanner(System.in);
	}

	public int getSelection() {
		int op = 0;
		Scanner s = new Scanner(System.in);
		while (op==0){
			System.out.println(title+"\n");
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
			}
			catch (NumberFormatException e) {
				op =0;
			}
			if (op>=i || op<=0){
				System.out.println("Opcao errada!");
				op=0;
			}

		}
		return op;
	}

	public String getSelectionOption(int selection) {
		if (selection > 0 && selection <= options.size()) {
			return options.get(selection - 1);
		}
		return null;

	}
}
