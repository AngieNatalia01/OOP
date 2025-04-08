
public class Operations {
    
    public int a,b,r;
      // Métodos para operaciones matemáticas
    public int sumar(int a, int b) {
        r=a + b;
        return r;
    }

    public int restar(int a, int b) {
        r=a - b;
        return r;   
    }

    public int multiplicar(int a, int b) {
        r=a * b;
        return r;   
    }
    public int potencia (int base, int exponente){
        r= exponente == 0 ? 1: base*potencia(base,exponente-1);
        return r;
    }
}
