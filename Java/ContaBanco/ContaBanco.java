
package aula5_poo;

public class ContaBanco {
    
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    
    public ContaBanco() {
        this.setSaldo(0); //saldo = 0;
        this.setStatus(false); //status = false;
    }
    
    public void estadoAtual() {
        System.out.println("------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }
    
    public void abrirConta(String t) {
        this.setTipo(t); //tipo = t;
        this.setStatus(true); //status = true;
        if (t.equals("CC")) { //(t == "CP")
            this.setSaldo(50);
            System.out.println("Conta Aberta com Sucesso, " + this.getDono() + "!");
        } else if (t.equals("CP")){ //(t == "CP")
            this.setSaldo(150);
            System.out.println("Conta Aberta com Sucesso, " + this.getDono() + "!");
        }
    }
    
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta com dinheiro!");
        } else if (this.getSaldo() < 0) {
            System.err.println("Conta em débito!");
        } else {
            this.setStatus(false);
            System.out.println("Conta Encerrada!");
        }
    }
    
    public void depositar(float v) {
        if (this.getStatus()) { //status == true ou isStatus()
            this.setSaldo(getSaldo() + v); //Melhor maneira
            System.out.println("Depósito Realizado na conta de " + this.getDono());
        } else {
            System.err.println("Imposssível depositar!");
        }
    }
    
    public void sacar(float v) {
        if (this.getStatus()) { //Mesmo que (status)
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque Realizado, " + this.getDono() + "! No valor de " + v);
            } else {
                System.err.println("Saldo Insuficiente!");
            }
        } else {
            System.err.println("Impossível Sacar!");
        }
    }
    
    public void pagarMensal() {
        float v = 0;
        
        if (this.getTipo().equals("CC")) {
            v = 12;
        } else if (this.getTipo().equals("CP")) {
            v = 20;
        }
        
        if (this.getStatus()) {
            if (this.getSaldo() > v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Mensalidade Paga, " + this.getDono() + "!");
            } else {
                System.err.println("Saldo Insuficiente!");
            }
        } else {
            System.err.println("Impossível Pagar!");
        }
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
