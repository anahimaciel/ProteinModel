public class proteinModelGen {
	//entrada: vetor estados iniciais das proteínas,fatores e fenótipos em t = 0; número de iterações k que serão simuladas
	//saída:n vetores de k elementos cada, onde cada vetor é o estado de uma proteína/fator/fenótipo ao longo de k iterações
	//ERK[i] estado da proteína ERK na iteração i

	public static boolean is_Active_now(Digraph g, Protein prot, Protein[] prots, int iteration, int[] states) {		
		int p = prot.number;
		Stack<Integer> thisRegs = which_regulators(g,p);
		int l = thisRegs.size();

		int cad = states[1];
		int rtk = states[2];
        int itg = states[3];

		/*Stack<Integer> thisRegs = which_regulators(g,p.number);
		int l = thisRegs.size();

		int ativ = 0;
		int inib = 0;
		for(int i=0;i<l;i++) {
			int regulator = thisRegs.pop(); */
		//	if (/*is_Active(g,prots[regulator],prots)==true||*/prots[regulator].state==true)	{
		/*		if (g.adj[regulator].get(p.number)==1) ativ++;
				else inib ++;
			}
		}
		if (ativ>inib) return true;
		else if (ativ<inib) return false;
		else return p.state;*/
	}


	public static void main(String[] args) {
		In in_0 = new In(args[0]);
		Digraph g = new Digraph(in_0);

		In in = new In(args[1]);

		String line1 = in.readLine();
		String[] s = line1.split(" ");
		//int cad = Integer.parseInt(s[0]);
        //int rtk = Integer.parseInt(s[1]);
       	//int itg = Integer.parseInt(s[2]);

    	int[] states = new int[s.length+1];
    	
    	for (int i =0;i<s.length;i++) {
    	  	states[i+1]=Integer.parseInt(s[i]);
    	}  

    	String line2 = in.readLine();
    	int k = Integer.parseInt(line2);

    	int[][] arr = new int[states.length][k];

    	//for (int i=4; i<states.length;i++) {
    	//	arr[i]= new int[k];
    	//}

    	Protein[] proteins = new Protein[states.length];			//vetor de proteínas

		for(int i =1;i<states.length;i++) {							//completando o vetor 
			Stack<Integer> regulators=which_regulators(g,i);		//vendo os reguladores de cada proteína
			proteins[i] = new Protein(i,regulators);				//criando um objeto para cada proteína
			proteins[i].setState(states[i]);
		}

    	for (int i=1; i<states.length;i++) {
    		for (int j =0;j<k;j++) {			//estado da proteína i na iteração j
    			arr[i][j]=is_Active_now(g,proteins[i],proteins,j,states);
    		}
    	}

    	for (int i =1;i<states.length ;i++ ) {
    		System.out.println("Fator, fenótipo ou proteína " + i);
    		for (int j =0;j<k ;j++ ) {
    		System.out.println("Fator, f");	
    		}
    	}
	}
}