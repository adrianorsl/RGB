import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Realce {

	public static String RealceP2(String inputFile, String nome) throws IOException {
		
		FileInputStream inputStream = new FileInputStream(inputFile);
        Scanner scanner = new Scanner(inputStream);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        
        // Lê o cabeçalho da imagem PGM
        String tipoImagem = scanner.nextLine();
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        int valorMaximo = scanner.nextInt();
      
        	
        String outputFile = "/home/adriano/eclipse-workspace/RGB/"+nome+".pgm"; // Caminho da imagem redimensionada de saída
        FileWriter writer = new FileWriter(outputFile);
        writer.write(tipoImagem + "\n");
        writer.write(largura + " " + altura + "\n");
        //escreve o valor maximo dos bits
        writer.write(valorMaximo + "\n");
        boolean vf = true;
        int bitMax = 0;
        int bitMin = 256;
        String tipo = br.readLine();
    	String alturaLar = br.readLine(); 
    	String valorMa = br.readLine();
        while (vf == true) {
        	String linha = br.readLine();
        	if(linha == null) {
        		vf = false;
        		System.out.println("FIM");
       
        	}else {
        		if(linha.equals(null)) {
        			break;
        		}else {
        			
        			String[] valores = linha.split(" ");
        			
            		for (int l = 0; l < valores.length; l++) {
                		if (bitMax <= Integer.parseInt(valores[l])) {
                			bitMax = Integer.parseInt(valores[l]);             
                		}else if (bitMin >= Integer.parseInt(valores[l])) {
                    		bitMin = Integer.parseInt(valores[l]);                  		
                		}  		
                	}
        		}
        	}
        }
        int a = 255/(bitMax - bitMin);
        int b = -a*bitMin;
        BufferedReader br2 = new BufferedReader(new FileReader(inputFile));
        boolean vfs = true;
        String tipo2 = br2.readLine();
    	String alturaLar2 = br2.readLine(); 
    	String valorMa2 = br2.readLine();
    	 while (vfs == true) {
         	String linha = br2.readLine();
         	if(linha == null) {
         		vfs = false;
         		System.out.println("FIM");
        
         	}else {
         		if(linha.equals(null)) {
         			break;
         		}else {
         			
         			String[] valores = linha.split(" ");
         			
             		for (int l = 0; l < valores.length; l++) {
             			int bit = a * Integer.parseInt(valores[l]) - b;
             			if ((bit >= 0) && (bit <= 255)) {
             				writer.write(bit + " ");
             			}else if (bit < 0) {
             				bit = 0;
             				writer.write(bit + " ");
             			}else {
             				bit = 255;
             				writer.write(bit + " ");
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
	
public static String RealceP3(String inputFile, String nome) throws IOException {
		
		FileInputStream inputStream = new FileInputStream(inputFile);
        Scanner scanner = new Scanner(inputStream);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        
        // Lê o cabeçalho da imagem PGM
        String tipoImagem = scanner.nextLine();
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        int valorMaximo = scanner.nextInt();

        	
        String outputFile = "/home/adriano/eclipse-workspace/RGB/"+nome+".ppm"; // Caminho da imagem redimensionada de saída
        FileWriter writer = new FileWriter(outputFile);
        writer.write(tipoImagem + "\n");
        writer.write(largura + " " + altura + "\n");
        //escreve o valor maximo dos bits
        writer.write(valorMaximo + "\n");
        boolean vf = true;
        int bitMax = 0;
        int bitMin = 256;
        String tipo = br.readLine();
    	String alturaLar = br.readLine(); 
    	String valorMa = br.readLine();
    	br.readLine();
        while (vf == true) {
        	String linha = br.readLine();
        	if(linha == null) {
        		vf = false;
        		System.out.println("FIM");
       
        	}else {
        		if(linha.equals(null)) {
        			break;
        		}else {
        			
        			String[] valores = linha.split(" ");
        			
            		for (int l = 0; l < valores.length; l++) {
                		if (bitMax <= Integer.parseInt(valores[l])) {
                			bitMax = Integer.parseInt(valores[l]);             
                		}else if (bitMin >= Integer.parseInt(valores[l])) {
                    		bitMin = Integer.parseInt(valores[l]);                  		
                		}  		
                	}
        		}
        	}
        }
        int a = 255/(bitMax - bitMin);
        int b = -a*bitMin;
        BufferedReader br2 = new BufferedReader(new FileReader(inputFile));
        boolean vfs = true;
        String tipo2 = br2.readLine();
    	String alturaLar2 = br2.readLine(); 
    	String valorMa2 = br2.readLine();
    	br2.readLine();
    	 while (vfs == true) {
         	String linha = br2.readLine();
         	if(linha == null) {
         		vfs = false;
         		System.out.println("FIM");
        
         	}else {
         		if(linha.equals(null)) {
         			break;
         		}else {
         			
         			String[] valores = linha.split(" ");
         			
         			for (int l = 0; l < valores.length; l++) {
             			int bit = a * Integer.parseInt(valores[l]) - b;
             			if ((bit >= 0) && (bit <= 255)) {
             				writer.write(bit + " ");
             			}else if (bit < 0) {
             				bit = 0;
             				writer.write(bit + " ");
             			}else {
             				bit = 255;
             				writer.write(bit + " ");
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
		String inputFile = "/home/adriano/eclipse-workspace/RGB/Entrada_EscalaCinza.pgm"; // Caminho da imagem de entrada
		String inputFile2 = "/home/adriano/eclipse-workspace/RGB/EntradaRGB.ppm"; // Caminho da imagem de entrada
		RealceP2(inputFile, "Realce");
		RealceP3(inputFile2, "RealceP3");
	}

}
