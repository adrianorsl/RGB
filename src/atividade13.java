import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class atividade13 {
	
	public static String adicao (String imagemA, String imagemB, String resultado) {
		
		        try {
		            // Carregue as duas imagens de entrada
		            BufferedImage imageA = ImageIO.read(new File(imagemA));
		            BufferedImage imageB = ImageIO.read(new File(imagemB));

		            // Verifique se as imagens têm as mesmas dimensões
		            int largura = imageA.getWidth();
		            int altura = imageA.getHeight();
		            if (largura != imageB.getWidth() || altura != imageB.getHeight()) {
		                return "As imagens não têm as mesmas dimensões.";
		            }

		            // Fator Lambda para controlar a mistura
		            double lambda = 0.5; // Valor entre 0 e 1

		            // Crie uma nova imagem para o resultado
		            BufferedImage resultImage = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

		            // Realize a adição de imagens pixel a pixel
		            for (int x = 0; x < largura; x++) {
		                for (int y = 0; y < altura; y++) {
		                    int rgbA = imageA.getRGB(x, y);
		                    int rgbB = imageB.getRGB(x, y);

		                    int rA = (rgbA >> 16) & 0xFF;
		                    int gA = (rgbA >> 8) & 0xFF;
		                    int bA = rgbA & 0xFF;

		                    int rB = (rgbB >> 16) & 0xFF;
		                    int gB = (rgbB >> 8) & 0xFF;
		                    int bB = rgbB & 0xFF;

		                    int rC = (int) (lambda * rA + (1 - lambda) * rB);
		                    int gC = (int) (lambda * gA + (1 - lambda) * gB);
		                    int bC = (int) (lambda * bA + (1 - lambda) * bB);

		                    int rgbC = (rC << 16) | (gC << 8) | bC;

		                    resultImage.setRGB(x, y, rgbC);
		                }
		            }

		            // Salve a imagem resultante
		            File outputImage = new File(resultado);
		            ImageIO.write(resultImage, "jpg", outputImage);

		            System.out.println("Imagem resultante salva como resultado.jpg.");

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		
		return "OK";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String imagemA = "/home/adriano/eclipse-workspace/RGB/imagemA.jpeg";
		String imagemB = "/home/adriano/eclipse-workspace/RGB/imagemB.jpeg";
		String resultado = "/home/adriano/eclipse-workspace/RGB/resultado.jpeg";

		adicao(imagemA, imagemB, resultado);
	}

}
