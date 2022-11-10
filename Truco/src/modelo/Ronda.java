package modelo;

import java.util.ArrayList;


public class Ronda{
		    private Jugador ganador;
			protected Envido envido;
			private ArrayList<Jugador> jugadores;
			private ArrayList<Carta> cartas;
			private boolean terminada=false;
		public boolean isTerminada() {
				return terminada;
			}
		public Ronda(){
			jugadores= new ArrayList<Jugador>();
			cartas= new ArrayList<Carta>();
		}
		/**no devuelve el puntaje porque se pueden seguir agregando.
		 * @param envido querido
		 */
		public IEnvido addEnvido(EstadoEnvido estado) {
			if (envido==null) {
				envido=new Envido();
				envido.addPreguntado(estado);
			}else {
				envido.addQuerido(estado);
			}
			return envido;
		}
	    public void jugar(Jugador j, Carta c){
	        cartas.add(c);
	        jugadores.add(j);
	        if (jugadores.size()==2){
	        	terminada=true;
	        }
	    }
	    /**
	     * @return jugador ganador de la ronda, en caso de parda retorna nulo
	     */
	    public Jugador getGanador() {
	    	Carta cartaMasAlta=new Carta(4,Palo.COPA);
	        int index=0;
	        for (int i=0;i< cartas.size();i++) {
	        	Carta carta=cartas.get(i);
	        	cartaMasAlta = carta.mayor(cartaMasAlta);
	        	index=cartaMasAlta==carta?i:index;
	        }
	        return (cartaMasAlta!=null)?jugadores.get(index):null;
	    }
	    /**
	     * @return jugador que ya tiro en caso que uno haya tirado y el otro no, si ambos tiraron devuelve null
	     */
	    public Jugador jugadorYaTiro(){
	    	Jugador jugador=null;
	    	if (jugadores.size()==1) {
	    		jugador=jugadores.get(0);
	    		}
	    	return jugador;
	    	}
}
