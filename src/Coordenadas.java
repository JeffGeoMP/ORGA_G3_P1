/**
 *
 * @author JeffGeo
 */
public class Coordenadas {
    private int Coordenada_X;
    private int Coordenada_Y;

    public Coordenadas(int Coordenada_X, int Coordenada_Y) {
        this.Coordenada_X = Coordenada_X;
        this.Coordenada_Y = Coordenada_Y;
    }
     
    public int getCoordenada_X() {
        return Coordenada_X;
    }

    public void setCoordenada_X(int Coordenada_X) {
        this.Coordenada_X = Coordenada_X;
    }

    public int getCoordenada_Y() {
        return Coordenada_Y;
    }

    public void setCoordenada_Y(int Coordenada_Y) {
        this.Coordenada_Y = Coordenada_Y;
    }
    
    public void Imprimir_X_Y(){
        System.out.println("("+Coordenada_X+","+Coordenada_Y+")");
    }
}
