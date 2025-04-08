
public class Main {
    
    public static void main(String[] args) {
        
        Operations resultado = new Operations ();
        resultado.sumar(3,2);
        System.out.println ("La suma es igual a : "+resultado.r);
        
        resultado.restar(3, 2);
        System.out.println ("La resta es igual a : "+resultado.r);
        
        resultado.multiplicar(3, 2);
        System.out.println ("La multiplicacion es igual a : "+resultado.r);
        
        resultado.potencia (3, 2);
        System.out.println ("La potencia es igual a : "+resultado.r);
    }
    
}
