import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static String AlterarP3P2(String inputFile, String tipoImagem2) throws IOException {
	
		FileInputStream inputStream = new FileInputStream(inputFile);
        Scanner scanner = new Scanner(inputStream);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/adriano/Imagens/PDI/FigP2.pbm"));
        
        // Lê o cabeçalho da imagem PGM
        String tipoImagem = scanner.nextLine();
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        int valorMaximo = scanner.nextInt();
        int newBit = 0;
        	
        String outputFile = "/home/adriano/Imagens/PDI/FigP2.pbm"; // Caminho da imagem redimensionada de saída
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
                		
                		int r1 = Integer.parseInt(valores[l]);
                		int g1 = Integer.parseInt(valores[l+1]);
                		int b1 = Integer.parseInt(valores[l+2]);
                	
                		newBit = (r1 + g1 + b1) / 3 ;
                		System.out.println(newBit);
                		writer.write(newBit + " ");
                	}
        		}
        	}
            writer.write("\n");
        }
        writer.close();
    	
    	String teste = "OK";
        
        return teste;
		
	}
	
	public static String AlterarP3Media(String inputFile, String tipoImagem2) throws IOException {
		
		FileInputStream inputStream = new FileInputStream(inputFile);
        Scanner scanner = new Scanner(inputStream);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/adriano/Imagens/PDI/FigP3Media.ppm"));
        
        // Lê o cabeçalho da imagem PGM
        String tipoImagem = scanner.nextLine();
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        int valorMaximo = scanner.nextInt();
        int newBit = 0;
        	
        String outputFile = "/home/adriano/Imagens/PDI/FigP3Media.ppm"; // Caminho da imagem redimensionada de saída
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
                		
                		int r1 = Integer.parseInt(valores[l]);
                		int g1 = Integer.parseInt(valores[l+1]);
                		int b1 = Integer.parseInt(valores[l+2]);
                		newBit = (r1 + g1 + b1) / 3 ;
                		System.out.println(newBit);
                		writer.write(newBit + " " + newBit + " " + newBit + " ");
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
		
		AlterarP3P2(inputFile,"P2");
		AlterarP3Media(inputFile,"P3");
	}

}
