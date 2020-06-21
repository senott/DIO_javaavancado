package processamento;

public class ExemploThread {

    public static void main(String[] args) {
        BarraCarregamento2 barra2 = new BarraCarregamento2();
        BarraCarregamento3 barra3 = new BarraCarregamento3();

        barra2.start();
        barra3.start();

    }
}

class GerarPDF implements Runnable {
    @Override
    public void run() {
        System.out.println("Gear PDF");
    }
}

class BarraCarregamento implements Runnable {
    @Override
    public void run() {
        System.out.println("Loading...");
    }
}

class BarraCarregamento2 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(3000);
            System.out.println("Rodei 2 " + this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraCarregamento3 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000);
            System.out.println("Rodei 3 " + this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}