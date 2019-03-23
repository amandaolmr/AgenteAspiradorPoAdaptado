package Testes;

public class AmbienteTeste {
	public   int tamanho = (int) (Math.random()*10+1);
	public  int ambiente[] ;
	
	
	public AmbienteTeste(int tamanho, int[] ambiente) {
		this.tamanho = tamanho;
		this.ambiente = ambiente;
	}
	
	public AmbienteTeste() {
		
	}
	
	
	public void geraAmbiente() {
		ambiente = new int[tamanho];
		System.out.println("Aquio é o tamanho do ambiente: "+tamanho);
		for (int i = 0; i < tamanho; i++) {
			   ambiente[i] = (int) (Math.random()*2);
			   System.out.print("[ "+ambiente[i]+" ]");
			}
		
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int[] getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(int[] ambiente) {
		this.ambiente = ambiente;
	}
	
	
	
}
