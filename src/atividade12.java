
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class atividade12 {
	
	
    public static void main(String[] args) throws IOException {
    	
    	
        try {
            // Carregue a imagem que você deseja rotacionar
            BufferedImage imagem = ImageIO.read(new File("/home/adriano/Imagens/PDI/tigre.jpg"));

            // Defina o ângulo de rotação em graus
            double anguloGraus = 90;

            // Converta o ângulo de graus para radianos
            double anguloRadianos = Math.toRadians(anguloGraus);

            // Calcule as dimensões da imagem rotacionada
            int larguraOriginal = imagem.getWidth();
            int alturaOriginal = imagem.getHeight();
            int larguraRotacionada = larguraOriginal;
            int alturaRotacionada = alturaOriginal;
            if (anguloGraus == 90 || anguloGraus == 270) {
                larguraRotacionada = alturaOriginal;
                alturaRotacionada = larguraOriginal;
            }

            // Crie uma nova imagem com as dimensões apropriadas para a rotação
            BufferedImage imagemRotacionada = new BufferedImage(larguraRotacionada, alturaRotacionada, imagem.getType());

            // Realize a rotação manualmente, copiando pixels da imagem original para a imagem rotacionada
            for (int x = 0; x < larguraRotacionada; x++) {
                for (int y = 0; y < alturaRotacionada; y++) {
                    int newX, newY;
                    if (anguloGraus == 90) {
                        newX = y;
                        newY = larguraRotacionada - x - 1;
                    } else if (anguloGraus == 270) {
                        newX = alturaRotacionada - y - 1;
                        newY = x;
                    } else {
                        double cos = Math.cos(anguloRadianos);
                        double sin = Math.sin(anguloRadianos);
                        newX = (int) (cos * x - sin * y);
                        newY = (int) (sin * x + cos * y);
                        newX = larguraRotacionada / 2 + newX;
                        newY = alturaRotacionada / 2 + newY;
                    }

                    if (newX >= 0 && newX < larguraOriginal && newY >= 0 && newY < alturaOriginal) {
                        int cor = imagem.getRGB(newX, newY);
                        imagemRotacionada.setRGB(x, y, cor);
                    }
                }
            }

            // Salve a imagem rotacionada em um arquivo
            ImageIO.write(imagemRotacionada, "jpg", new File("/home/adriano/eclipse-workspace/RGB/Rotacionada.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
