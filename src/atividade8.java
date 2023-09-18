import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class atividade8 {

	
	public static String AlterarP3(String inputFile, String tipoImagem2, String nome , int valor, char bit) throws IOException {
		
		FileInputStream inputStream = new FileInputStream(inputFile);
        Scanner scanner = new Scanner(inputStream);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/adriano/Imagens/PDI/"+nome+".ppm"));
        
        // Lê o cabeçalho da imagem PGM
        String tipoImagem = scanner.nextLine();
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        int valorMaximo = scanner.nextInt();
        int newBit = 0;
        	
        String outputFile = "/home/adriano/Imagens/PDI/"+nome+".ppm"; // Caminho da imagem redimensionada de saída
        FileWriter writer = new FileWriter(outputFile);
        writer.write(tipoImagem2 + "\n");
        writer.write(largura + " " + altura + "\n");
        //escreve o valor maximo dos bits
        writer.write(valorMaximo + "\n");
        boolean vf = true;
        int x = 0;
        String tipo = br.readLine();
    	String alturaLar = br.readLine(); 
    	String valorMa = br.readLine();
    	br.readLine();
        while (vf == true) {
        	String linha = br.readLine();
        	x++;
        	if(linha == null) {
        		vf = false;
        		System.out.println("FIM");
       
        	}else {
        		if(linha.equals(null)) {
        			break;
        		}else {
        			
        			String[] valores = linha.split(" ");
        			
            		for (int l = 0; l < valores.length; l = l+3) {
                		if (bit == 'r') {
                			int r = Integer.parseInt(valores[l]);
                    		int g = valor;
                    		int b = valor;
             
                    		writer.write(r + " " +g + " " + b + " ");
                		}else if (bit == 'g') {
                			int r = valor;
                    		int g = Integer.parseInt(valores[l+1]);
                    		int b = valor;
             
                    		writer.write(r + " " + g + " " + b + " ");
                		}else {
                			int r = valor;
                    		int g = valor;
                    		int b = Integer.parseInt(valores[l+2]);
             
                    		writer.write(r + " " + g + " " + b + " ");
                		}  		
                	}
        		}
        	}
            writer.write("\n");
        }
        writer.close();
    	
    	String teste = "OK";
        
        return teste;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String inputFile = "/home/adriano/Imagens/PDI/Fig4.ppm"; // Caminho da imagem de entrada

		AlterarP3(inputFile, "P3", "R", 0, 'r');
		AlterarP3(inputFile, "P3", "G", 0, 'g');
		AlterarP3(inputFile, "P3", "B", 0, 'b');
		AlterarP3(inputFile, "P3", "R255", 255, 'r');
		AlterarP3(inputFile, "P3", "G255", 255, 'g');
		AlterarP3(inputFile, "P3", "B255", 255, 'b');
	}

}
